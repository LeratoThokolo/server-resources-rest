-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2018 at 10:01 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `picknpaydatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `bankid` int(11) NOT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `branch_code` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`bankid`, `bank_name`, `branch_code`) VALUES
(124, 'ABSA', '632005'),
(125, 'FNB', '250655'),
(126, 'Capitec', '470010'),
(127, 'Nedbank', '198765'),
(128, 'Investec', '580105'),
(129, 'Standard Bank', '051001'),
(130, 'SA Post Bank (Post Office)', '460005'),
(131, 'Bidvest Bank', '462005'),
(132, 'Bank of Athens', '410506');

-- --------------------------------------------------------

--
-- Table structure for table `bank_detail`
--

CREATE TABLE `bank_detail` (
  `id` int(11) NOT NULL,
  `account_number` int(11) NOT NULL,
  `pin` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `bank_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank_detail`
--

INSERT INTO `bank_detail` (`id`, `account_number`, `pin`, `user_id`, `bank_id`) VALUES
(259, 11478, 124587, 146, 126),
(257, 989898, 142556, 117, 124),
(261, 94515, 147855, 117, 127),
(272, 9874521, 321547, 269, 129);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categoryid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryid`, `name`) VALUES
(55, 'Wine & Liquor'),
(56, 'Fresh Food'),
(57, 'Frozen Food'),
(58, 'Food Cupboard'),
(59, 'Convenience Meals'),
(60, 'Beverages'),
(69, 'Health & Beauty'),
(70, 'Baby'),
(71, 'Household Cleaning'),
(72, 'Electronics & Office'),
(73, 'Home & Outdoor');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `house_no` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `street_name` varchar(255) DEFAULT NULL,
  `surburb` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  `userid` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`house_no`, `postal_code`, `street_name`, `surburb`, `town`, `userid`) VALUES
('3288 phase 1', '1458', 'Archmat Dangor', 'Eden Park Tokoza', 'Alberton', 117),
('3670', '1632', 'Cameroon Street', 'Tembisa Tswelopele', 'Kempton Park', 146),
('3288 phase 1', '1458', 'Archmat Dangor', 'Eden Park Tokoza', 'Alberton', 268),
('3288 phase 1', '1458', 'Archmat Dangor', 'Eden Park Tokoza', 'Alberton', 269);

-- --------------------------------------------------------

--
-- Table structure for table `customer_order`
--

