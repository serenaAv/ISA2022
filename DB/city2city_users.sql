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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `email` varchar(60) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `resetpwtoken` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('detratti@gmail.com','Christian','Detratti','M','$2a$10$LskErPk1kMjagjcK64xwKOhoHC2HoPZUhCWgKU/sXtKHSiq9LuiHW','chrstian1',1,NULL),('marco.bianchi@prova.com','Marco','Bianchi','M','$2a$10$iI7xK3jE6UDIx.89XYiE..5y84lfcVVAaJa3NEmWvKQTLeaB8xtAa','marco2',2,NULL),('sere.avanzi@gmail.com','Serena','Avanzi','F','$2a$10$33hxeKpPEW7BajxpROh8zewCwz7zW81515OsklP74/SDbEDWIEeo.','serena3',3,NULL),('viola.rossi@prova.com','Viola','Rossi','F','$2a$10$Tc8q/B.RQ8n.znxJKD96QusFjHnba7czaYXNy/oD/j1OAj217//SG','viola4',4,'lw9m0H5OvW94T4PXfbXYihUwOHk0bPlz0OLHe28qNCXgN'),('bianco@prova.com','prova','prova2MOD','M','$2a$10$O0C9.3GVD4QXKSqRbPsix.D6KXXoXILps0VHce3pjd.HXqbmg2nU2','pp',11,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-02 11:25:55
