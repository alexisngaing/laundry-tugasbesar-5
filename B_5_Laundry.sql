-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2023 at 06:44 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundry-tubes`
--

-- --------------------------------------------------------

--
-- Table structure for table `cucian`
--

CREATE TABLE `cucian` (
  `id` int(11) NOT NULL,
  `statusCuci` varchar(6) NOT NULL,
  `statusDry` varchar(6) NOT NULL,
  `berat` float NOT NULL,
  `tglMasuk` date NOT NULL,
  `tglKeluar` date NOT NULL,
  `idPelanggan` int(11) NOT NULL,
  `idMesin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cucian`
--

INSERT INTO `cucian` (`id`, `statusCuci`, `statusDry`, `berat`, `tglMasuk`, `tglKeluar`, `idPelanggan`, `idMesin`) VALUES
(6, 'true', 'False', 9.12, '2023-06-13', '2023-06-13', 3, 1),
(7, 'False', 'False', 6.9, '2023-06-13', '2023-06-15', 4, 2),
(9, 'true', 'False', 1.11, '2023-06-13', '2023-06-13', 6, 1),
(11, 'true', 'False', 14.2, '2023-06-13', '2023-06-15', 3, 1),
(14, 'false', 'False', 3, '2023-06-13', '2023-06-15', 7, 2),
(15, 'false', 'False', 8, '2023-06-13', '2023-06-15', 3, 1),
(16, 'true', 'False', 21, '2023-06-13', '2023-06-15', 5, 1),
(19, 'true', 'False', 5.6, '2023-06-13', '2023-06-13', 4, 2),
(21, 'false', 'False', 3, '2023-06-13', '2023-06-15', 3, 1),
(22, 'false', 'False', 4, '2023-06-13', '2023-06-15', 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `mesin`
--

CREATE TABLE `mesin` (
  `id` int(11) NOT NULL,
  `status` varchar(6) NOT NULL,
  `kapasitas` float NOT NULL,
  `durasi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mesin`
--

INSERT INTO `mesin` (`id`, `status`, `kapasitas`, `durasi`) VALUES
(1, '1', 8.1, '2023-06-14'),
(2, '1', 9, '2023-06-13');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `noTelp` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id`, `nama`, `noTelp`, `alamat`) VALUES
(3, 'Adit', '0812345', 'Jalan Mliwis'),
(4, 'Vemas', '81233541', 'Condong Catur'),
(5, 'Giri', '081291273', 'Depok'),
(6, 'Dave', '08912388214', 'Babarsari'),
(7, 'Alex', '09123791', 'Kalimantan'),
(8, 'Robert', '089123941', 'New York');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` int(11) NOT NULL,
  `totalBiaya` float NOT NULL,
  `idCucian` int(11) NOT NULL,
  `idPelanggan` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `totalBiaya`, `idCucian`, `idPelanggan`) VALUES
(2, 40000, 15, 0),
(3, 20000, 22, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cucian`
--
ALTER TABLE `cucian`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPelanggan` (`idPelanggan`),
  ADD KEY `idMesin` (`idMesin`);

--
-- Indexes for table `mesin`
--
ALTER TABLE `mesin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idTransaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cucian`
--
ALTER TABLE `cucian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `mesin`
--
ALTER TABLE `mesin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `idTransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cucian`
--
ALTER TABLE `cucian`
  ADD CONSTRAINT `cucian_ibfk_1` FOREIGN KEY (`idPelanggan`) REFERENCES `pelanggan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cucian_ibfk_2` FOREIGN KEY (`idMesin`) REFERENCES `mesin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
