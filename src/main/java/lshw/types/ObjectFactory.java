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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lshw.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Node_QNAME = new QName("http://www.ezix.org", "node");
    
    private final static QName _List_QNAME = new QName("http://www.ezix.org", "list");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lshw.types
     * 
     */
    public ObjectFactory() {
    }
    
    /**
     * Create an instance of {@link Nodes }
     * 
     */
    public Nodes createNodes() {
        return new Nodes();
    }

    /**
     * Create an instance of {@link Nodeinfo }
     * 
     */
    public Nodeinfo createNodeinfo() {
        return new Nodeinfo();
    }

    /**
     * Create an instance of {@link Configinfo }
     * 
     */
    public Configinfo createConfiginfo() {
        return new Configinfo();
    }

    /**
     * Create an instance of {@link Capentry }
     * 
     */
    public Capentry createCapentry() {
        return new Capentry();
    }

    /**
     * Create an instance of {@link Capinfo }
     * 
     */
    public Capinfo createCapinfo() {
        return new Capinfo();
    }

    /**
     * Create an instance of {@link Measured }
     * 
     */
    public Measured createMeasured() {
        return new Measured();
    }

    /**
     * Create an instance of {@link Resinfo }
     * 
     */
    public Resinfo createResinfo() {
        return new Resinfo();
    }

    /**
     * Create an instance of {@link Configentry }
     * 
     */
    public Configentry createConfigentry() {
        return new Configentry();
    }

    /**
     * Create an instance of {@link Resentry }
     * 
     */
    public Resentry createResentry() {
        return new Resentry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Nodeinfo }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.ezix.org", name = "node")
    public JAXBElement<Nodeinfo> createNode(Nodeinfo value) {
        return new JAXBElement<Nodeinfo>(_Node_QNAME, Nodeinfo.class, null, value);
    }
    
    @XmlElementDecl(namespace = "http://www.ezix.org", name = "list")
    public JAXBElement<Nodes> createList(Nodes value) {
        return new JAXBElement<Nodes>(_List_QNAME, Nodes.class, null, value);
    }
}