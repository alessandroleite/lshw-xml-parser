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
 * Java class for configinfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="configinfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="setting" type="{http://www.ezix.org}configentry" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "configinfo", propOrder = { "setting" })
public class Configurations implements Serializable, Iterable<Configuration> {

	/**
	 * Serial code version <code>serialVersionUID<code>
	 */
	private static final long serialVersionUID = 4611068003461223473L;

	@XmlElement(required = true)
	protected List<Configuration> setting;

	/**
	 * Gets the value of the setting property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the setting property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSetting().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Configuration }
	 * 
	 * 
	 */
	public List<Configuration> getSetting() {
		if (setting == null) {
			setting = new ArrayList<Configuration>();
		}
		return this.setting;
	}

	static final Configuration NULL_CONFIGURATION = new Configuration("", "");

	/**
	 * Returns the {@link Configuration} that has the given id.
	 * 
	 * @param id
	 *            The id of the {@link Configuration} to be returned.
	 * @return {@link #NULL_CONFIGURATION} if the configuration does not exist
	 *         or the {@link Configuration} found with the given id.
	 */
	public Configuration getConfiguration(String id) {
		int index = getSetting().indexOf(id);
		return index < 0 ? NULL_CONFIGURATION.clone() : this.getSetting().get(
				index);
	}

	/**
	 * Returns the configurations as an unmodifiable {@link Map} where the key
	 * is the {@link Configuration} id and the value is the
	 * {@link Configuration} value.
	 * 
	 * @return The configurations as an unmodifiable {@link Map} where the key
	 *         is the {@link Configuration} id and the value is the
	 *         {@link Configuration} value.
	 */
	public Map<String, String> getConfigurationsMap() {
		Map<String, String> configurations = new HashMap<>();

		for (Configuration configuration : this.getSetting()) {
			configurations.put(configuration.getId(), configuration.getValue());
		}

		return Collections.unmodifiableMap(configurations);
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
	public Iterator<Configuration> iterator() {
		return this.getSetting().iterator();
	}
}