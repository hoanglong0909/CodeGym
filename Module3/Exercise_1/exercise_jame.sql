-- WHERE
select * from customers 
where customerName = 'Gift Depot Inc.';
-- AND
select customerName,customerNumber from customers
where customerNumber > 200 ;

-- join
select customers.customerName, customers.customerNumber,orders.orderDate,orders.orderNumber
from orders
right join customers
on  orders.customerNumber = customers.customerNumber;

-- join nhiều hơn 2 bảng
 
 -- Các hàm SQL:
 SELECT SUM(customerNumber)
 from customers
 where customerNumber < 200 ;
 
 -- hàm avg
 
 select avg(customerNumber)
 from customers 
 where customerNumber <200 ;
 
 -- hàm count
 select count(customerNumber)
 from customers
 where customerNumber < 300 ;
 
 -- hàm max
 select ( max(customerNumber)) 
 from customers;
 
-- now
select now() customers;

select customerNumber
from customers
order by customerNumber desc;

select count(customerNumber),customerName
from customers
group by customerName
having count(customerNumber)>=1


 
 
 
 


	




