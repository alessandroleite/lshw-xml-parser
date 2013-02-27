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
package lshw.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@XmlRootElement(name = "list")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Nodes implements Iterable<NodeInfo>, Serializable {

	/**
	 * Serial code version <code>serialVersionUID<code>
	 */
	private static final long serialVersionUID = 4147681342953174255L;

	@XmlElement(name = "node")
	private List<NodeInfo> nodes = new ArrayList<>();

	public Nodes() {
	}

	public Nodes(List<NodeInfo> nodes) {
		this.nodes.addAll(nodes);
	}

	public Nodes(NodeInfo... nodeinfos) {
		this(Arrays.asList(nodeinfos));
	}

	/**
	 * @return the nodes
	 */
	public List<NodeInfo> getNodes() {
		return nodes == null ? nodes = new ArrayList<>() : nodes;
	}

	/**
	 * @param nodes
	 *            the nodes to set
	 */
	public void setNodes(List<NodeInfo> nodes) {
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<NodeInfo> iterator() {
		return this.getNodes().iterator();
	}
}