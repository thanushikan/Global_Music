-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;



-- ---
-- Table 'TICKET'
-- 
-- ---

DROP TABLE IF EXISTS `TICKET`;
		
CREATE TABLE `TICKET` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `booking_id` INTEGER NOT NULL,
  `ticket_type` varchar(11) NOT NULL ,
  PRIMARY KEY (`id`)
);


-- ---
-- Table 'BOOKING'
-- 
-- ---

DROP TABLE IF EXISTS `BOOKING`;
		
CREATE TABLE `BOOKING` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `number_of_tickets` INTEGER NOT NULL,
  `payment_id` INTEGER NOT NULL,
  `festival_id` INTEGER NOT NULL,
  `user_id` INTEGER NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'FESTIVAL'
-- 
-- ---

DROP TABLE IF EXISTS `FESTIVAL`;
		
CREATE TABLE `FESTIVAL` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(30) NOT NULL,
  `postcode` VARCHAR(8) NULL DEFAULT NULL,
  `date` DATE NOT NULL,
  `festival_name` VARCHAR(50) NOT NULL,
  `venue` VARCHAR(25) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `tickets_available` INTEGER NOT NULL DEFAULT 0,
  `band_id` INTEGER NOT NULL,
  `ticket_price` DECIMAL NOT NULL DEFAULT 0.00,
  `event_type` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'BAND'
--
-- ---

DROP TABLE IF EXISTS `BAND`;

CREATE TABLE `BAND` (
   `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
   `bandName` VARCHAR(30) NOT NULL DEFAULT 'Band Name Required',
   `agent_id` INTEGER NOT NULL,
   PRIMARY KEY (`id`)
);

-- ---
-- Table 'USER'
--
-- ---

DROP TABLE IF EXISTS `USER`;

CREATE TABLE `USER` (
   `id` INTEGER NOT NULL AUTO_INCREMENT,
   `title` CHAR(4) NOT NULL,
   `first_name` VARCHAR(25) NOT NULL,
   `last_name` VARCHAR(25) NOT NULL,
   `gender` VARCHAR(10) NOT NULL DEFAULT 'Other',
   `address_line` VARCHAR(30) NOT NULL,
   `address_line2` VARCHAR(30) NULL DEFAULT NULL,
   `town` VARCHAR(30) NOT NULL,
   `county` VARCHAR(25) NOT NULL,
   `postcode` VARCHAR(8) NOT NULL,
   `dob` DATE NOT NULL,
   `contact_name` VARCHAR(30) NOT NULL,
   `organisation_name` VARCHAR(75) NULL DEFAULT NULL,
   `email_address` VARCHAR(50) NOT NULL COMMENT 'add unique contraint',
   `contact_no` BIGINT(11) NOT NULL,
   `mobile_no` BIGINT(11) NOT NULL,
   `web_address` VARCHAR(200) NULL DEFAULT NULL,
   `password` VARCHAR(255) NOT NULL,
   `is_corporate` BOOLEAN NULL DEFAULT NULL,
   `is_admin` BOOLEAN NULL DEFAULT NULL,
   `is_organiser` BOOLEAN NULL DEFAULT NULL,
   PRIMARY KEY (`id`)
);

-- ---
-- Table 'PAYMENT'
-- 
-- ---

DROP TABLE IF EXISTS `PAYMENT`;
		
CREATE TABLE `PAYMENT` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `charge` DECIMAL NOT NULL,
  `card_no` INTEGER NOT NULL,
  `expire_Date` VARCHAR(20) NOT NULL,
  `cardholder_Name` VARCHAR(60) NOT NULL,
  `cvs_No` INTEGER(3) NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'TICKET'
--
-- ---

DROP TABLE IF EXISTS `TICKET`;

CREATE TABLE `TICKET` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `booking_id` INTEGER NOT NULL,
  `ticket_type` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'ARTIST'
-- 
-- ---

DROP TABLE IF EXISTS `ARTIST`;

CREATE TABLE `ARTIST` (
   `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
   `first_name` VARCHAR(25) NULL DEFAULT NULL,
   `last_name` VARCHAR(25) NULL DEFAULT NULL,
   `agent_id` INTEGER NOT NULL,
   PRIMARY KEY (`id`)
);

