/**
 * Copyright (c) 2013-2014 Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package lshw.parser.xml.jaxb;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@SuppressWarnings("unchecked")
public final class JaxbXmlParser<E>
{

    public static final String DEFAULT_XML_ENCODING = "UTF-8";

    private static final Logger LOG = Logger.getLogger(JaxbXmlParser.class.getName());

    protected final DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

    private Schema schema;

    private String[] contextPath;

    protected static final Map<Object, JAXBContext> JAXB_CONTEXT = new ConcurrentHashMap<Object, JAXBContext>();

    public JaxbXmlParser(URL urlSchema, Class<?>... types) throws JAXBException
    {
        this(types);
        this.setSchema(getSchema(urlSchema));
    }

    public JaxbXmlParser(Class<?>... types) throws JAXBException
    {
        if (types != null && types.length > 0)
        {
            synchronized (JAXB_CONTEXT)
            {
                this.contextPath = new String[] { types[0].getPackage().getName() };
                JaxbXmlParser.JAXB_CONTEXT.put(types[0].getPackage().getName(), JAXBContext.newInstance(types));
            }
        }
    }

    public JaxbXmlParser(URL urlSchema, String... contextPath) throws JAXBException
    {
        this(getSchema(urlSchema), contextPath);
    }

    public JaxbXmlParser(Schema schema, String... contextPath) throws JAXBException
    {
        this.contextPath = contextPath;
        this.setSchema(schema);

        if (contextPath != null && contextPath.length > 0)
        {
            StringBuilder sb = new StringBuilder(contextPath[0]);
            for (int i = 1; i < contextPath.length; i++)
            {
                sb.append(":" + contextPath[i]);
            }

            synchronized (JAXB_CONTEXT)
            {
                JaxbXmlParser.JAXB_CONTEXT.put(contextPath, JAXBContext.newInstance(sb.toString()));
            }
        }
    }

    protected void setSchema(Schema schema)
    {
        this.schema = schema;
        if (!(schema == null))
        {
            this.documentFactory.setSchema(schema);
            this.documentFactory.setValidating(Boolean.TRUE);
            documentFactory.setNamespaceAware(Boolean.TRUE);
            documentFactory.setIgnoringComments(Boolean.TRUE);
        }
    }

    public JaxbXmlParser(Schema schema)
    {
        setSchema(schema);
    }

    public static Schema getSchema(final URL url)
    {
        try
        {
            return SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(url);
        }
        catch (SAXException exception)
        {
            LOG.debug(exception.getMessage(), exception);
        }
        return null;
    }

    protected DocumentBuilderFactory getDocumentFactory()
    {
        return this.documentFactory;
    }

    protected Document getDocument(E type) throws ParserConfigurationException, JAXBException
    {

        Document document = this.getDocumentFactory().newDocumentBuilder().newDocument();
        Marshaller marshaller = JAXBContext.newInstance(type.getClass()).createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, DEFAULT_XML_ENCODING);
        marshaller.marshal(type, document);

        return document;
    }

    protected Schema getSchema()
    {
        return schema;
    }

    private String getContextPath()
    {
        StringBuilder sb = new StringBuilder(contextPath[0]);
        for (int i = 1; i < contextPath.length; i++)
        {
            sb.append(":" + contextPath[i]);
        }
        return sb.toString();
    }

    private String getContextPath(String... paths)
    {
        StringBuilder sb = new StringBuilder(paths[0]);

        for (int i = 1; i < paths.length; i++)
        {
            sb.append(":" + paths[i]);
        }
        return sb.toString();
    }

    protected synchronized JAXBContext getContext(String... contextPath) throws JAXBException
    {
        JAXBContext context;
        if ((context = JaxbXmlParser.JAXB_CONTEXT.get(contextPath)) == null)
        {
            JaxbXmlParser.JAXB_CONTEXT.put(contextPath, context = JAXBContext.newInstance(getContextPath(contextPath)));
        }
        return context;
    }

    protected synchronized JAXBContext getContext() throws JAXBException
    {
        return this.getContext(this.contextPath);
    }

    protected Marshaller createMarshaller(String packageName) throws JAXBException
    {
        final Marshaller marshaller = getContext(packageName).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, DEFAULT_XML_ENCODING);

        if (!(this.getSchema() == null))
        {
            marshaller.setSchema(getSchema());
        }

        return marshaller;
    }

    protected Marshaller createMarshaller() throws JAXBException
    {
        return createMarshaller(getContextPath());
    }

    protected Unmarshaller createUnmarshaller(String contextPath) throws JAXBException
    {

        final Unmarshaller unmarshaller = getContext(contextPath).createUnmarshaller();

        if (!(getSchema() == null))
        {
            unmarshaller.setSchema(getSchema());
        }

        return unmarshaller;
    }

    protected Unmarshaller createUnmarshaller() throws JAXBException
    {
        return this.createUnmarshaller(getContextPath());
    }

    public E unmarshal(final String xml, final String charsetName) throws JAXBException, IOException
    {
        try (ByteArrayInputStream input = new ByteArrayInputStream(
                xml.getBytes(Charset.forName((charsetName != null && charsetName.isEmpty()) ? charsetName : DEFAULT_XML_ENCODING))))
        {
            return (E) this.createUnmarshaller().unmarshal(input);
        }
    }

    public E unmarshal(final String xml) throws JAXBException, IOException
    {
        return this.unmarshal(xml, DEFAULT_XML_ENCODING);
    }

    public final String marshal(Object obj) throws JAXBException
    {

        try (StringWriter writer = new StringWriter())
        {
            createMarshaller().marshal(obj, writer);
            return writer.toString();
        }
        catch (IOException exception)
        {
            LOG.debug(exception.getMessage(), exception);
        }
        return null;
    }

    public final E unmarshal(final File file) throws JAXBException, SAXException
    {
        return (E) this.createUnmarshaller().unmarshal(file);
    }

    public final E unmarshal(final InputStream input) throws JAXBException, SAXException
    {
        return (E) this.createUnmarshaller().unmarshal(input);
    }

    public Document getXmlDocumentOf(final String xmlText) throws IOException, ParserConfigurationException, SAXException
    {
        Document document = this.getDocumentFactory().newDocumentBuilder().parse(new ByteArrayInputStream(xmlText.getBytes(DEFAULT_XML_ENCODING)));
        document.normalizeDocument();
        return document;
    }

    public Document loadFromXmlFile(File xmlFile) throws IOException, ParserConfigurationException, SAXException
    {
        Document document = this.documentFactory.newDocumentBuilder().parse(xmlFile);
        document.normalizeDocument();
        return document;
    }
}
