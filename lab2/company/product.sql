SELECT 
    *
FROM
    firm.product;
    
-- SELECT #3 
SELECT 
    product.maker, product.model, pc.price
FROM
    product
        INNER JOIN
    pc ON product.model = pc.model
WHERE
    product.type = 'PC';
    
-- SELECT #4
SELECT 
    product.maker, product.model
FROM
    product
WHERE
    product.type = 'PC'
        AND product.model NOT IN (SELECT 
            pc.model
        FROM
            pc);

-- SELECT #10
SELECT 
    AVG(prices.price)
FROM
    (SELECT 
        pc.price
    FROM
        pc
    WHERE
        pc.model IN (SELECT 
                product.model
            FROM
                product
            WHERE
                product.maker = 'A'
                    AND product.type = 'PC') UNION ALL SELECT 
        laptop.price
    FROM
        laptop
    WHERE
        laptop.model IN (SELECT 
                product.model
            FROM
                product
            WHERE
                product.maker = 'A'
                    AND product.type = 'Laptop')) AS prices;

-- SELECT #7
SELECT DISTINCT
    product.maker
FROM
    product
WHERE
    product.type = 'PC'
        AND product.maker != (SELECT DISTINCT
            product.maker
        FROM
            product,
            pc
        WHERE
            product.type = 'PC'
        GROUP BY pc.model);
        