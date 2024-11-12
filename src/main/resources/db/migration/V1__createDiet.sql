create table if not exists diet(
    id serial not null primary key,
    start_date timestamp,
    end_date timestamp
);