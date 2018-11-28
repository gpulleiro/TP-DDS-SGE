-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: prueba
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `prueba`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `prueba` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `prueba`;

--
-- Table structure for table `actuador`
--

DROP TABLE IF EXISTS `actuador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actuador` (
  `TIPO` varchar(31) NOT NULL,
  `ID_ACTUADOR` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_ACTUADOR`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actuador`
--

LOCK TABLES `actuador` WRITE;
/*!40000 ALTER TABLE `actuador` DISABLE KEYS */;
INSERT INTO `actuador` VALUES ('ENCENDER',1),('APAGAR',2);
/*!40000 ALTER TABLE `actuador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `ID_CAT` bigint(20) NOT NULL AUTO_INCREMENT,
  `CARGO_FIJO` float DEFAULT NULL,
  `CARGO_VAR` float DEFAULT NULL,
  `CONSUMO` float DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_CAT`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,18.76,0.644,150,'R1'),(2,18.76,0.644,150,'R1');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumos`
--

DROP TABLE IF EXISTS `consumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumos` (
  `id_consumo` int(11) DEFAULT NULL,
  `id_dispositivo` int(11) DEFAULT NULL,
  `fecha` text,
  `cant_horas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumos`
--

LOCK TABLES `consumos` WRITE;
/*!40000 ALTER TABLE `consumos` DISABLE KEYS */;
INSERT INTO `consumos` VALUES (1,1,'1/1/2018',360),(2,1,'1/2/2018',37),(3,1,'1/3/2018',4),(4,2,'1/1/2018',360),(5,2,'1/2/2018',28),(6,2,'1/3/2018',46),(7,3,'1/1/2018',32),(8,3,'1/2/2018',34),(9,3,'1/3/2018',72),(10,4,'1/1/2018',12),(11,4,'1/2/2018',23),(12,4,'1/3/2018',22),(13,5,'1/1/2018',6),(14,5,'1/2/2018',19),(15,5,'1/3/2018',4),(16,6,'1/1/2018',81),(17,6,'1/2/2018',81),(18,6,'1/3/2018',7),(19,7,'1/1/2018',19),(20,7,'1/2/2018',87),(21,7,'1/3/2018',38),(22,8,'1/1/2018',6),(23,8,'1/2/2018',67),(24,8,'1/3/2018',12),(25,9,'1/1/2018',16),(26,9,'1/2/2018',100),(27,9,'1/3/2018',69),(28,10,'1/1/2018',72),(29,10,'1/2/2018',41),(30,10,'1/3/2018',67),(31,11,'1/1/2018',20),(32,11,'1/2/2018',64),(33,11,'1/3/2018',97),(34,12,'1/1/2018',1),(35,12,'1/2/2018',58),(36,12,'1/3/2018',65),(37,13,'1/1/2018',66),(38,13,'1/2/2018',22),(39,13,'1/3/2018',12),(40,14,'1/1/2018',96),(41,14,'1/2/2018',71),(42,14,'1/3/2018',21),(43,15,'1/1/2018',29),(44,15,'1/2/2018',26),(45,15,'1/3/2018',79),(46,16,'1/1/2018',65),(47,16,'1/2/2018',25),(48,16,'1/3/2018',95),(49,17,'1/1/2018',66),(50,17,'1/2/2018',39),(51,17,'1/3/2018',13),(52,18,'1/1/2018',30),(53,18,'1/2/2018',56),(54,18,'1/3/2018',65),(55,19,'1/1/2018',89),(56,19,'1/2/2018',57),(57,19,'1/3/2018',81),(58,20,'1/1/2018',15),(59,20,'1/2/2018',46),(60,20,'1/3/2018',51),(61,21,'1/1/2018',49),(62,21,'1/2/2018',22),(63,21,'1/3/2018',55),(64,22,'1/1/2018',98),(65,22,'1/2/2018',43),(66,22,'1/3/2018',81),(67,23,'1/1/2018',81),(68,23,'1/2/2018',40),(69,23,'1/3/2018',50),(70,24,'1/1/2018',65),(71,24,'1/2/2018',7),(72,24,'1/3/2018',28);
/*!40000 ALTER TABLE `consumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordenadas`
--

DROP TABLE IF EXISTS `coordenadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coordenadas` (
  `ID_COORD` bigint(20) NOT NULL AUTO_INCREMENT,
  `LATITUD` double DEFAULT NULL,
  `LONGITUD` double DEFAULT NULL,
  PRIMARY KEY (`ID_COORD`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordenadas`
--

LOCK TABLES `coordenadas` WRITE;
/*!40000 ALTER TABLE `coordenadas` DISABLE KEYS */;
INSERT INTO `coordenadas` VALUES (1,-34.6061408,-58.3787749),(2,-34.6037313,-58.3840308),(3,-34.6041238,-58.385562),(4,-34.605343,-58.387077),(5,-34.606155,-58.38506),(6,-34.601281,-58.379395),(7,-34.605731,-58.379395);
/*!40000 ALTER TABLE `coordenadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispositivo`
--

DROP TABLE IF EXISTS `dispositivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispositivo` (
  `TIPO` varchar(31) NOT NULL,
  `ID_DISP` bigint(20) NOT NULL AUTO_INCREMENT,
  `CONS_FIJO` double DEFAULT NULL,
  `MAX_HORAS` double DEFAULT NULL,
  `MIN_HORAS` double DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `ESTADO` varchar(255) DEFAULT NULL,
  `CANT_HORAS` int(11) DEFAULT NULL,
  `sensor_ID_SENSOR` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_DISP`),
  KEY `FK_5jm1l3f79oegj37612vns8gf1` (`sensor_ID_SENSOR`),
  CONSTRAINT `FK_5jm1l3f79oegj37612vns8gf1` FOREIGN KEY (`sensor_ID_SENSOR`) REFERENCES `sensor` (`ID_SENSOR`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispositivo`
--

LOCK TABLES `dispositivo` WRITE;
/*!40000 ALTER TABLE `dispositivo` DISABLE KEYS */;
INSERT INTO `dispositivo` VALUES ('INT',1,1.6130000352859497,360,90,'Aire acondicionado 3500 frigorias','apagado',NULL,NULL),('INT',2,1.0130000114440918,360,90,'Aire acondicionado 2200 frigorias','apagado',NULL,NULL),('STD',3,0.07500000298023224,360,90,'Televisor color de tubo fluorecente de 21',NULL,2,NULL),('STD',4,0.17499999701976776,360,90,'Televisor color de tubo fluorecente de 29 a 34',NULL,3,NULL),('STD',5,0.18000000715255737,360,90,'Televisor LCD 40',NULL,4,NULL),('INT',6,0.03999999910593033,360,90,'Televisor LED 24','apagado',NULL,NULL),('INT',7,0.054999999701976776,360,90,'Televisor LED 32','apagado',NULL,NULL),('INT',8,0.07999999821186066,360,90,'Televisor LED 40','apagado',NULL,NULL),('INT',9,0.09000000357627869,360,90,'Heladera con freezer','apagado',NULL,NULL),('INT',10,0.07500000298023224,360,90,'Heladera sin freezer','apagado',NULL,NULL),('STD',11,0.875,30,6,'Lavarropas automatico de 5kg con calentamiento de agua',NULL,2,NULL),('INT',12,0.17499999701976776,30,6,'Lavarropas automatico de 5kg','apagado',NULL,NULL),('STD',13,0.1274999976158142,30,6,'Lavarropas semiautomatico de 5kg',NULL,2,NULL),('STD',14,0.09000000357627869,360,120,'Ventilador de pie',NULL,2,NULL),('INT',15,0.05999999865889549,360,120,'Ventilador de techo','apagado',NULL,NULL),('INT',16,0.03999999910593033,360,90,'Lampara halogenas de 40w ','apagado',NULL,NULL),('INT',17,0.05999999865889549,360,90,'Lampara halogenas de 60w ','apagado',NULL,NULL),('INT',18,0.014999999664723873,360,90,'Lampara halogenas de 100w ','apagado',NULL,NULL),('INT',19,0.010999999940395355,360,90,'Lampara 11w ','apagado',NULL,NULL),('INT',20,0.014999999664723873,360,90,'Lampara 15w ','apagado',NULL,NULL),('INT',21,0.019999999552965164,360,90,'Lampara 20w ','apagado',NULL,NULL),('INT',22,0.4000000059604645,360,60,'PC de escritorio','apagado',NULL,NULL),('STD',23,0.6399999856948853,15,3,'Microondas convencional',NULL,3,NULL),('STD',24,0.75,30,3,'Plancha a vapor',NULL,4,NULL),('STD',25,20,10,2,'prueba estandar',NULL,0,NULL);
/*!40000 ALTER TABLE `dispositivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `ID_LOG` bigint(20) NOT NULL AUTO_INCREMENT,
  `ESTADO` varchar(255) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `ID_DISPOSITIVO` bigint(20) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_LOG`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,'encendido','2018-10-06 02:00:00',22,'PC de escritorio'),(2,'ahorro','2018-10-06 04:00:00',22,'PC de escritorio'),(3,'encendido','2018-10-06 09:00:00',22,'PC de escritorio'),(4,'encendido','2018-10-06 17:03:02',19,'Lampara 11w'),(5,'encendido','2018-10-06 17:03:02',20,'Lampara 15w'),(6,'encendido','2018-10-06 17:03:02',21,'Lampara 20w'),(7,'apagado','2018-10-06 17:03:34',16,'Lampara halogenas de 40w'),(8,'apagado','2018-10-06 17:03:34',7,'Televisor LED 24'),(9,'encendido','2018-10-06 18:03:34',7,'Televisor LED 24'),(10,'encendido','2018-10-06 17:03:34',7,'Televisor LED 24'),(11,'apagado','2018-10-06 17:03:34',8,'Televisor LED 32'),(12,'encendido','2018-10-06 17:03:34',8,'Televisor LED 32'),(13,'encendido','2018-10-06 17:03:34',8,'Televisor LED 32'),(14,'apagado','2018-10-06 17:03:34',2,'Aire acondicionado 3500 frigorias'),(15,'encendido','2018-10-06 18:03:34',2,'Aire acondicionado 3500 frigorias'),(16,'encendido','2018-10-06 23:03:34',2,'Aire acondicionado 3500 frigorias');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicion`
--

DROP TABLE IF EXISTS `medicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicion` (
  `ID_MEDICION` bigint(20) NOT NULL AUTO_INCREMENT,
  `FECHA_HORA` datetime DEFAULT NULL,
  `MAGNITUD` double DEFAULT NULL,
  PRIMARY KEY (`ID_MEDICION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicion`
--

LOCK TABLES `medicion` WRITE;
/*!40000 ALTER TABLE `medicion` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regla`
--

DROP TABLE IF EXISTS `regla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regla` (
  `ID_REGLA` bigint(20) NOT NULL AUTO_INCREMENT,
  `CONDICION` varchar(255) DEFAULT NULL,
  `FLAG` double DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `actuador_ID_ACTUADOR` bigint(20) DEFAULT NULL,
  `sensor_ID_SENSOR` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_REGLA`),
  KEY `FK_fmhsf0qloi046vanbejw2q3im` (`actuador_ID_ACTUADOR`),
  KEY `FK_eydoiqc3l9xs9ijub8k97vyu2` (`sensor_ID_SENSOR`),
  CONSTRAINT `FK_eydoiqc3l9xs9ijub8k97vyu2` FOREIGN KEY (`sensor_ID_SENSOR`) REFERENCES `sensor` (`ID_SENSOR`),
  CONSTRAINT `FK_fmhsf0qloi046vanbejw2q3im` FOREIGN KEY (`actuador_ID_ACTUADOR`) REFERENCES `actuador` (`ID_ACTUADOR`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regla`
--

LOCK TABLES `regla` WRITE;
/*!40000 ALTER TABLE `regla` DISABLE KEYS */;
INSERT INTO `regla` VALUES (1,'mayor',360,'ApagarAireAcondicionado',2,NULL),(2,'menor',120,'EncenderVentilador',1,NULL),(3,'mayor',360,'ApagarAireAcondicionado',2,NULL),(4,'menor',120,'EncenderVentilador',1,NULL);
/*!40000 ALTER TABLE `regla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor`
--

DROP TABLE IF EXISTS `sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensor` (
  `TIPO` varchar(31) NOT NULL,
  `ID_SENSOR` bigint(20) NOT NULL AUTO_INCREMENT,
  `MAGNITUD` double DEFAULT NULL,
  PRIMARY KEY (`ID_SENSOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor`
--

LOCK TABLES `sensor` WRITE;
/*!40000 ALTER TABLE `sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor_dispositivo`
--

DROP TABLE IF EXISTS `sensor_dispositivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensor_dispositivo` (
  `SENSOR_ID_SENSOR` bigint(20) NOT NULL,
  `dispositivos_ID_DISP` bigint(20) NOT NULL,
  UNIQUE KEY `UK_8w29p2l5usnh2yujx21l8olc0` (`dispositivos_ID_DISP`),
  KEY `FK_744ky33chnhfnf7lx76ymxfsq` (`SENSOR_ID_SENSOR`),
  CONSTRAINT `FK_744ky33chnhfnf7lx76ymxfsq` FOREIGN KEY (`SENSOR_ID_SENSOR`) REFERENCES `sensor` (`ID_SENSOR`),
  CONSTRAINT `FK_8w29p2l5usnh2yujx21l8olc0` FOREIGN KEY (`dispositivos_ID_DISP`) REFERENCES `dispositivo` (`ID_DISP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor_dispositivo`
--

LOCK TABLES `sensor_dispositivo` WRITE;
/*!40000 ALTER TABLE `sensor_dispositivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensor_dispositivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor_medicion`
--

DROP TABLE IF EXISTS `sensor_medicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensor_medicion` (
  `SENSOR_ID_SENSOR` bigint(20) NOT NULL,
  `mediciones_ID_MEDICION` bigint(20) NOT NULL,
  UNIQUE KEY `UK_q1sevl6m0wpb69x3e28dt9ygl` (`mediciones_ID_MEDICION`),
  KEY `FK_ktaokasm1u1frp8q8cvtmehcg` (`SENSOR_ID_SENSOR`),
  CONSTRAINT `FK_ktaokasm1u1frp8q8cvtmehcg` FOREIGN KEY (`SENSOR_ID_SENSOR`) REFERENCES `sensor` (`ID_SENSOR`),
  CONSTRAINT `FK_q1sevl6m0wpb69x3e28dt9ygl` FOREIGN KEY (`mediciones_ID_MEDICION`) REFERENCES `medicion` (`ID_MEDICION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor_medicion`
--

LOCK TABLES `sensor_medicion` WRITE;
/*!40000 ALTER TABLE `sensor_medicion` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensor_medicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor_regla`
--

DROP TABLE IF EXISTS `sensor_regla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensor_regla` (
  `SENSOR_ID_SENSOR` bigint(20) NOT NULL,
  `observadores_ID_REGLA` bigint(20) NOT NULL,
  UNIQUE KEY `UK_qy586dxsvix6gamjjpv4q9ic2` (`observadores_ID_REGLA`),
  KEY `FK_5drn4v21ppkjb8daahu3gcoys` (`SENSOR_ID_SENSOR`),
  CONSTRAINT `FK_5drn4v21ppkjb8daahu3gcoys` FOREIGN KEY (`SENSOR_ID_SENSOR`) REFERENCES `sensor` (`ID_SENSOR`),
  CONSTRAINT `FK_qy586dxsvix6gamjjpv4q9ic2` FOREIGN KEY (`observadores_ID_REGLA`) REFERENCES `regla` (`ID_REGLA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor_regla`
--

LOCK TABLES `sensor_regla` WRITE;
/*!40000 ALTER TABLE `sensor_regla` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensor_regla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transformador`
--

DROP TABLE IF EXISTS `transformador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transformador` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ZONA` int(11) DEFAULT NULL,
  `coordenadas_ID_COORD` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_7818ufo9e2rbb39m129dy95pe` (`coordenadas_ID_COORD`),
  CONSTRAINT `FK_7818ufo9e2rbb39m129dy95pe` FOREIGN KEY (`coordenadas_ID_COORD`) REFERENCES `coordenadas` (`ID_COORD`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transformador`
--

LOCK TABLES `transformador` WRITE;
/*!40000 ALTER TABLE `transformador` DISABLE KEYS */;
INSERT INTO `transformador` VALUES (1,1,3),(2,1,4),(3,1,5),(4,2,6),(5,3,7);
/*!40000 ALTER TABLE `transformador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transformador_usuario`
--

DROP TABLE IF EXISTS `transformador_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transformador_usuario` (
  `TRANSFORMADOR_ID` int(11) NOT NULL,
  `clientes_ID_USU` bigint(20) NOT NULL,
  UNIQUE KEY `UK_nwt1bfluxq4fftdhkb2ylfy6n` (`clientes_ID_USU`),
  KEY `FK_9tkc9bdb5cqpiml4mqaavqbjv` (`TRANSFORMADOR_ID`),
  CONSTRAINT `FK_9tkc9bdb5cqpiml4mqaavqbjv` FOREIGN KEY (`TRANSFORMADOR_ID`) REFERENCES `transformador` (`ID`),
  CONSTRAINT `FK_nwt1bfluxq4fftdhkb2ylfy6n` FOREIGN KEY (`clientes_ID_USU`) REFERENCES `usuario` (`ID_USU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transformador_usuario`
--

LOCK TABLES `transformador_usuario` WRITE;
/*!40000 ALTER TABLE `transformador_usuario` DISABLE KEYS */;
INSERT INTO `transformador_usuario` VALUES (1,2),(5,1);
/*!40000 ALTER TABLE `transformador_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `TIPO` varchar(31) NOT NULL,
  `ID_USU` bigint(20) NOT NULL AUTO_INCREMENT,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `CONTRASENIA` varchar(255) DEFAULT NULL,
  `DOMICILIO` varchar(255) DEFAULT NULL,
  `FECHA_ALTA` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `USUARIO` varchar(255) DEFAULT NULL,
  `NUM_DOC` int(11) DEFAULT NULL,
  `PUNTOS` int(11) DEFAULT NULL,
  `TELEFONO` int(11) DEFAULT NULL,
  `TIPO_DOC` varchar(255) DEFAULT NULL,
  `categoria_ID_CAT` bigint(20) DEFAULT NULL,
  `coordenadas_ID_COORD` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_USU`),
  KEY `FK_thwfye6kvgcknplsmnbyxyfng` (`categoria_ID_CAT`),
  KEY `FK_flxhw67aopybeojwy1cqp8026` (`coordenadas_ID_COORD`),
  CONSTRAINT `FK_flxhw67aopybeojwy1cqp8026` FOREIGN KEY (`coordenadas_ID_COORD`) REFERENCES `coordenadas` (`ID_COORD`),
  CONSTRAINT `FK_thwfye6kvgcknplsmnbyxyfng` FOREIGN KEY (`categoria_ID_CAT`) REFERENCES `categoria` (`ID_CAT`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('CLIENTE',1,'duportal','123456','teniente general Peron 850','19/08/2018','mauricio','mauri',35287399,10,48972378,'DNI',1,1),('CLIENTE',2,'pulleiro','123456','Av. Corrientes 1225','04/08/2018','gaston','gpulleiro',35287364,20,48972378,'DNI',2,2),('ADMIN',3,NULL,'admin',NULL,NULL,NULL,'admin',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_dispositivo`
--

DROP TABLE IF EXISTS `usuario_dispositivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_dispositivo` (
  `USUARIO_ID_USU` bigint(20) NOT NULL,
  `dispositivos_ID_DISP` bigint(20) NOT NULL,
  KEY `FK_h8tvm6dn5hy9w95d7r2fvdm5t` (`dispositivos_ID_DISP`),
  KEY `FK_hp0ifqjb5cow5noqqiewn02o5` (`USUARIO_ID_USU`),
  CONSTRAINT `FK_h8tvm6dn5hy9w95d7r2fvdm5t` FOREIGN KEY (`dispositivos_ID_DISP`) REFERENCES `dispositivo` (`ID_DISP`),
  CONSTRAINT `FK_hp0ifqjb5cow5noqqiewn02o5` FOREIGN KEY (`USUARIO_ID_USU`) REFERENCES `usuario` (`ID_USU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_dispositivo`
--

LOCK TABLES `usuario_dispositivo` WRITE;
/*!40000 ALTER TABLE `usuario_dispositivo` DISABLE KEYS */;
INSERT INTO `usuario_dispositivo` VALUES (2,1),(2,3),(2,12),(2,18),(2,22),(2,24),(2,20),(1,2),(1,9),(1,21),(1,14),(1,5),(1,11),(1,19),(1,3),(1,22);
/*!40000 ALTER TABLE `usuario_dispositivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_regla`
--

DROP TABLE IF EXISTS `usuario_regla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_regla` (
  `USUARIO_ID_USU` bigint(20) NOT NULL,
  `reglas_ID_REGLA` bigint(20) NOT NULL,
  UNIQUE KEY `UK_i96em35nul2u8i00bjeoia168` (`reglas_ID_REGLA`),
  KEY `FK_dlq7pf128dshyu4sfdbspw5ue` (`USUARIO_ID_USU`),
  CONSTRAINT `FK_dlq7pf128dshyu4sfdbspw5ue` FOREIGN KEY (`USUARIO_ID_USU`) REFERENCES `usuario` (`ID_USU`),
  CONSTRAINT `FK_i96em35nul2u8i00bjeoia168` FOREIGN KEY (`reglas_ID_REGLA`) REFERENCES `regla` (`ID_REGLA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_regla`
--

LOCK TABLES `usuario_regla` WRITE;
/*!40000 ALTER TABLE `usuario_regla` DISABLE KEYS */;
INSERT INTO `usuario_regla` VALUES (1,3),(1,4),(2,1),(2,2);
/*!40000 ALTER TABLE `usuario_regla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zona`
--

DROP TABLE IF EXISTS `zona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zona` (
  `ID_ZONA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `RADIO` int(11) DEFAULT NULL,
  `coordenadas_ID_COORD` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_ZONA`),
  KEY `FK_6uarx05puolaoufgk0pd2t330` (`coordenadas_ID_COORD`),
  CONSTRAINT `FK_6uarx05puolaoufgk0pd2t330` FOREIGN KEY (`coordenadas_ID_COORD`) REFERENCES `coordenadas` (`ID_COORD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zona`
--

LOCK TABLES `zona` WRITE;
/*!40000 ALTER TABLE `zona` DISABLE KEYS */;
/*!40000 ALTER TABLE `zona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zona_transformador`
--

DROP TABLE IF EXISTS `zona_transformador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zona_transformador` (
  `ZONA_ID_ZONA` int(11) NOT NULL,
  `transformadores_ID` int(11) NOT NULL,
  UNIQUE KEY `UK_k13hreng9dodpexd5c9sp07w4` (`transformadores_ID`),
  KEY `FK_3a7adp598c593mqjvbdnyqtco` (`ZONA_ID_ZONA`),
  CONSTRAINT `FK_3a7adp598c593mqjvbdnyqtco` FOREIGN KEY (`ZONA_ID_ZONA`) REFERENCES `zona` (`ID_ZONA`),
  CONSTRAINT `FK_k13hreng9dodpexd5c9sp07w4` FOREIGN KEY (`transformadores_ID`) REFERENCES `transformador` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zona_transformador`
--

LOCK TABLES `zona_transformador` WRITE;
/*!40000 ALTER TABLE `zona_transformador` DISABLE KEYS */;
/*!40000 ALTER TABLE `zona_transformador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-28 17:10:21
