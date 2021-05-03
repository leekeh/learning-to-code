-- 4a
SELECT CustomerName, 
	SUM(ExtendedPrice) AS "Netto verkopen", 
	SUM(Freight) AS "Vrachtkosten"
FROM invoices
WHERE customerID = "QUICK";

-- 4b
SELECT customers.CompanyName, 
	SUM(orders.Freight) AS "Vrachtkosten" 
FROM orders
JOIN customers ON orders.CustomerID = customers.CustomerID
WHERE orders.customerID = "QUICK";

-- 4c
-- invoices laat per product de vrachtprijs zien, terwijl deze per order maar één keer hoeft worden geteld.

-- 5a
SELECT customer.CustomerName, 
	SUM(NettValue)
FROM starschema.factsales
JOIN customer 
	ON factsales.CustomerID = customer.CustomerID
WHERE factsales.CustomerID = "QUICK";

-- 5b
SELECT customer.CustomerName, 
	SUM(FreightCost)
FROM starschema.factshipment
JOIN customer 
	ON factshipment.CustomerID = customer.CustomerID
WHERE factshipment.CustomerID = "QUICK";

-- 5c
SELECT customer.CustomerName, Nverkoop.Netto_Verkopen, Vracht.Vrachtkosten
FROM starschema.customer
JOIN 
	(SELECT factsales.CustomerID, SUM(NettValue) AS "Netto_Verkopen"
	FROM starschema.factsales
	WHERE factsales.CustomerID = "QUICK") 
	AS Nverkoop ON Nverkoop.CustomerID = customer.CustomerID
JOIN 
	(SELECT factshipment.CustomerID, SUM(FreightCost) AS "Vrachtkosten"
	FROM starschema.factshipment
	WHERE factshipment.CustomerID= "QUICK")
	AS Vracht ON Vracht.CustomerID = customer.CustomerID
	;

-- 6
-- find winning salesman
SELECT salesman.LastName, 
	SUM(factsales.GrossValue) 
FROM factsales
JOIN customer 
	ON customer.CustomerID = factsales.CustomerID
JOIN product 
	ON product.ProductID = factsales.ProductID
JOIN salesman 
	ON factsales.SalesmanID = salesman.SalesmanID
WHERE product.Origin = "Europa" 
	&& customer.CustomerCountry = "USA" 
	&& YEAR(factsales.OrderDate) = 1997
GROUP BY factsales.SalesmanID
ORDER BY SUM(GrossValue) desc
LIMIT 1;

-- show products
SELECT salesman.LastName, 
	product.ProductName, 
	sum(factsales.GrossValue)
FROM factsales
JOIN product 
	ON product.ProductID = factsales.ProductID
JOIN salesman 
	ON factsales.SalesmanID = salesman.SalesmanID
JOIN customer 
	ON customer.CustomerID = factsales.CustomerID
WHERE factsales.SalesmanID= 1 
	&& product.Origin = "Europa" 
	&& customer.CustomerCountry = "USA" 
	&& YEAR(factsales.OrderDate) = 1997
GROUP BY factsales.ProductID
ORDER BY sum(factsales.GrossValue) DESC

-- together v1

SELECT salesman.LastName, 
	product.ProductName, 
	sum(factsales.GrossValue)
FROM factsales
JOIN product 
	ON product.ProductID = factsales.ProductID
JOIN salesman 
	ON factsales.SalesmanID = salesman.SalesmanID
JOIN customer 
	ON customer.CustomerID = factsales.CustomerID
WHERE product.Origin = "Europa" 
	&& customer.CustomerCountry = "USA" 
	&& YEAR(factsales.OrderDate) = 1997 
	&& factsales.SalesmanID = 
		(SELECT factsales.SalesmanID
		FROM factsales
		JOIN customer ON customer.CustomerID = factsales.CustomerID
		JOIN product ON product.ProductID = factsales.ProductID
		JOIN salesman ON factsales.SalesmanID = salesman.SalesmanID
		WHERE product.Origin = "Europa" && customer.CustomerCountry = "USA" && YEAR(factsales.OrderDate) = 1997
		GROUP BY factsales.SalesmanID
		ORDER BY SUM(GrossValue) desc
		LIMIT 1)
GROUP BY factsales.ProductID
ORDER BY sum(factsales.GrossValue) DESC
