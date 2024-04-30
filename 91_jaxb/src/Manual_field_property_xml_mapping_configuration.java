import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD) // we want no automatic field/property marshalling

public class Manual_field_property_xml_mapping_configuration {

    /*
     * Manual field/property XML mapping configuration / Konfigurasi pemetaan XML
     * bidang/properti manual
     */

    /*
     * Anotasi @XmlElement, @XmlAttribute atau @XmlTransient dan lainnya dalam paket
     * javax.xml.bind.annotation izinkan pemrogram menentukan bidang atau properti
     * mana dan bagaimana yang harus diberi serial.
     */

    /*
     * @XmlAccessorType(XmlAccessType.NONE) // we want no automatic field/property
     * marshalling
     * public class ManualXmlElementsExample {
     * 
     * @XmlElement
     * private String field="field value";
     * 
     * @XmlAttribute
     * private String attribute="attr value";
     * 
     * @XmlAttribute(name="differentAttribute")
     * private String oneAttribute="other attr value";
     * 
     * @XmlElement(name="different name")
     * private String oneName="different name value";
     * 
     * @XmlTransient
     * private String transientField = "will not get serialized ever";
     * 
     * 
     * @XmlElement
     * public String getModifiedTransientValue() {
     * return transientField.replace(" ever", ", unless in a getter");
     * }
     * 
     * public void setModifiedTransientValue(String val) {} // empty on purpose
     * public static void main(String[] args) {
     * try {
     * JAXB.marshal(new ManualXmlElementsExample(), System.out);
     * } catch (Exception e) {
     * System.err.println("Exception occurred while writing in XML!");
     * }
     * }
     * }
     */

    @XmlElement
    private String field = "field value";
    @XmlAttribute
    private String attribute = "attr value";

    @XmlAttribute(name = "differentAttribute")
    private String oneAttribute = "other attr value";

    @XmlElement(name = "different name")
    private String oneName = "different name value";

    @XmlTransient
    private String transientField = "will not get serialized ever";

    @XmlElement
    public String getModifiedTransientValue() {
        return transientField.replace(" ever", ", unless in a getter");
    }

    public void setModifiedTransientValue(String val) {
    } // empty on purpose

    public static void main(String[] args) {
        try {
            JAXB.marshal(new Manual_field_property_xml_mapping_configuration(), System.out);
        } catch (Exception e) {
            System.err.println("Exception occurred while writing in XML!");
        }
    }

}
