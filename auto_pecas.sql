-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: auto_pecas
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `bairro` varchar(60) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_fisico`
--

DROP TABLE IF EXISTS `cliente_fisico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_fisico` (
  `idcliente_fisico` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(45) DEFAULT NULL,
  `rg` varchar(45) DEFAULT NULL,
  `dtNascimento` date DEFAULT NULL,
  `idcliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcliente_fisico`),
  KEY `idCliente_idx` (`idcliente`),
  CONSTRAINT `idCliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_fisico`
--

LOCK TABLES `cliente_fisico` WRITE;
/*!40000 ALTER TABLE `cliente_fisico` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente_fisico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_juridico`
--

DROP TABLE IF EXISTS `cliente_juridico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_juridico` (
  `idcliente_juridico` int(11) NOT NULL,
  `inscricaoEstadual` varchar(45) DEFAULT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `fundacao` date DEFAULT NULL,
  `idcliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcliente_juridico`),
  KEY `idCliente_juridco_idx` (`idcliente`),
  CONSTRAINT `idCliente_juridco` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_juridico`
--

LOCK TABLES `cliente_juridico` WRITE;
/*!40000 ALTER TABLE `cliente_juridico` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente_juridico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-08 12:30:30
