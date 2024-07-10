use kbdb;

CREATE TABLE IF NOT EXISTS `product` (
  `productName` varchar(4) NOT NULL,
  `cost` int NOT NULL,
  `makeData` date DEFAULT NULL,
  `companny` varchar(5) DEFAULT NULL,
  `amount` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `member2` (
  `memberID` varchar(8) NOT NULL,
  `memberName` varchar(5) NOT NULL,
  `memberAddress` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DESCRIBE product;


