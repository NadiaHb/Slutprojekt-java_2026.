Nadia Hörberg

Flowershop Project description: Console-based online flowershop. The user can see and order avaiable products and get it shipped for home delivery.

Superclass Name: Bouquet

Common fields: name, price

Common methods: 
displayBouquet()
getDescription()

Subclasses: 
TulipBouquet - extends Bouquet and overrides dislayBouquet() and getDescription()
RoseBouquet - extends Bouquet and overrides dislayBouquet() and getDescription()
AutumnBouquet - extends Bouquet and overrides dislayBouquet() and getDescription()

Interface name: DeliveryInfo
-Method: showDeliveryInfo()
-Implemented by: Delivery, Order

Menu:
1. Create order
2. View an existing order
3. Change delivery adress
4. Cancel an order
5. Exit program

Error handling:
Entering letters instead of numbers
Selecting an invalid delivery method
Selecting an invalid bouquet
Entering an invalid menu choice
Trying to show or cancel a non existing order

The program is structured using object-oriented programming to make the code easy to understand and develop.
Bouquet, the superclass, contains common information and methods shared by the different bouquets. The three subclasses inherit from it and override methods to provide their own description and information. This method demonstrated inheritance and polymorphism.

The interface DeliveryInfo is implemented by Order class and Delivery class to allow classes to display information regarding delivery.

I used ArrayLists to store the bouquet options as well as the orders, making it easy to add, display or remove objects.

The menu is built using a loop and a switch so that the user can choose different actions without restarting the program. Input validation and exception handling are used to ensure that the program does not crash when user enters invalid input.

An alternative could have been to put all functionality in one large class but using separate classes makes the program and code more organized and easier to work on if you would like to adjust or add anything.

