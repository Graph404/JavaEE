/*
Navicat MySQL Data Transfer

Source Server         : mysql_localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : java2108

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2022-02-22 11:59:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for salgrade
-- ----------------------------
DROP TABLE IF EXISTS `salgrade`;
CREATE TABLE `salgrade` (
  `grade` decimal(10,0) NOT NULL,
  `losal` decimal(10,0) DEFAULT NULL,
  `hisal` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salgrade
-- ----------------------------
INSERT INTO `salgrade` VALUES ('1', '700', '1200');
INSERT INTO `salgrade` VALUES ('2', '1201', '1400');
INSERT INTO `salgrade` VALUES ('3', '1401', '2000');
INSERT INTO `salgrade` VALUES ('4', '2001', '3000');
INSERT INTO `salgrade` VALUES ('5', '3001', '9999');
