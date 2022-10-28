-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: city2city
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `travels`
--

DROP TABLE IF EXISTS `travels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travels` (
  `id_travels` int NOT NULL,
  `date_travel` date DEFAULT NULL,
  `time_dep_real` time DEFAULT NULL,
  `time_arr_real` time DEFAULT NULL,
  `n_pass` int DEFAULT NULL,
  `id_bus` int DEFAULT NULL,
  `id_link` int DEFAULT NULL,
  PRIMARY KEY (`id_travels`),
  KEY `id_link_idx` (`id_link`),
  KEY `id_bus_idx` (`id_bus`),
  CONSTRAINT `id_bus` FOREIGN KEY (`id_bus`) REFERENCES `bus` (`id_bus`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_link` FOREIGN KEY (`id_link`) REFERENCES `links` (`id_links`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travels`
--

LOCK TABLES `travels` WRITE;
/*!40000 ALTER TABLE `travels` DISABLE KEYS */;
INSERT INTO `travels` VALUES (1,'2020-05-18','09:45:00','13:30:00',20,1,2),(2,'2020-07-24','09:05:00','13:00:00',30,4,1),(3,'2021-02-18','10:00:00','18:30:00',50,2,3),(4,'2021-06-28','05:35:00','15:45:00',40,3,4);
/*!40000 ALTER TABLE `travels` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-19 22:22:34
