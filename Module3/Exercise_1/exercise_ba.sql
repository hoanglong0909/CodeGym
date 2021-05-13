CREATE TABLE orders(
id INT PRIMARY KEY,
customer_id  INT,
orders_date DATE
);
CREATE TABLE customers(
id INT PRIMARY KEY,
`name`  varchar(110),
country varchar(100)
);

SELECT orders.id , customers.`name`, orders.orders_date
from orders
JOIN customers on orders.customer_id = customers.id ;