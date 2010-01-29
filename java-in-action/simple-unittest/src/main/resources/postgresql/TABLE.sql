-- Database: postgres
-- referer : http://www.google.com/codesearch/p?hl=ja#xGMH5KcOIIs/trunk/install/COUNTRY.sql&q=address%20lang:sql&d=1

drop table if exists address cascade;
drop table if exists member cascade;


create table address (
     address_id serial4 primary key,
     street text,
     zipcode text,
     city text,
     country text
--     CONSTRAINT address_id_pk PRIMARY KEY(address_id)
);

create table member (
    user_id serial4 primary key,
    user_name text,
    password text,
    address_id integer references address(address_id),
    regist_date timestamp DEFAULT current_timestamp
--    CONSTRAINT user_id_pk PRIMARY KEY(user_id),
--    FOREIGN KEY (address_id) REFERENCES address (address_id)
);





INSERT INTO ADDRESS(street, zipcode, city, country) VALUES ('Rheingutstrasse 40', '78462', 'Konstanz', 'DE');
INSERT INTO ADDRESS(street, zipcode, city, country) VALUES ('Brauneggerstrasse 55', '78462', 'Konstanz', 'DE');
INSERT INTO ADDRESS(street, zipcode, city, country) VALUES ('Batman Street 3', '12W12S', 'London', 'GB');
INSERT INTO ADDRESS(street, zipcode, city, country) VALUES ('Super Street 4', '15937', 'Metropolis', 'US');
INSERT INTO ADDRESS(street, zipcode, city, country) VALUES ('Spider 5', '75100', 'Paris', 'FR');
INSERT INTO ADDRESS(street, zipcode, city, country) VALUES ('Bergstrasse 6', '8050', 'Z rich', 'CH');
INSERT INTO ADDRESS(street, zipcode, city, country) VALUES ('Bl mchengasse 7', '10100', 'Berlin', 'DE');
INSERT INTO ADDRESS(street, zipcode, city, country) VALUES ('Brauneggerstrasse 55 W', 'D-78462', 'Konstanz', 'DE');
INSERT INTO ADDRESS(street, zipcode, city, country) VALUES ('Rheingutstrasse User 1', '78462', 'Konstanz', 'DE');
INSERT INTO ADDRESS(street, zipcode, city, country) VALUES ('Rheingutstrasse Supplier 1', '78462', 'Konstanz', 'DE');
INSERT INTO ADDRESS(street, zipcode, city, country) VALUES ('Rheingutstrasse User 2', '78462', 'Konstanz', 'DE');
INSERT INTO ADDRESS(street, zipcode, city, country) VALUES ('Rheingutstrasse Supplier 2', '78462', 'Konstanz', 'DE');




INSERT INTO MEMBER(user_name, password, address_id) VALUES('test1', 'test', 1);
INSERT INTO MEMBER(user_name, password, address_id) VALUES('test1', 'test', 1);
INSERT INTO MEMBER(user_name, password, address_id) VALUES('test1', 'test', 1);
INSERT INTO MEMBER(user_name, password, address_id) VALUES('test1', 'test', 2);
INSERT INTO MEMBER(user_name, password, address_id) VALUES('test1', 'test', 2);
INSERT INTO MEMBER(user_name, password, address_id) VALUES('test1', 'test', 2);
INSERT INTO MEMBER(user_name, password, address_id) VALUES('test1', 'test', 3);
INSERT INTO MEMBER(user_name, password, address_id) VALUES('test1', 'test', 3);
INSERT INTO MEMBER(user_name, password, address_id) VALUES('test1', 'test', 4);


COMMIT;


--delete from member;
select * from member;
select * from address;

--alter user postgres with password 'postgres';