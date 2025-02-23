-- Creation of Department Table
 
 create table department(
dept_id serial primary key,
dept_name varchar(20) UNIQUE not null ,
location varchar(25)) 

-- Creation of Employee Table

create table employee(
empId serial primary key,
empName varchar(30) not null,
email varchar(35) unique not null,
designation varchar(20),
salary numeric check(salary>0),
hireDate date  check(hiredate>='1990-12-29' and hiredate<= CURRENT_DATE),
reportingManager int REFERENCES employee(empId),
dept_id int REFERENCES department(dept_id)
)

-- Insert department

INSERT INTO department (dept_name, location) 
VALUES 
    ('HR', 'Chennai'),
    ('Admin', 'New york'),
    ('Sales', 'Madurai'),
    ('Tech', 'Bangalore'),
	('IT','Columbia');
 
-- Insert Employee

INSERT INTO employee (empName, email, designation, salary, hireDate, reportingManager, dept_id) 
VALUES
    ('Sabesan', 'sabesan@gmail.com', 'Manager', 90000, '2015-06-01', NULL, 1),
    ('Suriya', 'suriya@gmail.com', 'Software Engineer', 60000, '2017-08-05', NULL, 4),
    ('Barath', 'barath@gmail.com', 'Sales Manager', 55000, '2018-03-14', NULL, 3),
    ('Rajasekar', 'rajasekar@gmail.com', 'Marketing Assistant', 65000, '2020-01-21', NULL, 1),
    ('Jaya Prakash', 'jayaprakash@gmail.com', 'Software Trainee', 50000, '2020-12-15', 1, 1),
    ('Mullai', 'mullai@gmail.com', 'Junior Developer', 55000, '2021-07-10', 2, 4),
    ('Ragul', 'ragul@gmail.com', 'Software Trainee', 50000, '2021-11-01', 3, 3),
    ('Nandha', 'nandha@gmail.com', 'Marketing Specialist', 85000, '2019-04-03', 4, 2),
    ('Saran', 'saran@gmail.com', 'Senior Developer', 70000, '2020-10-12', 2, 4),
	('Srini','srini@gmail.com','Marketing Manager',70000,'2019-07-24',2,Null);

-- distinct Clause

select DISTINCT salary from employee

--         ----------------------------------------------Where Clause---------------------------------------------------- 

--(Add 10% bonus for dept_id = 1)

select employee.*,salary+salary*0.1 as total_salary 
from employee where dept_id = 1

-- find the employee salary who name is mullai

select salary from employee where empName = 'Mullai';

-- find the employee name who working as software trainee

select empname from employee where designation = 'Software Trainee';

-------------------------------------------------------- AND Operator --------------------------------------------------------

-- find employee details where designation is Software Trainee and dept_id is 3

select * from employee where designation = 'Software Trainee' and dept_id = 3;

-------------------------------------------------------- OR Operator --------------------------------------------------------

-- find employee details where reportingManager is 1 or salary greater than 60000

select * from employee where reportingManager = 1 or salary > 60000;

-------------------------------------------------------- IN Operator --------------------------------------------------------

-- find the employee details where working in dept 1 and 3

select * from employee where dept_id in (1,3);

-------------------------------------------------------- NOT IN Operator --------------------------------------------------------

-- find the employee details where not working in dept 1 and 3

select * from employee where dept_id not in (1,3);

-------------------------------------------------------- BETWEEN Opertor --------------------------------------------------------

-- find the Details of employee earning salary between 60000 and 80000

select * from employee where salary between 60000 and 80000;

-------------------------------------------------------- IS Operator --------------------------------------------------------

-- find the employee id,name,job,salary who do not have any reporting manager

select empid,empname,designation,salary from employee where reportingmanager is null;

-------------------------------------------------------- LIKE Operator --------------------------------------------------------

-- find employee name wh0's name as character 'N'

select empname from employee where empname like '%n%';

-- find employee name wh0's name starts with 'S' and ends with 'N'

select empName from employee where empname like 'S%n';

-- find employee name,designation,hiredate details who's hired in the year of 2020

