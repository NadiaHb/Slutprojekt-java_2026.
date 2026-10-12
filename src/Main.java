import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
//using scanner to log what user types in consol
        Scanner scanner = new Scanner(System.in);
        ArrayList<Order> orders = new ArrayList<>(); //arr för flera ordrar.
        boolean running = true;

        int nextOrderId= 1;
        //while program is running, menuchoices are visible
        //while-loop is running as long as boolean value is true
        while (running){
            System.out.println("Välkommen till Nadias blomsterbutik!");
            System.out.println("1.Skapa order");
            System.out.println("2. Visa order");
            System.out.println("3. Ändra leverans");
            System.out.println("4. Avbryt beställning");
            System.out.println("5. Avsluta program");


            //All menuchoices and methods
            int menuChoice;
//Try catch for integers, ska inta ha exceptions e då det är ett generellt catch(missat!)
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




        //The names and prices of the items

        System.out.println("Vänligen välj önskad bukett");
        System.out.println("1. Bunt gula tulpaner, 100kr SEK");
        System.out.println("2. Bunt röda rosor, 120kr SEK");
        System.out.println("3. Höstbukett, 400kr SEK");
        System.out.println("Du har valt: ");


        int bouquetChoice;

        try {
            bouquetChoice = scanner.nextInt();
        }catch (Exception e) {
            System.out.println("Vänligen ange godkänd siffra.");
            scanner.nextLine();
            break;
        }
        scanner.nextLine();

                    Bouquet bouquet;

                    if (bouquetChoice == 1) {
                        bouquet = new Bouquet("Bunt gula tulpaner", 100);
                    } else if (bouquetChoice == 2) {
                        bouquet = new Bouquet("Bunt röda rosor", 120);
                    } else if (bouquetChoice == 3) {
                        bouquet = new Bouquet("Höstbukett", 400);
                    } else {
                        System.out.println("Ogiltligt val");
                        break;
                    }


//Delivery menucoice, standard and express
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
        // info is added to send order to customer
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

            //order is created as well as an order summary
            Order newOrder = new Order (nextOrderId, customer, delivery, bouquet);
           orders.add(newOrder);

           //multiple orders availble, following order gets orderId 2,3,4 etc
           nextOrderId++;

           System.out.println("-----Ordersammanfattning------");
           System.out.println("Mottagare: " + customer.getName());
           System.out.println("OrderId: " + newOrder.getOrderId());
           System.out.println("E-post: " + customer.getMail());
            System.out.println("Leveransadress: " + customer.getAdress());
            System.out.println("Vald bukett: " + bouquet.getName());
            System.out.println("Bukett kostnad: " + bouquet.getPrice() + " kr");
            System.out.println("Leveransmetod: " + delivery.getType());
            System.out.println("Leveranskostnad: " + delivery.getDeliveryFee() + " kr");
            System.out.println("Totalpris: " + (bouquet.getPrice() + delivery.getDeliveryFee()) + " kr");
                    System.out.println("-------------------------");
            System.out.println("Tack för din beställning!");
            break;

          //menu choice to display order, orderId is needed
            case 2:

                if (orders.isEmpty()) { //if there's no order
                    System.out.println("Ingen beställning hittad");
                } else {
                    System.out.println("Ange orderId");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();
                    for (Order currentOrder : orders) {
                        currentOrder.displayOrder();
                    }
                    if (orderId > 0 && orderId <= orders.size()) {
                        Order selectedOrder = orders.get(orderId - 1);

                        } else {
                        System.out.println("Ogiltligt orderId");
                    }
                    }
                break;

            case 3: //menuchoice to chage delivery adress, must have orderId to proceed

                if (orders.isEmpty()) {
                    System.out.println("Ingen beställning hittad");
                } else {
                    System.out.println("Ange order ID");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();

                    if (orderId > 0 && orderId <= orders.size()) {
                        Order selectedOrder = orders.get(orderId - 1);


                } else {
                        System.out.println("Ingen beställning hittad"); //
                        System.out.println("Ange orderId");
                        scanner.nextLine();
                    }

                if (orderId > 0 && orderId <= orders.size()) {
                    Order selectedOrder = orders.get(orderId - 1);

                    System.out.println("Ändra leverans");
                    System.out.println("Angiven adress: " + selectedOrder.getCustomer().getAdress());
                    System.out.println("Fyll i ny leveransadress: ");
                    String newAdress = scanner.nextLine();
                    selectedOrder.getCustomer().setAdress(newAdress);
                    System.out.println("Ny adress: " + selectedOrder.getCustomer().getAdress());
                    System.out.println("Adressändring komplett");
                }else {
                    System.out.println("Ogiltligt orderId");
                }
                }
                 break;

                          //menuchoice to cancel order, must have orderId to proceed
                case 4:
                    if (orders.isEmpty()) {
                        System.out.println();
                        System.out.println("Ingen beställning hittad");
                    } else {
                        System.out.println("Ange orderId");
                        int orderId = scanner.nextInt();
                        scanner.nextLine();

                        if (orderId > 0 && orderId <= orders.size()) {
                            orders.remove(orderId - 1);
                            System.out.println("Beställning avbruten");
                        } else {
                            System.out.println("Ogiltligt orderId");
                        }
                    }
                    break;
                   //menuchoice to exit
                case 5:
                    running = false;
                    System.out.println("Tack för besöket, välkommen åter!");
                    break;
                default:
                    System.out.println("Välj ett menyalternativ(1-5)");
        }
    }
        scanner.close();
}


        }


