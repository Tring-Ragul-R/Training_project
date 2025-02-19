-- Creating Tables with Constraints

-- 1.

create table departments(
dept_id serial primary key,
dept_name varchar(10) UNIQUE not null 
) 

select * from departments

-- 2.
create table employees (
emp_id serial primary key,
emp_name VARCHAR(25) not null,
email VARCHAR(30) unique,
salary INT not null check(salary>0),
dept_id int REFERENCES departments(dept_id)
)

-- 3.

create table projects (
project_id serial primary key,
project_name varchar(50) not null,
dept_id int REFERENCES departments(dept_id)
)

-- Insert Sample Data

-- 4.

ALter table departments
alter column dept_name type varchar(25)

insert into departments (dept_name) values
('Admin'),
('IT'),
('HR'),
('Development'),
('Testing'),
('Sales')

-- 5.

insert into employees (emp_name,email,salary,dept_id) values
('Sabesan', 'sabesan@gmail.com', 50000, 1),
    ('Suriya', 'suriya@gmail.com', 55000, 2),
    ('Barath', 'barath@gmail.com', 45000, 3),
    ('Mullai', 'mullai@gmail.com', 60000, 6),
    ('Raja', 'raja@gmail.com', 52000, 5),
    ('Ragul', 'ragul@gmail.com', 48000, 1),
    ('Prakesh', 'prakesh@gmail.com', 57000, 2),
    ('Nandha', 'nandha@gmail.com', 62000, 3),
    ('Harshini', 'harshini@gmail.com', 53000, 4),
    ('Saran', 'saran@gmail.com', 51000, 5)

insert into employees (emp_name,email,salary) values
('srinivasan','srinivasan@gmail.com',50000)
	select * from employees

insert into projects (project_name,dept_id) values
('policy Management',1),
('Infrastructure Upgrade',2),
('Employee Onboarding',3),
('Library Management',4),
('Automation Testing',5),
('Sales Automation',6)

select * from projects

-- Writing Queries

-- Section A: Joins

-- 5. INNER JOIN

Select employees.*,dept_name from employees inner join departments on 
employees.dept_id = departments.dept_id

-- 6. LEFT JOIN

select * from employees left join  departments
on employees.dept_id = departments.dept_id

-- 7. RIGHT JOIN

select * from employees right join departments
on employees.dept_id = departments.dept_id

-- 8. FULL OUTER JOIN

select * from departments full outer join employees
on departments.dept_id = employees.dept_id

-- 9. JOIN With multiple table



-- Aggregate Functions

-- 10.

select departments.dept_id ,dept_name ,count(*) from employees
inner join departments on employees.dept_id = departments.dept_id
group by departments.dept_id

-- 11.

select departments.dept_id,dept_name,sum(salary) total_salary from employees
inner join departments on employees.dept_id = departments.dept_id
group by departments.dept_id

-- 12.

select departments.dept_id,dept_name,avg(salary) Average_salary from employees
inner join departments on employees.dept_id = departments.dept_id
group by departments.dept_id

-- 13.

select max(salary) max_salary,min(salary) min_salary from employees

-- 14.

select departments.dept_id,count(*),departments.dept_name from projects
inner join departments on projects.dept_id = departments.dept_id
group by departments.dept_id

-- GROUP BY and HAVING

-- 15.

select avg(salary),departments.dept_name from employees inner join departments on 
employees.dept_id = departments.dept_id group by departments.dept_id
having avg(salary) >50000

-- 16.

select dept_id ,count(*) from employees
group by dept_id 
having count(*)>3

-- 17.

select dept_id ,count(*) from projects
group by dept_id
having count(*)>=2

-- GROUP BY and HAVING

-- 18.

create or replace function calBonus(salary numeric)
returns numeric as $$
begin
	return salary+(salary*10/100);
end;
$$ language plpgsql

select emp_name,salary,calbonus(salary) from employees

-- 19.

create or replace function count_emp(dept_id_new int)
returns int as $$
declare
    employee_count int;
begin
    select count(*)
    into employee_count
    from employees
    where employees.dept_id = dept_id_new;

    return employee_count;
end;
$$ language plpgsql;

select count_emp(2) 

DROP FUNCTION count_emp(integer)

-- 20.

create function or replace 