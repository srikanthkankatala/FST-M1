use sales_db;
create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);

INSERT INTO orders VALUES(70001, 150.5, '2012-10-05', 3005, 5002);
INSERT INTO orders VALUES(70009, 270.65, '2012-09-10', 3001, 5005);
INSERT INTO orders VALUES(70002, 65.26, '2012-10-05', 3002, 5001);
INSERT INTO orders VALUES(70004, 110.5, '2012-08-17', 3009, 5003);
INSERT INTO orders VALUES(70007, 948.5, '2012-09-10', 3005, 5002);
INSERT INTO orders VALUES(70005, 2400.6, '2012-07-27', 3007, 5001);
INSERT INTO orders VALUES(70008, 5760, '2012-08-15', 3002, 5001);
INSERT INTO orders VALUES(70010, 1983.43, '2012-10-10', 3004, 5006);
INSERT INTO orders VALUES(70003, 2480.4, '2012-10-10', 3009, 5003);
INSERT INTO orders VALUES(70012, 250.45, '2012-06-27', 3008, 5002);
INSERT INTO orders VALUES(70011, 75.29, '2012-08-17', 3003, 5007);
INSERT INTO orders VALUES(70013, 3045.6, '2012-04-25', 3002, 5001);
    
    select * from orders;
    
select SUM(purchase_amount) AS "Total sum" from orders;

select AVG(purchase_amount) AS "Average" from orders;

select MAX(purchase_amount) AS "Maximum" from orders;

select MIN(purchase_amount) AS "Minumum" from orders;

select COUNT(distinct salesman_id) AS "Total count" from orders;

SELECT customer_id, MAX(purchase_amount) AS "Max Amount" FROM orders GROUP BY customer_id;

SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders 
WHERE order_date='2012/08/17' GROUP BY salesman_id, order_date;

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders
GROUP BY customer_id, order_date
HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);