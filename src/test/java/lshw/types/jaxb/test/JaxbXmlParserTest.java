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
package lshw.types.jaxb.test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import lshw.parser.xml.jaxb.JaxbXmlParser;
import lshw.types.Nodes;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class JaxbXmlParserTest
{
    private String xmlText;

    private JaxbXmlParser<Nodes> parser;

    @Before
    public void setUp() throws IOException, JAXBException
    {
        StringBuilder sb = new StringBuilder();
        try (InputStream is = getDefaultClassLoader().getResourceAsStream("example-network-output.xml"))
        {
            for (Object line : IOUtils.readLines(is))
            {
                sb.append(line).append("\n");
            }
        }

        xmlText = sb.toString();
        parser = new JaxbXmlParser<>(Nodes.class);
    }

    @Test
    public void must_unmarshal_two_nodes() throws JAXBException, IOException
    {
        assert_that_xml_has_two_nodes(xmlText);
    }

    @Test
    public void must_marshal_two_nodes() throws JAXBException, IOException
    {
        Nodes nodes = assert_that_xml_has_two_nodes(xmlText);
        String nodes_xml = parser.marshal(nodes);
        assert_that_xml_has_two_nodes(nodes_xml);
    }

    Nodes assert_that_xml_has_two_nodes(String xml) throws JAXBException, IOException
    {
        Nodes nodes = parser.unmarshal(xml);
        assertNotNull(nodes);
        assertEquals(2, nodes.getNodes().size());
        return nodes;
    }

    static ClassLoader getDefaultClassLoader()
    {
        ClassLoader cl = null;
        try
        {
            cl = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable ignore)
        {
        }
        if (cl == null)
        {
            cl = JaxbXmlParserTest.class.getClassLoader();
        }
        return cl;
    }
}
