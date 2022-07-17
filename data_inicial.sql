-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dblogistica
-- ------------------------------------------------------
-- Server version	8.0.26-google

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id_cat` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'CALZADOS'),(2,'PANTALONES'),(3,'ACCESORIOS'),(4,'ABRIGOS'),(5,'REMERAS'),(6,'CAMISAS'),(7,'ROPA INTERIOR'),(8,'TRAJES');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id_cliente` bigint NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `documento` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `razon_social` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Montevideo','Italia 231','214156510017','cliente1@gmail.com','Juan Dominguez','Bas S.R.L','099999999'),(2,'Salto','Derechos Humanos 212','211003420017','cliente2@gmail.com','Alberto Perez','La isla S.A','099999999'),(3,'Montevideo','Guatemala 212','210276180011','cliente3@gmail.com','Mario Gonzales','Macri S.R.L','099999999');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `depositos`
--

DROP TABLE IF EXISTS `depositos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `depositos` (
  `id_deposito` bigint NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `nom_deposito` varchar(255) DEFAULT NULL,
  `id_empresa` bigint DEFAULT NULL,
  PRIMARY KEY (`id_deposito`),
  KEY `FK4rklekdu27b9jaj0ctm3eh3po` (`id_empresa`),
  CONSTRAINT `FK4rklekdu27b9jaj0ctm3eh3po` FOREIGN KEY (`id_empresa`) REFERENCES `empresas` (`id_empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depositos`
--

LOCK TABLES `depositos` WRITE;
/*!40000 ALTER TABLE `depositos` DISABLE KEYS */;
INSERT INTO `depositos` VALUES (1,'Italia 123, Fray Bentos','Deposito Utec',1);
/*!40000 ALTER TABLE `depositos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribuidores`
--

DROP TABLE IF EXISTS `distribuidores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distribuidores` (
  `id_distribu` bigint NOT NULL AUTO_INCREMENT,
  `chofer` varchar(255) DEFAULT NULL,
  `matricula` varchar(255) DEFAULT NULL,
  `vehiculo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_distribu`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distribuidores`
--

