public class Order {

    private int orderId;
    private Customer customer;
    private Delivery delivery;
    private Bouquet bouquet;

    public Order(int orderId, Customer customer, Delivery delivery, Bouquet bouquet) {
        this.orderId = orderId;
        this.customer = customer;
        this.delivery = delivery;
        this.bouquet = bouquet;
    }

    public double totalPrice() {
        return bouquet.getPrice() + delivery.getPrice();
    }

    public void displayOrder() {

        System.out.println();
        System.out.println("Varukorg");
        System.out.println("Kunduppgifter; " + customer.getName());
        System.out.println("Mail: " + customer.getMail());
        System.out.println("Adress: " + customer.getAdress());
        System.out.println("Val av bukett: " + bouquet.getName() + bouquet.getPrice() + " SEK");
        System.out.println("Leveransinfo: " + delivery.getType());
        System.out.println("Leveranskostnad: " + delivery.getDeliveryFee());
        System.out.println("Total kostnad för din beställning är: " + totalPrice() + "SEK");
        System.out.println();
    }

    public Customer getCustomer() {
        return customer;
    }
    public Bouquet getBouquet() {
        return bouquet;
    }
    public Delivery getDelivery() {
        return  delivery;
    }
}
