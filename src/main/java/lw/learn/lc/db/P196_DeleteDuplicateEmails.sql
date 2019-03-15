delete p1
from Person p1, Person p2
where p1.Email = p2.Email and p1.Id > p2.Id;

delete
from person
where id not in
(select id from (select min(id) id from person group by email) b);