public class Customer {

    private String name;
    private String mail;
    private String adress;

    public Customer(String name, String mail, String adress) {
        this.name = name;
        this.mail = mail;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getAdress() {
        return null;
    }

    public void setAdress(String newAdress) {
    }
}
