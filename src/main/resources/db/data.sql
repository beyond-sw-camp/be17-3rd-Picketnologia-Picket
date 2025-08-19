INSERT INTO `user_role`(name)
values ('ROLE_ADMIN'),
       ('ROLE_USER'),
       ('ROLE_SELLER');

INSERT INTO `user_status`(name)
values ('ACTIVE'),
       ('SUSPEND'),
       ('DELETE');

--
-- Dumping data for table `user`
--

INSERT INTO `user`(created_at, updated_at, birth, email, gender, name, nickname, password, phone_number, user_type,
                   user_role_id, user_status_id)
VALUES (now(), now(), '1999-03-10', 'test01@test.com', 'MALE', 'test',
        'testman', 'qwer1234', '010-1234-5678', 'NORMAL', 2, 1),
       (now(), now(), '1996-12-16', 'test02@test.com', 'MALE',
        'seller', 'sellerman', 'qwer1234', '010-1234-5678', 'SELLER', 3, 1);

--
-- Dumping data for table `product`
--

INSERT INTO `product`(category, description, end_date, name, price, rating, running_time, session_date, session_time,
                      start_date, venue_address, venue_name, created_at, updated_at, user_id)
VALUES ('뮤지컬', '최고의 감동을 선사하는 클래식 공연입니다.', '2025-08-31', '공연01', 120000, '전체연령가', 120, '2025-08-16', 19, '2025-08-01',
        '서울 강남구 테헤란로 123', '코엑스 오디토리움', now(), now(), 1),
       ('콘서트', '잊지 못할 추억을 만드는 밴드 콘서트입니다.', '2025-08-31', '공연02', 90000, '15세 관람가', 90, '2025-08-17', 19,
        '2025-08-01', '서울 서초구 남부순환로 2406', '예술의전당 콘서트홀', now(), now(), 1),
       ('콘서트', '국내 최정상 아이돌 그룹의 화려한 무대!', '2025-09-30', '공연03', 150000, '15세 관람가', 150, '2025-09-13', 19,
        '2025-09-01', '서울 송파구 올림픽로 424', '올림픽공원 체조경기장', now(), now(), 1),
       ('뮤지컬', '웅장한 스케일의 오페라를 만나보세요.', '2025-09-30', '공연04', 100000, '12세 관람가', 100, '2025-09-27', 19, '2025-09-01',
        '서울 종로구 세종대로 175', '세종문화회관 대극장', now(), now(), 1),
       ('콘서트', '인디 밴드의 뜨거운 에너지를 느낄 수 있는 소극장 공연입니다.', '2025-09-30', '공연05', 55000, '19세 이상 관람가', 60, '2025-09-28', 19,
        '2025-09-01', '서울 마포구 어울마당로 65', '홍대 상상마당 라이브홀', now(), now(), 1),
       ('뮤지컬', '국내외 유명 뮤지컬 배우들이 총출동하는 특별 공연입니다.', '2025-09-30', '공연06', 110000, '12세 관람가', 110, '2025-09-28', 19,
        '2025-09-01', '서울 용산구 이태원로 294', '블루스퀘어 신한카드홀', now(), now(), 1),
       ('전시', '현대 예술 작품을 감상할 수 있는 감각적인 전시회입니다.', '2025-10-31', '공연07', 20000, '전체연령가', 30, '2025-10-04', 18,
        '2025-10-01', '서울 성동구 왕십리로 83-21', '디뮤지엄', now(), now(), 1),
       ('전시', '새로운 시각으로 세상을 바라보는 특별 전시입니다.', '2025-10-31', '공연08', 15000, '전체연령가', 30, '2025-10-04', 18,
        '2025-10-01', '서울 종로구 삼청로 30', '국립현대미술관 서울관', now(), now(), 1),
       ('콘서트', '세계적인 피아니스트의 리사이틀을 즐겨보세요.', '2025-11-30', '공연09', 70000, '전체연령가', 30, '2025-11-09', 19, '2025-11-01',
        '서울 송파구 올림픽로 300', '롯데콘서트홀', now(), now(), 1),
       ('콘서트', '유명 아티스트들의 합동 무대가 펼쳐집니다.', '2025-11-30', '공연10', 130000, '전체연령가', 120, '2025-11-22', 20,
        '2025-11-01', '서울 송파구 올림픽로 25', '잠실 실내체육관', now(), now(), 1);

