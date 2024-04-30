public class Automatic_field_property_xml_mapping_configuration {
    // Automatic field/property XML mapping configuration
    // (@XmlAccessorType)/Konfigurasi pemetaan XML bidang/properti otomatis
    // (@XmlAccessorType)

    /*
     * Anotasi @XmlAccessorType menentukan apakah bidang/properti akan secara
     * otomatis diserialkan ke XML. Catatan,
     * anotasi bidang dan metode @XmlElement, @XmlAttribute, atau @XmlTransient
     * lebih diutamakan daripada pengaturan default.
     */

    /*
     * public class XmlAccessTypeExample {
     * 
     * @XmlAccessorType(XmlAccessType.FIELD)
     * static class AccessorExampleField {
     * public String field="value1";
     * 
     * public String getGetter() {
     * return "getter";
     * }
     * 
     * public void setGetter(String value) {}
     * }
     * 
     * @XmlAccessorType(XmlAccessType.NONE)
     * static class AccessorExampleNone {
     * public String field="value1";
     * 
     * public String getGetter() {
     * return "getter";
     * }
     * 
     * public void setGetter(String value) {}
     * }
     * 
     * @XmlAccessorType(XmlAccessType.PROPERTY)
     * static class AccessorExampleProperty {
     * public String field="value1";
     * 
     * public String getGetter() {
     * return "getter";
     * }
     * 
     * public void setGetter(String value) {}
     * }
     * 
     * @XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
     * static class AccessorExamplePublic {
     * public String field="value1";
     * 
     * public String getGetter() {
     * return "getter";
     * }
     * 
     * public void setGetter(String value) {}
     * }
     * public static void main(String[] args) {
     * try {
     * System.out.println("\nField:");
     * JAXB.marshal(new AccessorExampleField(), System.out);
     * System.out.println("\nNone:");
     * JAXB.marshal(new AccessorExampleNone(), System.out);
     * System.out.println("\nProperty:");
     * JAXB.marshal(new AccessorExampleProperty(), System.out);
     * System.out.println("\nPublic:");
     * JAXB.marshal(new AccessorExamplePublic(), System.out);
     * } catch (Exception e) {
     * System.err.println("Exception occurred while writing in XML!");
     * }
     * }
     * } // outer class end
     */

    /*
     * Output
     * Field:
     * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
     * value1
     * None:
     * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
     * Property:
     * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
     * getter
     * Public:
     * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
     * value1
     * getter
     */

    public static void main(String[] args) {
        XmlAccessTypeExample box = new XmlAccessTypeExample();
    }
}
