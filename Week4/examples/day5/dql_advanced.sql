SET SEARCH_PATH TO test2;

SELECT * FROM order_line;
SELECT * FROM order_header;

-- Scalar subquery: customer with highest total line quantity

SELECT c.email 
FROM customer c
WHERE c.customer_id IN (
	SELECT oh.customer_id
	FROM order_line ol
	JOIN order_header oh ON oh.order_id = ol.order_id
	GROUP BY oh.customer_id
	ORDER BY SUM(ol.qty) DESC
);

-- or instead if you want the total quantity returned
SELECT c.email,
	SUM(ol.qty) AS total_qty
FROM customer c
JOIN order_header oh on c.customer_id = oh.customer_id
JOIN order_line ol ON oh.order_id = ol.order_id
GROUP BY c.customer_id
ORDER BY total_qty DESC;

