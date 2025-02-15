create table tb_genre (id bigserial not null, name varchar(255), primary key (id));
create table tb_movie (movie_year integer, genre_id bigint, id bigserial not null, img_url varchar(255), sub_title varchar(255), synopsis TEXT, title varchar(255), primary key (id));
create table tb_review (id bigserial not null, movie_id bigint, user_id bigint, text TEXT, primary key (id));
create table tb_role (id bigserial not null, authority varchar(255), primary key (id));
create table tb_user (id bigserial not null, email varchar(255) unique, name varchar(255), password varchar(255), primary key (id));
create table tb_user_role (role_id bigint not null, user_id bigint not null, primary key (role_id, user_id));
alter table if exists tb_movie add constraint FKsgjdq7d9ajnr85pl4am109qsh foreign key (genre_id) references tb_genre;
alter table if exists tb_review add constraint FKmnmhbadmg8ugakn8q89rh5k3l foreign key (movie_id) references tb_movie;
alter table if exists tb_review add constraint FKqeh83gbufxg1ft0ubwn7w0tty foreign key (user_id) references tb_user;
alter table if exists tb_user_role add constraint FKea2ootw6b6bb0xt3ptl28bymv foreign key (role_id) references tb_role;
alter table if exists tb_user_role add constraint FK7vn3h53d0tqdimm8cp45gc0kl foreign key (user_id) references tb_user;
