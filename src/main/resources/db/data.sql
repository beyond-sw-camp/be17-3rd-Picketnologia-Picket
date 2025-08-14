DROP DATABASE  IF EXISTS `pocket`;
CREATE DATABASE  IF NOT EXISTS `pocket` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `pocket`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 10.10.10.100    Database: web
-- ------------------------------------------------------
-- Server version	5.5.5-10.6.18-MariaDB-0ubuntu0.22.04.1-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `a`
--

-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: 192.168.220.100    Database: picket
-- ------------------------------------------------------
-- Server version	5.5.5-10.6.22-MariaDB-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
                           `idx` bigint(20) NOT NULL AUTO_INCREMENT,
                           `category` varchar(255) DEFAULT NULL,
                           `description` varchar(255) DEFAULT NULL,
                           `end_date` date DEFAULT NULL,
                           `name` varchar(255) DEFAULT NULL,
                           `price` int(11) DEFAULT NULL,
                           `rating` varchar(255) DEFAULT NULL,
                           `running_time` int(11) DEFAULT NULL,
                           `session_date` date DEFAULT NULL,
                           `session_time` int(11) DEFAULT NULL,
                           `start_date` date DEFAULT NULL,
                           `venue_address` varchar(255) DEFAULT NULL,
                           `venue_name` varchar(255) DEFAULT NULL,
                           `created_at` datetime(6) DEFAULT NULL,
                           `updated_at` datetime(6) DEFAULT NULL,
                           `user_id` bigint(20) DEFAULT NULL,
                           PRIMARY KEY (`idx`),
                           KEY `FK979liw4xk18ncpl87u4tygx2u` (`user_id`),
                           CONSTRAINT `FK979liw4xk18ncpl87u4tygx2u` FOREIGN KEY (`user_id`) REFERENCES `user` (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'뮤지컬','최고의 감동을 선사하는 클래식 공연입니다.','2025-08-31','공연01',120000,'전체연령가',120,'2025-08-16',19,'2025-08-01','서울 강남구 테헤란로 123','코엑스 오디토리움',NULL,NULL,NULL),(2,'콘서트','잊지 못할 추억을 만드는 밴드 콘서트입니다.','2025-08-31','공연02',90000,'15세 관람가',90,'2025-08-17',19,'2025-08-01','서울 서초구 남부순환로 2406','예술의전당 콘서트홀',NULL,NULL,NULL),(3,'콘서트','국내 최정상 아이돌 그룹의 화려한 무대!','2025-09-30','공연03',150000,'15세 관람가',150,'2025-09-13',19,'2025-09-01','서울 송파구 올림픽로 424','올림픽공원 체조경기장',NULL,NULL,NULL),(4,'뮤지컬','웅장한 스케일의 오페라를 만나보세요.','2025-09-30','공연04',100000,'12세 관람가',100,'2025-09-27',19,'2025-09-01','서울 종로구 세종대로 175','세종문화회관 대극장',NULL,NULL,NULL),(5,'콘서트','인디 밴드의 뜨거운 에너지를 느낄 수 있는 소극장 공연입니다.','2025-09-30','공연05',55000,'19세 이상 관람가',60,'2025-09-28',19,'2025-09-01','서울 마포구 어울마당로 65','홍대 상상마당 라이브홀',NULL,NULL,NULL),(6,'뮤지컬','국내외 유명 뮤지컬 배우들이 총출동하는 특별 공연입니다.','2025-09-30','공연06',110000,'12세 관람가',110,'2025-09-28',19,'2025-09-01','서울 용산구 이태원로 294','블루스퀘어 신한카드홀',NULL,NULL,NULL),(7,'전시','현대 예술 작품을 감상할 수 있는 감각적인 전시회입니다.','2025-10-31','공연07',20000,'전체연령가',30,'2025-10-04',18,'2025-10-01','서울 성동구 왕십리로 83-21','디뮤지엄',NULL,NULL,NULL),(8,'전시','새로운 시각으로 세상을 바라보는 특별 전시입니다.','2025-10-31','공연08',15000,'전체연령가',30,'2025-10-04',18,'2025-10-01','서울 종로구 삼청로 30','국립현대미술관 서울관',NULL,NULL,NULL),(9,'콘서트','세계적인 피아니스트의 리사이틀을 즐겨보세요.','2025-11-30','공연09',70000,'전체연령가',30,'2025-11-09',19,'2025-11-01','서울 송파구 올림픽로 300','롯데콘서트홀',NULL,NULL,NULL),(10,'콘서트','유명 아티스트들의 합동 무대가 펼쳐집니다.','2025-11-30','공연10',130000,'전체연령가',120,'2025-11-22',20,'2025-11-01','서울 송파구 올림픽로 25','잠실 실내체육관',NULL,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_image` (
                                 `idx` int(11) NOT NULL AUTO_INCREMENT,
                                 `file_name` varchar(255) DEFAULT NULL,
                                 `product_idx` bigint(20) DEFAULT NULL,
                                 PRIMARY KEY (`idx`),
                                 KEY `FKhqt1b9qmen7hstlpkeq7l4vbu` (`product_idx`),
                                 CONSTRAINT `FKhqt1b9qmen7hstlpkeq7l4vbu` FOREIGN KEY (`product_idx`) REFERENCES `product` (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
INSERT INTO `product_image` VALUES (1,'https://kangseol-s3.s3.amazonaws.com/2025/08/14/92670360-5051-4bb4-8fc0-7e490cf31324_1.jpg',1),(2,'https://kangseol-s3.s3.amazonaws.com/2025/08/14/72093682-6aef-4222-82fe-fa59b2b43e38_2.jpg',2),(3,'https://kangseol-s3.s3.amazonaws.com/2025/08/14/c60f5be2-e0f0-4c62-8fee-d98dae60b96c_3.jpg',3),(4,'https://kangseol-s3.s3.amazonaws.com/2025/08/14/80e85c61-022f-43c4-805a-1df203fa6c79_4.jpg',4),(5,'https://kangseol-s3.s3.amazonaws.com/2025/08/14/bdf0e34d-f300-490b-a4b1-4353b94514a9_5.jpg',5),(6,'https://kangseol-s3.s3.amazonaws.com/2025/08/14/f9f732b3-b4b5-4fba-938a-7469e2fb41d1_6.jpg',6),(7,'https://kangseol-s3.s3.amazonaws.com/2025/08/14/cd6ced44-06ca-40ee-aba9-ce64cfac7d2e_1.jpg',7),(8,'https://kangseol-s3.s3.amazonaws.com/2025/08/14/e1e89597-6464-4a16-8fa8-b75ca165f7ba_8.jpg',8),(9,'https://kangseol-s3.s3.amazonaws.com/2025/08/14/dbb29e65-7413-41ee-a305-41c72a49cece_9.jpg',9),(10,'https://kangseol-s3.s3.amazonaws.com/2025/08/14/6bea6a4d-01f0-45f3-9c18-6a114cc68fbf_10.jpg',10);
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qna`
--

DROP TABLE IF EXISTS `qna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qna` (
                       `idx` bigint(20) NOT NULL AUTO_INCREMENT,
                       `contents` varchar(255) DEFAULT NULL,
                       `created_at` datetime(6) DEFAULT NULL,
                       `is_private` bit(1) DEFAULT NULL,
                       `password` varchar(255) DEFAULT NULL,
                       `title` varchar(255) DEFAULT NULL,
                       `updated_at` datetime(6) DEFAULT NULL,
                       `product_id` bigint(20) DEFAULT NULL,
                       `user_id` bigint(20) DEFAULT NULL,
                       PRIMARY KEY (`idx`),
                       KEY `FK48n2j7932nshiq2j541jjv70e` (`product_id`),
                       KEY `FK22kn9bnirhpqdv8ibyyo28nkr` (`user_id`),
                       CONSTRAINT `FK22kn9bnirhpqdv8ibyyo28nkr` FOREIGN KEY (`user_id`) REFERENCES `user` (`idx`),
                       CONSTRAINT `FK48n2j7932nshiq2j541jjv70e` FOREIGN KEY (`product_id`) REFERENCES `product` (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qna`
--

LOCK TABLES `qna` WRITE;
/*!40000 ALTER TABLE `qna` DISABLE KEYS */;
INSERT INTO `qna` VALUES (1,'문의 내용01','2025-08-14 08:39:22.000000',_binary '','test1','문의01','2025-08-14 08:39:22.000000',1,1),(2,'문의 내용02','2025-08-14 08:39:22.000000',_binary '\0','test2','문의02','2025-08-14 08:39:22.000000',2,1),(3,'문의 내용03','2025-08-14 08:39:22.000000',_binary '\0','test3','문의03','2025-08-14 08:39:22.000000',3,1),(4,'문의 내용04','2025-08-14 08:39:22.000000',_binary '\0','test4','문의04','2025-08-14 08:39:22.000000',4,1),(5,'문의 내용05','2025-08-14 08:39:22.000000',_binary '','test5','문의05','2025-08-14 08:39:22.000000',5,1),(6,'문의 내용06','2025-08-14 08:39:22.000000',_binary '\0','test6','문의06','2025-08-14 08:39:22.000000',6,1),(7,'문의 내용07','2025-08-14 08:39:22.000000',_binary '','test7','문의07','2025-08-14 08:39:22.000000',7,1),(8,'문의 내용08','2025-08-14 08:39:22.000000',_binary '\0','test8','문의08','2025-08-14 08:39:22.000000',8,1),(9,'문의 내용09','2025-08-14 08:39:22.000000',_binary '\0','test9','문의09','2025-08-14 08:39:22.000000',9,1),(10,'문의 내용10','2025-08-14 08:39:22.000000',_binary '','test10','문의10','2025-08-14 08:39:22.000000',10,1);
/*!40000 ALTER TABLE `qna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
                          `idx` int(11) NOT NULL AUTO_INCREMENT,
                          `created_at` datetime(6) DEFAULT NULL,
                          `updated_at` datetime(6) DEFAULT NULL,
                          `comment` varchar(255) DEFAULT NULL,
                          `name` varchar(255) DEFAULT NULL,
                          `rating` int(11) DEFAULT NULL,
                          `product_id` bigint(20) DEFAULT NULL,
                          `user_id` bigint(20) DEFAULT NULL,
                          PRIMARY KEY (`idx`),
                          KEY `FKiyof1sindb9qiqr9o8npj8klt` (`product_id`),
                          KEY `FKiyf57dy48lyiftdrf7y87rnxi` (`user_id`),
                          CONSTRAINT `FKiyf57dy48lyiftdrf7y87rnxi` FOREIGN KEY (`user_id`) REFERENCES `user` (`idx`),
                          CONSTRAINT `FKiyof1sindb9qiqr9o8npj8klt` FOREIGN KEY (`product_id`) REFERENCES `product` (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'2025-08-14 08:32:55.000000','2025-08-14 08:32:55.000000','리뷰01',NULL,5,1,1),(2,'2025-08-14 08:32:55.000000','2025-08-14 08:32:55.000000','리뷰02',NULL,2,2,1),(3,'2025-08-14 08:32:55.000000','2025-08-14 08:32:55.000000','리뷰03',NULL,3,3,1),(4,'2025-08-14 08:32:55.000000','2025-08-14 08:32:55.000000','리뷰04',NULL,1,4,1),(5,'2025-08-14 08:32:55.000000','2025-08-14 08:32:55.000000','리뷰05',NULL,2,5,1),(6,'2025-08-14 08:32:55.000000','2025-08-14 08:32:55.000000','리뷰06',NULL,4,6,1),(7,'2025-08-14 08:32:55.000000','2025-08-14 08:32:55.000000','리뷰07',NULL,5,7,1),(8,'2025-08-14 08:32:55.000000','2025-08-14 08:32:55.000000','리뷰08',NULL,5,8,1),(9,'2025-08-14 08:32:55.000000','2025-08-14 08:32:55.000000','리뷰09',NULL,1,9,1),(10,'2025-08-14 08:32:55.000000','2025-08-14 08:32:55.000000','리뷰10',NULL,4,10,1);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller` (
                          `idx` bigint(20) NOT NULL AUTO_INCREMENT,
                          `business_address` varchar(255) DEFAULT NULL,
                          `business_number` varchar(255) DEFAULT NULL,
                          `representative_name` varchar(255) DEFAULT NULL,
                          `user_id` bigint(20) DEFAULT NULL,
                          PRIMARY KEY (`idx`),
                          UNIQUE KEY `UKetfpl3vymasxfqc4ri4r3euf6` (`user_id`),
                          CONSTRAINT `FK6rgw0e6tb24n93c27njlv0wcl` FOREIGN KEY (`user_id`) REFERENCES `user` (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
INSERT INTO `seller` VALUES (1,'서울시 동작구 신대방동','012-3456-789','test01',2);
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `idx` bigint(20) NOT NULL AUTO_INCREMENT,
                        `created_at` datetime(6) DEFAULT NULL,
                        `updated_at` datetime(6) DEFAULT NULL,
                        `birth` varchar(255) DEFAULT NULL,
                        `email` varchar(255) DEFAULT NULL,
                        `gender` enum('FEMALE','MALE') DEFAULT NULL,
                        `name` varchar(255) DEFAULT NULL,
                        `nickname` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `phone_number` varchar(255) DEFAULT NULL,
                        `user_type` enum('NORMAL','SELLER') DEFAULT NULL,
                        `user_role_id` int(11) DEFAULT NULL,
                        `user_status_id` int(11) DEFAULT NULL,
                        PRIMARY KEY (`idx`),
                        KEY `FKh2wc2dtfdo8maylne7mgubowq` (`user_role_id`),
                        KEY `FKo6g0t5ih8a5bsioca8qh5ukg3` (`user_status_id`),
                        CONSTRAINT `FKh2wc2dtfdo8maylne7mgubowq` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`idx`),
                        CONSTRAINT `FKo6g0t5ih8a5bsioca8qh5ukg3` FOREIGN KEY (`user_status_id`) REFERENCES `user_status` (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2025-08-14 08:32:12.000000','2025-08-14 08:32:12.000000','1999-03-10','test01@test.com','MALE','test','testman','qwer1234','010-1234-5678','NORMAL',2,1),(2,'2025-08-14 08:43:02.000000','2025-08-14 08:43:02.000000','1996-12-16','test02@test.com','MALE','seller','sellerman','qwer1234','010-1234-5678','SELLER',3,1),(3,'2025-08-14 08:43:04.000000','2025-08-14 08:43:04.000000','1999-03-10','test01@test.com','MALE','test','testman','qwer1234','010-1234-5678','NORMAL',2,1),(4,'2025-08-14 08:43:04.000000','2025-08-14 08:43:04.000000','1996-12-16','test02@test.com','MALE','seller','sellerman','qwer1234','010-1234-5678','SELLER',3,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
                             `idx` int(11) NOT NULL,
                             `name` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER'),(3,'ROLE_SELLER');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_status`
--

DROP TABLE IF EXISTS `user_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_status` (
                               `idx` int(11) NOT NULL,
                               `name` varchar(255) DEFAULT NULL,
                               PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_status`
--

LOCK TABLES `user_status` WRITE;
/*!40000 ALTER TABLE `user_status` DISABLE KEYS */;
INSERT INTO `user_status` VALUES (1,'ACTIVE'),(2,'SUSPEND'),(3,'DELETE');
/*!40000 ALTER TABLE `user_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-14 17:43:26
