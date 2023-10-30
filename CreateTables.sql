/*
Create an SQL script that has the create statements necessary to build the tables for
your database. Remember to include any constraints that you need for the database.
Run the SQL script in MySQL to create your database. This script should include SQL to
create the database schema. Name this file “CreateTables.sql”
*/

CREATE TABLE PIZZA (
    Pizza_ID int PRIMARY KEY,
    Crust_Type varchar(20) FOREIGN KEY,
    Size varchar(3) FOREIGN KEY,
    Pizza_State varchar(10), 
    Base_Cost float,
    Topping_List FOREIGN KEY, -- wait do we need this...?
    Discount_List FOREIGN KEY, -- or this...since Pizza_ID is a FK in the middle, couldn't we just reference that table?
    Order_ID int FOREIGN KEY,
    Base_Price float
);

CREATE TABLE ORDERS (
    Order_ID int PRIMARY KEY,
    Order_Type varchar(10),
    Order_Total float,
    Time_Ordered date,
    Discount_List FOREIGN KEY
);

CREATE TABLE DINE_IN (
    Order_ID int PRIMARY KEY FOREIGN KEY,
    Table_Num int
);

CREATE TABLE DELIVERY (
    Order_ID int PRIMARY KEY FOREIGN KEY,
    Cust_ID int FOREIGN KEY
);

CREATE TABLE PICKUP (
    Order_ID int PRIMARY KEY FOREIGN KEY,
    Cust_ID int FOREIGN KEY
);

CREATE TABLE TOPPINGS (
    Topping_ID int PRIMARY KEY,
    Topping_Name varchar(20),
    Topping_Cust_Price float,
    Topping_Buss_Price float,
    Min_Inventory int CHECK(Min_Inventory >=50),
    Current_Inventory int
);

CREATE TABLE TOPPINGLIST (
    Pizza_ID int PRIMARY KEY FOREIGN KEY,
    Topping_ID int PRIMARY KEY FOREIGN KEY
);

CREATE TABLE DISCOUNTS (
    Discount_ID int PRIMARY KEY,
    Discount_Name varchar(20), 
    Dollar_Amt_Off float,
    Percent_Off float CHECK (Percent_Off <= 1),
    Type_Discount varchar(10)
);

CREATE TABLE PIZZADISCOUNT (
    Pizza_ID int PRIMARY KEY FOREIGN KEY,
    Discount_ID int PRIMARY KEY FOREIGN KEY
);

CREATE TABLE ORDERDISCOUNT (
    Order_ID int PRIMARY KEY FOREIGN KEY,
    Discount_ID int PRIMARY KEY FOREIGN KEY
);

CREATE TABLE BASEPRICE (
    Pizza_Size varchar(3) PRIMARY KEY FOREIGN KEY,
    Crust_Type varchar(10) PRIMARY KEY FOREIGN KEY,
    Base_Cost float,
    Base_Price float
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