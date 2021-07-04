CREATE DATABASE  IF NOT EXISTS `casestudy` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `casestudy`;
-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: casestudy
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Laptop'),(2,'Điện thoại'),(3,'Máy ảnh'),(4,'Phụ kiện');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `passWord` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `isSell` int DEFAULT NULL,
  `isAdmin` int DEFAULT NULL,
  `logincol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `logincol_UNIQUE` (`logincol`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'thien','123',NULL,1,0,NULL),(2,'long','123',NULL,1,0,NULL),(3,'quang','123',NULL,1,0,NULL),(4,'nam','123',NULL,1,0,NULL),(5,'admin','123',NULL,NULL,1,NULL),(17,'tin','123','tinasda@a.cin',0,0,NULL);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `com`
--

DROP TABLE IF EXISTS `com`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `image` longtext NOT NULL,
  `price` float NOT NULL,
  `categoryId` int NOT NULL,
  `sell_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `com`
--

LOCK TABLES `com` WRITE;
/*!40000 ALTER TABLE `com` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'LAPTOP DELL VOSTRO 5301','https://st.quantrimang.com/photos/image/102012/11/Laptop-Acer.jpg',11111,1,1),(3,'SAMSUNG Galaxy j7','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRm_sfgQPCsNaQ7GYgqIeO3Sv913okR1NfTuUWjsMGh7fX6UXjP9-f9KA_H4yb-pQwmxgs&usqp=CAU',123321,1,2),(5,'LAPTOP DELL INSPIRON 3501','https://laptophunganh.vn/cdn/images/man-hinh-dell-inspiron-7559(2).jpg',120000,1,1),(6,'LAPTOP DELL INSPIRON 3501','https://hdlaptop.com.vn/img/thay-man-hinh-laptop-dell.PNG',200000,1,1),(7,'LAPTOP DELL GAMING G5 15 5500','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWRG0uN4Yjuhij6z33ri_un7bLO0siEVWywOFvT5qQ-SirOXM8TWhTf8S8kesTUBn0YSs&usqp=CAU',120000,1,1),(8,'SAMSUNG Galaxy S8','https://cdn.tgdd.vn/Products/Images/42/213023/xiaomi-mi-note-10-white-600x600.jpg',140000,2,2),(9,'SAMSUNG Galaxy S7 edge','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTl9N4p8VSjMER_AWBrO2wVu1EMhjcxcHXuZKgmxmo2FI1bkpYzgRy5ldbDJOBbi62t2-E&usqp=CAU',123000,2,2),(10,'SAMSUNG Galaxy A32','https://cdn.tgdd.vn/Products/Images/42/226463/Samsung-Galaxy-a32-5G--600x600.jpg',122000,2,2),(13,'Sony Alpha A7R','https://binhminhdigital.com/StoreData/Product/5730/M%C3%A1y%20%E1%BA%A2nh%20Sony%20Alpha%20A7R%203.jpg',230000,3,3),(14,'ASTRO Zoom AZ361','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFDLmx68tm7Qxt9V3wToA_alkZZvRLtFD81w&usqp=CAU',450000,3,3),(15,'Đèn trợ sáng ','https://media3.scdn.vn/img3/2019/11_24/WJpn4P_simg_d0daf0_800x1200_max.jpg',120000,4,4),(16,'Trợ sáng A42','https://cf.shopee.vn/file/a8e12b348532e508ff06c99a6224c27b',12300,4,4),(17,'Chân bạch tuột ','https://metrophone.vn/wp-content/uploads/2021/03/chan-bach-tuoc-may-anh-va-dien-thoai-ulanzi-mt-11-v2-thum-010.jpg',160000,4,4),(18,'Pin','https://salt.tikicdn.com/ts/com/a5/f5/4b/eb60fe9b5876f03fece2401949facf18.jpg',2000,4,4),(19,'Sạc dự phòng','https://smartnew.vn/upload_images/images/2021/01/27/sac-du-phong-sac-nhanh-2.jpg',19000,4,4),(20,'Pin dự phòng Aukey PB-T10 20.000 mAh','http://samsungstore.com.vn/wp-content/uploads/2017/03/1.jpg',120000,4,4),(21,'SAMSUNG GALAXY J22','https://cdn.mediamart.vn/Product/dien-thoai-samsung-galaxy-a32-128g-a325f-tim-g20x5t.jpg',213000,2,2),(22,'Xiao MI RedMi Not 10','https://cdn.tgdd.vn/Products/Images/42/222758/xiaomi-redmi-note-10-thumb-green-600x600.jpg',120000,2,2),(23,'EXPERIA F8','https://useful.vn/wp-content/uploads/1559703236685_2379754.jpg',1234,1,3),(57,'MSI Gaming GTR 1200','https://cdn.tgdd.vn/Files/2015/08/23/688623/csm_asus_gl552_front_7ad75b2f92.jpg',100000,1,1),(68,'laptop MSI','https://laptop88.vn/media/com/4907_4325_9s7_17e221_485_image_main_600x600.jpg',19999,1,5),(69,'laptop 4k','https://useful.vn/wp-content/uploads/1568434181045_8658978.png',1999.2,1,5),(71,'camera H1','https://binhminhdigital.com/StoreData/PageData/1380/may-anh-tam-trung-dang-mua3.jpg',230000,1,3);
/*!40000 ALTER TABLE `com` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-08 14:24:07
