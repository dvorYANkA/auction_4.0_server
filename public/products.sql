create table products
(
    id          integer not null
        primary key,
    price       integer,
    title       varchar(64),
    description varchar(256),
    categories  varchar(128),
    rating      integer
);

alter table products
    owner to adm;

