public class Delivery {

    private String name;
    private double price;

    public Delivery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayBouquet() {
        System.out.println(name + "," + price + "SEK");
    }


    }


