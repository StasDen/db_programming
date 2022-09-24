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
    battle = 'Guadalcanal' AND result = 'OK'
ORDER BY ship ASC;  
