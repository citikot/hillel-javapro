-- MySQL Script generated by MySQL Workbench
-- Sat 11 Mar 2023 18:37:16 EET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hw25-Homework
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hw25-Homework
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hw25-Homework` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hw25-Homework` ;

-- -----------------------------------------------------
-- Table `hw25-Homework`.`Homework`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hw25-Homework`.`Homework` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hw25-Homework`.`Lesson`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hw25-Homework`.`Lesson` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `updateted_at` VARCHAR(45) NULL DEFAULT NULL,
  `homework_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Lesson_1_idx` (`homework_id` ASC) VISIBLE,
  CONSTRAINT `fk_Lesson_1`
    FOREIGN KEY (`homework_id`)
    REFERENCES `hw25-Homework`.`Homework` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hw25-Homework`.`Schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hw25-Homework`.`Schedule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `updated_at` VARCHAR(45) NULL DEFAULT NULL,
  `lesson` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hw25-Homework`.`ScheduleLessonConnection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hw25-Homework`.`ScheduleLessonConnection` (
  `schedule_id` INT NOT NULL,
  `lesson_id` INT NOT NULL,
  INDEX `fk_ScheduleLessonConnection_1_idx` (`schedule_id` ASC) VISIBLE,
  INDEX `fk_ScheduleLessonConnection_2_idx` (`lesson_id` ASC) VISIBLE,
  CONSTRAINT `fk_ScheduleLessonConnection_1`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `hw25-Homework`.`Schedule` (`id`),
  CONSTRAINT `fk_ScheduleLessonConnection_2`
    FOREIGN KEY (`lesson_id`)
    REFERENCES `hw25-Homework`.`Lesson` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;