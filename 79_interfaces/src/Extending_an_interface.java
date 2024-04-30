public class Extending_an_interface {
    // Extending an interface/Memperluas antarmuka

    /*
     * Sebuah antarmuka dapat memperluas antarmuka lain melalui kata kunci extends.
     */

    /*
     * public interface BasicResourceService {
     * Resource getResource();
     * }
     * public interface ExtendedResourceService extends BasicResourceService {
     * void updateResource(Resource resource);
     * }
     */

    /*
     * Sekarang kelas yang mengimplementasikan ExtendedResourceService perlu
     * mengimplementasikan getResource() dan updateResource().
     */

    // Extending multiple interfaces/Memperluas beberapa antarmuka

    /*
     * Berbeda dengan kelas, kata kunci extends dapat digunakan untuk memperluas
     * beberapa antarmuka (Dipisahkan dengan koma) memungkinkan kombinasi antarmuka
     * menjadi antarmuka baru
     */

    /*
     * public interface BasicResourceService {
     * Resource getResource();
     * }
     * public interface AlternateResourceService {
     * Resource getAlternateResource();
     * }
     * public interface ExtendedResourceService extends BasicResourceService,
     * AlternateResourceService {
     * Resource updateResource(Resource resource);
     * }
     */

    /*
     * Dalam hal ini kelas yang mengimplementasikan ExtendedResourceService perlu
     * mengimplementasikan getResource(),
     * getAlternateResource(), dan updateResource().
     */

    public static void main(String[] args) {
        ResourceServiceImpl resourceService = new ResourceServiceImpl();

        // Mendapatkan resource
        Resource3 currentResource = resourceService.getResource();
        if (currentResource != null) {
            System.out.println("Current Resource: " + currentResource.getName());
        } else {
            System.out.println("Resource is null");
        }

        // Memperbarui resource
        Resource3 newResource = new Resource3("Updated Resource");
        resourceService.updateResource(newResource);

        // Mendapatkan resource setelah diperbarui
        currentResource = resourceService.getResource();
        if (currentResource != null) {
            System.out.println("Updated Resource: " + currentResource.getName());
        } else {
            System.out.println("Resource is null");
        }
        /*
         * output:
         * Resource is null
         * Resource updated: Updated Resource
         * Updated Resource: Updated Resource
         */

    }
}
