
create database ootd;

grant all privileges on ootd.* to 'dbdyd'@'%';
grant all privileges on ootd.* to 'dbdyd'@'localhost';
flush privileges;

-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- 생성 시간: 19-05-06 05:44
-- 서버 버전: 10.1.38-MariaDB
-- PHP 버전: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `ootd`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `bottomclothest`
--

CREATE TABLE `bottomclothest` (
  `b_clothes_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `b_category` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 테이블의 덤프 데이터 `bottomclothest`
--

INSERT INTO `bottomclothest` (`b_clothes_id`, `b_category`) VALUES
('b_c1', 'cotton_trousers'),
('b_c2', 'jeans'),
('b_c3', 'sweat_pants'),
('b_c4', 'leggings_skirt'),
('b_c5', 'leggings'),
('b_c6', 'shortpants'),
('b_c7', 'shorts'),
('b_c8', 'miniskirt'),
('b_c9', 'longskirt');

-- --------------------------------------------------------

--
-- 테이블 구조 `combinationt`
--

CREATE TABLE `combinationt` (
  `combi_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `t_clothes_id` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `b_clothes_id` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `p_clothes_id` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `o_clothes_id` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 테이블의 덤프 데이터 `combinationt`
--

INSERT INTO `combinationt` (`combi_id`, `t_clothes_id`, `b_clothes_id`, `p_clothes_id`, `o_clothes_id`) VALUES
('combi1', 't_c1', 'b_c1', NULL, NULL),
('combi10', 't_c3', 'b_c1', NULL, NULL),
('combi11', 't_c3', 'b_c4', NULL, 'o_c7'),
('combi12', 't_c6', 'b_c2', NULL, 'o_c8'),
('combi13', 't_c3', 'b_c5', NULL, 'o_c3'),
('combi14', NULL, NULL, 'p_c2', 'o_c5'),
('combi15', 't_c3', 'b_c1', NULL, NULL),
('combi16', 't_c2', 'b_c3', NULL, NULL),
('combi17', 't_c5', 'b_c6', NULL, NULL),
('combi18', 't_c7', 'b_c7', NULL, NULL),
('combi19', 't_c3', 'b_c1', NULL, NULL),
('combi2', 't_c2', 'b_c4', NULL, NULL),
('combi20', NULL, NULL, 'p_c5', 'o_c6'),
('combi21', 't_c1', 'b_c1', NULL, NULL),
('combi3', 't_c6', 'b_c8', NULL, NULL),
('combi4', NULL, NULL, 'p_c3', 'o_c6'),
('combi5', 't_c1', 'b_c1', NULL, NULL),
('combi6', 't_c1', 'b_c1', NULL, NULL),
('combi7', 't_c4', 'b_c1', NULL, 'o_c2'),
('combi8', NULL, NULL, 'p_c3', NULL),
('combi9', 't_c8', 'b_c2', NULL, NULL);

-- --------------------------------------------------------

--
-- 테이블 구조 `membert`
--

CREATE TABLE `membert` (
  `member_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `token` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `nickname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 테이블의 덤프 데이터 `membert`
--

INSERT INTO `membert` (`member_id`, `token`, `nickname`, `gender`, `created_at`, `updated_at`) VALUES
('duksung1', 'token_duksung1', '덕성1', 'woman', '2019-03-03', '2019-04-01'),
('duksung2', 'token_duksung2', '덕성2', 'man', '2019-01-02', '2019-03-30'),
('duksung3', 'token_duksung3', '덕성3', 'all', '2018-12-25', '2019-04-01'),
('duksung4', 'token_duksung4', '덕성4', 'man', '2018-07-08', '2019-02-27'),
('duksung5', 'token_duksung5', '덕성5', 'woman', '2019-04-01', '2019-03-03');

-- --------------------------------------------------------

--
-- 테이블 구조 `outerclothest`
--

CREATE TABLE `outerclothest` (
  `o_clothes_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `o_category` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 테이블의 덤프 데이터 `outerclothest`
--

INSERT INTO `outerclothest` (`o_clothes_id`, `o_category`) VALUES
('o_c1', 'winter_coat'),
('o_c2', 'fall_coat'),
('o_c3', 'padded_jacket'),
('o_c4', 'long_padded_jacket'),
('o_c5', 'vest'),
('o_c6', 'jacket'),
('o_c7', 'cardigan'),
('o_c8', 'stadium_jumper'),
('o_c9', 'hood_zip_up');

-- --------------------------------------------------------

--
-- 테이블 구조 `pairclothest`
--

CREATE TABLE `pairclothest` (
  `p_clothes_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `p_category` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 테이블의 덤프 데이터 `pairclothest`
--

INSERT INTO `pairclothest` (`p_clothes_id`, `p_category`) VALUES
('p_c1', 'minidress'),
('p_c2', 'mididress'),
('p_c3', 'longdress'),
('p_c4', 'two_piece'),
('p_c5', 'jump_suit'),
('p_c6', 'suit');

-- --------------------------------------------------------

--
-- 테이블 구조 `postt`
--

CREATE TABLE `postt` (
  `post_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `member_id` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `post_created_at` date DEFAULT NULL,
  `post_updated_at` date DEFAULT NULL,
  `post_count` int(30) DEFAULT NULL,
  `combi_id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `temp_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `image_url` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 테이블의 덤프 데이터 `postt`
--

INSERT INTO `postt` (`post_id`, `member_id`, `post_created_at`, `post_updated_at`, `post_count`, `combi_id`, `temp_id`, `image_url`) VALUES
('p1', 'duksung1', '2019-05-26', '2019-05-28', 1, 'combi1', 'temp8', 'image_url_p1'),
('p2', 'duksung1', '2019-05-26', '2019-05-28', 2, 'combi2', 'temp8', 'image_url_p2'),
('p3', 'duksung2', '2019-05-26', '2019-05-28', 3, 'combi3', 'temp8', 'image_url_p3'),
('p4', 'duksung2', '2019-05-26', '2019-05-28', 4, 'combi4', 'temp8', 'image_url_p4'),
('p5', 'duksung3', '2019-05-26', '2019-05-28', 5, 'combi5', 'temp8', 'image_url_p5');

-- --------------------------------------------------------

--
-- 테이블 구조 `tempt`
--

CREATE TABLE `tempt` (
  `temp_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `min` int(30) NOT NULL,
  `max` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 테이블의 덤프 데이터 `tempt`
--

INSERT INTO `tempt` (`temp_id`, `min`, `max`) VALUES

('temp1', -20, -5),
('temp2', -5, 0),
('temp3', 0, 5),
('temp4', 6, 9),
('temp5', 10, 13),
('temp6', 14, 16),
('temp7', 17, 19),
('temp8', 20, 23),
('temp9', 24, 27),
('temp10', 28, 40);

-- --------------------------------------------------------

--
-- 테이블 구조 `topclothest`
--

CREATE TABLE `topclothest` (
  `t_clothes_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `t_category` varchar(35) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 테이블의 덤프 데이터 `topclothest`
--

INSERT INTO `topclothest` (`t_clothes_id`, `t_category`) VALUES
('t_c1', 'knitwear'),
('t_c2', 'hoodie'),
('t_c3', 'sweat_shirt'),
('t_c4', 'dress_shirt'),
('t_c5', 'short_sleeved_t_shirt'),
('t_c6', 'long_sleeved_t_shirt'),
('t_c7', 'blouse'),
('t_c8', 'sleeveless_shirt'),
('t_c9', 'off_shoulder');

--
-- 덤프된 테이블의 인덱스
--
--
-- 테이블의 인덱스 `tempt`
--
ALTER TABLE `tempt`
  ADD PRIMARY KEY (`temp_id`);

--
-- 테이블의 인덱스 `membert`
--
ALTER TABLE `membert`
  ADD PRIMARY KEY (`member_id`);

--
-- 테이블의 인덱스 `combinationt`
--
ALTER TABLE `combinationt`
  ADD PRIMARY KEY (`combi_id`);

--
-- 테이블의 인덱스 `postt`
--
ALTER TABLE `postt`
  ADD PRIMARY KEY (`post_id`);

--
-- 테이블의 인덱스 `topclothest`
--
ALTER TABLE `topclothest`
  ADD PRIMARY KEY (`t_clothes_id`);

--
-- 테이블의 인덱스 `bottomclothest`
--
ALTER TABLE `bottomclothest`
  ADD PRIMARY KEY (`b_clothes_id`);

--
-- 테이블의 인덱스 `bottomclothest`
--
ALTER TABLE `pairclothest`
  ADD PRIMARY KEY (`p_clothes_id`);

--
-- 테이블의 인덱스 `outerclothest`
--
ALTER TABLE `outerclothest`
  ADD PRIMARY KEY (`o_clothes_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;