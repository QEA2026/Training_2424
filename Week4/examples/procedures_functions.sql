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
	customer_id INT NOT NULL REFERENCES customer(customer_id),
	order_date DATE NOT NULL DEFAULT CURRENT_DATE,
	total_amount NUMERIC(10,2) NOT NULL CHECK (total_amount>0)
);

