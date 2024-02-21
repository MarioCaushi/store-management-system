# Store-management-system
This is a Grocery Store Management System developed as the final project for CEN 215 OOP Course.
This system is built to ease the organizational and analytical everyday work of a store/supermarket, allowing two levels of autherization: 1.Manager 2.Cashier
The system is implemented using base principles of Object-oriented-Programming (OOP) with Java as the programming language, and the graphical-user interface (GUI) is built using JavaFX

## Features
* #### Two Levels of authorization
This system conatins two levels of authorization, each with its own level of management. 
Managers can edit anything in the system, from customers to cashiers, to product inventory and point of sales, they cannot edit other managers but they can delete them from the system.
Cashiers have limited access to editing personal information of themselves and other cashiers and managers. A cashier has got access to product inventory and POS for a certain customer. 

There are multiple notifications throught the program with every action so the user has got all the neccessary information as to how to use and manage the system


* #### Login Page
When you first run the program it opens up to a Login Page that welcomes the user to the system and requests for username and password of the user.
If the user enters a correct username and password the program then checks to recognize if the credentials entered are those of a Manager or a Cashier.

* #### Register Page
This program does not have a default admin implemented in the code so in order to access the system the user is required to register as a cashier or a manager and fill out the given fields.

* #### Home Page
When the user first logs in a Welcome Cashier/Manager message appears and then the user can see and edit its own personal information. 
Cashiers have got limited access to the editing priviliges. 

* #### Management Page
A manager can edit, add and remove cashiers and customers and only view and delete other managers.
A cashier can only view other cashiers and managers but it can add,remove, edit and add to POS other customers. 

* #### Inventory Page
Both Cashiers and Managers can view,edit, add and remove products from the inventory.

* #### Sales Report Page 
Managers and Cashiers can view a daily,weekly,monthly and yearly report of items sold and the profit made from those. 

* #### Loyalty Program Page - Manager Only
Managers have access to the loytlty program of the system. They can set certains conditions that determine the amount of discount customers have depending opn thr amount of items and loyalty points they have bought and earned.

* #### Point of Sale Page - Cashier Only
POS is a Cashier reserved function. After selecting a customer from management cashiers can add them to POS. There cashiers can view inventory and select items and the amount desired to sell to each customer's items bought list. After the cashier is done selecting, then when proceeding to selling it displays a message of the price with or without discount depending on the customer.

* #### Database 
This program is not built using any type of database software.
In this system binary files are used to load,store and arrange the data, so it must be relatively slower than a DBMS but it is efficient.
As a future improvement maybe database support can be added. 

## Requirements
* Java JDK

* JavaFX (to download: https://gluonhq.com/products/javafx/)

* Eclipse or Intellij IDE(any other compatible IDE)


## Images(brief view of the program)

* Client View
<img width="891" alt="CashierHome" src="https://github.com/MarioCaushi/store-management-system/assets/144184446/fffc8244-d394-4bc4-92fe-40ec9f79a17e">

* Manager View
<img width="892" alt="ManagerHome" src="https://github.com/MarioCaushi/store-management-system/assets/144184446/90460738-333d-42bd-9980-52756ec2d93b">


***For more pics check out the images folder***
