--Table BANK--
create table bank_project (bank_id int not null, bank_name varchar(255) not null, bank_address varchar(255) not null);
create sequence bank_id_seq start with 1001 increment by 1;
alter table bank_project add constraint bank_id_seq primary key(bank_id);

--Tbale BRANCH--
create table branch_project(branch_id int not null, branch_name varchar(255) not null,branch_loc varchar(255) not null, branch_address varchar(255) not null,branch_ifsc varchar(255) not null); 


--Table ROLE--
create table role(role_id int not null, role_name varchar(255) not null,role_decription varchar(255) not null,role_status varchar(255) not null, branch_id varchar(255) not null); 


--Table loans--
create table loan_project(loan_id int not null, loan_type varchar(255) not null,loan_name varchar(255) not null,loan_desc varchar(255) not null, loan_roi float not null, loan_duration int not null); 

--Table CUSTOMER--
create table customer_project(cust_id int not null,cust_name varchar(255) not null,cust_address varchar(255) not null, cust_status varchar(255) not null, cust_contact int not null); 


--Table PROIFLES--
create table profile_project(profile_id int not null,profile_pan varchar(255) not null,profile_aadhar int not null, profile_status varchar(255) not null, cust_id int not null); 

--Table Account--
create table account_project(acc_id int not null,acc_type varchar(255) not null,acc_num int not null, avail_bal int not null,acc_status varchar(255) not null, cust_id int not null); 


--Table TRANSACTION--
create table transaction_project(trans_id int not null,trans_type varchar(255) not null,trans_from int not null,trans_to int not null,trans_amt int not null, trasns_status varchar(255) not null, trans_date DATE
not null); 

--Table PAYEE--
create table payee_project(payee_id int not null,payee_name varchar(255) not null,payee_address varchar(255) not null,payee_status varchar(255) not null, payee_contact int not null);  
