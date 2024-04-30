public class MutablePerson extends Person3 {
    private String newName;

    public MutablePerson(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return newName;
    }

    public void setName(String name) {
        newName = name;
    }
}
