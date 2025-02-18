CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL, 
    created_at timestamp default current_timestamp
);

CREATE TABLE customers (
    customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE orders (
    order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE order_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    item_name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    total DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE
);

-- Trigger function to calculate the total for each item in 'order_items'
DELIMITER $$
CREATE TRIGGER calculate_item_total BEFORE INSERT ON order_items
FOR EACH ROW
BEGIN
    SET NEW.total = NEW.quantity * NEW.price;
END $$

DELIMITER ;

-- Trigger function to calculate the total amount of an order in 'orders'
DELIMITER $$
CREATE TRIGGER calculate_order_total AFTER INSERT ON order_items
FOR EACH ROW
BEGIN
    UPDATE orders
    SET total_amount = (SELECT COALESCE(SUM(total), 0) FROM order_items WHERE order_id = NEW.order_id)
    WHERE order_id = NEW.order_id;
END $$

DELIMITER ;

INSERT INTO users (username, password, email) VALUES
('valia', '1234', 'valia1@example.com'),
('evangelia', '2345', 'evangelia@example.com'),
('sdoukou', '3456', 'sdoukou@example.com');

INSERT INTO customers (firstname, lastname, user_id, created_at) VALUES
('Valia', 'Sdoukou', 1, NOW()),
('Evangelia', 'Sdoukou', 2, NOW()),
('Sdoukou', 'Sdoukou', 3, NOW());

INSERT INTO orders (user_id, created_at) VALUES
(1, NOW()),
(2, NOW()),
(3, NOW());

INSERT INTO order_items (order_id, item_name, quantity, price, created_at) VALUES
(1, 'Apples', 3, 2.50, NOW()), 
(1, 'Milk', 1, 1.80, NOW()), 
(2, 'Bananas', 2, 1.20, NOW()), 
(2, 'Bread', 1, 2.00, NOW()), 
(3, 'Eggs', 2, 3.50, NOW());

