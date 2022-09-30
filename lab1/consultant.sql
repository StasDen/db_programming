SELECT 
    *
FROM
    mydb.consultant;
    
-- SELECT #3
-- Consultants who work in "Your Best Party Ever" company 
SELECT 
    consultant.first_name,
    consultant.second_name,
    entertainment_agency.name
FROM
    consultant
        INNER JOIN
    entertainment_agency ON consultant.entertainment_agency_id = entertainment_agency.id
WHERE
    entertainment_agency.name = 'Your Best Party Ever'
