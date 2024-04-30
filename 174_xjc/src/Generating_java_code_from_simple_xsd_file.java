public class Generating_java_code_from_simple_xsd_file {
    // Generating Java code from simple XSD file/Menghasilkan kode Java dari file
    // XSD sederhana

    // XSD schema (schema.xsd)

    /*
     * Skema xml berikut (xsd) mendefinisikan daftar pengguna dengan nama atribut
     * dan reputasi
     * 
     * 
     * <?xml version="1.0"?>
     * <xs:schema version="1.0"
     * xmlns:xs="http://www.w3.org/2001/XMLSchema"
     * xmlns:ns="http://www.stackoverflow.com/users"
     * elementFormDefault="qualified"
     * targetNamespace="http://www.stackoverflow.com/users">
     * <xs:element name="users" type="ns:Users"/>
     * 
     * <xs:complexType name="Users">
     * <xs:sequence>
     * <xs:element type="ns:User" name="user" minOccurs="0" maxOccurs="unbounded"/>
     * </xs:sequence>
     * </xs:complexType>
     * 
     * <xs:complexType name="User">
     * <xs:attribute name="name" use="required" type="xs:string"/>
     * <xs:attribute name="reputation" use="required">
     * <xs:simpleType>
     * <xs:restriction base="xs:int">
     * <xs:minInclusive value="1"/>
     * </xs:restriction>
     * </xs:simpleType>
     * </xs:attribute>
     * </xs:complexType>
     * </xs:schema>
     * 
     */

    // gunakan xjc
    /*
     * Ini memerlukan jalur ke alat xjc (biner JDK) berada dalam variabel jalur OS.
     * Pembuatan kode dapat dimulai menggunakan
     * xjc schema.xsd
     * 
     * Ini akan menghasilkan file java di direktori kerja.
     */

    /*
     * File hasil
     * Akan ada beberapa komentar tambahan, namun pada dasarnya file java yang
     * dihasilkan terlihat seperti ini:
     * 
     * package com.stackoverflow.users;
     * import java.util.ArrayList;
     * import java.util.List;
     * import javax.xml.bind.annotation.XmlAccessType;
     * import javax.xml.bind.annotation.XmlAccessorType;
     * import javax.xml.bind.annotation.XmlType;
     * 
     * @XmlAccessorType(XmlAccessType.FIELD)
     * 
     * @XmlType(name = "Users", propOrder = {
     * "user"
     * })
     * public class Users {
     * protected List<User> user;
     * public List<User> getUser() {
     * if (user == null) {
     * user = new ArrayList<User>();
     * }
     * return this.user;
     * }
     * }
     * package com.stackoverflow.users;
     * import javax.xml.bind.annotation.XmlAccessType;
     * import javax.xml.bind.annotation.XmlAccessorType;
     * import javax.xml.bind.annotation.XmlAttribute;
     * import javax.xml.bind.annotation.XmlType;
     * 
     * @XmlAccessorType(XmlAccessType.FIELD)
     * 
     * @XmlType(name = "User")
     * public class User {
     * 
     * @XmlAttribute(name = "name", required = true)
     * protected String name;
     * 
     * @XmlAttribute(name = "reputation", required = true)
     * protected int reputation;
     * public String getName() {
     * return name;
     * }
     * public void setName(String value) {
     * this.name = value;
     * }
     * public int getReputation() {
     * return reputation;
     * }
     * public void setReputation(int value) {
     * this.reputation = value;
     * }
     * }
     * package com.stackoverflow.users;
     * import javax.xml.bind.JAXBElement;
     * import javax.xml.bind.annotation.XmlElementDecl;
     * import javax.xml.bind.annotation.XmlRegistry;
     * import javax.xml.namespace.QName;
     * 
     * @XmlRegistry
     * public class ObjectFactory {
     * private final static QName _Users_QNAME = new
     * QName("http://www.stackoverflow.com/users",
     * "users");
     * public ObjectFactory() {
     * }
     * public Users createUsers() {
     * return new Users();
     * }
     * public User createUser() {
     * return new User();
     * }
     * 
     * @XmlElementDecl(namespace = "http://www.stackoverflow.com/users", name =
     * "users")
     * public JAXBElement<Users> createUsers(Users value) {
     * return new JAXBElement<Users>(_Users_QNAME, Users.class, null, value);
     * }
     * }
     * package-info.java
     * 
     * @javax.xml.bind.annotation.XmlSchema(namespace =
     * "http://www.stackoverflow.com/users",
     * elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)
     * package com.stackoverflow.users;
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
