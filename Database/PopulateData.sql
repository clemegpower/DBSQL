/*
Create an SQL script that has the insert statements necessary to populate your database
with the provided data (see additional info below for the data). Note: This will get a little
tedious to insert all the data in the correct tables. I tried to find a way to automate it or
make it easier, but there’s not a way without knowing your specific database design. Copy
and Paste will be your friend. Name this file “PopulateData.sql”
*/

USE cpsc4620project;

/*
Inserting into topping table
*/
/*
1
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Pepperoni", 1.25, 0.20, 100, 50, 2, 2.75, 3.5, 4.5); 

/*
2
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Sausage", 1.25, 0.15, 100, 50, 2.5, 3, 3.5, 4.25); 

/*
3
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Ham", 1.5, 0.15, 78, 25, 2, 2.5, 3.25, 4);

/*
4
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Chicken", 1.75, 0.25, 56, 25, 1.5, 2, 2.25, 3); 

/*
5
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Green Pepper", 0.5, 0.02, 79, 25, 1, 1.5, 2, 2.5); 

/*
6
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Onion", 0.5, 0.02, 85, 25, 1, 1.5, 2, 2.75); 

/*
7
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Roma Tomato", 0.75, 0.03, 86, 10, 2, 3, 3.5, 4.5); 

/*
8
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Mushrooms", 0.75, 0.1, 52, 50, 1.5, 2, 2.5, 3); 

/*
9
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Black Olives", 0.6, 0.1, 39, 25, 0.75, 1, 1.5, 2); 

/*
10
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Pineapple", 1, 0.25, 15, 0, 1, 1.25, 1.75, 2); 

/*
11
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Jalapenos", 0.5, 0.05, 64, 0, 0.5, 0.75, 1.25, 1.75); 

/*
12
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Banana Peppers", 0.5, 0.05, 36, 0, 0.6, 1, 1.3, 1.75);

/*
13
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Regular Cheese", 0.5, 0.12, 250, 50, 2, 3.5, 5, 7); 

/*
14
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Four Cheese Blend", 1, 0.15, 150, 25, 2, 3.5, 5, 7); 

/*
15
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Feta Cheese", 1.5, 0.18, 75, 0, 1.75, 3, 4, 5.5); 

/*
16
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Goat Cheese", 1.5, 0.2, 54, 0, 1.6, 2.75, 4, 5.5); 

/*
17
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Bacon", 1.5, 0.25, 89, 0, 1, 1.5, 2, 3); 



/*
Inserting into discount table
*/
-- id:1
INSERT INTO discount (DiscountName, DiscountPercent)
VALUES ("Employee", 0.15);

-- id:2
INSERT INTO discount (DiscountName, DiscountDollarAmt)
VALUES ("Lunch Special Medium", 1.00);

-- id:3
INSERT INTO discount (DiscountName, DiscountDollarAmt)
VALUES ("Lunch Special Large", 2.00);

-- id:4
INSERT INTO discount (DiscountName, DiscountDollarAmt)
VALUES ("Specialty Pizza", 1.50);

-- id:5
INSERT INTO discount (DiscountName, DiscountPercent)
VALUES ("Happy Hour", 0.10);

-- id:6
INSERT INTO discount (DiscountName, DiscountPercent)
VALUES ("Gameday Special", 0.20);


/*
Inserting into base prices table
*/

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("Small", "Thin", 3, 0.5);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("Small", "Original", 3, 0.75);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("Small", "Pan", 3.5, 1);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("Small", "Gluten-Free", 4, 2);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("Medium", "Thin", 5, 1);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("Medium", "Original", 5, 1.5);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("Medium", "Pan", 6, 2.25);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("Medium", "Gluten-Free", 6.25, 3);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("Large", "Thin", 8, 1.25);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("Large", "Original", 8, 2);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("Large", "Pan", 9, 3);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("Large", "Gluten-Free", 9.5, 4);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("XLarge", "Thin", 10, 2);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("XLarge", "Original", 10, 3);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("XLarge", "Pan", 11.5, 4.5);

INSERT INTO base (BasePizzaSize, BaseCrustType, BasePrice, BaseCost)
VALUES ("XLarge", "Gluten-Free", 12.5, 6);

/*
On March 5th at 12:03 pm there was a dine-in order (at table 21) for a large thin crust pizza with Regular
Cheese (extra), Pepperoni, and Sausage (Price: $20.75, Cost: $3.68). They used the “Lunch Special Large”
discount for the pizza.
*/

