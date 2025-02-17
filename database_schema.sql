create database qnrprojectdb;
use qnrprojectdb;

create table users (
    user_id bigint auto_increment primary key,
    username varchar(50) unique not null,
    password varchar(255) not null,
    email varchar(50) unique not null
);

create table orders (
    order_id bigint auto_increment primary key,
    user_id bigint references users(user_id) on delete cascade,
    order_date timestamp default current_timestamp,
    total_amount decimal(10, 2) not null default 0.00
);

create table order_items (
    id bigint auto_increment primary key,
    order_id bigint references orders(order_id) on delete cascade,
    item_name varchar(100) not null,
    quantity int not null,
    price decimal(10, 2) not null,
    total decimal(10, 2) not null default 0.00
);

-- Trigger function to calculate the total for each item in 'order_items'
delimiter $$
create trigger calculate_item_total before insert on order_items
for each row
begin
    set new.total = new.quantity * new.price;
end $$
delimiter ;

-- Trigger function to calculate the total amount of an order in 'orders'
delimiter $$
create trigger calculate_order_total after insert on order_items
for each row
begin
    update orders
    set total_amount = (select coalesce(sum(total), 0) from order_items where order_id = new.order_id)
    where order_id = new.order_id;
end $$
delimiter ;

insert into users (username, password, email) values
('valia', '1234', 'valia1@example.com'),
('evangelia', '2345', 'evangelia@example.com'),
('sdoukou', '3456', 'sdoukou@example.com');

insert into orders (user_id) values
(1),
(2),
(3);

insert into order_items (order_id, item_name, quantity, price) values
(1, 'Apples', 3, 2.50), 
(1, 'Milk', 1, 1.80), 
(2, 'Bananas', 2, 1.20), 
(2, 'Bread', 1, 2.00), 
(3, 'Eggs', 2, 3.50);
