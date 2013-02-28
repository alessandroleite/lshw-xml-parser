/**
 * Copyright (c) 2013 Alessandro
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
package lshw.parser.xml;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import lshw.parser.exception.LshwParserException;
import lshw.parser.xml.jaxb.JaxbXmlParser;
import lshw.types.NodeInfo;
import lshw.types.Nodes;

public class Lshw {

	private static final String START_TAG = "<list>";

	/**
	 * Parser a given XML and return the informations as list of
	 * {@link NodeInfo}.
	 * 
	 * @param xml
	 *            The XML to be parsed
	 * @return The {@link Nodes} info
	 * @throws IllegalArgumentException
	 *             Throw if the XML is <code>null</code> or <em>empty</em>.
	 * @throws LshwParserException
	 *             Throw if is impossible to parser the XML.
	 */
	public static Nodes unmarshall(final String xml) {

		if (xml == null || xml.trim().isEmpty()) {
			throw new IllegalArgumentException("Xml must not be null or empty.");
		}

		String xmlToParser = xml;

		if (xmlToParser.indexOf(START_TAG) == -1) {
			xmlToParser = String.format("<list>\n%s\n</list>", xml.trim());
		}

		try {
			return new JaxbXmlParser<Nodes>(Nodes.class).unmarshal(xmlToParser);
		} catch (JAXBException | IOException e) {
			throw new LshwParserException(e.getMessage(), e);
		}
	}

	/**
	 * Generate a XML of a given {@link Nodes} instance.
	 * 
	 * @param nodes
	 *            The instance to be serialized to XML format.
	 * @return The XML representation of the instance.
	 * @throws LshwParserException
	 *             Throw if is impossible to generate the XML of the
	 *             {@link Nodes}.
	 */
	public static String marshall(Nodes nodes) {
		try {
			return new JaxbXmlParser<Nodes>(Nodes.class).marshall(nodes);
		} catch (JAXBException exception) {
			throw new LshwParserException(exception.getMessage(), exception);
		}
	}

	/**
	 * Generate a XML using the given nodes. The nodes are put together in the
	 * XML.
	 * 
	 * @param nodeinfos
	 *            The nodes to be include in the XML output.
	 * @return The XML representation of the {@link NodeInfo}
	 * @see #marshall(Nodes)
	 */
	public static String marshall(NodeInfo... nodeinfos) {
		if (nodeinfos != null && nodeinfos.length > 0) {
			return marshall(new Nodes(nodeinfos));
		}
		return null;
	}
}