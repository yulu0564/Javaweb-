/*
Navicat MySQL Data Transfer

Source Server         : yulu
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-09-07 17:23:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_inf
-- ----------------------------
DROP TABLE IF EXISTS `user_inf`;
CREATE TABLE `user_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) NOT NULL,
  `PASSWORD` varchar(16) NOT NULL,
  `STATUS` int(11) NOT NULL DEFAULT '1',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(20) NOT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `head_image` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_inf
-- ----------------------------
INSERT INTO `user_inf` VALUES ('1', 'admin', '123456', '2', '2016-03-12 09:34:28', '超级管理员', null, null);
