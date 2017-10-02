-- MySQL dump 10.13  Distrib 5.7.19, for osx10.12 (x86_64)
--
-- Host: localhost    Database: student_tracker
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

--
-- Create SCHEMA
--

CREATE SCHEMA IF NOT EXISTS `student_tracker` DEFAULT CHARACTER SET utf8 ;
USE `student_tracker` ;

--
-- Create User with Permissions
--

DROP USER 'tracker'@'localhost';
CREATE USER `tracker`@`localhost` IDENTIFIED BY 'tracker';
GRANT SELECT ON `student_tracker`.* TO 'tracker'@'localhost';
GRANT DELETE ON `student_tracker`.* TO 'tracker'@'localhost';
GRANT INSERT ON `student_tracker`.* TO 'tracker'@'localhost';
GRANT UPDATE ON `student_tracker`.* TO 'tracker'@'localhost';


-- -----------------------------------------------------
-- Table `student_tracker`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(100) NULL DEFAULT '',
  `street2` VARCHAR(100) NULL DEFAULT '',
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `postal_code` VARCHAR(20) NULL DEFAULT '',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `image_url` VARCHAR(255) NOT NULL,
  `title` VARCHAR(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `is_va` TINYINT(1) NOT NULL DEFAULT 0,
  `user_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  `image_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `student_user_fk_idx` (`user_id` ASC),
  INDEX `student_address_fk_idx` (`address_id` ASC),
  INDEX `student_image_fk_idx` (`image_id` ASC),
  CONSTRAINT `student_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `student_tracker`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `student_address_fk`
    FOREIGN KEY (`address_id`)
    REFERENCES `student_tracker`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `student_image_fk`
    FOREIGN KEY (`image_id`)
    REFERENCES `student_tracker`.`image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `employee_user_fk_idx` (`user_id` ASC),
  CONSTRAINT `employee_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `student_tracker`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`contact_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`contact_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NULL,
  `phone` VARCHAR(20) NULL,
  `type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `contact_contact_type_fk_idx` (`type_id` ASC),
  CONSTRAINT `contact_contact_type_fk`
    FOREIGN KEY (`type_id`)
    REFERENCES `student_tracker`.`contact_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`employee_contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`employee_contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `employee_id` INT NOT NULL,
  `contact_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `employee_contact_employee_fk_idx` (`employee_id` ASC),
  INDEX `employee_contact_contact_idx` (`contact_id` ASC),
  CONSTRAINT `employee_contact_employee_fk`
    FOREIGN KEY (`employee_id`)
    REFERENCES `student_tracker`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `employee_contact_contact`
    FOREIGN KEY (`contact_id`)
    REFERENCES `student_tracker`.`contact` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`student_contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`student_contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `contact_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `student_cohort_student_idx` (`student_id` ASC),
  INDEX `student_contact_contact_idx` (`contact_id` ASC),
  CONSTRAINT `student_contact_student`
    FOREIGN KEY (`student_id`)
    REFERENCES `student_tracker`.`student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `student_contact_contact`
    FOREIGN KEY (`contact_id`)
    REFERENCES `student_tracker`.`contact` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`cohort`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`cohort` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `capacity` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`cohort_student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`cohort_student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `cohort_id` INT NOT NULL,
  `accepted_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `cohort_student_student_idx` (`student_id` ASC),
  INDEX `cohort_student_cohort_fk_idx` (`cohort_id` ASC),
  CONSTRAINT `cohort_student_student_fk`
    FOREIGN KEY (`student_id`)
    REFERENCES `student_tracker`.`student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cohort_student_cohort_fk`
    FOREIGN KEY (`cohort_id`)
    REFERENCES `student_tracker`.`cohort` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`application`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`application` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cohort_id` INT NOT NULL,
  `student_id` INT NOT NULL,
  `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_active` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `application_cohort_fk_idx` (`cohort_id` ASC),
  INDEX `application_student_fk_idx` (`student_id` ASC),
  CONSTRAINT `application_cohort_fk`
    FOREIGN KEY (`cohort_id`)
    REFERENCES `student_tracker`.`cohort` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `application_student_fk`
    FOREIGN KEY (`student_id`)
    REFERENCES `student_tracker`.`student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`application_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`application_task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `is_active` TINYINT(1) NOT NULL DEFAULT 0,
  `application_task_order` INT UNSIGNED NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`application_step`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`application_step` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `application_id` INT NOT NULL,
  `application_task` INT NOT NULL,
  `completed_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_acceptable` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `application_step_application_idx` (`application_id` ASC),
  INDEX `application_step_application_task_idx` (`application_task` ASC),
  CONSTRAINT `application_step_application`
    FOREIGN KEY (`application_id`)
    REFERENCES `student_tracker`.`application` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `application_step_application_task`
    FOREIGN KEY (`application_task`)
    REFERENCES `student_tracker`.`application_task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`assignment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`assignment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `max_score` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`student_assignment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`student_assignment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `assignment_id` INT NOT NULL,
  `is_completed` TINYINT(1) NOT NULL DEFAULT 1,
  `score` DECIMAL(2,1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `student_assignment_assignment_fk_idx` (`assignment_id` ASC),
  INDEX `student_assignment_student_fk_idx` (`student_id` ASC),
  CONSTRAINT `student_assignment_student_fk`
    FOREIGN KEY (`student_id`)
    REFERENCES `student_tracker`.`student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `student_assignment_assignment_fk`
    FOREIGN KEY (`assignment_id`)
    REFERENCES `student_tracker`.`assignment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`cohort_assignment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`cohort_assignment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cohort_id` INT NOT NULL,
  `assignment_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `cohort_assignment_assignment_fk_idx` (`assignment_id` ASC),
  INDEX `cohort_assignment_cohort_fk_idx` (`cohort_id` ASC),
  CONSTRAINT `cohort_assignment_cohort_fk`
    FOREIGN KEY (`cohort_id`)
    REFERENCES `student_tracker`.`cohort` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cohort_assignment_assignment_fk`
    FOREIGN KEY (`assignment_id`)
    REFERENCES `student_tracker`.`assignment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`note`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`note` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `employee_id` INT NOT NULL,
  `topic` VARCHAR(100) NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `note_employee_fk_idx` (`employee_id` ASC),
  CONSTRAINT `note_employee_fk`
    FOREIGN KEY (`employee_id`)
    REFERENCES `student_tracker`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`assignment_note`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`assignment_note` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `assignment_id` INT NOT NULL,
  `note_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `assignment_note_assignment_fk_idx` (`assignment_id` ASC),
  INDEX `assignment_note_note_fk_idx` (`note_id` ASC),
  CONSTRAINT `assignment_note_assignment_fk`
    FOREIGN KEY (`assignment_id`)
    REFERENCES `student_tracker`.`assignment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `assignment_note_note_fk`
    FOREIGN KEY (`note_id`)
    REFERENCES `student_tracker`.`note` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_tracker`.`student_note`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_tracker`.`student_note` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `note_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `student_note_note_fk_idx` (`note_id` ASC),
  INDEX `student_note_student_fk_idx` (`student_id` ASC),
  CONSTRAINT `student_note_student_fk`
    FOREIGN KEY (`student_id`)
    REFERENCES `student_tracker`.`student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `student_note_note_fk`
    FOREIGN KEY (`note_id`)
    REFERENCES `student_tracker`.`note` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE USER 'tracker' IDENTIFIED BY 'tracker';

GRANT SELECT ON TABLE `student_tracker`.* TO 'tracker';
GRANT SELECT, INSERT, TRIGGER ON TABLE `student_tracker`.* TO 'tracker';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `student_tracker`.* TO 'tracker';
