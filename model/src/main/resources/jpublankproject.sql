-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 13 Juin 2016 à 13:43
-- Version du serveur :  5.7.9
-- Version de PHP :  5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jpublankproject`
--
CREATE DATABASE IF NOT EXISTS `jpublankproject` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `jpublankproject`;

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `helloworldById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `helloworldById` (IN `p_id` INT)  READS SQL DATA
  SQL SECURITY INVOKER
  SELECT * FROM helloworld WHERE id = p_id$$

DROP PROCEDURE IF EXISTS `HelloworldByKey`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `HelloworldByKey` (IN `p_key` VARCHAR(2))  READS SQL DATA
  SQL SECURITY INVOKER
  SELECT * FROM jpublankproject.helloworld where `key`=p_key$$

DROP PROCEDURE IF EXISTS `loadmapById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadmapById` (IN `idmap` INT(11))  NO SQL
  SELECT * FROM map WHERE map_id = idmap$$

DROP PROCEDURE IF EXISTS `loadmapByKey`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadmapByKey` (IN `namemap` VARCHAR(50))  NO SQL
  SELECT * FROM map WHERE map_name = namemap$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `helloworld`
--

DROP TABLE IF EXISTS `helloworld`;
CREATE TABLE IF NOT EXISTS `helloworld` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(2) NOT NULL,
  `message` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_UNIQUE` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `helloworld`
--

INSERT INTO `helloworld` (`id`, `key`, `message`) VALUES
  (1, 'GB', 'Hello world'),
  (2, 'FR', 'Bonjour le monde'),
  (3, 'DE', 'Hallo Welt'),
  (4, 'ID', 'Salamat pagi dunia');

-- --------------------------------------------------------

--
-- Structure de la table `highscore`
--

DROP TABLE IF EXISTS `highscore`;
CREATE TABLE IF NOT EXISTS `highscore` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(11) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `map`
--

DROP TABLE IF EXISTS `map`;
CREATE TABLE IF NOT EXISTS `map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map_name` varchar(50) NOT NULL,
  `map` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `map`
--

INSERT INTO `map` (`id`, `map_name`, `map`) VALUES
  (1, 'MAP1', 'BHHHHHHHHHHHHHHHHHHB\r\nV    V             V\r\nV    V             V\r\nV    V     P       V\r\nV  P BHHHHHB       V\r\nV P P1     K  L   CV\r\nV  P BHHHHHB       V\r\nV    V     P       V\r\nV    V             V\r\nV    V             V\r\nV    V             V\r\nBHHHHHHHHHHHHHHHHHHB'),
  (2, 'MAP2', '        BHHB        \r\n        VP V        \r\nBHHHHHB V  BHHHHHHB \r\nV4    BHB L  B   2V \r\nV   K      BHBHBBHB \r\nV     BHB  V V VV V \r\nVP    V V  BHBHBBHB \r\nV P   V V  BHBHBBHB \r\nVP    V V  V V VV V \r\nV PBHHBHB  BHBHBBHBB\r\nV               3 CV\r\nBHHHHHHHHHHHHHHHHHHB'),
  (3, 'MAP3', 'BHHHHHHHB    BHHHHHB\r\nVP      V    V1   3V\r\nV BHHHB V    V  B  V\r\nV H     V    V  P  V\r\nB H BHHHBHHHHB  P  V\r\nC H V   V  L V BPB V\r\nB H B B B    V  P  V\r\nV H   V      V  P  V\r\nV BHHHHHBHHHHB  P  V\r\nV               B  V\r\nV       BHHHHB2   4V\r\nBHHHHHHHB    BHHHHHB'),
  (4, 'MAP4', 'BHHHHHHHHHHHHHHHHHB \r\nV                 BB\r\nV BHHHHHHHHHHHHHB  V\r\nV P          2  BB V\r\nV BHHHHHHHHHHHB  V V\r\nV V4           B V V\r\nVKV            B V V\r\nV BHHHHHHHHHHHB  V V\r\nV P   1         BB V\r\nV BHHHHHHHHHHHHHBL B\r\nBB                 C\r\n BHHHHHHHHHHHHHHHHHB'),
  (5, 'MAP5', 'BHHHHHHHHHHHBHHHHB  \r\nVP P        V    BB \r\nV  B  B3 B  V     V \r\nV  V4 P  P1 V   B V \r\nV  V  P  P  V   V V \r\nV  V  P  P  V   V V \r\nV  V  B  B  V   V V \r\nV  V        V   V V \r\nV  BHHHHHHHHB   V V \r\nV  K        L BHB V \r\nBB               CBB\r\n BHHHHHHHHHHHHHHHHHB'),
  (6, 'MAP6', 'BHHBHHHHHHHHHHHHBHHB\r\nV1 B            B 2V\r\nV  B            B  V\r\nBBBB      C     BBBB\r\nV                  V\r\nV       P L P      V\r\nV                  V\r\nV         K        V\r\nBBBB            BBBB\r\nV  B            B  V\r\nV4 B            B 3V\r\nBHHBHHHHHHHHHHHHBHHB');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
