SELECT 
    *
FROM
    mydb.city;
    
-- SELECT #1
-- Cities which located in Lviv region 
SELECT 
    city.name
FROM
    city
        INNER JOIN
    region ON city.region_id = region.id
WHERE
    region.name = 'Lviv';
