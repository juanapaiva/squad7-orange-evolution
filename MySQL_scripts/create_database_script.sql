-- MySQL Script generated by MySQL Workbench
-- Sat Nov  5 23:03:58 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbOrangeEvolution
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbOrangeEvolution
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbOrangeEvolution` DEFAULT CHARACTER SET utf8 ;
USE `dbOrangeEvolution` ;

-- -----------------------------------------------------
-- Table `dbOrangeEvolution`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbOrangeEvolution`.`tb_users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(70) NOT NULL,
  `password` VARCHAR(70) NOT NULL,
  `is_admin` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbOrangeEvolution`.`Interests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbOrangeEvolution`.`tb_interests` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stack` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbOrangeEvolution`.`Users_has_Interests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbOrangeEvolution`.`tb_interests_users` (
  `users_id` INT NOT NULL,
  `interest_id` INT NOT NULL,
  PRIMARY KEY (`users_id`, `interest_id`),
  INDEX `fk_interests_users_interests1_idx` (`interest_id` ASC) VISIBLE,
  INDEX `fk_interests_users_users_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_interests_users_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `dbOrangeEvolution`.`tb_users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_interests_users_interests1`
    FOREIGN KEY (`interest_id`)
    REFERENCES `dbOrangeEvolution`.`tb_interests` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbOrangeEvolution`.`Roadmaps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbOrangeEvolution`.`tb_roadmaps` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `duration` INT NULL,
  `creator` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbOrangeEvolution`.`Users_has_Roadmaps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbOrangeEvolution`.`tb_roadmaps_users` (
  `users_id` INT NOT NULL,
  `roadmap_id` INT NOT NULL,
  PRIMARY KEY (`users_id`, `roadmap_id`),
  INDEX `fk_roadmaps_users_roadmaps1_idx` (`roadmap_id` ASC) VISIBLE,
  INDEX `fk_roadmaps_users_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_roadmaps_users_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `dbOrangeEvolution`.`tb_users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_roadmaps_users_roadmaps1`
    FOREIGN KEY (`roadmap_id`)
    REFERENCES `dbOrangeEvolution`.`tb_roadmaps` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbOrangeEvolution`.`Contents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbOrangeEvolution`.`tb_contents` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(100) NOT NULL,
  `subject` VARCHAR(100) NOT NULL,
  `title` VARCHAR(200) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `owner` VARCHAR(100) NULL,
  `duration` TIME NULL,
  `link` VARCHAR(300) NOT NULL,
  `id_roadmap` INT NOT NULL,
  PRIMARY KEY (`id`, `id_roadmap`),
  INDEX `fk_contents_roadmaps_id` (`id_roadmap` ASC) VISIBLE,
  CONSTRAINT `fk_contents_roadmaps1`
    FOREIGN KEY (`id_roadmap`)
    REFERENCES `dbOrangeEvolution`.`tb_roadmaps` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `dbOrangeEvolution`.`Content_Status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbOrangeEvolution`.`tb_content_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `roadmap_id` INT NOT NULL,
  `content_id` INT NOT NULL,
  `status_id` INT NULL,
  PRIMARY KEY (`id`, `user_id`, `roadmap_id`, `content_id`),
  INDEX `fk_contents_status_users_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_contents_status_roadmaps_idx` (`roadmap_id` ASC) VISIBLE,
  INDEX `fk_contents_status_contents_idx` (`content_id` ASC) VISIBLE,
  CONSTRAINT `fk_contents_status_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `dbOrangeEvolution`.`tb_users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contents_status_roadmaps1`
	FOREIGN KEY (`roadmap_id`)
	REFERENCES `dbOrangeEvolution`.`tb_roadmaps` (`id`)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION,
  CONSTRAINT `fk_contents_status_contents1`
    FOREIGN KEY (`content_id`)
    REFERENCES `dbOrangeEvolution`.`tb_contents` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;