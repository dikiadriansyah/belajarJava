public class Using_xmladapter_to_trim_string {
    // Using XmlAdapter to trim string/Menggunakan XmlAdapter untuk memangkas string

    /*
     * package com.example.xml.adapters;
     * import javax.xml.bind.annotation.adapters.XmlAdapter;
     * public class StringTrimAdapter extends XmlAdapter<String, String> {
     * 
     * @Override
     * public String unmarshal(String v) throws Exception {
     * if (v == null)
     * return null;
     * return v.trim();
     * }
     * 
     * @Override
     * public String marshal(String v) throws Exception {
     * if (v == null)
     * return null;
     * return v.trim();
     * }
     * }
     */

    // Dan di package-info.java tambahkan deklarasi berikut.

    /*
     * @XmlJavaTypeAdapter(value = com.example.xml.adapters.StringTrimAdapter.class,
     * type = String.class)
     * package com.example.xml.jaxb.bindings;// Packge where you intend to apply
     * trimming filter
     * import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
     */

    public static void main(String[] args) {
        StringTrimAdapter adapter = new StringTrimAdapter();

        // Test unmarshal method
        String unmarshalTest = "   Test String   ";
        String unmarshaledString = null;
        try {
            unmarshaledString = adapter.unmarshal(unmarshalTest);
        } catch (Exception e) {
            System.err.println("Error during unmarshaling: " + e.getMessage());
        }
        System.out.println("Unmarshaled string: \"" + unmarshaledString + "\"");

        // Test marshal method
        String marshalTest = "   Test String   ";
        String marshaledString = null;
        try {
            marshaledString = adapter.marshal(marshalTest);
        } catch (Exception e) {
            System.err.println("Error during marshaling: " + e.getMessage());
        }
        System.out.println("Marshaled string: \"" + marshaledString + "\"");
    }

}
