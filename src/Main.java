import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner



        //Här har jag all kundinfo för leverans etc
        Customer customer1 = new Customer(
                "Adam Stensson",
                "adam@gmail.com",
                "Tulpanvägen 6"
        );
        Customer customer2 = new Customer(
                "Bengt Axelsson",
                "bengt@gmail.com",
                "Rosvägen 18"
        );
        Customer customer3 = new Customer(
                "Lisa Stensson",
                "lisa@gmail.com",
                "Höstvägen 1"
        );


        //Nedan har vi namnet på varorna, aka blombuketter samt pris
        Bouquet bouquet1 = new Bouquet(
                "Bunt gula tulpaner",
                100
        );

        Bouquet bouquet2 = new Bouquet(
                "Bunt röda rosor",
                 120
        );
        Bouquet bouquet3 = new Bouquet(
                "Höstbukett",
                400
        );


// här läggs info till för att skicka ordern till kund
        Delivery delivery1 = new Delivery(
        customer1.getAdress();
        );
        Delivery delivery2 = new Delivery(
                customer2.getAdress();
        );
        Delivery delivery3 = new Delivery(
                customer3.getAdress();
        );


   //Här skapas ordern
        Order order = new Order(

        );
//m
        order.displayOrder();

        order.basketPrice();

        order.changeStatus()

    }
    }
}