LOCK TABLES `distribuidores` WRITE;
/*!40000 ALTER TABLE `distribuidores` DISABLE KEYS */;
INSERT INTO `distribuidores` VALUES (1,'Marcos Fernandez','SAF6254','Camion Mercedes-Benz'),(2,'Mariano Arias','SBF6243','Camioneta Peugeot'),(3,'Marcelo Gimenes','SWE3243','Camioneta Peugeot'),(4,'Emilia Gonzales','WE3221','Camioneta Chevrolet'),(5,'Gabriela Bermudez','WEE2231','Camioneta Chevrolet');
/*!40000 ALTER TABLE `distribuidores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresas`
--

DROP TABLE IF EXISTS `empresas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresas` (
  `id_empresa` bigint NOT NULL AUTO_INCREMENT,
  `contacto` varchar(255) DEFAULT NULL,
  `documento` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom_empresa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresas`
--

LOCK TABLES `empresas` WRITE;
/*!40000 ALTER TABLE `empresas` DISABLE KEYS */;
INSERT INTO `empresas` VALUES (1,'Juan Gonzales',179194001,'empresa1@gmail.com','La isla'),(2,'Pedro Montero',173181901,'empresa2@gmail.com','Los Muchachos'),(3,'Maria Perez',139240901,'empresa3@gmail.com','Empresa Agricola');
/*!40000 ALTER TABLE `empresas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `espacios`
--

DROP TABLE IF EXISTS `espacios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `espacios` (
  `id_esp` bigint NOT NULL AUTO_INCREMENT,
  `nom_espacio` varchar(255) DEFAULT NULL,
  `id_pasillo` bigint DEFAULT NULL,
  PRIMARY KEY (`id_esp`),
  KEY `FKf56v466vmbm5dfigtemrxx5yh` (`id_pasillo`),
  CONSTRAINT `FKf56v466vmbm5dfigtemrxx5yh` FOREIGN KEY (`id_pasillo`) REFERENCES `pasillos` (`id_pasillo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `espacios`
--

LOCK TABLES `espacios` WRITE;
/*!40000 ALTER TABLE `espacios` DISABLE KEYS */;
INSERT INTO `espacios` VALUES (1,'1',1),(2,'2',1),(3,'3',1),(4,'1',2),(5,'2',2),(6,'3',2);
/*!40000 ALTER TABLE `espacios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `espacios_productos`
--

DROP TABLE IF EXISTS `espacios_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `espacios_productos` (
  `id_tipo_producto` bigint NOT NULL,
  `id_espacio` bigint NOT NULL,
  KEY `FKo299c3w2w5sqon872bk0rb61t` (`id_espacio`),
  KEY `FK9sd8okupox42dvjxk951ji44y` (`id_tipo_producto`),
  CONSTRAINT `FK9sd8okupox42dvjxk951ji44y` FOREIGN KEY (`id_tipo_producto`) REFERENCES `espacios` (`id_esp`),
  CONSTRAINT `FKo299c3w2w5sqon872bk0rb61t` FOREIGN KEY (`id_espacio`) REFERENCES `tipo_productos` (`id_tipo_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `espacios_productos`
--

LOCK TABLES `espacios_productos` WRITE;
/*!40000 ALTER TABLE `espacios_productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `espacios_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_pedido`
--

DROP TABLE IF EXISTS `estado_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado_pedido` (
  `id_estado_pedido` bigint NOT NULL AUTO_INCREMENT,
  `fecha` datetime(6) DEFAULT NULL,
  `tipo_estado_pedido` varchar(255) DEFAULT NULL,
  `usuario_id_usuario` bigint DEFAULT NULL,
  `id_pedido` bigint DEFAULT NULL,
  PRIMARY KEY (`id_estado_pedido`),
  KEY `FKyqcv5ivds1hb2ckhrb46g923` (`usuario_id_usuario`),
  KEY `FKaemthur0xoocfqq3fl3l6asge` (`id_pedido`),
  CONSTRAINT `FKaemthur0xoocfqq3fl3l6asge` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id_pedido`),
  CONSTRAINT `FKyqcv5ivds1hb2ckhrb46g923` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_pedido`
--

LOCK TABLES `estado_pedido` WRITE;
/*!40000 ALTER TABLE `estado_pedido` DISABLE KEYS */;
INSERT INTO `estado_pedido` VALUES (1,'2022-01-05 16:09:43.313000','PENDIENTE',1,1),(2,'2022-01-05 16:10:00.700000','PREPARADO',1,1),(3,'2022-01-05 16:10:18.241000','CONTROLADO',1,1),(4,'2022-01-05 16:10:33.712000','DESPACHADO',1,1),(5,'2022-01-05 16:10:51.464000','ENTREGADO',1,1),(6,'2022-02-05 16:11:11.399000','PENDIENTE',1,2),(7,'2022-02-05 16:11:22.071000','PREPARADO',1,2),(8,'2022-02-05 16:11:39.896000','CONTROLADO',1,2),(9,'2022-02-05 16:11:55.416000','DESPACHADO',1,2),(10,'2022-02-05 16:12:10.008000','ENTREGADO',1,2),(11,'2022-03-05 16:12:29.114000','PENDIENTE',1,3),(12,'2022-03-05 16:12:41.326000','PREPARADO',1,3),(13,'2022-03-05 16:12:55.930000','CONTROLADO',1,3),(14,'2022-03-05 16:13:11.683000','DESPACHADO',1,3),(15,'2022-03-05 16:13:26.703000','ENTREGADO',1,3),(16,'2022-04-05 16:13:53.566000','PENDIENTE',1,4),(17,'2022-04-05 16:14:08.607000','PREPARADO',1,4),(18,'2022-04-05 16:14:26.784000','CONTROLADO',1,4),(19,'2022-04-05 16:14:47.706000','DESPACHADO',1,4),(20,'2022-04-05 16:15:06.174000','ENTREGADO',1,4),(21,'2022-05-05 16:15:40.931000','PENDIENTE',1,5),(22,'2022-05-05 16:15:57.373000','PREPARADO',1,5),(23,'2022-05-05 16:16:14.319000','CONTROLADO',1,5),(24,'2022-06-05 16:16:42.010000','PENDIENTE',1,6),(25,'2022-06-05 16:16:53.559000','PREPARADO',1,6),(26,'2022-05-05 16:17:10.776000','CONTROLADO',1,6),(27,'2022-06-05 16:17:36.545000','DESPACHADO',1,6),(28,'2022-05-05 16:17:54.621000','ENTREGADO',1,6),(29,'2022-06-05 16:18:11.762000','DESPACHADO',1,5),(30,'2022-06-05 16:18:29.599000','ENTREGADO',1,5);
/*!40000 ALTER TABLE `estado_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_recepcion`
--

DROP TABLE IF EXISTS `estado_recepcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado_recepcion` (
  `id_estado_recepcion` bigint NOT NULL AUTO_INCREMENT,
  `fecha_estado` datetime(6) DEFAULT NULL,
  `tipo_estado` varchar(255) DEFAULT NULL,
  `usuario_id_usuario` bigint DEFAULT NULL,
  `id_recepcion` bigint DEFAULT NULL,
  PRIMARY KEY (`id_estado_recepcion`),
  KEY `FK5oh6jxkxpsis9wcljwm633i2p` (`usuario_id_usuario`),
  KEY `FKtrs3j7e91okh5oqu7op2urest` (`id_recepcion`),
  CONSTRAINT `FK5oh6jxkxpsis9wcljwm633i2p` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  CONSTRAINT `FKtrs3j7e91okh5oqu7op2urest` FOREIGN KEY (`id_recepcion`) REFERENCES `recepciones` (`id_recepcion`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_recepcion`
--

LOCK TABLES `estado_recepcion` WRITE;
/*!40000 ALTER TABLE `estado_recepcion` DISABLE KEYS */;
INSERT INTO `estado_recepcion` VALUES (1,'2022-01-05 15:58:56.869000','PENDIENTE',1,1),(2,'2022-01-05 15:59:14.945000','RECIBIDO',1,1),(3,'2022-02-05 15:59:30.601000','PENDIENTE',1,2),(4,'2022-02-05 15:59:44.097000','RECIBIDO',1,2),(5,'2022-03-05 16:00:04.741000','PENDIENTE',1,3),(6,'2022-03-05 16:00:19.660000','RECIBIDO',1,3),(7,'2022-04-05 16:00:43.175000','PENDIENTE',1,4),(8,'2022-04-05 16:00:53.609000','RECIBIDO',1,4),(9,'2022-05-05 16:01:21.880000','PENDIENTE',1,5),(10,'2022-05-05 16:01:40.985000','RECIBIDO',1,5),(11,'2022-06-05 16:01:47.388000','RECIBIDO',1,5),(12,'2022-06-05 16:01:57.841000','PENDIENTE',1,6),(13,'2022-07-05 16:02:08.598000','RECIBIDO',1,6);
/*!40000 ALTER TABLE `estado_recepcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasillos`
--

DROP TABLE IF EXISTS `pasillos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pasillos` (
  `id_pasillo` bigint NOT NULL AUTO_INCREMENT,
  `nom_pasillo` varchar(255) DEFAULT NULL,
  `id_deposito` bigint DEFAULT NULL,
  PRIMARY KEY (`id_pasillo`),
  KEY `FKhbpavmhb1a4yt0wg6asc0w47r` (`id_deposito`),
  CONSTRAINT `FKhbpavmhb1a4yt0wg6asc0w47r` FOREIGN KEY (`id_deposito`) REFERENCES `depositos` (`id_deposito`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasillos`
--

LOCK TABLES `pasillos` WRITE;
/*!40000 ALTER TABLE `pasillos` DISABLE KEYS */;
INSERT INTO `pasillos` VALUES (1,'A',1),(2,'B',1);
/*!40000 ALTER TABLE `pasillos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `id_pedido` bigint NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `duracion_estimada` bigint DEFAULT NULL,
  `duracion_final` bigint DEFAULT NULL,
  `fecha_pedido` datetime(6) DEFAULT NULL,
  `total` double NOT NULL,
  `cliente_id_cliente` bigint DEFAULT NULL,
  `distribuidor_id_distribu` bigint DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `FK5obb7re6ekap2ilowsh290cqi` (`cliente_id_cliente`),
  KEY `FKcqaau2ltqurnogcrbr54hh1by` (`distribuidor_id_distribu`),
  CONSTRAINT `FK5obb7re6ekap2ilowsh290cqi` FOREIGN KEY (`cliente_id_cliente`) REFERENCES `clientes` (`id_cliente`),
  CONSTRAINT `FKcqaau2ltqurnogcrbr54hh1by` FOREIGN KEY (`distribuidor_id_distribu`) REFERENCES `distribuidores` (`id_distribu`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,'Italia 231',NULL,1,'2022-01-05 16:09:43.313000',6000,1,5),(2,'Derechos Humanos 212',NULL,0,'2022-02-05 16:11:11.398000',3000,2,5),(3,'Derechos Humanos 212',NULL,0,'2022-03-05 16:12:29.109000',6000,2,3),(4,'Italia 231',NULL,1,'2022-04-05 16:13:53.565000',2500,1,5),(5,'Derechos Humanos 212',NULL,2,'2022-05-05 16:15:40.930000',12000,2,4),(6,'Derechos Humanos 212',NULL,1,'2022-06-05 16:16:42.009000',3000,2,5);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos_producto`
--

DROP TABLE IF EXISTS `pedidos_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos_producto` (
  `id_pedido_producto` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` double DEFAULT NULL,
  `id_pedido` bigint DEFAULT NULL,
  `id_tipo_producto` bigint NOT NULL,
  PRIMARY KEY (`id_pedido_producto`),
  KEY `FKjtrcg095crpbaf5193a93xbho` (`id_pedido`),
  KEY `FKg4aggpbcx248r8oxwvre6vdsi` (`id_tipo_producto`),
  CONSTRAINT `FKg4aggpbcx248r8oxwvre6vdsi` FOREIGN KEY (`id_tipo_producto`) REFERENCES `tipo_productos` (`id_tipo_prod`),
  CONSTRAINT `FKjtrcg095crpbaf5193a93xbho` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id_pedido`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos_producto`
--

LOCK TABLES `pedidos_producto` WRITE;
/*!40000 ALTER TABLE `pedidos_producto` DISABLE KEYS */;
INSERT INTO `pedidos_producto` VALUES (1,3,1,1),(2,3,1,2),(3,2,2,3),(4,3,3,5),(5,1,4,9),(6,1,4,7),(7,2,5,4),(8,2,5,7),(9,2,6,6),(10,1,6,7);
/*!40000 ALTER TABLE `pedidos_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id_prod` bigint NOT NULL AUTO_INCREMENT,
  `cantidad_disponible` double DEFAULT NULL,
  `cantidad_cuarentena` double DEFAULT NULL,
  `cantidad_reservada` double DEFAULT NULL,
  `tipo_prod_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id_prod`),
  KEY `FK6jwg3bkv3rgpoeus4c4i2m4v` (`tipo_prod_id`),
  CONSTRAINT `FK6jwg3bkv3rgpoeus4c4i2m4v` FOREIGN KEY (`tipo_prod_id`) REFERENCES `tipo_productos` (`id_tipo_prod`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,17,0,0,1),(2,9,0,0,2),(3,18,0,0,3),(4,122,0,0,4),(5,175,0,0,5),(6,38,0,0,6),(7,20,0,0,7),(8,164,0,0,8),(9,10,0,0,9);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `id_prov` bigint NOT NULL AUTO_INCREMENT,
  `contacto` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre_prov` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_prov`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'Juan Gonzales','provedor1@gmail.com','Zara'),(2,'Tamara De-La-Torre','provedor2@gmail.com','Adidas '),(3,'Mauro Martines','provedor3@gmail.com','Nike'),(4,'Raul Merchan','provedor4@gmail.com','Puma'),(5,'Manuel Arana','provedor5@gmail.com','Destino Colection'),(6,'Benjamin Puertas','provedor6@gmail.com','Nuss Tejidos');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recepciones`
--

DROP TABLE IF EXISTS `recepciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recepciones` (
  `id_recepcion` bigint NOT NULL AUTO_INCREMENT,
  `fecha_recepcion` datetime(6) DEFAULT NULL,
  `provedor_id_prov` bigint DEFAULT NULL,
  PRIMARY KEY (`id_recepcion`),
  KEY `FKfewb4u0nho7iuk9mh64682lgl` (`provedor_id_prov`),
  CONSTRAINT `FKfewb4u0nho7iuk9mh64682lgl` FOREIGN KEY (`provedor_id_prov`) REFERENCES `proveedores` (`id_prov`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recepciones`
--

LOCK TABLES `recepciones` WRITE;
/*!40000 ALTER TABLE `recepciones` DISABLE KEYS */;
INSERT INTO `recepciones` VALUES (1,'2022-01-05 15:58:56.869000',1),(2,'2022-07-05 15:59:30.605000',4),(3,'2022-06-05 16:00:04.748000',2),(4,'2022-04-05 16:00:43.181000',4),(5,'2022-03-05 16:01:21.885000',5),(6,'2022-02-05 16:01:57.847000',3);
/*!40000 ALTER TABLE `recepciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recepciones_productos`
--

DROP TABLE IF EXISTS `recepciones_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recepciones_productos` (
  `id_recepcion_producto` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` double DEFAULT NULL,
  `id_tipo_producto` bigint NOT NULL,
  `id_recepcion` bigint DEFAULT NULL,
  PRIMARY KEY (`id_recepcion_producto`),
  KEY `FK2d6ky5lfjfb367wll44328xc6` (`id_tipo_producto`),
  KEY `FKa6henneuxt8l7kvnry5ljcg9k` (`id_recepcion`),
  CONSTRAINT `FK2d6ky5lfjfb367wll44328xc6` FOREIGN KEY (`id_tipo_producto`) REFERENCES `tipo_productos` (`id_tipo_prod`),
  CONSTRAINT `FKa6henneuxt8l7kvnry5ljcg9k` FOREIGN KEY (`id_recepcion`) REFERENCES `recepciones` (`id_recepcion`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recepciones_productos`
--

LOCK TABLES `recepciones_productos` WRITE;
/*!40000 ALTER TABLE `recepciones_productos` DISABLE KEYS */;
INSERT INTO `recepciones_productos` VALUES (1,10,3,1),(2,14,8,2),(3,9,9,3),(4,20,8,4),(5,4,5,5),(6,10,6,5),(7,2,7,5),(8,4,4,6);
/*!40000 ALTER TABLE `recepciones_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_categorias`
--

DROP TABLE IF EXISTS `sub_categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_categorias` (
  `id_sub_cat` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_sub_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_categorias`
--

LOCK TABLES `sub_categorias` WRITE;
/*!40000 ALTER TABLE `sub_categorias` DISABLE KEYS */;
INSERT INTO `sub_categorias` VALUES (1,'CALZADO DEPORTIVO'),(2,'CALZADO FORMAL'),(3,'CALZADO INFORMAL'),(4,'CINTURONES'),(5,'GORROS'),(6,'MEDIAS'),(7,'CINTURON'),(8,'JEANS'),(9,'CAMPERAS'),(10,'BUZO'),(11,'FELPA'),(12,'SWEATERS'),(13,'SACOS'),(14,'SANDALIAS'),(15,'DERMUDAS'),(16,'MUSCULOSAS'),(17,'CANGUROS'),(18,'BOTAS'),(19,'OJOTAS'),(20,'CAMISAS MANGA LARGA'),(21,'CAMISAS MANGA CORTA');
/*!40000 ALTER TABLE `sub_categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_productos`
--

DROP TABLE IF EXISTS `tipo_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_productos` (
  `id_tipo_prod` bigint NOT NULL AUTO_INCREMENT,
  `codigo_de_barras` int NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `neto` double NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `categoria_id` bigint DEFAULT NULL,
  `id_prov` bigint DEFAULT NULL,
  `sub_categoria_id` bigint DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `metodo_picking` varchar(255) NOT NULL,
  `precio_de_venta` double NOT NULL,
  PRIMARY KEY (`id_tipo_prod`),
  KEY `FKn53c64wqknwm8co2rpt3lq5fb` (`categoria_id`),
  KEY `FK6aav698p656546lsyti22jqhe` (`id_prov`),
  KEY `FKap3ppx63397r8mbtm0yq5xke5` (`sub_categoria_id`),
  CONSTRAINT `FK6aav698p656546lsyti22jqhe` FOREIGN KEY (`id_prov`) REFERENCES `proveedores` (`id_prov`),
  CONSTRAINT `FKap3ppx63397r8mbtm0yq5xke5` FOREIGN KEY (`sub_categoria_id`) REFERENCES `sub_categorias` (`id_sub_cat`),
  CONSTRAINT `FKn53c64wqknwm8co2rpt3lq5fb` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_productos`
--

LOCK TABLES `tipo_productos` WRITE;
/*!40000 ALTER TABLE `tipo_productos` DISABLE KEYS */;
INSERT INTO `tipo_productos` VALUES (1,11111,'CAMISA CUADROS AZUL GENERICA',1,'CAMISA CUADROS AZUL',1000,6,6,12,'https://storage.googleapis.com/clawtechpics/tipoProducto/11111.jpg','AZAR',1200),(2,22222,'CAMISA ESTAMPADA NEGRO GENERICA',1,'CAMISA ESTAMPADA',1000,6,6,20,'https://storage.googleapis.com/clawtechpics/tipoProducto/22222.jpg','AZAR',1200),(3,33333,'PANTALON COLOR AZUL MARCA ZARA',1,'JEAN AZUL ZARA',1500,2,1,1,'https://storage.googleapis.com/clawtechpics/tipoProducto/33333.jpg','AZAR',1600),(4,44444,'CALZADO DEPORTIVO NIKE',1,'CALZADO DEPORTIVO NEGRO',5000,1,3,1,'https://storage.googleapis.com/clawtechpics/tipoProducto/44444.jpeg','AZAR',6000),(5,55555,'CALZADO FORMAL AZUL GENERICO',1,'ZAPATO FORMAL AZUL',2000,1,5,2,'https://storage.googleapis.com/clawtechpics/tipoProducto/55555.jpg','AZAR',3000),(6,66666,'CALZADO INFORMAL BLANCO GENERICO',1,'CALZADO INFORMAL BLANCO',1000,1,5,2,'https://storage.googleapis.com/clawtechpics/tipoProducto/66666.jpg','AZAR',1200),(7,77777,'BUZO BLANCO GENERICO',1,'BUZO BLANCO',1000,4,5,10,'https://storage.googleapis.com/clawtechpics/tipoProducto/77777.jpg','AZAR',1400),(8,88888,'BUZO NEGRO MARCA PUMA',1,'BUZO NEGRO PUMA',1500,4,4,10,'https://storage.googleapis.com/clawtechpics/tipoProducto/88888.jpg','AZAR',1700),(9,99999,'GORRO NEGRO MARCA ADIDAS CON LOGO',1,'GORRO NEGRO ADIDAS',1500,3,2,5,'https://storage.googleapis.com/clawtechpics/tipoProducto/99999.jpg','AZAR',1800);
/*!40000 ALTER TABLE `tipo_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tipo_usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK_kfsp0s1tflm1cwlj8idhqsad0` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,_binary '','Rodriguez','grodriguez@clawtech.com.uy','Guillermo','$2a$10$wffAhlkRwbVa2NmpP50oHOZBzZ01FfPT/4xFGBA.FSIf50j9fcgJe','ADMIN'),(2,_binary '','Fernandez','tfernandez@clawtech.com.uy','Tomas','$2a$10$9CL7X4y99uTOOIDEto.0huUsGzTnf5yinFTbnQYF./3UPD5zB7QlK','ADMIN'),(3,_binary '','Gutierrez','agutierrez@clawtech.com.uy','Andres','$2a$10$1PlHl6iI7nejiz8Pv8VcR.tGzndiMFVG1tZP9kk1gfFyJiD0K98NW','ADMIN');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-17 12:00:26
