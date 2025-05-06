CREATE EXTENSION vector;
CREATE EXTENSION hstore;

create table item
(
    id         uuid primary key,
    name       varchar(100) not null,
    labels     json,
    embedding  vector,
    price      money,
    tags       text[],
    attributes hstore,
    created_at timestamp    not null default now(),
    updated_at timestamp    not null default now()
);