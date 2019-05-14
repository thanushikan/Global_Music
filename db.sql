-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

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
  `phone_no` BIGINT(11) NOT NULL,
  `mobile_no` BIGINT(11) NOT NULL,
  `web_address` VARCHAR(200) NULL DEFAULT NULL,
  `password` VARCHAR(255) NOT NULL,
  `is_corporate` BOOLEAN NULL DEFAULT NULL,
  `is_admin` BOOLEAN NULL DEFAULT NULL,
  `is_organiser` BOOLEAN NULL DEFAULT NULL,
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
  `tickct_type` varchar(11) NOT NULL ,
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
  `line_up_id` INTEGER NOT NULL,
  `ticket_price` DECIMAL NOT NULL DEFAULT 0.00,
  `event_type` VARCHAR(255) NULL DEFAULT NULL,
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
-- Table 'LINEUP'
-- 
-- ---

DROP TABLE IF EXISTS `LINEUP`;
		
CREATE TABLE `LINEUP` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `performance_time` DATETIME NOT NULL,
    `artist_id` INTEGER(255) NOT NULL,
  `performance_name` VARCHAR(100) NOT NULL DEFAULT 'Name Required',
  PRIMARY KEY (`id`)
);



-- ---
-- Table 'Artist'
-- 
-- ---

DROP TABLE IF EXISTS `Artist`;
		
CREATE TABLE `Artist` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `first_name` VARCHAR(25) NULL DEFAULT NULL,
  `last_name` VARCHAR(25) NULL DEFAULT NULL,
  `Agent` VARCHAR(25) NULL DEFAULT NULL,
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
  `agent_email` VARCHAR(30) NOT NULL,
  `agent_contract_no` BIGINT(11) NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `BOOKING` ADD FOREIGN KEY (payment_id) REFERENCES `PAYMENT` (`id`);
ALTER TABLE `BOOKING` ADD FOREIGN KEY (festival_id) REFERENCES `FESTIVAL` (`id`);
ALTER TABLE `BOOKING` ADD FOREIGN KEY (user_id) REFERENCES `USER` (`id`);
ALTER TABLE `FESTIVAL` ADD FOREIGN KEY (line_up_id) REFERENCES `LINEUP` (`id`);
ALTER TABLE `LINEUP` ADD FOREIGN KEY (artist_id) REFERENCES `Artist` (`id`);
ALTER TABLE `TICKET` ADD FOREIGN KEY (booking_id) REFERENCES `BOOKING` (`id`);
ALTER TABLE `Invoice` ADD FOREIGN KEY (user_id) REFERENCES `USER` (`id`);
ALTER TABLE `Invoice` ADD FOREIGN KEY (user_id) REFERENCES `BOOKING` (`id`);
ALTER TABLE `Invoice` ADD FOREIGN KEY (booking_id) REFERENCES `PAYMENT` (`id`);

-- ---
-- Constraints
-- ---
ALTER TABLE `booking` ADD UNIQUE(`id`);
ALTER TABLE `user` ADD UNIQUE(`email_address`);
-- ---
-- Table Properties
-- ---

-- ALTER TABLE `BOOKING` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `FESTIVAL` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `LINEUP` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `USER` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `PAYMENT` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `TICKET` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `Artist` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `Invoice` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `BOOKING` (`id`,`number_of_tickets`,`payment_id`,`festival_id`,`user_id`) VALUES
-- ('','','','','');
-- INSERT INTO `FESTIVAL` (`id`,`date`,`festival_name`,`venue`,`city`,postcode`,`description`,`tickets_available`,`line_up_id`,`ticket_price`,`event_type`)" + VALUES
-- ('','','','','','','','','','','');
-- INSERT INTO `USER` (`id`,`first_name`,`last_name`,`gender`,`address_line`,`address_line2`,`town`,`county`,`postcode`,`dob`,`contact_name`,`organisation_name`,`email_address`,`phone_no`,`mobile_no`,`web_address`,`password`,`is_corporate`,`is_admin`,`title`) VALUES
-- ('','','','','','','','','','','','','','','','','','','','');
-- INSERT INTO `PAYMENT` (`id`,`charge`,`card_no`) VALUES
-- ('','','');
-- INSERT INTO `LINEUP` (`id`,`performance_time`,`artist`) VALUES
-- ('','','');
-- INSERT INTO `TICKET` (`id`,`booking_id`,`ticket_type`) VALUES
-- ('','','');
-- INSERT INTO `Artist` (`id`,`first_name`,`last_name`,`agent_ id`) VALUES
-- ('','','','');
-- INSERT INTO `AGENT` (`id`,`first_name`,`last_name`,agent_contract_no`,`agent_email`) VALUES
-- ('','','','','');
-- INSERT INTO `Invoice` (`id`,`user_id`,`booking_id`,`payment_id`) VALUES
-- ('','','','');
