SET SEARCH_PATH TO test1;

DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS customer CASCADE;

CREATE TABLE customer (
	customer_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	customer_name VARCHAR(100) NOT NULL,
	current_discount_rate NUMERIC(5,2) DEFAULT 0.0,
	discount_updated_at TIMESTAMP
);

CREATE TABLE orders (
	order_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	customer_id INT NOT NULL REFERENCES customer(customer_id) ON DELETE CASCADE,
	order_date DATE NOT NULL DEFAULT CURRENT_DATE,
	total_amount NUMERIC(10,2) NOT NULL CHECK (total_amount>0)
);

INSERT INTO customer(customer_name)
VALUES
('Alice Johnson'),
('Bob Smith'),
('Carol Davis');

INSERT INTO orders(customer_id, total_amount)
VALUES
(1,2500.00),
(1, 3500.00),
(2,5000.00),
(2,7500.00),
(3,300.00),
(3,300.00);

SELECT * FROM orders;
SELECT * FROM customer;
