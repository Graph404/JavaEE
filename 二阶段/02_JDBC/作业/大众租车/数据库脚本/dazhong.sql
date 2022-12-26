/*
Navicat MySQL Data Transfer

Source Server         : mysql_localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db01

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2022-05-13 19:53:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_brand
-- ----------------------------
INSERT INTO `t_brand` VALUES ('2', '大众');
INSERT INTO `t_brand` VALUES ('4', '奔驰');
INSERT INTO `t_brand` VALUES ('3', '奥迪');
INSERT INTO `t_brand` VALUES ('5', '宝马');
INSERT INTO `t_brand` VALUES ('1', '标致');

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_number` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `model` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `color` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `t_comments` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double(11,1) NOT NULL,
  `rent` double(9,2) DEFAULT NULL,
  `status` int(1) DEFAULT '0',
  `useable` int(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_number` (`car_number`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '沪A11C32', '2', '郎逸', '红色', '2', '自动1.6L', '140000.0', '78.00', '0', '1');
INSERT INTO `t_car` VALUES ('2', '沪B0000', '2', '途观', '黑色', '3', '自动1.8T', '220000.0', '200.00', '0', '0');
INSERT INTO `t_car` VALUES ('3', '沪A1686', '3', 'A4L', '红色', '4', '自动2.0T', '400000.0', '359.00', '0', '0');
INSERT INTO `t_car` VALUES ('4', '沪D11C32', '1', '308', '黑色', '1', '手动1.6L', '130000.0', '56.00', '0', '0');
INSERT INTO `t_car` VALUES ('5', '沪E11C99', '1', '308S', '蓝色', '2', '自动1.2T', '160000.0', '70.00', '0', '0');
INSERT INTO `t_car` VALUES ('6', '沪F11C21', '2', '高尔夫', '红色', '1', '自动1.4T', '200000.0', '69.00', '0', '0');
INSERT INTO `t_car` VALUES ('7', '沪F1324', '5', '320Li', '白色', '4', '自动2.0T', '380000.0', '999.00', '0', '0');
INSERT INTO `t_car` VALUES ('8', '沪F6666', '4', 'B200', '黑色', '4', '自动1.6T', '320000.0', '300.00', '0', '0');
INSERT INTO `t_car` VALUES ('9', '泸B666', '2', '速腾', '黑色', '2', '自动1.6T', '14500.0', '70.00', '0', '0');
INSERT INTO `t_car` VALUES ('11', '鄂A666666', '2', 'A4L', '红色', '2', '自动3.5T', '260000.0', '666.00', '0', '0');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('3', 'SUV');
INSERT INTO `t_category` VALUES ('4', '精英型');
INSERT INTO `t_category` VALUES ('1', '紧凑型');
INSERT INTO `t_category` VALUES ('2', '舒适型');

-- ----------------------------
-- Table structure for t_record
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `return_date` datetime DEFAULT NULL,
  `payment` double(9,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_record
-- ----------------------------
INSERT INTO `t_record` VALUES ('1', '2', '2', '2017-01-24 00:00:00', '2017-01-26 00:00:00', '400.00');
INSERT INTO `t_record` VALUES ('2', '3', '4', '2017-02-20 00:00:00', '2017-02-28 00:00:00', '448.00');
INSERT INTO `t_record` VALUES ('3', '4', '5', '2017-03-01 00:00:00', '2017-03-03 00:00:00', '210.00');
INSERT INTO `t_record` VALUES ('4', '1', '1', '2017-03-02 00:00:00', '2017-03-06 00:00:00', '288.00');
INSERT INTO `t_record` VALUES ('8', '5', '5', '2021-03-27 15:22:05', '2021-03-28 15:25:07', '70.00');
INSERT INTO `t_record` VALUES ('13', '2', '9', '2021-03-30 13:39:11', '2021-03-30 13:45:22', '70.00');
INSERT INTO `t_record` VALUES ('14', '2', '1', '2021-04-01 19:00:06', '2021-04-01 19:00:41', '78.00');
INSERT INTO `t_record` VALUES ('24', '2', '2', '2021-04-10 09:19:43', '2021-04-10 09:20:41', '200.00');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `sex` int(1) DEFAULT '0',
  `id_number` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tel` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addr` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` int(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'xiaoming', '111111', '0', '15647641312345', '1515445554', '江苏', '0');
INSERT INTO `t_user` VALUES ('2', 'tom', '111111', '0', '15647641312346', '1515445555', '日本', '0');
INSERT INTO `t_user` VALUES ('3', 'lucy', '111111', '0', '15647641312347', '1515445556', '上海', '0');
INSERT INTO `t_user` VALUES ('4', 'sam', '111111', '0', '15647641312348', '1515445557', '北京', '0');
INSERT INTO `t_user` VALUES ('5', 'leo', '111111', '0', '15647641312349', '1515445558', '深圳', '0');
INSERT INTO `t_user` VALUES ('6', 'marry', '111111', '0', '15647641312340', '1515445559', '南京', '1');
INSERT INTO `t_user` VALUES ('7', 'admin', 'admin', '0', null, null, null, '1');
INSERT INTO `t_user` VALUES ('17', '123', '123', '1', '123456', '123456', '中国', '0');
