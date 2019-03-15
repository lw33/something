select a.Id
from Weather a, Weather b
where a.Temperature > b.Temperature
and datediff(a.RecordDate, b.RecordDate) = 1;
-- datediff 日期差值