-- Task 1
INSERT INTO customers(customerName, salesRepEmployeeNumber)
VALUES ('Alex Pishvanov',
(SELECT employeeNumber FROM employees WHERE lastName = 'Jennings' AND firstName = 'Leslie' )
);
UPDATE customers SET customerNumber = 1001 WHERE customerName = 'Alex Pishvanov';
SELECT @customer_number := customerNumber FROM customers WHERE customerName = 'Alex Pishvanov';
SELECT @product_code := productCode FROM products WHERE productName = '1996 Moto Guzzi 1100i';
INSERT INTO orders(orderNumber, orderDate, requiredDate, shippedDate, status, customerNumber)
VALUES (1010001,  '2023-01-01', '2023-02-02', '2023-03-01', 'Cancelled', @customer_number);
SELECT @order_number := orderNumber FROM orders WHERE customerNumber = @customer_number;
INSERT INTO orderdetails(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber)
VALUES (@order_number,  @product_code, 1, 800.34, 1);

-- Task 2

UPDATE customers c SET c.customerName = CONCAT(c.customerName, ' Superstar')
WHERE c.customerName IN (SELECT s.customerName FROM (SELECT c.customerName, COUNT(*) as orders_amount FROM customers c
LEFT JOIN orders o ON c.customerNumber = o.customerNumber
GROUP BY c.customerNumber HAVING orders_amount > 10) as s);

-- Task 3

SELECT @customerNumber := customerNumber FROM customers
WHERE customerName = 'Diecast Collectables';

DELETE FROM payments
WHERE customerNumber = @customerNumber;

DELETE FROM orderdetails
WHERE orderNumber IN (SELECT orderNumber FROM orders
WHERE customerNumber = @customerNumber);

DELETE FROM orders
WHERE customerNumber = @customerNumber;





