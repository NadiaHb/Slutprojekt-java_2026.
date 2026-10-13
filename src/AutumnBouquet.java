public class AutumnBouquet extends Bouquet{

    public AutumnBouquet() {
        super("Höstbukett", 400);
    }
    //overrides the method in the superclass
    @Override
    public void displayBouquet() {
        System.out.println(getName() + ":");
    }
    //overrides the description in superclass
    @Override
    public String getDescription() {
    return "Färgglad höstbuett som livar upp i mörkret";

    }
}
