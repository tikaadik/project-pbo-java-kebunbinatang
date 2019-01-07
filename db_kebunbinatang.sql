-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2019 at 07:53 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_kebunbinatang`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_herbivora`
--

CREATE TABLE IF NOT EXISTS `tbl_herbivora` (
  `id_binatang` int(20) NOT NULL AUTO_INCREMENT,
  `nama_binatang` int(30) NOT NULL,
  `tipe_binatang` int(25) NOT NULL,
  `jenis_binatang` int(25) NOT NULL,
  `habitat` int(50) NOT NULL,
  `berkembangbiak` int(30) NOT NULL,
  PRIMARY KEY (`id_binatang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_karnivora`
--

CREATE TABLE IF NOT EXISTS `tbl_karnivora` (
  `id_binatang` varchar(25) NOT NULL,
  `nama_binatang` varchar(30) NOT NULL,
  `jk` varchar(25) NOT NULL,
  `jenis_binatang` varchar(25) NOT NULL,
  `habitat` varchar(50) NOT NULL,
  PRIMARY KEY (`id_binatang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_omnivora`
--

CREATE TABLE IF NOT EXISTS `tbl_omnivora` (
  `nama_binatang` int(30) NOT NULL,
  `tipe_binatang` int(25) NOT NULL,
  `jenis_binatang` int(25) NOT NULL,
  `habitat` int(50) NOT NULL,
  `berkembangbiak` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
