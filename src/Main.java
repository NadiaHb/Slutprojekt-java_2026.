import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {

    public static void main(String[] args) {
//using scanner to log what user types in consol
        Scanner scanner = new Scanner(System.in);
        ArrayList<Order> orders = new ArrayList<>(); //arraylist for multiple orders.
        ArrayList<Bouquet> bouquets = new ArrayList<>(); //Arraylist for different bouquets
        bouquets.add(new TulipBouquet());
        bouquets.add(new RoseBouquet());
        bouquets.add(new AutumnBouquet());

        boolean running = true; //menu loop

        int nextOrderId = 1; //Order id counter


        //while program is running, menuchoices are visible
        //while-loop is running as long as boolean value is true
        while (running) {
            System.out.println("Välkommen till Nadias blomsterbutik!");
            System.out.println("1.Skapa order");
            System.out.println("2. Visa order");
            System.out.println("3. Ändra leverans");
            System.out.println("4. Avbryt beställning");
            System.out.println("5. Avsluta program");


            //All menuchoices and methods
            int menuChoice;
//Try catch for integers
            try {
                menuChoice = scanner.nextInt();
            } catch (InputMismatchException e) { //catch for invalid input when user enter is not a number
                System.out.println("Du måste ange en siffra.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            //checking if the menu choice is within valid range
            if (menuChoice < 1 || menuChoice > 5) {
                System.out.println("Ogiltligt val, ange ett val mellan 1-5.");
                //Displays error message if menuchoice is invalid
                continue;
            }

            switch (menuChoice) {
                case 1:
                    System.out.println();
                    System.out.println("Skapa din order");

                    String name = "";
                    while (true) { //while loops and if statements to prevent empty input.
                        System.out.println("Vänligen ange ditt för- och efternamn: ");
                        name = scanner.nextLine();

                        if (!name.isBlank() && name.chars().allMatch(c -> Character.isLetter(c) || c == ' ')) {
                            break;
                        }
                        System.out.println("Vänligen ange för-och efternamn. Fältet får ej lämnas tomt");
                    }

                    String adress = "";
                    while (adress.isBlank()) {
                        System.out.println("Vänligen ange din leveransadress");
                        adress = scanner.nextLine();

                        if (adress.isBlank()) {
                            System.out.println("vönligen ange din leveransadress. Fältet får ej lämnas tomt.");
                        }
                    }

                    String mail = "";
                    while (mail.isBlank()) {
                        System.out.println("Vänligen ange e-post för orderbekräftelse.");
                        mail = scanner.nextLine();

                        if (mail.isBlank()) {
                            System.out.println("Vänligen ange e-post. Fältet får ej lämnas tomt.");
                        }
                    }

                    Customer customer = new Customer(name, mail, adress);


                    //The names and prices of the items

                    System.out.println("Vänligen välj önskad bukett");
                    System.out.println("1. Bunt gula tulpaner, 100kr SEK");
                    System.out.println("2. Bunt röda rosor, 120kr SEK");
                    System.out.println("3. Höstbukett, 400kr SEK");
                    System.out.println("Du har valt: ");


                    int bouquetChoice = 0;
                    boolean validBouquet = false;
                    //Repeat while user inputs invalid choice until user inputs valid choice
                    while (!validBouquet) {
                        //Displays availble bouquet options
                        for (Bouquet bouquet : bouquets) {
                            bouquet.displayBouquet();
                            System.out.println(bouquet.getDescription());
                        }
                        //Ask user to choose bouquet
                        System.out.println("Välj bukett genom att välja val 1-3");
                        try {
                            bouquetChoice = scanner.nextInt();//Check user's choise

                            //Checking for valid bouquet choice
                            if (bouquetChoice < 1 || bouquetChoice > 3) {
                                throw new IllegalArgumentException("Ogiltligt val");
                            }
                            validBouquet = true;
                        } catch (InputMismatchException e) {
                            //catch for invalid input whe user enter something that's not a number
                            System.out.println("Vänligen ange en godkänd siffra");
                            scanner.nextLine();

                        } catch (IllegalArgumentException e) {
                            //catch for invalid bouquet choice
                            System.out.println(e.getMessage());
                        }
                    }
                    scanner.nextLine();
                    Bouquet bouquet;
                    //if else for the selected bouquet
                    if (bouquetChoice == 1) {
                        bouquet = new TulipBouquet();
                    } else if (bouquetChoice == 2) {
                        bouquet = new RoseBouquet();
                    } else if (bouquetChoice == 3) {
                        bouquet = new AutumnBouquet();
                    } else {
                        System.out.println("Ogiltligt val");
                        break;
                    }
//Delivery menu choice display
                    System.out.println();
                    System.out.println("Leveransmetor: ");
                    System.out.println("Välj 1 för Standardleverans: 5-7 arbetsdagar, 59kr SEK");
                    System.out.println("Välj 2 för Expressleverans: 1-3 arbetsdagar, 99kr SEK");
                    System.out.println("Du har valt: ");

                    int deliveryChoice = 0;
                    boolean validDelivery = false;
                    //Repeat until user enters valid delivery choice
                    while (!validDelivery) {

                        try { //Reading user inout and checking if it's within the allowed range
                            deliveryChoice = scanner.nextInt();
                            //Cheching for valid delivery choice
                            if (deliveryChoice < 1 || deliveryChoice > 2) {
                                throw new IllegalArgumentException("Ogiltligt val");
                            }
                            validDelivery = true;
                            //Catch for invalid input when user enters something besides a number
                        } catch (InputMismatchException e) {
                            System.out.println("Ogiltigt val. Vänligen ange giltligt nummer");
                            scanner.nextLine();

                        } catch (IllegalArgumentException e) { // catch for invalid delivery choice
                            System.out.println(e.getMessage());
                        }
                    }
                    // info is added to send order to customer
                    scanner.nextLine();

                    Delivery delivery;

                    if (deliveryChoice == 1) {
                        delivery = new Delivery("Standardleverans", 59
                        );
                    } else if (deliveryChoice == 2) {
                        delivery = new Delivery("Expressleverans", 99
                        );
                    } else {
                        System.out.println("Ogiltligt val");
                        break;
                    }

                    //order is created as well as an order summary
                    Order newOrder = new Order(nextOrderId, customer, delivery, bouquet);
                    orders.add(newOrder);
                    //polymorphic arraylist using the deliveryInfo interface
                    ArrayList<DeliveryInfo> deliveryInfos = new ArrayList<>();
                    deliveryInfos.add(delivery);//adding delivery and order objects to the list
                    deliveryInfos.add(newOrder);

                    //for loop through the list, displaying delivery information
                    for (DeliveryInfo info : deliveryInfos) {
                        info.showDeliveryInfo();
                    }

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
                {
                    System.out.println("Vänligen ange order-Id");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();
                    // loop through the order arraylist to find order that matches the entered orderID
                    Order selectedOrder = null;

                    for (Order order : orders) {
                        if (order.getOrderId() == orderId) {
                            selectedOrder = order;
                            break;
                        }
                    }
                    if (selectedOrder != null) { //Displau the order if found
                        selectedOrder.displayOrder();
                    } else { //otherwise this error message displays
                        System.out.println("Ogiltligt order-Id");
                    }
                    break;
                }

                case 3: //menu choice to change delivery adress, must have orderId to proceed

                    if (orders.isEmpty()) { //if there's no order
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
                        } else {
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
                //menu choice to exit
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





