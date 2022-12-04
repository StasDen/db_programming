USE party_animators;

DELIMITER //
CREATE TRIGGER afterInsertClientOrdering
    AFTER INSERT
    ON client_ordering
    FOR EACH ROW
BEGIN
    DECLARE client_name VARCHAR(100);
    DECLARE ordering_name VARCHAR(100);
    SELECT CONCAT(first_name, ' ', second_name) INTO client_name FROM client WHERE id = new.client_id;
    SELECT CONCAT(name, '/', cost_in_usd) INTO ordering_name FROM ordering WHERE id = new.ordering_id;
    INSERT INTO ledger (client, ordering, action, time, user)
    VALUES (client_name, ordering_name, 'GOT', NOW(), USER());
END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER afterDeleteClientOrdering
    AFTER DELETE
    ON client_ordering
    FOR EACH ROW
BEGIN
    DECLARE client_name VARCHAR(100);
    DECLARE ordering_name VARCHAR(100);
    SELECT CONCAT(first_name, ' ', second_name) INTO client_name FROM client WHERE id = old.client_id;
    SELECT CONCAT(name, '/', cost_in_usd) INTO ordering_name FROM ordering WHERE id = old.ordering_id;
    INSERT INTO ledger(client, ordering, action, time, user)
    VALUES (client_name, ordering_name, 'GAVE BACK', NOW(), USER());
END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER on_party_animator_phone_num_update
    AFTER UPDATE
    ON party_animator
    FOR EACH ROW
BEGIN
    INSERT INTO party_animator_copy (first_name, last_name, phone_number_old, phone_number_updated, unique_performance,
                                     work_experience_in_years,
                                     order_id, action, time_stamp, user)
    VALUES (old.first_name, old.last_name, old.phone_number, new.phone_number, old.unique_performance,
            old.work_experience_in_years, old.order_id, 'UPDATE', NOW(), USER());
END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER after_delete_animator_copy_two_min
    AFTER DELETE
    ON party_animator_copy
    FOR EACH ROW
BEGIN
    IF (SELECT count(*) from party_animator_copy) < 2
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot delete because min card is 2';
    END IF;
END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER before_insert_in_event
    BEFORE INSERT
    ON event
    FOR EACH ROW
BEGIN
    IF new.duration_in_hours LIKE '%0' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'duration_in_hours cannot contain 0 at the end';
    END IF;
END //
DELIMITER ;
