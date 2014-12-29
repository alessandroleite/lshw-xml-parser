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
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * <p>
 * Java class for measured complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="measured">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
 *       &lt;attribute name="units" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measured", propOrder = { "value" })
public class Measured implements Serializable, Cloneable
{

    /**
     * Serial code version <code>serialVersionUID<code>
     */
    private static final long serialVersionUID = 3570818139072544994L;

    @XmlValue
    protected BigDecimal value;
    @XmlAttribute(name = "units")
    protected String units;

    public Measured()
    {
        super();
    }

    public Measured(BigDecimal value)
    {
        this.value = value;
    }

    public Measured(BigDecimal value, String units)
    {
        this(value);
        this.units = units;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return possible object is {@link BigDecimal }
     * 
     */
    public BigDecimal getValue()
    {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setValue(BigDecimal value)
    {
        this.value = value;
    }

    /**
     * Gets the value of the units property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getUnits()
    {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setUnits(String value)
    {
        this.units = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Measured clone()
    {
        return new Measured(this.getValue(), this.getUnits());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
