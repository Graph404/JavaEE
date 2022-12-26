/*
Navicat MySQL Data Transfer

Source Server         : mysql_localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : java2108

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2022-02-22 11:34:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(30) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('10', 'ACCOUNTING', 'NEW YORK');
INSERT INTO `dept` VALUES ('20', 'RESEARCH', 'DALLAS');
INSERT INTO `dept` VALUES ('30', 'SALES', 'CHICAGO');
INSERT INTO `dept` VALUES ('40', 'OPERATIONS', 'BOSTON');
INSERT INTO `dept` VALUES ('50', '人事部', 'WUHAN');
INSERT INTO `dept` VALUES ('60', '财务', 'cw');
