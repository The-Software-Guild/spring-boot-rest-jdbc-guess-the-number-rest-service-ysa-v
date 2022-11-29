DROP DATABASE IF EXISTS guessgame1;
CREATE DATABASE guessgame1;

USE guessgame1;

DROP TABLE IF EXISTS `game`;

CREATE TABLE `game` (
  `game_id` int NOT NULL AUTO_INCREMENT,
  `answer` varchar(10) NOT NULL,
  `isFinished` tinyint(1) NOT NULL,
  PRIMARY KEY (`game_id`)
);


INSERT INTO `game` VALUES (1,'3290',0),(2,'9807',1),(3,'1290',1),(4,'4352',1),(5,'9876',1),(6,'1254',0),(7,'2689',0),(8,'5087',0),(9,'2383',0),(10,'6835',0);
