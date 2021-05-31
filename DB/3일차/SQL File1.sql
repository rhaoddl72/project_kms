create database music;

use music;

desc member;

create table singer(
	si_num int auto_increment,
    si_name varchar(50),
    si_start_year int,
    si_agency varchar(30),
	primary key(si_num),
    check(si_start_year >= 0 and si_start_year <= 9999)
);

create table if not exists artist(
	ar_num int auto_increment,
    ar_birth datetime not null,
    ar_agency varchar(30),
    ar_name varchar(50) not null,
    ar_rname varchar(30) not null,
	primary key(ar_num)
);

create table member(
	me_num int auto_increment,
    me_si_num int not null,
    me_ar_num int not null,
    me_position varchar(20),
	primary key(me_num),
    foreign key(me_si_num) references singer(si_num),
    foreign key(me_ar_num) references artist(ar_num)
);

create table if not exists source(
	so_num int auto_increment,
    so_title varchar(50) not null,
    so_lyric longtext not null,
    so_public_day datetime not null,
    so_songwriter varchar(50) not null,
    so_lyricist varchar(50) not null,
	primary key(so_num)
);

create table if not exists sing(
	sn_num int auto_increment,
    sn_so_num int not null,
    sn_si_num int not null,
    sn_featuring char(1) not null,
	primary key(sn_num),
    foreign key(sn_so_num) references `source`(so_num),
    foreign key(sn_si_num) references singer(si_num)
);

create table if not exists album(
	al_num int auto_increment,
    al_title varchar(50) not null,
    al_issue_date date,
	primary key(al_num)
);

create table if not exists issue(
	is_num int auto_increment,
    is_al_num int not null,
    is_si_num int not null ,
	primary key(is_num),
    foreign key(is_al_num) references album(al_num),
    foreign key(is_si_num) references singer(si_num)
);

create table if not exists list(
	li_num int auto_increment,
    li_al_num int not null,
    li_so_num int not null,
    li_main char(1) not null,
	primary key(li_num),
    foreign key(li_al_num) references album(al_num),
    foreign key(li_so_num) references `source`(so_num)
);




