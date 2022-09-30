SELECT 
    *
FROM
    mydb.party_animator;
   
-- SELECT #9
-- Animators who do unique perfomances      
SELECT 
    party_animator.first_name,
    party_animator.last_name,
    party_animator.phone_number,
    party_animator.unique_performance
FROM
    party_animator
WHERE
    party_animator.unique_performance IS NOT NULL
