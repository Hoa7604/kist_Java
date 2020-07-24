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
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `tour_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_booking_tour_user` (`user_id`),
  KEY `FK_booking_tour_tour` (`tour_id`),
  CONSTRAINT `FK_booking_tour_tour` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`tour_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_booking_tour_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='information booking tour';

-- Dumping data for table mysql_tour.booking_tour: ~0 rows (approximately)
/*!40000 ALTER TABLE `booking_tour` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking_tour` ENABLE KEYS */;

-- Dumping structure for table mysql_tour.tour
CREATE TABLE IF NOT EXISTS `tour` (
  `tour_id` int(11) NOT NULL AUTO_INCREMENT,
  `nane_tour` varchar(50) DEFAULT '',
  `location_start` varchar(50) DEFAULT '',
  `time_start` time DEFAULT NULL,
  `date_start` date DEFAULT NULL,
  `mem_number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tour_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='infomation Tour ';

-- Dumping data for table mysql_tour.tour: ~0 rows (approximately)
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
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
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_user_user_account` FOREIGN KEY (`id`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='information for user\r\n';

-- Dumping data for table mysql_tour.user: ~0 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table mysql_tour.user_account
CREATE TABLE IF NOT EXISTS `user_account` (
  `id` int(11) NOT NULL,
  `username_ac` varchar(50) DEFAULT '',
  `user_pwdac` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='information account user';

-- Dumping data for table mysql_tour.user_account: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
