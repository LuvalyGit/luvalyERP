
package facturas;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EstadoDte.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EstadoDte"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Anulado"/&gt;
 *     &lt;enumeration value="NoEnviado"/&gt;
 *     &lt;enumeration value="Enviado"/&gt;
 *     &lt;enumeration value="Proceso"/&gt;
 *     &lt;enumeration value="Aceptado"/&gt;
 *     &lt;enumeration value="Reparo"/&gt;
 *     &lt;enumeration value="Rechazado"/&gt;
 *     &lt;enumeration value="Reenviar"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EstadoDte")
@XmlEnum
public enum EstadoDte {

    @XmlEnumValue("Anulado")
    ANULADO("Anulado"),
    @XmlEnumValue("NoEnviado")
    NO_ENVIADO("NoEnviado"),
    @XmlEnumValue("Enviado")
    ENVIADO("Enviado"),
    @XmlEnumValue("Proceso")
    PROCESO("Proceso"),
    @XmlEnumValue("Aceptado")
    ACEPTADO("Aceptado"),
    @XmlEnumValue("Reparo")
    REPARO("Reparo"),
    @XmlEnumValue("Rechazado")
    RECHAZADO("Rechazado"),
    @XmlEnumValue("Reenviar")
    REENVIAR("Reenviar");
    private final String value;

    EstadoDte(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadoDte fromValue(String v) {
        for (EstadoDte c: EstadoDte.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
