package OPPConcept;

public class Feed extends Animal{

    public static void main(String[] args) {
        feed();
        walking("Lanre");
    }

    private static Dog dog = new Dog();
    public static void feed() {
       System.out.println(dog.feed());
    }
}
