-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:3306
-- Время создания: Сен 03 2016 г., 14:10
-- Версия сервера: 5.5.50
-- Версия PHP: 5.4.45

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `trading_activity`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Broker`
--

CREATE TABLE IF NOT EXISTS `Broker` (
  `id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `login` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Broker`
--

INSERT INTO `Broker` (`id`, `name`, `login`, `password`) VALUES
(1, 'Vasia', 'vasilii', 'pupkin');

-- --------------------------------------------------------

--
-- Структура таблицы `Category`
--

CREATE TABLE IF NOT EXISTS `Category` (
  `id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Category`
--

INSERT INTO `Category` (`id`, `name`) VALUES
(1, 'hard'),
(2, 'soft');

-- --------------------------------------------------------

--
-- Структура таблицы `Sale`
--

CREATE TABLE IF NOT EXISTS `Sale` (
  `id` int(11) NOT NULL,
  `security_name` varchar(25) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `broker_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Sale`
--

INSERT INTO `Sale` (`id`, `security_name`, `quantity`, `price`, `broker_id`, `category_id`) VALUES
(1, 'MSFT', 1000, 5638, 1, 2),
(2, 'ORCL', 200, 4100, 1, 2),
(3, 'INTL', 500, 3526, 1, 1);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `Broker`
--
ALTER TABLE `Broker`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `Sale`
--
ALTER TABLE `Sale`
  ADD PRIMARY KEY (`id`),
  ADD KEY `broker_id` (`broker_id`),
  ADD KEY `category_id` (`category_id`) USING BTREE;

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `Broker`
--
ALTER TABLE `Broker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT для таблицы `Category`
--
ALTER TABLE `Category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `Sale`
--
ALTER TABLE `Sale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `Sale`
--
ALTER TABLE `Sale`
  ADD CONSTRAINT `sale_ibfk_1` FOREIGN KEY (`broker_id`) REFERENCES `Broker` (`id`),
  ADD CONSTRAINT `sale_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `Category` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
