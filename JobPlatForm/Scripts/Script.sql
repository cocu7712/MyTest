Create table Member (
       	mEmail varchar(40) primary key,
       	PW varchar(30) not null,
       	Sex varchar(10) not null,
       	Birth date not null,
       	Name varchar(20) not null,
       	Phone varchar(20) not null,
       	RoadAddr varchar(100) not null,
	 AddrDetail varchar(100) not null,
       	Sysdate timestamp default now()
) ENGINE = innoDB;



Create table Self_intro (
       	introNo int auto_increment primary key,
       	mEmail varchar(40) not null,
	title varchar(100) not null,
       	Intro_text1 varchar(1000),
       	Intro_text2 varchar(1000),
       	Intro_text3 varchar(1000),
       	Intro_text4 varchar(1000) 
) ENGINE = innoDB;

alter table self_intro add foreign key(mEmail) references member(mEmail) on delete cascade;



 Create table myImg (
       	mEmail  varchar(40) not null,
       	Res_img varchar(200) not null
) ENGINE = innoDB;



Create table school (
	No int auto_increment primary key,
       	mEmail  varchar(40) not null,
       	school varchar(30) not null,
       	schoolDetail varchar(30) not null,
       	Admission varchar(30) not null,
       	Graduated varchar(30) not null
) ENGINE = innoDB;


Create table certificate (
	No int auto_increment primary key,
       	mEmail  varchar(40) not null,
       	certificate varchar(30) not null,
       	Issuer varchar(30) not null,
       	getDate varchar(30) not null
) ENGINE = innoDB;


Create table career(
	No int auto_increment primary key,
       	mEmail  varchar(40) not null,
       	position varchar(30) not null,
       	company varchar(30) not null,
       	startDate varchar(30) not null,
       	endDate varchar(30)
) ENGINE = innoDB;


drop table myImg;
drop table school;
drop table certificate;
drop table career;
drop table self_intro;
drop table member;

alter table myImg add foreign key(mEmail) references member(mEmail) on delete cascade;
 alter table school add foreign key(mEmail) references member(mEmail) on delete cascade;
 alter table certificate add foreign key(mEmail) references member(mEmail) on delete cascade;
 alter table career add foreign key(mEmail) references member(mEmail) on delete cascade;


drop table resume ;

insert into member values(	'test01',	'1111',	'남',	'2021-05-01',	'test1',	'010-1111-1111',	'관악구',	'행운 5길',	now());
insert into member values(	'test02',	'1112',	'남',	'2021-05-02',	'test2',	'010-1111-1112',	'관악구',	'행운 6길',	now());
insert into member values(	'test03',	'1113',	'남',	'2021-05-03',	'test3',	'010-1111-1113',	'관악구',	'행운 7길',	now());
insert into member values(	'test04',	'1114',	'남',	'2021-05-04',	'test4',	'010-1111-1114',	'관악구',	'행운 8길',	now());
insert into member values(	'test05',	'1115',	'남',	'2021-05-05',	'test5',	'010-1111-1115',	'관악구',	'행운 9길',	now());
insert into member values(	'test06',	'1116',	'여',	'2021-05-06',	'test6',	'010-1111-1116',	'관악구',	'행운 10길',	now());
insert into member values(	'test07',	'1117',	'여',	'2021-05-07',	'test7',	'010-1111-1117',	'관악구',	'행운 11길',	now());
insert into member values(	'test08',	'1118',	'여',	'2021-05-08',	'test8',	'010-1111-1118',	'관악구',	'행운 12길',	now());
insert into member values(	'test09',	'1119',	'여',	'2021-05-09',	'test9',	'010-1111-1119',	'관악구',	'행운 13길',	now());
insert into member values(	'test10',	'1120',	'여',	'2021-05-10',	'test10',	'010-1111-1120',	'관악구',	'행운 14길',	now());

drop table recruit;
drop table applycom;
drop table tag;

alter table self_intro add foreign key(id) references member(id) on delete cascade;

alter table self_intro add title varchar(100) not null;

delete from school where schoolDitail = '1';

/* 다른 사람 테이블*/

Create table IntrstCom (
       	ID varchar(20) primary key,
       	NO int not null
) ENGINE = innoDB;

create table applycom(
	NO int not null,
    	introNo int not null,
    Foreign Key(NO) references recruit(NO),
    Foreign Key(introNo) references Self_Intro(introNo)
);

Create table Company (
       	cEmail varchar(40) not null primary key,
       	PW varchar(20) not null,
       	comName varchar(50) not null unique,
       	RoadAddr varchar(100) not null,
		AddrDetail varchar(100) not null,
       	tel varchar(30) not null,
       	img varchar(200) not null,
       	appr varchar(20) not null,
       	sysdate timestamp default now()
) ENGINE = innoDB;

create table recruit(
		NO int primary key,
       	comName varchar(50) not null,
       	Category varchar(20) not null,
        career varchar(20) not null,
        title varchar(200) not null,
       	Text1 varchar(200) not null,
       	Text2 varchar(200) not null,
       	Text3 varchar(200) not null,
       	Text4 varchar(200) not null,
       	Text5 varchar(200) not null,
        Foreign Key(comName) references company(comName)
);

create table Tag(
	No int not null,
Tag varchar(20)
) ENGINE = innoDB;

 CREATE TABLE seq_mysql(
     id INT NOT NULL, 
     seq_name VARCHAR(50) NOT NULL
 );
use JobPlatForm;

DELIMITER $$
CREATE FUNCTION get_seq (p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE seq_mysql SET id = LAST_INSERT_ID(id+1) 
 WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
end $$
DELIMITER ;

INSERT INTO seq_mysql
VALUES (0, 'NO_SEQ');

select get_seq('NO_SEQ');



