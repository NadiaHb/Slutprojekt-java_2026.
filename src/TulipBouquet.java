public class TulipBouquet extends Bouquet {

    public TulipBouquet() {
        super("Bunt gula tulpaner", 100);
    }
    //overrides the method in the superclass
    @Override
    public void displayBouquet() {
        System.out.println(getName() + ":");
    }
    //overrides the description in superclass
    @Override
    public String getDescription() {
        return "Gula tulpaner som passar perfekt i glasvasen";

    }
}









