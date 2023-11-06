/*
Create an SQL script that has the create statements necessary to build the tables for
your database. Remember to include any constraints that you need for the database.
Run the SQL script in MySQL to create your database. This script should include SQL to
create the database schema. Name this file “CreateTables.sql”
*/

CREATE TABLE base (
    BasePizzaSize varchar(3),
    BaseCrustType varchar(10),
    BasePrice DECIMAL(3,2),
    BaseCost DECIMAL(3,2),
    PRIMARY KEY (BaseCrustType, BasePizzaSize)
);

CREATE TABLE topping (
    ToppingId int PRIMARY KEY,
    ToppingName varchar(20),
    ToppingPricePer DECIMAL(3,2),
    ToppingCostPer DECIMAL(3,2),
    ToppingCurrentInventory int, 
    ToppingMinInventory int,
    ToppingUnitsSmall int CHECK(ToppingUnitsSmall > 0),
    ToppingUnitsMedium int CHECK(ToppingUnitsMedium > 0),
    ToppingUnitsLarge int CHECK(ToppingUnitsLarge > 0),
    ToppingUnitsXLarge int CHECK(ToppingUnitsXLarge > 0)

);

CREATE TABLE customer (
    CustomerId int PRIMARY KEY,
    CustomerFName varchar(20), 
    CustomerLName varchar(20),
    CustomerPhone int, 
    CustomerStreet varchar(50),
    CustomerCity varchar(30),
    CustomerState varchar(5),
    CustomerZipcode int
);

CREATE TABLE discount (
    DiscountId int PRIMARY KEY,
    DiscountName varchar(20), 
    DiscountDollarAmt DECIMAL(3,2),
    DiscountPercent DECIMAL(3,2) CHECK (DiscountPercent <= 1 AND DiscountPercent >= 0),
    DiscountType varchar(10)
);

CREATE TABLE orderinfo (
    OrderInfoId int PRIMARY KEY,
    OrderInfoType varchar(10),
    OrderInfoTotal DECIMAL(3,2),
    OrderInfoTime date
);

CREATE TABLE dinein (
    OrderId int PRIMARY KEY,
    TableNum int,
    FOREIGN KEY (OrderId) REFERENCES orderinfo(OrderInfoId)
);

CREATE TABLE delivery (
    OrderId int PRIMARY KEY,
    CustomerId int,
    FOREIGN KEY (OrderId) REFERENCES order(OrderInfoId),
    FOREIGN KEY (CustomerId) REFERENCES customer(CustomerId)
);

CREATE TABLE pickup (
    OrderId int PRIMARY KEY,
    CustomerId int,
    FOREIGN KEY (OrderId) REFERENCES orderinfo(OrderInfoId),
    FOREIGN KEY (CustomerId) REFERENCES customer(CustomerId)
);

CREATE TABLE pizza (
    PizzaId int PRIMARY KEY,
    PizzaCrustType varchar(20),
    PizzaSize varchar(3),
    PizzaState varchar(10), 
    PizzaBaseCost DECIMAL(3,2),
    PizzaOrderId int,
    PizzaBasePrice DECIMAL(3,2),
    FOREIGN KEY (PizzaOrderId) REFERENCES orderinfo(OrderInfoId),
    FOREIGN KEY (PizzaCrustType, PizzaSize) REFERENCES base(BaseCrustType, BasePizzaSize)
);

CREATE TABLE pizzatopping (
    PizzaToppingPizzaId int,
    PizzaToppingToppingId int,
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