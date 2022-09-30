SELECT 
    *
FROM
    outcomes;

-- SELECT #1 
SELECT 
    *
FROM
    outcomes
WHERE
    battle = 'Guadalcanal'
        AND result != 'sunk'
ORDER BY ship DESC;  
