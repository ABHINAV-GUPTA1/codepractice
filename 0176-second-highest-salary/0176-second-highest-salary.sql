# Write your MySQL query statement below
#SELECT MAX(salary) as SecondHighestSalary FROM Employee WHERE salary <> (SELECT MAX(salary) FROM Employee);

SELECT (SELECT DISTINCT(salary) FROM Employee ORDER BY salary desc LIMIT 1,1) As SecondHighestSalary;