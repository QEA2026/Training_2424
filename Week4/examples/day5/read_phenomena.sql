SET SEARCH_PATH TO test2;

DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
	account_id INT PRIMARY KEY,
	customer_name VARCHAR(50),
	balance DECIMAL(10,2)
);

INSERT INTO accounts VALUES
(1,'Alice',1000),
(2,'Bob',500),
(3,'Charlie',700);