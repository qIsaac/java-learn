drop table if exists users;
create table users (
  id int ,
  name VARCHAR(20)
);
insert into users(id,name) values (1,'user1');