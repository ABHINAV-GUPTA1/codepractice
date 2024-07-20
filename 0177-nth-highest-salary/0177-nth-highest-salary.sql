CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N-1;
  RETURN (
      SELECT (SELECT DISTINCT(salary) FROM Employee ORDER BY salary DESC LIMIT N,1) AS salary

  );
END