
package facturas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="ObtenerEstadoDTEResult" type="{https://www.efacturadelsur.cl}EstadoGeneral"/&gt;
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
    "obtenerEstadoDTEResult"
})
@XmlRootElement(name = "ObtenerEstadoDTEResponse")
public class ObtenerEstadoDTEResponse {

    @XmlElement(name = "ObtenerEstadoDTEResult", required = true)
    @XmlSchemaType(name = "string")
    protected EstadoGeneral obtenerEstadoDTEResult;

    /**
     * Obtiene el valor de la propiedad obtenerEstadoDTEResult.
     * 
     * @return
     *     possible object is
     *     {@link EstadoGeneral }
     *     
     */
    public EstadoGeneral getObtenerEstadoDTEResult() {
        return obtenerEstadoDTEResult;
    }

    /**
     * Define el valor de la propiedad obtenerEstadoDTEResult.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoGeneral }
     *     
     */
    public void setObtenerEstadoDTEResult(EstadoGeneral value) {
        this.obtenerEstadoDTEResult = value;
    }

}
