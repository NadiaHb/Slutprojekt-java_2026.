public class Customer {
//konstruktorn tar emot dessa tre värden när kundobjkt skapas
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
//getters för att läsa kunduppg, setters för att ändra adress
    public String getAdress() { return adress;}

    public void setAdress(String newAdress) {
        this.adress = newAdress;
    }
}
