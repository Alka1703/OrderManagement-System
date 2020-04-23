-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 20, 2020 at 04:32 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oms_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `CartId` int(5) NOT NULL,
  `UserId` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`CartId`, `UserId`) VALUES
(304, 904),
(305, 905),
(306, 906),
(307, 907);

-- --------------------------------------------------------

--
-- Table structure for table `cart_items`
--

CREATE TABLE `cart_items` (
  `CartId` int(5) NOT NULL,
  `ProductId` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cart_items`
--

INSERT INTO `cart_items` (`CartId`, `ProductId`) VALUES
(304, 5),
(304, 15),
(304, 10),
(305, 1),
(306, 5),
(306, 8),
(306, 9),
(307, 11),
(307, 14);

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `OrderId` int(5) NOT NULL,
  `ProductId` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`OrderId`, `ProductId`) VALUES
(501, 6),
(501, 3),
(501, 2),
(502, 8),
(502, 2),
(502, 8),
(502, 7),
(503, 4),
(503, 5),
(503, 3),
(504, 7),
(504, 8);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `orderId` int(5) NOT NULL,
  `orderNum` varchar(15) NOT NULL,
  `orderedOn` date NOT NULL,
  `orderedBy` int(5) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`orderId`, `orderNum`, `orderedOn`, `orderedBy`, `status`) VALUES
(501, 'OD124719220', '2020-01-26', 901, 'CONFIRMED'),
(502, 'OD119215410', '2020-02-14', 902, 'PACKED'),
(503, 'OD119215340', '2020-03-23', 903, 'BILLED'),
(504, 'OD116410240', '2020-04-01', 904, 'OUT_FOR_DELIVERY');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProductId` int(5) NOT NULL,
  `productcode` varchar(4) NOT NULL,
  `name` varchar(15) NOT NULL,
  `description` varchar(30) NOT NULL,
  `price` int(5) NOT NULL,
  `category` varchar(40) NOT NULL,
  `count` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductId`, `productcode`, `name`, `description`, `price`, `category`, `count`) VALUES
(1, 'A001', 'Spoon', 'Stainless steel', 80, 'HOME_AND_KITCHEN', 0),
(2, 'A002', 'Milk boiler', 'Stainless steel item', 300, 'HOME_AND_KITCHEN', 0),
(3, 'A003', 'Belan', 'Wooden, slim', 80, 'HOME_AND_KITCHEN', 0),
(4, 'A004', 'Chakla', 'Wooden', 300, 'HOME_AND_KITCHEN', 0),
(5, 'A005', 'Dough maker', 'Plastic', 120, 'HOME_AND_KITCHEN', 0),
(6, 'B006', 'Bhujiya', 'Haldiram\'s Prabhuji bhujiya', 90, 'BISCUITS_SNACKS_CHOCOLATES', 0),
(7, 'B007', 'Choco fills', 'Dark Fantasy', 30, 'BISCUITS_SNACKS_CHOCOLATES', 0),
(8, 'B008', 'Hide and Seek', 'Choco chip cookies', 30, 'BISCUITS_SNACKS_CHOCOLATES', 0),
(9, 'B009', 'Oreo', 'Chocolate cookies', 30, 'BISCUITS_SNACKS_CHOCOLATES', 0),
(10, 'B010', 'Maggi masala', 'Jumbo pack', 40, 'BISCUITS_SNACKS_CHOCOLATES', 0),
(11, 'C011', 'Tea', 'Tata tea', 60, 'BEVERAGES', 0),
(12, 'C011', 'Coffee', 'Brew', 50, 'BEVERAGES', 0),
(13, 'C012', 'Green Tea', 'Red label', 100, 'BEVERAGES', 0),
(14, 'C014', 'Soup', 'Knorr', 10, 'BEVERAGES', 0),
(15, 'C015', 'Sugar', '1 kg packet', 40, 'BEVERAGES', 0),
(16, 'C016', 'White powder', 'Amul', 197, 'BREAKFAST_AND_DAIRY', 0),
(17, 'C017', 'toned milk', 'packaged tetra pack', 70, 'BREAKFAST_AND_DAIRY', 0),
(18, 'C018', 'bread', 'fresh packeet', 10, 'BREAKFAST_AND_DAIRY', 0),
(19, 'C019', 'butter', 'Amul', 20, 'BREAKFAST_AND_DAIRY', 0),
(20, 'C020', 'cheese', 'Amul', 14, 'BREAKFAST_AND_DAIRY', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userid` int(5) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(10) NOT NULL,
  `address` varchar(15) NOT NULL,
  `name` varchar(15) NOT NULL,
  `phone` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES
(901, 'aastha_shah@persistent.co', 'aastha123', 'kolkata', 'Aastha Shah', 987889790),
(902, 'alka_prasad@persistent.co', 'alka123', 'kolkata', 'Alka Prasad', 78906808),
(903, 'saloni_lohia@persistent.c', 'saloni123', 'kolkata', 'Saloni Lohia', 790648533),
(904, 'pritha_hazra@persistent.c', 'pritha123', 'kolkata', 'Pritha Hazra', 685309882),
(905, 'aniruddh_kotecha@persiste', 'aniruddh12', 'kolkata', 'Aniruddh Kotech', 797680089),
(906, 'pulkit_vatsal@persistent.', 'pulkit123', 'kolkata', 'Pulkit Vatsal', 980969075),
(907, 'rashmi_prasad@persistent.com', 'rashmi123', 'kolkata', 'Rashmi Prasad', 989788987);

-- --------------------------------------------------------

--
-- Table structure for table `wishes`
--

CREATE TABLE `wishes` (
  `WishlistId` int(5) NOT NULL,
  `ProductId` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `wishes`
--

INSERT INTO `wishes` (`WishlistId`, `ProductId`) VALUES
(1001, 2),
(1001, 5),
(1002, 3),
(1002, 10),
(1002, 15),
(1003, 11),
(1003, 9),
(1003, 6),
(1004, 14),
(1004, 13);

-- --------------------------------------------------------

--
-- Table structure for table `wishlist`
--

CREATE TABLE `wishlist` (
  `WishlistID` int(5) NOT NULL,
  `WishedBy` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `wishlist`
--

INSERT INTO `wishlist` (`WishlistID`, `WishedBy`) VALUES
(1001, 901),
(1002, 902),
(1003, 903),
(1004, 904);


CREATE TABLE stock (
    StockId int(5) PRIMARY KEY,
    Quantity int(5) ,
    ProductId int(5) FOREIGN KEY REFERENCES product(ProductId)
);

INSERT INTO stock values(1,5,2);
INSERT INTO stock values(2,3,9);
INSERT INTO stock values(3,8,7);
INSERT INTO stock values(4,4,19);
INSERT INTO stock values(5,1,10);
INSERT INTO stock values(6,9,14);
INSERT INTO stock values(7,12,8);
INSERT INTO stock values(8,10,6);
INSERT INTO stock values(9,2,3);
INSERT INTO stock values(10,13,1);
INSERT INTO stock values(11,12,5);
INSERT INTO stock values(12,10,31);
INSERT INTO stock values(13,17,22);
INSERT INTO stock values(14,15,33);
INSERT INTO stock values(15,1,17);
INSERT INTO stock values(16,9,11);
INSERT INTO stock values(17,12,37);
INSERT INTO stock values(18,7,26);
INSERT INTO stock values(19,11,40);
INSERT INTO stock values(20,16,18);
INSERT INTO stock values(21,3,4);
INSERT INTO stock values(22,2,34);
INSERT INTO stock values(23,6,29);
INSERT INTO stock values(24,1,20);
INSERT INTO stock values(25,3,16);
INSERT INTO stock values(26,17,32);
INSERT INTO stock values(27,19,38);
INSERT INTO stock values(28,20,39);
INSERT INTO stock values(29,15,21);
INSERT INTO stock values(30,11,30);
INSERT INTO stock values(31,7,23);
INSERT INTO stock values(32,9,28);
INSERT INTO stock values(33,2,15);
INSERT INTO stock values(34,4,36);
INSERT INTO stock values(35,6,12);
INSERT INTO stock values(36,10,25);
INSERT INTO stock values(37,13,27);
INSERT INTO stock values(38,2,13);
INSERT INTO stock values(39,9,35);
INSERT INTO stock values(40,20,24);



--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`CartId`),
  ADD UNIQUE KEY `UserId` (`UserId`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderId`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`);

--
-- Indexes for table `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`WishlistID`,`WishedBy`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
