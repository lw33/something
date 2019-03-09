select Name  Customers 
from
Customers c left join Orders o
on o.CustomerId = c.Id 
where o.CustomerId IS NULL;