CREATE SCHEMA `todo_app`;

CREATE TABLE `tasks` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `type` INT, 
    `contents` TEXT,
    PRIMARY KEY(`id`)
);

INSERT INTO `tasks` (`type`, `contents`) VALUES 
(1, "Grab a snackie"),
(2, "Practice coding");

SELECT * FROM `tasks`;