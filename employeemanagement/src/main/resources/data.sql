insert into department(branch,dept_name) values('Chennai','Sales');
insert into department(branch,dept_name) values('Hyderabad','HR');
insert into department(branch,dept_name) values('Chennai','Marketing');
insert into department(branch,dept_name) values('Delhi','Delievery');
insert into department(branch,dept_name) values('Mumbai','Payroll');

insert into designation(designation_name) values('Salesman');
insert into designation(designation_name) values('Manager');
insert into designation(designation_name) values('CEO');
insert into designation(designation_name) values('Security');
insert into designation(designation_name) values('Assistant');

insert into employee(hire_date,hire_manager,status,department_id,last_updated) values(now(),5,'Active',5,now());
insert into employee(hire_date,hire_manager,status,department_id,last_updated) values(now(),4,'Active',3,now());
insert into employee(hire_date,hire_manager,status,department_id,last_updated) values(now(),2,'Active',4,now());
insert into employee(hire_date,hire_manager,status,department_id,last_updated) values(now(),3,'Active',2,now());
insert into employee(hire_date,hire_manager,status,department_id,last_updated) values(now(),1,'Active',1,now());
insert into employee(hire_date,hire_manager,status,department_id,last_updated) values(now(),2,'Active',5,now());
insert into employee(hire_date,hire_manager,status,department_id,last_updated) values(now(),4,'Active',1,now());

insert into employee_personal_details(email_address,first_name,last_name,mobile_number,employee_id,designation_id) values ('abcd@gmail.com','sahithi','bellam','9324325879',1,1);
insert into employee_personal_details(email_address,first_name,last_name,mobile_number,employee_id,designation_id) values ('cde@gmail.com','Revanth','bellam','9068709045',2,2);
insert into employee_personal_details(email_address,first_name,last_name,mobile_number,employee_id,designation_id) values ('der@gmail.com','yoshitha','gandham','9087698599',3,3);
insert into employee_personal_details(email_address,first_name,last_name,mobile_number,employee_id,designation_id) values ('sdgf@gmail.com','sunitha','avvuri','8967069000',4,2);
insert into employee_personal_details(email_address,first_name,last_name,mobile_number,employee_id,designation_id) values ('dsgsdggmail.com','mahi','nelluri','6579057899',5,4);
insert into employee_personal_details(email_address,first_name,last_name,mobile_number,employee_id,designation_id)values ('safs@gmail.com','nikhil','nelluri','7908698990',6,5);
insert into employee_personal_details(email_address,first_name,last_name,mobile_number,employee_id,designation_id) values ('fdgdfgdf@gmail.com','sumit','bellam','7850835899',7,1);

insert into employee_payroll_details(account_number,account_status,bank_code,bank_name,employee_id)
values (859749,'Active','S589680','Bank of America',1);
insert into employee_payroll_details(account_number,account_status,bank_code,bank_name,employee_id)
values (596450,'Active','BD38589','Bank of Baroda',2);
insert into employee_payroll_details(account_number,account_status,bank_code,bank_name,employee_id)
values (456565,'Active','VDD325','Bank of America',3);
insert into employee_payroll_details(account_number,account_status,bank_code,bank_name,employee_id)
values (575756,'Active','VD345345','Bank of Mumbai',4);
insert into employee_payroll_details(account_number,account_status,bank_code,bank_name,employee_id)
values (5744545,'Active','DD34545','Bank of Baroda',5);
insert into employee_payroll_details(account_number,account_status,bank_code,bank_name,employee_id)
values (456456,'Active','ED342423','Bank of Nyka',6);
insert into employee_payroll_details(account_number,account_status,bank_code,bank_name,employee_id)
values (4564565,'Active','FD4363','Bank of Nivia',7);

insert into employee_passport_details(passport_number,valid_from,valid_to,employee_id)
values ('FF325903',	'2000-08-19','2020-08-19',1);
insert into employee_passport_details(passport_number,valid_from,valid_to,employee_id)
values ('VFD45334','2000-08-19','2022-08-19',2);
insert into employee_passport_details(passport_number,valid_from,valid_to,employee_id)
values ('DEE43534','2000-08-19','2023-08-19',3);
insert into employee_passport_details(passport_number,valid_from,valid_to,employee_id)
values ('VD46456','1997-08-19','2024-08-19',4);
insert into employee_passport_details(passport_number,valid_from,valid_to,employee_id)
values ('V34535','2000-08-19','2009-08-19',5);
insert into employee_passport_details(passport_number,valid_from,valid_to,employee_id)
values ('GF56456','2005-08-19','2025-08-19',6);
insert into employee_passport_details(passport_number,valid_from,valid_to,employee_id)
values ('VV43645','2000-08-19','2034-08-19',7);

insert into employee_address(city,line1,line2,zip_code,employee_id)
values ('Mumbai','abcd','sfs',468944,1);
insert into employee_address(city,line1,line2,zip_code,employee_id)
values ('Mumbai','sdgfd','gdfsfd',4645,2);
insert into employee_address(city,line1,line2,zip_code,employee_id)
values ('Mumbai','dgdfgdfg','dfgdfgd',45345,3);
insert into employee_address(city,line1,line2,zip_code,employee_id)
values ('Mumbai','dgdg','dgddf',7876,4);
insert into employee_address(city,line1,line2,zip_code,employee_id)
values ('Mumbai','sdgfsdg','gdfg',68672,5);
insert into employee_address(city,line1,line2,zip_code,employee_id)
values ('Mumbai','sdfsd','dfgdgd',23426,6);
insert into employee_address(city,line1,line2,zip_code,employee_id)
values ('Mumbai','dsgsd','sdggsd',46433,7);
