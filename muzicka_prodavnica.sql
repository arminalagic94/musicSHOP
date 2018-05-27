-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 09, 2017 at 03:02 PM
-- Server version: 5.1.53
-- PHP Version: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `muzicka_prodavnica`
--

-- --------------------------------------------------------

--
-- Table structure for table `artikal`
--

CREATE TABLE IF NOT EXISTS `artikal` (
  `id_artikal` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `tip` varchar(10) NOT NULL,
  `opis` varchar(200) NOT NULL,
  `slika` varchar(45) NOT NULL,
  `redovna_cijena` varchar(45) NOT NULL,
  `popust_cijena` varchar(45) NOT NULL,
  `br_komada` int(100) NOT NULL,
  PRIMARY KEY (`id_artikal`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `artikal`
--


-- --------------------------------------------------------

--
-- Table structure for table `kupac`
--

CREATE TABLE IF NOT EXISTS `kupac` (
  `id_kupac` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `adresa` varchar(45) NOT NULL,
  `br_telefona` int(45) NOT NULL,
  `br_kupljenih_artikala` int(100) NOT NULL,
  PRIMARY KEY (`id_kupac`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `kupac`
--

INSERT INTO `kupac` (`id_kupac`, `ime`, `prezime`, `username`, `password`, `email`, `adresa`, `br_telefona`, `br_kupljenih_artikala`) VALUES
(1, 'Armin', 'Alagic', 'armin', 'armin', 'armin@gmail.com', 'plandisce 6', 62107667, 0);

-- --------------------------------------------------------

--
-- Table structure for table `prodavac`
--

CREATE TABLE IF NOT EXISTS `prodavac` (
  `id_prodavac` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id_prodavac`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `prodavac`
--


-- --------------------------------------------------------

--
-- Table structure for table `racun`
--

CREATE TABLE IF NOT EXISTS `racun` (
  `id_racun` int(11) NOT NULL AUTO_INCREMENT,
  `id_kupac` int(11) NOT NULL,
  `id_prodavac` int(11) NOT NULL,
  `id_artikal` int(11) NOT NULL,
  `br_komada` int(100) NOT NULL,
  `ukupna_cijena` int(100) NOT NULL,
  `datum` date NOT NULL,
  PRIMARY KEY (`id_racun`),
  KEY `id_kupac` (`id_kupac`,`id_prodavac`,`id_artikal`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `racun`
--

