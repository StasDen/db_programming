SELECT 
    *
FROM
    ships.ships;

-- SELECT #2
SELECT 
    name, launched
FROM
    ships
WHERE
    name NOT LIKE '%a';

-- SELECT #5
SELECT 
    ships.name, ships.launched, classes.displacement
FROM
    ships
        INNER JOIN
    classes ON ships.class = classes.class
WHERE
    launched >= 1922
        AND displacement > 35000
