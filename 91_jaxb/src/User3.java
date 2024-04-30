import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

@XmlRootElement
public class User3 {
    private String name;
    private BufferedImage image;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlJavaTypeAdapter(value = ImageCacheAdapter.class)
    @XmlAttribute
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public User3(String name, BufferedImage image) {
        this.name = name;
        this.image = image;
    }

    public User3() {
        this("", null);
    }

    public static void main(String[] args) {
        // Example usage
        try {
            BufferedImage img = ImageIO.read(new File("example.png"));
            User3 user = new User3("John Doe", img);

            // Marshalling to XML
            javax.xml.bind.JAXBContext jaxbContext = javax.xml.bind.JAXBContext.newInstance(User3.class);
            javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(user, System.out);

            // Unmarshalling from XML
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<user name=\"Jane Doe\" image=\"iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAACXBIWXMAAAsTAAALEwEAmpwYAAAB0klEQVQ4y2NgGAWjYBSMglEwK0oDGZk8X8tLQLEwT8/vyDMczmJkZGb///Gz8DCQxkDEZiQq7AT8IEEzEz/DzMDxkBQ3AcDKCAd9NrgcGJwYWPsP//H4PZGBsbExYDgA00FlaWmB8QVFxeADG9gYGBgAAUz8RQYABOwMOzv7EExABBgYYGBmDA0P9//8/T3BsAB1ODkBdQjNRgZGDk5m5CQnJYAVxAEDSgQBGaQAK0NLgBjgDD4zYOAGIQxsJAwOJIZANi2UAasSfQkMjAwA/MU2QQAGJGMDgwMECFMD/DBQEKJiAMDIyMB4kioKAA6lA7EgCJSBmBYf+HkC9BZLJKS0AWAFcWFDAwMRisJOnf4AABDgB8JA8CDpGJ6AdD5gb6fPz7w9XbwOHDgAhQBk4DLGDKY+QcAY4Eg/xMA7w4GAGBbMGDAAkSA0/k4fOhc5INg5A3H//fpxWBAQAGQYnExIgZAABzIaCnp1KakAAAAASUVORK5CYII=\"/>";
            javax.xml.bind.Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            User3 unmarshalledUser = (User3) unmarshaller.unmarshal(new ByteArrayInputStream(xml.getBytes()));
            System.out.println(unmarshalledUser.getName());
            ImageIO.write(unmarshalledUser.image, "png", new File("example_unmarshalled.png"));

        } catch (javax.xml.bind.JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

}
