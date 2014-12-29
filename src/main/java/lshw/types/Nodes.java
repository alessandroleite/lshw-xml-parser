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
public class Nodes implements Iterable<NodeInfo>, Serializable
{

    /**
     * Serial code version <code>serialVersionUID<code>
     */
    private static final long serialVersionUID = 4147681342953174255L;

    @XmlElement(name = "node")
    private List<NodeInfo> nodes = new ArrayList<>();

    public Nodes()
    {
    }

    public Nodes(List<NodeInfo> nodes)
    {
        this.nodes.addAll(nodes);
    }

    public Nodes(NodeInfo... nodeinfos)
    {
        this(Arrays.asList(nodeinfos));
    }

    /**
     * @return the nodes
     */
    public List<NodeInfo> getNodes()
    {
        return nodes == null ? nodes = new ArrayList<>() : nodes;
    }

    /**
     * @param nodes
     *            the nodes to set
     */
    public void setNodes(List<NodeInfo> nodes)
    {
        this.nodes = nodes;
    }

    /**
     * Return the {@link NodeInfo} that has a given id.
     * 
     * @param hardwareId
     *            The if of the {@link NodeInfo} to be returned.
     * @return <code>null</code> if the {@link Node} does not exist or the {@link NodeInfo} that has the given id.
     */
    public NodeInfo findNodeByHardwareId(String hardwareId)
    {
        int index = this.getNodes().indexOf(NodeInfo.valueOf(hardwareId));
        return index < 0 ? null : this.getNodes().get(index);
    }

    /**
     * Returns the first {@link NodeInfo} or <code>null</code> if the list is empty.
     * 
     * @return the first {@link NodeInfo} or <code>null</code> if the list is empty.
     */
    public NodeInfo first()
    {
        return this.getNodes().isEmpty() ? null : this.getNodes().get(0);
    }

    /**
     * Returns the last {@link NodeInfo} or <code>null</code> if the list is empty.
     * 
     * @return the last {@link NodeInfo} or <code>null</code> if the list is empty.
     */
    public NodeInfo last()
    {
        int size = this.getNodes().size();
        return size > 0 ? this.getNodes().get(size - 1) : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<NodeInfo> iterator()
    {
        return this.getNodes().iterator();
    }
}
