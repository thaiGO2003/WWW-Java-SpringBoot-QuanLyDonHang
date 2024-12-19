/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `quanlydonhang` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `quanlydonhang`;

CREATE TABLE IF NOT EXISTS `cua_hang` (
  `ma_cua_hang` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_cua_hang`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `cua_hang` (`ma_cua_hang`, `ten`) VALUES
	(1, 'Cua hang 1'),
	(2, 'Cua hang 2');

CREATE TABLE IF NOT EXISTS `don_hang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `ma_don_hang` varchar(255) DEFAULT NULL,
  `ngay_dat_hang` date NOT NULL,
  `ten_khach_hang` varchar(50) NOT NULL,
  `tensp` varchar(255) NOT NULL,
  `trang_thai` bit(1) NOT NULL,
  `ma_cua_hang` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4kymaakagxjkbm99g5vlrilih` (`ma_cua_hang`),
  CONSTRAINT `FK4kymaakagxjkbm99g5vlrilih` FOREIGN KEY (`ma_cua_hang`) REFERENCES `cua_hang` (`ma_cua_hang`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `don_hang` (`id`, `email`, `ma_don_hang`, `ngay_dat_hang`, `ten_khach_hang`, `tensp`, `trang_thai`, `ma_cua_hang`) VALUES
	(5, 'customer1@example.com', '20231218010101', '2023-12-18', 'Nguyen Van A', 'Product 1', b'1', 1),
	(6, 'customer2@example.com', '20231218010102', '2023-12-18', 'Tran Thi B', 'Product 2', b'0', 2),
	(7, 'customer3@example.com', '20231218010103', '2023-12-18', 'Le Thi C', 'Product 3', b'1', 1),
	(8, 'customer4@example.com', '20241219210524', '2024-12-20', 'Pham Minh D', 'Product 4', b'1', 2),
	(9, 'customer5@example.com', '20231218010105', '2023-12-18', 'Nguyen Thi E', 'Product 5', b'1', 2),
	(10, 'customer6@example.com', '20231218010106', '2023-12-18', 'Hoang Thi F', 'Product 6', b'1', 1),
	(11, 'customer7@example.com', '20231218010107', '2023-12-18', 'Mai Minh G', 'Product 7', b'0', 1),
	(12, 'customer8@example.com', '20231218010108', '2023-12-18', 'Vu Thi H', 'Product 8', b'1', 2),
	(13, 'customer9@example.com', '20231218010109', '2023-12-18', 'Bui Thi I', 'Product 9', b'1', 1),
	(14, 'customer10@example.com', '20231218010110', '2023-12-18', 'Do Thi J', 'Product 10', b'0', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
