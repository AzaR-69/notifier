-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 01, 2021 at 01:17 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `notifier`
--

-- --------------------------------------------------------

--
-- Table structure for table `newnote`
--

CREATE TABLE `newnote` (
  `id` int(11) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `notebookName` varchar(50) DEFAULT NULL,
  `noteName` varchar(50) DEFAULT NULL,
  `startDate` varchar(15) DEFAULT NULL,
  `endDate` varchar(15) DEFAULT NULL,
  `remainderDate` varchar(15) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `tag` varchar(10) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `newnote`
--

INSERT INTO `newnote` (`id`, `email`, `notebookName`, `noteName`, `startDate`, `endDate`, `remainderDate`, `status`, `tag`, `description`) VALUES
(26, 'naveenj@gmail.com', 'Virtusa Material', 'Backend', '2021-02-17', '2021-02-20', '2021-02-19', 'Not Started', 'private', 'Start backend process'),
(27, 'naveenj@gmail.com', 'Semester 8', 'Cognitive Radio', '2021-02-21', '2021-02-24', '2021-02-23', 'Not Started', 'public', 'Start preparing for CR exam'),
(29, 'naveenj@gmail.com', 'Semester 8', 'NRA', '2021-02-26', '2021-02-27', '2021-02-26', 'Not Started', 'private', 'Start preparing for NRA'),
(31, 'naveenj@gmail.com', 'Virtusa Material', 'FrontEnd', '2021-02-17', '2021-02-20', '2021-02-19', 'Not Started', 'public', 'Start doing Front End '),
(64, 'ethan15@gmail.com', 'Second Sample', 'Type Script assignment', '2021-03-01', '2021-03-03', '2021-03-01', 'Not Started', 'private', 'Reminder to start typescript project\r\n\r\n '),
(65, 'ethan15@gmail.com', 'Virtusa Preparation', 'Java Fundamentals', '2021-03-01', '2021-03-04', '2021-03-01', 'Started', 'private', 'Reminder to prepare for Java\r\n'),
(67, 'ethan15@gmail.com', 'Virtusa Preparation', 'Java EE', '2021-03-01', '2021-03-08', '2021-03-03', 'Not Started', 'private', 'Go through Java EE concepts');

-- --------------------------------------------------------

--
-- Table structure for table `notebook_db`
--

CREATE TABLE `notebook_db` (
  `id` int(11) NOT NULL,
  `email` varchar(120) DEFAULT NULL,
  `notebookName` varchar(100) DEFAULT NULL,
  `count` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notebook_db`
--

INSERT INTO `notebook_db` (`id`, `email`, `notebookName`, `count`) VALUES
(19, 'naveenj@gmail.com', 'Virtusa Material', 2),
(20, 'naveenj@gmail.com', 'Semester 8', 3),
(26, 'ethan15@gmail.com', 'Second Sample', 1),
(32, 'ethan15@gmail.com', 'Virtusa Preparation', 2);

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(11) NOT NULL,
  `userName` varchar(15) DEFAULT NULL,
  `phoneNumber` varchar(10) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `userName`, `phoneNumber`, `email`, `password`) VALUES
(1, 'ethan20', '8965321047', 'ethan15@gmail.com', 'EthaN20'),
(4, 'jd_professor', '6541230987', 'jd_prof@gmail.com', 'jackdaniels'),
(5, 'naveen_j2017', '6541239870', 'naveenj@gmail.com', 'NaveeNj20'),
(6, 'naveen_j2017', '6987541230', 'naveenj@gmail.com', 'NaveenJ'),
(7, 'nithishh', '9941697284', 'itsmygame1999@gmail.com', 'Qwerty@123'),
(17, 'inder18', '7452103698', 'inder@gmail.com', 'IndeR18'),
(18, 'adas@gmail.com', 'fasd', 'sadad@gmail.com', 'dadd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `newnote`
--
ALTER TABLE `newnote`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notebook_db`
--
ALTER TABLE `notebook_db`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `newnote`
--
ALTER TABLE `newnote`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT for table `notebook_db`
--
ALTER TABLE `notebook_db`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
