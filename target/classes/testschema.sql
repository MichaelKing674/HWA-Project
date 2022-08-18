DROP TABLE IF EXISTS `driver`;

CREATE TABLE `driver` (
	`id` BIGINT AUTO_INCREMENT,
	`First_Name` VARCHAR(255) NOT NULL,
	`Last_Name` VARCHAR(255) NOT NULL,
	`Team` VARCHAR(255) NOT NULL,
	`Wins` INT NOT NULL,
	`Podium_Finishes` INT NOT NULL,
	PRIMARY KEY(`id`)
);

	