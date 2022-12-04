USE party_animators;

DELIMITER //
DROP FUNCTION IF EXISTS max_ordering_cost //
CREATE FUNCTION max_ordering_cost() RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE cost INT;
    SELECT MAX(cost_in_usd)
    INTO cost
    FROM ordering;
    RETURN cost;
END //
DELIMITER ;

SELECT DISTINCT MAX_ORDERING_COST()
FROM ordering;
