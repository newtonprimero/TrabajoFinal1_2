-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: taller_utp1
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aparato`
--

DROP TABLE IF EXISTS `aparato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aparato` (
  `id_aparato` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(60) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `nroSerie` varchar(50) NOT NULL,
  `estado_activ` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_aparato`),
  KEY `id_marca` (`id_marca`),
  CONSTRAINT `aparato_ibfk_1` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aparato`
--

LOCK TABLES `aparato` WRITE;
/*!40000 ALTER TABLE `aparato` DISABLE KEYS */;
INSERT INTO `aparato` VALUES (1,'El aparato no prende despues de apretar el boton on',5,'n-355a',1),(2,'El aparato no da vueltas',4,'54544-555-ddf',1),(3,'el aparato presenta problemas de comunicaciÃ³n ',3,'aad-dd-w-w',1),(4,'el aparato no prende',4,'kfr-87-4',1),(5,'se calienta en exceso',3,'aad-dd-w-wer',1),(6,'se calienta en exceso',3,'aad-dd-w-wer',1),(7,'se calienta en exceso ',6,'aad-dd-w-fg',1),(8,'se calienta en exceso ',6,'aad-dd-w-fg',1),(9,'dasdasdasdasd',2,'asdasdas',1),(10,'dasdasd',5,'asdsad',1),(11,'dasfasasda',2,'dasdasd',1),(12,'el aparato no prende',2,'lll-565-78',1),(13,'asddasdasd',4,'aad-dd-w-fg',1),(14,'asdsad dassssssdas dasdasdas',3,'45',1),(15,'asdsad dassssssdas dasdasdas',3,'45',1),(16,'sdkasdkas laksdklasjdlaks',2,'aad-dd-w-w',1),(17,'sdkasdkas laksdklasjdlaks',2,'aad-dd-w-w',1),(18,'No enciende con el botton',3,'lll-565-78',1),(19,'sfadfasf',2,'aad-dd-w-wer',1),(20,'El aparato suena mucho y no funciona su motor',4,'aad-dd-w-w',1);
/*!40000 ALTER TABLE `aparato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cita` (
  `id_cita` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `id_aparato` int(11) NOT NULL,
  `id_distrito` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `presupuesto` double DEFAULT NULL,
  `estado_activ` tinyint(1) NOT NULL,
  `telefono` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_cita`),
  KEY `id_persona` (`id_persona`),
  KEY `id_aparato` (`id_aparato`),
  KEY `id_distrito` (`id_distrito`),
  CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`),
  CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`id_aparato`) REFERENCES `aparato` (`id_aparato`),
  CONSTRAINT `cita_ibfk_3` FOREIGN KEY (`id_distrito`) REFERENCES `distrito` (`id_distrito`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
INSERT INTO `cita` VALUES (1,4,1,3,'Av. ejercito 100','2022-05-31 01:04:00',NULL,1,NULL),(3,4,3,3,'Jerusalen 104','2022-06-02 14:10:00',NULL,1,NULL),(4,4,9,2,'asdasdasd','2022-06-03 12:42:36',NULL,1,NULL),(5,4,10,2,'dasdasdas','2022-06-03 13:09:37',839,1,NULL),(6,4,11,2,'Pj. rollo argentina mz. 4','2022-06-03 17:26:22',NULL,1,NULL),(7,4,12,4,'Pj. rollo argentina mz. 4','2022-06-13 01:57:55',NULL,1,NULL),(8,4,13,3,'Las garrapatas 206','2022-06-13 02:05:06',NULL,1,NULL),(9,3,14,3,'Jerusalen 208','2022-06-28 19:44:00',100,1,123456789),(10,3,15,3,'Jerusalen 208','2022-06-29 19:44:00',53,1,123456789),(11,4,16,2,'Pj. rollo argentina mz. 4','2022-06-30 13:35:00',0,1,954875123),(12,4,17,2,'Pj. rollo argentina mz. 4','2022-06-30 13:35:00',0,1,954875123),(13,3,18,3,'Jerusalen 208','2022-06-29 17:24:00',59.9,1,123456789),(14,4,19,2,'Jerusalen 104','2022-06-27 17:31:21',NULL,1,NULL),(15,4,20,2,'Jerusalen 104','2022-07-24 17:37:24',NULL,1,NULL);
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalles_servicio`
--

