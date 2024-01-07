package OPPConcept;

public class Dog extends Animal {

    private String name = "Bingo";
    private String breed = "German Shepherd";


    private String bark() {
        return (name + " barks");
    }
    public String feed () {
        return "When " + bark() + "the " + breed + " is hungry";
    }
}
