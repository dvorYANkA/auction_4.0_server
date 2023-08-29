create table reviews
(
    id         integer not null
        primary key,
    product_id integer,
    timestamp  varchar(64),
    user_name  varchar(64),
    rating     integer,
    comment    varchar(256)
);

alter table reviews
    owner to adm;

