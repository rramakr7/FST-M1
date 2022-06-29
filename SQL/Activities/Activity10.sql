REM   Script: Activity 10
REM   FST - SQL - Activity10

select * from orders where salesman_id = (select distinct salesman_id from orders where customer_id = 3007);

select * from orders where salesman_id = (select salesman_id from salesman where salesman_city = 'New York');

select grade,COUNT(*) from customers group by grade having grade > (select AVG(grade) from customers where city = 'New York');

select * from orders where salesman_id = (select salesman_id from salesman where commission = (select MAX(commission) from salesman));

