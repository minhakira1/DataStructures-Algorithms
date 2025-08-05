# Write your MySQL query statement below
select e.event_day as day, e.emp_id, SUM(e.out_time - e.in_time) as total_time
from Employees e
group by emp_id, event_day
ORDER BY
    emp_id, event_day;