-- ---
-- Table 'Invoice'
-- 
-- ---

DROP TABLE IF EXISTS `Invoice`;
		
CREATE TABLE `Invoice` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `user_id` INTEGER NULL DEFAULT NULL,
  `booking_id` INTEGER NULL DEFAULT NULL,
  `payment_id` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'AGENT'
-- 
-- ---

DROP TABLE IF EXISTS `AGENT`;
		
CREATE TABLE `AGENT` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `first_name` VARCHAR(25) NULL DEFAULT NULL,
  `last_name` VARCHAR(25) NULL DEFAULT NULL,
  `agent_contact_no` BIGINT(11) NULL DEFAULT NULL ,
  `agent_email` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `BOOKING` ADD FOREIGN KEY (payment_id) REFERENCES `PAYMENT` (`id`);
ALTER TABLE `BOOKING` ADD FOREIGN KEY (festival_id) REFERENCES `FESTIVAL` (`id`);
ALTER TABLE `BOOKING` ADD FOREIGN KEY (user_id) REFERENCES `USER` (`id`);
ALTER TABLE `FESTIVAL` ADD FOREIGN KEY (band_id) REFERENCES `BAND` (`id`);
ALTER TABLE `BAND` ADD FOREIGN KEY (agent_id) REFERENCES `AGENT` (`id`);
ALTER TABLE `TICKET` ADD FOREIGN KEY (booking_id) REFERENCES `BOOKING` (`id`);
ALTER TABLE `ARTIST` ADD FOREIGN KEY (agent_id) REFERENCES `AGENT` (`id`);
ALTER TABLE `Invoice` ADD FOREIGN KEY (booking_id) REFERENCES `BOOKING` (`id`);

-- ---
-- Constraints
-- ---
ALTER TABLE `booking` ADD UNIQUE(`id`);
ALTER TABLE `user` ADD UNIQUE(`email_address`);
ALTER TABLE `agent` ADD UNIQUE(`agent_email`);
-- ---
-- Table Properties
-- ---

-- ALTER TABLE `BOOKING` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `FESTIVAL` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `BAND` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `USER` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `PAYMENT` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `TICKET` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `ARTIST` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `Invoice` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `AGENT` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `BOOKING` (`id`,`number_of_tickets`,`payment_id`,`festival_id`,`user_id`) VALUES
-- ('','','','','');
-- INSERT INTO `FESTIVAL` (`id`,`city`,`postcode`,`date`,`festival_name`,`venue`,`description`,`tickets_available`,`band_id`,`ticket_price`,`event_type`) VALUES
-- ('','','','','','','','','','','');
-- INSERT INTO `BAND` (`id`,`bandName`,`agent_id`) VALUES
-- ('','','');
-- INSERT INTO `USER` (`id`,`title`,`first_name`,`last_name`,`gender`,`address_line`,`address_line2`,`town`,`county`,`postcode`,`dob`,`contact_name`,`organisation_name`,`email_address`,`contact_no`,`mobile_no`,`web_address`,`password`,`is_corporate`,`is_admin`,`is_organiser`) VALUES
-- ('','','','','','','','','','','','','','','','','','','','','');
-- INSERT INTO `PAYMENT` (`id`,`charge`,`card_no`,`expire_Date`,`cardholder_Name`,`cvs_No`) VALUES
-- ('','','','','','');
-- INSERT INTO `TICKET` (`id`,`booking_id`,`ticket_type`) VALUES
-- ('','','');
-- INSERT INTO `ARTIST` (`id`,`first_name`,`last_name`,`agent_id`,`band_id`) VALUES
-- ('','','','','');
-- INSERT INTO `Invoice` (`id`,`user_id`,`booking_id`,`payment_id`) VALUES
-- ('','','','');
-- INSERT INTO `AGENT` (`id`,`first_name`,`last_name`,`agent_contact_no`,`email`) VALUES
-- ('','','','','');