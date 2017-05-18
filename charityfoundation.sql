-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2017 at 09:19 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `charityfoundation`
--

-- --------------------------------------------------------

--
-- Table structure for table `announcements`
--

CREATE TABLE `announcements` (
  `id` int(11) NOT NULL,
  `text` varchar(8000) NOT NULL,
  `date` timestamp NOT NULL,
  `telephone` varchar(100) NOT NULL,
  `account` int(11) NOT NULL,
  `picture` varchar(100) NOT NULL,
  `title` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `announcements`
--

INSERT INTO `announcements` (`id`, `text`, `date`, `telephone`, `account`, `picture`, `title`) VALUES
(4, 'Announcement1', '2017-03-21 19:12:06', '38761380026', 1452541, 'announcement1.png', 'Announcement1'),
(5, 'Announcement2', '2017-03-21 19:12:37', '38761380026', 7454215, 'announcement2.png', 'Announcement2'),
(2332, 'Announcement3Announcement3Announcement3Announcement3Announcement3Announcement3', '2017-03-21 19:14:50', '38761456296', 1781246, 'announcement3.png', 'Announcement3'),
(2334, 'Announcement4', '2017-03-21 19:12:37', '38761456296', 221212, 'announcement4.png', 'Announcement4');

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `text` varchar(1000) NOT NULL,
  `date` date NOT NULL,
  `user_id` int(11) NOT NULL,
  `announcement_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `text`, `date`, `user_id`, `announcement_id`) VALUES
(1, 'comment1', '2017-05-04', 26, 4),
(3, 'comment2comment2comment2comment2comment2comment2comment2comment2comment2', '2017-05-11', 26, 2332),
(4, 'Comment3Comment3Comment3Comment3Comment3Comment3Comment3Comment3', '2017-05-12', 26, 2332),
(5, 'Comment4Comment4Comment4Comment4Comment4Comment4Comment4Comment4Comment4', '2017-05-13', 26, 2332);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL,
  `enabled` int(11) NOT NULL,
  `telephone` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `registered` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `role`, `enabled`, `telephone`, `email`, `registered`) VALUES
(26, 'admin', 'admin', 'ROLE_ADMIN', 1, '38761380026', 'ilvana.brankovic@gmail.com', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `announcements`
--
ALTER TABLE `announcements`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user` (`user_id`) USING BTREE,
  ADD KEY `announcement` (`announcement_id`) USING BTREE;

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `announcements`
--
ALTER TABLE `announcements`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2335;
--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`announcement_id`) REFERENCES `announcements` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
