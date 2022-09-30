SELECT 
    *
FROM
    mydb.order;
 
-- SELECT #10  
-- Average cost of different events
SELECT 
    name AS event, event.cost
FROM
    (SELECT 
        name, AVG(cost_in_usd) AS cost
    FROM
        `order`
    WHERE
        name LIKE '%Birthday%') AS event 
UNION (SELECT 
    name, AVG(cost_in_usd)
FROM
    `order`
WHERE
    name LIKE '%graduation%') UNION (SELECT 
    name, AVG(cost_in_usd)
FROM
    `order`
WHERE
    name LIKE '%Wedding%')
