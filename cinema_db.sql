create table cast_members
(
	id int auto_increment
		primary key,
	name varchar(45) not null,
	surname varchar(45) not null,
	birthday varchar(45) null,
	gender enum('MAN', 'WOMAN') not null,
	type enum('ACTOR', 'DIRECTOR') not null,
	studio varchar(45) null,
	understudy varchar(45) null
)
engine=InnoDB charset=utf8
;

create table cinemas
(
	id int auto_increment
		primary key,
	city varchar(45) not null,
	street varchar(45) not null,
	name varchar(45) not null,
	description varchar(45) null
)
engine=InnoDB charset=utf8
;

create table film_format
(
	id int auto_increment
		primary key,
	format varchar(8) not null
)
engine=InnoDB charset=utf8
;

create table film_genres
(
	id int auto_increment
		primary key,
	genre varchar(45) not null
)
engine=InnoDB charset=utf8
;

create table films
(
	id int auto_increment
		primary key,
	title varchar(20) not null,
	release_date date not null,
	description varchar(300) null,
	country varchar(45) not null
)
engine=InnoDB charset=utf8
;

create table films_has_cast_members
(
	films_id int not null,
	cast_members_id int not null,
	primary key (films_id, cast_members_id),
	constraint FKeqtw3akdtv9rgqs3evfqib78o
		foreign key (films_id) references films (id),
	constraint FKh8a94lwfqxxeceq96ewjee1ax
		foreign key (cast_members_id) references cast_members (id)
)
engine=InnoDB
;

create index FKh8a94lwfqxxeceq96ewjee1ax
	on films_has_cast_members (cast_members_id)
;

create table films_has_film_genres
(
	films_id int not null,
	film_genres_id int not null,
	primary key (films_id, film_genres_id),
	constraint FKdnx52annrtm9m84pht3u4k9gv
		foreign key (films_id) references films (id),
	constraint FKlh4utaq074vxednb9ebhltls3
		foreign key (film_genres_id) references film_genres (id)
)
engine=InnoDB
;

create index FKlh4utaq074vxednb9ebhltls3
	on films_has_film_genres (film_genres_id)
;

create table halls
(
	id int auto_increment
		primary key,
	capacity int not null,
	cinemas_id int not null,
	constraint FKou8ffpji5dira798i18o5fpmn
		foreign key (cinemas_id) references cinemas (id),
	constraint fk_halls_cinemas1
		foreign key (cinemas_id) references cinemas (id)
)
engine=InnoDB charset=utf8
;

create index fk_halls_cinemas1_idx
	on halls (cinemas_id)
;

create table hibernate_sequences
(
	sequence_name varchar(255) not null
		primary key,
	next_val bigint null
)
engine=InnoDB
;

create table seances
(
	id int auto_increment
		primary key,
	date date not null,
	time time not null,
	films_id int not null,
	film_format_id int not null,
	age_limit varchar(10) not null,
	halls_id int not null,
	constraint FKck4umx7to9yjg3il447ld3d4k
		foreign key (films_id) references films (id),
	constraint fk_seances_films1
		foreign key (films_id) references films (id),
	constraint FKcl3k69vqill2clf1jrd215btj
		foreign key (film_format_id) references film_format (id),
	constraint fk_seances_film_format1
		foreign key (film_format_id) references film_format (id),
	constraint FKnwq6xbwil3kv4vsvuou6sx32q
		foreign key (halls_id) references halls (id),
	constraint fk_seances_halls1
		foreign key (halls_id) references halls (id)
)
engine=InnoDB charset=utf8
;

create index fk_seances_films1_idx
	on seances (films_id)
;

create index fk_seances_film_format1_idx
	on seances (film_format_id)
;

create index fk_seances_halls1_idx
	on seances (halls_id)
;

create table tickets
(
	id int auto_increment
		primary key,
	place int not null,
	price float not null,
	seances_id int null,
	users_id int null,
	constraint UK_apmhfqsoercr7hakuxt5371dw
		unique (place),
	constraint FKboa5aogj2m9watvlnupev41cu
		foreign key (seances_id) references seances (id)
)
engine=InnoDB
;

create index FKboa5aogj2m9watvlnupev41cu
	on tickets (seances_id)
;

create index FK384xu0lexsjs1mqhaj0cese1t
	on tickets (users_id)
;

create table users
(
	id int auto_increment
		primary key,
	email varchar(255) null,
	login varchar(255) not null,
	password varchar(255) not null,
	type varchar(255) not null,
	constraint UK_6dotkott2kjsp8vw4d0m25fb7
		unique (email),
	constraint UK_ow0gan20590jrb00upg3va2fn
		unique (login)
)
engine=InnoDB
;

alter table tickets
	add constraint FK384xu0lexsjs1mqhaj0cese1t
		foreign key (users_id) references users (id)
;

INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (1,'564cv6','hyrdcvsr',NULL,'MAN','ACTOR',NULL,'sffdfgfgd');
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (2,'sds','fgdf',NULL,'MAN','DIRECTOR','studio',NULL);
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (3,'gdf','fgdfgfgf',NULL,'MAN','ACTOR',NULL,'yes');
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (4,'sds','fgdf',NULL,'MAN','DIRECTOR','studio',NULL);
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (5,'gdf','fgdfgfgf',NULL,'MAN','ACTOR',NULL,'yes');
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (12,'sds','fgdf',NULL,'MAN','DIRECTOR','studio',NULL);
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (13,'gdf','fgdfgfgf',NULL,'MAN','ACTOR',NULL,'yes');
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (14,'Brad','Pitt','2018-02-10','WOMAN','ACTOR',NULL,'Best one');
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (15,'Angelina','Jolie','2018-02-10','WOMAN','ACTOR',NULL,'Best one');
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (16,'Brad','Pitt','2018-02-10','WOMAN','ACTOR',NULL,NULL);
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (17,'Angelina','Jolie','2018-02-10','WOMAN','DIRECTOR',NULL,NULL);
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (18,'Jason','Woorhis','2018-02-10','MAN','ACTOR',NULL,NULL);
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (19,'Brad','Pitt','2018-02-10','MAN','DIRECTOR',NULL,NULL);
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (20,'Brad','Pitt','2018-02-10','MAN','DIRECTOR','Universal',NULL);
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (21,'Brad','Pitt','2018-02-10','MAN','DIRECTOR','Universal',NULL);
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (23,'Brad','Pitt',NULL,'MAN','DIRECTOR','studioo',NULL);
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (24,'Brad','Pitt',NULL,'MAN','ACTOR',NULL,NULL);
INSERT INTO `cast_members` (`id`,`name`,`surname`,`birthday`,`gender`,`type`,`studio`,`understudy`) VALUES (25,'Brad','Pitt',NULL,'MAN','DIRECTOR',NULL,NULL);