CREATE TABLE `customer_order` (
  `orderid` int(11) NOT NULL,
  `amount` double NOT NULL,
  `date_created` date DEFAULT NULL,
  `delivered` varchar(255) DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `order_number` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `full_names` varchar(255) DEFAULT NULL,
  `house_no` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_order`
--

INSERT INTO `customer_order` (`orderid`, `amount`, `date_created`, `delivered`, `driver_id`, `order_number`, `user_id`, `area`, `full_names`, `house_no`) VALUES
(260, 9598.5, '2018-04-17', 'Yes', 162, 146, 146, 'Tembisa Tswelopele', 'Karabo Thokolo', '3670'),
(262, 607, '2018-04-17', 'No', 0, 117, 117, 'Eden Park Tokoza', 'Lesedi Thokolo', '3288 phase 1'),
(271, 40149.630000000005, '2018-04-18', 'No', 0, 268, 268, 'Eden Park Tokoza', 'Morongwa Thokolo', '3288 phase 1'),
(273, 682.4, '2018-04-18', 'No', 0, 269, 269, 'Eden Park Tokoza', 'Mosibudi Salome Ramere', '3288 phase 1');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `userid` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`userid`) VALUES
(162),
(163);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(274),
(274);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productid` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `purchased` tinyint(1) NOT NULL,
  `unit_price` double NOT NULL,
  `category_categoryid` int(11) DEFAULT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productid`, `image`, `name`, `purchased`, `unit_price`, `category_categoryid`, `quantity`) VALUES
(65, 'assets/images/heineken-lager-beer.jpg', 'Beer', 0, 22, 55, 85),
(66, 'assets/images/Eggs-in-basket.jpg', 'Eggs', 0, 14, 56, 90),
(67, 'assets/images/dacheese.png', 'Cheese', 0, 29, 56, 25),
(76, 'assets/images/71e6C8g0BFL._SL1500_.jpg', 'Cream & Lotion', 0, 36, 70, 69),
(77, 'assets/images/m_55c1b17a71ca4.jpg', 'Freshpak Rooibos', 0, 53, 60, 60),
(118, 'assets/images/silo5000267014005front130802300W300H.jpg', 'Johnnie Walker Red Label Whisky 750ml', 0, 226, 55, 10),
(119, 'assets/images/silo5010494564839front130205300W300H.jpg', 'Glenmorangie 18 YO Single Malt Whisky 750ml', 0, 1714.9, 55, 36),
(120, 'assets/images/silo6001504000040front260890300W300H.jpg', 'Charka Braaimeester 5kg', 0, 70, 73, 15),
(121, 'assets/images/silo6009671882469front247464300W300H.jpg', 'Ola Rich \'n Creamy Neapolitan Ice Cream 2l', 0, 39.99, 57, 22),
(122, 'assets/images/silo6001087355087front247450300W300H.jpg', 'Ola Magnum Chocolate Ice Cream Almond 110ml', 0, 27.24, 57, 42);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `roleid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`roleid`, `name`) VALUES
(1, 'Admin'),
(2, 'Supplier'),
(3, 'Driver'),
(4, 'Customer');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `userid` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`userid`) VALUES
(265),
(266),
(267);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `cell_no` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_names` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `last_password_reset_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `cell_no`, `email`, `full_names`, `password`, `user_name`, `last_password_reset_date`) VALUES
(5, '0720682472', 'leratongoakothokolo@gmail.com', 'Lerato Thokolo', 'lerato', 'lerato', NULL),
(117, '0713547217', 'lesedi.phoko@thokolo.co.za', 'Lesedi Thokolo', 'lesedi', 'lesedi', NULL),
(146, '0716126650', 'karabo.luther@thokolo.co.za', 'Karabo Thokolo', 'karabo', 'karabo', NULL),
(162, '0660668940', 'shakes@thokolo.com', 'Phineas Thokolo', 'shakes', 'shakes', NULL),
(163, '0761172425', 'sontaga@thokolo.com', 'Sontaga Thokolo', 'sondy', 'sontaga', NULL),
(266, '0791572221', 'richard.mrich@thokolo.co.za', 'Richard Thokolo', 'mrich', 'mrich', NULL),
(265, '0721739740', 'pele.philemon@thokolo.co.za', 'Pele Thokolo', 'mathuba', 'mathuba', NULL),
(267, '0624296458', 'baholo.matome@thokolo.co.za', 'Matome Hezekiel Thokolo', 'baholo', 'baholo', NULL),
(268, '0728355604', 'grace.morongwa@thokolo.com', 'Morongwa Thokolo', 'grace', 'grace', NULL),
(269, '0713547217', 'shibu.ramere@thokolo.co.za', 'Mosibudi Salome Ramere', 'shibu', 'shibu', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `userid` int(11) NOT NULL,
  `roles_roleid` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`userid`, `roles_roleid`) VALUES
(5, 1),
(114, 4),
(115, 4),
(116, 4),
(117, 4),
(146, 4),
(162, 3),
(163, 3),
(263, 3),
(264, 3),
(265, 2),
(266, 2),
(267, 2),
(268, 4),
(269, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`bankid`);

--
-- Indexes for table `bank_detail`
--
ALTER TABLE `bank_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKd8va9wuvjcbh83nqjcyy7akuo` (`bank_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryid`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`userid`);

--
-- Indexes for table `customer_order`
--
ALTER TABLE `customer_order`
  ADD PRIMARY KEY (`orderid`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`userid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productid`),
  ADD KEY `FKkgovblhcwws5vfdokgm6qs0tg` (`category_categoryid`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`roleid`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`userid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`userid`,`roles_roleid`),
  ADD KEY `FKd5arsgyp9prbwjw255td66hu7` (`roles_roleid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
