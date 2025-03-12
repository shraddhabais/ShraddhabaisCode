-- Insert Customers
INSERT INTO CUSTOMER (id, name) VALUES (1, 'Jonny');
INSERT INTO CUSTOMER (id, name) VALUES (2, 'Ronny');
INSERT INTO CUSTOMER (id, name) VALUES (3, 'Bobby');

-- Insert Transactions
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (1, 1, 120.50, '2024-12-01');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (2, 1, 75.00, '2024-11-10');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (3, 2, 200.00, '2024-12-15');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (4, 2, 50.00, '2025-01-20');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (5, 3, 130.00, '2024-12-05');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (6, 3, 95.00, '2025-01-15');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (7, 1, 130.00, '2024-10-01');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (8, 1, 100.00, '2025-02-10');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (9, 1, 200.00, '2025-01-01');
INSERT INTO TRANSACTION (id, customer_id, amount, transaction_date) VALUES (10, 3, 70.00, '2025-02-01');


