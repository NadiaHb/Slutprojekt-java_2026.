public class Bouquet {
//attributes are kept private
    private String name;
    private double price;


    //constructor that runs when a new bouquet is created, contain name and price
    public Bouquet(String name, double price) {
        this.name = name;
        this.price = price;
    }
//Jag ska göra en superklass med klasshierari av bouquet, missat..!
    public String getName() {
        return name;
    }
//public getters
    public double getPrice() {
        return price;
    }

    public void displayBouquet() {
        System.out.println(name + "," + price + "SEK");
    }

    public String getDescription() {
        return "En fin blomnukett";
    }
}


