-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema society
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema society
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `society` DEFAULT CHARACTER SET latin1 ;
USE `society` ;

-- -----------------------------------------------------
-- Table `society`.`society_archive_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `society`.`society_archive_member` ;

CREATE TABLE IF NOT EXISTS `society`.`society_archive_member` (
  `prime_key` VARCHAR(5) NOT NULL,
  `last_date` DATETIME NULL DEFAULT NULL,
  `alternate_mobile_no` VARCHAR(15) NULL DEFAULT NULL,
  `building` VARCHAR(2) NULL DEFAULT NULL,
  `co_member_name1` VARCHAR(255) NULL DEFAULT NULL,
  `co_member_name2` VARCHAR(255) NULL DEFAULT NULL,
  `co_member_name3` VARCHAR(255) NULL DEFAULT NULL,
  `flat_no` VARCHAR(3) NULL DEFAULT NULL,
  `is_currently_staying` BIT(1) NOT NULL,
  `member_name` VARCHAR(255) NOT NULL,
  `mobile_no` VARCHAR(255) NULL DEFAULT NULL,
  `primary_email` VARCHAR(255) NULL DEFAULT NULL,
  `secondary_email` VARCHAR(255) NULL DEFAULT NULL,
  `shop_no` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`prime_key`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `society`.`society_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `society`.`society_member` ;

CREATE TABLE IF NOT EXISTS `society`.`society_member` (
  `prime_key` VARCHAR(5) NOT NULL,
  `alternate_mobile_no` VARCHAR(15) NULL DEFAULT NULL,
  `building` VARCHAR(2) NULL DEFAULT NULL,
  `co_member_name1` VARCHAR(255) NULL DEFAULT NULL,
  `co_member_name2` VARCHAR(255) NULL DEFAULT NULL,
  `co_member_name3` VARCHAR(255) NULL DEFAULT NULL,
  `flat_no` VARCHAR(3) NULL DEFAULT NULL,
  `is_currently_staying` BIT(1) NOT NULL,
  `member_name` VARCHAR(255) NOT NULL,
  `mobile_no` VARCHAR(255) NULL DEFAULT NULL,
  `primary_email` VARCHAR(255) NULL DEFAULT NULL,
  `secondary_email` VARCHAR(255) NULL DEFAULT NULL,
  `shop_no` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`prime_key`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `society`.`society_tenant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `society`.`society_tenant` ;

CREATE TABLE IF NOT EXISTS `society`.`society_tenant` (
  `prime_key` VARCHAR(5) NOT NULL,
  `alternate_mobile_no` VARCHAR(15) NULL DEFAULT NULL,
  `building` VARCHAR(2) NULL DEFAULT NULL,
  `contract_enddate` DATETIME NULL DEFAULT NULL,
  `contract_start_date` DATETIME NULL DEFAULT NULL,
  `flat_no` VARCHAR(3) NULL DEFAULT NULL,
  `is_deleted` BIT(1) NOT NULL,
  `mobile_no` VARCHAR(15) NULL DEFAULT NULL,
  `owner_name` VARCHAR(255) NOT NULL,
  `primary_email` VARCHAR(255) NULL DEFAULT NULL,
  `secondary_email` VARCHAR(255) NULL DEFAULT NULL,
  `shop_no` VARCHAR(2) NULL DEFAULT NULL,
  `tenant_name1` VARCHAR(255) NOT NULL,
  `tenant_name2` VARCHAR(255) NULL DEFAULT NULL,
  `tenant_name3` VARCHAR(255) NULL DEFAULT NULL,
  `tenant_name4` VARCHAR(255) NULL DEFAULT NULL,
  `tenant_name5` VARCHAR(255) NULL DEFAULT NULL,
  `tenant_name6` VARCHAR(255) NULL DEFAULT NULL,
  `tenant_name7` VARCHAR(255) NULL DEFAULT NULL,
  `tenant_name8` VARCHAR(255) NULL DEFAULT NULL,
  `tenant_name9` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`prime_key`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
