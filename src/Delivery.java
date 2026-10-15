public class Delivery implements DeliveryInfo{

    private String type;
    private double deliveryFee;
//constructor
    public Delivery(String type, double deliveryFee){
        this.type =type;
        this.deliveryFee = deliveryFee;
    }
//Getters and setters methods to find and change information connected to the delivery
    public String getType(){
        return type;
    }
    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }
    //Display deliveryfee and type of delivery
    @Override
    public void showDeliveryInfo() {
        System.out.println("Leveranstyp: " + type);
        System.out.println("Leveranskostnad: " + deliveryFee + "kr");
    }
}
