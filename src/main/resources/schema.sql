

--
-- 데이터베이스: `ootd`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `bottomclothest`
--

CREATE TABLE `bottomclothest` (
  `b_clothes_id` varchar(30)  NOT NULL,
  `b_category` varchar(30)  NOT NULL
) ;


-- --------------------------------------------------------

--
-- 테이블 구조 `combinationt`
--

CREATE TABLE `combinationt` (
  `combi_id` varchar(30)  NOT NULL,
  `t_clothes_id` varchar(30)  DEFAULT NULL,
  `b_clothes_id` varchar(30)  DEFAULT NULL,
  `p_clothes_id` varchar(30)  DEFAULT NULL,
  `o_clothes_id` varchar(30)  DEFAULT NULL
) ;

-- --------------------------------------------------------

--
-- 테이블 구조 `membert`
--

CREATE TABLE `membert` (
  `member_id` varchar(30)  NOT NULL,
  `token` varchar(100)  NOT NULL,
  `nickname` varchar(30)  NOT NULL,
  `gender` varchar(30)  NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL
) ;

-- --------------------------------------------------------

--
-- 테이블 구조 `outerclothest`
--

CREATE TABLE `outerclothest` (
  `o_clothes_id` varchar(30)  NOT NULL,
  `o_category` varchar(30)  NOT NULL
) ;

-- --------------------------------------------------------

--
-- 테이블 구조 `pairclothest`
--

CREATE TABLE `pairclothest` (
  `p_clothes_id` varchar(30)  NOT NULL,
  `p_category` varchar(30)  NOT NULL
) ;

-- --------------------------------------------------------

--
-- 테이블 구조 `postt`
--

CREATE TABLE `postt` (
  `post_id` varchar(30)  NOT NULL,
  `member_id` varchar(30)  DEFAULT NULL,
  `post_created_at` date DEFAULT NULL,
  `post_updated_at` date DEFAULT NULL,
  `post_count` int(30) DEFAULT NULL,
  `combi_id` varchar(100)  NOT NULL,
  `temp_id` varchar(30)  NOT NULL,
  `image_url` varchar(500)  NOT NULL
) ;

-- --------------------------------------------------------

--
-- 테이블 구조 `tempt`
--

CREATE TABLE `tempt` (
  `temp_id` varchar(30)  NOT NULL,
  `min` int(30) NOT NULL,
  `max` int(30) NOT NULL
) ;

-- --------------------------------------------------------

--
-- 테이블 구조 `topclothest`
--

CREATE TABLE `topclothest` (
  `t_clothes_id` varchar(30)  NOT NULL,
  `t_category` varchar(35)  DEFAULT NULL
) ;


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
