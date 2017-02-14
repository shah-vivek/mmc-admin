CREATE DATABASE mmc;

CREATE TABLE `members` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_email` varchar(50) NOT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `pass` varchar(200) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `status` tinyint(1) DEFAULT 1,
  `role` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`member_id`,`member_email`)
);

CREATE TABLE `events` (
  `event_id` varchar(200) NOT NULL,
  `event_name` varchar(100) DEFAULT NULL,
  `event_description` varchar(1000) DEFAULT NULL,
  `event_start` datetime DEFAULT NULL,
  `event_end` datetime DEFAULT NULL,
  `event_price` double DEFAULT NULL,
  `event_venue` varchar(200) DEFAULT NULL,
  `event_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
);

CREATE TABLE `membership_type` (
  `membership_id` varchar(200) DEFAULT NULL,
  `membership_name` varchar(200) DEFAULT NULL,
  `membership_description` varchar(1000) DEFAULT NULL,
  `membership_duration` int(11) DEFAULT NULL,
  `membership_status` tinyint(1) DEFAULT NULL,
  `membership_cost` double DEFAULT NULL
);

CREATE TABLE `albums` (
  `album_id` varchar(200) NOT NULL,
  `album_name` varchar(200) NOT NULL,
  PRIMARY KEY (`album_id`)
);

CREATE TABLE `tickets` (
  `ticket_id` varchar(200) DEFAULT NULL,
  `ticket_name` varchar(200) DEFAULT NULL,
  `ticket_description` varchar(1000) DEFAULT NULL,
  `ticket_price` double DEFAULT NULL,
  `ticket_qty` int default null,
  `event_id` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ticket_id`)
);

CREATE TABLE `ads` (
  `ads_id` varchar(200) DEFAULT NULL,
  `ads_title` varchar(200) DEFAULT NULL,
  `ads_desc` varchar(1000) DEFAULT NULL,
  `ads_url` varchar(500) DEFAULT NULL,
  `ads_image` longblob DEFAULT NULL,
  PRIMARY KEY (`ads_id`)
);

