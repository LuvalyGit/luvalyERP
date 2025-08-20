
package facturas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PonerDTE2Result" type="{https://www.efacturadelsur.cl}ArrayOfString" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ponerDTE2Result"
})
@XmlRootElement(name = "PonerDTE2Response")
public class PonerDTE2Response {

    @XmlElement(name = "PonerDTE2Result")
    protected ArrayOfString ponerDTE2Result;

    /**
     * Obtiene el valor de la propiedad ponerDTE2Result.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getPonerDTE2Result() {
        return ponerDTE2Result;
    }

    /**
     * Define el valor de la propiedad ponerDTE2Result.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setPonerDTE2Result(ArrayOfString value) {
        this.ponerDTE2Result = value;
    }

}
