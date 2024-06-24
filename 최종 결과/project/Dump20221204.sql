CREATE DATABASE  IF NOT EXISTS `project` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `project`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: project
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `가평관광지`
--

DROP TABLE IF EXISTS `가평관광지`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `가평관광지` (
  `이름` text,
  `위치` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `가평관광지`
--

LOCK TABLES `가평관광지` WRITE;
/*!40000 ALTER TABLE `가평관광지` DISABLE KEYS */;
INSERT INTO `가평관광지` VALUES ('가평 잣고을 전통시장','경기도 가평군'),('현등사(가평)','경기도 가평군'),('가평 자라섬테마파크','경기도 가평군'),('가평 연인산마을','경기도 가평군'),('가평사계절썰매장','경기도 가평군'),('가평5일장 / 잣고을전통시장 (5, 10일)','경기도 가평군'),('더 스테이호텔[한국관광 품질인증/Korea Quality]','경기도 가평군'),('취옹예술관[한국관광 품질인증/Korea Quality]','경기도 가평군'),('나인포레스트 이화원','경기도 가평군'),('남송미술관','경기도 가평군');
/*!40000 ALTER TABLE `가평관광지` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `가평모텔`
--

DROP TABLE IF EXISTS `가평모텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `가평모텔` (
  `장소` text,
  `대실` text,
  `숙박` text,
  `위치` text,
  `별점` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `가평모텔`
--

LOCK TABLES `가평모텔` WRITE;
/*!40000 ALTER TABLE `가평모텔` DISABLE KEYS */;
INSERT INTO `가평모텔` VALUES ('가평자라','35000원','90000원','경기가평군가평읍대곡리',9.5),('가평원스테이','30000원','60000원','경기가평군청평면고성리',9.2),('가평케이팝호텔','30000원','77000원','경기가평군가평읍하색리',9.4),('가평리버랜드','25000원','85000원','경기가평군설악면회곡리',8.7),('청평리오','0원','60000원','경기가평군청평면삼회리',9.1),('가평이틀','30000원','65000원','경기가평군청평면대성리',8.8),('가평연인산','30000원','50000원','경기가평군북면목동리',10),('가평파라다이스','25000원','60000원','경기가평군청평면삼회리',8.3),('가평돌고래수상리조트','180000원','99000원','경기가평군설악면회곡리',9.4),('청평강변','30000원','60000원','경기가평군청평면청평리',8.9);
/*!40000 ALTER TABLE `가평모텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `가평음식점`
--

DROP TABLE IF EXISTS `가평음식점`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `가평음식점` (
  `이름` text,
  `별점` text,
  `위치` text,
  `종류` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `가평음식점`
--

LOCK TABLES `가평음식점` WRITE;
/*!40000 ALTER TABLE `가평음식점` DISABLE KEYS */;
INSERT INTO `가평음식점` VALUES ('송원막국수','4.2점','가평군','칼국수/국수'),('산골농원','4.0점','가평군','닭볶음탕/닭갈비/닭발'),('언덕마루가평잣두부집','4.0점','가평군','두부/순두부'),('방일해장국본점','4.0점','가평군','해장국/국밥/육개장'),('불타는오리','4.0점','가평군','오리고기');
/*!40000 ALTER TABLE `가평음식점` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `가평축제`
--

DROP TABLE IF EXISTS `가평축제`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `가평축제` (
  `이름` text,
  `위치` text,
  `기간` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `가평축제`
--

LOCK TABLES `가평축제` WRITE;
/*!40000 ALTER TABLE `가평축제` DISABLE KEYS */;
/*!40000 ALTER TABLE `가평축제` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `가평펜션`
--

DROP TABLE IF EXISTS `가평펜션`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `가평펜션` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `가평펜션`
--

LOCK TABLES `가평펜션` WRITE;
/*!40000 ALTER TABLE `가평펜션` DISABLE KEYS */;
INSERT INTO `가평펜션` VALUES ('가평오버더마운틴','경기가평군상면행현리',9.7,'스텐다드B (마운틴뷰)3305호','0원','스텐다드B (마운틴뷰)3306호','0원','스텐다드B (마운틴뷰)3307호','0원','슈페리어(독채)V206호','0원','슈페리어(독채)V302호','0원','슈페리어(독채)V304호','0원','슈페리어(독채)V305호','0원','디럭스B(독채)V101호','0원','디럭스A(독채)V202호','0원','로열스위트B(독채)V301호','0원'),('청평1234스파펜션','쁘띠프랑스차량14분',9.8,'203호(제트스파)','0원','302호(제트스파)','0원','202호(제트스파)','0원','201호(제트스파)','0원','301호(제트스파)','0원','305호(제트스파)','0원','','','','','','','',''),('풀빌라가평BROOK5(브룩5)','자라섬차량13분',9.8,'STANDARD 103','0원','STANDARD 404','0원','STANDARD 203','0원','STANDARD 504','0원','STANDARD 204','0원','STANDARD 403','0원','STANDARD 104','0원','STANDARD 102','0원','POOLVILLA 501','0원','KIDS 402','432000원'),('풀빌라가평에비뉴알리에키즈풀빌라','자연휴양림차량7분',9.1,'포마(복층/제트스파)','0원','스쿨버스풀빌라(미온수수영장/정글짐)','0원','캔디(키즈정글짐/스파)','0원','푸우키즈풀빌라(미온수수영장/정글짐)','0원','플레이키즈풀빌라(미온수수영장/키즈정글짐)','259000원','','','','','','','','','',''),('풀빌라가평안젤로키즈풀빌라','남송미술관차량15분',9.9,'밸로','0원','루체','0원','안젤로','279000원','','','','','','','','','','','','','',''),('풀빌라가평까사벨라풀빌라','용추계곡차량27분',10,'102호','259000원','103호','259000원','','','','','','','','','','','','','','','',''),('가평숲속의정원펜션','경기가평군북면목동리',9.8,'로제','0원','보니르','0원','큐브 1','0원','아미띠에','120000원','키세스벨1','169000원','글램핑C','189000원','','','','','','','',''),('풀빌라가평어반힐스','경기가평군상면행현리',8.5,'스파1동(독채,스파)','0원','빌라202(실내수영장)','0원','키즈105(실내수영장,빔시어터)','0원','빌라302(실내수영장,스파)','210000원','키즈104(실내수영장,빔시어터)','270000원','','','','','','','','','',''),('풀빌라가평디오르풀빌라','경기가평군상면행현리',9.5,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('풀빌라가평프랜치캣','남이섬차량23분',8.9,'S-202호(복층,스파룸)','99000원','','','','','','','','','','','','','','','','','','');
/*!40000 ALTER TABLE `가평펜션` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `가평호텔`
--

DROP TABLE IF EXISTS `가평호텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `가평호텔` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `가평호텔`
--

LOCK TABLES `가평호텔` WRITE;
/*!40000 ALTER TABLE `가평호텔` DISABLE KEYS */;
INSERT INTO `가평호텔` VALUES ('★핫세일특가★마이다스호텔리조트','청평역차량10분',9.3,'[단독특가] 디럭스 트윈','259000원','[단독! 조식 2인] 디럭스 트윈','269000원','','','','','','','','','','','','','','','',''),('관광가평호텔스위티안','쁘띠프랑스차량3분',9.2,'[SNS 뷰맛집] 스탠다드 더블','407000원','[SNS 뷰맛집] 스탠다드 트윈','407000원','[리버뷰 욕조] 가든테라스 디자인 화이트','407000원','[리버뷰 욕조] 디자인 화이트','407000원','[리버뷰 욕조] 디자인 다크','407000원','[MD픽-2인 디너코스] 스탠다드 더블','500000원','[MD픽-2인 디너코스] 스탠다드 트윈','500000원','[MD픽-2인 디너코스] [리버뷰 욕조] 디자인 다크','500000원','[MD픽-2인 디너코스] [리버뷰 욕조] 디자인 ...','500000원','[MD픽-2인 디너코스] [리버뷰 욕조] 가든테라...','500000원'),('가평W지우리조트','남이섬차량2분',9.1,'[한정수량] 프리미어 풀스위트 (전망없음 / ...','159000원','[특가] 슈페리어 더블','279000원','[반짝특가] 슈페리어 더블','280000원','[특가 패키지] 체크인 시 배정 (전망 랜덤배정)','295000원','[보팅 2인 패키지] 슈페리어 더블','299000원','[조식 2인 패키지] 슈페리어 더블','300000원','[S컬렉션] 펜트 풀하우스','600000원','','','','','',''),('관광가평파로티아워터하우스','파로티아수상레저부근',7,'스탠다드 발코니','99000원','스탠다드 A','129000원','카바나 디럭스 트윈','159000원','스위트','299000원','패밀리 스위트','399000원','파로티아 스위트','499000원','','','','','','','',''),('켄싱턴리조트가평','경기가평군상면덕현리',7.6,'[조식 2인 패키지] 디럭스 룸 (25평)','0원','디럭스 룸 (25평)','260000원','프리미어 룸 (28평)','340000원','','','','','','','','','','','','','',''),('2성급청평가족호텔캐비어파크리조트','청평역차량6분',7.9,'스탠다드 더블','100000원','스탠다드 트윈','120000원','','','','','','','','','','','','','','','',''),('관광트라움호텔','대성리역차량2분',8.8,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','','');
/*!40000 ALTER TABLE `가평호텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `강릉관광지`
--

DROP TABLE IF EXISTS `강릉관광지`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `강릉관광지` (
  `이름` text,
  `위치` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `강릉관광지`
--

LOCK TABLES `강릉관광지` WRITE;
/*!40000 ALTER TABLE `강릉관광지` DISABLE KEYS */;
INSERT INTO `강릉관광지` VALUES ('강릉오죽한옥마을[한국관광 품질인증/Korea Quality]','강원도 강릉시'),('강릉 올림픽파크','강원도 강릉시'),('강릉커피거리','강원도 강릉시'),('강릉 월화거리','강원도 강릉시'),('강릉 중앙시장','강원도 강릉시'),('강릉향교','강원도 강릉시'),('강릉선교장[한국관광 품질인증/Korea Quality]','강원도 강릉시'),('강릉컬링센터 (강릉실내빙상장)','강원도 강릉시'),('강릉 솔향수목원','강원도 강릉시'),('강릉 모래내 한과마을(갈골한과)','강원도 강릉시');
/*!40000 ALTER TABLE `강릉관광지` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `강릉모텔`
--

DROP TABLE IF EXISTS `강릉모텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `강릉모텔` (
  `장소` text,
  `대실` text,
  `숙박` text,
  `위치` text,
  `별점` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `강릉모텔`
--

LOCK TABLES `강릉모텔` WRITE;
/*!40000 ALTER TABLE `강릉모텔` DISABLE KEYS */;
INSERT INTO `강릉모텔` VALUES ('경포대오션호텔','30000원','125000원','강원강릉시강문동',9.4),('경포대에이치에비뉴호텔','0원','140000원','강원강릉시강문동',9.2),('강릉피크닉','25000원','60000원','강원강릉시홍제동',9.4),('경포대호텔주노','40000원','160000원','강원강릉시강문동',9.4),('경포대WYNN-윈','0원','120000원','강원강릉시강문동',8.6),('HOTEL여기어때-경포','40000원','129000원','강원강릉시강문동',9.5),('경포대파라다이스','0원','70000원','강원강릉시강문동',9.3),('강릉루이스호텔','0원','90000원','강원강릉시옥천동',9.6),('경포대호텔큐브','40000원','130000원','강원강릉시강문동',8.7),('경포대브라운도트호텔','0원','220000원','강원강릉시강문동',9.6);
/*!40000 ALTER TABLE `강릉모텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `강릉음식점`
--

DROP TABLE IF EXISTS `강릉음식점`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `강릉음식점` (
  `이름` text,
  `별점` text,
  `위치` text,
  `종류` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `강릉음식점`
--

LOCK TABLES `강릉음식점` WRITE;
/*!40000 ALTER TABLE `강릉음식점` DISABLE KEYS */;
INSERT INTO `강릉음식점` VALUES ('해미가','4.2점','강릉시','회/횟집/참치'),('길손','4.2점','강릉시','낙지/문어/주꾸미'),('엄지네포장마차','4.2점','강릉시','포장마차'),('차현희순두부청국장','4.0점','강릉시','두부/순두부'),('한성먹거리','4.0점','강릉시','회/횟집/참치');
/*!40000 ALTER TABLE `강릉음식점` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `강릉축제`
--

DROP TABLE IF EXISTS `강릉축제`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `강릉축제` (
  `이름` text,
  `위치` text,
  `기간` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `강릉축제`
--

LOCK TABLES `강릉축제` WRITE;
/*!40000 ALTER TABLE `강릉축제` DISABLE KEYS */;
INSERT INTO `강릉축제` VALUES ('2023 강릉 세계합창대회','강원 강릉시','2023.07.03 ~ 2023.07.13'),('주문진 불꽃크루즈','강원 강릉시','2022.07.01 ~ 2022.12.31');
/*!40000 ALTER TABLE `강릉축제` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `강릉펜션`
--

DROP TABLE IF EXISTS `강릉펜션`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `강릉펜션` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `강릉펜션`
--

LOCK TABLES `강릉펜션` WRITE;
/*!40000 ALTER TABLE `강릉펜션` DISABLE KEYS */;
INSERT INTO `강릉펜션` VALUES ('강릉당신의안목펜션주문진점','주문진항차량4분',9.4,'그라스 401','0원','브리에 401','0원','','','','','','','','','','','','','','','',''),('강릉까르디에펜션','사천해수욕장차량2분',9.7,'A303(SPA)','0원','A301(SPA)','0원','A202(복층스파)','0원','A203(SPA)','189000원','A302(복층스파)','190000원','A402(SPA)','190000원','A401(SPA)','230000원','','','','','',''),('강릉더퍼스트펜션','강원강릉시사천면사천진리',9.8,'203호(스파/테라스)','0원','201호(오션뷰/스파)','0원','202호(오션뷰/스파)','0원','401호(오션뷰/테라스/복층)','0원','403호(하프오션뷰/스파/복층)','0원','301호(오션뷰/스파/테라스)','0원','','','','','','','',''),('경포오션힐펜션','강원강릉시안현동',9.8,'A201(복층,스파)','0원','A302(복층,스파)','0원','B205(복층,스파)','0원','A203(복층,스파)','0원','A204(복층,스파)','0원','A401(복층,스파)','0원','A304(복층,스파)','0원','A303(복층,스파)','0원','A402(복층,스파)','0원','A403(복층,스파)','0원'),('풀빌라강릉더강문풀빌라스파','경포호차량5분',10,'301호 풀빌라','0원','302호 풀빌라','0원','','','','','','','','','','','','','','','',''),('강릉쇼콜라펜션','강원강릉시사천면사천진리',9.8,'302호','0원','304호(개별테라스)','0원','303호','199000원','','','','','','','','','','','','','',''),('강릉KN하우스','경포해수욕장차량3분',9.8,'2호','0원','1호','0원','3호','0원','5호','0원','6호','0원','','','','','','','','','',''),('풀빌라강릉미술시간풀빌라스파','강원강릉시사천면방동리',9.2,'Junior suite T(스파오션뷰)','0원','Junior suite R(스파오션뷰)','0원','Mega suite(풀빌라+스파+오션뷰)','0원','Standard(오션뷰)','350000원','','','','','','','','','','','',''),('강릉지브스파','강원강릉시주문진읍주문리',10,'302 (오션뷰)','0원','303 (오션뷰)','0원','304 (오션뷰)','0원','301 (오션뷰)','0원','305 (오션뷰)','0원','401(오션뷰)','0원','402(스파,오션뷰)','0원','404(스파,오션뷰)','0원','503(스파,오션뷰)','0원','501(스파,오션뷰)','0원'),('풀빌라류풀빌라펜션','강원강릉시옥계면금진리',9.9,'Superior 302','0원','VVIP Poolvilla 401 (복층형)','0원','Special 202','270000원','Superior 301','290000원','VVIP Poolvilla 403 (복층형)','330000원','VVIP Poolvilla 402 (복층형)','340000원','','','','','','','','');
/*!40000 ALTER TABLE `강릉펜션` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `강릉호텔`
--

DROP TABLE IF EXISTS `강릉호텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `강릉호텔` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `강릉호텔`
--

LOCK TABLES `강릉호텔` WRITE;
/*!40000 ALTER TABLE `강릉호텔` DISABLE KEYS */;
INSERT INTO `강릉호텔` VALUES ('특급세인트존스호텔','강문해변앞',8.9,'슈페리어 트윈 (마운틴뷰 / Room Only)','297000원','슈페리어 헐리우드 (마운틴뷰 / Room Only)','297000원','슈페리어 더블 (마운틴뷰 / Room Only)','297000원','골져스 파셜오션 더블','341000원','골져스 파셜오션 트윈','341000원','골져스 플러스 킹 마운틴뷰','341000원','슈페리어 패밀리 트윈 (마운틴뷰 / Room Only)','341000원','슈페리어 패밀리 온돌 (빌딩뷰 / Room Only)','341000원','펫 더블 (포레스트뷰/Room Only)','374000원','골져스 파셜오션 패밀리트윈','374000원'),('특급★당일특가★스카이베이호텔경포','강문해변차량2분',9,'디럭스 더블 (레이크뷰 / 2인조식포함)','0원','이그제큐티브 더블 (오션뷰)','0원','이그제큐티브 트윈 (오션뷰)','0원','이그제큐티브 트윈 (오션뷰 / 2인조식포함)','0원','디럭스 트윈 (소나무or호수 전망 / 2~3층)','308000원','[18시 늦은 체크인] 디럭스 트윈 (소나무or호...','308000원','디럭스 더블 (소나무 or 호수 전망/ 저층)','400000원','디럭스 더블 (레이크뷰)','400000원','','','',''),('특1급정동진썬크루즈호텔','정동진역차량5분',8.9,'콘도형 디럭스 트윈 (공원뷰)','0원','(비치크루즈) 테라스트윈 저층형 (11층, 수영...','341000원','(비치 크루즈) 프라이빗 인피니티 풀빌라A','605000원','(비치 크루즈) 프라이빗 인피니티 풀빌라B','605000원','','','','','','','','','','','',''),('가족호텔★핫세일특가★파인아트라벨','강릉송정해변',9.4,'패밀리 트윈 오션뷰','0원','[혼자만의 여행] 스탠다드 더블룸 전망없음','109000원','[단독특가] 스탠다드 더블룸 전망없음','110000원','[단독! 특가] 스탠다드 더블룸 하프오션뷰','135000원','[단독특가] 디럭스 더블룸 오션뷰','152000원','스탠다드 더블룸 하프오션뷰','169000원','트리플 벙커룸 하프오션뷰','189000원','디럭스 더블룸 오션뷰','209000원','디럭스 트윈룸 오션뷰','209000원','[멍이냥이룸] 트리플 벙커룸 하프오션뷰','209000원'),('4성급★파격특가★호텔탑스텐','안목커피거리도보5분',9.2,'디럭스 패밀리 트윈 (전망 없음)','440000원','','','','','','','','','','','','','','','','','',''),('비지니스올림피아호텔','정동진해변차량13분',8.9,'스탠다드 더블','99000원','스탠다드 트윈','99000원','슈페리어 트윈','110000원','디럭스 트윈','120000원','스위트','250000원','','','','','','','','','',''),('비지니스경포대더호텔비즈니스','강릉역차량3분',9.5,'디럭스 퀸 (원룸)','99000원','가족룸 (거실1+침실)','149000원','','','','','','','','','','','','','','','',''),('특급SL호텔강릉','강원강릉시안현동',9,'디럭스 더블 시티뷰','160000원','디럭스 트윈 시티뷰','170000원','[2인 조식 패키지] 디럭스 더블 시티뷰','177000원','[무료뷰UP] 디럭스 트윈 시티뷰 → 디럭스 트...','182000원','[무료뷰UP] 디럭스 더블 시티뷰 → 디럭스 더...','182000원','[일출 패키지] 디럭스 더블 오션뷰','192000원','[2인 조식 패키지] 디럭스 트윈 시티뷰','195000원','디럭스 더블 오션뷰','209000원','디럭스 트윈 오션뷰','209000원','[로맨틱 윈터 패키지] 디럭스 더블 오션뷰','220000원'),('라카이샌드파인','주문진터미널차량4분',9.2,'[조식 2인 패키지] 스튜디오 (가든뷰/더블)','0원','[조식 2인 패키지] 듀오 (오션뷰 or 가든뷰 ...','0원','스튜디오 (비전망/트윈)','210000원','스튜디오 (가든뷰/패밀리트윈)','240000원','[조식 2인 패키지] 스튜디오 (비전망/트윈)','260000원','[조식 2인 패키지] 스튜디오 (가든뷰/패밀리...','290000원','스튜디오 (가든뷰/더블)','360000원','스튜디오 (호수뷰/패밀리트윈)','360000원','스튜디오 스위트 (오션뷰 or 가든뷰 선착순배정)','448000원','듀오 (오션뷰 or 가든뷰 선착순배정)','680000원'),('비지니스강릉씨티호텔','경포해변도보5분',9.4,'스탠다드 트윈','0원','[단독-2인 조식포함] 스탠다드 더블','0원','[단독-2인 조식포함] 디럭스 더블','0원','디럭스 트윈','175473원','디럭스 온돌','175473원','[단독-3인 조식포함] 디럭스 트윈','221000원','[S컬렉션] 프리미어 더블','224000원','[S컬렉션] 프리미어 발코니 더블','224000원','스탠다드 더블','300000원','디럭스 더블','350000원');
/*!40000 ALTER TABLE `강릉호텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `광주관광지`
--

DROP TABLE IF EXISTS `광주관광지`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `광주관광지` (
  `이름` text,
  `위치` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `광주관광지`
--

LOCK TABLES `광주관광지` WRITE;
/*!40000 ALTER TABLE `광주관광지` DISABLE KEYS */;
INSERT INTO `광주관광지` VALUES ('남광주시장(남광주밤기차야시장)','광주 동구'),('광주 예술의 거리','광주 동구'),('광주 역사민속박물관','광주 북구'),('광주호 호수생태원','광주 북구'),('무등산국립공원','광주 동구'),('광주 대인시장 (대인예술시장)','광주 동구'),('광주 조선백자 요지','경기도 광주시'),('전일빌딩245','광주 동구'),('기박산성 의병 역사공원','광주 북구'),('사직공원(광주)','광주 남구');
/*!40000 ALTER TABLE `광주관광지` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `광주모텔`
--

DROP TABLE IF EXISTS `광주모텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `광주모텔` (
  `장소` text,
  `대실` text,
  `숙박` text,
  `위치` text,
  `별점` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `광주모텔`
--

LOCK TABLES `광주모텔` WRITE;
/*!40000 ALTER TABLE `광주모텔` DISABLE KEYS */;
INSERT INTO `광주모텔` VALUES ('광주G','20000원','60000원','광주북구신안동',9.6),('신안동여기서자자','20000원','75000원','광주북구신안동',9.7),('뉴충장로브라운도트충장로점','20000원','80000원','광주동구호남동',9.6),('충장로첫번째부띠끄호텔','19000원','78000원','광주동구학동',9.5),('첨단YAJAHOTEL','20000원','80000원','광주북구오룡동',9.8),('광주호텔더테라스','20000원','100000원','광주광산구우산동',9.3),('광주브라운도트첨단점','25000원','90000원','광주광산구쌍암동',9.7),('상무지구M','15000원','60000원','광주서구치평동',9.5),('첨단벤틀리페라리호텔','30000원','80000원','광주광산구쌍암동',9.6),('하남HOTELSTAY35','20000원','70000원','광주광산구우산동',10);
/*!40000 ALTER TABLE `광주모텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `광주음식점`
--

DROP TABLE IF EXISTS `광주음식점`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `광주음식점` (
  `이름` text,
  `별점` text,
  `위치` text,
  `종류` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `광주음식점`
--

LOCK TABLES `광주음식점` WRITE;
/*!40000 ALTER TABLE `광주음식점` DISABLE KEYS */;
INSERT INTO `광주음식점` VALUES ('송정떡갈비1호점','4.0점','광산구/송정/수완/첨단','소구이/불고기'),('연화식당','4.8점','서구-상무/화정','전/빈대떡'),('RONNIQUE','4.4점','동구-충장/금남/동명','프렌치'),('미미원','4.4점','동구-충장/금남/동명','한정식'),('대광식당','4.3점','서구-상무/화정','전/빈대떡');
/*!40000 ALTER TABLE `광주음식점` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `광주축제`
--

DROP TABLE IF EXISTS `광주축제`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `광주축제` (
  `이름` text,
  `위치` text,
  `기간` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `광주축제`
--

LOCK TABLES `광주축제` WRITE;
/*!40000 ALTER TABLE `광주축제` DISABLE KEYS */;
/*!40000 ALTER TABLE `광주축제` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `광주펜션`
--

DROP TABLE IF EXISTS `광주펜션`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `광주펜션` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `광주펜션`
--

LOCK TABLES `광주펜션` WRITE;
/*!40000 ALTER TABLE `광주펜션` DISABLE KEYS */;
INSERT INTO `광주펜션` VALUES ('경기더케이플러스펜션','곤지암리조트차량3분',9.6,'C301','0원','A201','0원','C202','100000원','C203','100000원','D101','120000원','D102','120000원','D103','120000원','D301','120000원','D302','120000원','D303','120000원'),('풀빌라K401독채펜션','곤지암리조트차량5분',9.4,'STAY 2','300000원','STAY 1','400000원','','','','','','','','','','','','','','','',''),('퇴촌푸른솔펜션','경기광주시퇴촌면원당리',10,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('곤지암통나무펜션','장심리계곡도보1분',9.9,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('퇴촌뜰에산에펜션','천진암계곡차량3분',10,'포도','120000원','레몬','120000원','오렌지','250000원','토마토','250000원','','','','','','','','','','','',''),('알파인펜션','곤지암리조트차량3분',10,'101호','200000원','201호','200000원','','','','','','','','','','','','','','','',''),('경기곤지암반딧불펜션','곤지암리조트차량1분',9.1,'핑크','120000원','옐로우','120000원','와인','120000원','룸_B','200000원','룸_A','200000원','룸_E','200000원','룸_C','200000원','룸_D','200000원','','','',''),('경기라르고펜션','곤지암리조트차량2분',9.5,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('경기샵테라스펜션','곤지암리조트차량3분',9.5,'블루','240000원','카키','240000원','그린','240000원','스카이','300000원','','','','','','','','','','','',''),('광주산아래펜션','천진암계곡차량4분',10,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','','');
/*!40000 ALTER TABLE `광주펜션` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `광주호텔`
--

DROP TABLE IF EXISTS `광주호텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `광주호텔` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `광주호텔`
--

LOCK TABLES `광주호텔` WRITE;
/*!40000 ALTER TABLE `광주호텔` DISABLE KEYS */;
INSERT INTO `광주호텔` VALUES ('4성급유탑부티크호텔레지던스','상무역차량4분',9.4,'[장기투숙-30박] 디럭스 레지던스 더블','66000원','디럭스 레지던스 더블','69000원','디럭스 부티크 더블','79000원','[에그에그 패키지] 디럭스 레지던스 더블','99000원','[맥주엔 먹태지! 패키지] 디럭스 레지던스 더블','109000원','[맥주엔 꼬치지! 패키지] 디럭스 레지던스 더블','109000원','[붉은악마 패키지] 디럭스 레지던스 더블','119000원','[커플 패키지] 디럭스 레지던스 더블','119000원','[스시벤또 패키지] 디럭스 레지던스 더블','120000원','디럭스 부티크 트리플','132000원'),('비지니스광주호텔B','5.18기념공원부근',9,'체크인 시 배정 (룸온리)','73000원','스탠다드 더블','83000원','디럭스 더블','103000원','디럭스 트윈','103000원','프리미엄 더블','113000원','디럭스 트윈 (킹+싱글)','124000원','프리미엄 트윈','135000원','패밀리 스위트','280000원','','','',''),('곤지암리조트','곤지암터미널차량12분',9.7,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('비지니스탑클라우드호텔광주','광주광산구쌍암동',9.4,'[룸 업그레이드] 코너 스위트→듀플렉스','0원','디럭스','70000원','코너 스위트','76000원','[룸 업그레이드] 코너 스위트→주니어 스위트','76000원','미들 스위트','79000원','주니어 스위트','85000원','패밀리 스위트 트윈','94000원','[30시간 스테이 패키지] 디럭스','95000원','주니어 스위트 듀플렉스','99000원','코너 스위트 듀플렉스','99000원'),('3성급광주CS관광호텔','상무역근처',9.5,'[2인 조식 포함] 스탠다드 패밀리 트윈','80000원','[2인 조식 포함] 스탠다드 더블','80000원','[2인 조식 포함] 디럭스 패밀리 트윈','90000원','[2인 조식 포함] 디럭스 더블','90000원','[2인 조식 포함] 럭셔리 더블','120000원','[2인 조식 포함] 럭셔리 패밀리 트윈','130000원','[2인 조식 포함] 럭셔리 싱글 트윈','130000원','[2인 조식 포함] 프리미엄 패밀리 트윈','160000원','[2인 조식 포함] 프리미엄 온돌','160000원','',''),('비지니스광주어반라이프호텔','광주기아챔피언스필드5.3km',9.6,'[1인 특가] 스탠다드','60000원','[2인 조식&도보특가] 스탠다드','60000원','스탠다드 (조식 2인)','65000원','트윈 BED (2인 조식)','70000원','[1인 특가] 프리미엄','70000원','[2인 조식&도보특가] 프리미엄','70000원','프리미엄 (조식 2인)','75000원','스위트 (2인 조식)','85000원','','','',''),('비지니스호텔더힐','유스퀘어광주터미널도보5분',9.8,'스탠다드 더블','55000원','클래식 더블','60000원','디럭스 더블','65000원','프리미엄 더블','70000원','패밀리 트윈','70000원','','','','','','','','','',''),('비지니스광주벤틀리호텔상무점','돌고개역차량7분',8.8,'비즈니스','60000원','디럭스','70000원','프리미엄','80000원','디럭스 트윈','80000원','프리미엄 트윈','110000원','','','','','','','','','',''),('비지니스광주워싱턴호텔','상무역도보7분',8.9,'[조식 미포함] 디럭스 A','55000원','[조식 미포함] 슈페리어','88000원','[조식 미포함] 슈페리어 트윈','100000원','[조식 미포함] 스위트','130000원','','','','','','','','','','','',''),('비지니스에이치원호텔','문화전당역도보7분',9.5,'디럭스 킹룸','104000원','패밀리 트윈룸','130000원','','','','','','','','','','','','','','','','');
/*!40000 ALTER TABLE `광주호텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대구관광지`
--

DROP TABLE IF EXISTS `대구관광지`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대구관광지` (
  `이름` text,
  `위치` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대구관광지`
--

LOCK TABLES `대구관광지` WRITE;
/*!40000 ALTER TABLE `대구관광지` DISABLE KEYS */;
INSERT INTO `대구관광지` VALUES ('대구 근대골목(근대로의 여행)','대구 중구'),('대새목장','대구 달성군'),('국립대구박물관','대구 수성구'),('대구 달성공원','대구 중구'),('대구앞산공원','대구 남구'),('대구 서문시장 & 서문시장 야시장','대구 중구'),('표충재 전통체험관[한국관광 품질인증/Korea Quality]','대구 동구'),('대구 계산동성당','대구 중구'),('대구수목원','대구 달서구'),('동산청라언덕','대구 중구');
/*!40000 ALTER TABLE `대구관광지` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대구모텔`
--

DROP TABLE IF EXISTS `대구모텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대구모텔` (
  `장소` text,
  `대실` text,
  `숙박` text,
  `위치` text,
  `별점` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대구모텔`
--

LOCK TABLES `대구모텔` WRITE;
/*!40000 ALTER TABLE `대구모텔` DISABLE KEYS */;
INSERT INTO `대구모텔` VALUES ('동대구역스테이앤플레이호텔','20000원','100000원','대구동구신천동',9.4),('동성로헤븐스토리','20000원','75000원','대구중구북성로1가',9.2),('동대구역H호텔','20000원','100000원','대구동구신천동',9.1),('평리호텔하이엔드','20000원','60000원','대구서구평리동',9.7),('대구더스테이낭만','25000원','85000원','대구달서구호산동',9.6),('대구브라운도트-성당못점','20000원','95000원','대구남구대명동',9.5),('대구더스테이낭만-태전점','20000원','85000원','대구북구태전동',9.8),('동대구역호텔포레스트701','22000원','130000원','대구동구신천동',9.7),('서부정류장앤-Anne','21000원','88000원','대구남구대명동',9.2),('평리낭만스테이호텔','20000원','85000원','대구서구평리동',9.5);
/*!40000 ALTER TABLE `대구모텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대구음식점`
--

DROP TABLE IF EXISTS `대구음식점`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대구음식점` (
  `이름` text,
  `별점` text,
  `위치` text,
  `종류` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대구음식점`
--

LOCK TABLES `대구음식점` WRITE;
/*!40000 ALTER TABLE `대구음식점` DISABLE KEYS */;
INSERT INTO `대구음식점` VALUES ('삼송빵집본점','3.9점','중구/동성로/중앙로/종로','베이커리/제과점'),('왕거미식당','3.8점','중구/동성로/중앙로/종로','소구이/불고기'),('옛집식당','4.4점','중구/동성로/중앙로/종로','해장국/국밥/육개장'),('신송자신마산식당','4.3점','남구/봉덕/대명','해장국/국밥/육개장'),('태산만두','4.3점','중구/동성로/중앙로/종로','만두/만두전골');
/*!40000 ALTER TABLE `대구음식점` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대구축제`
--

DROP TABLE IF EXISTS `대구축제`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대구축제` (
  `이름` text,
  `위치` text,
  `기간` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대구축제`
--

LOCK TABLES `대구축제` WRITE;
/*!40000 ALTER TABLE `대구축제` DISABLE KEYS */;
INSERT INTO `대구축제` VALUES ('2022 경북사과홍보행사','대구 수성구','2022.11.25 ~ 2022.11.27');
/*!40000 ALTER TABLE `대구축제` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대구펜션`
--

DROP TABLE IF EXISTS `대구펜션`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대구펜션` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대구펜션`
--

LOCK TABLES `대구펜션` WRITE;
/*!40000 ALTER TABLE `대구펜션` DISABLE KEYS */;
INSERT INTO `대구펜션` VALUES ('대구애플호텔펜션','대구동화사차량3분',9.5,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('강진더베이펜션','가우도차량11분',8.4,'S2','80000원','카라반','80000원','M1','100000원','M2','100000원','M3','100000원','F1(4월~9월스파가능)','150000원','','','','','','','',''),('군위솔향기펜션','파계사차량28분',9.2,'본관 202호','0원','본관 203호','90000원','본관 201호','90000원','별관 201호','110000원','본관 102호','110000원','본관 103호','150000원','별관 101호','180000원','','','','','',''),('강진바다목장','마량항차량5분',9,'102호','100000원','301호','120000원','101호','160000원','','','','','','','','','','','','','',''),('군위대구펜션','경북군위군부계면남산리',0,'202','120000원','303','120000원','302','120000원','201','120000원','203','120000원','301','120000원','101','120000원','','','','','','');
/*!40000 ALTER TABLE `대구펜션` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대구호텔`
--

DROP TABLE IF EXISTS `대구호텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대구호텔` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대구호텔`
--

LOCK TABLES `대구호텔` WRITE;
/*!40000 ALTER TABLE `대구호텔` DISABLE KEYS */;
INSERT INTO `대구호텔` VALUES ('3성급대구JB관광호텔','안심역차량9분',9.5,'스탠다드 (조식포함 / 일요일 숙박고객 조식 ...','60000원','디럭스 (조식포함 / 일요일 숙박고객 조식 미...','70000원','프리미엄 (조식포함 / 일요일 숙박고객 조식 ...','80000원','프리미엄 더블+싱글 (조식포함/일요일숙박고...','100000원','한옥 일반실 온돌 (조식포함 / 일요일숙박 조...','120000원','스위트 더블+싱글 (조식포함/일요일숙박고객 ...','120000원','한옥 일반실 침대 (조식포함 / 일요일숙박 조...','120000원','스위트 더블+더블 (조식포함/일요일 투숙 조...','120000원','','','',''),('비지니스호텔피에드수성','고산역차량1분',9.8,'스탠다드','90000원','슈페리어 트윈','120000원','디럭스','120000원','이그제큐티브','140000원','시그니처 프리미엄','160000원','스위트 패밀리','290000원','','','','','','','',''),('2성급아마레호텔','용계역차량8분',9.2,'스탠다드','60000원','디럭스 (안마의자)','70000원','디럭스 (안마베드)','70000원','스페셜 (안마의자)','80000원','프리미엄 (히노끼룸)','90000원','이벤트룸 (노래방)','140000원','이벤트룸 (수영장)','140000원','','','','','',''),('5성급대구메리어트호텔','동대구역도보7분',9.7,'디럭스 더블','231000원','디럭스 킹','231000원','[2인 조식 패키지] 디럭스 킹','286000원','[2인 조식 패키지] 디럭스 더블','286000원','[웰니스 2인 패키지] 디럭스 더블','308000원','[웰니스 2인 패키지] 디럭스 킹','308000원','[단독! 풀패키지 호캉스] 디럭스 킹','385000원','[단독! 풀패키지 호캉스] 디럭스 더블','385000원','[S컬렉션] 이그제큐티브 스위트','407000원','',''),('비지니스ACT관광호텔','대구스타디움차량3분',9.5,'[1인 비즈니스 패키지] 수페리어 더블','80000원','[룸온리 패키지] 수페리어 더블','100000원','[룸온리 패키지] 수페리어 트윈','109000원','[룸온리 패키지] 프리미어 더블','109000원','[룸온리 패키지] 프리미어 패밀리','119000원','[룸온리 패키지] 이그제큐티브 더블','129000원','','','','','','','',''),('비지니스대구2월호텔더시그니처동성로점','중앙로역도보1분',9.2,'시그니처 디럭스 테라스룸','0원','시그니처 디럭스','129000원','시그니처 디럭스 노하드2pc룸','149000원','시그니처 스위트 더블','168000원','시그니처 스위트 테라스','204000원','시그니처 스위트 투베드','252000원','시그니처 프리미엄 스위트 투베드','252000원','시그니처 루프탑 풀빌라 카라반 주니어 스위트','360000원','시그니처 로얄 풀 카바나 스위트','384000원','시그니처 루프탑 풀빌라 카라반 스위트','412000원'),('4성급엘디스리젠트호텔','반월당역7분',8.8,'스탠다드 더블 (본관)','129412원','스탠다드 트윈','141177원','디럭스 더블 W (신관)','164706원','디럭스 더블 E (신관)','176471원','디럭스 트윈','188236원','','','','','','','','','',''),('비지니스호텔여기어때서대구점','반고개역차량7분',9.2,'스탠다드','65000원','디럭스','75000원','디럭스 트윈','85000원','프리미엄','85000원','스위트','95000원','프리미엄 (배틀그라운드&스파)','95000원','스위트(노래방)','125000원','','','','','',''),('가족호텔호텔수성','지산역차량4분',9.5,'[1인 조식포함+2인 인피니티풀 무제한이용] ...','236900원','[1인 조식포함+2인 인피니티풀 무제한이용] ...','282900원','','','','','','','','','','','','','','','',''),('2성급엘리시아호텔','진천역차량7분',9.2,'스탠다드','90000원','디럭스','100000원','VIP 트윈','130000원','스위트 트윈','150000원','로얄 트윈','170000원','','','','','','','','','','');
/*!40000 ALTER TABLE `대구호텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대전관광지`
--

DROP TABLE IF EXISTS `대전관광지`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대전관광지` (
  `이름` text,
  `위치` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대전관광지`
--

LOCK TABLES `대전관광지` WRITE;
/*!40000 ALTER TABLE `대전관광지` DISABLE KEYS */;
INSERT INTO `대전관광지` VALUES ('대전시립박물관','대전 유성구'),('대전엑스포과학공원','대전 유성구'),('국립대전현충원 보훈둘레길','대전 유성구'),('계족산 황톳길','대전 대덕구'),('대전 중앙시장','대전 동구'),('대전역 가락국수','대전 동구'),('이응노 미술관','대전 서구'),('스카이로드','대전 중구'),('대전 계족산성','대전 대덕구'),('솔로몬로파크','대전 유성구');
/*!40000 ALTER TABLE `대전관광지` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대전모텔`
--

DROP TABLE IF EXISTS `대전모텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대전모텔` (
  `장소` text,
  `대실` text,
  `숙박` text,
  `위치` text,
  `별점` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대전모텔`
--

LOCK TABLES `대전모텔` WRITE;
/*!40000 ALTER TABLE `대전모텔` DISABLE KEYS */;
INSERT INTO `대전모텔` VALUES ('유성메이호텔','20000원','95000원','대전유성구봉명동',9.3),('대전벨레자호텔','20000원','70000원','대전동구용전동',9.5),('대전베스트인시티호텔','20000원','90000원','대전중구대흥동',9.6),('문창호텔루이스','20000원','100000원','대전중구문창동',9.4),('용전더휴식아늑호텔-2호점','30000원','120000원','대전동구용전동',9.8),('유성호텔드메르','30000원','100000원','대전유성구봉명동',9.6),('대흥콩','20000원','95000원','대전중구대흥동',9.8),('중리만월호텔','20000원','80000원','대전대덕구중리동',9.5),('유성K7PC텔','20000원','95000원','대전유성구봉명동',9.3),('유성더휴식아늑호텔-2호점','30000원','140000원','대전유성구봉명동',9.8);
/*!40000 ALTER TABLE `대전모텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대전음식점`
--

DROP TABLE IF EXISTS `대전음식점`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대전음식점` (
  `이름` text,
  `별점` text,
  `위치` text,
  `종류` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대전음식점`
--

LOCK TABLES `대전음식점` WRITE;
/*!40000 ALTER TABLE `대전음식점` DISABLE KEYS */;
INSERT INTO `대전음식점` VALUES ('대전2층전문제과(성심당)','4.2점','동구/대전역','베이커리/제과점'),('오씨칼국수','3.7점','동구/대전역','칼국수/국수'),('원조황소집','4.4점','대덕구/오정동/신탄진','소구이/불고기'),('이태리국시','4.4점','서구-둔산/탄방','이탈리안'),('부여순대','4.3점','동구/대전역','순댓국/순대');
/*!40000 ALTER TABLE `대전음식점` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대전축제`
--

DROP TABLE IF EXISTS `대전축제`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대전축제` (
  `이름` text,
  `위치` text,
  `기간` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대전축제`
--

LOCK TABLES `대전축제` WRITE;
/*!40000 ALTER TABLE `대전축제` DISABLE KEYS */;
/*!40000 ALTER TABLE `대전축제` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대전펜션`
--

DROP TABLE IF EXISTS `대전펜션`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대전펜션` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대전펜션`
--

LOCK TABLES `대전펜션` WRITE;
/*!40000 ALTER TABLE `대전펜션` DISABLE KEYS */;
INSERT INTO `대전펜션` VALUES ('풀빌라청도굿스파키즈풀빌라','자계서원차량18분',9.4,'B105(개별온천수수영장/키즈놀이터)','0원','B106(개별온천수수영장/키즈놀이터)','0원','B102(개별온천수수영장/키즈놀이터)','0원','B103(개별온천수수영장/키즈놀이터)','0원','A304(개별온천수수영장/키즈놀이터)','0원','B205(개별온천수수영장/키즈놀이터)','199000원','B206(개별온천수수영장/키즈놀이터)','199000원','A305(개별온천수수영장/키즈놀이터)','249000원','','','',''),('대전시에스타펜션','대전서구산직동',9.9,'202','120000원','101','120000원','102','120000원','201','120000원','','','','','','','','','','','',''),('대전장태산민가가든','장태산휴양림차량5분',10,'201호','0원','102호','120000원','202호','130000원','본채1층','150000원','101호','180000원','본채2층','200000원','별채','200000원','','','','','',''),('대전풀내음쉼터펜션','형제산차량12분',9.3,'채송화','100000원','달맞이','180000원','민들레','180000원','코스모스(3층)','300000원','백일홍','350000원','','','','','','','','','',''),('대전알프스캠핑펜션','장태산휴양림차량6분',8.1,'난초(독채)','80000원','국화(독채)','140000원','연산홍','140000원','개나리','140000원','진달래','160000원','머루','160000원','매화','160000원','다래','160000원','소나무','160000원','수련','160000원'),('대전장태산루체','장태산휴양림차량2분',8.3,'본관105','0원','본관 104','80000원','본관 102','250000원','별관 101','250000원','본관 101','250000원','본관 세미나','250000원','','','','','','','',''),('논산대둔산수락호수펜션(구산초의집)','수락계곡도보11분',10,'행복','90000원','기쁨','180000원','사랑','180000원','','','','','','','','','','','','','',''),('대전장태산의아침','자연휴양림도보18분',10,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('포항자연의소리펜션','화진해수욕장차량7분',8.1,'소리방101호','100000원','소리방102호','100000원','소리방103호','200000원','자연방101호','200000원','자연방102호','200000원','자연소리방','350000원','','','','','','','','');
/*!40000 ALTER TABLE `대전펜션` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대전호텔`
--

DROP TABLE IF EXISTS `대전호텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대전호텔` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대전호텔`
--

LOCK TABLES `대전호텔` WRITE;
/*!40000 ALTER TABLE `대전호텔` DISABLE KEYS */;
INSERT INTO `대전호텔` VALUES ('2성급토요코인대전','정부청사역도보10분',9.3,'싱글 (흡연)','58000원','싱글 (금연)','58000원','비즈니스 싱글 (흡연/1인 투숙)','63000원','레지던스 싱글 (1인 투숙)','77000원','트윈','88000원','레지던스 더블','88000원','스위트 더블','132000원','스위트 트윈','154000원','','','',''),('레지던스라미아호텔','정부청사역차량3분',8.6,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('4성급롯데시티호텔대전','대전컨벤션센터앞',9.6,'[숙박불가(당일퇴실)-8시간휴캉스] 체크인 시...','96250원','[연말 미리예약특가-성심당 상품권] 헐리우드...','129250원','체크인 시 배정','130625원','[레이트버드 특가! 18시 체크인(연박불가)] ...','133375원','[레이트버드 특가! 18시 체크인(연박불가)] ...','133375원','[레이트버드 특가! 18시 체크인(연박불가)] ...','133375원','스탠다드 더블','137500원','스탠다드 트윈','137500원','헐리우드 더블','137500원','[장기투숙-14박 이상] 스탠다드 더블','137500원'),('레지던스대전레지던스호텔라인','정부청사역차량3분',9.5,'스탠다드 더블','45000원','스탠다드 트윈','58000원','디럭스 패밀리 A','68000원','','','','','','','','','','','','','',''),('레지던스크리스탈레지던스호텔','한복거리차량2분',9,'스탠다드','50000원','디럭스','60000원','한실','80000원','디럭스 더블','80000원','','','','','','','','','','','',''),('비지니스대전나무호텔','유성온천역도보10분',8.7,'스탠다드 더블','55000원','스탠다드 트윈','65000원','','','','','','','','','','','','','','','',''),('비지니스라마다바이윈덤대전','유성온천역도보3분',9.5,'스탠다드 트윈','91765원','헐리우드 킹','91765원','부티크 더블','91765원','[2인조식 패키지] 부티크 더블','135765원','[2인조식 패키지] 헐리우드 킹','135765원','','','','','','','','','',''),('비지니스호텔스카이파크대전1호점','현대프리미엄아울렛대전도보1분',9.5,'[24시간이 모자라] 스탠다드 퀸','0원','스탠다드 퀸','79000원','스탠다드 트윈','79000원','[한미르 대덕 CC 골프 패키지] 스탠다드 퀸','99000원','디럭스 트윈','129000원','코너 디럭스 트윈','149000원','패밀리룸','169000원','','','','','',''),('1급스탕달호텔','유성온천역도보9분',9.4,'슈페리어 더블 (모든요일 투숙시 조식 무료)','113000원','레지던스 슈페리어 더블 (모든요일 투숙시 조...','113000원','디럭스 더블 (모든요일 투숙시 조식 무료)','146000원','슈페리어 트윈 (모든요일 투숙시 조식 무료)','155000원','프레지덴셜 스위트 펜트하우스 (모든요일 투...','690000원','','','','','','','','','',''),('5성급호텔오노마대전오토그래프컬렉션','정부청사역차량7분',9.6,'프리미어 코너','0원','디럭스 더블','242000원','디럭스 트윈','242000원','[가을 연휴 특별 혜택] 디럭스 트윈','242100원','','','','','','','','','','','','');
/*!40000 ALTER TABLE `대전호텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `부산관광지`
--

DROP TABLE IF EXISTS `부산관광지`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `부산관광지` (
  `이름` text,
  `위치` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `부산관광지`
--

LOCK TABLES `부산관광지` WRITE;
/*!40000 ALTER TABLE `부산관광지` DISABLE KEYS */;
INSERT INTO `부산관광지` VALUES ('현대 모터스튜디오 부산','부산 수영구'),('부산다이아몬드타워','부산 중구'),('부산 송도해수욕장','부산 서구'),('부산대교','부산 영도구'),('부산세관박물관','부산 중구'),('부산 자갈치시장','부산 중구'),('부산박물관','부산 남구'),('용두산 자갈치 관광특구','부산 중구'),('갤러리 ERD 부산','부산 해운대구'),('신세계사이먼 부산 프리미엄 아울렛','부산 기장군');
/*!40000 ALTER TABLE `부산관광지` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `부산모텔`
--

DROP TABLE IF EXISTS `부산모텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `부산모텔` (
  `장소` text,
  `대실` text,
  `숙박` text,
  `위치` text,
  `별점` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `부산모텔`
--

LOCK TABLES `부산모텔` WRITE;
/*!40000 ALTER TABLE `부산모텔` DISABLE KEYS */;
INSERT INTO `부산모텔` VALUES ('광안리씨유','40000원','110000원','부산수영구광안동',8.8),('만덕덴바스타포레스트','40000원','120000원','부산북구만덕동',9.7),('범일덴바스타프리미엄','40000원','89500원','부산동구범일동',9.9),('사직덴바스타시그니처호텔','25000원','85000원','부산동래구온천동',9.9),('해운대호텔아크블루','25000원','109000원','부산해운대구우동',9.5),('해운대호텔V','20000원','130000원','부산해운대구우동',9.4),('서면호텔25H더파크','25000원','100000원','부산부산진구부전동',9.9),('서면HOTEL치즈','20000원','90000원','부산부산진구부전동',9.7),('동래덴바스타','25000원','100000원','부산동래구명륜동',9.9),('영도그랜드베른호텔','0원','160000원','부산영도구청학동',9.8);
/*!40000 ALTER TABLE `부산모텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `부산음식점`
--

DROP TABLE IF EXISTS `부산음식점`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `부산음식점` (
  `이름` text,
  `별점` text,
  `위치` text,
  `종류` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `부산음식점`
--

LOCK TABLES `부산음식점` WRITE;
/*!40000 ALTER TABLE `부산음식점` DISABLE KEYS */;
INSERT INTO `부산음식점` VALUES ('해운대암소갈비집','3.9점','해운대','소구이/불고기'),('스시연','4.7점','해운대','일식'),('원조할매집','4.6점','동구/부산역/초량','낙지/문어/주꾸미'),('마산곱창','4.5점','부산진구/서면','곱창/대창'),('괘법쭈꾸미전문점','4.5점','사상구/덕포','낙지/문어/주꾸미');
/*!40000 ALTER TABLE `부산음식점` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `부산축제`
--

DROP TABLE IF EXISTS `부산축제`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `부산축제` (
  `이름` text,
  `위치` text,
  `기간` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `부산축제`
--

LOCK TABLES `부산축제` WRITE;
/*!40000 ALTER TABLE `부산축제` DISABLE KEYS */;
INSERT INTO `부산축제` VALUES ('부산국제광고제','부산 해운대구','2022.01.01 ~ 2022.12.31');
/*!40000 ALTER TABLE `부산축제` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `부산펜션`
--

DROP TABLE IF EXISTS `부산펜션`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `부산펜션` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `부산펜션`
--

LOCK TABLES `부산펜션` WRITE;
/*!40000 ALTER TABLE `부산펜션` DISABLE KEYS */;
INSERT INTO `부산펜션` VALUES ('해운대송정오셔너스','송정해수욕장도보1분',9.2,'온돌룸','0원','온돌룸','0원','오션디럭스','0원','오션디럭스','0원','오션디럭스','0원','오션스파(랜덤배정)','0원','파티룸','0원','온돌룸','49000원','오션디럭스','79000원','오션디럭스','79000원'),('풀빌라부산타이드어웨이풀빌라','송정해수욕장도보6분',9.6,'205 Ocean Deluxe (수영장없음)','0원','204 Ocean Deluxe (수영장없음)','0원','104 Infiniti Deluxe (수영장있음)','0원','401 Ocean Suite (수영장있음)','0원','102 Infiniti Deluxe (수영장있음)','450000원','301 Ocean Terrace Suite (수영장있음)','600000원','402 Ocean Suite (수영장있음)','600000원','','','','','',''),('풀빌라해운대마린케이풀빌라펜션','해월정사차량8분',9.2,'202_디럭스','0원','301_노천버블스파','0원','302_노천버블스파','0원','401_복층,노천버블스파','0원','402_복층,노천버블스파','0원','801_복층,풀빌라','0원','201_디럭스','120000원','','','','','',''),('풀빌라부산그레이샌즈풀빌라','부산해운대구송정동',7.2,'디럭스풀빌라301','0원','스위트풀빌라502','159000원','스위트풀빌라402','159000원','','','','','','','','','','','','','',''),('풀빌라해운대송정스카이풀빌라','송정해수욕장차량3분',9.9,'502 spa Villa(침대1,화장실1,거실)','0원','B03 부티크Spa Villa(오픈원룸,침대1,거실,화...','0원','B04 부티크Spa Villa(오픈원룸,침대1,거실,화...','0원','B06 부티크Spa Villa(오픈원룸,침대2,거실,화...','0원','','','','','','','','','','','',''),('1872팡시온펜션','일광해수욕장차량3분',8.8,'C201','110000원','B202','120000원','C202','140000원','B301 (복층 / BBQ 불가)','150000원','A101','240000원','A201','240000원','C301','240000원','','','','','',''),('하루하우스','해동용궁사차량20분',10,'[오션뷰-거실분리형원룸]A301호-BBQ옥상테라...','110000원','[거실분리형원룸]A202호-BBQ옥상테라스이용','110000원','[오션뷰-복층형]A402호-방1개(킹침대)욕실','140000원','[오션뷰-복층형]A401호-방1개(킹침대)욕실','140000원','[투룸복층형]A201호-방2개(킹침대2)욕실3개','230000원','[오션뷰-투룸복층형]A203호-방2개(킹침대2)욕...','260000원','[쓰리룸복층형]B302호-방3개(침대-퀸3)욕실3개','320000원','[쓰리룸복층형]B301호-방3개(침대-퀸3,싱글2)...','350000원','','','',''),('송정스테이서몽','송정해수욕장차량2분',9.6,'type 바람 302호','0원','','','','','','','','','','','','','','','','','',''),('기장비치하임펜션','부산롯데월드차량15분',9.2,'A303호','110000원','B201호','130000원','B202호','130000원','A202호','150000원','B101호','450000원','','','','','','','','','',''),('풀빌라부산본레브연화리330풀빌라','부산기장군기장읍연화리',9.4,'스탠다드405','0원','디럭스304','60000원','디럭스303','60000원','스탠다드404','120000원','스탠다드501','120000원','스탠다드503','120000원','스탠다드502','120000원','스탠다드504','120000원','스탠다드505','120000원','스탠다드401','120000원');
/*!40000 ALTER TABLE `부산펜션` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `부산호텔`
--

DROP TABLE IF EXISTS `부산호텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `부산호텔` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `부산호텔`
--

LOCK TABLES `부산호텔` WRITE;
/*!40000 ALTER TABLE `부산호텔` DISABLE KEYS */;
INSERT INTO `부산호텔` VALUES ('비지니스라마다앙코르바이윈덤부산해운대','해운대역도보1분',9.2,'슈페리어 더블','70000원','디럭스 트윈','80000원','패밀리 트윈','100000원','[2인 조식 패키지] 슈페리어 더블','110000원','[2인 조식 패키지] 디럭스 트윈','120000원','[2인 조식 패키지] 패밀리 트윈','140000원','코너 스위트 더블','180000원','코너 스위트 트윈','180000원','[2인 조식 패키지] 코너 스위트 더블','220000원','[2인 조식 패키지] 코너 스위트 트윈','220000원'),('3성급호텔아쿠아펠리스','광안리해수욕장앞',8.1,'한국식 패밀리온돌-전망없음','90000원','디럭스 더블 (전망 없음/리모델링)','90000원','디럭스 트윈 (전망 없음/리모델링)','90000원','오션+시티 체크인 시 배정 (더블or트윈)','100000원','[조식 2인] 디럭스 더블 (전망 없음/리모델링)','105000원','[조식 2인] 디럭스 트윈 (전망 없음/리모델링)','105000원','[객찜 패키지] 디럭스 → 오션시티 트윈','130000원','','','','','',''),('비지니스반짝특가광수호텔','해운대해수욕장도보4분',9.2,'[단독특가] 슈페리얼 더블','39000원','[도보특가-주차불가] 슈페리얼 더블','115000원','슈페리얼 더블','120000원','[룸 업그레이드] 슈페리어 → 디럭스 더블 시티','120000원','[도보특가-주차불가] 디럭스 더블 시티','135000원','[도보특가-주차불가] 디럭스 트윈 시티','135000원','디럭스 더블 시티','140000원','디럭스 트윈 시티','140000원','[고백 패키지] 슈페리얼 더블','140000원','디럭스 더블 하프 오션','160000원'),('1급광안리그레이193호텔','광안리해변도보1분',9.3,'[반나절 호캉스-숙박불가] 체크인 시 배정 (...','65000원','오션 디럭스 (오션뷰)','110000원','[와인PKG] 오션 디럭스 (오션뷰)','130000원','하이오션 디럭스 (오션뷰)','140000원','오션 트윈 (오션뷰)','160000원','','','','','','','','','',''),('3성급호텔일루아','해운대도보5분',9.1,'스탠다드 트윈','100000원','스탠다드 온돌','100000원','디럭스 더블','130000원','디럭스 트윈','130000원','디럭스 더블 테라스','170000원','슈퍼 디럭스 트윈','170000원','디럭스 온돌 테라스','210000원','디럭스 패밀리 트윈','210000원','스파 디럭스 테라스','250000원','로얄 스위트','300000원'),('비지니스반짝특가신라스테이서부산','하단역차량16분',9.6,'[반나절 호캉스-숙박불가] 스탠다드 체크인시...','46200원','[반나절 호캉스-숙박불가] 스탠다드 체크인시...','77000원','[단독특가!룸UP+미니바포함+13시퇴실] 스탠다...','94900원','스탠다드 더블룸','114400원','스탠다드 트윈룸','114400원','[1인 조식 특가] 스탠다드 더블룸','114400원','[룸UP] 스탠다드 → 디럭스 더블룸','114400원','[룸UP] 스탠다드 → 디럭스 트윈룸','114400원','[무료 룸UP&신라스테이 베어 패키지] 스탠다...','114400원','[무료 룸UP&신라스테이 베어 패키지] 스탠다...','114400원'),('2성급오션더포인트호텔','부산수영구민락동',9.1,'[반나절 호캉스-숙박불가] [7시간 이용권] 시...','60000원','디럭스 하프오션 (넷플릭스)','75000원','[광안리 핫딜] 슈페리어 시티 트윈(넷플릭스)','85000원','[롱스테이30H] 시티뷰 배정 (넷플릭스)','105000원','[광안리 핫딜] 오션 스위트 조식패키지(넷플...','130000원','[오션랜덤] 오션뷰 랜덤 객실 배정','130000원','펫 룸 시티','135000원','슈페리어 오션 트윈 조식패키지(넷플릭스)','150000원','이그제큐티브 오션 스위트 조식패키지(넷플릭스)','170000원','펫 룸 오션','170000원'),('3성급베스트루이스해밀턴호텔해운대','해운대도보5분',9.4,'[반나절 호캉스-숙박불가] 체크인 시 배정 (...','36000원','비즈니스 더블','45000원','[레이트버드-20시 체크인] 슈페리어 더블','45000원','[일찍 일어나면 특가-09시 체크아웃] 슈페리...','45000원','슈페리어 더블','50000원','[주차불가-12시 늦은 퇴실] 슈페리어 더블','50000원','[친환경 패키지] 슈페리어 더블','50000원','[비즈니스 패키지] 슈페리어 더블','60000원','[레이트버드-20시 체크인] 디럭스 더블','60000원','[조식 2인 패키지] 비즈니스 더블','64000원'),('1급부산지앤비호텔','자갈치역도보10분',9.4,'스탠다드 더블','65000원','스탠다드 트윈','65000원','디럭스 더블','75000원','스위트 더블','85000원','디럭스 트윈','95000원','패밀리 트윈','105000원','패밀리 트리플','135000원','주니어 스위트','135000원','프리미엄 스위트','215000원','',''),('2성급광안리하운드호텔','광안리해변앞',9.3,'스탠다드 더블 (전망없음)','60000원','체크인 시 배정 (하프오션뷰/트윈)','80000원','디럭스 더블 (전망없음)','90000원','디럭스 트윈 (전망없음)','95000원','패밀리 트윈 (전망없음)','100000원','슈페리어 더블 (전망없음) - Type A','100000원','슈페리어 더블 (전망없음) - Type B','110000원','스탠다드 더블 (오션뷰)','120000원','체크인 시 배정 (오션뷰)','120000원','디럭스 트윈 (오션뷰)','140000원');
/*!40000 ALTER TABLE `부산호텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `서울관광지`
--

DROP TABLE IF EXISTS `서울관광지`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `서울관광지` (
  `이름` text,
  `위치` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `서울관광지`
--

LOCK TABLES `서울관광지` WRITE;
/*!40000 ALTER TABLE `서울관광지` DISABLE KEYS */;
INSERT INTO `서울관광지` VALUES ('서울낙산스테이 [한국관광 품질인증/Korea Quality]','서울 성북구'),('서울천년타임캡슐광장','서울 중구'),('남산서울타워','서울 용산구'),('서울 약령시장','서울 동대문구'),('서울로 7017','서울 중구'),('롯데월드타워 서울스카이','서울 송파구'),('서울시립미술관(서소문본관)','서울 중구'),('인왕사(서울)','서울 종로구'),('경희궁','서울 종로구'),('정스패밀리 [한국관광 품질인증/Korea Quality]','서울 용산구');
/*!40000 ALTER TABLE `서울관광지` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `서울모텔`
--

DROP TABLE IF EXISTS `서울모텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `서울모텔` (
  `장소` text,
  `대실` text,
  `숙박` text,
  `위치` text,
  `별점` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `서울모텔`
--

LOCK TABLES `서울모텔` WRITE;
/*!40000 ALTER TABLE `서울모텔` DISABLE KEYS */;
INSERT INTO `서울모텔` VALUES ('명동밀리오레호텔','35000원','140000원','서울중구충무로1가',9),('종로K-World','35000원','120000원','서울종로구관수동',9.7),('종로호텔더포스트','35000원','140000원','서울종로구관수동',9.5),('신촌가을','30000원','120000원','서울서대문구창천동',8.9),('잠실셀레네','30000원','125000원','서울송파구방이동',9.3),('종로부티크호텔K','27000원','70000원','서울종로구관철동',9.4),('역삼호텔디아티스트','35000원','150000원','서울강남구역삼동',9.2),('건대더디자이너스프리미어-화양동','35000원','135000원','서울광진구화양동',9.4),('영등포Blvd호텔오라','35000원','120000원','서울영등포구영등포동3가',9.3),('영등포부띠크HotelSB','25990원','139990원','서울영등포구영등포동3가',9.1);
/*!40000 ALTER TABLE `서울모텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `서울음식점`
--

DROP TABLE IF EXISTS `서울음식점`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `서울음식점` (
  `이름` text,
  `별점` text,
  `위치` text,
  `종류` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `서울음식점`
--

LOCK TABLES `서울음식점` WRITE;
/*!40000 ALTER TABLE `서울음식점` DISABLE KEYS */;
INSERT INTO `서울음식점` VALUES ('주옥','4.4점','시청','퓨전'),('소이연남','4.4점','연남동','태국'),('피에르가니에르서울롯데호텔서울','4.3점','시청','프렌치'),('서울신라호텔팔선','4.3점','동대문/장충/신당','중식'),('스와니예','4.3점','서래마을','퓨전');
/*!40000 ALTER TABLE `서울음식점` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `서울축제`
--

DROP TABLE IF EXISTS `서울축제`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `서울축제` (
  `이름` text,
  `위치` text,
  `기간` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `서울축제`
--

LOCK TABLES `서울축제` WRITE;
/*!40000 ALTER TABLE `서울축제` DISABLE KEYS */;
INSERT INTO `서울축제` VALUES ('2023코리아그랜드세일','서울','2023.01.12 ~ 2023.02.28');
/*!40000 ALTER TABLE `서울축제` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `서울펜션`
--

DROP TABLE IF EXISTS `서울펜션`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `서울펜션` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `서울펜션`
--

LOCK TABLES `서울펜션` WRITE;
/*!40000 ALTER TABLE `서울펜션` DISABLE KEYS */;
INSERT INTO `서울펜션` VALUES ('풀빌라가평BROOK5(브룩5)','자라섬차량13분',9.8,'POOLVILLA 401','0원','STANDARD 303','186000원','STANDARD 103','186000원','STANDARD 503','186000원','STANDARD 304','199000원','STANDARD 302','199000원','STANDARD 404','199000원','STANDARD 504','199000원','STANDARD 204','199000원','STANDARD 502','199000원'),('풀빌라가평세인트21독채풀빌라','자라섬차량12분',9.4,'207호(람블라)','0원','205호(차일)','249000원','204호(까미니또)','269000원','312호(라우니온)','269000원','313호(오차드)','269000원','415호(이스티클랄)','269000원','','','','','','','',''),('풀빌라대부도어스20(Us20)','경기안산시단원구대부남동',8.8,'A동_201','0원','B동_201','0원','A동_202','95000원','A동_102','95000원','A동_302','152000원','A동_301','152000원','단체펜션_3층','161500원','단체펜션_1층','190000원','단체펜션_2층','237500원','B동_302','256500원'),('양평에피소드706','상원계곡차량14분',9.9,'episode 2','0원','episode 3','0원','episode 4','0원','episode 6','0원','episode 5','144000원','','','','','','','','','',''),('풀빌라가평여우가달을사랑할때(라구나펜션)','남이섬차량21분',9.4,'글램핑(투베드)(기준3인)(랜덤배정)','0원','커플A(제트스파)(기준2인)','109000원','커플B(제트스파)(기준2인)','109000원','글램핑(투베드)(기준3인)(랜덤배정)','139000원','글램핑(투베드)(기준3인)(랜덤배정)','139000원','여우의정원(풀빌라)(기준2인)','300000원','','','','','','','',''),('풀빌라양평그랑아치풀빌라','경기양평군개군면주읍리',10,'Arch_FOUR','0원','Arch_TWO','353400원','Arch_THREE','353400원','','','','','','','','','','','','','',''),('대부도와우펜션','누에섬차량5분',9.8,'[커플/스파/안마기]2층','0원','[스위트룸]1층','0원','[스위트룸/스파/노래방]독채','0원','[커플/스파]3층','162000원','','','','','','','','','','','',''),('을왕리시드니펜션','왕산마리나차량9분',9.9,'203호','0원','501호','60000원','602호','60000원','603호','60000원','502호','60000원','503호','60000원','601호','60000원','701호','270000원','','','',''),('풀빌라양평초록밤풀빌라','문호리버마켓차량15분',9.4,'별님1호(POOL)','190000원','별님3호','190000원','초록2호(POOL)','190000원','초록3호','190000원','달님2호(POOL)','190000원','달님3호','190000원','달님1호(POOL)','190000원','','','','','',''),('풀빌라가평릴리브풀빌라','아침고요동물원차량7분',9.8,'풀빌라_102','270000원','풀빌라_202','270000원','','','','','','','','','','','','','','','','');
/*!40000 ALTER TABLE `서울펜션` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `서울호텔`
--

DROP TABLE IF EXISTS `서울호텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `서울호텔` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `서울호텔`
--

LOCK TABLES `서울호텔` WRITE;
/*!40000 ALTER TABLE `서울호텔` DISABLE KEYS */;
INSERT INTO `서울호텔` VALUES ('5성급서울신라호텔','동대입구역5번출구도보5분',9.9,'[LTA ROOM ONLY] 디럭스 더블','660000원','[LTA ROOM ONLY] 디럭스 트윈','660000원','[LTA ROOM ONLY] 비즈니스 디럭스 킹','720500원','[LTA ROOM ONLY] 비즈니스 디럭스 트윈','720500원','[LTA BED AND BREAKFAST] 디럭스 더블','760000원','[LTA BED AND BREAKFAST] 디럭스 트윈','760000원','[LTA ROOM ONLY] 그랜드 코너 디럭스','781000원','[LTA BED AND BREAKFAST] 비즈니스 디럭스 킹','820500원','[LTA BED AND BREAKFAST] 비즈니스 디럭스 트윈','820500원','[TA Urban Island] 디럭스 더블','847000원'),('특급페어필드바이메리어트서울','영등포역부근',9.3,'[반나절 호캉스-숙박불가] 프리미어 체크인 ...','0원','[반나절 호캉스-숙박불가] 프리미어 체크인 ...','95000원','슈페리어 싱글 (조식불포함)','97000원','[레이트버드 21시 체크인] 프리미어 (킹 / 조...','97000원','[레이트버드 21시 체크인] 프리미어 (싱글+싱...','97000원','[얼리버드 특가-17시 레이트 체크인] 프리미...','98000원','#Autumn Spot Sale# 프리미어 (킹 / 조식불포함)','99000원','#Autumn Spot Sale# 프리미어 (싱글+싱글 / ...','99000원','#선착순! 고층배정# 프리미어 킹','102000원','[17시 체크인&13시 체크아웃] 프리미어 (킹 /...','103000원'),('특급★당일특가★더스테이트선유호텔','선유도역도보2분',9.4,'슈페리어 더블 (샤워부스)','0원','디럭스 패밀리트윈','0원','[루프탑 와인무제한 패키지] 슈페리어 더블 (...','0원','[단독! 13시 체크아웃] 슈페리어 더블 (욕조)','99000원','[넷플릭스 이용] 슈페리어 트윈','118000원','슈페리어 더블 (욕조)','124000원','[넷플릭스 이용] 슈페리어 더블 (욕조)','129000원','[스테이크 SET 패키지] 슈페리어 더블 (욕조)','189000원','','','',''),('3성급★당일특가★글래드강남코엑스센터','삼성역도보1분',9.4,'[반나절호캉스-숙박불가] 할리우드 더블 (15...','0원','[반나절호캉스-숙박불가] 스탠다드 트윈 (15...','104500원','[반나절호캉스-숙박불가] 스탠다드 더블 (15...','110000원','[한정특가] 스탠다드 트윈','123000원','[한정특가] 스탠다드 더블','128000원','[MD픽! 메디힐 수분크림 1개 제공] 스탠다드 ...','132000원','[MD픽! 메디힐 수분크림 1개 제공] 스탠다드 ...','137500원','[조식 1+1 패키지] 스탠다드 트윈','154000원','[조식 1+1 패키지] 스탠다드 더블','159500원','',''),('4성급반짝특가호텔리베라','청담역도보5분',9.1,'[S컬렉션] 디럭스 온돌','0원','[단독특가] 체크인 시 배정','111000원','슈페리어 더블','125000원','디럭스 트윈','125000원','슈페리어 트윈','130000원','럭셔리 트윈','140000원','패밀리 트윈','170000원','슈페리어 스위트','350000원','','','',''),('3성급JK블라썸호텔','증미역차량3분',9.2,'비즈니스 트윈 (씨티뷰)','60000원','슈페리어 트윈 (시티뷰)','70000원','헐리우드 더블 (씨티뷰)','70000원','프리미엄 비즈니스 더블 (리버뷰)','70000원','슈페리어 더블 (리버뷰)','80000원','스위트 (파티룸)','110000원','디럭스 더블 (리버뷰)','120000원','[주중 호캉스 훈제&맥주 무제한 패키지] 비즈...','150000원','[주중 호캉스 훈제&맥주 무제한 패키지] 슈페...','160000원','',''),('5성급노보텔스위트앰배서더서울용산','용산역3번출구도보3분',9.5,'[S컬렉션] 주니어 스위트 (2싱글베드)','258500원','디럭스 스위트','324500원','주니어 스위트','435600원','','','','','','','','','','','','','',''),('3성급반짝특가신라스테이마포','홍대입구차량10분',9.1,'[숙박불가-Stay&Relax 9시간+Netflix] 체크인...','0원','[숙박불가-Stay&Relax 9시간] 체크인시 배정','92500원','[반짝특가! 무료 룸UP] 스탠다드→디럭스 더블...','113000원','[Room only] 스탠다드 트윈','126500원','[Room only] 스탠다드 더블','126500원','헐리우드 더블 (욕조 포함)','126500원','[연말여행-룸UP&쿠팡이츠 1만원] 스탠다드 더...','126500원','스탠다드 패밀리 트윈','132000원','[Room only] 디럭스 더블','132000원','[Holy Moly Netflix 패키지] 스탠다드 더블','133375원'),('3성급신라스테이삼성','삼성역도보2분',9.2,'[넷플릭스 OTT 패키지] 디럭스 트윈 (빌리지뷰)','0원','[반나절 호캉스-숙박불가] 체크인 시 배정 (...','118700원','[단독특가] 컴포트 레저 (65인치 TV, 모션베드)','155375원','[단독특가! 조식1+1] 컴포트 레저 (65인치 TV...','188375원','체크인 시 배정','190300원','[단독! Relaxing Night] 체크인 시 배정','201080원','[조식 2인 패키지] 스탠다드 트윈 (빌리지뷰)','211200원','[24시간 스테이 패키지] 스탠다드 트윈 (빌리...','216700원','스탠다드 트윈 (빌리지뷰)','217520원','[조식1+1 패키지] 체크인 시 배정','223300원'),('4성급골든서울호텔','서울강서구염창동',9,'[단독특가] 스탠다드 트윈','79000원','[단독특가] 스탠다드 더블','85000원','인사이드 더블','89900원','스탠다드 싱글','99000원','스탠다드 더블','109900원','스탠다드 트윈','109900원','디럭스 트윈','149900원','스탠다드 트리플','159000원','[골든 인 크루즈 패키지] 디럭스 트윈','159900원','패밀리 트윈','239000원');
/*!40000 ALTER TABLE `서울호텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `수원관광지`
--

DROP TABLE IF EXISTS `수원관광지`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `수원관광지` (
  `이름` text,
  `위치` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `수원관광지`
--

LOCK TABLES `수원관광지` WRITE;
/*!40000 ALTER TABLE `수원관광지` DISABLE KEYS */;
INSERT INTO `수원관광지` VALUES ('수원 화성 [유네스코 세계문화유산]','경기도 수원시'),('수원화성 관광특구','경기도 수원시'),('수원박물관','경기도 수원시'),('수원사(수원)','경기도 수원시'),('수원시미술전시관','경기도 수원시'),('수원시립아이파크미술관','경기도 수원시'),('수원 남문시장','경기도 수원시'),('조개창고 수원점','경기도 수원시'),('수원광교박물관','경기도 수원시'),('수원화성박물관','경기도 수원시');
/*!40000 ALTER TABLE `수원관광지` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `수원모텔`
--

DROP TABLE IF EXISTS `수원모텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `수원모텔` (
  `장소` text,
  `대실` text,
  `숙박` text,
  `위치` text,
  `별점` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `수원모텔`
--

LOCK TABLES `수원모텔` WRITE;
/*!40000 ALTER TABLE `수원모텔` DISABLE KEYS */;
INSERT INTO `수원모텔` VALUES ('수원역J호텔-제이호텔','30000원','100000원','경기수원시팔달구매산로1가',9.3),('인계동No.25-수원인계점','22000원','100000원','경기수원시팔달구인계동',9.4),('수원역71번가-71st','25000원','85000원','경기수원시팔달구매산로2가',9.1),('인계동호텔로와','23000원','90000원','경기수원시팔달구인계동',9.7),('수원역하운드호텔','24800원','99800원','경기수원시팔달구매산로2가',9.9),('구운동파티즈-구메이트','30000원','130000원','경기수원시권선구구운동',9.4),('인계동리치-RICH','25000원','120000원','경기수원시팔달구인계동',9.6),('인계동호텔리아체','40000원','115000원','경기수원시팔달구인계동',9.8),('인계동부티크엘가','17000원','87000원','경기수원시팔달구인계동',9.3),('인계동앨리스','50000원','90000원','경기수원시팔달구인계동',9.9);
/*!40000 ALTER TABLE `수원모텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `수원음식점`
--

DROP TABLE IF EXISTS `수원음식점`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `수원음식점` (
  `이름` text,
  `별점` text,
  `위치` text,
  `종류` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `수원음식점`
--

LOCK TABLES `수원음식점` WRITE;
/*!40000 ALTER TABLE `수원음식점` DISABLE KEYS */;
INSERT INTO `수원음식점` VALUES ('본수원갈비','4.1점','수원-팔달구/인계/행궁','소구이/불고기'),('진미통닭','4.1점','수원-팔달구/인계/행궁','치킨/통닭'),('아다미식당','4.4점','수원-팔달구/인계/행궁','순댓국/순대'),('장안통닭','4.2점','수원-팔달구/인계/행궁','치킨/통닭'),('입주집','4.1점','수원-팔달구/인계/행궁','곱창/대창');
/*!40000 ALTER TABLE `수원음식점` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `수원축제`
--

DROP TABLE IF EXISTS `수원축제`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `수원축제` (
  `이름` text,
  `위치` text,
  `기간` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `수원축제`
--

LOCK TABLES `수원축제` WRITE;
/*!40000 ALTER TABLE `수원축제` DISABLE KEYS */;
INSERT INTO `수원축제` VALUES ('수원화성의 비밀','경기 수원시','2022.01.01 ~ 2022.12.31'),('무예24기 시범공연','경기 수원시','2021.12.22 ~ 2022.12.31');
/*!40000 ALTER TABLE `수원축제` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `수원펜션`
--

DROP TABLE IF EXISTS `수원펜션`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `수원펜션` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `수원펜션`
--

LOCK TABLES `수원펜션` WRITE;
/*!40000 ALTER TABLE `수원펜션` DISABLE KEYS */;
INSERT INTO `수원펜션` VALUES ('동해망상길펜션','망상해변도보5분',9.6,'201','0원','206','70000원','205','75000원','301','90000원','','','','','','','','','','','',''),('동해수원지펜션','하평해변차량9분',10,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('제주별바람펜션','어도오름차량10분',9.9,'별 하나(오션뷰)','70000원','별 둘(오션뷰)','80000원','별 셋(오션뷰)','80000원','','','','','','','','','','','','','',''),('제주모아나스테이','곽지해수욕장차량10분',0,'독채(2층 전체)','250000원','','','','','','','','','','','','','','','','','',''),('제주하늘바다펜션','곽지해수욕장차량10분',0,'하늘룸(2박이상예약가능)','91800원','제주룸(2박이상예약가능)','91800원','바다룸(오션뷰/2박이상예약가능)','132600원','하늘바다룸(오션뷰/2박이상예약가능)','306000원','','','','','','','','','','','','');
/*!40000 ALTER TABLE `수원펜션` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `수원호텔`
--

DROP TABLE IF EXISTS `수원호텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `수원호텔` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `수원호텔`
--

LOCK TABLES `수원호텔` WRITE;
/*!40000 ALTER TABLE `수원호텔` DISABLE KEYS */;
INSERT INTO `수원호텔` VALUES ('3성급이비스앰배서더수원','수원시청역도보3분',9.1,'슈페리어 트윈 (Room only)','160000원','[Late Out Promotion] 슈페리어 더블 (14시 ...','170000원','주니어 스위트 (욕조없음)','187000원','주니어 스위트 (Room only)','209000원','','','','','','','','','','','',''),('1성급수원도노1796','수원화성도보3분',8.7,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('관광수원세인트호텔','서수원시외버스터미널앞',9.2,'[22시 체크인] 디럭스','180000원','[22시체크인] OTT룸(디즈니+/넷플릭스/티빙)','200000원','[18시 체크인] 디럭스','210000원','[22시 체크인] 트윈룸','220000원','[22시 체크인] 풋스파룸','220000원','[22시 체크인] 프리미엄','220000원','[18시체크인] OTT룸(디즈니+/넷플릭스/티빙)','230000원','[18시 체크인] 트윈룸','260000원','[18시 체크인] 풋스파룸','260000원','[18시 체크인] 프리미엄','260000원'),('비지니스벨라스위트호텔','수원시청역도보2분',9.5,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('3성급호텔아르떼(HotelArte)','수원버스터미널차량9분',9.5,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('4성급라마다프라자수원','수원시청역부근',9.3,'슈페리어 더블','242000원','슈페리어 더블 (2인조식포함)','275000원','','','','','','','','','','','','','','','',''),('비지니스에스스테이호텔','수원역도보9분',9.6,'디럭스 더블','119000원','','','','','','','','','','','','','','','','','',''),('레지던스수원역아이비스테이호텔','수원역도보5분',9.6,'[1인 도보특가] 더블','94500원','[도보특가] 디럭스 더블','100000원','디럭스 더블','111200원','프리미엄 더블','133400원','복층 스위트','167000원','','','','','','','','','',''),('4성급코트야드메리어트수원','광교중앙역도보10분',9.7,'[주차불가 핫딜] 프리미어 킹','297000원','프리미어 킹','330000원','[주차불가 핫딜-조식포함] 프리미어 킹','330000원','[컬러풀 스테이케이션-드로잉체험] 프리미어 킹','341000원','[2인 조식 패키지] 프리미어 킹','363000원','[아쿠아 패키지-조식포함] 프리미어 킹','385000원','[2인 라운지 패키지] 이그제큐티브 프리미어 킹','418000원','','','','','',''),('비지니스탑클라우드호텔수원','수원화성차량3분',9.4,'[30H STAY I TYPE] STYLER DELUXE(금연객실)','0원','[30H STAY II TYPE] STANDARD (금연객실)','0원','STANDARD A (금연객실)','65000원','STANDARD B (금연객실)','65000원','STANDARD C (금연객실)','65000원','','','','','','','','','','');
/*!40000 ALTER TABLE `수원호텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `울산관광지`
--

DROP TABLE IF EXISTS `울산관광지`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `울산관광지` (
  `이름` text,
  `위치` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `울산관광지`
--

LOCK TABLES `울산관광지` WRITE;
/*!40000 ALTER TABLE `울산관광지` DISABLE KEYS */;
INSERT INTO `울산관광지` VALUES ('울산 12경','울산 중구'),('부산과 울산 여행을 한번에! 1박2일 여행 코스 추천','울산 울주군'),('태화강 국가정원 십리대숲 (은하수길)','울산 중구'),('울산대교 전망대','울산 동구'),('울산 큰애기하우스','울산 중구'),('어련당[한국관광 품질인증/Korea Quality]','울산 중구'),('울산 문화의거리','울산 중구'),('울산 귀신고래 회유해면','울산 남구'),('울산대공원','울산 남구'),('울산대공원 동물원','울산 남구');
/*!40000 ALTER TABLE `울산관광지` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `울산모텔`
--

DROP TABLE IF EXISTS `울산모텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `울산모텔` (
  `장소` text,
  `대실` text,
  `숙박` text,
  `위치` text,
  `별점` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `울산모텔`
--

LOCK TABLES `울산모텔` WRITE;
/*!40000 ALTER TABLE `울산모텔` DISABLE KEYS */;
INSERT INTO `울산모텔` VALUES ('삼산도브','20000원','70000원','울산남구삼산동',9.7),('삼산호텔락','20000원','50000원','울산남구삼산동',9.4),('삼산HotelMar','30000원','69500원','울산남구삼산동',9.6),('삼산H호텔','25000원','80000원','울산남구삼산동',9.6),('경주라쿠스호텔','30000원','120000원','경북경주시진현동',9.9),('울산호텔낭만스테이-삼산점','25000원','80000원','울산남구삼산동',9.8),('울산호텔그라운드7','25000원','80000원','울산북구진장동',9.8),('삼산커스텀호텔','29500원','129000원','울산남구삼산동',9.9),('울산V','30000원','70000원','울산중구성남동',9.7),('삼산알리바바','25000원','85000원','울산남구삼산동',9.4);
/*!40000 ALTER TABLE `울산모텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `울산음식점`
--

DROP TABLE IF EXISTS `울산음식점`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `울산음식점` (
  `이름` text,
  `별점` text,
  `위치` text,
  `종류` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `울산음식점`
--

LOCK TABLES `울산음식점` WRITE;
/*!40000 ALTER TABLE `울산음식점` DISABLE KEYS */;
INSERT INTO `울산음식점` VALUES ('사량도자연산횟집','4.3점','남구-달동','회/횟집/참치'),('저수지휴게실','4.2점','울주군','칼국수/국수'),('떡바우횟집','4.2점','울주군','회/횟집/참치'),('언양진미불고기','4.0점','울주군','소구이/불고기'),('OK목장','4.0점','울주군','한정식');
/*!40000 ALTER TABLE `울산음식점` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `울산축제`
--

DROP TABLE IF EXISTS `울산축제`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `울산축제` (
  `이름` text,
  `위치` text,
  `기간` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `울산축제`
--

LOCK TABLES `울산축제` WRITE;
/*!40000 ALTER TABLE `울산축제` DISABLE KEYS */;
/*!40000 ALTER TABLE `울산축제` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `울산펜션`
--

DROP TABLE IF EXISTS `울산펜션`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `울산펜션` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `울산펜션`
--

LOCK TABLES `울산펜션` WRITE;
/*!40000 ALTER TABLE `울산펜션` DISABLE KEYS */;
INSERT INTO `울산펜션` VALUES ('울산머물곶펜션카라반2호점','진하해수욕장차량5분',10,'패밀리 카라반','0원','머물, 곶 스위트','500000원','','','','','','','','','','','','','','','',''),('울산간절그곳펜션','간절곶차량7분',9.6,'203호','120000원','302호','150000원','301호','150000원','','','','','','','','','','','','','',''),('풀빌라울산히든베이풀빌라','강동몽돌해변차량6분',9.9,'A104(개별실내풀)','0원','B202(개별루프탑풀)','0원','C301(개별루프탑풀)','0원','','','','','','','','','','','','','',''),('풀빌라울산비클래시키즈풀빌라간절곶점','울산울주군서생면대송리',9.3,'D-101','0원','D-201','0원','','','','','','','','','','','','','','','',''),('울산간절곶뷰펜션','간절곳차량3분',9.6,'302호 (침대)','50000원','2F','120000원','3F','120000원','','','','','','','','','','','','','',''),('풀빌라울진베아트리스풀빌라','후포해변차량5분',9.7,'풀빌라106호','0원','일반 202호','130000원','','','','','','','','','','','','','','','',''),('팜하우스','간절곶도보9분',9.4,'102','80000원','104','80000원','201','120000원','202','120000원','204','120000원','205','120000원','팜4','160000원','팜7','160000원','팜5','180000원','팜6','180000원'),('울산에스티210','정자항차량4분',9.8,'302호','210000원','301호','210000원','303호','310000원','','','','','','','','','','','','','',''),('울산머물곶펜션카라반','진하해수욕장차량6분',9.8,'302호','0원','','','','','','','','','','','','','','','','','',''),('울산나디아펜션','진하해수욕장차량9분',9.4,'a201','100000원','a202','100000원','a203','130000원','b201','130000원','b202','130000원','b301','130000원','b302','130000원','','','','','','');
/*!40000 ALTER TABLE `울산펜션` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `울산호텔`
--

DROP TABLE IF EXISTS `울산호텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `울산호텔` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `울산호텔`
--

LOCK TABLES `울산호텔` WRITE;
/*!40000 ALTER TABLE `울산호텔` DISABLE KEYS */;
INSERT INTO `울산호텔` VALUES ('3성급스타즈호텔울산','태화강역차량2분',9.6,'[리오픈 특가] [언택트체크인] 스카이 스탠다...','0원','[리오픈 특가+조식2인][언택트체크인] 스카이...','63000원','[리오픈 특가] [언택트체크인] 패밀리 트윈','66500원','[언택트체크인] 스카이 스탠다드 더블','70000원','[언택트체크인] 패밀리 트윈','95000원','[리오픈 특가] [언택트체크인] 스위트','105000원','[언택트체크인] 스위트','150000원','','','','','',''),('레지던스호텔리버사이드울산','태화강도보1분',9.6,'디럭스 (저층하프뷰)','65000원','[25시간스테이 & 무료룸UP] 슈페리어→디럭스','66500원','[27시간 스테이 특가-웰컴드링크2잔] 슈페리어','66500원','[한정특가] 슈페리어','66500원','[단독! 무료 룸UP] 슈페리어→The Party 4인테...','70000원','[비즈니스 안심 패키지] 슈페리어→디럭스 (무...','72000원','디럭스','105000원','The Party 4인테이블','125000원','[특가] 스위트','310000원','',''),('3성급신라스테이울산','울산남구달동',9.3,'[반나절 호캉스-숙박불가] [4시간숏캉스] 스...','47850원','[반나절 호캉스-숙박불가] [객실 6시간 이용]...','59800원','[반나절 호캉스-숙박불가] [8시간숏캉스] 스...','67800원','스탠다드 체크인 시 배정','77000원','스탠다드 더블','79750원','스탠다드 트윈','79750원','[Relaxing Night] 스탠다드 더블','79750원','[스마트 스트리밍 패키지] 스탠다드 더블','82750원','[스마트 스트리밍 패키지] 스탠다드 트윈','82750원','디럭스 더블','85250원'),('3성급롯데시티호텔울산','울산남구달동',9.5,'스탠다드 더블','77000원','스탠다드 트윈','77000원','[스마트 TV 패키지] 스탠다드 더블','77000원','[스마트 TV 패키지] 스탠다드 트윈','77000원','[1인 조식 패키지] 스탠다드 더블','95000원','스탠다드 패밀리 트윈','104500원','[스마트 TV 패키지] 스탠다드 패밀리 트윈','104500원','[2인 조식 패키지] 스탠다드 더블','113000원','[2인 조식 패키지] 스탠다드 트윈','113000원','디럭스 더블','121000원'),('4성급호텔현대바이라한울산','일산해수욕장차량5분',9.5,'디럭스 트윈 (수영장 2인 1회 포함)','95000원','디럭스 더블 (수영장 2인 1회 포함)','95000원','[연박할인] [무료 룸UP] 디럭스 더블→프리미...','95000원','[연박할인] 디럭스 트윈 (수영장 2인 1회 포함)','95000원','[24시간 스테이 패키지] 디럭스 더블 (수영장...','105000원','[24시간 스테이 패키지] 디럭스 트윈 (수영장...','105000원','프리미엄 디럭스 더블 (수영장 2인 1회 포함)','115000원','[조식&수영장 2인 패키지] 디럭스 더블','139000원','[조식&수영장 2인 패키지] 디럭스 트윈','139000원','프리미엄 스위트 (수영장 2인 1회 포함)','145000원'),('비지니스울산브라운도트장생포항구점','울산시외버스터미널차량15분',9.8,'스탠다드 더블 시티','60000원','디럭스 더블 시티 (넷플릭스 서비스 제공)','70000원','디럭스 더블 오션 (넷플릭스 서비스 제공)','85000원','디럭스 트윈 오션 (넷플릭스 서비스 제공)','95000원','디럭스 패밀리 트윈 오션 (넷플릭스 서비스 ...','110000원','테라스 스위트 (넷플릭스 서비스 제공)','130000원','','','','','','','',''),('4성급머큐어앰배서더울산','울산공항차량22분',9.5,'슈페리어 트윈 (파셜오션뷰)','138636원','슈페리어 더블 (파셜오션뷰)','150000원','슈페리어 패밀리 (파셜오션뷰)','175000원','프리빌리지 더블 (정면오션뷰)','212500원','프리빌리지 패밀리 (정면오션뷰)','237500원','','','','','','','','','',''),('비지니스울산커스텀호텔','태화강역차량3분',9.6,'디럭스 트윈','100000원','패밀리 트윈','120000원','패밀리 스위트 & 스파','300000원','','','','','','','','','','','','','',''),('3성급울산에쉬튼호텔','태화강역차량13분',9.8,'스탠다드 싱글','60000원','[무료 룸 업그레이드] 스탠다드 싱글→스탠다...','60000원','[장생포 고래 패키지] 스탠다드 싱글','65000원','스탠다드 더블','70000원','[무료 룸 업그레이드] 스탠다드 더블→슈페리...','70000원','[장생포 고래 패키지] 스탠다드 더블','75000원','슈페리어 더블','80000원','[무료 룸 업그레이드] 슈페리어→패밀리 트윈','80000원','슈페리어 트윈(싱글+싱글)','80000원','[장생포 고래 패키지] 슈페리어 더블','85000원'),('가족호텔키즈호텔상상플레이등억점','울산역차량14분',10,'키즈 VIP 히노끼 온돌','100000원','키즈 VIP 벙커','140000원','키즈 VIP 트윈','160000원','키즈 프리미엄 트윈','180000원','키즈 VIP 복층','200000원','','','','','','','','','','');
/*!40000 ALTER TABLE `울산호텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `인천관광지`
--

DROP TABLE IF EXISTS `인천관광지`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `인천관광지` (
  `이름` text,
  `위치` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `인천관광지`
--

LOCK TABLES `인천관광지` WRITE;
/*!40000 ALTER TABLE `인천관광지` DISABLE KEYS */;
INSERT INTO `인천관광지` VALUES ('인천대교','인천 중구'),('[인천 개항 누리길] 3시간 코스','인천 중구'),('[인천 개항 누리길] 1시간 코스','인천 중구'),('하워드 존슨 인천 에어포트 [한국관광 품질인증/Korea Quality]','인천 중구'),('인천 차이나타운','인천 중구'),('데이즈 호텔 인천 에어포트 (데이즈 호텔 앤 스위트 인천 에어포트) [한국관광 품질인증/Korea Quality]','인천 중구'),('인천도호부관아','인천 미추홀구'),('인천상륙작전기념관','인천 연수구'),('인천도시역사관','인천 연수구'),('이코노미호텔 인천부평점 [한국관광 품질인증/Korea Quality]','인천 부평구');
/*!40000 ALTER TABLE `인천관광지` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `인천모텔`
--

DROP TABLE IF EXISTS `인천모텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `인천모텔` (
  `장소` text,
  `대실` text,
  `숙박` text,
  `위치` text,
  `별점` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `인천모텔`
--

LOCK TABLES `인천모텔` WRITE;
/*!40000 ALTER TABLE `인천모텔` DISABLE KEYS */;
INSERT INTO `인천모텔` VALUES ('구월반월아시아드호텔','24990원','90000원','인천남동구구월동',9.5),('구월동구월호텔','24990원','100000원','인천남동구구월동',9.4),('호구포그랜드팰리스','60000원','99000원','인천남동구논현동',9),('간석골든호텔','25000원','90000원','인천남동구간석동',9.5),('부평샴푸','23000원','80000원','인천부평구부평동',9.6),('검단3SBOUTIQUEHOTEL','30000원','85000원','인천서구당하동',9.6),('부평더휴식아늑호텔','30000원','110000원','인천부평구부평동',9.8),('구월느낌','25000원','120000원','인천남동구구월동',9.5),('연수호텔498','30000원','100000원','인천연수구청학동',9.5),('HOTEL여기어때-주안점','25000원','85000원','인천미추홀구주안동',9.6);
/*!40000 ALTER TABLE `인천모텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `인천음식점`
--

DROP TABLE IF EXISTS `인천음식점`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `인천음식점` (
  `이름` text,
  `별점` text,
  `위치` text,
  `종류` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `인천음식점`
--

LOCK TABLES `인천음식점` WRITE;
/*!40000 ALTER TABLE `인천음식점` DISABLE KEYS */;
INSERT INTO `인천음식점` VALUES ('충남서산집','4.1점','강화도/석모/옹진군','꽃게/랍스터/새우'),('신승반점','4.4점','중구-동인천/차이나타운/월미도','중식'),('권오길손국수본점','4.3점','서구/검단','칼국수/국수'),('변가네옹진냉면','4.3점','미추홀구/주안/인하대','냉면/막국수'),('부영선지국','4.3점','미추홀구/주안/인하대','전골');
/*!40000 ALTER TABLE `인천음식점` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `인천축제`
--

DROP TABLE IF EXISTS `인천축제`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `인천축제` (
  `이름` text,
  `위치` text,
  `기간` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `인천축제`
--

LOCK TABLES `인천축제` WRITE;
/*!40000 ALTER TABLE `인천축제` DISABLE KEYS */;
/*!40000 ALTER TABLE `인천축제` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `인천펜션`
--

DROP TABLE IF EXISTS `인천펜션`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `인천펜션` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `인천펜션`
--

LOCK TABLES `인천펜션` WRITE;
/*!40000 ALTER TABLE `인천펜션` DISABLE KEYS */;
INSERT INTO `인천펜션` VALUES ('풀빌라대부도일루아펜션','목섬차량5분',8.3,'오션204(스파)','0원','오션303(복층/스파)','0원','오션103(스파)','81100원','오션304(복층/스파)','127000원','디럭스(복층/스파)','171000원','펜트하우스A(투룸/복층/스파)','252000원','풀빌라(투룸/수영장/스파)','350000원','그랜드펜트하우스(독채룸4)','604000원','','','',''),('글램독영흥도','인천옹진군영흥면외리',9.1,'205','0원','305','0원','301','109000원','','','','','','','','','','','','','',''),('강화요정들의선물펜션','동막해수욕장차량3분',8.4,'꽃의요정','100000원','숲속의요정','100000원','바다요정(스파)','120000원','별빛요정(하절기에만스파)','140000원','','','','','','','','','','','',''),('을왕리별자리펜션','용유도해변차량5분',9.1,'[나동]201호(침대방)','60000원','[나동]202호(침대방)','60000원','[다동]201호(침대방)','60000원','[다동]202호(침대방)','60000원','[가동]101호(침대방)','80000원','[가동]102호(침대방)','80000원','[나동]203호(침대방)','80000원','[다동]203호(침대방)','80000원','[가동]201호(단체룸)','250000원','[나동]101호(단체룸, 침대방)','250000원'),('강화예플로펜션','전등사차량18분',9,'구름','80000원','노을','130000원','달무리','130000원','미리내','130000원','솔향','130000원','','','','','','','','','',''),('대부도미림펜션(본관)','장경리해수욕장차량1분',7.8,'102호','100000원','103호','100000원','104호','100000원','105호','100000원','106호','100000원','101호','100000원','107호','120000원','본관2층','320000원','본관단체','390000원','',''),('강화그랑블루펜션','매화마름차량12분',10,'단체룸','0원','커플룸B','73000원','커플룸A','73000원','둥실둥실(오션뷰1호 복층)','89000원','오손도손(오션뷰2호 복층)','89000원','알록달록(오션뷰4호 복층)','89000원','반짝반짝(오션뷰5호 복층)','89000원','','','','','',''),('풀빌라선재해림풀빌라카라반','인천옹진군영흥면선재리',9.6,'라온 501','0원','라온 601','0원','','','','','','','','','','','','','','','',''),('강화에코스파펜션글램핑','전등사차량11분',9.9,'물망초(2층,스파)','0원','아네모네(2층,스파)','0원','글램핑2(빔프로젝트 구비O,가족4인입실)','0원','라일락(1층,스파,가족4인입실)','0원','글램핑1(빔프로젝트 구비O,가족4인입실)','0원','글램핑3(빔프로젝트 구비O)','0원','','','','','','','',''),('선재도리틀미코노스','인천옹진군영흥면선재리',8.6,'202동302호(개별바베큐)','0원','101동202호(스탠다드A)','110000원','104동101호(스탠다드A)','110000원','101동101호(개별바베큐)','120000원','101동201호(개별바베큐)','120000원','101동302호(개별바베큐)','120000원','107동101호(개별바베큐)','120000원','102동201호(스탠다드B)','120000원','102동302호(스탠다드B)','120000원','304동302호(스탠다드B)','120000원');
/*!40000 ALTER TABLE `인천펜션` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `인천호텔`
--

DROP TABLE IF EXISTS `인천호텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `인천호텔` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `인천호텔`
--

LOCK TABLES `인천호텔` WRITE;
/*!40000 ALTER TABLE `인천호텔` DISABLE KEYS */;
INSERT INTO `인천호텔` VALUES ('특급로얄엠포리움','인천국제공항차량20분',9,'디럭스 트윈','50000원','디럭스 더블','65000원','[2인 조식] 디럭스 트윈','70000원','[2인 조식] 디럭스 더블','85000원','프리미어 트윈','88000원','프리미어 더블','93000원','프리미어 패밀리 트윈','103000원','키즈룸 (체크인 시 배정)','105000원','프리미어 펫룸 위드 테라스','110000원','[2인 조식] 프리미어 트윈','118000원'),('4성급오라카이송도파크호텔','송도센트럴파크도보1분',9.1,'체크인 시 배정','104500원','[타임세일] 디럭스 트윈+스마트TV (Room Only)','110000원','스페셜 더블 (Room Only / 장애인 객실)','110000원','[타임세일] 디럭스 더블+스마트TV (Room Only)','121000원','디럭스 트윈+스마트TV (Room Only)','132000원','디럭스 트윈 센트럴파크뷰+스마트TV','132000원','디럭스 더블+스마트TV (Room Only)','143000원','디럭스 더블 센트럴파크뷰+스마트TV','143000원','[타임세일-2인 조식] 디럭스 트윈+스마트TV','165000원','[타임세일] 프리미어 패밀리 트윈+스마트TV (...','176000원'),('레지던스블루오션레지던스호텔','인천중구중산동',9.1,'[반나절 호캉스-숙박불가] 디럭스룸 랜덤배정...','0원','[장기투숙-29박 이상] 디럭스 더블 (시티뷰)','53296원','[장기투숙-21박 이상] 디럭스 더블 (시티뷰)','58891원','[장기투숙-14박 이상] 디럭스 더블 (시티뷰)','58919원','디럭스 더블 (시티뷰)','60000원','[장기투숙-7박 이상] 디럭스 더블 (시티뷰)','61844원','디럭스 더블 (오션뷰)','75000원','디럭스 트윈 더블 (오션뷰)','95000원','','','',''),('레지던스어반스테이인천송도','송도달빛축제공원역도보5분',9.7,'[주중 타임 반짝특가!] 스튜디오 더블룸','59000원','[레이트버드-18시 체크인] 스튜디오 더블룸','59000원','비즈니스 더블룸','65000원','[무료 룸UP+늦은퇴실] 비즈니스 더블룸→스튜...','65000원','스튜디오 더블룸','69000원','[13시 레이트 체크아웃] 비즈니스 더블룸','75000원','[13시 레이트 체크아웃] 스튜디오 더블룸','79000원','','','','','',''),('특급에어스카이호텔','인천중구중산동',9.3,'[반나절 호캉스-숙박불가] 체크인 시 배정 (...','0원','스탠다드 트윈 (하버뷰)','66000원','스탠다드 더블 (하버뷰)','71500원','디럭스 트윈 (오션뷰)','77000원','디럭스 더블 (오션뷰)','82500원','프리미어 트윈 (파크오션뷰)','88000원','프리미어 더블 (오션뷰)','93500원','프리미어 패밀리 트윈 (오션뷰)','99000원','프리미어 트윈 펫 (파크오션뷰)','99000원','[조식 단품 2인 패키지] 스탠다드 트윈 (하버뷰)','100000원'),('특급웨스턴그레이스호텔','인천중구중산동',8.8,'[레이트버드 18시 체크인] 스탠다드 더블 (하...','48000원','스탠다드 더블 (하버뷰)','53000원','[레이트버드 18시 체크인] 스탠다드 더블 (오...','58000원','스탠다드 더블 (오션뷰)','63000원','[레이트버드 18시 체크인] 패밀리 트윈 (오션뷰)','64000원','패밀리 트윈 (오션뷰)','69000원','오션 더블 (오션뷰)','92000원','','','','','',''),('비지니스연화문호텔','용유역차량10분',9.4,'방이 꽉 찼습니다.','','','','','','','','','','','','','','','','','','',''),('3성급라마다송도호텔','인천연수구동춘동',8.1,'[단독특가] 디럭스 더블','63500원','[단독특가] 디럭스 트윈','68000원','디럭스 더블','80000원','디럭스 트윈','80000원','','','','','','','','','','','',''),('비지니스오션파크나인','운서역차량18분',9.3,'[반나절 호캉스-숙박불가] 체크인 시 배정 (6...','0원','[장기투숙-11박 이상] 스탠다드 수퍼킹 시티뷰','0원','[단독! 20시 체크인] 체크인 시 배정','47900원','[20시 체크인] 체크인 시 배정','50000원','스탠다드 트윈 시티뷰 (취사불가)','55000원','스탠다드 수퍼킹 시티뷰 (취사불가)','55000원','[단독! 주중특가] 스탠다드 수퍼킹 오션뷰 (...','58500원','스탠다드 수퍼킹 오션뷰 (취사불가)','60000원','디럭스 트리플 (취사가능)','120000원','프리미어 오션뷰 편백욕조 (취사가능)','150000원'),('3성급★오늘의특가★파크마린호텔','소래포구역부근',8.9,'[단독특가] 디럭스 더블 + 12시 체크아웃','59900원','체크인 시 배정','72000원','인사이드 더블 (전망 없음)','72000원','디럭스 더블','77000원','디럭스 트윈','77000원','[조식 2인 패키지] 디럭스 더블','93000원','[조식 2인 패키지] 디럭스 트윈','93000원','[소래포구 어시장! 모둠회 풀세트] 디럭스 더블','117000원','[소래포구 어시장! 모둠회 풀세트] 디럭스 트윈','117000원','한실 패밀리 트윈','120000원');
/*!40000 ALTER TABLE `인천호텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `제주도관광지`
--

DROP TABLE IF EXISTS `제주도관광지`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `제주도관광지` (
  `이름` text,
  `위치` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `제주도관광지`
--

LOCK TABLES `제주도관광지` WRITE;
/*!40000 ALTER TABLE `제주도관광지` DISABLE KEYS */;
INSERT INTO `제주도관광지` VALUES ('제주도 관광특구','제주도'),('제주도 국가지질공원','제주도 제주시'),('한라산 (제주도 국가지질공원)','제주도 제주시'),('천지연폭포 (제주도 국가지질공원)','제주도 서귀포시'),('제주도민속자연사박물관','제주도 제주시'),('제주도립미술관','제주도 제주시'),('만장굴 (제주도 국가지질공원)','제주도 제주시'),('진미명가','제주도'),('제주도 스쿠터 여행사 한라하이킹','제주도 제주시'),('제주도 하도리 숨비소리길(하도리밭담길)','제주도 제주시');
/*!40000 ALTER TABLE `제주도관광지` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `제주도모텔`
--

DROP TABLE IF EXISTS `제주도모텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `제주도모텔` (
  `장소` text,
  `대실` text,
  `숙박` text,
  `위치` text,
  `별점` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `제주도모텔`
--

LOCK TABLES `제주도모텔` WRITE;
/*!40000 ALTER TABLE `제주도모텔` DISABLE KEYS */;
INSERT INTO `제주도모텔` VALUES ('제주미주호텔','25000원','39000원','제주도제주시연동',9.4),('제주애플관광호텔','25000원','39900원','제주도제주시이도일동',8.4),('제주포시즌호텔','30000원','35000원','제주도제주시노형동',9.1),('제주탑아일랜드','23000원','35000원','제주특별자치도제주시용담일동',9.6),('제주퓨어스테이오션','30000원','44900원','제주특별자치도제주시도두이동',9.1),('서귀포호텔더그랑-제주중문','0원','120000원','제주도서귀포시색달동',9.6),('제주제이투호텔','40000원','45000원','제주특별자치도제주시연동',9.5),('제주서문레지던스호텔','40000원','50000원','제주특별자치도제주시용담일동',9.6),('제주우림호텔','27000원','35000원','제주도제주시애월읍하귀2리',8.8),('제주백호','25000원','40000원','제주도제주시연동',8.9);
/*!40000 ALTER TABLE `제주도모텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `제주도음식점`
--

DROP TABLE IF EXISTS `제주도음식점`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `제주도음식점` (
  `이름` text,
  `별점` text,
  `위치` text,
  `종류` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `제주도음식점`
--

LOCK TABLES `제주도음식점` WRITE;
/*!40000 ALTER TABLE `제주도음식점` DISABLE KEYS */;
INSERT INTO `제주도음식점` VALUES ('옥돔식당','3.9점','모슬포/대정/한경면/마라도','칼국수/국수'),('올래국수','3.8점','제주시내','칼국수/국수'),('항구식당','4.6점','모슬포/대정/한경면/마라도','생선구이/생선요리'),('해비치호텔앤드리조트밀리우','4.5점','남원/표선/성읍','퓨전'),('우진해장국','4.4점','제주시내','해장국/국밥/육개장');
/*!40000 ALTER TABLE `제주도음식점` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `제주도축제`
--

DROP TABLE IF EXISTS `제주도축제`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `제주도축제` (
  `이름` text,
  `위치` text,
  `기간` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `제주도축제`
--

LOCK TABLES `제주도축제` WRITE;
/*!40000 ALTER TABLE `제주도축제` DISABLE KEYS */;
/*!40000 ALTER TABLE `제주도축제` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `제주도펜션`
--

DROP TABLE IF EXISTS `제주도펜션`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `제주도펜션` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `제주도펜션`
--

LOCK TABLES `제주도펜션` WRITE;
/*!40000 ALTER TABLE `제주도펜션` DISABLE KEYS */;
INSERT INTO `제주도펜션` VALUES ('제주라임펜션','제주특별자치도제주시도두일동',9.7,'라임온돌','0원','','','','','','','','','','','','','','','','','',''),('제주바다의향기펜션','올레길10코스차량2분',9,'소라 3(오션뷰)','0원','소라 6(오션뷰)','63300원','소라 2(오션뷰)','63300원','소라 4(오션뷰)','63300원','소라 5(오션뷰)','63300원','','','','','','','','','',''),('제주가까이에소리펜션','이호테우해변차량9분',9.6,'가족룸1','100000원','','','','','','','','','','','','','','','','','',''),('서귀포향림원펜션','정방폭포차량5분',9.3,'10평형2','40000원','15평형','50000원','20평형1','60000원','20평형2','60000원','20평형3','60000원','23평형','70000원','','','','','','','',''),('풀빌라서귀포대정시크릿풀빌라','제주특별자치도서귀포시대정읍영락리',8.9,'리조트 스탠다드룸 B 302','0원','리조트 스탠다드룸 A 301','0원','리조트 스탠다드룸 B 304','0원','리조트 스탠다드 더블룸 B 204','0원','리조트 스탠다드 더블룸 B 202','0원','리조트 스탠다드룸 A 303','80000원','리조트 디럭스 더블룸 B 201','104000원','리조트 디럭스 더블룸 A 201','104000원','A-type1','210000원','A-type2','210000원'),('제주틴더타운','제주특별자치도제주시구좌읍행원리',10,'HOUSE 7','0원','HOUSE 4','120000원','HOUSE 8','270000원','HOUSE 1','290000원','HOUSE 6','290000원','HOUSE 10','290000원','HOUSE 9','290000원','HOUSE 2','380000원','','','',''),('풀빌라세도나중문풀빌라','제주특별자치도서귀포시색달동',9.7,'C타입','0원','A타입','310000원','B타입','310000원','','','','','','','','','','','','','',''),('풀빌라아쿠아뷰티크','월정리해변차량1분',9.6,'퀸베드 미니풀빌라 독채-조식 포함','270000원','패밀리형 미니풀빌라-조식 포함','310000원','','','','','','','','','','','','','','','',''),('풀빌라사무이제주풀빌라','애월해안도로차량4분',10,'A타입','0원','B타입','0원','','','','','','','','','','','','','','','',''),('풀빌라서귀포스마트풀빌라','제주특별자치도서귀포시표선면세화리',10,'스윗가든스파','0원','스탠다드테라스스파','87410원','프리미어 가든스파','148580원','로얄 풀빌라','200430원','플래티늄풀빌라','253800원','','','','','','','','','','');
/*!40000 ALTER TABLE `제주도펜션` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `제주도호텔`
--

DROP TABLE IF EXISTS `제주도호텔`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `제주도호텔` (
  `장소` text,
  `위치` text,
  `별점` double DEFAULT NULL,
  `방1` text,
  `가격1` text,
  `방2` text,
  `가격2` text,
  `방3` text,
  `가격3` text,
  `방4` text,
  `가격4` text,
  `방5` text,
  `가격5` text,
  `방6` text,
  `가격6` text,
  `방7` text,
  `가격7` text,
  `방8` text,
  `가격8` text,
  `방9` text,
  `가격9` text,
  `방10` text,
  `가격10` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `제주도호텔`
--

LOCK TABLES `제주도호텔` WRITE;
/*!40000 ALTER TABLE `제주도호텔` DISABLE KEYS */;
INSERT INTO `제주도호텔` VALUES ('5성급제주신라호텔','서귀포터미널차량17분',9.7,'스탠다드 마운틴 트윈','423500원','디럭스 마운틴 더블','459800원','디럭스 마운틴 트윈','459800원','스탠다드 가든 더블','459800원','스탠다드 가든 트윈','459800원','프리미어 마운틴 더블','484000원','디럭스 마운틴 패밀리 트윈','484000원','[2인 조식 또는 중식] 스탠다드 마운틴 트윈','511500원','[가족형] 스탠다드 테라스 가든','520300원','디럭스 오션 트윈','532400원'),('특급베스트웨스턴제주','제주특별자치도제주시노형동',9,'[안녕 제주! 주차불가 특가] 트리플','0원','[안녕 제주! 주차불가 특가] 스탠다드 트윈','65000원','[안녕 제주! 주차불가 특가] 스탠다드 더블','65000원','[안녕 제주! 주차불가 특가] 스탠다드 → 디럭...','65000원','[안녕 제주! 주차불가 특가] 스탠다드 온돌','70000원','[안녕 제주! 주차불가 특가] 디럭스 트윈','75000원','[안녕 제주! 주차불가 특가] 디럭스 패밀리 트윈','105000원','','','','','',''),('봄그리고가을호텔앤리조트','성산항차량5분',9.1,'[하프오션] 슈페리어 트윈','0원','[갓성비] 가든 패밀리 (정원뷰)','212000원','[강추] 주니어 스위트','219000원','프리미어 패밀리','237000원','[단체 추천] 프리미어 패밀리 골드','315000원','','','','','','','','','',''),('비지니스글로스터호텔제주','제주국제공항차량10분',9.3,'[2인 조식 포함] 트리플','0원','수페리어 트윈룸','71000원','수페리어 더블룸','71000원','디럭스 더블룸','76000원','디럭스 트윈룸','86000원','[특가] [무료 뷰UP] 디럭스 더블룸 (씨티뷰→...','86000원','[2인 조식 포함] 수페리어 트윈룸','97000원','[2인 조식 포함] 수페리어 더블룸','97000원','[노형 슈퍼마켓 입장권 2매 제공] 체크인 시 ...','97000원','[2인 조식 포함] 디럭스 더블룸','102000원'),('특급오션스위츠제주','제주특별자치도제주시삼도이동',9,'[단독! 무료룸UP] 코지트윈→스탠다드트윈 (싱...','88000원','스탠다드 트윈 (오션뷰)','99000원','디럭스 더블 (측면 오션뷰)','140000원','','','','','','','','','','','','','',''),('4성급신라스테이제주','제주특별자치도제주시연동',9.2,'스탠다드 더블','132000원','스탠다드 트윈','132000원','[LAZY 룸캉스] 스탠다드 더블','138600원','[LAZY 룸캉스] 스탠다드 트윈','138600원','디럭스 더블','141900원','[릴렉싱 나이트] 체크인 시 배정','141900원','패밀리 트윈','151800원','[치킨 TO-GO BOX] 스탠다드 더블','155100원','[피자 TO-GO BOX] 스탠다드 더블','155100원','[치킨 TO-GO BOX] 스탠다드 트윈','155100원'),('비지니스제주웨스턴그레이스호텔','서귀포터미널차량2분',9.3,'디럭스 더블','0원','[조식 1+1] 디럭스 더블','0원','디럭스 더블or트윈 랜덤배정','39000원','디럭스 트윈','40000원','패밀리 트윈','50000원','[조식 1+1] 디럭스 트윈','50000원','[넷플릭스 패키지] 디럭스 트윈','50000원','디럭스 트윈 (2인 조식)','60000원','디럭스 트윈 (1인 조식)','60000원','[조식 1+1] 패밀리 트윈','60000원'),('5성급해비치호텔리조트','표선해비치해변앞',9.3,'[특가] [리조트] 32평 원룸 스튜디오 트윈 (...','0원','[리조트] 32평 원룸 스튜디오 트윈','0원','[리조트] 32평 원룸스튜디오트윈 오션뷰','0원','[2인 조식] [리조트] 32평 원룸스튜디오트윈 ...','0원','[2인 조식] [호텔] 이그제큐티브 정면 오션뷰...','0원','[공동구매] [호텔] 슈페리어 빌리지 더블','314600원','[공동구매] [호텔] 슈페리어 빌리지 트윈','314600원','[공동구매] [리조트] 32평 투룸 디럭스 더블','314600원','[특가] [호텔] 슈페리어 빌리지 더블 (환불불가)','325248원','[특가] [호텔] 슈페리어 빌리지 트윈 (환불불가)','325248원'),('관광블루하와이호텔','협재해수욕장',8.9,'트윈룸 (한라산 전망)','55000원','트윈룸 (바다 전망)','60000원','','','','','','','','','','','','','','','',''),('특급더그랜드섬오름','한림공원차량5분',9.3,'[혼자도 좋아] [1인조식&음료] [신관] 슈페리...','132000원','[무료 룸업&조식] [신관] 슈페리어→디럭스 패...','132000원','[초특가! 음료 2잔] [신관] 슈페리어 트윈 (...','133100원','[초특가! 음료+인원추가] [본관] 패밀리 (오...','154000원','[초특가! 음료+인원추가] [본관] 패밀리룸 (...','169400원','[초특가! 음료+인원추가] [신관] 디럭스 패밀...','169400원','[초특가! 음료+인원추가] [신관] 디럭스 패밀...','169400원','[초특가! 음료+인원추가] [신관] 디럭스 패밀...','181500원','[초특가! 음료 2잔] [신관] 프리미어 패밀리 ...','266200원','[본관] 파노라마 스위트 B타입 (오션뷰)','319000원');
/*!40000 ALTER TABLE `제주도호텔` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'project'
--

--
-- Dumping routines for database 'project'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-04 22:26:08
