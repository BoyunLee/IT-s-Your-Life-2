use shop2;

SELECT * FROM shop2.logs;CREATE TABLE `tour` (
  `id` int NOT NULL AUTO_INCREMENT,
  `destination` varchar(255) NOT NULL,
  `duration` int NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tour` (`destination`, `duration`, `price`) VALUES
('Paris', 7, 1500.00),
('London', 5, 1200.00),
('New York', 10, 2000.00),
('Tokyo', 8, 1800.00),
('Sydney', 12, 2500.00),
('Rome', 6, 1400.00),
('Berlin', 4, 1100.00),
('Moscow', 9, 1600.00),
('Dubai', 7, 1700.00),
('Hong Kong', 5, 1300.00);