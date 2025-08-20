
package facturas;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EstadoGeneral.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EstadoGeneral"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NoExiste"/&gt;
 *     &lt;enumeration value="Anulado"/&gt;
 *     &lt;enumeration value="Reenviar"/&gt;
 *     &lt;enumeration value="Manual"/&gt;
 *     &lt;enumeration value="SiiNoEnviado"/&gt;
 *     &lt;enumeration value="SiiEnviado"/&gt;
 *     &lt;enumeration value="SiiProceso"/&gt;
 *     &lt;enumeration value="SiiAceptado"/&gt;
 *     &lt;enumeration value="SiiReparo"/&gt;
 *     &lt;enumeration value="SiiRechazado"/&gt;
 *     &lt;enumeration value="ReceptorEnviado"/&gt;
 *     &lt;enumeration value="ReceptorRecibidoOk"/&gt;
 *     &lt;enumeration value="ReceptorErrorFirma"/&gt;
 *     &lt;enumeration value="ReceptorErrorRutEmisor"/&gt;
 *     &lt;enumeration value="ReceptorErrorRutReceptor"/&gt;
 *     &lt;enumeration value="ReceptorRepetido"/&gt;
 *     &lt;enumeration value="ReceptorOtro"/&gt;
 *     &lt;enumeration value="ReceptorAceptadoOk"/&gt;
 *     &lt;enumeration value="ReceptorDiscrepancia"/&gt;
 *     &lt;enumeration value="ReceptorRechazado"/&gt;
 *     &lt;enumeration value="ReceptorAcuseRecibo"/&gt;
 *     &lt;enumeration value="SiiAceptadoDocumento"/&gt;
 *     &lt;enumeration value="SiiContado"/&gt;
 *     &lt;enumeration value="SiiReclamado"/&gt;
 *     &lt;enumeration value="SiiAcuseRecibo"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EstadoGeneral")
@XmlEnum
public enum EstadoGeneral {

    @XmlEnumValue("NoExiste")
    NO_EXISTE("NoExiste"),
    @XmlEnumValue("Anulado")
    ANULADO("Anulado"),
    @XmlEnumValue("Reenviar")
    REENVIAR("Reenviar"),
    @XmlEnumValue("Manual")
    MANUAL("Manual"),
    @XmlEnumValue("SiiNoEnviado")
    SII_NO_ENVIADO("SiiNoEnviado"),
    @XmlEnumValue("SiiEnviado")
    SII_ENVIADO("SiiEnviado"),
    @XmlEnumValue("SiiProceso")
    SII_PROCESO("SiiProceso"),
    @XmlEnumValue("SiiAceptado")
    SII_ACEPTADO("SiiAceptado"),
    @XmlEnumValue("SiiReparo")
    SII_REPARO("SiiReparo"),
    @XmlEnumValue("SiiRechazado")
    SII_RECHAZADO("SiiRechazado"),
    @XmlEnumValue("ReceptorEnviado")
    RECEPTOR_ENVIADO("ReceptorEnviado"),
    @XmlEnumValue("ReceptorRecibidoOk")
    RECEPTOR_RECIBIDO_OK("ReceptorRecibidoOk"),
    @XmlEnumValue("ReceptorErrorFirma")
    RECEPTOR_ERROR_FIRMA("ReceptorErrorFirma"),
    @XmlEnumValue("ReceptorErrorRutEmisor")
    RECEPTOR_ERROR_RUT_EMISOR("ReceptorErrorRutEmisor"),
    @XmlEnumValue("ReceptorErrorRutReceptor")
    RECEPTOR_ERROR_RUT_RECEPTOR("ReceptorErrorRutReceptor"),
    @XmlEnumValue("ReceptorRepetido")
    RECEPTOR_REPETIDO("ReceptorRepetido"),
    @XmlEnumValue("ReceptorOtro")
    RECEPTOR_OTRO("ReceptorOtro"),
    @XmlEnumValue("ReceptorAceptadoOk")
    RECEPTOR_ACEPTADO_OK("ReceptorAceptadoOk"),
    @XmlEnumValue("ReceptorDiscrepancia")
    RECEPTOR_DISCREPANCIA("ReceptorDiscrepancia"),
    @XmlEnumValue("ReceptorRechazado")
    RECEPTOR_RECHAZADO("ReceptorRechazado"),
    @XmlEnumValue("ReceptorAcuseRecibo")
    RECEPTOR_ACUSE_RECIBO("ReceptorAcuseRecibo"),
    @XmlEnumValue("SiiAceptadoDocumento")
    SII_ACEPTADO_DOCUMENTO("SiiAceptadoDocumento"),
    @XmlEnumValue("SiiContado")
    SII_CONTADO("SiiContado"),
    @XmlEnumValue("SiiReclamado")
    SII_RECLAMADO("SiiReclamado"),
    @XmlEnumValue("SiiAcuseRecibo")
    SII_ACUSE_RECIBO("SiiAcuseRecibo");
    private final String value;

    EstadoGeneral(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadoGeneral fromValue(String v) {
        for (EstadoGeneral c: EstadoGeneral.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
