/*
Navicat MySQL Data Transfer

Source Server         : 120.79.191.7_3306
Source Server Version : 50722
Source Host           : 120.79.191.7:3306
Source Database       : cqutcrm

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-06-14 14:56:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `ctId` int(11) NOT NULL AUTO_INCREMENT,
  `cusNo` varchar(20) NOT NULL COMMENT '客户，外键',
  `ctName` varchar(50) NOT NULL COMMENT '联系人姓名',
  `ctTitle` varchar(50) NOT NULL COMMENT '职位',
  `ctGender` varchar(10) NOT NULL COMMENT '联系人性别',
  `ctPhone` varchar(50) NOT NULL COMMENT '联系人电话',
  `ctMemo` varchar(255) NOT NULL COMMENT '联系人备注',
  PRIMARY KEY (`ctId`),
  KEY `cusNo` (`cusNo`),
  CONSTRAINT `contact_ibfk_1` FOREIGN KEY (`cusNo`) REFERENCES `customer` (`cusNo`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('4', '90020', '12321', '21321', '女', '213', '123');
INSERT INTO `contact` VALUES ('8', '90001', '尹以操', '经理', '男', '17602338789', '爱好：玩儿');
INSERT INTO `contact` VALUES ('9', '90001', '尹以操', '经理', '男', '17602338789', '爱好：玩儿');
INSERT INTO `contact` VALUES ('10', '90001', '尹以操', '经理', '男', '17602338789', '爱好：玩儿');
INSERT INTO `contact` VALUES ('11', '90001', '尹以操', '经理', '男', '17602338789', '爱好：玩儿');
INSERT INTO `contact` VALUES ('12', '90001', '尹以操', '经理', '男', '17602338789', '爱好：玩儿');
INSERT INTO `contact` VALUES ('13', '90001', '尹以操', '经理', '男', '17602338789', '爱好：玩儿');
INSERT INTO `contact` VALUES ('17', '91621380217', '尹以操', '经理', '男', '17602338789', '爱好：玩儿');
INSERT INTO `contact` VALUES ('18', '91621380217', '尹以操', '经理', '男', '17602338789', '爱好：玩儿');
INSERT INTO `contact` VALUES ('20', '90001', '10', '1', '女', '11111110', '1');
INSERT INTO `contact` VALUES ('21', '90001', '陈鑫涛', '董事长', '男', '19922383350', '666');
INSERT INTO `contact` VALUES ('23', '90001', 'test', '1', '女', '1', '1');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cusId` int(11) NOT NULL AUTO_INCREMENT,
  `cusNo` varchar(20) NOT NULL,
  `cusName` varchar(50) NOT NULL,
  `cusRegion` varchar(20) NOT NULL,
  `cusAddr` varchar(100) NOT NULL,
  `cusUrl` varchar(50) NOT NULL,
  `cusLevel` varchar(20) NOT NULL,
  `cusCredit` tinyint(4) NOT NULL,
  PRIMARY KEY (`cusId`),
  KEY `cusNo` (`cusNo`),
  KEY `cusName` (`cusName`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '90001', '重庆理工', '东北', '重庆市巴南区花溪街道红光大道69号', 'http://www.cqut.edu.com', '战略合作伙伴', '4');
INSERT INTO `customer` VALUES ('5', '91621380217', '尹以操', '西南', '重庆市梁平区', 'cnblogs.com/hyyq', '普通客户', '4');
INSERT INTO `customer` VALUES ('13', '90002', '尹以操', '西南', '重庆市', 'yinyicao.work', '战略合作伙伴', '5');
INSERT INTO `customer` VALUES ('29', '90008', '尹以操', '西南', '重庆市', 'yinyicao.work', '战略合作伙伴', '5');
INSERT INTO `customer` VALUES ('30', '90009', '尹以操', '西南', '重庆市', 'yinyicao.work', '战略合作伙伴', '5');
INSERT INTO `customer` VALUES ('31', '90010', '尹以操', '西北', '重庆市', 'yinyicao.work', '战略合作伙伴', '5');
INSERT INTO `customer` VALUES ('33', '90012', '尹以操', '西南', '重庆市', 'yinyicao.work', '战略合作伙伴', '5');
INSERT INTO `customer` VALUES ('41', '90020', '123', '东北', '123', '123', '普通客户', '1');
INSERT INTO `customer` VALUES ('46', '123', '123', '华中', '123', 'test.com', 'VIP客户', '4');
INSERT INTO `customer` VALUES ('47', '123', '123', '华中', '123', 'test.com', 'VIP客户', '4');
INSERT INTO `customer` VALUES ('48', '123', '123', '西北', '123', 'test.com', 'VIP客户', '4');
INSERT INTO `customer` VALUES ('49', '123', '123', '华南', '123', 'test.com', 'VIP客户', '4');
INSERT INTO `customer` VALUES ('51', '90001', '陈鑫涛', '西南', '重庆市巴南区理工大学', 'www.cqvie.edu.cn', '战略合作伙伴', '5');
INSERT INTO `customer` VALUES ('52', '90025', '郭萍萍', '西南', '花溪', '保密', 'SSVIP', '5');
INSERT INTO `customer` VALUES ('53', '90026', '曾瑞', '东北', '卡卡个个', '保密', '合作伙伴', '5');
INSERT INTO `customer` VALUES ('54', '90027', '杨庆婷', '西北', '不知道', '保密', '大客户', '4');
INSERT INTO `customer` VALUES ('55', '90028', '谭茗芝', '华南', '南华', '密保', '大客户', '4');
INSERT INTO `customer` VALUES ('56', '90029', '罗以建', '华中', '浙江', '不知道', 'SSVIP', '3');
INSERT INTO `customer` VALUES ('57', '90030', '尹以操', '西南', '重庆', 'yyc.com', 'SSVIP', '5');
INSERT INTO `customer` VALUES ('58', '90031', '周敏', '华南', '重庆', 'zm.com', '合作伙伴', '4');
INSERT INTO `customer` VALUES ('59', '1', 'test', '华中', '1', '1', '战略合作伙伴', '4');
INSERT INTO `customer` VALUES ('60', '1', '1', '华中', '1', '1', '战略合作伙伴', '3');

-- ----------------------------
-- Table structure for saleorder
-- ----------------------------
DROP TABLE IF EXISTS `saleorder`;
CREATE TABLE `saleorder` (
  `saleId` int(10) NOT NULL AUTO_INCREMENT,
  `saleNo` varchar(50) NOT NULL,
  `proName` varchar(50) NOT NULL,
  `cusNo` varchar(20) NOT NULL,
  `proPrice` double(50,0) NOT NULL,
  `proNum` int(50) NOT NULL,
  `proTotal` double(50,0) NOT NULL,
  `proDate` date DEFAULT NULL,
  `proState` varchar(50) NOT NULL,
  PRIMARY KEY (`saleId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of saleorder
-- ----------------------------
INSERT INTO `saleorder` VALUES ('6', '1', '1', '1', '1', '1', '1', null, '1');
INSERT INTO `saleorder` VALUES ('7', '2', '2', '22', '2', '2', '2', '2019-06-14', '2');
INSERT INTO `saleorder` VALUES ('8', '123', '123', '', '123', '123', '123', '2019-06-06', '123');

-- ----------------------------
-- Table structure for service
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `svId` int(11) NOT NULL AUTO_INCREMENT,
  `svType` varchar(20) NOT NULL,
  `svContent` varchar(20) NOT NULL,
  `svDate` datetime NOT NULL,
  PRIMARY KEY (`svId`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service
-- ----------------------------
INSERT INTO `service` VALUES ('1', '咨询', '顶顶顶顶顶', '2019-06-11 13:40:52');
INSERT INTO `service` VALUES ('2', '咨询', '顶顶顶顶顶', '2019-06-11 13:43:07');
INSERT INTO `service` VALUES ('3', '投诉', '打算大苏打大大', '2019-06-11 13:46:00');
INSERT INTO `service` VALUES ('4', '建议', '打算大苏打大大', '2019-06-11 13:48:29');
INSERT INTO `service` VALUES ('5', '投诉', '顶顶顶顶顶顶顶顶顶', '2019-06-11 14:34:56');
INSERT INTO `service` VALUES ('6', '投诉', '1234', '2019-06-12 09:41:33');
INSERT INTO `service` VALUES ('7', '投诉', '1234', '2019-06-12 09:41:36');
INSERT INTO `service` VALUES ('8', '投诉', '1234', '2019-06-12 09:41:39');
INSERT INTO `service` VALUES ('9', '建议', '1234', '2019-06-12 09:41:43');
INSERT INTO `service` VALUES ('10', '建议', '1234', '2019-06-12 09:41:45');
INSERT INTO `service` VALUES ('11', '建议', '1234', '2019-06-12 09:41:47');
INSERT INTO `service` VALUES ('15', '建议', '12345', '2019-06-12 09:44:19');
INSERT INTO `service` VALUES ('16', '建议', '12345', '2019-06-12 09:44:23');
INSERT INTO `service` VALUES ('17', '建议', '12345', '2019-06-12 09:44:25');
INSERT INTO `service` VALUES ('18', '建议', '12345', '2019-06-12 09:44:27');
INSERT INTO `service` VALUES ('19', '咨询', '123', '2019-06-12 09:44:35');
INSERT INTO `service` VALUES ('20', '咨询', '123', '2019-06-12 09:44:45');
INSERT INTO `service` VALUES ('21', '咨询', '123', '2019-06-12 09:44:49');
INSERT INTO `service` VALUES ('22', '咨询', '1', '2019-06-12 15:48:22');
INSERT INTO `service` VALUES ('23', '咨询', '11', '2019-06-12 15:48:26');
INSERT INTO `service` VALUES ('24', '咨询', '1111', '2019-06-12 15:48:29');
INSERT INTO `service` VALUES ('25', '咨询', '111111', '2019-06-12 15:48:31');
INSERT INTO `service` VALUES ('26', '人工客服', '666666', '2019-06-12 18:16:35');
INSERT INTO `service` VALUES ('27', '人工客服', '666666', '2019-06-12 18:16:38');
INSERT INTO `service` VALUES ('28', '人工客服', '666666', '2019-06-12 18:16:40');
INSERT INTO `service` VALUES ('29', '人工客服', '666666', '2019-06-12 18:16:45');
INSERT INTO `service` VALUES ('30', '人工客服', '666666', '2019-06-12 18:16:47');
INSERT INTO `service` VALUES ('31', '人工客服', '666666', '2019-06-12 18:16:50');
INSERT INTO `service` VALUES ('32', '人工客服', '666666', '2019-06-12 18:16:53');
INSERT INTO `service` VALUES ('33', '人工客服', '666666', '2019-06-12 18:16:54');
INSERT INTO `service` VALUES ('34', '其他', '其他类型！！！', '2019-06-12 18:17:13');
INSERT INTO `service` VALUES ('35', '其他', '其他类型！！！', '2019-06-12 18:17:16');
INSERT INTO `service` VALUES ('36', '其他', '其他类型！！！', '2019-06-12 18:17:20');
INSERT INTO `service` VALUES ('37', '其他', '其他类型！！！', '2019-06-12 18:17:22');
INSERT INTO `service` VALUES ('38', '其他', '其他类型！！！', '2019-06-12 18:17:24');
INSERT INTO `service` VALUES ('39', '投诉', '123', '2019-06-13 10:28:46');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '将url带*号的权限放前面，sql用order by id desc查询，这样put进shiro权限才能有效',
  `name` varchar(255) NOT NULL,
  `permission` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '联系人管理', 'contact', '/home/contactService/*');
INSERT INTO `sys_permission` VALUES ('2', '订单管理', 'saleorder', '/home/saleorderService/*');
INSERT INTO `sys_permission` VALUES ('3', '服务管理', 'service', '/home/serviceService/*');
INSERT INTO `sys_permission` VALUES ('4', '客户管理', 'customer', '/home/customerService/*');
INSERT INTO `sys_permission` VALUES ('100', '客户查询', 'customer:view', '/home/customerService/get*');
INSERT INTO `sys_permission` VALUES ('101', '客户联系人查询', 'contact:view', '/home/contactService/get*');
INSERT INTO `sys_permission` VALUES ('102', '服务查询', 'service:view', '/home/serviceService/get*');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` int(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '管理员', 'admin');
INSERT INTO `sys_role` VALUES ('2', '1', '普通用户', 'user');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `permission_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('3', '1');
INSERT INTO `sys_role_permission` VALUES ('4', '1');
INSERT INTO `sys_role_permission` VALUES ('100', '2');
INSERT INTO `sys_role_permission` VALUES ('101', '2');
INSERT INTO `sys_role_permission` VALUES ('102', '2');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `role_id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '管理员', '798ec9149efe30fa4d114967aea3fbb2', '105bde19b6bf4bd1bd3376038e1a7c20', '1', 'admin');
INSERT INTO `user_info` VALUES ('2', '普通用户', '340a30f22780c83445f2ae6771e2bda5', '13edf7c57a864857a53108116f4a034d', '1', 'user');
