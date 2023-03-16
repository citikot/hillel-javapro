USE classicmodels;

SELECT * FROM offices;
-- Task 1
SELECT * FROM offices WHERE officeCode IN (4,5,6,7);
SELECT * FROM offices WHERE officeCode >= 4 AND officeCode <=7;
SELECT * FROM offices order by officeCode LIMIT 3, 4;
-- Task 5
SELECT * FROM offices order by city DESC;

SELECT * FROM products;
-- Task 2
SELECT * FROM products WHERE productName LIKE '1936%';
-- Task 3
SELECT * FROM products WHERE productVendor 
	IN ( "Motor City Art Classics", "Exoto Designs") 
    AND productScale LIKE '1:24';

SELECT * FROM orders;
-- Task 4
SELECT * FROM orders WHERE shippedDate IS NULL;






