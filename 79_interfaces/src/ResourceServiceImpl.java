public class ResourceServiceImpl implements ExtendedResourceService2 {
    private Resource3 resource;

    @Override
    public Resource3 getResource() {
        return resource;
    }

    @Override
    public void updateResource(Resource3 resource) {
        this.resource = resource;
        System.out.println("Resource updated: " + resource.getName());
    }
}