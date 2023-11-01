/*
Create an SQL script that has the insert statements necessary to populate your database
with the provided data (see additional info below for the data). Note: This will get a little
tedious to insert all the data in the correct tables. I tried to find a way to automate it or
make it easier, but there’s not a way without knowing your specific database design. Copy
and Paste will be your friend. Name this file “PopulateData.sql”
*/


/*
Inserting into toppings table
*/
INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Pepperoni", 1.25, 0.20, 100, 50, 2, 2.75, 3.5, 4.5); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Sausage", 1.25, 0.15, 100, 50, 2.5, 3, 3.5, 4.25); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Ham", 1.5, 0.15, 78, 25, 2, 2.5, 3.25, 4);

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Chicken", 1.75, 0.25, 56, 25, 1.5, 2, 2.25, 3); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Green Pepper", 0.5, 0.02, 79, 25, 1, 1.5, 2, 2.5); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Onion", 0.5, 0.02, 85, 25, 1, 1.5, 2, 2.75); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Roma Tomato", 0.75, 0.03, 86, 10, 2, 3, 3.5, 4.5); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Mushrooms", 0.75, 0.1, 52, 50, 1.5, 2, 2.5, 3); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Black Olives", 0.6, 0.1, 39, 25, 0.75, 1, 1.5, 2); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Pineapple", 1, 0.25, 15, 0, 1, 1.25, 1.75, 2); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Jalapenos", 0.5, 0.05, 64, 0, 0.5, 0.75, 1.25, 1.75); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Banana Peppers", 0.5, 0.05, 36, 0, 0.6, 1, 1.3, 1.75);

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Regular Cheese", 0.5, 0.12, 250, 50, 2, 3.5, 5, 7); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Four Cheese Blend", 1, 0.15, 150, 25, 2, 3.5, 5, 7); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Feta Cheese", 1.5, 0.18, 75, 0, 1.75, 3, 4, 5.5); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Goat Cheese", 1.5, 0.2, 54, 0, 1.6, 2.75, 4, 5.5); 

INSERT INTO TOPPINGS (Topping_Name, Topping_Price_Per_Unit, Topping_Cost_Per_Unit, Current_Inventory,
Min_Inventory, Units_Small, Units_Medium, Units_Large, Units_XLarge)
VALUES ("Bacon", 1.5, 0.25, 89, 0, 1, 1.5, 2, 3); 



/*
Inserting into discounts table
*/

INSERT INTO DISCOUNTS (Discount_Name, Percent_Off)
VALUES ("Employee", 0.15);

INSERT INTO DISCOUNTS (Discount_Name, Dollar_Amt_Off)
VALUES ("Lunch Special Medium", 1.00);

INSERT INTO DISCOUNTS (Discount_Name, Dollar_Amt_Off)
VALUES ("Lunch Special Large", 2.00);

INSERT INTO DISCOUNTS (Discount_Name, Dollar_Amt_Off)
VALUES ("Specialty Pizza", 1.50);

INSERT INTO DISCOUNTS (Discount_Name, Percent_Off)
VALUES ("Happy Hour", 0.10);

INSERT INTO DISCOUNTS (Discount_Name, Percent_Off)
VALUES ("Gameday Special", 0.20);


/*
Inserting into base prices table
*/

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("Small", "Thin", 3, 0.5);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("Small", "Original", 3, 0.75);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("Small", "Pan", 3.5, 1);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("Small", "Gluten-Free", 4, 2);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("Medium", "Thin", 5, 1);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("Medium", "Original", 5, 1.5);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("Medium", "Pan", 6, 2.25);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("Medium", "Gluten-Free", 6.25, 3);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("Large", "Thin", 8, 1.25);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("Large", "Original", 8, 2);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("Large", "Pan", 9, 3);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("Large", "Gluten-Free", 9.5, 4);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("XLarge", "Thin", 10, 2);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("XLarge", "Original", 10, 3);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("XLarge", "Pan", 11.5, 4.5);

INSERT INTO BASEPRICE (Pizza_Size, Crust_Type, Base_Price, Base_Cost)
VALUES ("XLarge", "Gluten-Free", 12.5, 6);