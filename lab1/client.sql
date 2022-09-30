SELECT 
    *
FROM
    mydb.client;
    
-- SELECT #2
-- Clients who own "Gold customer" card      
SELECT 
    client.second_name, client.phone_number
FROM
    client
        INNER JOIN
    client_card ON client.client_card_id = client_card.id
WHERE
    client_card.name = 'Gold customer';
