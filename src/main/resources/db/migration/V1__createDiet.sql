create table if not exists diet(
    id serial not null primary key,
    start_date timestamp not null,
    end_date timestamp
);