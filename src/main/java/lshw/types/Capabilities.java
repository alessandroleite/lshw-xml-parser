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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * <p>
 * Java class for capinfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="capinfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capability" type="{http://www.ezix.org}capentry" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "capinfo", propOrder = { "capabilities" })
public class Capabilities implements Serializable, Iterable<Capability>, Cloneable {

	/**
	 * Serial code version <code>serialVersionUID<code>
	 */
	private static final long serialVersionUID = 2623565505511049386L;

	@XmlElement(required = true, name = "capability")
	protected List<Capability> capabilities;

	/**
	 * Gets the value of the capability property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the capability property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCapability().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Capability }
	 * 
	 * 
	 */
	public List<Capability> getCapabilities() {
		if (capabilities == null) {
			capabilities = new ArrayList<Capability>();
		}
		return this.capabilities;
	}
	
	/**
	 * Add a new {@link Capability}.
	 * 
	 * @param capability
	 *            The {@link Capability} to be added.
	 */
	public void add(Capability capability) {
		if (capability != null) {
			this.getCapabilities().add(capability);
		}
	}

	/**
	 * Returns the capabilities as an unmodifiable {@link Map} where the key is
	 * the capability id and the value is the capability value.
	 * 
	 * @return the capabilities as an unmodifiable {@link Map} where the key is
	 *         the capability id and the value is the capability value.
	 */
	public Map<String, String> getCapabilitiesMap() {
		Map<String, String> capabilities = new HashMap<>();

		for (Capability capability : this.getCapabilities()) {
			capabilities.put(capability.getId(), capability.getValue());
		}
		return Collections.unmodifiableMap(capabilities);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Capabilities clone() {
		Capabilities capabilities = new Capabilities();
		
		for(Capability capability: this.getCapabilities()) {
			capabilities.getCapabilities().add(capability.clone());
		}
		return capabilities;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<Capability> iterator() {
		return this.getCapabilities().iterator();
	}
}