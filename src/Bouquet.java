public class Bouquet {
//attribut hålls privata
    private String name;
    private double price;

    //konstruktorn som körs när jag skapar en ny bukett
    public Bouquet(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
//publika getters
    public double getPrice() {
        return price;
    }

    public void displayBouquet() {
        System.out.println(name + "," + price + "SEK");
    }
}
