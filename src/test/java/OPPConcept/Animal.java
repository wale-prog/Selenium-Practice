package OPPConcept;

public abstract class Animal {

    public String name;

    public Animal(String name) {
        this.name = name;
    }
    public void speaks() {}

    public static void walking(String name) {
        System.out.println(name + " is walking");
    }
}
