SELECT 
    *
FROM
    mydb.event;
   
-- SELECT #7
-- Checking how many animators and visitors on the event     
SELECT 
    event.name, event.date, event.address
FROM
    event
WHERE
    event.animators_num = 1
        AND event.visitors_num > 20
ORDER BY event.name ASC;

-- SELECT #8
-- Events held in summer 
SELECT 
    event.name
FROM
    event
WHERE
    event.date LIKE '2022-06%'
        OR event.date LIKE '2022-07%'
        OR event.date LIKE '2022-08%'
