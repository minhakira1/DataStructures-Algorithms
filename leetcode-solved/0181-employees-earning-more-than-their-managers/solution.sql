/* Write your PL/SQL query statement below */
select e.name as Employee
from Employee e
inner join Employee e2 
    on e.managerId = e2.id and e.salary > e2.salary