--
-- Table structure for table `product_image`
--

--
-- Dumping data for table `product_image`
--

INSERT INTO `product_image`(file_name, product_idx)
VALUES ('https://kangseol-s3.s3.amazonaws.com/2025/08/14/92670360-5051-4bb4-8fc0-7e490cf31324_1.jpg', 1),
       ('https://kangseol-s3.s3.amazonaws.com/2025/08/14/72093682-6aef-4222-82fe-fa59b2b43e38_2.jpg', 2),
       ('https://kangseol-s3.s3.amazonaws.com/2025/08/14/c60f5be2-e0f0-4c62-8fee-d98dae60b96c_3.jpg', 3),
       ('https://kangseol-s3.s3.amazonaws.com/2025/08/14/80e85c61-022f-43c4-805a-1df203fa6c79_4.jpg', 4),
       ('https://kangseol-s3.s3.amazonaws.com/2025/08/14/bdf0e34d-f300-490b-a4b1-4353b94514a9_5.jpg', 5),
       ('https://kangseol-s3.s3.amazonaws.com/2025/08/14/f9f732b3-b4b5-4fba-938a-7469e2fb41d1_6.jpg', 6),
       ('https://kangseol-s3.s3.amazonaws.com/2025/08/14/cd6ced44-06ca-40ee-aba9-ce64cfac7d2e_1.jpg', 7),
       ('https://kangseol-s3.s3.amazonaws.com/2025/08/14/e1e89597-6464-4a16-8fa8-b75ca165f7ba_8.jpg', 8),
       ('https://kangseol-s3.s3.amazonaws.com/2025/08/14/dbb29e65-7413-41ee-a305-41c72a49cece_9.jpg', 9),
       ('https://kangseol-s3.s3.amazonaws.com/2025/08/14/6bea6a4d-01f0-45f3-9c18-6a114cc68fbf_10.jpg', 10);

--
-- Dumping data for table `qna`
--
INSERT INTO `qna` (contents, created_at, is_private,is_deleted, password, title, updated_at, product_id, user_id)
VALUES ('문의 내용01', now(), b'1',b'0' ,'test1', '문의01', now(), 1, 1),
       ('문의 내용02', now(), b'0',b'0' ,'test2', '문의02', now(), 2, 1),
       ('문의 내용03', now(), b'0', b'0','test3', '문의03', now(), 3, 1),
       ('문의 내용04', now(), b'0', b'0','test4', '문의04', now(), 4, 1),
       ('문의 내용05', now(), b'1', b'0','test5', '문의05', now(), 5, 1),
       ('문의 내용06', now(), b'0', b'0','test6', '문의06', now(), 6, 1),
       ('문의 내용07', now(), b'1', b'0','test7', '문의07', now(), 7, 1),
       ('문의 내용08', now(), b'0', b'0','test8', '문의08', now(), 8, 1),
       ('문의 내용09', now(), b'0', b'0','test9', '문의09', now(), 9, 1),
       ('문의 내용10', now(), b'1', b'0','test10', '문의10', now(), 10, 1);

--
-- Dumping data for table `review`
--

INSERT INTO `review`(created_at, updated_at, comment, name, rating, product_id, user_id)
VALUES (now(), now(), '리뷰01', NULL, 5, 1, 1),
       (now(), now(), '리뷰02', NULL, 2, 2, 1),
       (now(), now(), '리뷰03', NULL, 3, 3, 1),
       (now(), now(), '리뷰04', NULL, 1, 4, 1),
       (now(), now(), '리뷰05', NULL, 2, 5, 1),
       (now(), now(), '리뷰06', NULL, 4, 6, 1),
       (now(), now(), '리뷰07', NULL, 5, 7, 1),
       (now(), now(), '리뷰08', NULL, 5, 8, 1),
       (now(), now(), '리뷰09', NULL, 1, 9, 1),
       (now(), now(), '리뷰10', NULL, 4, 10, 1);

--
-- Dumping data for table `seller`
--

INSERT INTO `seller`(business_address, business_number, representative_name, user_id)
VALUES ('서울시 동작구 신대방동', '012-3456-789', 'test01', 2);

-- Dump completed on 2025-08-14 17:43:26
