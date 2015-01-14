drop table VOUCHER;
drop table CUSTOMER;
drop TABLE CUSTOMER_VOUCHER;

CREATE TABLE VOUCHER (
    VOUCHER_ID INTEGER NOT NULL,
VOUCHER_TEXT VARCHAR(1024),
COMPANY_NAME VARCHAR(256),
FLAG INTEGER NOT NULL,
PRIMARY KEY (VOUCHER_ID)
)


CREATE TABLE CUSTOMER (
	CUSTOMER_ID INTEGER NOT NULL,
	EMAIL VARCHAR(256),
PRIMARY KEY (CUSTOMER_ID)
)


CREATE TABLE CUSTOMER_VOUCHER (
	ID INTEGER NOT NULL,
	CUSTOMER_ID INTEGER,
	VOUCHER_ID INTEGER,
PRIMARY KEY (ID)
)


insert into customer values ('1', 'yan.wang.ch@gmail.com');
insert into customer values ('2', 'yan.wang.geneva@gmail.com');

insert into voucher values ('1', 'code : 0001 - 10%', 'Starbucks', '1');
insert into voucher values ('2', 'code : 0002 - 30%', 'Starbucks', '1');
insert into voucher values ('3', 'code : 0003 - 5%', 'Starbucks', '0');
insert into voucher values ('4', 'code : 0004 - 15%', 'Starbucks', '0');
insert into voucher values ('5', 'code : 0005 - 20%', 'Starbucks', '0');
insert into voucher values ('6', 'code : 000A - 5%', 'Tim Horton', '0');
insert into voucher values ('7', 'code : 000B - 15%', 'Tim Horton', '0');
insert into voucher values ('8', 'code : 000C - 30%', 'Tim Horton', '0');
insert into voucher values ('9', 'code : 000D - 50%', 'Tim Horton', '0');
insert into voucher values ('10', 'code : 000E - 20%', 'Tim Horton', '0');

insert into customer_voucher values('1', '1', '1');
insert into customer_voucher values('2', '2', '2');
