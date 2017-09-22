/*
Navicat MySQL Data Transfer

Source Server         : yulu
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-09-22 17:33:22
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('30', '特让人', '1', '而投入如果以后', '<p>提前儿童烫个头</p>', '特特', 'admin', '2017-09-19 17:05:55', '0');
INSERT INTO `news` VALUES ('31', '哪些城市居民存款多：6城市突破万亿大关，', '7', ' 哪些城市的市民存款最多?第一财经记者通过对29个重点城市的统计发现，有17个城市的住户存款超过了5000亿，6个城市的住户存款超过了1万亿大关。', '<p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\"><span class=\"Apple-converted-space\">&nbsp;</span>国家统计局发布的数据显示，2016年末住户存款余额为60.65万亿元，同比增长9.9%。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 哪些城市的市民存款最多?第一财经记者通过对29个重点城市的统计发现，有17个城市的住户存款超过了5000亿，6个城市的住户存款超过了1万亿大关。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 需要说明的是，由于部分重点城市如天津、沈阳、济南、大连等城市的住户存款数据对外公开部分搜集不能齐全，在此没有一并纳入统计。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 北上广领跑</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 住户存款，是指银行业金融机构通过信用方式吸收的居民储蓄存款及通过其他方式吸收的由住户部门(由住户和为其服务的非营利机构组成的部门)支配的存款，这是衡量民富的一个重要指标。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 这其中，京沪的住户存款余额都超过了2万亿大关，分别为2.8万亿和2.5万亿。上海和北京两大直辖市作为强一线城市，现代服务业最为发达。比如近几年我国平均工资最高的三大行业，一直是金融业和信息传输、软件和信息技术服务业以及科学研究和技术服务业。而上海和北京又恰好是这些高收入行业最为集中的地区。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 数据显示，京沪不仅是住户存款总量大，而且人均存款也排在前两位。以北京的住户存款余额，除以北京常住人口数量，去年北京人均存款约12.9万。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 京沪之后，南边的广州尽管近年来在金融业、互联网为代表的高新技术产业的发展势头不如北上深，但是民间富裕程度仍相当不错。数据显示，2016年广州住户存款总量达到了1.44万亿，位居第三位。人均存款也是位居第三，达到10.3万，与上海相当。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 北上广之后，西南的重庆和成都的住户存款总量也都突破了1万亿大关，分列第四和第五位，当然这两个城市的全域总人口较多，比如重庆有3000多万人口，成都也有1591万人。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 一线城市深圳的住户存款总量仅位居第六，深圳去年人均存款为8.7万，也是排在第六。不仅不如北上广，而且也比杭州和佛山少。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 深圳的住户存款总量和人均存款量较低，可能与深圳整体的投资氛围有关。数据显示，2016年深圳的住户贷款余额高达15022.07亿元，高居全国第二，也是少有的几个住户贷款余额大于住户存款余额的城市，贷款余额与存款余额之比高达145%。而住户贷款中，绝大部分都是住房按揭贷款。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 表1、29个城市住户存款余额</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"http://img1.gtimg.com/house/pics/hv1/187/73/2240/145674802.jpg\"/></p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　 数据来源：各地统计部门公布的2016年统计公报及人民银行支行报告数据</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; border: 0px; vertical-align: baseline; word-wrap: break-word; font-family: &quot;Microsoft YaHei&quot;; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">　　<strong style=\"margin: 0px; padding: 0px; border: 0px; vertical-align: baseline;\"><span class=\"Apple-converted-space\">&nbsp;</span>人均存款：东高西低</strong></p><p><br/></p>', '第一财经日报', 'admin', '2017-09-19 17:07:50', '0');
INSERT INTO `news` VALUES ('32', '也同样也', '1', '申达股份付付付付付付付付', '<p><span style=\"font-size: 36px;\">和和法规和和规范化个胡国富合格后</span></p><p><span style=\"font-size: 36px;\">浩哥</span></p><p><span style=\"font-size: 36px;\"><br/></span></p><p><span style=\"font-size: 36px;\"><span style=\"font-size: 16px;\">合格后浩哥</span><br/></span></p><p><span style=\"font-size: 36px;\"><span style=\"font-size: 16px;\">浩哥</span></span></p>', '同仁堂', 'admin', '2017-09-21 09:37:58', '0');
INSERT INTO `news` VALUES ('33', '曝勇士险被火箭挖角 伊戈达拉差点就加盟休', '1', ' 勇士今夏连续续约库里、杜兰特、伊戈达拉、帕楚利亚和利文斯顿等人，保留了超级强大的阵容班底。但实际上，勇士留下伊戈达拉的过程非常惊险，后者差一点就决定和火箭签约。', '<p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">（文/Chris Haynes ESPN撰稿人）<span class=\"Apple-converted-space\">&nbsp;</span><a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/team/?id=warriors\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">勇士</a>今夏连续续约<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/player/?id=4612\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">库里</a>、<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/player/?id=4244\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">杜兰特</a>、伊戈达拉、帕楚利亚和利文斯顿等人，保留了超级强大的阵容班底。但实际上，勇士留下伊戈达拉的过程非常惊险，后者差一点就决定和<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/team/?id=rockets\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">火箭</a>签约。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\"><img alt=\"曝勇士险被火箭挖角 伊戈达拉差点就加盟休城\" src=\"http://img1.gtimg.com/sports/pics/hv1/248/201/2240/145707503.jpeg\"/></p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">上赛季帮助勇士夺冠后，伊戈达拉成为完全自由球员，受到了<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/team/?id=lakers\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">湖人</a>、<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/team/?id=spurs\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">马刺</a>、<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/team/?id=kings\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">国王</a>、火箭、<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/team/?id=clippers\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">快船</a>、<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/team/?id=jazz\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">爵士</a>和<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/team/?id=sixers\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">76人</a>等多支球队的追逐。而勇士最初只提供了3年3600万美元的报价，这让伊戈达拉相当不满。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">伊戈达拉作为球员工会副主席，他需要起到表率作用，力争大合同，让自己的价值得到最大化的体现。尤其是在2013年，伊戈达拉加盟勇士，签署的仅仅是一份4年4800万美元的“打折价”合同，他更加希望能够得到一份符合自己身价的合同。当时，伊戈达拉和他的代表们向勇士表态，他们不会接受均薪低于1600万美元的合同。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">与此同时，火箭积极招募伊戈达拉，同他进行了会面。当时的老板亚历山大、总经理莫雷、总经理助理罗萨斯、主帅德<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/player/?id=3706\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">安东尼</a>和CEO布朗组成了火箭的招募团队，他们向伊戈达拉描述，如果有他加盟，火箭就能在系列赛中击败勇士。莫雷还告诉伊戈达拉，如果加盟火箭，他会省下更多的钱，得州没有州税，休斯敦的生活消费水平相对湾区也要更低。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">德安东尼则向伊戈达拉展示了火箭的快速进攻理念，还强调了球队将提升防守，认为<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/player/?id=3930\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">保罗</a>、<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/player/?id=4469\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">戈登</a>、<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/player/?id=3860\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">阿里扎</a>和伊戈达拉能组成恐怖的四人组，快速轮转，挡住对手的凶猛进攻。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">知情人透露，伊戈达拉对火箭阵营的表述印象深刻，并且沉浸其中。而之后发生的事情，更拉近了伊戈达拉和休斯敦的距离。在会谈中，莫雷的电话响了，是<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/player/?id=4563\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">哈登</a>打过来的，他并不知道莫雷当时正在和伊戈达拉见面。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">哈登只是因为一件小事来找莫雷，他为自己打断他们的会面感到抱歉。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">“没关系。”莫雷说道，“我随时随刻都会接你的电话。”</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">之后，哈登让莫雷把电话给伊戈达拉，他没有直接劝说伊戈达拉来火箭，而是再次对自己打断会谈做出了道歉。在电话挂断前，哈登祝贺伊戈达拉一切好运。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">在会谈重新开始后，刚刚加盟火箭4天的保罗突然现身，他冲进会议室，加入到了火箭的招募团队中。对此，伊戈达拉和他的团队深感惊讶。在约20分钟的时间里，保罗对火箭大加赞扬，称球队非常开放。保罗的陈述，深深吸引了伊戈达拉。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">火箭当时没有薪资空间，能够提供最大的合同为4年3200万美元。但莫雷有足够的筹码，能够用先签后换的方式得到伊戈达拉。在与火箭会谈后，伊戈达拉取消了与快船、<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/team/?id=timberwolves\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">森林狼</a>、76人和爵士等队的会面，开始考虑先签后换加盟火箭的可行性。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">“火箭完成了史上最棒的招募工作。”伊戈达拉阵营中的一名成员说道。火箭虽然没有得到伊戈达拉的加盟承诺，但对得到2015年总决赛MVP有十足的信心。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">伊戈达拉本来计划和勇士主帅科尔和总经理迈尔斯坐下来会谈，告诉他们自己打算离开勇士加盟火箭的决定。伊戈达拉经纪人向迈尔斯打去了最后一个电话，询问对方是否能提高合同报价。迈尔斯迅速请示老板后，然后将合同提高到了3年4800万美元。</p><p style=\"margin-top: 0px; margin-bottom: 28px; padding: 0px; word-wrap: break-word; font-family: &quot;Microsoft Yahei&quot;, Helvetica, sans-serif; line-height: 28px; white-space: normal; widows: 1; text-indent: 2em; background-color: rgb(255, 255, 255);\">尽管联手哈登和保罗非常诱人，但在得到满意的续约合同后，伊戈达拉最终决定留在金州，他可以继续和库里、杜兰特、格林和<a class=\"a-tips-Article-QQ\" href=\"http://nba.stats.qq.com/player/?id=4892\" target=\"_blank\" style=\"text-decoration-line: none; outline: 0px; color: rgb(0, 0, 0); border-bottom: 1px dotted rgb(83, 109, 166);\">汤普森</a>并肩作战，有机会争取卫冕，开创王朝。一波三折之后，勇士还是保住了他们看起来无法被击败的超强核心阵容。（肖恩）</p><p><br/></p>', '腾讯体育', 'admin', '2017-09-21 10:15:43', '0');

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
  `isdelete` int(1) NOT NULL,
  `email` varchar(25) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `ident` int(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_inf
-- ----------------------------
INSERT INTO `user_inf` VALUES ('1', 'admin', '123456', '2', '2016-03-12 09:34:28', '超级管理员', null, null, '0', null, null, null, '0');
