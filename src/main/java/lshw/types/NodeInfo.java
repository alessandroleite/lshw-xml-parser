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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * <p>
 * Java class for nodeinfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="nodeinfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="product" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vendor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="physid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serial" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="slot" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="size" type="{http://www.ezix.org}measured"/>
 *         &lt;element name="capacity" type="{http://www.ezix.org}measured"/>
 *         &lt;element name="clock" type="{http://www.ezix.org}measured"/>
 *         &lt;element name="width" type="{http://www.ezix.org}measured"/>
 *         &lt;element name="configuration" type="{http://www.ezix.org}configinfo"/>
 *         &lt;element name="capabilities" type="{http://www.ezix.org}capinfo"/>
 *         &lt;element name="resources" type="{http://www.ezix.org}resinfo"/>
 *         &lt;element name="node" type="{http://www.ezix.org}nodeinfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="handle" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="claimed" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="disabled" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nodeinfo", propOrder = { "description", "product", "vendor",
		"physId", "version", "serial", "busInfo", "slot", "size", "capacity",
		"clock", "width", "configuration", "capabilities", "resources", "node", "logicalName" })
public class NodeInfo {

	@XmlElement(required = true)
	protected String description;
	@XmlElement(required = true)
	protected String product;
	@XmlElement(required = true)
	protected String vendor;
	@XmlElement(required = true, name="physid")
	protected String physId;
	@XmlElement(required = true)
	protected String version;
	@XmlElement(required = true)
	protected String serial;
	@XmlElement(required = true, name = "businfo")
	protected String busInfo;
	@XmlElement(required = true)
	protected String slot;
	@XmlElement(required = true)
	protected Measured size;
	@XmlElement(required = true)
	protected Measured capacity;
	@XmlElement(required = true)
	protected Measured clock;
	@XmlElement(required = true)
	protected Measured width;
	@XmlElement(required = true)
	protected Configurations configuration;
	@XmlElement(required = true)
	protected Capabilities capabilities;
	@XmlElement(required = true)
	protected Resources resources;
	@XmlElement(required = true)
	protected List<NodeInfo> node;
	@XmlAttribute(name = "id")
	protected String id;
	@XmlAttribute(name = "handle")
	protected String handle;
	@XmlAttribute(name = "class")
	protected String clazz;
	@XmlAttribute(name = "claimed")
	protected Boolean claimed;
	@XmlAttribute(name = "disabled")
	protected Boolean disabled;
	@XmlAttribute(name = "logicalname")
	protected String logicalName;

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the product property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * Sets the value of the product property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProduct(String value) {
		this.product = value;
	}

	/**
	 * Gets the value of the vendor property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * Sets the value of the vendor property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVendor(String value) {
		this.vendor = value;
	}

	/**
	 * Gets the value of the physId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPhysId() {
		return physId;
	}

	/**
	 * Sets the value of the physid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPhysId(String value) {
		this.physId = value;
	}

	/**
	 * Gets the value of the version property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the value of the version property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVersion(String value) {
		this.version = value;
	}

	/**
	 * Gets the value of the serial property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * Sets the value of the serial property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSerial(String value) {
		this.serial = value;
	}

	/**
	 * Gets the value of the businfo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBusInfo() {
		return busInfo;
	}

	/**
	 * Sets the value of the businfo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBusInfo(String value) {
		this.busInfo = value;
	}

	/**
	 * Gets the value of the slot property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSlot() {
		return slot;
	}

	/**
	 * Sets the value of the slot property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSlot(String value) {
		this.slot = value;
	}

	/**
	 * Gets the value of the size property.
	 * 
	 * @return possible object is {@link Measured }
	 * 
	 */
	public Measured getSize() {
		return size;
	}

	/**
	 * Sets the value of the size property.
	 * 
	 * @param value
	 *            allowed object is {@link Measured }
	 * 
	 */
	public void setSize(Measured value) {
		this.size = value;
	}

	/**
	 * Gets the value of the capacity property.
	 * 
	 * @return possible object is {@link Measured }
	 * 
	 */
	public Measured getCapacity() {
		return capacity;
	}

	/**
	 * Sets the value of the capacity property.
	 * 
	 * @param value
	 *            allowed object is {@link Measured }
	 * 
	 */
	public void setCapacity(Measured value) {
		this.capacity = value;
	}

	/**
	 * Gets the value of the clock property.
	 * 
	 * @return possible object is {@link Measured }
	 * 
	 */
	public Measured getClock() {
		return clock;
	}

	/**
	 * Sets the value of the clock property.
	 * 
	 * @param value
	 *            allowed object is {@link Measured }
	 * 
	 */
	public void setClock(Measured value) {
		this.clock = value;
	}

	/**
	 * Gets the value of the width property.
	 * 
	 * @return possible object is {@link Measured }
	 * 
	 */
	public Measured getWidth() {
		return width;
	}

	/**
	 * Sets the value of the width property.
	 * 
	 * @param value
	 *            allowed object is {@link Measured }
	 * 
	 */
	public void setWidth(Measured value) {
		this.width = value;
	}

	/**
	 * Gets the value of the configuration property.
	 * 
	 * @return possible object is {@link Configurations }
	 * 
	 */
	public Configurations getConfiguration() {
		return configuration;
	}

	/**
	 * Sets the value of the configuration property.
	 * 
	 * @param value
	 *            allowed object is {@link Configurations }
	 * 
	 */
	public void setConfiguration(Configurations value) {
		this.configuration = value;
	}

	/**
	 * Gets the value of the capabilities property.
	 * 
	 * @return possible object is {@link Capabilities }
	 * 
	 */
	public Capabilities getCapabilities() {
		return capabilities;
	}

	/**
	 * Sets the value of the capabilities property.
	 * 
	 * @param value
	 *            allowed object is {@link Capabilities }
	 * 
	 */
	public void setCapabilities(Capabilities value) {
		this.capabilities = value;
	}

	/**
	 * Gets the value of the resources property.
	 * 
	 * @return possible object is {@link Resources }
	 * 
	 */
	public Resources getResources() {
		return resources;
	}

	/**
	 * Sets the value of the resources property.
	 * 
	 * @param value
	 *            allowed object is {@link Resources }
	 * 
	 */
	public void setResources(Resources value) {
		this.resources = value;
	}

	/**
	 * Gets the value of the node property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the node property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getNode().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link NodeInfo }
	 * 
	 * 
	 */
	public List<NodeInfo> getNode() {
		if (node == null) {
			node = new ArrayList<NodeInfo>();
		}
		return this.node;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the handle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHandle() {
		return handle;
	}

	/**
	 * Sets the value of the handle property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHandle(String value) {
		this.handle = value;
	}

	/**
	 * Gets the value of the clazz property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getClazz() {
		return clazz;
	}

	/**
	 * Sets the value of the clazz property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setClazz(String value) {
		this.clazz = value;
	}

	/**
	 * Gets the value of the claimed property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isClaimed() {
		return claimed;
	}

	/**
	 * Sets the value of the claimed property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setClaimed(Boolean value) {
		this.claimed = value;
	}

	/**
	 * Gets the value of the disabled property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isDisabled() {
		return disabled;
	}

	/**
	 * Sets the value of the disabled property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setDisabled(Boolean value) {
		this.disabled = value;
	}
	

	/**
	 * @return the logicalName
	 */
	public String getLogicalName() {
		return logicalName;
	}

	/**
	 * @param logicalName the logicalName to set
	 */
	public void setLogicalName(String logicalName) {
		this.logicalName = logicalName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}