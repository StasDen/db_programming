SELECT 
    *
FROM
    mydb.entertainment_agency;
    
-- SELECT #5
-- Vodafone operator in agencies contact numbers    
SELECT 
    entertainment_agency.name,
    entertainment_agency.contact_number
FROM
    entertainment_agency
WHERE
    entertainment_agency.contact_number LIKE '%0 50%';
    
-- SELECT #6
-- Companies located in Lutsk
SELECT 
    entertainment_agency.name,
    entertainment_agency.address,
    city.name
FROM
    entertainment_agency
        INNER JOIN
    city ON entertainment_agency.city_id = city.id
WHERE
    city.name = 'Lutsk'
