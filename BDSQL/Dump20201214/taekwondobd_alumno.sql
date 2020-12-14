-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: taekwondobd
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumno` (
  `id_Alumno` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `a_paterno` varchar(50) NOT NULL,
  `a_materno` varchar(50) DEFAULT NULL,
  `fotografia` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `seguro_medico` varchar(50) NOT NULL,
  `certificado_medico` varchar(50) NOT NULL,
  `carta_responsiva` varchar(50) NOT NULL,
  `actividad` varchar(45) NOT NULL,
  `grado` varchar(45) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_Alumno`),
  KEY `alumnofk1_idx` (`username`),
  CONSTRAINT `alumnofk1` FOREIGN KEY (`username`) REFERENCES `usuario` (`username`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'Aries','Becerra','Ruiz','C:\\fakepath\\1984.jpg','1996-04-09','1234h1234n','C:\\fakepath\\Tarea01.pdf','C:\\fakepath\\Tarea02.pdf','Kick Boxing','Principiante','BAries'),(2,'Alumno','Prueba','Jala','C:\\fakepath\\(500) Days of Summer.jpg','2011-11-11','1298238724687943','C:\\fakepath\\Ejercicio 1 ADA.pdf','C:\\fakepath\\Ejercicio 1 ADA.pdf','taekwondo','taekwondo','BAries'),(3,'Jesús Haans','López','Hernández','C:\\fakepath\\Alien 1.jpg','1996-04-16',',jsdghfjhadgfkuadhfjasdg','C:\\fakepath\\TDI-CódigosHTTP.pdf','C:\\fakepath\\TDI-JPA.pdf','Kick Boxing','Principiante','killerhaans'),(4,'Alumno','Prueba','Prueba','C:\\fakepath\\Ejercicio 1 ADA.pdf','2000-11-02','983764645287','C:\\fakepath\\Tarea03.pdf','C:\\fakepath\\Tarea04.pdf','taekwondo','8','BAries'),(6,'Alice','Apellido1','Apellido2','C:\\fakepath\\Tarea01.pdf','2001-05-11','jfshgjdfg','C:\\fakepath\\Tarea04.pdf','C:\\fakepath\\Tarea05.pdf','TaeKwonDo','Cinta Blanca','BAries'),(7,'Aries','Becerra','Ruiz','C:\\fakepath\\Tarea02.pdf','1996-04-09','sjadhgfkjahd','C:\\fakepath\\Tarea2.pdf','C:\\fakepath\\Tarea2.pdf','TaeKwonDo','Cinta Azul','BAries');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-14  4:23:15
