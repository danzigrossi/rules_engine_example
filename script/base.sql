CREATE DATABASE  IF NOT EXISTS `rules` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rules`;
-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: rules
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `TB_RULE_X_ACTION`
--

DROP TABLE IF EXISTS `TB_RULE_X_ACTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TB_RULE_X_ACTION` (
  `id_rule` int(11) NOT NULL,
  `id_action` int(11) NOT NULL,
  KEY `fk_TB_RULE_X_ACTION_1_idx` (`id_rule`),
  KEY `fk_TB_RULE_X_ACTION_2_idx` (`id_action`),
  CONSTRAINT `fk_TB_RULE_X_ACTION_1` FOREIGN KEY (`id_rule`) REFERENCES `tb_rule` (`id_rule`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_RULE_X_ACTION_2` FOREIGN KEY (`id_action`) REFERENCES `tb_action` (`id_action`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TB_RULE_X_ACTION`
--

LOCK TABLES `TB_RULE_X_ACTION` WRITE;
/*!40000 ALTER TABLE `TB_RULE_X_ACTION` DISABLE KEYS */;
INSERT INTO `TB_RULE_X_ACTION` VALUES (5,1),(5,2),(4,1),(4,2);
/*!40000 ALTER TABLE `TB_RULE_X_ACTION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TB_RULE_X_CONDITION`
--

DROP TABLE IF EXISTS `TB_RULE_X_CONDITION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TB_RULE_X_CONDITION` (
  `id_rule` int(11) NOT NULL,
  `id_condition` int(11) NOT NULL,
  KEY `fk_TB_RULE_X_CONDITION_1_idx` (`id_rule`),
  KEY `fk_TB_RULE_X_CONDITION_2_idx` (`id_condition`),
  CONSTRAINT `fk_TB_RULE_X_CONDITION_1` FOREIGN KEY (`id_rule`) REFERENCES `tb_rule` (`id_rule`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_RULE_X_CONDITION_2` FOREIGN KEY (`id_condition`) REFERENCES `tb_condition` (`id_condition`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TB_RULE_X_CONDITION`
--

LOCK TABLES `TB_RULE_X_CONDITION` WRITE;
/*!40000 ALTER TABLE `TB_RULE_X_CONDITION` DISABLE KEYS */;
INSERT INTO `TB_RULE_X_CONDITION` VALUES (4,4),(4,2),(5,1),(5,4),(5,3);
/*!40000 ALTER TABLE `TB_RULE_X_CONDITION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_action`
--

DROP TABLE IF EXISTS `tb_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_action` (
  `id_action` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `class_type` varchar(200) NOT NULL,
  `destination` varchar(45) DEFAULT NULL,
  `message_model` varchar(45) DEFAULT NULL,
  `command` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `from` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_action`),
  UNIQUE KEY `id_action_UNIQUE` (`id_action`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_action`
--

LOCK TABLES `tb_action` WRITE;
/*!40000 ALTER TABLE `tb_action` DISABLE KEYS */;
INSERT INTO `tb_action` VALUES (1,'Ação de envio de email','com.rulesengine.action.usecase.processor.EmailActionProcess','a@gmail.com, d@gmail.com','MODEL','','email teste','z@gmail.com'),(2,'Ação de envio de SMS','com.rulesengine.action.usecase.processor.SMSActionProcess','5519991919191,5519991919192,5519991919193','','teste','SMS teste','');
/*!40000 ALTER TABLE `tb_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_condition`
--

DROP TABLE IF EXISTS `tb_condition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_condition` (
  `id_condition` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `type_class` varchar(400) DEFAULT NULL,
  `field_name` varchar(45) DEFAULT NULL,
  `filter_value` varchar(45) DEFAULT NULL,
  `radius` int(11) DEFAULT NULL,
  `area` geometry DEFAULT NULL,
  PRIMARY KEY (`id_condition`),
  UNIQUE KEY `id_condition_UNIQUE` (`id_condition`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_condition`
--

LOCK TABLES `tb_condition` WRITE;
/*!40000 ALTER TABLE `tb_condition` DISABLE KEYS */;
INSERT INTO `tb_condition` VALUES (1,'Regra Velocidade acima de 10','com.rulesengine.rule.usecases.processor.math.BiggerConditionProcessor','Velocity','10',0,NULL),(2,'Regra Velocidade acima de 130','com.rulesengine.rule.usecases.processor.math.BiggerConditionProcessor','Velocity','130',0,NULL),(3,'Regra Velocidade abaixo de 40','com.rulesengine.rule.usecases.processor.math.MinorConditionProcessor','Velocity','40',0,NULL),(4,'Regra status ativo','com.rulesengine.rule.usecases.processor.math.EqualsConditionProcessor','Active','1',0,NULL);
/*!40000 ALTER TABLE `tb_condition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rule`
--

DROP TABLE IF EXISTS `tb_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_rule` (
  `id_rule` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) NOT NULL,
  PRIMARY KEY (`id_rule`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `id_rule_UNIQUE` (`id_rule`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rule`
--

LOCK TABLES `tb_rule` WRITE;
/*!40000 ALTER TABLE `tb_rule` DISABLE KEYS */;
INSERT INTO `tb_rule` VALUES (4,'Ativo com velocidade acima de 130'),(5,'Ativo com velocidade entre 10km/h e 40 km/h'),(6,'Inativo com velocidade acima de 130');
/*!40000 ALTER TABLE `tb_rule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

