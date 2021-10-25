drop database if exists ssafy_testdb;
create database ssafy_testdb;
use ssafy_testdb;

drop table if exists phones;
drop table if exists company;
drop table if exists userinfo;

create table company (
	vcode char(2) primary key,
	vendor  varchar(20) not null
);
insert  into company values('10', '삼성');
insert  into company values('20', '엘지');
insert  into company values('30', '애플');

create table Phones(
	num char(5) primary key,
	model varchar(20) not null,
	price int(6) not null,
	vcode char(2),
   constraint fk_vcode foreign key(vcode) references company(vcode)

);
insert  into Phones values('S105G','겔럭시 S10 5G',1397000,'10');
insert  into Phones values('V50SQ','LG V50S ThinQ',1199000,'20');

create table userinfo (
	id  varchar(20) primary key,
	pw  varchar(20) not null
);
insert  into userinfo values('ssafy','ssafy');
insert  into userinfo values('admin','admin');
commit;