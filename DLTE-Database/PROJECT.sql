--Table BANK--
create table bank_project (bank_id int not null, bank_name varchar(255) not null, bank_address varchar(255) not null);
create sequence bank_id_seq start with 1001 increment by 1;
alter table bank_project add constraint bank_id_seq primary key(bank_id);

--Tbale BRANCH--
create table branch_project(branch_id int not null, branch_name varchar(255) not null,branch_loc varchar(255) not null, branch_address varchar(255) not null,branch_ifsc varchar(255) not null); 
create sequence branch_seq start with 100 increment by 1;
alter table branch_project add constraint branch_seq primary key(branch_id);


--Table ROLE--
create table role(role_id int not null, role_name varchar(255) not null,role_decription varchar(255) not null,role_status varchar(255) not null, branch_id varchar(255) not null); 
create sequence role_seq start with 100 increment by 1;
alter table role add constraint role_seq primary key(role_id);
alter table role add foreign key(branch_id) references branch_project(branch_id);



--Table ADMIN loans--
create table admin_loan(loan_id int not null, loan_type varchar(255) not null,loan_name varchar(255) not null,loan_desc varchar(255) not null, loan_roi float not null, loan_duration int not null); 

--Table CUSTOMER--
create table customer_project(cust_id int not null,cust_name varchar(255) not null,cust_address varchar(255) not null, cust_status varchar(255) not null, cust_contact int not null,branch_id int not null); 
create sequence cus_seq start with 100 increment by 1;
alter table customer_project add constraint cus_seq primary key(cust_id);
alter table customer_project add foreign key(branch_id) references branch_project(branch_id);




--Table PROIFLES--
create table profile_project(profile_id int not null,profile_pan varchar(255) not null,profile_aadhar int not null, profile_status varchar(255) not null, cust_id int not null); 
alter table profile_project add constraint pro_seq primary key(profile_id);
alter table profile_project add foreign key(cust_id) references customer_project(cust_id);



--Table Account--
create table account_project(acc_id int not null,acc_type varchar(255) not null,acc_num int not null, avail_bal int not null,acc_status varchar(255) not null, cust_id int not null); 
alter table account_project add constraint acc_seq primary key(acc_id);
alter table account_project add foreign key(cust_id) references customer_project(cust_id);



--Table TRANSACTION--
create table transaction_project(trans_id int not null,trans_type varchar(255) not null,trans_from int not null,trans_to int not null,trans_amt int not null, trasns_status varchar(255) not null, trans_date DATE
not null,acc_id int not null); 
alter table transaction_project add constraint tran_seq primary key(trans_id);
alter table  transaction_project add foreign key(acc_id) references account_project(acc_id);



--Table PAYEE--
create table payee_project(payee_id int not null,payee_name varchar(255) not null,acc_num int not null,cust_id int not null);
alter table payee_project add constraint pay_seq primary key(payee_id);
alter table payee_project add foreign key(cust_id) references customer_project(cust_id);



--Table Loan-project--
create table loan_project(loanApp_id int not null, loan_type varchar(255) not null,loan_name varchar(255) not null,loan_desc varchar(255) not null, loan_amt int not null, loan_emi int not null,cust_id int not null); 
alter table loan_project add constraint loa_seq primary key(loanApp_id);
alter table  loan_project add foreign key(cust_id) references customer_project(cust_id);


