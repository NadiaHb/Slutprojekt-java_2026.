public class RoseBouquet extends Bouquet {

    //constructor
    public RoseBouquet() {
        super("Bunt röda rosor", 120);
    }
    //overrides the method in the superclass
    @Override
    public void displayBouquet() {
        System.out.println(getName() + ":");
    }
    //overrides the description in superclass
    @Override
    public  String getDescription() {
        return "Röda rosor till flickbän, mamma, eller varför inte dig själv?";
    }

}
