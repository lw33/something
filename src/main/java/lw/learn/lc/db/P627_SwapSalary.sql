# noinspection SqlNoDataSourceInspectionForFile

-- Write your MySQL query statement below
-- select id, name, if(sex="f", "m", "f") as sex, salary 
-- from salary;

update salary set sex=if(sex='f', 'm', 'f');