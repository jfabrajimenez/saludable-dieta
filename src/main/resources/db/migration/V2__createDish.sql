create table if not exists dish(
    id serial not null primary key,
    name varchar(1000) not null,
    constraint uk_dish_name
        unique(name)
);
