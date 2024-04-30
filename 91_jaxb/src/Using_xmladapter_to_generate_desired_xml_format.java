import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class Using_xmladapter_to_generate_desired_xml_format {
    // Using XmlAdapter to generate desired xml format/Menggunakan XmlAdapter untuk
    // menghasilkan format xml yang diinginkan

    /*
     * Ketika format XML yang diinginkan berbeda dari model objek Java, implementasi
     * XmlAdapter dapat digunakan untuk mentransformasikannya
     * objek model menjadi objek berformat xml dan sebaliknya. Contoh ini
     * menunjukkan cara memasukkan nilai bidang ke dalam atribut elemen dengan nama
     * bidang.
     * 
     * public class XmlAdapterExample {
     * 
     * @XmlAccessorType(XmlAccessType.FIELD)
     * public static class NodeValueElement {
     * 
     * @XmlAttribute(name="attrValue")
     * String value;
     * 
     * public NodeValueElement() {
     * }
     * 
     * public NodeValueElement(String value) {
     * super();
     * this.value = value;
     * }
     * 
     * public String getValue() {
     * return value;
     * }
     * 
     * public void setValue(String value) {
     * this.value = value;
     * }
     * }
     * public static class ValueAsAttrXmlAdapter extends
     * XmlAdapter<NodeValueElement, String> {
     * 
     * @Override
     * public NodeValueElement marshal(String v) throws Exception {
     * return new NodeValueElement(v);
     * }
     * 
     * @Override
     * public String unmarshal(NodeValueElement v) throws Exception {
     * if (v==null) return "";
     * return v.getValue();
     * }
     * }
     * 
     * @XmlRootElement(name="DataObject")
     * 
     * @XmlAccessorType(XmlAccessType.FIELD)
     * public static class DataObject {
     * 
     * String elementWithValue;
     * 
     * @XmlJavaTypeAdapter(value=ValueAsAttrXmlAdapter.class)
     * String elementWithAttribute;
     * }
     * public static void main(String[] args) {
     * DataObject data = new DataObject();
     * data.elementWithValue="value1";
     * data.elementWithAttribute ="value2";
     * 
     * ByteArrayOutputStream baos = new ByteArrayOutputStream();
     * JAXB.marshal(data, baos);
     * String xmlString = new String(baos.toByteArray(), StandardCharsets.UTF_8);
     * 
     * System.out.println(xmlString);
     * }
     * }
     * 
     */

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class NodeValueElement {

        @XmlAttribute(name = "attrValue")
        String value;

        public NodeValueElement() {
        }

        public NodeValueElement(String value) {
            super();
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class ValueAsAttrXmlAdapter extends XmlAdapter<NodeValueElement, String> {
        @Override
        public NodeValueElement marshal(String v) throws Exception {
            return new NodeValueElement(v);
        }

        @Override
        public String unmarshal(NodeValueElement v) throws Exception {
            if (v == null)
                return "";
            return v.getValue();
        }
    }

    @XmlRootElement(name = "DataObject")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class DataObject {

        String elementWithValue;
        @XmlJavaTypeAdapter(value = ValueAsAttrXmlAdapter.class)
        String elementWithAttribute;
    }

    public static void main(String[] args) {
        DataObject data = new DataObject();
        data.elementWithValue = "value1";
        data.elementWithAttribute = "value2";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JAXB.marshal(data, baos);
        String xmlString = new String(baos.toByteArray(), StandardCharsets.UTF_8);

        System.out.println(xmlString);
    }
}
