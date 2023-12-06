/*
Create an SQL script that has the create statements necessary to build the tables for
your database. Remember to include any constraints that you need for the database.
Run the SQL script in MySQL to create your database. This script should include SQL to
create the database schema. Name this file “CreateTables.sql”
*/

CREATE SCHEMA cpsc4620project;

USE cpsc4620project;

CREATE TABLE base (
    BasePizzaSize varchar(10),
    BaseCrustType varchar(20),
    BasePrice DECIMAL(5,2),
    BaseCost DECIMAL(5,2),
    PRIMARY KEY (BaseCrustType, BasePizzaSize)
);

CREATE TABLE topping (
    ToppingId int NOT NULL AUTO_INCREMENT,
    ToppingName varchar(20),
    ToppingPricePer DECIMAL(3,2),
    ToppingCostPer DECIMAL(3,2),
    ToppingCurrentInventory int, 
    ToppingMinInventory int,
    ToppingUnitsSmall int CHECK(ToppingUnitsSmall > 0),
    ToppingUnitsMedium int CHECK(ToppingUnitsMedium > 0),
    ToppingUnitsLarge int CHECK(ToppingUnitsLarge > 0),
    ToppingUnitsXLarge int CHECK(ToppingUnitsXLarge > 0),
    PRIMARY KEY (ToppingId)
);

CREATE TABLE customer (
    CustomerId int AUTO_INCREMENT,
    CustomerFName varchar(20), 
    CustomerLName varchar(20),
    CustomerPhone varchar(20), 
    CustomerStreet varchar(50),
    CustomerCity varchar(30),
    CustomerState varchar(5),
    CustomerZipcode int,
    PRIMARY KEY (CustomerId)
);

CREATE TABLE discount (
    DiscountId int AUTO_INCREMENT,
    DiscountName varchar(20), 
    DiscountDollarAmt DECIMAL(5,2),
    DiscountPercent DECIMAL(5,2) CHECK (DiscountPercent <= 1 AND DiscountPercent >= 0),
    DiscountType varchar(10),
    PRIMARY KEY (DiscountId)
);

CREATE TABLE orderinfo (
    OrderInfoId int AUTO_INCREMENT,
    OrderInfoType varchar(10),
    OrderInfoPrice DECIMAL(5,2),
    OrderInfoCost DECIMAL(5, 2),
    OrderInfoTime datetime,
    OrderInfoStatus boolean default = false,
    PRIMARY KEY (OrderInfoId)
);

CREATE TABLE dinein (
    DineInOrderId int PRIMARY KEY,
    DineInTableNum int,
    FOREIGN KEY (DineInOrderId) REFERENCES orderinfo(OrderInfoId)
);

CREATE TABLE delivery (
    DeliveryOrderId int PRIMARY KEY,
    DeliveryCustomerId int,
    FOREIGN KEY (DeliveryOrderId) REFERENCES orderinfo(OrderInfoId),
    FOREIGN KEY (DeliveryCustomerId) REFERENCES customer(CustomerId)
);

CREATE TABLE pickup (
    PickupOrderId int PRIMARY KEY,
    PickupCustomerId int,
    PickupIsPickedUp boolean default=false,
    FOREIGN KEY (PickupOrderId) REFERENCES orderinfo(OrderInfoId),
    FOREIGN KEY (PickupCustomerId) REFERENCES customer(CustomerId)
);

CREATE TABLE pizza (
    PizzaId int AUTO_INCREMENT,
    PizzaCrustType varchar(20),
    PizzaSize varchar(10),
    PizzaState varchar(10), 
    PizzaBaseCost DECIMAL(5,2),
    PizzaOrderId int,
    PizzaBasePrice DECIMAL(5,2),
    PRIMARY KEY (PizzaId),
    FOREIGN KEY (PizzaOrderId) REFERENCES orderinfo(OrderInfoId),
    FOREIGN KEY (PizzaCrustType, PizzaSize) REFERENCES base(BaseCrustType, BasePizzaSize)
);

CREATE TABLE pizzatopping (
    PizzaToppingPizzaId int,
    PizzaToppingToppingId int,
    PizzaToppingQuantity int,
    PRIMARY KEY (PizzaToppingPizzaId, PizzaToppingToppingId),
    FOREIGN KEY (PizzaToppingPizzaId) REFERENCES pizza(PizzaId),
    FOREIGN KEY (PizzaToppingToppingId) REFERENCES topping(ToppingId)
);


CREATE TABLE pizzadiscount (
    PizzaDiscountPizzaId int,
    PizzaDiscountDiscountId int,
    PRIMARY KEY (PizzaDiscountPizzaId, PizzaDiscountDiscountId),
    FOREIGN KEY (PizzaDiscountPizzaId) REFERENCES pizza(PizzaId),
    FOREIGN KEY (PizzaDiscountDiscountId) REFERENCES discount(DiscountId)
);

CREATE TABLE orderdiscount (
    OrderDiscountOrderId int,
    OrderDiscountDiscountId int,
    PRIMARY KEY (OrderDiscountOrderId, OrderDiscountDiscountId),
    FOREIGN KEY (OrderDiscountOrderId) REFERENCES orderinfo(OrderInfoId),
    FOREIGN KEY (OrderDiscountDiscountId) REFERENCES discount(DiscountId)
);