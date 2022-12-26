/*
Navicat MySQL Data Transfer

Source Server         : localhost.mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : java1912

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-07-02 17:58:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stuscore
-- ----------------------------
DROP TABLE IF EXISTS `stuscore`;
CREATE TABLE `stuscore` (
  `sno` int(11) DEFAULT NULL,
  `sname` varchar(30) DEFAULT NULL,
  `subject` varchar(30) DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stuscore
-- ----------------------------
INSERT INTO `stuscore` VALUES ('1', '张三', '数学', '90');
INSERT INTO `stuscore` VALUES ('2', '张三', '语文', '50');
INSERT INTO `stuscore` VALUES ('3', '张三', '地理', '40');
INSERT INTO `stuscore` VALUES ('4', '李四', '语文', '55');
INSERT INTO `stuscore` VALUES ('5', '李四', '政治', '45');
INSERT INTO `stuscore` VALUES ('6', '王五', '政治', '30');
INSERT INTO `stuscore` VALUES ('7', '李四', '数学', '80');
INSERT INTO `stuscore` VALUES ('8', '王五', '语文', '70');
