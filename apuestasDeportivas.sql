-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: apuestasdeportivas
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `parametros`
--

DROP TABLE IF EXISTS `parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parametros` (
  `puntosPorAcierto` int NOT NULL,
  `puntosExtra` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametros`
--

LOCK TABLES `parametros` WRITE;
/*!40000 ALTER TABLE `parametros` DISABLE KEYS */;
INSERT INTO `parametros` VALUES (3,5);
/*!40000 ALTER TABLE `parametros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `idPersona` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'pepe'),(2,'sara'),(3,'tito');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pronosticos`
--

DROP TABLE IF EXISTS `pronosticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pronosticos` (
  `idRonda` int NOT NULL,
  `idPartido` int NOT NULL,
  `idPersona` int NOT NULL,
  `nombrePersona` varchar(50) NOT NULL,
  `equipo` varchar(50) NOT NULL,
  `resultado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronosticos`
--

LOCK TABLES `pronosticos` WRITE;
/*!40000 ALTER TABLE `pronosticos` DISABLE KEYS */;
INSERT INTO `pronosticos` VALUES (1,1,1,'pepe','Ecuador','GANADOR'),(1,2,1,'pepe','Países Bajos','GANADOR'),(1,3,1,'pepe','Argentina','PERDEDOR'),(1,4,1,'pepe','México','EMPATE'),(2,5,1,'pepe','Alemania','EMPATE'),(2,6,1,'pepe','Senegal','GANADOR'),(2,7,1,'pepe','Irán','PERDEDOR'),(2,8,1,'pepe','Bélgica','PERDEDOR'),(3,9,1,'pepe','Francia','GANADOR'),(3,10,1,'pepe','Dinamarca','PERDEDOR'),(3,11,1,'pepe','Uruguay','GANADOR'),(3,12,1,'pepe','Corea del Sur','EMPATE'),(1,1,2,'sara','Ecuador','PERDEDOR'),(1,2,2,'sara','Países Bajos','EMPATE'),(1,3,2,'sara','Argentina','PERDEDOR'),(1,4,2,'sara','México','PERDEDOR'),(2,5,2,'sara','Alemania','EMPATE'),(2,6,2,'sara','Senegal','PERDEDOR'),(2,7,2,'sara','Irán','EMPATE'),(2,8,2,'sara','Bélgica','EMPATE'),(3,9,2,'sara','Francia','PERDEDOR'),(3,10,2,'sara','Dinamarca','GANADOR'),(3,11,2,'sara','Uruguay','EMPATE'),(3,12,2,'sara','Corea del Sur','GANADOR'),(1,1,3,'tito','Ecuador','PERDEDOR'),(1,2,3,'tito','Países Bajos','EMPATE'),(1,3,3,'tito','Argentina','EMPATE'),(1,4,3,'tito','México','PERDEDOR'),(2,5,3,'tito','Alemania','GANADOR'),(2,6,3,'tito','Senegal','GANADOR'),(2,7,3,'tito','Irán','GANADOR'),(2,8,3,'tito','Bélgica','EMPATE'),(3,9,3,'tito','Francia','EMPATE'),(3,10,3,'tito','Dinamarca','GANADOR'),(3,11,3,'tito','Uruguay','PERDEDOR'),(3,12,3,'tito','Corea del Sur','EMPATE');
/*!40000 ALTER TABLE `pronosticos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultadospartidos`
--

DROP TABLE IF EXISTS `resultadospartidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resultadospartidos` (
  `idPartido` int unsigned NOT NULL AUTO_INCREMENT,
  `idRonda` int NOT NULL,
  `equipo1` varchar(50) NOT NULL,
  `equipo2` varchar(50) NOT NULL,
  `golesEquipo1` int NOT NULL,
  `golesEquipo2` int NOT NULL,
  PRIMARY KEY (`idPartido`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultadospartidos`
--

LOCK TABLES `resultadospartidos` WRITE;
/*!40000 ALTER TABLE `resultadospartidos` DISABLE KEYS */;
INSERT INTO `resultadospartidos` VALUES (1,1,'Catar','Ecuador',0,1),(2,1,'Senegal','Países Bajos',0,2),(3,1,'Argentina','Arabia Saudita',1,2),(4,1,'México','Polonia',0,0),(5,2,'España','Alemania',1,1),(6,2,'Senegal','Japón',2,0),(7,2,'Inglaterra','Irán',2,0),(8,2,'Bélgica','Canadá',1,0),(9,3,'Francia','Australia',2,1),(10,3,'Dinamarca','Túnez',2,1),(11,3,'Portugal','Uruguay',2,1),(12,3,'Corea del Sur','Ghana',2,0);
/*!40000 ALTER TABLE `resultadospartidos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-24 23:18:49