DROP TABLE IF EXISTS `detalles_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalles_servicio` (
  `id_detalles` int(11) NOT NULL AUTO_INCREMENT,
  `id_servicio` int(11) NOT NULL,
  `id_repuesto` int(11) NOT NULL,
  `costo` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `sub_total` double NOT NULL,
  PRIMARY KEY (`id_detalles`),
  KEY `id_repuesto` (`id_repuesto`),
  KEY `id_servicio` (`id_servicio`),
  CONSTRAINT `detalles_servicio_ibfk_1` FOREIGN KEY (`id_repuesto`) REFERENCES `repuesto` (`id_repuesto`),
  CONSTRAINT `detalles_servicio_ibfk_2` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id_servicio`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalles_servicio`
--

LOCK TABLES `detalles_servicio` WRITE;
/*!40000 ALTER TABLE `detalles_servicio` DISABLE KEYS */;
INSERT INTO `detalles_servicio` VALUES (2,1,2,59.9,1,59.9),(3,1,2,59.9,1,59.9),(4,1,3,59,1,59),(5,2,1,195,2,390),(6,2,3,59,1,59),(7,3,4,28.5,1,28.5),(8,3,1,195,1,195),(9,4,4,28.5,1,28.5),(11,6,4,28.5,1,28.5),(12,7,4,28.5,1,28.5),(13,7,4,28.5,1,28.5),(14,7,4,28.5,1,28.5);
/*!40000 ALTER TABLE `detalles_servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalles_servicio_domi`
--

DROP TABLE IF EXISTS `detalles_servicio_domi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalles_servicio_domi` (
  `id_detalles_domi` int(11) NOT NULL AUTO_INCREMENT,
  `id_servicio` int(11) NOT NULL,
  `id_repuesto` int(11) NOT NULL,
  `costo` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `sub_total` double NOT NULL,
  PRIMARY KEY (`id_detalles_domi`),
  KEY `id_servicio` (`id_servicio`),
  KEY `id_repuesto` (`id_repuesto`),
  CONSTRAINT `detalles_servicio_domi_ibfk_1` FOREIGN KEY (`id_servicio`) REFERENCES `servicio_domicilio` (`id_servicio_domi`),
  CONSTRAINT `detalles_servicio_domi_ibfk_2` FOREIGN KEY (`id_repuesto`) REFERENCES `repuesto` (`id_repuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalles_servicio_domi`
--

LOCK TABLES `detalles_servicio_domi` WRITE;
/*!40000 ALTER TABLE `detalles_servicio_domi` DISABLE KEYS */;
INSERT INTO `detalles_servicio_domi` VALUES (1,1,2,59.9,1,59.9),(2,1,3,59,1,59),(3,2,3,59,2,118),(4,2,1,195,1,195),(6,2,2,59.9,1,59.9),(7,2,1,195,1,195),(8,2,3,59,1,59),(9,2,3,59,3,177),(10,1,1,195,1,195),(11,1,4,28.5,3,85.5),(12,1,2,59.9,2,119.8),(13,1,1,195,1,195),(14,1,4,28.5,1,28.5),(15,2,1,195,2,390),(16,1,4,28.5,1,28.5),(17,2,4,28.5,1,28.5);
/*!40000 ALTER TABLE `detalles_servicio_domi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distrito`
--

DROP TABLE IF EXISTS `distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distrito` (
  `id_distrito` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_distrito` varchar(50) NOT NULL,
  `estado_activ` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_distrito`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distrito`
--

LOCK TABLES `distrito` WRITE;
/*!40000 ALTER TABLE `distrito` DISABLE KEYS */;
INSERT INTO `distrito` VALUES (1,'Alto Selva Alegre',1),(2,'Cayma',1),(3,'Cercado',1),(4,'Yanahuara',1),(5,'Mirafloress',1);
/*!40000 ALTER TABLE `distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidad` (
  `id_especialidad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidad`
--

LOCK TABLES `especialidad` WRITE;
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
INSERT INTO `especialidad` VALUES (1,'Tecnico Electronico'),(2,'Técnico Reparación'),(3,'Ninguno');
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoja_servicio`
--

DROP TABLE IF EXISTS `hoja_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hoja_servicio` (
  `id_hoja` int(11) NOT NULL AUTO_INCREMENT,
  `id_servicio` int(11) NOT NULL,
  `estado_activ` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_hoja`),
  KEY `id_servicio` (`id_servicio`),
  CONSTRAINT `hoja_servicio_ibfk_1` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id_servicio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoja_servicio`
--

LOCK TABLES `hoja_servicio` WRITE;
/*!40000 ALTER TABLE `hoja_servicio` DISABLE KEYS */;
INSERT INTO `hoja_servicio` VALUES (1,2,1);
/*!40000 ALTER TABLE `hoja_servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoja_servicio_domi`
--

DROP TABLE IF EXISTS `hoja_servicio_domi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hoja_servicio_domi` (
  `id_hoja` int(11) NOT NULL AUTO_INCREMENT,
  `id_servicio` int(11) NOT NULL,
  `estado_activ` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_hoja`),
  KEY `id_servicio` (`id_servicio`),
  CONSTRAINT `hoja_servicio_domi_ibfk_1` FOREIGN KEY (`id_servicio`) REFERENCES `servicio_domicilio` (`id_servicio_domi`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoja_servicio_domi`
--

LOCK TABLES `hoja_servicio_domi` WRITE;
/*!40000 ALTER TABLE `hoja_servicio_domi` DISABLE KEYS */;
INSERT INTO `hoja_servicio_domi` VALUES (7,1,1),(8,2,1),(9,2,1);
/*!40000 ALTER TABLE `hoja_servicio_domi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horarios` (
  `id_horario` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora_ini` time NOT NULL,
  `hora_fin` time NOT NULL,
  `estado_activ` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_horario`),
  KEY `id_persona` (`id_persona`),
  CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (1,2,'2022-05-16','14:37:54','18:37:54',1),(2,2,'2022-05-31','15:30:13','18:15:13',1),(9,2,'2022-06-01','16:59:00','17:59:00',0),(10,2,'2022-05-31','20:46:00','23:46:00',0),(11,2,'2022-06-21','08:23:00','09:23:00',0),(12,2,'2022-06-02','02:20:00','04:21:00',0),(13,2,'2022-06-02','03:25:00','22:29:00',0),(14,2,'2022-06-02','03:25:00','22:29:00',0),(15,2,'2022-06-02','01:27:00','03:27:00',1),(17,2,'2022-06-02','07:30:00','08:30:00',1),(19,2,'2022-06-02','08:36:00','09:37:00',1),(20,10,'2022-06-15','08:38:44','09:38:44',1),(21,10,'2022-06-05','08:39:00','09:40:00',0),(22,2,'2022-06-05','18:25:00','20:26:00',0),(23,10,'2022-06-14','07:56:00','08:56:00',0),(24,10,'2022-06-15','08:04:00','10:04:00',0),(25,2,'2022-06-15','11:44:00','12:45:00',1),(26,10,'2022-06-15','18:09:00','20:09:00',1),(27,10,'2022-06-21','13:50:00','15:47:00',1),(29,2,'2022-06-28','15:45:00','17:45:00',0),(30,10,'2022-07-25','17:54:00','18:54:00',0),(31,9,'2022-07-26','12:10:04','13:10:04',1);
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `id_marca` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'NBX'),(2,'JVC'),(3,'Oster'),(4,'Samsung'),(5,'LG'),(6,'Sony');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca_repuesto`
--

DROP TABLE IF EXISTS `marca_repuesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca_repuesto` (
  `id_marca_rep` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_marca_rep`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca_repuesto`
--

LOCK TABLES `marca_repuesto` WRITE;
/*!40000 ALTER TABLE `marca_repuesto` DISABLE KEYS */;
INSERT INTO `marca_repuesto` VALUES (1,'iRobot Roomba'),(2,'Fagor'),(3,'Philips'),(4,'Oster');
/*!40000 ALTER TABLE `marca_repuesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `dni` int(11) NOT NULL,
  `id_distrito` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `id_especialidad` int(11) NOT NULL,
  `telefono1` int(11) NOT NULL,
  `telefono2` int(11) DEFAULT NULL,
  `estado_activ` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_persona`),
  KEY `id_distrito` (`id_distrito`),
  KEY `id_especialidad` (`id_especialidad`),
  CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`id_distrito`) REFERENCES `distrito` (`id_distrito`),
  CONSTRAINT `persona_ibfk_2` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidad` (`id_especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Juan Cristiano','Perez Lazo',12345678,1,'Pj Marron Las Torres j 16',2,987654321,987456123,1),(2,'Maria Lazo','Zeballos',12345678,2,'Av.cayma 105',2,123456789,NULL,1),(3,'Timo Andres','Warner Perez',87654321,3,'Jerusalen 208',3,123456789,NULL,1),(4,'Claudia','Rozales Marin',12345678,2,'Pj. rollo argentina mz. 4',3,954875123,223654,0),(5,'Ramiro','Suarez Prieto',12345678,1,'Jerusalen 104',3,211547,958745123,1),(6,'Pedro Ramiro','Vegazo Jordan',87654321,2,'Pj. rollo argentina mz. 4',3,955998897,955998897,1),(7,'Juan','Zapana Apaza',65487321,4,'Jerusalen 104',3,123456789,123456789,1),(8,'Pedro','Vegazo Jordan',78546213,2,'Pj. rollo argentina mz. 4',3,987654414,987654414,1),(9,'Chacal','Prado Benites',74689512,1,'Los coritos 502',3,987654321,NULL,1),(10,'Maria Mercedess','Pato Feliz',654232144,3,'la calle nueva de la esquina',1,254652312,0,0),(12,'Santiago','Zapana Apaza',22546879,2,'Pj. rollo argentina mz. 4',1,1232456,0,1);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repuesto`
--

DROP TABLE IF EXISTS `repuesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repuesto` (
  `id_repuesto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_repuesto` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `precio` double NOT NULL,
  `estado_activ` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_repuesto`),
  KEY `id_marca` (`id_marca`),
  CONSTRAINT `repuesto_ibfk_1` FOREIGN KEY (`id_marca`) REFERENCES `marca_repuesto` (`id_marca_rep`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repuesto`
--

LOCK TABLES `repuesto` WRITE;
/*!40000 ALTER TABLE `repuesto` DISABLE KEYS */;
INSERT INTO `repuesto` VALUES (1,'Cuchilla reemplazable QP220/51',10,3,195,1),(2,'OneBlade Cuchilla reemplazable\r\nQP210/51',10,3,59.9,1),(3,'Vaso vidrio Boroclass® 1.25 litros Oster® BLSTAJ-GTS-011',15,4,59,1),(4,'Cuchilla picahielo Oster® 6 aspas 4980',5,4,28.5,1);
/*!40000 ALTER TABLE `repuesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Encargado'),(2,'Técnico'),(3,'Cliente');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicio` (
  `id_servicio` int(11) NOT NULL AUTO_INCREMENT,
  `id_cita` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `id_tecnico` int(11) NOT NULL,
  `total` double DEFAULT NULL,
  `estado_activ` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_servicio`),
  KEY `id_tipo` (`id_tipo`),
  KEY `id_tecnico` (`id_tecnico`),
  KEY `id_cita` (`id_cita`),
  CONSTRAINT `servicio_ibfk_2` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_servicio` (`id_tipoServicio`),
  CONSTRAINT `servicio_ibfk_3` FOREIGN KEY (`id_tecnico`) REFERENCES `persona` (`id_persona`),
  CONSTRAINT `servicio_ibfk_4` FOREIGN KEY (`id_cita`) REFERENCES `cita` (`id_cita`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (1,1,2,10,178.8,0),(2,5,2,10,839,0),(3,6,2,2,195,0),(4,9,1,10,28.5,0),(5,10,1,10,20,0),(6,11,1,10,57,0),(7,12,1,10,85.5,0),(8,13,1,10,NULL,1);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio_domicilio`
--

DROP TABLE IF EXISTS `servicio_domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicio_domicilio` (
  `id_servicio_domi` int(11) NOT NULL AUTO_INCREMENT,
  `id_cita` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `id_horario` int(11) NOT NULL,
  `total` double DEFAULT NULL,
  `estado_activ` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_servicio_domi`),
  KEY `id_cita` (`id_cita`),
  KEY `id_tipo` (`id_tipo`),
  KEY `id_horario` (`id_horario`),
  CONSTRAINT `servicio_domicilio_ibfk_1` FOREIGN KEY (`id_cita`) REFERENCES `cita` (`id_cita`),
  CONSTRAINT `servicio_domicilio_ibfk_2` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_servicio` (`id_tipoServicio`),
  CONSTRAINT `servicio_domicilio_ibfk_3` FOREIGN KEY (`id_horario`) REFERENCES `horarios` (`id_horario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio_domicilio`
--

LOCK TABLES `servicio_domicilio` WRITE;
/*!40000 ALTER TABLE `servicio_domicilio` DISABLE KEYS */;
INSERT INTO `servicio_domicilio` VALUES (1,7,2,23,223.5,0),(2,8,2,24,57,0),(3,14,2,29,NULL,1),(4,15,2,30,NULL,1);
/*!40000 ALTER TABLE `servicio_domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_servicio`
--

DROP TABLE IF EXISTS `tipo_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_servicio` (
  `id_tipoServicio` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `estado_activ` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_tipoServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_servicio`
--

LOCK TABLES `tipo_servicio` WRITE;
/*!40000 ALTER TABLE `tipo_servicio` DISABLE KEYS */;
INSERT INTO `tipo_servicio` VALUES (1,'AtenciónTaller',1),(2,'Atención Domicilio',1);
/*!40000 ALTER TABLE `tipo_servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `contrasena` varchar(20) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `estado_activ` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `id_persona` (`id_persona`),
  KEY `id_rol` (`id_rol`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`),
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,1,'juancristiano@gmail.com','123456','2022-05-29 21:16:35',1),(2,2,2,'marialuz@gmail.com','123456','2022-05-30 04:17:14',1),(3,3,3,'timoandres@gmail.com','123456','2022-05-29 21:17:56',1),(4,4,3,'rozalesmarin@gmail.com','123456','2022-05-29 21:28:47',1),(5,5,3,'altod@gmail.com','123456','2022-05-30 17:44:18',1),(6,6,2,'vegazojordanpedro@gmail.com','1234562','2022-06-01 23:18:01',1),(7,7,3,'zapanaapaza@gmail.com','123456','2022-06-01 23:24:32',1),(8,8,3,'vegazojordan@gmail.com','123456','2022-06-01 23:36:54',1),(9,9,2,'vegazojordan@gmail.com','123456','2022-06-01 23:46:10',1),(10,10,2,'maria@gmail.com','123456','2022-06-02 11:39:14',1),(11,10,2,'adsadasd@gmail.com','123456','2022-06-03 17:21:31',1),(12,12,2,'dasdas@gmail.com','123456','2022-06-03 17:22:48',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-25 11:02:51
