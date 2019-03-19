	
create table users(
username varchar(50) not null primary key,
password varchar(100) not null,
enabled boolean not null
);
create table authorities (
username varchar(50) not null,
authority varchar(50) not null,
constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);
	
		
insert into users(username,password,enabled)
values('admin','$2a$10$PrGxSU.JUw.q8abZbY7pD.D3Y38SBZ7CZbxolgK9lTa6xytJTQChi',true);

insert into authorities(username,authority) 
values('admin','ROLE_ADMIN');
	
insert into users(username,password,enabled)
values('user','$2a$10$wYoprcmE8lyl4znbHyXqsu7v4KbJUdIOmTmukULngoLBMD646kBKy',true);

insert into authorities(username,authority) 
values('user','ROLE_USER');
