use ssafyws;

drop table if exists emp;
create table if not exists emp (
  num    int primary key,
  name   varchar(20) not null,
  salary  int
);

insert into emp values (101, '홍길동', 1000),(102, '손오공', 2000),
   (103, '홍길순', 3000),(104, '사오정', 4000),(105, '저팔계', 5000);
-- commit;

select * from emp;