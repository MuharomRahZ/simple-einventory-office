-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2022 at 07:49 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tescrudpbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `log_login`
--

CREATE TABLE `log_login` (
  `id` bigint(18) NOT NULL,
  `id_user` varchar(50) NOT NULL,
  `waktu_login` timestamp NOT NULL DEFAULT current_timestamp(),
  `waktu_logout` timestamp NULL DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `log_login`
--

INSERT INTO `log_login` (`id`, `id_user`, `waktu_login`, `waktu_logout`) VALUES
(1, 'admin', '2022-06-02 03:33:44', '2022-06-02 03:36:41'),
(2, 'admin', '2022-06-02 03:43:05', '2022-06-02 03:43:43');

-- --------------------------------------------------------

--
-- Table structure for table `marketing`
--

CREATE TABLE `marketing` (
  `idBarang` varchar(20) NOT NULL,
  `namaBarang` varchar(100) DEFAULT NULL,
  `tglMasuk` date DEFAULT NULL,
  `jumlahBarang` double DEFAULT NULL,
  `hargaSatuan` double DEFAULT NULL,
  `hargaTotal` double DEFAULT NULL,
  `barangHadir` double DEFAULT NULL,
  `barangAway` double DEFAULT NULL,
  `tglKeluar` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `marketing`
--

INSERT INTO `marketing` (`idBarang`, `namaBarang`, `tglMasuk`, `jumlahBarang`, `hargaSatuan`, `hargaTotal`, `barangHadir`, `barangAway`, `tglKeluar`) VALUES
('carpet129', 'karpet lantai', '2022-04-04', 10, 1000000, 100, 10, 0, '2022-04-04'),
('chair125', 'desk chair', '2022-05-02', 200, 2000000, 400000000, 195, 5, '2022-05-09'),
('com121', 'komputer', '2022-05-02', 5, 10000000, 50000000, 4, 1, '2022-05-23'),
('table127', 'meja', '2022-04-04', 10, 5000000, 100, 9, 1, '2022-05-30');

-- --------------------------------------------------------

--
-- Table structure for table `personalia`
--

CREATE TABLE `personalia` (
  `idBarang` varchar(20) NOT NULL,
  `namaBarang` varchar(100) DEFAULT NULL,
  `tglMasuk` date DEFAULT NULL,
  `jumlahBarang` double DEFAULT NULL,
  `hargaSatuan` double DEFAULT NULL,
  `hargaTotal` double DEFAULT NULL,
  `barangHadir` double DEFAULT NULL,
  `barangAway` double DEFAULT NULL,
  `tglKeluar` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `personalia`
--

INSERT INTO `personalia` (`idBarang`, `namaBarang`, `tglMasuk`, `jumlahBarang`, `hargaSatuan`, `hargaTotal`, `barangHadir`, `barangAway`, `tglKeluar`) VALUES
('chair115', 'desk chair', '2022-04-04', 200, 2000000, 400000000, 125, 75, '2022-05-20'),
('table111', 'meja', '2022-05-02', 20, 5000000, 400, 15, 5, '2022-05-16');

-- --------------------------------------------------------

--
-- Table structure for table `produksi`
--

CREATE TABLE `produksi` (
  `idBarang` varchar(20) NOT NULL,
  `namaBarang` varchar(100) DEFAULT NULL,
  `tglMasuk` date DEFAULT NULL,
  `jumlahBarang` double DEFAULT NULL,
  `hargaSatuan` double DEFAULT NULL,
  `hargaTotal` double DEFAULT NULL,
  `barangHadir` double DEFAULT NULL,
  `barangAway` double DEFAULT NULL,
  `tglKeluar` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produksi`
--

INSERT INTO `produksi` (`idBarang`, `namaBarang`, `tglMasuk`, `jumlahBarang`, `hargaSatuan`, `hargaTotal`, `barangHadir`, `barangAway`, `tglKeluar`) VALUES
('chair105', 'desk chair', '2022-04-04', 200, 2000000, 400000000, 195, 5, '2022-05-02'),
('table101', 'meja desk', '2022-04-04', 100, 5000000, 500000000, 90, 10, '2022-05-09');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nama` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `password`, `nama`) VALUES
('admin', '25d55ad283aa400af464c76d713c07ad', 'Administrator');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `log_login`
--
ALTER TABLE `log_login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `marketing`
--
ALTER TABLE `marketing`
  ADD PRIMARY KEY (`idBarang`);

--
-- Indexes for table `personalia`
--
ALTER TABLE `personalia`
  ADD PRIMARY KEY (`idBarang`);

--
-- Indexes for table `produksi`
--
ALTER TABLE `produksi`
  ADD PRIMARY KEY (`idBarang`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `log_login`
--
ALTER TABLE `log_login`
  MODIFY `id` bigint(18) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
