/*
Create an SQL script that maps your tables onto a set of standard views. You must the
create 3 views described in Part 1 with the following view names and column names.
• ToppingPopularity: rank order of all the toppings (accounting for extra toppings)
from most popular to least popular
• ProfitByPizza: a summary of the profit by pizza size and crust type over a selected
time period ordered by profit from most profitable to least profitable
• ProfitByOrderType: a summary of the profit for each of the three types of orders
by month with a grand total over all the orders at the pizzeria ordered by customer
type and profit.
DO NOT Change the view names or the column names shown above. Your results
should match once you have populated the database with the orders and data specified
below. You must include a “SELECT * FROM …” command for each of the views. Name
this file “CreateViews.sql”
*/

USE cpsc4620project;

/* 
    ProfitByPizza View:
    A summary of the profit by pizza size and crust type over a selected time
    period ordered by profit from most profitable to least profitable
*/

CREATE VIEW ProfitByPizza AS

SELECT 
	PizzaCrustType AS 'Crust', 
    PizzaSize AS 'Type', 
    SUM(PizzaBasePrice-PizzaBaseCost) AS Profit,
	CONCAT(MONTH(OrderInfoTime), '/', YEAR(OrderInfoTime)) AS OrderMonth
FROM pizza P
JOIN orderinfo O ON P.PizzaOrderId=O.OrderInfoId
GROUP BY PizzaCrustType, PizzaSize
ORDER BY Profit DESC;


/* 
    ToppingPopularity:
    Rank order of all the toppings (accounting for extra toppings) 
    from most popular to least popular
*/

CREATE VIEW ToppingPopularity AS

SELECT ToppingName, SUM(COALESCE(PizzaToppingQuantity, 0)) AS ToppingCount
FROM topping T
LEFT JOIN pizzatopping PT ON T.ToppingId=PT.PizzaToppingToppingId
GROUP BY ToppingId
ORDER BY ToppingCount DESC;

/*
    ProfitByOrderType:
    A summary of the profit for each of the three types of orders by month 
    with a grand total over all the orders at the pizzeria ordered by 
    customer type and profit.
*/

CREATE VIEW ProfitByOrderType AS 

SELECT 
	OrderInfoType AS customerType,
    date_format(OrderInfoTime, '%c/%Y') AS OrderMonth,
    SUM(OrderInfoPrice) AS TotalOrderPrice,
    SUM(OrderInfoCost) AS TotalOrderCost,
    SUM(OrderInfoPrice-OrderInfoCost) AS TotalProfit
FROM orderinfo O
GROUP BY customerType, OrderMonth

UNION

SELECT 
	NULL, 
	'Grand Total',
	SUM(OrderInfoPrice) AS TotalOrderPrice,
    SUM(OrderInfoCost) AS TotalOrderCost,
    SUM(OrderInfoPrice-OrderInfoCost) AS TotalProfit
FROM orderinfo
