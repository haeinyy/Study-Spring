drop schema if exists ssafymv;
create schema if not exists ssafymv 
  default character set utf8mb4 collate utf8mb4_0900_as_cs;
use ssafymv;
drop table if exists user;
create table if not exists user(
  id varchar(10) primary key, # 사용자 ID
  pass varchar(10) not null,  # 사용자 비밀번호
  name varchar(20) not null      # 사용자 명
);
drop table if exists type;
create table if not exists type(
  no char(2) primary key,      # 타입 코드
  name varchar(10) not null   # 타입 명
);
drop table if exists movie;
create table if not exists movie(
  code char(3)  primary key,  # 코드
  title varchar(20) not null, # 이름
  price int not null,         # 가격
  no char(2),                 # 타입
  foreign key(no) references type(no)
);
insert into user values ('ssafy','ssafy','오싸피');
insert into type values ('co','코미디'),('sf','판타지'),('dr','드라마');
insert into movie values ('101','기생충',9000,'co'),
                         ('102','승리호',6000,'sf'),
                         ('103','미나리',7000,'dr');                  
commit;