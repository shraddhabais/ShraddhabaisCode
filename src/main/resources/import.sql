-- Drop tables if they exist (to avoid conflicts)
DROP TABLE IF EXISTS TRANSACTION;
DROP TABLE IF EXISTS CUSTOMER;

-- Create CUSTOMER table
CREATE TABLE CUSTOMER (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- Create TRANSACTION table
CREATE TABLE TRANSACTION (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id)
);
-- Insert Customers
INSERT INTO CUSTOMER (id, name) VALUES (1, 'John Doe');
INSERT INTO CUSTOMER (id, name) VALUES (2, 'Jane Smith');

-- Insert Transactions
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (1, 1, 120.50, '2024-12-01 10:15:00');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (2, 1, 75.00, '2024-12-05 14:30:00');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (3, 2, 200.00, '2024-12-10 09:00:00');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (4, 2, 50.00, '2024-12-12 11:45:00');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (5, 1, 30.00, '2024-12-15 16:20:00');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (6, 2, 90.00, '2024-12-18 18:10:00');
