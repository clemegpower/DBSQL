/*
Create an SQL script that has the insert statements necessary to populate your database
with the provided data (see additional info below for the data). Note: This will get a little
tedious to insert all the data in the correct tables. I tried to find a way to automate it or
make it easier, but there’s not a way without knowing your specific database design. Copy
and Paste will be your friend. Name this file “PopulateData.sql”
*/


/*
Inserting into topping table
*/
INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Pepperoni", 1.25, 0.20, 100, 50, 2, 2.75, 3.5, 4.5); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Sausage", 1.25, 0.15, 100, 50, 2.5, 3, 3.5, 4.25); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Ham", 1.5, 0.15, 78, 25, 2, 2.5, 3.25, 4);

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Chicken", 1.75, 0.25, 56, 25, 1.5, 2, 2.25, 3); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Green Pepper", 0.5, 0.02, 79, 25, 1, 1.5, 2, 2.5); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Onion", 0.5, 0.02, 85, 25, 1, 1.5, 2, 2.75); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Roma Tomato", 0.75, 0.03, 86, 10, 2, 3, 3.5, 4.5); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Mushrooms", 0.75, 0.1, 52, 50, 1.5, 2, 2.5, 3); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Black Olives", 0.6, 0.1, 39, 25, 0.75, 1, 1.5, 2); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Pineapple", 1, 0.25, 15, 0, 1, 1.25, 1.75, 2); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Jalapenos", 0.5, 0.05, 64, 0, 0.5, 0.75, 1.25, 1.75); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Banana Peppers", 0.5, 0.05, 36, 0, 0.6, 1, 1.3, 1.75);

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Regular Cheese", 0.5, 0.12, 250, 50, 2, 3.5, 5, 7); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Four Cheese Blend", 1, 0.15, 150, 25, 2, 3.5, 5, 7); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Feta Cheese", 1.5, 0.18, 75, 0, 1.75, 3, 4, 5.5); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Goat Cheese", 1.5, 0.2, 54, 0, 1.6, 2.75, 4, 5.5); 

INSERT INTO topping (ToppingName, ToppingPricePer, ToppingCostPer, ToppingCurrentInventory,
ToppingMinInventory, ToppingUnitsSmall, ToppingUnitsMedium, ToppingUnitsLarge, ToppingUnitsXLarge)
VALUES ("Bacon", 1.5, 0.25, 89, 0, 1, 1.5, 2, 3); 



/*
Inserting into discount table
*/

INSERT INTO discount (DiscountName, DiscountPercent)
VALUES ("Employee", 0.15);

INSERT INTO discount (DiscountName, DiscountDollarAmt)
VALUES ("Lunch Special Medium", 1.00);

INSERT INTO discount (DiscountName, DiscountDollarAmt)
VALUES ("Lunch Special Large", 2.00);

INSERT INTO discount (DiscountName, DiscountDollarAmt)
VALUES ("Specialty Pizza", 1.50);

INSERT INTO discount (DiscountName, DiscountPercent)
VALUES ("Happy Hour", 0.10);

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