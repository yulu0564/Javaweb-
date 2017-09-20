/*
Navicat MySQL Data Transfer

Source Server         : yulu
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-09-20 17:30:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collects
-- ----------------------------
DROP TABLE IF EXISTS `collects`;
CREATE TABLE `collects` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) NOT NULL,
  `newsid` int(10) NOT NULL,
  `isdelete` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_collects_user` (`userid`),
  KEY `FK_collects_news` (`newsid`),
  CONSTRAINT `FK_collects_news` FOREIGN KEY (`newsid`) REFERENCES `news` (`id`),
  CONSTRAINT `FK_collects_user` FOREIGN KEY (`userid`) REFERENCES `user_inf` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='收藏表';

-- ----------------------------
-- Records of collects
-- ----------------------------

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `newsid` int(11) NOT NULL,
  `replyid` int(11) DEFAULT NULL,
  `contects` varchar(100) NOT NULL,
  `time` varchar(50) NOT NULL,
  `isdelete` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_comments_user` (`userid`),
  KEY `FK_comments_news` (`newsid`),
  KEY `FK_comments_reply` (`replyid`),
  CONSTRAINT `FK_comments_news` FOREIGN KEY (`newsid`) REFERENCES `news` (`id`),
  CONSTRAINT `FK_comments_reply` FOREIGN KEY (`replyid`) REFERENCES `reply` (`id`),
  CONSTRAINT `FK_comments_user` FOREIGN KEY (`userid`) REFERENCES `user_inf` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `sort` int(1) NOT NULL,
  `digest` varchar(500) NOT NULL,
  `contect` varchar(10000) NOT NULL,
  `fromto` varchar(20) DEFAULT NULL,
  `fromuser` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `isdelete` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `news-sort` (`sort`),
  CONSTRAINT `news-sort` FOREIGN KEY (`sort`) REFERENCES `sort` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('30', '特让人', '1', '而投入如果以后', '<p>提前儿童烫个头</p>', '特特', 'admin', '2017-09-19 17:05:55', '0');
INSERT INTO `news` VALUES ('31', '哪些城市居民存款多：6城市突破万亿大关，', '7', ' 哪些城市的市民存款最多?第一财经记者通过对29个重点城市的统计发现，有17个城市的住户存款超过了5000亿，6个城市的住户存款超过了1万亿大关。', '<p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\"><span class=\"Apple-converted-space\">&nbsp;</span>国家统计局发布的数据显示，2016年末住户存款余额为60.65万亿元，同比增长9.9%。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 哪些城市的市民存款最多?第一财经记者通过对29个重点城市的统计发现，有17个城市的住户存款超过了5000亿，6个城市的住户存款超过了1万亿大关。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 需要说明的是，由于部分重点城市如天津、沈阳、济南、大连等城市的住户存款数据对外公开部分搜集不能齐全，在此没有一并纳入统计。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 北上广领跑</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 住户存款，是指银行业金融机构通过信用方式吸收的居民储蓄存款及通过其他方式吸收的由住户部门(由住户和为其服务的非营利机构组成的部门)支配的存款，这是衡量民富的一个重要指标。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 这其中，京沪的住户存款余额都超过了2万亿大关，分别为2.8万亿和2.5万亿。上海和北京两大直辖市作为强一线城市，现代服务业最为发达。比如近几年我国平均工资最高的三大行业，一直是金融业和信息传输、软件和信息技术服务业以及科学研究和技术服务业。而上海和北京又恰好是这些高收入行业最为集中的地区。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 数据显示，京沪不仅是住户存款总量大，而且人均存款也排在前两位。以北京的住户存款余额，除以北京常住人口数量，去年北京人均存款约12.9万。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 京沪之后，南边的广州尽管近年来在金融业、互联网为代表的高新技术产业的发展势头不如北上深，但是民间富裕程度仍相当不错。数据显示，2016年广州住户存款总量达到了1.44万亿，位居第三位。人均存款也是位居第三，达到10.3万，与上海相当。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 北上广之后，西南的重庆和成都的住户存款总量也都突破了1万亿大关，分列第四和第五位，当然这两个城市的全域总人口较多，比如重庆有3000多万人口，成都也有1591万人。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 一线城市深圳的住户存款总量仅位居第六，深圳去年人均存款为8.7万，也是排在第六。不仅不如北上广，而且也比杭州和佛山少。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 深圳的住户存款总量和人均存款量较低，可能与深圳整体的投资氛围有关。数据显示，2016年深圳的住户贷款余额高达15022.07亿元，高居全国第二，也是少有的几个住户贷款余额大于住户存款余额的城市，贷款余额与存款余额之比高达145%。而住户贷款中，绝大部分都是住房按揭贷款。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 表1、29个城市住户存款余额</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"http://img1.gtimg.com/house/pics/hv1/187/73/2240/145674802.jpg\"/></p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 数据来源：各地统计部门公布的2016年统计公报及人民银行支行报告数据</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　<strong style=\"margin: 0px; padding: 0px; border: 0px; vertical-align: baseline;\"><span class=\"Apple-converted-space\">&nbsp;</span>人均存款：东高西低</strong></p><p><br/></p>', '第一财经日报', 'admin', '2017-09-19 17:07:50', '0');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `contects` varchar(200) NOT NULL DEFAULT '0',
  `time` varchar(50) DEFAULT '0',
  `isdelete` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_reply_user` (`userid`),
  CONSTRAINT `FK_reply_user` FOREIGN KEY (`userid`) REFERENCES `user_inf` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sortname` varchar(20) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `isdelete` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES ('1', '体育', '体育新闻', '0');
INSERT INTO `sort` VALUES ('2', '娱乐', '娱乐类新闻', '0');
INSERT INTO `sort` VALUES ('3', '教育', '教育新闻', '0');
INSERT INTO `sort` VALUES ('4', '科技', '科技类', '0');
INSERT INTO `sort` VALUES ('5', '热点', '头条热点', '0');
INSERT INTO `sort` VALUES ('6', '法律', '法律新闻', '0');
INSERT INTO `sort` VALUES ('7', '社会', '国际社会', '0');

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
