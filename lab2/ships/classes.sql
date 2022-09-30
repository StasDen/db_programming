SELECT 
    *
FROM
    ships.classes;
    
-- SELECT #8
SELECT 
    outcomes.ship, ship_class.numGuns, ship_class.displacement
FROM
    (SELECT 
        ships.name, classes.numGuns, classes.displacement
    FROM
        ships
    INNER JOIN classes ON ships.class = classes.class) AS ship_class
        INNER JOIN
    outcomes ON ship_class.name = outcomes.ship
WHERE
    outcomes.battle = 'Guadalcanal';
    