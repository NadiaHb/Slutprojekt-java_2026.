public class Delivery {

    private String type;
    private double deliveryFee;

    public Delivery(String type, double deliveryFee){
        this.type =type;
        this.deliveryFee = deliveryFee;
    }

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
}
