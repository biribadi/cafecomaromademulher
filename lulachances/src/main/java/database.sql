-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20-Dez-2016 às 03:48
-- Versão do servidor: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lulanches`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `ingridient_type`
--

CREATE TABLE `ingridient_type` (
  `id` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ingridient_type`
--

INSERT INTO `ingridient_type` (`id`, `type`) VALUES
(1, 'Bread'),
(2, 'Salad'),
(3, 'Sauce'),
(4, 'Spyce'),
(5, 'Cheese'),
(6, 'Filling');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ingridient_type`
--
ALTER TABLE `ingridient_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ingridient_type`
--
ALTER TABLE `ingridient_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

INSERT INTO `role`(`id`, `role`) VALUES (1,"ROLE_ADMIN");
INSERT INTO `role`(`id`, `role`) VALUES (2,"ROLE_USER");
INSERT INTO `user_snacks`(`id`, `email`, `password`) VALUES (1,'admin@lulanches.com','mundomagicodeoz');
INSERT INTO `user_snacks_roles`(`user_snacks_id`, `roles_id`) VALUES (1,1);
INSERT INTO `user_snacks`(`id`, `email`, `password`) VALUES (2,'user@lulanches.com','mundomagicodafantasia');
INSERT INTO `user_snacks_roles`(`user_snacks_id`, `roles_id`) VALUES (2,2);

INSERT INTO `description_item`(`id`, `word_en_us`, `word_pt_br`) VALUES (1,"Bread","Pão");
INSERT INTO `description_item`(`id`, `word_en_us`, `word_pt_br`) VALUES (2,"Cheese","Queijo");
INSERT INTO `description_item`(`id`, `word_en_us`, `word_pt_br`) VALUES (3,"Salad","Salada");
INSERT INTO `description_item`(`id`, `word_en_us`, `word_pt_br`) VALUES (4,"Sauce","Molho");
INSERT INTO `description_item`(`id`, `word_en_us`, `word_pt_br`) VALUES (5,"Spice","Tempero");
INSERT INTO `description_item`(`id`, `word_en_us`, `word_pt_br`) VALUES (6,"Filling","Recheio");

INSERT INTO `description_item`(`id`, `word_en_us`, `word_pt_br`) VALUES (7,"Arugula","Rucula");
INSERT INTO `description_item`(`id`, `word_en_us`, `word_pt_br`) VALUES (8,"Lettuce","Alface");
INSERT INTO `description_item`(`id`, `word_en_us`, `word_pt_br`) VALUES (9,"Tomato","Tomate");

INSERT INTO `ingridient_type` (`id`, `type_id`) VALUES ('1', '3');
INSERT INTO `ingridient` (`id`, `price`, `description_id`, `ingridient_type_id`) VALUES ('1', '0.99', '8', '1');