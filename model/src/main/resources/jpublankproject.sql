-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2016 at 02:08 PM
-- Server version: 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jpublankproject`
--
CREATE DATABASE IF NOT EXISTS `jpublankproject` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `jpublankproject`;

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `loadmapById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadmapById` (IN `idmap` INT(11))  NO SQL
  SELECT * FROM map WHERE id = idmap$$

DROP PROCEDURE IF EXISTS `loadmapByKey`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadmapByKey` (IN `namemap` VARCHAR(50))  NO SQL
  SELECT * FROM map WHERE map_name = namemap$$

DROP PROCEDURE IF EXISTS `putHighscoreInDB`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `putHighscoreInDB` (IN `number` INT(11), IN `name` VARCHAR(50))  NO SQL
  INSERT INTO highscore (nickname, score)
  VALUES (name, number)$$

DROP PROCEDURE IF EXISTS `sortHighscoreByDescendingOrder`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sortHighscoreByDescendingOrder` ()  NO SQL
  SELECT * FROM highscore
  ORDER BY score DESC limit 6$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `highscore`
--

DROP TABLE IF EXISTS `highscore`;
CREATE TABLE IF NOT EXISTS `highscore` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(11) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `highscore`
--

INSERT INTO `highscore` (`score_id`, `score`, `nickname`) VALUES
  (1, 800, 'Dipper'),
  (2, 1200, 'Mabbel'),
  (3, 0, 'Waddles'),
  (4, 100, 'StanPines'),
  (5, 9999, 'Soos'),
  (6, 300, 'Wendy');

-- --------------------------------------------------------

--
-- Table structure for table `map`
--

DROP TABLE IF EXISTS `map`;
CREATE TABLE IF NOT EXISTS `map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map_name` varchar(50) NOT NULL,
  `map` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `map`
--

INSERT INTO `map` (`id`, `map_name`, `map`) VALUES
  (1, 'MAP1', 'BHHHHHHHHHHHHHHHHHHB\nV    V             V\nV    V             V\nV    V     P       V\nV  P BHHHHHB       V\nV P P1     P  L  KCV\nV  P BHHHHHB       V\nV    V     P       V\nV    V             V\nV    V             V\nV    V             V\nBHHHHHHHHHHHHHHHHHHB'),
  (2, 'MAP2', '        BHHB        \n        VP V        \nBHHHHHB V  BHHHHHHB \nV4    BHB L  P   2V \nV       K  BHBHBBHB \nV     BHB  B V VV V \nVP    V V  BHBHBBHB \nV P   V V  BHBHBBHB \nVP    V V  V V VV V \nV PBHHBHB  BHBHBBHBB\nV               3 CV\nBHHHHHHHHHHHHHHHHHHB'),
  (3, 'MAP3', 'BHHHHHHHB    BHHHHHB\nVP      V    V1   3V\nV BHHHB V    V  B  V\nV V     V    V  P  V\nB V BHHHBHHHHB  P  V\nC V V   V  L V BPB V\nBKV B B B    V  P  V\nV V   V      V  P  V\nV BHHHHHBHHHHB  P  V\nV               B  V\nV       BHHHHB2   4V\nBHHHHHHHB    BHHHHHB'),
  (4, 'MAP4', 'BHHHHHHHHHHHHHHHHHB \nV                 BB\nV BHHHHHHHHHHHHHB  V\nV P          2  BB V\nV BHHHHHHHHHHHB  V V\nV V4           B V V\nVKV            B V V\nV BHHHHHHHHHHHB  V V\nV P   1         BB V\nV BHHHHHHHHHHHHHBL B\nBB                 C\n BHHHHHHHHHHHHHHHHHB'),
  (5, 'MAP5', 'BHHHHHHHHHHHBHHHHB  \nVP P        V    BB \nV  B  B3 B  V     V \nV  V4 P  P1 V   B V \nV  V  P  P  V   V V \nV  V  P  P  V   V V \nV  V  B  B  V   V V \nV  V        V   V V \nV  BHHHHHHHHB   V V \nV  K        L BHB V \nBB               CBB\n BHHHHHHHHHHHHHHHHHB'),
  (6, 'MAP6', 'BHHBHHHHHHHHHHHHBHHB\r\nV1 B            B 2V\r\nV  B            B  V\r\nBBBB      C     BBBB\r\nV                  V\r\nV       P L P      V\r\nV                  V\r\nV         K        V\r\nBBBB            BBBB\r\nV  B            B  V\r\nV4 B            B 3V\r\nBHHBHHHHHHHHHHHHBHHB');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
