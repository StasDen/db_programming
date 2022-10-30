SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS jdbc_template_project DEFAULT CHARACTER SET utf8;
USE jdbc_template_project;

DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS `client`;
DROP TABLE IF EXISTS client_card;
DROP TABLE IF EXISTS consultant;
DROP TABLE IF EXISTS discount;
DROP TABLE IF EXISTS entertainment_agency;
DROP TABLE IF EXISTS `event`;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS party_animator;
DROP TABLE IF EXISTS region;

# ======
# Tables
# ======
CREATE TABLE IF NOT EXISTS region
(
    id     INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS city
(
    id        INT         NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(30) NOT NULL,
    region_id INT         NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_city_region1_idx (region_id ASC) VISIBLE
) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS `event`
(
    id                INT             NOT NULL AUTO_INCREMENT,
    `name`            VARCHAR(30)     NOT NULL,
    animators_num     INT(2)          NULL,
    visitors_num      INT(3)          NULL,
    `date`            DATE            NOT NULL,
    address           VARCHAR(30)     NOT NULL,
    duration_in_hours INT(2) UNSIGNED NOT NULL,
    city_id           INT             NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_event_city1_idx (city_id ASC) VISIBLE
) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS discount
(
    id         INT             NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(35)     NULL,
    percentage INT(2) UNSIGNED NOT NULL,
    PRIMARY KEY (id)
) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS client_card
(
    id                  INT         NOT NULL AUTO_INCREMENT,
    `name`              VARCHAR(25) NOT NULL,
    discount_percentage INT(2)      NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `client`
(
    id             INT         NOT NULL AUTO_INCREMENT,
    first_name     VARCHAR(25) NOT NULL,
    second_name    VARCHAR(30) NOT NULL,
    phone_number   VARCHAR(20) NOT NULL,
    client_card_id INT         NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX phone_number_UNIQUE (phone_number ASC) VISIBLE,
    INDEX fk_client_client_card1_idx (client_card_id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS entertainment_agency
(
    id             INT         NOT NULL AUTO_INCREMENT,
    `name`         VARCHAR(40) NOT NULL,
    contact_number VARCHAR(20) NOT NULL,
    address        VARCHAR(30) NULL,
    animator_id    INT         NOT NULL,
    city_id        INT         NOT NULL,
    UNIQUE INDEX name_UNIQUE (`name` ASC) VISIBLE,
    PRIMARY KEY (id),
    INDEX fk_entertainment_agency_animator1_idx (animator_id ASC) VISIBLE,
    INDEX fk_entertainment_agency_city1_idx (city_id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `order`
(
    id                      INT             NOT NULL AUTO_INCREMENT,
    `name`                  VARCHAR(35)     NOT NULL,
    cost_in_usd             INT(5) UNSIGNED NOT NULL,
    event_id                INT             NOT NULL,
    discount_id             INT             NULL,
    client_id               INT             NOT NULL,
    entertainment_agency_id INT             NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_order_event1_idx (event_id ASC) VISIBLE,
    INDEX fk_order_discount1_idx (discount_id ASC) VISIBLE,
    INDEX fk_order_client1_idx (client_id ASC) VISIBLE,
    INDEX fk_order_entertainment_agency1_idx (entertainment_agency_id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS party_animator
(
    id                       INT             NOT NULL AUTO_INCREMENT,
    first_name               VARCHAR(25)     NOT NULL,
    last_name                VARCHAR(30)     NOT NULL,
    phone_number             VARCHAR(20)     NOT NULL,
    unique_performance       VARCHAR(30)     NULL,
    work_experience_in_years INT(2) UNSIGNED NULL,
    order_id                 INT             NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
    UNIQUE INDEX phone_number_UNIQUE (phone_number ASC) VISIBLE,
    INDEX fk_animator_order1_idx (order_id ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS consultant
(
    id                      INT         NOT NULL AUTO_INCREMENT,
    first_name              VARCHAR(25) NOT NULL,
    second_name             VARCHAR(30) NOT NULL,
    phone_number            VARCHAR(25) NOT NULL,
    entertainment_agency_id INT         NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX phone_number_UNIQUE (phone_number ASC) VISIBLE,
    INDEX fk_agency_worker_entertainment_agency1_idx (entertainment_agency_id ASC) VISIBLE
)
    ENGINE = InnoDB;

# ======
# Alters
# ======
ALTER TABLE city
    ADD CONSTRAINT fk_city_region1
        FOREIGN KEY (region_id)
            REFERENCES region (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE `event`
    ADD CONSTRAINT fk_event_city
        FOREIGN KEY (city_id)
            REFERENCES city (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE `client`
    ADD INDEX second_name_idx (second_name), # Adding one more index
    ADD CONSTRAINT fk_client_client_card1
        FOREIGN KEY (client_card_id)
            REFERENCES client_card (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE entertainment_agency
    ADD CONSTRAINT fk_entertainment_agency_animator1
        FOREIGN KEY (animator_id)
            REFERENCES party_animator (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_entertainment_agency_city1
        FOREIGN KEY (city_id)
            REFERENCES city (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE `order`
    ADD INDEX name_idx (`name`),
    ADD CONSTRAINT fk_order_event1
        FOREIGN KEY (event_id)
            REFERENCES `event` (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_order_discount1
        FOREIGN KEY (discount_id)
            REFERENCES discount (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_order_client1
        FOREIGN KEY (client_id)
            REFERENCES `client` (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_order_entertainment_agency1
        FOREIGN KEY (entertainment_agency_id)
            REFERENCES entertainment_agency (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE party_animator
    ADD CONSTRAINT fk_animator_order1
        FOREIGN KEY (order_id)
            REFERENCES `order` (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE consultant
    ADD CONSTRAINT fk_agency_worker_entertainment_agency1
        FOREIGN KEY (entertainment_agency_id)
            REFERENCES entertainment_agency (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

# =======
# Inserts
# =======
INSERT INTO region(id, `name`)
VALUES (1, 'Volyn'),
       (2, 'Lviv'),
       (3, 'Kyiv');

INSERT INTO city(id, `name`, region_id)
VALUES (1, 'Lutsk', 1),
       (2, 'Lviv', 2),
       (3, 'Kovel', 1),
       (4, 'Volodymyr', 1),
       (5, 'Stryi', 2),
       (6, 'Brody', 2),
       (7, 'Zolochiv', 2),
       (8, 'Kyiv', 3),
       (9, 'Sambir', 2),
       (10, 'Shatsk', 1);

INSERT INTO client_card(id, `name`, discount_percentage)
VALUES (1, 'Gold customer', 40),
       (2, 'Silver customer', 30),
       (3, 'Bronze customer', 20);

INSERT INTO client(id, first_name, second_name, phone_number, client_card_id)
VALUES (1, 'Mykola', 'Yurchenko', '+380 66 122 4935', 2),
       (2, 'Ivan', 'Shapovalov', '+380 66 937 4822', 1),
       (3, 'Ivanna', 'Vasylenko', '+380 94 970 7931', 2),
       (4, 'Maksym', 'Hryhorenko', '+380 50 737 9882', NULL),
       (5, 'Taras', 'Solovei', '+380 96 534 9483', 1),
       (6, 'Oksana', 'Dmytruk', '+380 97 697 3310', NULL),
       (7, 'Kateryna', 'Voznyuk', '+380 66 836 0794', 1),
       (8, 'Ruslana', 'Lukyanenko', '+380 68 431 5374', 1),
       (9, 'Taras', 'Zhuk', '+380 50 786 4968', 1),
       (10, 'Stanislav', 'Hrytsenko', '+380 63 680 9190', NULL);

INSERT INTO discount(id, `name`, percentage)
VALUES (1, 'Winter holidays', 35),
       (2, 'Halloween', 25),
       (3, 'Easter', 30),
       (4, 'First bell', 25),
       (5, 'Regular customer', 10),
       (6, 'First try', 15);

INSERT INTO entertainment_agency(id, `name`, contact_number, address, animator_id, city_id)
VALUES (1, 'Animatorooze', '+380 50 750 5060', 'Voli Ave', 5, 1),
       (2, 'Gl-Kids', '+380 50 831 8698', 'Stepana Bandery St', 2, 2),
       (3, 'Classic Animator', '+380 50 966 5390', 'Kopernika St', 3, 1),
       (4, 'Vegas party', '+380 73 043 5489', 'Bendeliani St', 4, 1),
       (5, 'Kids Time!', '+380 50 328 2038', 'Konovalca St', 4, 2),
       (6, 'Exfoliate Animator', '+380 97 034 5583', 'Bankova St', 10, 3),
       (7, 'Animatorsy', '+380 50 319 7551', 'Kychmyn Yar St', 5, 3),
       (8, 'Wed-ding', '+380 68 681 9868', 'Shopena St', 1, 1),
       (9, 'Your Best Party Ever', '+380 98 154 0441', 'Prince Roman St', 9, 2),
       (10, 'Animatorella', '+380 66 542 0834', 'UPA Heroes St', 6, 2);

INSERT INTO consultant(id, first_name, second_name, phone_number, entertainment_agency_id)
VALUES (1, 'Volodymyr', 'Sydorenko', '+380 50 331 6602', 3),
       (2, 'Eduard', 'Lysenko', '+380 71 943 0821', 5),
       (3, 'Alina', 'Serdyuk', '+380 96 040 5440', 9),
       (4, 'Victor', 'Hrytsaj', '+380 72 018 3201', 7),
       (5, 'Anton', 'Nesterenko', '+380 50 404 0137', 6),
       (6, 'Hanna', 'Hrytsenko', '+380 50 421 4425', 1),
       (7, 'Iryna', 'Semenova', '+380 73 269 1553', 5),
       (8, 'Marharyta', 'Yarosh', '+380 66 552 3136', 9),
       (9, 'Denys', 'Marchuk', '+380 50 354 6621', 9),
       (10, 'Yaroslav', 'Zozulya', '+380 50 666 8157', 8);

INSERT INTO `event`(id, `name`, animators_num, visitors_num, `date`, address, duration_in_hours, city_id)
VALUES (1, 'Birthday', 2, 15, '2022-08-11', 'Stepana Bandery St', 3, 1),
       (2, 'Birthday-party', 3, 40, '2022-08-23', 'Stepana Bandery St', 5, 2),
       (3, 'Kids party', 1, 20, '2022-07-28', 'Voli Ave', 6, 1),
       (4, 'School graduation', 2, 18, '2022-06-25', 'Grushevskogo Ave', 4, 1),
       (5, 'Summer holiday start', 4, 45, '2022-06-10', 'Horodotska St', 6, 2),
       (6, 'Kindergarten graduation', 3, 20, '2022-05-29', 'Volodymyrska St', 3, 3),
       (7, 'Sons Birthday', 1, 30, '2022-07-16', 'Prorizna St', 3, 3),
       (8, 'Mothers Birthday', 1, 15, '2022-08-03', 'Zelena St', 5, 2),
       (9, 'Wedding', 2, 40, '2022-04-22', 'Vynnychenka St', 6, 1),
       (10, 'University winter holiday', 1, 35, '2022-11-20', 'Grabovskogo St', 4, 2);

INSERT INTO party_animator(id, first_name, last_name, phone_number, unique_performance, work_experience_in_years,
                           order_id)
VALUES (1, 'Oleksij', 'Movchan', '+380 50 906 2366', NULL, 3, 1),
       (2, 'Denys', 'Khomenko', '+380 50 618 4500', 'Pinata', 7, 1),
       (3, 'Ihor', 'Horbenko', '+380 71 774 6062', NULL, 2, 6),
       (4, 'Tymofiy', 'Denysenko', '+380 71 818 3455', 'Search quests', 5, 8),
       (5, 'Lidiya', 'Denysenko', '+380 95 140 3467', NULL, NULL, 8),
       (6, 'Olena', 'Osadchuk', '+380 95 888 4512', NULL, NULL, 9),
       (7, 'Vira', 'Lytvyna', '+380 66 963 6112', 'Focuses', 4, 10),
       (8, 'Zhanna', 'Levchuk', '+380 50 600 5211', NULL, NULL, 2),
       (9, 'Valerij', 'Sushko', '+380 50 392 0114', NULL, 3, 4),
       (10, 'Tamara', 'Tereshchenko', '+380 50 924 8357', NULL, NULL, 5);

INSERT INTO `order`(id, `name`, cost_in_usd, event_id, discount_id, client_id, entertainment_agency_id)
VALUES (1, 'Birthday', 400, 1, 6, 5, 1),
       (2, 'Birthday-party', 900, 2, NULL, 2, 5),
       (3, 'Wedding', 650, 9, 1, 1, 8),
       (4, 'Summer holiday start', 1000, 5, 5, 8, 1),
       (5, 'Kindergarten graduation', 600, 6, NULL, 9, 5),
       (6, 'Mothers Birthday', 400, 8, NULL, 3, 3),
       (7, 'University winter holiday', 300, 10, 1, 6, 10),
       (8, 'School graduation', 450, 4, 5, 6, 9),
       (9, 'Sons Birthday', 250, 7, 5, 6, 3),
       (10, 'Kids party', 600, 3, 6, 7, 6);

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
