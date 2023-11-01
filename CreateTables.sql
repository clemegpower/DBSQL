/*
Create an SQL script that has the create statements necessary to build the tables for
your database. Remember to include any constraints that you need for the database.
Run the SQL script in MySQL to create your database. This script should include SQL to
create the database schema. Name this file “CreateTables.sql”
*/

CREATE TABLE BASEPRICE (
    Pizza_Size varchar(3),
    Crust_Type varchar(10),
    Base_Cost float,
    Base_Price float,
    PRIMARY KEY (Crust_Type, Pizza_Size)
);

CREATE TABLE TOPPINGS (
    Topping_ID int PRIMARY KEY,
    Topping_Name varchar(20),
    Topping_Cust_Price float,
    Topping_Buss_Price float,
    Min_Inventory int CHECK(Min_Inventory >=50),
    Current_Inventory int
);

CREATE TABLE CUSTOMER (
    Cust_ID int PRIMARY KEY,
    Cust_FName varchar(20), 
    Cust_LName varchar(20),
    Cust_Phone int, 
    Cust_Street varchar(50),
    Cust_City varchar(30),
    Cust_State varchar(5),
    Cust_Zipcode int
);

CREATE TABLE DISCOUNTS (
    Discount_ID int PRIMARY KEY,
    Discount_Name varchar(20), 
    Dollar_Amt_Off float,
    Percent_Off float CHECK (Percent_Off <= 1 AND Percent_Off >= 0),
    Type_Discount varchar(10)
);

CREATE TABLE ORDERS (
    Order_ID int PRIMARY KEY,
    Order_Type varchar(10),
    Order_Total float,
    Time_Ordered date
);

CREATE TABLE DINE_IN (
    Order_ID int PRIMARY KEY,
    Table_Num int,
    FOREIGN KEY (Order_ID) REFERENCES ORDERS(Order_ID)
);

CREATE TABLE DELIVERY (
    Order_ID int PRIMARY KEY,
    Cust_ID int,
    FOREIGN KEY (Order_ID) REFERENCES ORDERS(Order_ID),
    FOREIGN KEY (Cust_ID) REFERENCES CUSTOMER(Cust_ID)
);

CREATE TABLE PICKUP (
    Order_ID int PRIMARY KEY,
    Cust_ID int,
    FOREIGN KEY (Order_ID) REFERENCES ORDERS(Order_ID),
    FOREIGN KEY (Cust_ID) REFERENCES CUSTOMER(Cust_ID)
);

CREATE TABLE PIZZA (
    Pizza_ID int PRIMARY KEY,
    Crust_Type varchar(20),
    Pizza_Size varchar(3),
    Pizza_State varchar(10), 
    Base_Cost float,
    Order_ID int,
    Base_Price float
    FOREIGN KEY (Order_ID) REFERENCES ORDERS(Order_ID)
    FOREIGN KEY (Crust_Type, Pizza_Size) REFERENCES BASEPRICE(Crust_Type, Pizza_Size)
);

CREATE TABLE PIZZATOPPINGS (
    Pizza_ID int PRIMARY KEY,
    Topping_ID int PRIMARY KEY,
    FOREIGN KEY (Pizza_ID) REFERENCES PIZZA(Pizza_ID),
    FOREIGN KEY (Topping_ID) REFERENCES TOPPINGS(Topping_ID)
);


CREATE TABLE PIZZADISCOUNT (
    Pizza_ID int PRIMARY KEY,
    Discount_ID int PRIMARY KEY,
    FOREIGN KEY (Pizza_ID) REFERENCES PIZZA(Pizza_ID),
    FOREIGN KEY (Discount_ID) REFERENCES DISCOUNTS(Discount_ID)
);

CREATE TABLE ORDERDISCOUNT (
    Order_ID int PRIMARY KEY,
    Discount_ID int PRIMARY KEY,
    FOREIGN KEY (Order_ID) REFERENCES ORDERS(Order_ID),
    FOREIGN KEY (Discount_ID) REFERENCES DISCOUNTS(Discount_ID)
);