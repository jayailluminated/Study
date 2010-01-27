-- Database: postgres

drop table member;
create table member (
    username varchar(80),
    password varchar(80),
    regist_date timestamp DEFAULT current_timestamp,
    CONSTRAINT username_pk PRIMARY KEY(username)
);

insert into member values('test', 'test');
--delete from member;
select * from member;

alter user postgres with password 'postgres';