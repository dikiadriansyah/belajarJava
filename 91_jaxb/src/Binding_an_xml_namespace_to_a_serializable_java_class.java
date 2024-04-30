
public class Binding_an_xml_namespace_to_a_serializable_java_class {
    // Binding an XML namespace to a serializable Java class/Mengikat namespace XML
    // ke kelas Java yang dapat diserialkan

    /*
     * Ini adalah contoh file package-info.java yang mengikat namespace XML ke kelas
     * Java yang dapat diserialkan. Ini harus ditempatkan dalam paket yang sama
     * dengan kelas Java yang harus diserialkan menggunakan namespace.
     */

    /**
     * A package containing serializable classes.
     */

    /*
     * @XmlSchema
     * (
     * xmlns =
     * {
     * 
     * @XmlNs(prefix = MySerializableClass.NAMESPACE_PREFIX, namespaceURI =
     * MySerializableClass.NAMESPACE)
     * },
     * namespace = MySerializableClass.NAMESPACE,
     * elementFormDefault = XmlNsForm.QUALIFIED
     * )
     * package com.test.jaxb;
     * import javax.xml.bind.annotation.XmlNs;
     * import javax.xml.bind.annotation.XmlNsForm;
     * import javax.xml.bind.annotation.XmlSchema;
     * 
     */

}
