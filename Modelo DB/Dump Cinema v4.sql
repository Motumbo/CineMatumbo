CREATE DATABASE  IF NOT EXISTS `db_cinema` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_cinema`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: db_cinema
-- ------------------------------------------------------
-- Server version	5.5.25a

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
  `ciudad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk_cine`),
  KEY `cine_ciudad_idx` (`ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cines`
--

LOCK TABLES `tbl_cines` WRITE;
/*!40000 ALTER TABLE `tbl_cines` DISABLE KEYS */;
INSERT INTO `tbl_cines` VALUES (1,'CineMatumbo','Tierra Media'),(2,'Cine Los Gallegos','Mar del Plata'),(3,'Cine Ambassador','Mar del Plata'),(5,'Cine Guido','Mar del Plata');
/*!40000 ALTER TABLE `tbl_cines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_funciones`
--

DROP TABLE IF EXISTS `tbl_funciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_funciones` (
  `pk_funcion` int(11) NOT NULL AUTO_INCREMENT,
  `horario_inicio` timestamp NULL DEFAULT NULL,
  `tarifa` float DEFAULT NULL,
  `fk_sala` int(11) NOT NULL,
  `fk_pelicula` int(11) NOT NULL,
  PRIMARY KEY (`pk_funcion`),
  KEY `funcion_sala_idx` (`fk_sala`),
  KEY `funcion_pelicula_idx` (`fk_pelicula`),
  CONSTRAINT `funcion_pelicula` FOREIGN KEY (`fk_pelicula`) REFERENCES `tbl_peliculas` (`pk_pelicula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `funcion_sala` FOREIGN KEY (`fk_sala`) REFERENCES `tbl_salas` (`pk_sala`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_funciones`
--

LOCK TABLES `tbl_funciones` WRITE;
/*!40000 ALTER TABLE `tbl_funciones` DISABLE KEYS */;
INSERT INTO `tbl_funciones` VALUES (1,'2015-12-12 19:00:00',50,1,2),(2,'2015-10-10 15:00:00',100,1,1),(3,'2015-12-30 18:30:00',40,6,7),(4,'2015-11-28 20:00:00',50,4,4),(5,'2016-01-06 00:00:00',45,5,8),(6,'2016-02-04 17:30:00',30,2,1),(7,'2016-01-06 00:00:00',50,5,8);
/*!40000 ALTER TABLE `tbl_funciones` ENABLE KEYS */;
UNLOCK TABLES;

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
  `duracion` int(11) DEFAULT NULL,
  `imagen` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`pk_pelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_peliculas`
--

LOCK TABLES `tbl_peliculas` WRITE;
/*!40000 ALTER TABLE `tbl_peliculas` DISABLE KEYS */;
INSERT INTO `tbl_peliculas` VALUES (1,'El Senor de los Anillos','Fantasia Epica','+13',180,'https://www.movieposter.com/posters/archive/main/105/MPW-52979'),(2,'Mad Max: Fury Road','Accion','+18',120,'http://vignette2.wikia.nocookie.net/roadwarrior/images/b/be/Poster-mad-max-fury-road-08b.jpg/revision/latest?cb=20150521140222'),(4,'The Shawshank Redemption','Drama','+13',142,'https://upload.wikimedia.org/wikipedia/en/8/81/ShawshankRedemptionMoviePoster.jpg'),(5,'Hobo with a Shotgun','Clase B','+18',90,'http://www.wired.com/images_blogs/underwire/2011/03/hobo_with_a_shotgun_1300.jpg'),(6,'The Godfather','Drama','+16',200,'http://keyartdesigns.com/wp-content/uploads/2010/09/the-godfather-movie-poster-1020243893.jpg'),(7,'Akira','Animacion - Ciencia ficcion','+16',100,'http://vignette1.wikia.nocookie.net/akira/images/0/0e/Akira-Poster-akira-13827694-1013-1500.jpg/revision/latest?cb=20131117120052'),(8,'Pulp Fiction','Drama','+18',120,'http://vignette4.wikia.nocookie.net/total-movies/images/f/f8/Pulp_Fiction_poster.jpg/revision/latest?cb=20131129221011');
/*!40000 ALTER TABLE `tbl_peliculas` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`pk_reserva`),
  KEY `reserva_funcion_idx` (`fk_funcion`),
  KEY `reserva_usuario_idx` (`fk_usuario`),
  CONSTRAINT `reserva_funcion` FOREIGN KEY (`fk_funcion`) REFERENCES `tbl_funciones` (`pk_funcion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `reserva_usuario` FOREIGN KEY (`fk_usuario`) REFERENCES `tbl_usuarios` (`pk_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_reservas`
--

LOCK TABLES `tbl_reservas` WRITE;
/*!40000 ALTER TABLE `tbl_reservas` DISABLE KEYS */;
INSERT INTO `tbl_reservas` VALUES (1,1,1,4),(2,1,2,4),(3,10,2,7),(4,15,3,6),(5,7,3,6),(6,19,5,4),(7,20,5,4);
/*!40000 ALTER TABLE `tbl_reservas` ENABLE KEYS */;
UNLOCK TABLES;

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
  `tiempo_limpieza` int(11) DEFAULT NULL,
  `fk_cine` int(11) NOT NULL,
  PRIMARY KEY (`pk_sala`),
  KEY `sala_cine_idx` (`fk_cine`),
  CONSTRAINT `sala_cine` FOREIGN KEY (`fk_cine`) REFERENCES `tbl_cines` (`pk_cine`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_salas`
--

LOCK TABLES `tbl_salas` WRITE;
/*!40000 ALTER TABLE `tbl_salas` DISABLE KEYS */;
INSERT INTO `tbl_salas` VALUES (1,'Sala Isengard',10,10,10,1),(2,'Sala Mordor',30,50,20,1),(4,'Sala 2D',25,40,10,2),(5,'Sala 3D',40,60,10,2),(6,'Sala Imax',25,45,20,3);
/*!40000 ALTER TABLE `tbl_salas` ENABLE KEYS */;
UNLOCK TABLES;

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
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuarios`
--

LOCK TABLES `tbl_usuarios` WRITE;
/*!40000 ALTER TABLE `tbl_usuarios` DISABLE KEYS */;
INSERT INTO `tbl_usuarios` VALUES (1,'Nicolas','123','admin','nicolas@gmail.com'),(4,'Cris','123','cliente','cris@judio.con'),(5,'Guido','123','admin','guido@mail.com'),(6,'Nahue','123','cliente','nahue@punto.com'),(7,'Gandalf','123','cliente','magordito@mordor.com');
/*!40000 ALTER TABLE `tbl_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-06 14:53:58
