import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Order order = null;
        boolean running = true;

        while (running){
            System.out.println("Välkommen till Nadias blomsterbutik!");
            System.out.println("1.Skapa order");
            System.out.println("2. Visa varukorgen");
            System.out.println("3. Ändra leverans");
            System.out.println("4. Avbryt beställning");


            //Alla menyval och metoder för dem
            int menuChoice;

            try {
                menuChoice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Du måste ange en siffra.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            switch (menuChoice) {
                case 1:
                    System.out.println();
                    System.out.println("Skapa din order");

                    System.out.println("Vänligen ange ditt för- och efternamn: ");
                    String name = scanner.nextLine();

                    System.out.println("Vänligen ange leveransadress: ");
                    String adress = scanner.nextLine();

                    System.out.println("Vänligen ange e-post för orderbekräftelse :");
                    String mail = scanner.nextLine();

                    Customer customer = new Customer(name, mail, adress);

            }


        //Nedan har vi namnet på varorna, aka blombuketter samt pris

        System.out.println("Vänligen välj önskad bukett");
        System.out.println("1. Bunt gula tulpaner, 100kr SEK");
        System.out.println("2. Bunt röda rosor, 120kr SEK");
        System.out.println("3. Höstbukett, 400kr SEK");
        System.out.println("Du har valt: ");
        int bouquetChoice = scanner.nextInt();

        Bouquet selectedBouquet;
        if (bouquetChoice == 1) {
            selectedBouquet = new Bouquet("Bunt gula tulpaner", 100);
        } else if (bouquetChoice == 2) {
            selectedBouquet = new Bouquet("Bunt röda rosor", 120);
        }else {
            selectedBouquet = new Bouquet("Höstbukett", 400);
        }

//Delivery menyval, standard och express
            System.out.println();
            System.out.println("Leveransmetor: ");
            System.out.println("Välj 1 för Standardleverans: 5-7 arbetsdagar, 59kr SEK");
            System.out.println("Välj 2 för Expressleverans: 1-3 arbetsdagar, 99kr SEK");
            System.out.println("Du har valt: ");

        int deliveryChoice;
        try {
            deliveryChoice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ogiltigt val. Vänligen ange giltligt nummer");
            scanner.nextLine();
            break;
        }
            // här läggs info till för att skicka ordern till kund
        scanner.nextLine();

        Delivery delivery;

           if (deliveryChoice == 1){
               delivery = new Delivery("Standardleverans", 59
               );
               } else if (deliveryChoice == 2){
                   delivery=new Delivery("Expressleverans", 99
                   );
               } else {
                   System.out.println("Ogiltligt val");
                   break;
               }

            //Här skapas ordern
            order = new Order(
           customer,
           bouquet,
           delivery
            );
            System.out.println();
            System.out.println("Tack för din beställning!");
            break;


            case 2:

                if (order == null) {
                    System.out.println("Ingen beställning hittad");
                } else {
                    order.displayOrder();
                }
                break;

            case 3:

        }
    }
}






        }


