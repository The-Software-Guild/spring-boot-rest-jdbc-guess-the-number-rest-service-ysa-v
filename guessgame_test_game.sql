
DROP DATABASE IF EXISTS guessgame_test;
CREATE DATABASE guessgame_test;
USE guessgame_test;

DROP TABLE IF EXISTS `game`;
CREATE TABLE `game` (
  `game_id` int NOT NULL AUTO_INCREMENT,
  `answer` varchar(10) NOT NULL,
  `isFinished` tinyint(1) NOT NULL,
  PRIMARY KEY (`game_id`)
  );

DROP TABLE IF EXISTS `round`;
CREATE TABLE `round` (
  `round_id` int NOT NULL AUTO_INCREMENT,
  `game_id` int NOT NULL,
  `guess_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `guess` varchar(10) NOT NULL,
  `result` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`round_id`),
  KEY `fk_game_id` (`game_id`),
  CONSTRAINT `fk_game_id` FOREIGN KEY (`game_id`)
  REFERENCES `game` (`game_id`)
  );

INSERT INTO `game` VALUES (36,'0357',0),(37,'1282',0);
INSERT INTO `round` VALUES (9,36,NULL,'1111',NULL),(10,37,NULL,'2222',NULL);
