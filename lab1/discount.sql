SELECT 
    *
FROM
    mydb.discount;
    
-- SELECT #4
-- Commentaries for better reading      
SELECT 
    CONCAT('event: ', discount.name) AS event,
    CONCAT('discount: ', discount.percentage, '%') AS discount
FROM
    discount
