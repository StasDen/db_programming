USE party_animators;

DROP PROCEDURE IF EXISTS getOrderingsAfterCost;
DELIMITER //
CREATE PROCEDURE getOrderingsAfterCost(IN cost INT)
BEGIN
    SELECT *
    FROM ordering
    WHERE cost_in_usd > cost
    ORDER BY cost_in_usd;
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS getNumOfOrderingsAfterCost;
DELIMITER //
CREATE PROCEDURE getNumOfOrderingsAfterCost(IN cost INT, OUT num INT)
BEGIN
    SELECT count(*)
    INTO num
    FROM ordering
    WHERE cost_in_usd > cost;
END //
DELIMITER ;

# ====================================================================

DROP PROCEDURE IF EXISTS insertNonameRegions;
DELIMITER //
CREATE PROCEDURE insertNonameRegions()
BEGIN
    DECLARE no INT DEFAULT 1;
    region_loop:
    LOOP
        INSERT INTO region(name)
        VALUES (CONCAT('NONAME#', CONVERT(no, CHAR)));
        SET no = no + 1;
        IF no = 11 THEN
            LEAVE region_loop;
        END IF;
    END LOOP region_loop;
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS cursor_stored_procedure;
DELIMITER //
CREATE PROCEDURE cursor_stored_procedure()
BEGIN
    DECLARE done int DEFAULT false;
    DECLARE party_animator_surname, party_animator_name varchar(50);

    DECLARE party_animators_db_cursor CURSOR FOR SELECT last_name, first_name FROM party_animator;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;

    OPEN party_animators_db_cursor;
    procedure_loop:
    LOOP
        FETCH party_animators_db_cursor INTO party_animator_surname, party_animator_name;
        IF done = true THEN
            LEAVE procedure_loop;
        END IF;
        SET @temp_query = CONCAT('CREATE SCHEMA IF NOT EXISTS ', party_animator_surname, party_animator_name);
        PREPARE query FROM @temp_query;
        EXECUTE query;
        DEALLOCATE PREPARE query;
    END LOOP;
    CLOSE party_animators_db_cursor;
END //
DELIMITER ;
