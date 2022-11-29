
DROP TABLE IF EXISTS `round`;

CREATE TABLE `round` (
  `round_id` int NOT NULL AUTO_INCREMENT,
  `game_id` int NOT NULL,
  `guess_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `guess` varchar(10) NOT NULL,
  `result` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`round_id`),
  KEY `fk_game_id` (`game_id`),
  CONSTRAINT `fk_game_id` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`)
);

INSERT INTO `round` VALUES (1,1,'2021-08-10 13:20:11','1254','e:4:p:0'),(2,2,'2021-04-11 08:47:31','5181','e:0:p:0'),(3,3,'2021-05-15 04:36:59','9876','e:4:p:0'),(4,4,'2021-01-31 10:03:01','1254','e:4:p:0'),(5,5,'2021-10-01 17:55:02','1259','e:1:p:1'),(6,6,'2021-08-04 10:20:49','4352','e:4:p:0');

