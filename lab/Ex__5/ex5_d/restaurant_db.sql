-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2024 at 05:31 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurant_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `menuitems`
--

CREATE TABLE `menuitems` (
  `id` int(11) NOT NULL,
  `item_name` varchar(100) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menuitems`
--

INSERT INTO `menuitems` (`id`, `item_name`, `description`, `price`) VALUES
(1, 'Margherita Pizza', 'Classic cheese and tomato pizza.', 299.99),
(2, 'Chicken Biryani', 'Aromatic basmati rice with spiced chicken.', 199.99),
(3, 'Caesar Salad', 'Fresh lettuce with Caesar dressing and croutons.', 149.99),
(4, 'Chocolate Lava Cake', 'Molten chocolate center with a rich flavor.', 99.99),
(5, 'Cold Coffee', 'Iced coffee with a creamy texture.', 89.99);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `order_details` text DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `order_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `order_details`, `total_price`, `order_date`) VALUES
(21, 1, '1x Margherita Pizza, 1x Caesar Salad', 449.98, '2024-11-20 15:26:31'),
(22, 2, '2x Chicken Biryani, 1x Cold Coffee', 489.98, '2024-11-20 15:26:31'),
(23, 3, '1x Chicken Biryani, 1x Chocolate Lava Cake', 299.98, '2024-11-20 15:26:31'),
(24, 1, '1x Caesar Salad, 1x Cold Coffee', 239.98, '2024-11-20 15:26:31'),
(25, 19, '1x Margherita Pizza, 1x Cold Coffee', 389.98, '2024-11-20 15:26:31'),
(26, 23, '3x Chicken Biryani', 599.97, '2024-11-20 15:26:31'),
(27, 22, '2x Chocolate Lava Cake, 1x Cold Coffee', 289.98, '2024-11-20 15:26:31'),
(28, 21, '1x Caesar Salad, 1x Chocolate Lava Cake', 249.98, '2024-11-20 15:26:31'),
(29, 20, '1x Margherita Pizza, 1x Chicken Biryani', 499.98, '2024-11-20 15:26:31'),
(30, 19, '1x Cold Coffee, 1x Chocolate Lava Cake', 189.98, '2024-11-20 15:26:31'),
(31, 1, '1x Chicken Biryani', 800.00, '2024-11-20 16:20:30'),
(32, 29, '1x Margherita Pizza', 250.00, '2024-11-21 12:59:26'),
(33, 29, '1x Margherita Pizza', 250.00, '2024-11-21 12:59:30'),
(34, 29, '1x Margherita Pizza', 250.00, '2024-11-21 12:59:32'),
(35, 29, '1x Margherita Pizza', 250.00, '2024-11-21 12:59:33'),
(36, 29, '1x Butter Chicken', 300.00, '2024-11-21 13:03:10'),
(37, 29, '1x Butter Chicken', 300.00, '2024-11-21 13:03:12'),
(38, 29, '1x Butter Chicken', 300.00, '2024-11-21 13:03:13'),
(39, 29, '1x Butter Chicken', 300.00, '2024-11-21 13:03:13'),
(40, 29, '1x Butter Chicken', 300.00, '2024-11-21 13:03:14'),
(41, 29, '1x Margherita Pizza', 1200.00, '2024-11-21 13:13:31'),
(42, 29, '1x Margherita Pizza', 1200.00, '2024-11-21 13:13:32'),
(43, 29, '1x Margherita Pizza', 1200.00, '2024-11-21 13:13:33'),
(44, 29, '1x Margherita Pizza', 1200.00, '2024-11-21 13:13:35'),
(45, 29, '1x Veg Pulao', 550.00, '2024-11-21 13:14:41'),
(46, 1, '1x Prawn Masala', 950.00, '2024-11-21 13:20:33'),
(47, 1, '1x Chocolate Lava Cake', 450.00, '2024-11-21 13:23:21'),
(48, 1, '1x Prawn Masala', 950.00, '2024-11-21 14:51:46'),
(49, 1, '1x Chocolate Lava Cake', 450.00, '2024-11-23 16:29:14'),
(50, 1, '1x Margherita Pizza', 1200.00, '2024-11-23 16:29:21'),
(51, 1, '1x Margherita Pizza', 1200.00, '2024-11-25 16:18:54'),
(52, 1, '1x Margherita Pizza', 1200.00, '2024-11-25 16:20:07'),
(53, 1, '1x Margherita Pizza', 1200.00, '2024-11-25 16:22:17'),
(54, 1, '1x Margherita Pizza', 1200.00, '2024-11-25 16:28:14');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`) VALUES
(1, 'John Doe', 'john@example.com', 'password123'),
(2, 'Jane Smith', 'jane@example.com', 'securepassword'),
(3, 'Mike Brown', 'mike@example.com', 'mikepassword'),
(19, 'Alice Green', 'alice@example.com', 'alicepassword'),
(20, 'Bob White', 'bob@example.com', 'bobpassword'),
(21, 'Emma Black', 'emma@example.com', 'emmapassword'),
(22, 'Lucas Grey', 'lucas@example.com', 'lucaspassword'),
(23, 'Sophia Blue', 'sophia@example.com', 'sophiapassword'),
(24, 'Abinaya B', 'abinaya.26csa@licet.ac.in', '1234567'),
(26, 'sample1', 'sample1@gmail.com', '12345678'),
(27, 'sample2', 'sample2@gmail.com', '123'),
(28, 'sample3', 'sample3@gmail.com', '1234'),
(29, 'samplephp', 'samplephp@gmail.com', '$2y$10$McIn59gCAQGizADZc2RiV.3n4tOege8q2rRqlPrVgz8n5NTLSEOzu'),
(30, 'sd', 'hi@gmail.com', '$2y$10$pqRZo6jJVarbdb8W8vAf0uXiVjaByxOmLomfm78jNOLuGg6G1rQE6'),
(31, 'sampledb', 'sampledb@gmail.com', 'db'),
(32, 'samplephpdb', 'samplephpdb@gmail.com', '$2y$10$RABDADVig.gDVU3XcV7A0uu7QZJLiFHaZLB.0mDrryV5w.4fDkl5e');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menuitems`
--
ALTER TABLE `menuitems`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `menuitems`
--
ALTER TABLE `menuitems`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
