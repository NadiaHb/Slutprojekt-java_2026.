public class Customer {

    //constructor recieves these three values when new object is created
    private String name;
    private String mail;
    private String adress;
//constructor
    public Customer(String name, String mail, String adress) {
        this.name = name;
        this.mail = mail;
        this.adress = adress;
    }
//metthods
    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

   //getters to read customer info, setters to change adress
    public String getAdress() { return adress;}

    public void setAdress(String newAdress) {
        this.adress = newAdress;
    }
}