select empname,designation,hiredate from employee where hiredate::text like '2020%';

-- find the employee name who name has character 'a' as the second letter in the name and ends with 'a'

select empname from employee where empname like '_a%a';

-------------------------------------------------------- Aggregate Function --------------------------------------------------------

-- find average salary and minimum salary given to employee's of dept 3

select avg(salary) as AverageSalary,min(salary) from employee where dept_id = 3;

-- find minimum salary,count and sum of salary given to the Employee who work in dept 1 as Software Trainee or a Manager

select min(salary),count(*),sum(salary) from Employee where dept_id= 1 and designation in ('Software Trainee','Manager')

-------------------------------------------------------- GROUP BY --------------------------------------------------------

-- find number of employee working in each department 

select count(*),dept_id from Employee group by dept_id;

-- find maximum salary given to an employee working in each department

select max(salary),dept_id from Employee group by dept_id order by dept_id;

--------------------------------------------------------HAVING CLAUSE --------------------------------------------------------

-- find number of employee working in each department  except dept 2, if they are atleast 3 employee in each department

select count(*),dept_id from Employee
where dept_id not in (2)
group by dept_id
having count(*) >= 3;

-------------------------------------------------------- SubQuery --------------------------------------------------------

-- find employee name,hiredate of the employee hired after 2018 and before Mullai

select Empname,hiredate from Employee
where hiredate >= '2019-01-01' and
hiredate < (Select hireDate from Employee where empname = 'Mullai');

-- display empname,salary and designation of the employee who's annual salary is more than Ragul and less than Sabesan

select Empname,salary,designation from Employee
where salary*12 > (select salary*12 from employee where empname = 'Ragul')
AND salary * 12 < (select salary*12 from employee where empname = 'Sabesan');

--display the employee details working in Chennai location

select * from employee
where dept_id  = (select dept_id from department where location='Chennai')

-- find the name of Employee reporting to Barath

select empname from Employee where reportingManager = (
select empid from employee where empname = 'Barath');

-------------------------------------------------------- INNER JOIN --------------------------------------------------------

-- Display employee name and salary for all the employees working in Tech department

select empname,salary from employee as e inner join department as d
on e.dept_id = d.dept_id where d.dept_name = 'Tech';

-------------------------------------------------------- LEFT JOIN --------------------------------------------------------

-- find employee name, designation, dept_name

select empname, designation,dept_name
from employee e left join department d on e.dept_id = d.dept_id;

-------------------------------------------------------- RIGHT JOIN --------------------------------------------------------

-- find employee name, designation, dept_name

select empname, designation,dept_name
from employee e right join department d on e.dept_id = d.dept_id;

-------------------------------------------------------- FULL JOIN --------------------------------------------------------

-- find employee name, designation, dept_name

select empname, designation,dept_name
from employee e full join department d on e.dept_id = d.dept_id;

-------------------------------------------------------- SELF JOIN --------------------------------------------------------

-- display name of the employee and his manager's name if employee is working as Software Trainee

select e1.empname as emp_name,e2.empname as manager_name
from employee e1 join employee e2
on e1.reportingmanager = e2.empid and e1.designation = 'Software Trainee';

-------------------------------------------------------- CORELATED SUBQUERY --------------------------------------------------------

-- display dept name in which employees are working

select d.dept_name from department d where d.dept_id in(
select e.dept_id from employee e
where d.dept_id = e.dept_id);
)

---------------------------------------------------- WINDOW FUNCTIONS -------------------------------------------------------

-- Calculate the Rank of Employee Based on Salary

select empname, dept_name, salary,
       rank() over (partition by dept_name order by salary desc) as rank
from employee
join department on employee.dept_id = department.dept_id;

-- Find the Previous and Next Salaries

select empname, salary,
       lag(salary, 1) over (order by salary desc) as previous_salary,
       lead(salary, 1) over (order by salary desc) as next_salary
from employee;

---------------------------------------------------- INDEX ----------------------------------------------------

-- create index

create index idx_employee_email
on employee (email);

SELECT indexname, indexdef
FROM pg_indexes
WHERE tablename = 'employee';