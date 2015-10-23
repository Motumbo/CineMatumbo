CREATE DATABASE  IF NOT EXISTS `db_cinema` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_cinema`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: db_cinema
-- ------------------------------------------------------
-- Server version	5.6.27-log

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
-- Table structure for table `tbl_cines`
--

DROP TABLE IF EXISTS `tbl_cines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cines` (
  `pk_cine` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `fk_ciudad` int(11) NOT NULL,
  PRIMARY KEY (`pk_cine`),
  KEY `cine_ciudad_idx` (`fk_ciudad`),
  CONSTRAINT `cine_ciudad` FOREIGN KEY (`fk_ciudad`) REFERENCES `tbl_ciudades` (`pk_ciudad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_ciudades`
--

DROP TABLE IF EXISTS `tbl_ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_ciudades` (
  `pk_ciudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk_ciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_funciones`
--

DROP TABLE IF EXISTS `tbl_funciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_funciones` (
  `pk_funcion` int(11) NOT NULL AUTO_INCREMENT,
  `horario_inicio` datetime DEFAULT NULL,
  `fk_sala` int(11) NOT NULL,
  `fk_pelicula` int(11) NOT NULL,
  PRIMARY KEY (`pk_funcion`),
  KEY `funcion_sala_idx` (`fk_sala`),
  KEY `funcion_pelicula_idx` (`fk_pelicula`),
  CONSTRAINT `funcion_pelicula` FOREIGN KEY (`fk_pelicula`) REFERENCES `tbl_peliculas` (`pk_pelicula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `funcion_sala` FOREIGN KEY (`fk_sala`) REFERENCES `tbl_salas` (`pk_sala`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_peliculas`
--

DROP TABLE IF EXISTS `tbl_peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_peliculas` (
  `pk_pelicula` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `clasificacion` varchar(45) DEFAULT NULL,
  `duracion` time DEFAULT NULL,
  PRIMARY KEY (`pk_pelicula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_reservas`
--

DROP TABLE IF EXISTS `tbl_reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_reservas` (
  `pk_reserva` int(11) NOT NULL AUTO_INCREMENT,
  `asiento` int(11) DEFAULT NULL,
  `fk_funcion` int(11) NOT NULL,
  `fk_usuario` int(11) NOT NULL,
  `fk_tarifa` int(11) NOT NULL,
  PRIMARY KEY (`pk_reserva`),
  KEY `reserva_funcion_idx` (`fk_funcion`),
  KEY `reserva_usuario_idx` (`fk_usuario`),
  KEY `reserva_tarifa_idx` (`fk_tarifa`),
  CONSTRAINT `reserva_funcion` FOREIGN KEY (`fk_funcion`) REFERENCES `tbl_funciones` (`pk_funcion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `reserva_tarifa` FOREIGN KEY (`fk_tarifa`) REFERENCES `tbl_tarifas` (`pk_tarifa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `reserva_usuario` FOREIGN KEY (`fk_usuario`) REFERENCES `tbl_usuarios` (`pk_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_salas`
--

DROP TABLE IF EXISTS `tbl_salas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_salas` (
  `pk_sala` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `filas` int(11) DEFAULT NULL,
  `columnas` int(11) DEFAULT NULL,
  `tiempo_limpieza` time DEFAULT NULL,
  `fk_cine` int(11) NOT NULL,
  PRIMARY KEY (`pk_sala`),
  KEY `sala_cine_idx` (`fk_cine`),
  CONSTRAINT `sala_cine` FOREIGN KEY (`fk_cine`) REFERENCES `tbl_cines` (`pk_cine`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_tarifas`
--

DROP TABLE IF EXISTS `tbl_tarifas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_tarifas` (
  `pk_tarifa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `importe` float DEFAULT NULL,
  PRIMARY KEY (`pk_tarifa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_usuarios`
--

DROP TABLE IF EXISTS `tbl_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_usuarios` (
  `pk_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-16 12:11:08
