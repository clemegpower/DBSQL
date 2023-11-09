/* 
Create an SQL script that will DROP each table in your database. This will be helpful for you
to run when there are errors in your create file or insert file and you need to re-run
everything. Steps 3 and 4 will make it easier to grade your submission as well. Name this file
“DropTables.sql”
*/

USE cpsc4620project;

DROP TABLE orderdiscount;
DROP TABLE pizzadiscount;
DROP TABLE pizzatopping;
DROP TABLE pizza;
DROP TABLE pickup;
DROP TABLE delivery;
DROP TABLE dinein;
DROP TABLE orderinfo;
DROP TABLE discount;
DROP TABLE customer;
DROP TABLE topping;
DROP TABLE base;

DROP SCHEMA cpsc4620project;