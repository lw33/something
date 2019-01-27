CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE c INT;
  SELECT (N-1) INTO c;
  RETURN (
      # Write your MySQL query statement below.
      SELECT distinct Salary FROM Employee ORDER BY Salary DESC LIMIT c,1
  );
END