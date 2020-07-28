-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.4-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for mysql_tour
CREATE DATABASE IF NOT EXISTS `mysql_tour` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mysql_tour`;

-- Dumping structure for table mysql_tour.booking_tour
CREATE TABLE IF NOT EXISTS `booking_tour` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `tour_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_booking_tour_user` (`user_id`),
  KEY `FK_booking_tour_tour` (`tour_id`),
  CONSTRAINT `FK_booking_tour_tour` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`tour_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_booking_tour_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='information booking tour';

-- Dumping data for table mysql_tour.booking_tour: ~2 rows (approximately)
/*!40000 ALTER TABLE `booking_tour` DISABLE KEYS */;
INSERT INTO `booking_tour` (`id`, `user_id`, `tour_id`) VALUES
	(1, 1, 1),
	(2, 2, 7);
/*!40000 ALTER TABLE `booking_tour` ENABLE KEYS */;

-- Dumping structure for table mysql_tour.tour
CREATE TABLE IF NOT EXISTS `tour` (
  `tour_id` int(11) NOT NULL AUTO_INCREMENT,
  `name_tour` varchar(50) DEFAULT NULL,
  `location_start` varchar(50) DEFAULT NULL,
  `time_start` time DEFAULT NULL,
  `date_start` date DEFAULT NULL,
  `mem_number` int(50) DEFAULT NULL,
  PRIMARY KEY (`tour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COMMENT='infomation Tour ';

-- Dumping data for table mysql_tour.tour: ~3 rows (approximately)
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` (`tour_id`, `name_tour`, `location_start`, `time_start`, `date_start`, `mem_number`) VALUES
	(1, 'danang_bana', 'danang', '10:54:07', '2020-07-28', 0),
	(7, 'vungtau_baisau', 'vungtau', '10:20:20', '2020-10-23', 0),
	(8, 'hochiminh_quan1', 'hochiminh', '06:20:20', '2020-02-01', 0);
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;

-- Dumping structure for table mysql_tour.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `gmail` varchar(50) DEFAULT NULL,
  `Ex` varchar(50) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `phonenumber` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `id_ac` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_user_account` (`id_ac`),
  CONSTRAINT `FK_user_user_account` FOREIGN KEY (`id_ac`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1 COMMENT='information for user\r\n';

-- Dumping data for table mysql_tour.user: ~4 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `gmail`, `Ex`, `Birthday`, `phonenumber`, `address`, `id_ac`) VALUES
	(1, 'nguyenvanhung', 'hung@gmail.com', 'nam', '1998-07-24', 125478548, '13 dienbienphu, phuong15, quan binhthanh', 2),
	(2, 'tranvanminh', 'minh@gmail.com', 'nam', NULL, 958467584, NULL, NULL),
	(3, 'tranthihoa', 'hoa@gmail.com', 'nu', NULL, 987654321, NULL, NULL),
	(4, 'letrunghieu', 'hieu@gmail.com', 'nam', NULL, 987654322, NULL, 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table mysql_tour.user_account
CREATE TABLE IF NOT EXISTS `user_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username_ac` varchar(50) DEFAULT '',
  `access_right` varchar(50) DEFAULT '',
  `date` date DEFAULT NULL,
  `password_ac` varchar(50) DEFAULT '',
  `nameaccount` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=latin1 COMMENT='information account user';

-- Dumping data for table mysql_tour.user_account: ~4 rows (approximately)
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` (`id`, `username_ac`, `access_right`, `date`, `password_ac`, `nameaccount`) VALUES
	(1, 'hoa', 'admin', '2020-07-28', '123456', 'duchoa'),
	(2, 'nghia', 'user', '2020-07-28', '123456', 'VanNghia'),
	(61, 'minh', 'user', '2020-07-28', '123456', 'minhcui'),
	(98, 'thien', 'admin', NULL, '123456', 'thienthan');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
