-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: bantay_sinta_db
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reports` (
  `id` int NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `description` text,
  `image_path` varchar(255) DEFAULT NULL,
  `certification` tinyint(1) DEFAULT NULL,
  `profile_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `student_number` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `profile_id` (`profile_id`),
  CONSTRAINT `reports_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
INSERT INTO `reports` VALUES (1,'oh norr','dyan lang','oh naurr help me kuya ate','path/to/image',1,NULL,-1,NULL,NULL),(2,'aaaaaaaaa','aaaaaaaaaaa','aaaaaaaaaaaaaaaaaa','path/to/image',1,NULL,-1,NULL,NULL),(3,'gasd','gasdgasdgfas','fsdfSFS','path/to/image',1,NULL,-1,NULL,NULL),(4,'dfgfdg','dgadgadg','adgdfagadfg','path/to/image',1,NULL,-1,NULL,NULL),(5,'test','test','test','test',1,NULL,NULL,NULL,NULL),(6,'test','test','test','agfdgfdgdfg',1,NULL,NULL,NULL,NULL),(7,'test','test','test','99dd2e514d6f0b17d2f2a5e06808024c.jpg',1,NULL,NULL,NULL,NULL),(8,'ayoko na','sa bahay','gusto ko na po matulog','99dd2e514d6f0b17d2f2a5e06808024c.jpg',1,NULL,NULL,'',NULL),(9,'ayoko na','sa bahay','gusto ko na po matulog','99dd2e514d6f0b17d2f2a5e06808024c.jpg',1,NULL,NULL,'',NULL),(10,'ayoko na','sa bahay','gusto ko na po matulog','99dd2e514d6f0b17d2f2a5e06808024c.jpg',1,NULL,NULL,'',NULL),(11,'ayoko na','sa bahay','gusto ko na po matulog','',1,NULL,NULL,'',NULL),(12,'ayoko na','sa bahay','gusto ko na po matulog','99dd2e514d6f0b17d2f2a5e06808024c.jpg',1,NULL,NULL,'',NULL),(13,'ayoko na','promise','AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA','hahaha.png',1,NULL,NULL,NULL,NULL),(14,'hello','sa bahay poi\\','di ko po madebug haha','hello.png',1,NULL,NULL,NULL,NULL),(15,'sdfasd','asdfas','sdfsDF','sdasd.png',1,NULL,NULL,NULL,NULL),(16,'a','a','a','sdasdsa',1,NULL,NULL,NULL,NULL),(17,'1','1','1','d',1,NULL,NULL,NULL,NULL),(18,'2','2','2','imagePath',1,NULL,NULL,'1',NULL),(19,'5','5','5','C:\\Users\\Lenovo\\OneDrive - Polytechnic University of the Philippines\\Desktop\\Photos\\309380610_1282885652561622_4499804001374122973_n.jpg',1,NULL,NULL,'1','309380610_1282885652561622_4499804001374122973_n.jpg'),(20,'6','6','6','C:\\Users\\Lenovo\\OneDrive - Polytechnic University of the Philippines\\Desktop\\Photos\\5d91aed1367d95b1e06fef51f6723513.jpg',1,NULL,NULL,'1','5d91aed1367d95b1e06fef51f6723513.jpg');
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-11 20:31:36
