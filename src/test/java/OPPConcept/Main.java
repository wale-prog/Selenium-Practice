package OPPConcept;

public class Main extends Animal{

    public Main(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Dog bingo = new Dog("Bingo");
        System.out.println("The name of the dog is " + bingo.name);
    }


}
