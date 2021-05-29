-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.24 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for proagil
CREATE DATABASE IF NOT EXISTS `proagil` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proagil`;

-- Dumping structure for table proagil.evento
CREATE TABLE IF NOT EXISTS `evento` (
  `evento_id` bigint NOT NULL AUTO_INCREMENT,
  `data_evento` datetime DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `local` varchar(80) DEFAULT NULL,
  `quantidade_pessoas` int DEFAULT NULL,
  `telefone` varchar(80) DEFAULT NULL,
  `tema` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`evento_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=LATIN1;


REPLACE INTO `evento` (`evento_id`, `data_evento`, `email`, `local`, `quantidade_pessoas`, `telefone`, `tema`) VALUES
	(1, '2021-07-05 00:00:00', 'evento@email.com', 'Santa Catarina', 2547, '119485578', 'Palestra sobre Aquecimento Global'),
	(2, '2021-08-08 00:00:00', 'angular@email.com', 'São Paulo', 254, '12345678', 'Angular JS'),
	(3, '2021-12-12 00:00:00', 'java@email.com', 'Minas Gerais', 2548, '1234567', 'Java + Hibernate'),
	(5, '2020-04-18 21:00:00', 'teste@teste.com', 'teste 2', 321, '123456', 'Teste 3');

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;