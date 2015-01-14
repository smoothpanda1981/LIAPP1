CREATE TABLE VOUCHER (
    VOUCHER_ID INTEGER NOT NULL,
VOUCHER_TEXT VARCHAR(1024),
COMPANY_NAME VARCHAR(256),
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

insert into voucher values ('1', 'code : 0001 - 10%', 'Starbucks');
insert into voucher values ('2', 'code : 0002 - 30%', 'Starbucks');
insert into voucher values ('3', 'code : 0003 - 5%', 'Starbucks');
insert into voucher values ('4', 'code : 0004 - 15%', 'Starbucks');
insert into voucher values ('5', 'code : 0005 - 20%', 'Starbucks');
insert into voucher values ('6', 'code : 000A - 5%', 'Tim Horton');
insert into voucher values ('7', 'code : 000B - 15%', 'Tim Horton');
insert into voucher values ('8', 'code : 000C - 30%', 'Tim Horton');
insert into voucher values ('9', 'code : 000D - 50%', 'Tim Horton');
insert into voucher values ('10', 'code : 000E - 20%', 'Tim Horton');

insert into customer_voucher values('1', '1', '1');
insert into customer_voucher values('2', '1', '3');
insert into customer_voucher values('3', '1', '5');
insert into customer_voucher values('4', '1', '7');
insert into customer_voucher values('5', '1', '9');
insert into customer_voucher values('6', '2', '2');
insert into customer_voucher values('7', '2', '4');
insert into customer_voucher values('8', '2', '6');
insert into customer_voucher values('9', '2', '8');
insert into customer_voucher values('10', '2', '10');
