
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





--
-- 테이블의 덤프 데이터 `membert`
--

INSERT INTO `membert` (`member_id`, `token`, `nickname`, `gender`, `created_at`, `updated_at`) VALUES
('duksung1', 'token_duksung1', '덕성1', 'woman', '2019-03-03', '2019-04-01'),
('duksung2', 'token_duksung2', '덕성2', 'man', '2019-01-02', '2019-03-30'),
('duksung3', 'token_duksung3', '덕성3', 'all', '2018-12-25', '2019-04-01'),
('duksung4', 'token_duksung4', '덕성4', 'man', '2018-07-08', '2019-02-27'),
('duksung5', 'token_duksung5', '덕성5', 'woman', '2019-04-01', '2019-03-03');



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




--
-- 테이블의 덤프 데이터 `postt`
--

INSERT INTO `postt` (`post_id`, `member_id`, `post_created_at`, `post_updated_at`, `post_count`, `combi_id`, `temp_id`, `image_url`) VALUES
('p1', 'duksung1', '2019-05-26', '2019-05-28', 1, 'combi1', 'temp8', 'image_url_p1'),
('p2', 'duksung1', '2019-05-26', '2019-05-28', 2, 'combi2', 'temp8', 'image_url_p2'),
('p3', 'duksung2', '2019-05-26', '2019-05-28', 3, 'combi3', 'temp8', 'image_url_p3'),
('p4', 'duksung2', '2019-05-26', '2019-05-28', 4, 'combi4', 'temp8', 'image_url_p4'),
('p5', 'duksung3', '2019-05-26', '2019-05-28', 5, 'combi5', 'temp8', 'image_url_p5');



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