-- order id:1
INSERT INTO orderinfo(OrderInfoType, OrderInfoPrice, OrderInfoCost, OrderInfoTime)
VALUES ("dinein", 20.75, 3.68, "2023-03-05T12:03:00");
-- dine in 
INSERT INTO dinein(DineInOrderId, DineInTableNum)
VALUES (1, 21);
-- pizza id:1
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Thin", "Large", 3.68, 20.75, "Completed", 1);
-- toppings
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (1, 13, 2);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (1, 1, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (1, 2, 1);
-- pizzadiscount
INSERT INTO pizzadiscount (PizzaDiscountPizzaId, PizzaDiscountDiscountId)
VALUES (1, 3);

/*
On April 3rd at 12:05 pm there was a dine-in order (at table 4). They ordered a medium pan pizza with
Feta Cheese, Black Olives, Roma Tomatoes, Mushrooms and Banana Peppers (Price: $12.85, Cost: $3.23).
They used the “Lunch Special Medium” and the “Specialty Pizza” discounts for the pizza. They also ordered
a small original crust pizza with Regular Cheese, Chicken and Banana Peppers (Price: $6.93, Cost: $1.40).
*/

-- order id:2
INSERT INTO orderinfo(OrderInfoType, OrderInfoPrice, OrderInfoCost, OrderInfoTime)
VALUES ("dinein", 19.78, 4.63, "2023-04-03T12:05:00");
-- dine in order
INSERT INTO dinein(DineInOrderId, DineInTableNum)
VALUES (2, 4);

-- pizzas
-- id:2
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Pan", "Medium", 3.23, 12.85, "Completed", 2);
-- id:3
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Original", "Small", 1.40, 6.93, "Completed", 2);

-- toppings pizza id:2
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (2, 15, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (2, 9, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (2, 2, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (2, 7, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (2, 8, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (2, 12, 1);

-- toppings pizza id:3
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (3, 13, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (3, 4, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (3, 12, 1);

-- discount pizza id:2
INSERT INTO pizzadiscount (PizzaDiscountPizzaId, PizzaDiscountDiscountId)
VALUES (2, 2);
INSERT INTO pizzadiscount (PizzaDiscountPizzaId, PizzaDiscountDiscountId)
VALUES (2, 4);

/*
On March 3rd at 9:30 pm Andrew Wilkes-Krier placed an order for pickup of 6 large original crust pizzas
with Regular Cheese and Pepperoni (Price: $14.88, Cost: $3.30 each). Andrew’s phone number is 864-254-
5861.
*/

-- customer id:1
INSERT INTO customer(CustomerFName, CustomerLName, CustomerPhone)
VALUES ("Andrew", "Wilkes-Krier", "8642545861");

-- order id:3
INSERT INTO orderinfo(OrderInfoType, OrderInfoPrice, OrderInfoCost, OrderInfoTime)
VALUES ("pickup", 89.28, 19.8, "2023-03-03T21:30:00");

-- pickup order
INSERT INTO pickup(PickupOrderId, PickupCustomerId)
VALUES (3, 1);

-- pizzas
-- id:4
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Original", "Large", 3.30, 14.88, "Completed", 3);
-- id:5
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Original", "Large", 3.30, 14.88, "Completed", 3);
-- id:6
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Original", "Large", 3.30, 14.88, "Completed", 3);
-- id:7
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Original", "Large", 3.30, 14.88, "Completed", 3);
-- id:8
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Original", "Large", 3.30, 14.88, "Completed", 3);
-- id:9
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Original", "Large", 3.30, 14.88, "Completed", 3);

-- toppings pizza id:4
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (4, 1, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (4, 13, 1);
-- toppings pizza id:5
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (5, 1, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (5, 13, 1);
-- toppings pizza id:6
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (6, 1, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (6, 13, 1);
-- toppings pizza id:7
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (7, 1, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (7, 13, 1);
-- toppings pizza id:8
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (8, 1, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (8, 13, 1);
-- toppings pizza id:9
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (9, 1, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (9, 13, 1);

/*
On April 20th at 7:11 pm there was a delivery order made by Andrew Wilkes-Krier for 1 xlarge pepperoni
and Sausage pizza (Price: $27.94, Cost: $9.19), one xlarge pizza with Ham (extra) and Pineapple (extra)
pizza (Price: $31.50, Cost: $6.25), and one xlarge Chicken and Bacon pizza (Price: $26.75, Cost: $8.18). All
the pizzas have the Four Cheese Blend on it and are original crust. The order has the “Gameday Special”
discount applied to it, and the ham and pineapple pizza has the “Specialty Pizza” discount applied to it. The
pizzas were delivered to 115 Party Blvd, Anderson SC 29621. His phone number is the same as before.
*/

-- adding address to customer
UPDATE customer
SET CustomerStreet="115 Party Blvd", CustomerCity="Anderson", CustomerState="SC", CustomerZipcode=29621
WHERE CustomerId=1;

-- order id:4
INSERT INTO orderinfo(OrderInfoType, OrderInfoPrice, OrderInfoCost, OrderInfoTime)
VALUES ("delivery", 86.19, 23.62, "2023-04-20T19:11:00");

-- delivery order
INSERT INTO delivery(DeliveryOrderId, DeliveryCustomerId)
VALUES (4, 1);

-- pizzas
-- id:10
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Original", "XLarge", 9.19, 27.94, "Completed", 4);
-- id:11
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Original", "XLarge", 6.25, 31.50, "Completed", 4);
-- id:12
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Original", "XLarge", 8.18, 26.75, "Completed", 4);

-- toppings pizza id:10
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (10, 1, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (10, 2, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (10, 14, 1);
-- toppings pizza id:11
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (11, 3, 2);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (11, 10, 2);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (11, 14, 1);
-- toppings pizza id:12
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (12, 4, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (12, 17, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (12, 14, 1);

-- discount pizza 11
INSERT INTO pizzadiscount (PizzaDiscountPizzaId, PizzaDiscountDiscountId)
VALUES (11, 4);
-- discount order
INSERT INTO orderdiscount(OrderDiscountOrderId, OrderDiscountDiscountId)
VALUES(4, 6);

/*
On March 2nd at 5:30 pm Matt Engers placed an order for pickup for an xlarge pizza with Green Pepper,
Onion, Roma Tomatoes, Mushrooms, and Black Olives on it. He wants the Goat Cheese on it, and a Gluten
Free Crust (Price: $27.45, Cost: $7.88). The “Specialty Pizza” discount is applied to the pizza. Matt’s phone
number is 864-474-9953
*/

-- customer id:2
INSERT INTO customer(CustomerFName, CustomerLName, CustomerPhone)
VALUES ("Matt", "Engers", "8644749953");

-- order id:5
INSERT INTO orderinfo(OrderInfoType, OrderInfoPrice, OrderInfoCost, OrderInfoTime)
VALUES ("pickup", 27.45, 7.88, "2023-03-02T17:30:00");

-- pickup order
INSERT INTO pickup(PickupOrderId, PickupCustomerId)
VALUES (5, 2);

-- pizzas
-- id:13
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Gluten-free", "XLarge", 7.88, 27.45, "Completed", 5);

-- toppings pizza id:13
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (13, 5, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (13, 6, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (13, 7, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (13, 8, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (13, 9, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (13,16, 1);

-- discount pizza 13
INSERT INTO pizzadiscount (PizzaDiscountPizzaId, PizzaDiscountDiscountId)
VALUES (13, 4);

/*
On March 2nd at 6:17 pm Frank Turner places an order for delivery of one large pizza with Chicken, Green
Peppers, Onions, and Mushrooms. He wants the Four Cheese Blend (extra) and thin crust (Price: $25.81,
Cost: $4.24). The pizza was delivered to 6745 Wessex St Anderson SC 29621. Frank’s phone number is 864-
232-8944.
*/

-- customer id:3
INSERT INTO customer(CustomerFName, CustomerLName, CustomerPhone, CustomerStreet, CustomerCity, CustomerState, CustomerZipcode)
VALUES ("Frank", "Turner", "8642328944", "6745 Wessex St", "Anderson", "SC", 29621);

-- order id:6
INSERT INTO orderinfo(OrderInfoType, OrderInfoPrice, OrderInfoCost, OrderInfoTime)
VALUES ("delivery", 25.81, 4.24, "2023-03-02T18:17:00");

-- delivery order
INSERT INTO delivery(DeliveryOrderId, DeliveryCustomerId)
VALUES (6, 3);

-- pizzas
-- id:14
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Thin", "Large", 4.24, 25.81, "Completed", 6);

-- toppings pizza id:14
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (14, 4, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (14, 5, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (14, 6, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (14, 8, 1);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (14, 14, 2);


/*
On April 13th at 8:32 pm Milo Auckerman ordered two large thin crust pizzas. One had the Four Cheese
Blend on it (extra) (Price: $18.00, Cost: $2.75), the other was Regular Cheese and Pepperoni (extra) (Price:
$19.25, Cost: $3.25). He used the “Employee” discount on his order. He had them delivered to 8879
Suburban Home, Anderson, SC 29621. His phone number is 864-878-5679.
*/

-- customer id:4
INSERT INTO customer(CustomerFName, CustomerLName, CustomerPhone, CustomerStreet, CustomerCity, CustomerState, CustomerZipcode)
VALUES ("Milo", "Auckerman", "8648785679", "8879 Suburban Home", "Anderson", "SC", 29621);

-- order id:7
INSERT INTO orderinfo(OrderInfoType, OrderInfoPrice, OrderInfoCost, OrderInfoTime)
VALUES ("delivery", 37.25, 6.00, "2023-04-13T20:32:00");

-- delivery order
INSERT INTO delivery(DeliveryOrderId, DeliveryCustomerId)
VALUES (7, 4);

-- pizzas
-- id:15
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Thin", "Large", 2.75, 18.00, "Completed", 7);
-- id:16
INSERT INTO pizza (PizzaCrustType, PizzaSize, PizzaBaseCost, PizzaBasePrice, PizzaState, PizzaOrderId)
VALUES ("Thin", "Large", 3.25,  19.25, "Completed", 7);

-- toppings pizza id:15
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (15, 14, 2);
-- toppings pizza id:16
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (16, 1, 2);
INSERT INTO pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity)
VALUES (16, 13, 1);

-- discount order
INSERT INTO orderdiscount(OrderDiscountOrderId, OrderDiscountDiscountId)
VALUES(7, 1)
