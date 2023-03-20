-- Task 1 Show employees working in Paris and Tokyo
SELECT e.lastName, e.firstName, e.officeCode, o.city FROM employees e
INNER JOIN offices o ON o.officeCode = e.officeCode
WHERE o.city IN ('Paris', 'Tokyo')
ORDER BY o.city;

-- Task 2 Show employees how many clients they supported (from 0 to ...)
SELECT e.employeeNumber, e.lastName, e.firstName, COUNT(c.salesRepEmployeeNumber) AS clients_amount FROM employees e
LEFT JOIN customers c ON e.employeeNumber = c.salesRepEmployeeNumber
GROUP BY e.employeeNumber
ORDER BY clients_amount DESC;

-- Task 3 Show employees reported to Bondur Gerard
SELECT em.employeeNumber, em.firstName, em.lastName, em.reportsTo, e.firstName, e.lastName FROM employees e
LEFT JOIN employees em ON e.employeeNumber = em.reportsTo
WHERE e.lastName = 'Bondur'AND e.firstName = 'Gerard';

-- Task 4 Show employees that helped less than five clients
SELECT e.employeeNumber, e.lastName, e.firstName, COUNT(c.salesRepEmployeeNumber) AS clients_amount FROM employees e
LEFT JOIN customers c ON e.employeeNumber = c.salesRepEmployeeNumber
GROUP BY e.employeeNumber HAVING clients_amount < 5
ORDER BY clients_amount DESC;

-- Task 5 Show all employees with not Shipped orders
SELECT e.employeeNumber, e.lastName, e.firstName, COUNT(od.customerNumber) AS orders_non_shipped FROM employees e
LEFT JOIN customers c ON e.employeeNumber = c.salesRepEmployeeNumber
LEFT JOIN orders od ON c.customerNumber = od.customerNumber
WHERE !(od.status = 'Shipped')
GROUP BY e.employeeNumber
ORDER BY orders_non_shipped DESC;

-- Task 6-1 Show the best employee (by the count of the Shipped orders)
SELECT e.employeeNumber, e.lastName, e.firstName, COUNT(od.customerNumber) AS shipped_orders_amount FROM employees e
LEFT JOIN customers c ON e.employeeNumber = c.salesRepEmployeeNumber
LEFT JOIN orders od ON c.customerNumber = od.customerNumber
WHERE od.status = 'Shipped'
GROUP BY e.employeeNumber
ORDER BY shipped_orders_amount DESC
LIMIT 1;

-- Task 6-2 Show the worst employee (by the count of the Shipped orders)
SELECT e.employeeNumber, e.lastName, e.firstName, COUNT(od.customerNumber) AS shipped_orders_amount FROM employees e
LEFT JOIN customers c ON e.employeeNumber = c.salesRepEmployeeNumber
LEFT JOIN orders od ON c.customerNumber = od.customerNumber
WHERE od.status = 'Shipped'
GROUP BY e.employeeNumber
ORDER BY shipped_orders_amount
LIMIT 1;