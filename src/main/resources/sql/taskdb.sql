# DB作成
CREATE DATABASE taskdb;

USE taskdb;

# テーブルの作成
CREATE TABLE `task_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `content` varchar(200) DEFAULT NULL,
  `duedate` date DEFAULT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`id`)
)