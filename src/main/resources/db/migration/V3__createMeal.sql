create table if not exists meal(
    id serial not null primary key,
    id_diet int not null,
    id_dish int not null,
    name varchar(10),
    moment varchar(20),
    meal_order int
);

alter table if exists meal
    add constraint fk_meal_diet
    foreign key (id_diet)
    references diet(id);

alter table if exists meal
    add constraint fk_meal_dish
    foreign key (id_dish)
    references dish(id);