SELECT 
    *
FROM
    firm.printer;

-- SELECT #6
SELECT 
    CONCAT('код: ', printer.code) AS code,
    CONCAT("модель: ", printer.model) AS model,
    CONCAT("колір: ", printer.color) AS color,
    CONCAT("тип: ", printer.type) AS type,
    CONCAT("ціна: ", printer.price) AS price
FROM
    printer
