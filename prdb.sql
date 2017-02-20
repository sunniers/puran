/*
Navicat MySQL Data Transfer

Source Server         : prdb
Source Server Version : 50621
Source Host           : 192.168.1.251:3306
Source Database       : prdb

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-11-24 09:41:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `assessment_audit`
-- ----------------------------
DROP TABLE IF EXISTS `assessment_audit`;
CREATE TABLE `assessment_audit` (
  `audit_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '审核ID',
  `assessment_id` bigint(20) DEFAULT NULL COMMENT '评估ID',
  `back_user_id` int(11) DEFAULT NULL COMMENT '审核的后台用户ID',
  `audit_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_content` varchar(255) DEFAULT NULL COMMENT '审核内容',
  `audit_status` int(11) DEFAULT NULL COMMENT '审核状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='专业评估审核';

-- ----------------------------
-- Records of assessment_audit
-- ----------------------------
INSERT INTO `assessment_audit` VALUES ('2', '2', '1', '2016-11-07 10:25:02', null, '400703', '');
INSERT INTO `assessment_audit` VALUES ('8', '1', '1', '2016-11-14 16:38:33', null, '400702', '');
INSERT INTO `assessment_audit` VALUES ('14', '3', null, '2016-11-14 17:02:54', null, '400703', '');
INSERT INTO `assessment_audit` VALUES ('15', '4', null, '2016-11-14 17:04:45', null, '400702', '');
INSERT INTO `assessment_audit` VALUES ('16', '3', null, '2016-11-14 17:06:20', null, '400702', '');
INSERT INTO `assessment_audit` VALUES ('17', '2', '1', '2016-11-14 18:38:11', null, '400703', '');
INSERT INTO `assessment_audit` VALUES ('18', '3', '1', '2016-11-17 19:07:02', null, '400702', '');

-- ----------------------------
-- Table structure for `back_roles`
-- ----------------------------
DROP TABLE IF EXISTS `back_roles`;
CREATE TABLE `back_roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '后台角色ID',
  `role_name` varchar(30) DEFAULT NULL COMMENT '后台角色名',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='后台用户角色';

-- ----------------------------
-- Records of back_roles
-- ----------------------------
INSERT INTO `back_roles` VALUES ('3', '管理员', '2016-11-09 09:08:40', '');
INSERT INTO `back_roles` VALUES ('4', '管理员', '2016-11-09 09:49:36', '');
INSERT INTO `back_roles` VALUES ('5', '管理员', '2016-11-09 09:50:19', '');
INSERT INTO `back_roles` VALUES ('6', '管理员', '2016-11-09 09:50:44', '');

-- ----------------------------
-- Table structure for `back_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `back_role_resource`;
CREATE TABLE `back_role_resource` (
  `role_res_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '后台角色系统资源关系ID',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '系统资源ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '后台角色ID',
  PRIMARY KEY (`role_res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='后台角色系统资源映射';

-- ----------------------------
-- Records of back_role_resource
-- ----------------------------
INSERT INTO `back_role_resource` VALUES ('1', '1', '3');
INSERT INTO `back_role_resource` VALUES ('2', '2', '3');
INSERT INTO `back_role_resource` VALUES ('3', '3', '3');
INSERT INTO `back_role_resource` VALUES ('4', '4', '3');
INSERT INTO `back_role_resource` VALUES ('5', '5', '3');
INSERT INTO `back_role_resource` VALUES ('6', '6', '3');
INSERT INTO `back_role_resource` VALUES ('7', '7', '3');
INSERT INTO `back_role_resource` VALUES ('8', '8', '3');
INSERT INTO `back_role_resource` VALUES ('9', '9', '3');
INSERT INTO `back_role_resource` VALUES ('10', '10', '3');
INSERT INTO `back_role_resource` VALUES ('11', '11', '3');
INSERT INTO `back_role_resource` VALUES ('12', '12', '3');
INSERT INTO `back_role_resource` VALUES ('13', '13', '3');
INSERT INTO `back_role_resource` VALUES ('14', '14', '3');
INSERT INTO `back_role_resource` VALUES ('15', '15', '3');
INSERT INTO `back_role_resource` VALUES ('16', '16', '3');
INSERT INTO `back_role_resource` VALUES ('17', '17', '3');
INSERT INTO `back_role_resource` VALUES ('18', '20', '3');
INSERT INTO `back_role_resource` VALUES ('19', '21', '3');
INSERT INTO `back_role_resource` VALUES ('20', '22', '3');
INSERT INTO `back_role_resource` VALUES ('21', '23', '3');
INSERT INTO `back_role_resource` VALUES ('22', '24', '3');
INSERT INTO `back_role_resource` VALUES ('23', '25', '3');
INSERT INTO `back_role_resource` VALUES ('24', '26', '3');
INSERT INTO `back_role_resource` VALUES ('25', '27', '3');
INSERT INTO `back_role_resource` VALUES ('26', '28', '3');
INSERT INTO `back_role_resource` VALUES ('27', '29', '3');
INSERT INTO `back_role_resource` VALUES ('28', '30', '3');
INSERT INTO `back_role_resource` VALUES ('29', '31', '3');
INSERT INTO `back_role_resource` VALUES ('30', '32', '3');
INSERT INTO `back_role_resource` VALUES ('31', '33', '3');
INSERT INTO `back_role_resource` VALUES ('32', '34', '3');
INSERT INTO `back_role_resource` VALUES ('33', '35', '3');
INSERT INTO `back_role_resource` VALUES ('34', '36', '3');
INSERT INTO `back_role_resource` VALUES ('35', '37', '3');
INSERT INTO `back_role_resource` VALUES ('36', '38', '3');
INSERT INTO `back_role_resource` VALUES ('37', '39', '3');
INSERT INTO `back_role_resource` VALUES ('38', '40', '3');
INSERT INTO `back_role_resource` VALUES ('39', '41', '3');
INSERT INTO `back_role_resource` VALUES ('40', '42', '3');
INSERT INTO `back_role_resource` VALUES ('41', '43', '3');
INSERT INTO `back_role_resource` VALUES ('42', '44', '3');
INSERT INTO `back_role_resource` VALUES ('43', '45', '3');
INSERT INTO `back_role_resource` VALUES ('44', '46', '3');

-- ----------------------------
-- Table structure for `back_user`
-- ----------------------------
DROP TABLE IF EXISTS `back_user`;
CREATE TABLE `back_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '后台用户ID',
  `user_name` varchar(30) DEFAULT NULL COMMENT '后台用户名',
  `user_alias` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `user_pwd` varchar(40) DEFAULT NULL COMMENT '后台用户密码',
  `user_department` varchar(100) DEFAULT NULL COMMENT '部门',
  `user_mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `user_email` varchar(100) DEFAULT NULL COMMENT '用户邮箱',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建日期',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='后台用户';

-- ----------------------------
-- Records of back_user
-- ----------------------------
INSERT INTO `back_user` VALUES ('3', '545898817', null, '681BE1589455F52EE5394C3DE0B695DC', null, null, null, '2016-11-08 20:47:51', '');
INSERT INTO `back_user` VALUES ('4', 'admin', '23323223', '21232F297A57A5A743894A0E4A801FC3', null, null, null, '2016-11-09 09:56:58', '');
INSERT INTO `back_user` VALUES ('5', 'sd', 'dsds', 'dsds', null, null, null, '2016-11-23 18:32:16', '');
INSERT INTO `back_user` VALUES ('6', 'gds123456', null, 'F6F344CBBB36A1E18975CF814B2717E8', null, null, null, '2016-11-11 14:01:24', '');

-- ----------------------------
-- Table structure for `back_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `back_user_role`;
CREATE TABLE `back_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '后台用户角色ID',
  `user_id` int(11) DEFAULT NULL COMMENT '后台用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='后台用户角色关系';

-- ----------------------------
-- Records of back_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `ceative_resource_transaction`
-- ----------------------------
DROP TABLE IF EXISTS `ceative_resource_transaction`;
CREATE TABLE `ceative_resource_transaction` (
  `resource_transaction_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意资源交易ID',
  `creative_resource_id` bigint(20) DEFAULT NULL COMMENT '创意资源ID',
  `buy_user_id` bigint(20) DEFAULT NULL COMMENT '交易者ID',
  `transaction_number` int(11) DEFAULT NULL COMMENT '交易数量',
  `transaction_price` decimal(10,2) DEFAULT NULL COMMENT '交易单价',
  `transaction_money` decimal(10,2) DEFAULT NULL COMMENT '交易金额',
  `transaction_datetime` datetime DEFAULT NULL COMMENT '交易时间',
  `transaction_status` int(11) DEFAULT NULL COMMENT '交易状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`resource_transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='创意资源交易';

-- ----------------------------
-- Records of ceative_resource_transaction
-- ----------------------------
INSERT INTO `ceative_resource_transaction` VALUES ('1', '1', '2', '222', '222.00', '222.00', '2016-11-08 13:07:00', '400505', '');
INSERT INTO `ceative_resource_transaction` VALUES ('2', '1', '2', '313', '333.00', '333.00', '2016-11-17 11:19:41', '400504', '');
INSERT INTO `ceative_resource_transaction` VALUES ('3', '2', '8', '444', '444.00', '444.00', '2016-11-17 11:22:06', '400505', '');

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公司ID',
  `company_name` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `company_corporation` varchar(50) DEFAULT NULL COMMENT '公司法人',
  `organizational_institution_code` varchar(200) DEFAULT NULL COMMENT '组织机构代码',
  `company_address` varchar(500) DEFAULT NULL COMMENT '公司地址',
  `company_phone` varchar(50) DEFAULT NULL COMMENT '公司电话',
  `company_type` varchar(50) DEFAULT NULL COMMENT '公司分类',
  `company_trade` varchar(200) DEFAULT NULL COMMENT '公司行业',
  `company_introduce` varchar(2000) DEFAULT NULL COMMENT '公司介绍',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='公司';

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '公司名称1', '123123', '213213123', '123', '123', null, null, '123', '');
INSERT INTO `company` VALUES ('2', 'gds', 'fairen', '1223321asd312', null, null, null, null, null, '');
INSERT INTO `company` VALUES ('3', '1', '法人', '组织机构代码', null, '1', null, null, null, '');

-- ----------------------------
-- Table structure for `company_credit`
-- ----------------------------
DROP TABLE IF EXISTS `company_credit`;
CREATE TABLE `company_credit` (
  `credit_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '证件ID',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司ID',
  `credit_name` varchar(200) DEFAULT NULL COMMENT '证件名称',
  `credit_type` varchar(40) DEFAULT NULL COMMENT '证件类型',
  `credit_filename` varchar(100) DEFAULT NULL COMMENT '证件文件名',
  `credit_front_path` varchar(200) DEFAULT NULL COMMENT '证件正面文件路径',
  `credit_back_path` varchar(200) DEFAULT NULL COMMENT '证件反面文件路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`credit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='公司证件';

-- ----------------------------
-- Records of company_credit
-- ----------------------------
INSERT INTO `company_credit` VALUES ('1', '1', null, null, '8371420161114045339', 'cai1', 'ghj', '2016-11-08 11:17:17');
INSERT INTO `company_credit` VALUES ('2', '1', null, null, '7494520161114045339', 'sdf', 'cai2', '2016-11-14 11:18:00');
INSERT INTO `company_credit` VALUES ('3', '3', null, null, '6214520161114045339', 'cai3', 'dsds', '2016-11-14 11:18:03');

-- ----------------------------
-- Table structure for `create_resource_warehouse`
-- ----------------------------
DROP TABLE IF EXISTS `create_resource_warehouse`;
CREATE TABLE `create_resource_warehouse` (
  `stock_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '库存ID',
  `create_resource_id` bigint(20) DEFAULT NULL COMMENT '资源ID',
  `stock_count` int(11) DEFAULT NULL COMMENT '库存数量',
  `resource_type` int(11) DEFAULT NULL COMMENT '资源类型',
  `in_stock_time` datetime DEFAULT NULL COMMENT '入库时间',
  `update_time` datetime DEFAULT NULL COMMENT '最近更新时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='库存';

-- ----------------------------
-- Records of create_resource_warehouse
-- ----------------------------
INSERT INTO `create_resource_warehouse` VALUES ('1', '1', '40', '700005', '2016-11-14 09:50:32', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('2', '2', '8', '700005', '2016-11-14 09:59:39', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('3', '3', '20', '700005', '2016-11-14 10:09:38', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('4', '4', '20', '700005', '2016-11-14 10:09:42', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('5', '5', '20', '700005', '2016-11-14 10:09:43', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('6', '36', '20', '700005', '2016-11-14 13:25:13', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('7', '37', '20', '700005', '2016-11-17 20:16:34', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('8', '38', '20', '700005', '2016-11-17 20:16:45', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('9', '39', '321', '700005', '2016-11-17 20:16:49', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('10', null, null, null, '2016-11-19 22:25:21', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('11', '10', '5', '700005', '2016-11-20 14:58:26', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('12', '1', '0', null, '2016-11-21 19:47:18', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('13', '6', '20', null, '2016-11-21 19:49:09', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('14', '7', '5', null, '2016-11-21 19:49:22', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('15', '8', '5', null, '2016-11-21 19:56:42', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('16', '9', '5', null, '2016-11-21 19:56:56', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('17', '11', '5', null, '2016-11-21 20:12:31', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('18', '12', '5', null, '2016-11-21 20:13:33', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('19', '1', null, '700005', '2016-11-23 16:12:35', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('20', '34', null, '700005', '2016-11-23 16:16:15', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('21', '34', null, '700005', '2016-11-23 16:19:34', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('22', '37', null, '700005', '2016-11-23 16:20:53', null, '');
INSERT INTO `create_resource_warehouse` VALUES ('23', '55', null, '700005', '2016-11-23 17:24:47', null, '');

-- ----------------------------
-- Table structure for `creative_resource`
-- ----------------------------
DROP TABLE IF EXISTS `creative_resource`;
CREATE TABLE `creative_resource` (
  `creative_resource_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意资源ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '创意资源所有者ID',
  `resource_name` varchar(200) DEFAULT NULL COMMENT '创意资源名称',
  `resource_image_name` varchar(50) DEFAULT NULL COMMENT '创意资源图片名称',
  `resource_image` varchar(200) DEFAULT NULL COMMENT '创意资源图片路径',
  `resource_number` int(11) DEFAULT NULL COMMENT '创意资源数量',
  `resource_description` varchar(1000) DEFAULT NULL COMMENT '创意资源描述',
  `show_address` varchar(500) DEFAULT NULL COMMENT '创意资源演示地址',
  `resource_attach` varchar(200) DEFAULT NULL COMMENT '创意资源附件',
  `resource_attach_see` varchar(200) DEFAULT NULL COMMENT '创意资源附件预览',
  `resource_attach_name` varchar(50) DEFAULT NULL COMMENT '创意资源附件名称',
  `resource_currency` int(11) DEFAULT NULL COMMENT '创意资源币种',
  `resource_price` decimal(10,2) DEFAULT NULL COMMENT '创意资源价格',
  `resource_status` int(11) DEFAULT NULL COMMENT '创意资源状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`creative_resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8 COMMENT='创意资源';

-- ----------------------------
-- Records of creative_resource
-- ----------------------------
INSERT INTO `creative_resource` VALUES ('1', '1', '资源交易00641', null, 'file/testfiles/1479202929690Desert_middlejpg.JPEG', '20', '资源交易描述2', '演示地址url1', '资源附件地址1', null, null, null, '9911239.99', '401203', '', '2016-11-14 14:57:13');
INSERT INTO `creative_resource` VALUES ('2', '1', '资源交易0063', null, 'file/testfiles/1479202929690Desert_middlejpg.JPEG', '20', '资源交易描述1', 'http://ditu.baidu.com', '资源附件地址', null, null, null, '999.99', '401206', '', '2016-11-17 16:07:56');
INSERT INTO `creative_resource` VALUES ('3', '1', '资源交易0003', null, 'file/testfiles/1479202929690Desert_middlejpg.JPEG', '20', '资源交易描述', '演示地址url', '资源附件地址', null, null, null, '999.99', '401203', '', '2016-11-10 15:57:18');
INSERT INTO `creative_resource` VALUES ('4', '1', '资源交易0004', null, 'file/testfiles/1479202929690Desert_middlejpg.JPEG', '20', '资源交易描述', 'null', '资源附件地址', null, null, null, '999.99', '401203', '', '2016-11-17 16:07:40');
INSERT INTO `creative_resource` VALUES ('5', '1', '资源交易0005', null, 'file/testfiles/1479202929690Desert_middlejpg.JPEG', '20', '资源交易描述', 'null', '资源附件地址', null, null, null, '999.99', '401205', '', '2016-11-17 16:08:00');
INSERT INTO `creative_resource` VALUES ('6', '1', '资源交易0006', null, 'file/testfiles/1479202929690Desert_middlejpg.JPEG', '20', '资源交易描述', '演示地址url', '资源附件地址', null, null, null, '999.99', '401203', '', '2016-11-11 09:48:21');
INSERT INTO `creative_resource` VALUES ('19', '1', '资源交易00060000000000000000', null, 'file/testfiles/1479202929690Desert_middlejpg.JPEG', '20', '资源交易描述', '演示地址url', null, null, null, null, '999.99', '401205', '', '2016-11-11 16:47:51');
INSERT INTO `creative_resource` VALUES ('20', '1', '资源交易0064', null, 'resources/images/front/QRcode.JPG', '20', '资源交易描述1', 'http://baike.baidu.com', null, null, null, null, '999.99', '401203', '', '2016-11-16 17:35:38');
INSERT INTO `creative_resource` VALUES ('21', '1', '资源交易0064', null, '图片地址url1', '20', '资源交易描述1', '演示地址url1', null, null, null, null, '999.99', '401206', '', '2016-11-16 17:35:41');
INSERT INTO `creative_resource` VALUES ('22', '2', '资源交易0011', null, 'http://localhost:8080/resources/images/front/QRcode.JPG', '20', '资源交易描述', 'baidu.com', '资源附件地址', null, null, null, '999.99', '401203', '', '2016-11-09 19:53:36');
INSERT INTO `creative_resource` VALUES ('23', '2', '资源交易0012', '图片mingc', '图片地址url', '20', '资源交易描述', '演示地址url', '资源附件地址', null, null, null, '999.99', '401201', '', '2016-11-09 19:53:42');
INSERT INTO `creative_resource` VALUES ('33', '1', '资源交易00060000000000000000', null, '图片地址url', '20', '资源交易描述', '演示地址url', null, null, null, null, '999.99', '401201', '', '2016-11-10 09:56:27');
INSERT INTO `creative_resource` VALUES ('34', '1', '资源交易00060000000000000000', null, '图片地址url', '20', '资源交易描述', '演示地址url', null, null, null, null, '999.99', '0', '', '2016-11-16 20:28:04');
INSERT INTO `creative_resource` VALUES ('35', '1', '资源交易0014', null, '图片地址url', '20', '资源交易描述', '演示地址url', '资源附件地址', null, null, null, '999.99', '401201', '', '2016-11-11 15:14:54');
INSERT INTO `creative_resource` VALUES ('36', '1', '资源交易0014', null, '图片地址url', '20', '资源交易描述', '演示地址url', '资源附件地址', null, null, null, '999.99', '401206', '', '2016-11-17 11:25:18');
INSERT INTO `creative_resource` VALUES ('37', '1', '资源交易00642', '图片名称', '图片地址url11', '20', '资源交易描述2', '演示地址url1', '资源附件地址1', '资源附件地址2', '资源附件名称', null, '999.99', '401203', '', '2016-11-16 20:28:38');
INSERT INTO `creative_resource` VALUES ('38', '1', '321', 'imageName', 'undefined', '321', '321', '321', null, null, null, null, '321.00', '401204', '', '2016-11-16 20:28:54');
INSERT INTO `creative_resource` VALUES ('39', '1', '123', 'imageName', 'undefined', '123', '123', '123', null, null, null, null, '123.00', '401201', '', '2016-11-14 15:24:08');
INSERT INTO `creative_resource` VALUES ('40', '1', '12321', 'imageName', 'file/1479202291946mima.png', '123', '123', '123', null, null, null, null, '123.00', '401201', '', '2016-11-15 17:35:31');
INSERT INTO `creative_resource` VALUES ('41', '1', '12321', 'imageName', 'file/1479202291946mima.png', '123', '123', '123', null, null, null, null, '123.00', '401204', '', '2016-11-15 17:36:28');
INSERT INTO `creative_resource` VALUES ('42', '1', '12321', 'imageName', 'file/1479202291946mima.png', '123', '123', '123', null, null, null, null, '123.00', '401204', '', '2016-11-15 17:37:04');
INSERT INTO `creative_resource` VALUES ('43', '1', '资源交易1111111', null, '图片地址url', '20', '资源交易描述', '演示地址url', '资源附件地址', null, null, null, '999.99', '401201', '', '2016-11-15 17:46:23');
INSERT INTO `creative_resource` VALUES ('44', '1', '资源交易1111111', null, '图片地址url', '20', '资源交易描述', '演示地址url', '资源附件地址', null, null, null, '999.99', '401204', '', '2016-11-15 17:47:10');
INSERT INTO `creative_resource` VALUES ('45', '1', '111', 'imageName', 'file/1479204334949后台登录LOGO.jpg', '11', '11111', '111', null, null, null, null, '11.00', '401202', '', '2016-11-15 18:08:25');
INSERT INTO `creative_resource` VALUES ('46', '1', '111', 'imageName', 'file/1479204334949后台登录LOGO.jpg', '11', '11111', '111', null, null, null, null, '11.00', '401201', '', '2016-11-15 18:08:55');
INSERT INTO `creative_resource` VALUES ('47', '1', '111', 'imageName', 'file/1479204334949后台登录LOGO.jpg', '11', '11111', '111', null, null, null, null, '11.00', '401202', '', '2016-11-15 18:09:06');
INSERT INTO `creative_resource` VALUES ('48', '1', '资源交易0011111100', null, '图片地址url000', '20', '资源交易描述', '演示地址url', '资源附件地址', null, null, null, '999.99', '401201', '', '2016-11-16 16:35:53');
INSERT INTO `creative_resource` VALUES ('49', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:19:24');
INSERT INTO `creative_resource` VALUES ('50', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:19:52');
INSERT INTO `creative_resource` VALUES ('51', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:19:54');
INSERT INTO `creative_resource` VALUES ('52', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:19:54');
INSERT INTO `creative_resource` VALUES ('53', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:19:54');
INSERT INTO `creative_resource` VALUES ('54', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401204', '', '2016-11-16 18:19:55');
INSERT INTO `creative_resource` VALUES ('55', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401203', '', '2016-11-16 18:19:56');
INSERT INTO `creative_resource` VALUES ('56', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401202', '', '2016-11-16 18:19:57');
INSERT INTO `creative_resource` VALUES ('57', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401202', '', '2016-11-16 18:19:57');
INSERT INTO `creative_resource` VALUES ('58', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401202', '', '2016-11-16 18:19:57');
INSERT INTO `creative_resource` VALUES ('59', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:19:58');
INSERT INTO `creative_resource` VALUES ('60', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:19:58');
INSERT INTO `creative_resource` VALUES ('61', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:19:59');
INSERT INTO `creative_resource` VALUES ('62', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:19:59');
INSERT INTO `creative_resource` VALUES ('63', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:19:59');
INSERT INTO `creative_resource` VALUES ('64', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:20:04');
INSERT INTO `creative_resource` VALUES ('65', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:20:04');
INSERT INTO `creative_resource` VALUES ('66', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:20:04');
INSERT INTO `creative_resource` VALUES ('67', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:20:05');
INSERT INTO `creative_resource` VALUES ('68', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:20:05');
INSERT INTO `creative_resource` VALUES ('69', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:20:05');
INSERT INTO `creative_resource` VALUES ('70', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:20:05');
INSERT INTO `creative_resource` VALUES ('71', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:20:06');
INSERT INTO `creative_resource` VALUES ('72', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401201', '', '2016-11-16 18:20:07');
INSERT INTO `creative_resource` VALUES ('73', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401202', '', '2016-11-16 18:20:08');
INSERT INTO `creative_resource` VALUES ('74', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401202', '', '2016-11-16 18:20:08');
INSERT INTO `creative_resource` VALUES ('75', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401202', '', '2016-11-16 18:20:08');
INSERT INTO `creative_resource` VALUES ('76', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401202', '', '2016-11-16 18:20:08');
INSERT INTO `creative_resource` VALUES ('77', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401202', '', '2016-11-16 18:20:39');
INSERT INTO `creative_resource` VALUES ('78', '2', 'test3', 'imageName', 'Tulips.jpg', '10', 'wewq', '', null, null, null, null, '10000.00', '401202', '', '2016-11-16 18:20:40');
INSERT INTO `creative_resource` VALUES ('79', '1', '111111111', 'imageName', 'file/1479299872000我的项目3.png', '1111', '111111111', '', null, null, null, null, '11111.00', '401201', '', '2016-11-16 20:37:10');
INSERT INTO `creative_resource` VALUES ('80', '1', '111111111', 'imageName', 'file/1479299872000我的项目3.png', '1111', '111111111', '', null, null, null, null, '11111.00', '401202', '', '2016-11-16 20:37:13');
INSERT INTO `creative_resource` VALUES ('81', '1', '111111111', 'imageName', 'file/1479299872000我的项目3.png', '1111', '111111111', '', null, null, null, null, '11111.00', '401202', '', '2016-11-16 20:37:15');
INSERT INTO `creative_resource` VALUES ('82', '1', 'touxiang', 'imageName', 'f1fc22d4f2e102995d08b27b6fd90291.jpg', '22', 'erere', 'http://www.baidu.com', null, null, null, null, '999.99', '401201', '', '2016-11-17 09:17:17');
INSERT INTO `creative_resource` VALUES ('83', '1', 'touxiang', 'imageName', 'f1fc22d4f2e102995d08b27b6fd90291.jpg', '22', 'erere', 'http://www.baidu.com', null, null, null, null, '999.99', '401201', '', '2016-11-17 09:18:08');
INSERT INTO `creative_resource` VALUES ('84', '1', 'touxiang', 'imageName', 'f1fc22d4f2e102995d08b27b6fd90291.jpg', '22', 'erere', 'http://www.baidu.com', null, null, null, null, '999.99', '401202', '', '2016-11-17 09:18:10');
INSERT INTO `creative_resource` VALUES ('85', '1', 'touxiang', 'imageName', 'f1fc22d4f2e102995d08b27b6fd90291.jpg', '22', 'erere', 'http://www.baidu.com', null, null, null, null, '999.99', '401202', '', '2016-11-17 09:18:12');
INSERT INTO `creative_resource` VALUES ('86', '1', 'ttututu', 'imageName', 'f1fc22d4f2e102995d08b27b6fd90291.jpg', '1', 'dsafa', 'http://ss', null, null, null, null, '99.33', '401202', '', '2016-11-17 09:35:11');
INSERT INTO `creative_resource` VALUES ('87', '1', '12321', 'imageName', 'mima.png', '3213', '123213', '1231', null, null, null, null, '123.00', '401202', '', '2016-11-17 18:51:46');
INSERT INTO `creative_resource` VALUES ('88', '1', '测试', 'mima.png', 'file/files/1479379983402.png', '1', '哈哈哈', 'www.baidu.com', null, null, null, null, '100.00', '401202', '', '2016-11-17 18:53:25');
INSERT INTO `creative_resource` VALUES ('89', '1', 'person01资源', '我的项目3.png', 'file/files/1479446177370.png', '45', '概况需求暂时不明确自己想象一下', 'http:baidu.com', null, null, null, null, '568.00', '401201', '', '2016-11-18 13:16:51');
INSERT INTO `creative_resource` VALUES ('90', '1', 'person01资源', '我的项目3.png', 'file/files/1479446177370.png', '45', '概况需求暂时不明确自己想象一下', 'http:baidu.com', null, null, null, null, '568.00', '401202', '', '2016-11-18 13:16:55');
INSERT INTO `creative_resource` VALUES ('91', '1', '资源类型', 'preloader.gif', 'file/files/1479872708106.gif', '15', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '150.00', '401201', '', '2016-11-23 11:44:47');
INSERT INTO `creative_resource` VALUES ('92', '1', '资源类型', 'preloader.gif', 'file/files/1479872708106.gif', '15', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '150.00', '401201', '', '2016-11-23 11:44:49');
INSERT INTO `creative_resource` VALUES ('93', '1', '资源类型', 'preloader.gif', 'file/files/1479872708106.gif', '15', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '150.00', '401202', '', '2016-11-23 11:44:51');
INSERT INTO `creative_resource` VALUES ('94', '1', '资源类型', 'preloader.gif', 'file/files/1479872708106.gif', '15', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '150.00', '401201', '', '2016-11-23 11:44:52');
INSERT INTO `creative_resource` VALUES ('95', '1', '资源类型', 'preloader.gif', 'file/files/1479872708106.gif', '15', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '150.00', '401201', '', '2016-11-23 11:45:26');
INSERT INTO `creative_resource` VALUES ('96', '1', '资源类型', 'preloader.gif', 'file/files/1479872708106.gif', '15', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '150.00', '401202', '', '2016-11-23 11:45:27');
INSERT INTO `creative_resource` VALUES ('97', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '546.00', '401201', '', '2016-11-23 11:46:14');
INSERT INTO `creative_resource` VALUES ('98', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '546.00', '401201', '', '2016-11-23 11:46:15');
INSERT INTO `creative_resource` VALUES ('99', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '546.00', '401201', '', '2016-11-23 11:46:16');
INSERT INTO `creative_resource` VALUES ('100', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '546.00', '401202', '', '2016-11-23 11:46:19');
INSERT INTO `creative_resource` VALUES ('101', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '546.00', '401202', '', '2016-11-23 11:46:20');
INSERT INTO `creative_resource` VALUES ('102', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '546.00', '401202', '', '2016-11-23 11:46:20');
INSERT INTO `creative_resource` VALUES ('103', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '546.00', '401202', '', '2016-11-23 11:46:20');
INSERT INTO `creative_resource` VALUES ('104', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '546.00', '401202', '', '2016-11-23 11:46:21');
INSERT INTO `creative_resource` VALUES ('105', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '546.00', '401202', '', '2016-11-23 11:46:21');
INSERT INTO `creative_resource` VALUES ('106', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '546.00', '401201', '', '2016-11-23 11:46:24');
INSERT INTO `creative_resource` VALUES ('107', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '述需求概述需求概述需求概述需求概述', 'http://baidu.com', null, null, null, null, '546.00', '401201', '', '2016-11-23 11:46:24');
INSERT INTO `creative_resource` VALUES ('108', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '1', 'http://baidu.com', null, null, null, null, '546.00', '401201', '', '2016-11-23 11:46:31');
INSERT INTO `creative_resource` VALUES ('109', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '1', 'http://baidu.com', null, null, null, null, '546.00', '401201', '', '2016-11-23 11:46:32');
INSERT INTO `creative_resource` VALUES ('110', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '1', 'http://baidu.com', null, null, null, null, '546.00', '401201', '', '2016-11-23 11:46:32');
INSERT INTO `creative_resource` VALUES ('111', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '1', 'http://baidu.com', null, null, null, null, '546.00', '401201', '', '2016-11-23 11:46:32');
INSERT INTO `creative_resource` VALUES ('112', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '1', 'http://baidu.com', null, null, null, null, '546.00', '401201', '', '2016-11-23 11:46:33');
INSERT INTO `creative_resource` VALUES ('113', '1', '资源名称123456', 'preloader.gif', 'file/files/1479872807375.gif', '156', '1', 'http://baidu.com', null, null, null, null, '546.00', '401202', '', '2016-11-23 11:46:33');
INSERT INTO `creative_resource` VALUES ('114', '1', '测试111111', '后台登录LOGO.jpg', 'file/files/1479891501400.jpg', '123', '12312312312', '123', null, null, null, null, '123.00', '401202', '', '2016-11-23 16:58:41');
INSERT INTO `creative_resource` VALUES ('115', '1', 'ceshi13213', '后台登录LOGO.jpg', 'file/files/1479891710226.jpg', '3213', 'das大多数是生生世世生生世世生生世世生生世世', '321321321', null, null, null, null, '3213.00', '401202', '', '2016-11-23 17:02:08');
INSERT INTO `creative_resource` VALUES ('116', '1', '123', '后台登录LOGO.jpg', 'file/files/1479891739599.jpg', '123', '123', '123', null, null, null, null, '123.00', '401202', '', '2016-11-23 17:02:32');
INSERT INTO `creative_resource` VALUES ('117', '1', '321', '登录 (1).png', 'file/files/1479891789398.png', '123', '123', '123', null, null, null, null, '123.00', '401202', '', '2016-11-23 17:03:23');
INSERT INTO `creative_resource` VALUES ('118', '1', '这里是一个发布跳转测试', '后台登录LOGO.jpg', 'file/files/1479891812560.jpg', '123', '123', '123', null, null, null, null, '123.00', '401202', '', '2016-11-23 17:03:53');
INSERT INTO `creative_resource` VALUES ('119', '1', '这个是保存测试', '后台登录LOGO.jpg', 'file/files/1479892139602.jpg', '12', '123123213', '12', null, null, null, null, '12.00', '401201', '', '2016-11-23 17:09:21');

-- ----------------------------
-- Table structure for `creative_resource_audit`
-- ----------------------------
DROP TABLE IF EXISTS `creative_resource_audit`;
CREATE TABLE `creative_resource_audit` (
  `audit_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意资源审核ID',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '创意资源ID',
  `back_user_id` int(11) DEFAULT NULL COMMENT '审核的后台用户ID',
  `audit_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_content` varchar(200) DEFAULT NULL COMMENT '审核内容',
  `audit_status` int(11) DEFAULT NULL COMMENT '审核状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='创意资源审核';

-- ----------------------------
-- Records of creative_resource_audit
-- ----------------------------
INSERT INTO `creative_resource_audit` VALUES ('1', '1', null, '2016-11-09 12:08:39', null, '400702', '');
INSERT INTO `creative_resource_audit` VALUES ('2', '1', null, '2016-11-11 14:12:38', null, '400702', '');
INSERT INTO `creative_resource_audit` VALUES ('3', '1', '4', '2016-11-23 16:12:35', null, '400702', '');
INSERT INTO `creative_resource_audit` VALUES ('4', '34', '4', '2016-11-23 16:16:15', null, '400703', '');
INSERT INTO `creative_resource_audit` VALUES ('5', '34', '4', '2016-11-23 16:19:34', null, '0', '');
INSERT INTO `creative_resource_audit` VALUES ('6', '37', '4', '2016-11-23 16:20:53', null, '400702', '');
INSERT INTO `creative_resource_audit` VALUES ('7', '38', '4', '2016-11-23 17:07:09', null, '400703', '');
INSERT INTO `creative_resource_audit` VALUES ('8', '41', '4', '2016-11-23 17:20:03', null, '400703', '');
INSERT INTO `creative_resource_audit` VALUES ('9', '54', '4', '2016-11-23 17:24:24', null, '400703', '');
INSERT INTO `creative_resource_audit` VALUES ('10', '55', '4', '2016-11-23 17:24:47', null, '400702', '');
INSERT INTO `creative_resource_audit` VALUES ('11', '42', '4', '2016-11-23 17:25:06', null, '400703', '');
INSERT INTO `creative_resource_audit` VALUES ('12', '44', '4', '2016-11-23 17:25:20', null, '400703', '');

-- ----------------------------
-- Table structure for `creative_resource_classifier`
-- ----------------------------
DROP TABLE IF EXISTS `creative_resource_classifier`;
CREATE TABLE `creative_resource_classifier` (
  `classifier_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意资源类型ID',
  `creative_resource_id` bigint(20) DEFAULT NULL COMMENT '创意资源ID',
  `classifier_value` int(11) DEFAULT NULL COMMENT '创意资源类型值',
  PRIMARY KEY (`classifier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=893 DEFAULT CHARSET=utf8 COMMENT='创意资源类型';

-- ----------------------------
-- Records of creative_resource_classifier
-- ----------------------------
INSERT INTO `creative_resource_classifier` VALUES ('9', '3', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('10', '3', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('11', '3', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('12', '3', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('13', '4', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('14', '4', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('15', '4', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('16', '4', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('17', '5', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('18', '5', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('19', '5', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('20', '5', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('21', '6', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('22', '6', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('23', '6', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('24', '6', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('25', '7', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('26', '7', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('27', '7', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('28', '7', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('29', '8', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('30', '8', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('31', '8', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('32', '8', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('33', '9', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('34', '9', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('35', '9', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('36', '9', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('37', '10', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('38', '10', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('39', '10', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('40', '10', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('41', '52', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('42', '52', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('43', '52', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('50', '2', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('51', '2', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('52', '2', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('53', '11', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('54', '11', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('55', '11', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('56', '11', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('57', '12', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('58', '12', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('59', '12', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('60', '12', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('61', '13', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('62', '13', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('63', '13', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('64', '13', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('65', '14', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('66', '14', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('67', '14', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('68', '14', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('69', '15', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('70', '15', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('71', '15', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('72', '15', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('73', '16', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('74', '16', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('75', '16', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('76', '16', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('77', '17', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('78', '17', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('79', '17', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('80', '17', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('81', '18', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('82', '18', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('83', '18', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('84', '18', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('144', '20', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('145', '20', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('146', '20', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('150', '21', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('151', '21', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('152', '21', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('162', '22', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('163', '22', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('164', '22', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('165', '22', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('166', '23', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('167', '23', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('168', '23', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('169', '23', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('170', '24', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('171', '24', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('172', '24', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('173', '24', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('174', '25', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('175', '25', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('176', '25', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('177', '25', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('178', '26', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('179', '26', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('180', '26', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('181', '26', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('182', '27', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('183', '27', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('184', '27', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('185', '27', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('186', '28', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('187', '28', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('188', '28', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('189', '28', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('190', '29', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('191', '29', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('192', '29', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('193', '29', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('194', '30', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('195', '30', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('196', '30', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('197', '30', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('198', '31', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('199', '31', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('200', '31', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('201', '31', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('213', '32', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('214', '32', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('215', '32', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('216', '32', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('217', '19', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('218', '19', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('219', '19', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('220', '19', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('221', '33', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('282', '35', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('283', '35', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('284', '35', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('285', '35', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('286', '36', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('287', '36', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('288', '36', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('289', '36', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('306', '1', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('307', '1', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('308', '1', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('330', '39', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('331', '39', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('332', '40', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('333', '40', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('334', '41', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('335', '41', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('336', '42', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('337', '42', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('338', '43', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('339', '43', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('340', '43', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('341', '43', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('342', '44', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('343', '44', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('344', '44', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('345', '44', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('346', '45', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('347', '45', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('348', '46', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('349', '46', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('350', '47', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('351', '47', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('352', '48', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('353', '48', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('354', '48', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('355', '48', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('356', '49', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('357', '50', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('358', '51', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('359', '52', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('360', '53', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('361', '54', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('362', '55', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('363', '56', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('364', '57', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('365', '58', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('366', '59', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('367', '60', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('368', '61', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('369', '62', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('370', '63', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('371', '64', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('372', '65', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('373', '66', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('374', '67', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('375', '68', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('376', '69', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('377', '70', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('378', '71', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('379', '72', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('380', '73', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('381', '74', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('382', '75', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('383', '76', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('384', '77', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('385', '78', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('386', '34', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('387', '34', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('388', '34', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('389', '34', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('390', '34', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('391', '34', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('392', '34', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('393', '34', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('394', '34', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('395', '34', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('396', '34', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('397', '34', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('398', '34', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('399', '34', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('400', '34', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('401', '34', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('403', '37', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('404', '37', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('405', '37', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('406', '37', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('407', '37', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('408', '37', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('409', '37', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('410', '37', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('411', '37', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('412', '37', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('413', '37', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('414', '37', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('415', '37', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('416', '37', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('417', '37', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('418', '37', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('419', '37', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('420', '38', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('421', '79', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('422', '79', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('423', '79', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('424', '79', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('425', '79', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('426', '79', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('427', '79', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('428', '79', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('429', '79', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('430', '79', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('431', '79', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('432', '79', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('433', '79', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('434', '79', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('435', '79', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('436', '79', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('437', '79', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('438', '80', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('439', '80', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('440', '80', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('441', '80', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('442', '80', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('443', '80', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('444', '80', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('445', '80', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('446', '80', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('447', '80', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('448', '80', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('449', '80', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('450', '80', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('451', '80', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('452', '80', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('453', '80', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('454', '80', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('455', '81', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('456', '81', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('457', '81', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('458', '81', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('459', '81', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('460', '81', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('461', '81', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('462', '81', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('463', '81', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('464', '81', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('465', '81', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('466', '81', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('467', '81', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('468', '81', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('469', '81', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('470', '81', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('471', '81', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('472', '82', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('473', '82', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('474', '83', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('475', '83', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('476', '84', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('477', '84', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('478', '85', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('479', '85', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('480', '86', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('481', '87', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('482', '87', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('483', '88', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('484', '88', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('485', '89', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('486', '89', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('487', '89', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('488', '89', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('489', '90', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('490', '90', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('491', '90', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('492', '90', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('493', '91', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('494', '91', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('495', '91', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('496', '91', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('497', '92', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('498', '92', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('499', '92', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('500', '92', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('501', '93', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('502', '93', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('503', '93', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('504', '93', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('505', '94', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('506', '94', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('507', '94', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('508', '94', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('509', '95', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('510', '95', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('511', '95', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('512', '95', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('513', '96', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('514', '96', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('515', '96', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('516', '96', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('517', '97', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('518', '97', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('519', '97', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('520', '97', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('521', '97', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('522', '97', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('523', '97', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('524', '97', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('525', '97', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('526', '97', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('527', '97', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('528', '97', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('529', '97', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('530', '97', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('531', '97', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('532', '97', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('533', '97', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('534', '98', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('535', '98', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('536', '98', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('537', '98', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('538', '98', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('539', '98', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('540', '98', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('541', '98', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('542', '98', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('543', '98', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('544', '98', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('545', '98', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('546', '98', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('547', '98', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('548', '98', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('549', '98', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('550', '98', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('551', '99', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('552', '99', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('553', '99', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('554', '99', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('555', '99', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('556', '99', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('557', '99', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('558', '99', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('559', '99', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('560', '99', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('561', '99', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('562', '99', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('563', '99', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('564', '99', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('565', '99', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('566', '99', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('567', '99', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('568', '100', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('569', '100', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('570', '100', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('571', '100', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('572', '100', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('573', '100', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('574', '100', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('575', '100', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('576', '100', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('577', '100', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('578', '100', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('579', '100', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('580', '100', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('581', '100', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('582', '100', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('583', '100', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('584', '100', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('585', '101', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('586', '101', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('587', '101', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('588', '101', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('589', '101', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('590', '101', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('591', '101', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('592', '101', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('593', '101', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('594', '101', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('595', '101', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('596', '101', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('597', '101', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('598', '101', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('599', '101', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('600', '101', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('601', '101', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('602', '102', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('603', '102', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('604', '102', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('605', '102', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('606', '102', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('607', '102', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('608', '102', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('609', '102', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('610', '102', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('611', '102', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('612', '102', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('613', '102', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('614', '102', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('615', '102', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('616', '102', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('617', '102', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('618', '102', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('619', '103', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('620', '103', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('621', '103', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('622', '103', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('623', '103', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('624', '103', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('625', '103', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('626', '103', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('627', '103', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('628', '103', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('629', '103', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('630', '103', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('631', '103', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('632', '103', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('633', '103', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('634', '103', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('635', '103', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('636', '104', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('637', '104', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('638', '104', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('639', '104', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('640', '104', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('641', '104', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('642', '104', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('643', '104', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('644', '104', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('645', '104', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('646', '104', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('647', '104', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('648', '104', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('649', '104', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('650', '104', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('651', '104', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('652', '104', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('653', '105', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('654', '105', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('655', '105', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('656', '105', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('657', '105', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('658', '105', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('659', '105', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('660', '105', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('661', '105', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('662', '105', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('663', '105', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('664', '105', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('665', '105', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('666', '105', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('667', '105', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('668', '105', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('669', '105', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('670', '106', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('671', '106', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('672', '106', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('673', '106', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('674', '106', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('675', '106', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('676', '106', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('677', '106', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('678', '106', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('679', '106', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('680', '106', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('681', '106', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('682', '106', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('683', '106', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('684', '106', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('685', '106', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('686', '106', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('687', '107', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('688', '107', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('689', '107', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('690', '107', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('691', '107', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('692', '107', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('693', '107', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('694', '107', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('695', '107', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('696', '107', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('697', '107', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('698', '107', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('699', '107', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('700', '107', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('701', '107', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('702', '107', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('703', '107', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('704', '108', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('705', '108', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('706', '108', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('707', '108', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('708', '108', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('709', '108', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('710', '108', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('711', '108', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('712', '108', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('713', '108', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('714', '108', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('715', '108', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('716', '108', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('717', '108', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('718', '108', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('719', '108', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('720', '108', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('721', '109', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('722', '109', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('723', '109', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('724', '109', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('725', '109', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('726', '109', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('727', '109', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('728', '109', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('729', '109', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('730', '109', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('731', '109', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('732', '109', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('733', '109', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('734', '109', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('735', '109', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('736', '109', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('737', '109', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('738', '110', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('739', '110', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('740', '110', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('741', '110', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('742', '110', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('743', '110', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('744', '110', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('745', '110', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('746', '110', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('747', '110', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('748', '110', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('749', '110', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('750', '110', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('751', '110', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('752', '110', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('753', '110', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('754', '110', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('755', '111', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('756', '111', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('757', '111', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('758', '111', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('759', '111', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('760', '111', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('761', '111', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('762', '111', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('763', '111', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('764', '111', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('765', '111', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('766', '111', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('767', '111', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('768', '111', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('769', '111', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('770', '111', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('771', '111', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('772', '112', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('773', '112', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('774', '112', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('775', '112', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('776', '112', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('777', '112', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('778', '112', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('779', '112', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('780', '112', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('781', '112', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('782', '112', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('783', '112', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('784', '112', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('785', '112', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('786', '112', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('787', '112', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('788', '112', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('789', '113', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('790', '113', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('791', '113', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('792', '113', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('793', '113', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('794', '113', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('795', '113', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('796', '113', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('797', '113', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('798', '113', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('799', '113', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('800', '113', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('801', '113', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('802', '113', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('803', '113', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('804', '113', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('805', '113', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('806', '114', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('807', '114', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('808', '115', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('809', '115', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('810', '115', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('811', '115', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('812', '115', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('813', '115', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('814', '115', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('815', '115', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('816', '115', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('817', '115', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('818', '115', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('819', '115', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('820', '115', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('821', '115', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('822', '115', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('823', '115', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('824', '115', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('825', '116', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('826', '116', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('827', '116', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('828', '116', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('829', '116', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('830', '116', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('831', '116', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('832', '116', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('833', '116', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('834', '116', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('835', '116', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('836', '116', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('837', '116', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('838', '116', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('839', '116', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('840', '116', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('841', '116', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('842', '117', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('843', '117', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('844', '117', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('845', '117', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('846', '117', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('847', '117', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('848', '117', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('849', '117', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('850', '117', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('851', '117', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('852', '117', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('853', '117', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('854', '117', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('855', '117', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('856', '117', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('857', '117', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('858', '117', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('859', '118', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('860', '118', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('861', '118', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('862', '118', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('863', '118', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('864', '118', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('865', '118', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('866', '118', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('867', '118', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('868', '118', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('869', '118', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('870', '118', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('871', '118', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('872', '118', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('873', '118', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('874', '118', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('875', '118', '200403');
INSERT INTO `creative_resource_classifier` VALUES ('876', '119', '200101');
INSERT INTO `creative_resource_classifier` VALUES ('877', '119', '200105');
INSERT INTO `creative_resource_classifier` VALUES ('878', '119', '200102');
INSERT INTO `creative_resource_classifier` VALUES ('879', '119', '200103');
INSERT INTO `creative_resource_classifier` VALUES ('880', '119', '200104');
INSERT INTO `creative_resource_classifier` VALUES ('881', '119', '200201');
INSERT INTO `creative_resource_classifier` VALUES ('882', '119', '200202');
INSERT INTO `creative_resource_classifier` VALUES ('883', '119', '200203');
INSERT INTO `creative_resource_classifier` VALUES ('884', '119', '200301');
INSERT INTO `creative_resource_classifier` VALUES ('885', '119', '200305');
INSERT INTO `creative_resource_classifier` VALUES ('886', '119', '200302');
INSERT INTO `creative_resource_classifier` VALUES ('887', '119', '200303');
INSERT INTO `creative_resource_classifier` VALUES ('888', '119', '200304');
INSERT INTO `creative_resource_classifier` VALUES ('889', '119', '200404');
INSERT INTO `creative_resource_classifier` VALUES ('890', '119', '200401');
INSERT INTO `creative_resource_classifier` VALUES ('891', '119', '200402');
INSERT INTO `creative_resource_classifier` VALUES ('892', '119', '200403');

-- ----------------------------
-- Table structure for `creative_resource_evaluate`
-- ----------------------------
DROP TABLE IF EXISTS `creative_resource_evaluate`;
CREATE TABLE `creative_resource_evaluate` (
  `evaluate_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意资源评价ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '评价用户ID',
  `transaction_id` bigint(20) DEFAULT NULL COMMENT '创意资源交易ID',
  `evaluate_star` int(11) DEFAULT NULL COMMENT '评价星级',
  `evaluate_value` varchar(500) DEFAULT NULL COMMENT '评价内容',
  `evaluate_append` varchar(500) DEFAULT NULL COMMENT '追加评论',
  `explain_value` varchar(500) DEFAULT NULL COMMENT '解释',
  `evaluate_time` datetime DEFAULT NULL COMMENT '评论时间',
  `append_time` datetime DEFAULT NULL COMMENT '追加时间',
  `explain_time` datetime DEFAULT NULL COMMENT '解释时间',
  PRIMARY KEY (`evaluate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8 COMMENT='创意资源评价';

-- ----------------------------
-- Records of creative_resource_evaluate
-- ----------------------------
INSERT INTO `creative_resource_evaluate` VALUES ('1', '1', '3', '3', '3', '3', '3', '2016-11-22 17:19:20', '2016-11-22 17:19:24', '2016-11-22 17:19:26');
INSERT INTO `creative_resource_evaluate` VALUES ('2', '2', '2', '1', '还不错！', '用着不错', '您满意我放心', '2016-11-21 09:21:47', '2016-11-21 09:21:51', '2016-11-21 09:21:54');
INSERT INTO `creative_resource_evaluate` VALUES ('212', '1', '1', '4', '1', '8', '8', null, null, null);

-- ----------------------------
-- Table structure for `creative_talent_evaluate`
-- ----------------------------
DROP TABLE IF EXISTS `creative_talent_evaluate`;
CREATE TABLE `creative_talent_evaluate` (
  `evaluate_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意人才评价ID',
  `proj_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '评价用户ID',
  `evaluate_star` int(11) DEFAULT NULL COMMENT '评价星级',
  `evaluate_time` datetime DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (`evaluate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='创意人才评价';

-- ----------------------------
-- Records of creative_talent_evaluate
-- ----------------------------
INSERT INTO `creative_talent_evaluate` VALUES ('1', '38', '1', '3', '2016-11-16 11:47:25');
INSERT INTO `creative_talent_evaluate` VALUES ('2', '38', '1', '4', '2016-11-16 11:47:43');
INSERT INTO `creative_talent_evaluate` VALUES ('3', '28', '2', '4', '2016-11-16 11:47:54');
INSERT INTO `creative_talent_evaluate` VALUES ('4', '38', '2', '2', '2016-11-16 11:58:18');

-- ----------------------------
-- Table structure for `dealtable`
-- ----------------------------
DROP TABLE IF EXISTS `dealtable`;
CREATE TABLE `dealtable` (
  `tableid` int(11) NOT NULL AUTO_INCREMENT,
  `dealtablename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tableid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dealtable
-- ----------------------------
INSERT INTO `dealtable` VALUES ('1', 'back_user');

-- ----------------------------
-- Table structure for `dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典ID',
  `parent_id` int(11) DEFAULT NULL COMMENT '父字典ID',
  `dict_name` varchar(50) DEFAULT NULL COMMENT '字典值',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=800001 DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('100000', null, '需求');
INSERT INTO `dictionary` VALUES ('100100', '100000', '需求分类');
INSERT INTO `dictionary` VALUES ('100200', '100000', '需求类型');
INSERT INTO `dictionary` VALUES ('100300', '100000', '需求预算');
INSERT INTO `dictionary` VALUES ('100400', '100000', '工作形式');
INSERT INTO `dictionary` VALUES ('100500', '100000', '供方类型');
INSERT INTO `dictionary` VALUES ('100600', '100000', '认证要求');
INSERT INTO `dictionary` VALUES ('100700', '100000', '发布方式');
INSERT INTO `dictionary` VALUES ('110000', null, '投诉处理状态');
INSERT INTO `dictionary` VALUES ('140000', null, '融资');
INSERT INTO `dictionary` VALUES ('140100', '140000', '融资分类');
INSERT INTO `dictionary` VALUES ('140200', '140000', '融资方式');
INSERT INTO `dictionary` VALUES ('140400', '140000', '草稿');
INSERT INTO `dictionary` VALUES ('200000', null, '创意资源');
INSERT INTO `dictionary` VALUES ('200100', '200000', '开发分类');
INSERT INTO `dictionary` VALUES ('200200', '200000', '测试分类');
INSERT INTO `dictionary` VALUES ('200300', '200000', '设计分类');
INSERT INTO `dictionary` VALUES ('200400', '200000', '作品类型');
INSERT INTO `dictionary` VALUES ('300000', null, '创意人才');
INSERT INTO `dictionary` VALUES ('300100', '300000', '热门领域');
INSERT INTO `dictionary` VALUES ('300200', '300000', '热门技术');
INSERT INTO `dictionary` VALUES ('300300', '300000', '认证');
INSERT INTO `dictionary` VALUES ('400000', null, '状态');
INSERT INTO `dictionary` VALUES ('400100', '400000', '创意需求状态');
INSERT INTO `dictionary` VALUES ('400200', '400000', '报名状态');
INSERT INTO `dictionary` VALUES ('400300', '400000', '计划/任务状态');
INSERT INTO `dictionary` VALUES ('400400', '400000', '资源仓库状态');
INSERT INTO `dictionary` VALUES ('400500', '400000', '资源交易状态');
INSERT INTO `dictionary` VALUES ('400600', '400000', '项目状态');
INSERT INTO `dictionary` VALUES ('400700', '400000', '审核状态');
INSERT INTO `dictionary` VALUES ('400800', '400000', '团队人员状态');
INSERT INTO `dictionary` VALUES ('400900', '400000', '变更状态');
INSERT INTO `dictionary` VALUES ('401000', '400000', '项目评估状态');
INSERT INTO `dictionary` VALUES ('401100', '400000', '创意需求详细状态');
INSERT INTO `dictionary` VALUES ('401200', '400000', '创意资源状态');
INSERT INTO `dictionary` VALUES ('500000', null, '投资机构');
INSERT INTO `dictionary` VALUES ('500100', '500000', '投资偏好');
INSERT INTO `dictionary` VALUES ('500200', '500000', '投资领域');
INSERT INTO `dictionary` VALUES ('600000', null, '消息类型');
INSERT INTO `dictionary` VALUES ('700000', null, '收藏类型');
INSERT INTO `dictionary` VALUES ('800000', null, '我的成交');

-- ----------------------------
-- Table structure for `dictionarydata`
-- ----------------------------
DROP TABLE IF EXISTS `dictionarydata`;
CREATE TABLE `dictionarydata` (
  `data_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `dict_id` int(11) DEFAULT NULL COMMENT '字典ID',
  `data_value` varchar(50) DEFAULT NULL COMMENT '数据值',
  PRIMARY KEY (`data_id`)
) ENGINE=InnoDB AUTO_INCREMENT=900005 DEFAULT CHARSET=utf8 COMMENT='字典数据';

-- ----------------------------
-- Records of dictionarydata
-- ----------------------------
INSERT INTO `dictionarydata` VALUES ('100101', '100100', '网站开发');
INSERT INTO `dictionarydata` VALUES ('100102', '100100', 'html5应用');
INSERT INTO `dictionarydata` VALUES ('100103', '100100', '微信应用');
INSERT INTO `dictionarydata` VALUES ('100104', '100100', '移动开发');
INSERT INTO `dictionarydata` VALUES ('100105', '100100', 'SDK/API开发');
INSERT INTO `dictionarydata` VALUES ('100106', '100100', '文档翻译');
INSERT INTO `dictionarydata` VALUES ('100201', '100200', '招募');
INSERT INTO `dictionarydata` VALUES ('100202', '100200', '需求');
INSERT INTO `dictionarydata` VALUES ('100203', '100200', '融资');
INSERT INTO `dictionarydata` VALUES ('100301', '100300', '1000以下');
INSERT INTO `dictionarydata` VALUES ('100302', '100300', '1000-5000');
INSERT INTO `dictionarydata` VALUES ('100303', '100300', '5000-1万');
INSERT INTO `dictionarydata` VALUES ('100304', '100300', '1万-5万');
INSERT INTO `dictionarydata` VALUES ('100305', '100300', '5万以上');
INSERT INTO `dictionarydata` VALUES ('100401', '100400', '兼职');
INSERT INTO `dictionarydata` VALUES ('100402', '100400', '全职');
INSERT INTO `dictionarydata` VALUES ('100501', '100500', '企业用户');
INSERT INTO `dictionarydata` VALUES ('100502', '100500', '个人用户');
INSERT INTO `dictionarydata` VALUES ('100601', '100600', '身份认证');
INSERT INTO `dictionarydata` VALUES ('100602', '100600', '手机认证');
INSERT INTO `dictionarydata` VALUES ('100603', '100600', '邮箱认证');
INSERT INTO `dictionarydata` VALUES ('100701', '100700', '公开发布');
INSERT INTO `dictionarydata` VALUES ('100702', '100700', '我的圈子');
INSERT INTO `dictionarydata` VALUES ('100703', '100700', '平台自动推荐');
INSERT INTO `dictionarydata` VALUES ('110001', '110000', '待处理');
INSERT INTO `dictionarydata` VALUES ('110002', '110000', '已处理');
INSERT INTO `dictionarydata` VALUES ('110003', '110000', '已忽略');
INSERT INTO `dictionarydata` VALUES ('130001', '130000', '项目');
INSERT INTO `dictionarydata` VALUES ('130002', '130000', '任务');
INSERT INTO `dictionarydata` VALUES ('140101', '140100', '融资分类一');
INSERT INTO `dictionarydata` VALUES ('140102', '140100', '融资分类二');
INSERT INTO `dictionarydata` VALUES ('140103', '140100', '融资分类三');
INSERT INTO `dictionarydata` VALUES ('140201', '140200', '融资方式一');
INSERT INTO `dictionarydata` VALUES ('140202', '140200', '融资方式二');
INSERT INTO `dictionarydata` VALUES ('140203', '140200', '融资方式三');
INSERT INTO `dictionarydata` VALUES ('140401', '140300', '草稿');
INSERT INTO `dictionarydata` VALUES ('140402', '140300', '待审核');
INSERT INTO `dictionarydata` VALUES ('140403', '140400', '审核通过');
INSERT INTO `dictionarydata` VALUES ('140404', '140400', '审核未通过');
INSERT INTO `dictionarydata` VALUES ('200101', '200100', '前端开发');
INSERT INTO `dictionarydata` VALUES ('200102', '200100', 'Web开发');
INSERT INTO `dictionarydata` VALUES ('200103', '200100', 'Android开发');
INSERT INTO `dictionarydata` VALUES ('200104', '200100', 'IOS开发');
INSERT INTO `dictionarydata` VALUES ('200105', '200100', '后端开发');
INSERT INTO `dictionarydata` VALUES ('200201', '200200', '功能测试');
INSERT INTO `dictionarydata` VALUES ('200202', '200200', '性能测试');
INSERT INTO `dictionarydata` VALUES ('200203', '200200', '单体测试');
INSERT INTO `dictionarydata` VALUES ('200301', '200300', '网页设计');
INSERT INTO `dictionarydata` VALUES ('200302', '200300', 'APP设计');
INSERT INTO `dictionarydata` VALUES ('200303', '200300', '视觉设计');
INSERT INTO `dictionarydata` VALUES ('200304', '200300', 'DEMO设计');
INSERT INTO `dictionarydata` VALUES ('200305', '200300', '客户端设计');
INSERT INTO `dictionarydata` VALUES ('200401', '200400', '移动APP');
INSERT INTO `dictionarydata` VALUES ('200402', '200400', '建站系统');
INSERT INTO `dictionarydata` VALUES ('200403', '200400', '软件工具');
INSERT INTO `dictionarydata` VALUES ('200404', '200400', '环境素材');
INSERT INTO `dictionarydata` VALUES ('300101', '300100', '网站开发');
INSERT INTO `dictionarydata` VALUES ('300102', '300100', 'Android');
INSERT INTO `dictionarydata` VALUES ('300103', '300100', 'IOS');
INSERT INTO `dictionarydata` VALUES ('300104', '300100', '企业软件');
INSERT INTO `dictionarydata` VALUES ('300105', '300100', '桌面应用');
INSERT INTO `dictionarydata` VALUES ('300106', '300100', '微信');
INSERT INTO `dictionarydata` VALUES ('300201', '300200', 'Java');
INSERT INTO `dictionarydata` VALUES ('300202', '300200', 'Oracle');
INSERT INTO `dictionarydata` VALUES ('300203', '300200', 'C');
INSERT INTO `dictionarydata` VALUES ('300204', '300200', 'MySql');
INSERT INTO `dictionarydata` VALUES ('300205', '300200', 'Android');
INSERT INTO `dictionarydata` VALUES ('300206', '300200', 'IOS');
INSERT INTO `dictionarydata` VALUES ('300207', '300200', 'jsp');
INSERT INTO `dictionarydata` VALUES ('300208', '300200', 'JQuery');
INSERT INTO `dictionarydata` VALUES ('300209', '300200', 'html5');
INSERT INTO `dictionarydata` VALUES ('300301', '300300', '身份认证');
INSERT INTO `dictionarydata` VALUES ('300302', '300300', '手机认证');
INSERT INTO `dictionarydata` VALUES ('300303', '300300', '邮箱认证');
INSERT INTO `dictionarydata` VALUES ('400101', '400100', '审核中');
INSERT INTO `dictionarydata` VALUES ('400102', '400100', '已发布');
INSERT INTO `dictionarydata` VALUES ('400103', '400100', '已成交');
INSERT INTO `dictionarydata` VALUES ('400104', '400100', '发布失败');
INSERT INTO `dictionarydata` VALUES ('400105', '400100', '草稿');
INSERT INTO `dictionarydata` VALUES ('400201', '400200', '未接纳');
INSERT INTO `dictionarydata` VALUES ('400202', '400200', '已接纳');
INSERT INTO `dictionarydata` VALUES ('400301', '400300', '未开始');
INSERT INTO `dictionarydata` VALUES ('400302', '400300', '完成');
INSERT INTO `dictionarydata` VALUES ('400303', '400300', '进行中');
INSERT INTO `dictionarydata` VALUES ('400401', '400400', '正在出售');
INSERT INTO `dictionarydata` VALUES ('400402', '400400', '审核中');
INSERT INTO `dictionarydata` VALUES ('400403', '400400', '未通过审核');
INSERT INTO `dictionarydata` VALUES ('400404', '400400', '已下架');
INSERT INTO `dictionarydata` VALUES ('400405', '400400', '已删除');
INSERT INTO `dictionarydata` VALUES ('400501', '400500', '待付款');
INSERT INTO `dictionarydata` VALUES ('400502', '400500', '待发货');
INSERT INTO `dictionarydata` VALUES ('400503', '400500', '待确认');
INSERT INTO `dictionarydata` VALUES ('400504', '400500', '待评价');
INSERT INTO `dictionarydata` VALUES ('400505', '400500', '已完成');
INSERT INTO `dictionarydata` VALUES ('400506', '400500', '已关闭');
INSERT INTO `dictionarydata` VALUES ('400601', '400600', '进行中');
INSERT INTO `dictionarydata` VALUES ('400602', '400600', '已完成');
INSERT INTO `dictionarydata` VALUES ('400701', '400700', '未审核');
INSERT INTO `dictionarydata` VALUES ('400702', '400700', '已通过');
INSERT INTO `dictionarydata` VALUES ('400703', '400700', '未通过');
INSERT INTO `dictionarydata` VALUES ('400801', '400800', '在职');
INSERT INTO `dictionarydata` VALUES ('400802', '400800', '终止');
INSERT INTO `dictionarydata` VALUES ('400803', '400800', '请假');
INSERT INTO `dictionarydata` VALUES ('400804', '400800', '未确认');
INSERT INTO `dictionarydata` VALUES ('400805', '400800', '已拒绝');
INSERT INTO `dictionarydata` VALUES ('400901', '400900', '未确认');
INSERT INTO `dictionarydata` VALUES ('400902', '400900', '已确认');
INSERT INTO `dictionarydata` VALUES ('401001', '401000', '未提交');
INSERT INTO `dictionarydata` VALUES ('401002', '401000', '已提交');
INSERT INTO `dictionarydata` VALUES ('401003', '401000', '已受理');
INSERT INTO `dictionarydata` VALUES ('401004', '401000', '评估中');
INSERT INTO `dictionarydata` VALUES ('401005', '401000', '评估完成');
INSERT INTO `dictionarydata` VALUES ('401101', '401100', '发布');
INSERT INTO `dictionarydata` VALUES ('401102', '401100', '开始报名');
INSERT INTO `dictionarydata` VALUES ('401103', '401100', '报名截止');
INSERT INTO `dictionarydata` VALUES ('401104', '401100', '筛选');
INSERT INTO `dictionarydata` VALUES ('401105', '401100', '已成交');
INSERT INTO `dictionarydata` VALUES ('401201', '401200', '草稿');
INSERT INTO `dictionarydata` VALUES ('401202', '401200', '待审核');
INSERT INTO `dictionarydata` VALUES ('401203', '401200', '审核通过');
INSERT INTO `dictionarydata` VALUES ('401204', '401200', '审核未通过');
INSERT INTO `dictionarydata` VALUES ('401205', '401200', '已下架');
INSERT INTO `dictionarydata` VALUES ('401206', '401200', '已删除');
INSERT INTO `dictionarydata` VALUES ('401301', '401300', '未承接');
INSERT INTO `dictionarydata` VALUES ('401302', '401300', '已拒绝');
INSERT INTO `dictionarydata` VALUES ('401303', '401300', '已承接');
INSERT INTO `dictionarydata` VALUES ('401304', '401300', '已过期');
INSERT INTO `dictionarydata` VALUES ('500101', '500100', '发展期');
INSERT INTO `dictionarydata` VALUES ('500102', '500100', '成熟期');
INSERT INTO `dictionarydata` VALUES ('500201', '500200', '互联网');
INSERT INTO `dictionarydata` VALUES ('500202', '500200', '电子商务');
INSERT INTO `dictionarydata` VALUES ('500203', '500200', '金融');
INSERT INTO `dictionarydata` VALUES ('600001', '600000', '报名消息');
INSERT INTO `dictionarydata` VALUES ('600002', '600000', '收藏消息');
INSERT INTO `dictionarydata` VALUES ('700001', '700000', '创意需求');
INSERT INTO `dictionarydata` VALUES ('700002', '700000', '人才需求');
INSERT INTO `dictionarydata` VALUES ('700003', '700000', '融资需求');
INSERT INTO `dictionarydata` VALUES ('700004', '700000', '创意人才');
INSERT INTO `dictionarydata` VALUES ('700005', '700000', '创意资源');
INSERT INTO `dictionarydata` VALUES ('800001', '800000', '需求');
INSERT INTO `dictionarydata` VALUES ('800002', '800000', '招募');
INSERT INTO `dictionarydata` VALUES ('800003', '800000', '出售');
INSERT INTO `dictionarydata` VALUES ('800004', '800000', '人才');
INSERT INTO `dictionarydata` VALUES ('800005', '800000', '购买');
INSERT INTO `dictionarydata` VALUES ('900001', '900001', '待审核');
INSERT INTO `dictionarydata` VALUES ('900002', '900000', '审核未通过');
INSERT INTO `dictionarydata` VALUES ('900003', '900000', '待评估');
INSERT INTO `dictionarydata` VALUES ('900004', '900000', '已完成');

-- ----------------------------
-- Table structure for `email_enroll`
-- ----------------------------
DROP TABLE IF EXISTS `email_enroll`;
CREATE TABLE `email_enroll` (
  `auth_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '验证ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `auth_code` varchar(500) DEFAULT NULL COMMENT '验证码',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮箱验证';

-- ----------------------------
-- Records of email_enroll
-- ----------------------------

-- ----------------------------
-- Table structure for `fancing`
-- ----------------------------
DROP TABLE IF EXISTS `fancing`;
CREATE TABLE `fancing` (
  `fancing_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '融资ID',
  `project_name` varchar(500) DEFAULT NULL COMMENT '项目名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `fancing_money` decimal(10,2) DEFAULT NULL COMMENT '融资金额',
  `fancing_description` varchar(500) DEFAULT NULL COMMENT '融资描述',
  `fancing_use` varchar(100) DEFAULT NULL COMMENT '融资用途',
  `publish_way` varchar(50) DEFAULT NULL COMMENT '发布方式',
  `fancing_file_see_path` varchar(200) DEFAULT NULL COMMENT '融资附件预览路径',
  `fancing_file_name` varchar(50) DEFAULT NULL COMMENT '附件名称',
  `fancing_body` varchar(50) DEFAULT NULL COMMENT '融资主体',
  `fancing_attachment` varchar(200) DEFAULT NULL COMMENT '融资附件路径',
  `fancing_way` int(11) DEFAULT NULL COMMENT '融资方式',
  `fancing_status` int(11) DEFAULT NULL COMMENT '融资状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `is_open` bit(1) DEFAULT b'1' COMMENT '是否公开',
  PRIMARY KEY (`fancing_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='融资';

-- ----------------------------
-- Records of fancing
-- ----------------------------
INSERT INTO `fancing` VALUES ('1', '项目名称01', '1', '13999.99', '描述1', '用途2', '100701,100702,100703', '1', '附件名2', '公司2', '路径2', '140201', '140402', '', '2016-11-08 13:19:11', '');
INSERT INTO `fancing` VALUES ('2', '项目名称02', '1', '13999.99', null, '用途2', '100701,100702,100703', '1', '附件名2', '公司2', '路径2', '140201', '140402', '', '2016-11-08 13:22:16', '');
INSERT INTO `fancing` VALUES ('3', '项目名称03', '1', '13999.99', null, '用途3', '100701,100702,100703', '1', '附件名3', '公司3', '路径3', '140201', '140402', '', '2016-11-21 14:58:13', '');
INSERT INTO `fancing` VALUES ('4', '项目名称', '1', '3999.99', null, '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-21 15:59:05', '');
INSERT INTO `fancing` VALUES ('5', '项目名称05', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-21 16:16:55', '');
INSERT INTO `fancing` VALUES ('6', '项目名称06', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-21 17:28:37', '');
INSERT INTO `fancing` VALUES ('7', '项目名称06', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-21 17:33:07', '');
INSERT INTO `fancing` VALUES ('8', '项目名称06', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-21 17:37:36', '');
INSERT INTO `fancing` VALUES ('9', '项目名称06', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-21 17:39:08', '');
INSERT INTO `fancing` VALUES ('10', '项目名称07', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-21 17:44:18', '');
INSERT INTO `fancing` VALUES ('11', '项目名称08', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-22 11:45:37', '');
INSERT INTO `fancing` VALUES ('12', '项目名称09', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-22 11:49:05', '');
INSERT INTO `fancing` VALUES ('13', '项目名称10', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-22 12:29:06', '');
INSERT INTO `fancing` VALUES ('14', '项目名称10', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-22 12:35:40', '');
INSERT INTO `fancing` VALUES ('15', '项目名称11', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-22 12:35:42', '');
INSERT INTO `fancing` VALUES ('16', '项目名称12', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-22 12:36:42', '');
INSERT INTO `fancing` VALUES ('17', '项目名称12', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140402', '', '2016-11-22 12:41:49', '');
INSERT INTO `fancing` VALUES ('18', '项目名称13', '1', '3999.99', '描述', '用途', '100701,100702,100703', '1', '附件名', '公司', '路径', '140201', '140404', '', '2016-11-22 12:42:25', '');
INSERT INTO `fancing` VALUES ('19', '项目名称14', '1', '3999.99', '描述', '用途', '100701,100702,100703', '预览路径', '附件名', '公司', '路径', '140201', '140401', '', '2016-11-22 16:03:48', '');
INSERT INTO `fancing` VALUES ('20', 'a', '1', '2.00', 'fdsfds', 'sdfs', '100701', 'resources/images/front/upload.png', null, 'fsdfas', 'resources/images/front/upload.png', '140202', '140401', '', '2016-11-23 21:02:54', '');

-- ----------------------------
-- Table structure for `fancing_audit`
-- ----------------------------
DROP TABLE IF EXISTS `fancing_audit`;
CREATE TABLE `fancing_audit` (
  `audit_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '融资审核ID',
  `fancing_id` bigint(20) DEFAULT NULL COMMENT '融资ID',
  `back_user_id` int(11) DEFAULT NULL COMMENT '审核后台用户ID',
  `audit_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_content` varchar(200) DEFAULT NULL COMMENT '审核内容',
  `audit_status` int(11) DEFAULT NULL COMMENT '审核状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='融资审核';

-- ----------------------------
-- Records of fancing_audit
-- ----------------------------
INSERT INTO `fancing_audit` VALUES ('1', '10', null, '2016-11-22 14:34:45', null, null, '');

-- ----------------------------
-- Table structure for `fancing_classifier`
-- ----------------------------
DROP TABLE IF EXISTS `fancing_classifier`;
CREATE TABLE `fancing_classifier` (
  `fancing_classifier_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '融资分类ID',
  `fancing_id` bigint(20) DEFAULT NULL COMMENT '融资ID',
  `fancing_classifier_value` int(11) DEFAULT NULL COMMENT '融资分类值',
  PRIMARY KEY (`fancing_classifier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='融资分类';

-- ----------------------------
-- Records of fancing_classifier
-- ----------------------------
INSERT INTO `fancing_classifier` VALUES ('1', '9', '140101');
INSERT INTO `fancing_classifier` VALUES ('2', '9', '140102');
INSERT INTO `fancing_classifier` VALUES ('3', '10', '140101');
INSERT INTO `fancing_classifier` VALUES ('4', '10', '140102');
INSERT INTO `fancing_classifier` VALUES ('7', '1', '140101');
INSERT INTO `fancing_classifier` VALUES ('8', '1', '140102');
INSERT INTO `fancing_classifier` VALUES ('9', '2', '140101');
INSERT INTO `fancing_classifier` VALUES ('10', '2', '140102');
INSERT INTO `fancing_classifier` VALUES ('13', '3', '140101');
INSERT INTO `fancing_classifier` VALUES ('14', '3', '140102');
INSERT INTO `fancing_classifier` VALUES ('15', '4', '140101');
INSERT INTO `fancing_classifier` VALUES ('16', '11', '140102');
INSERT INTO `fancing_classifier` VALUES ('17', '5', '140101');
INSERT INTO `fancing_classifier` VALUES ('18', '12', '140102');
INSERT INTO `fancing_classifier` VALUES ('19', '6', '140101');
INSERT INTO `fancing_classifier` VALUES ('20', '13', '140102');
INSERT INTO `fancing_classifier` VALUES ('21', '7', '140101');
INSERT INTO `fancing_classifier` VALUES ('22', '14', '140102');
INSERT INTO `fancing_classifier` VALUES ('23', '8', '140101');
INSERT INTO `fancing_classifier` VALUES ('24', '15', '140102');
INSERT INTO `fancing_classifier` VALUES ('25', '9', '140101');
INSERT INTO `fancing_classifier` VALUES ('26', '16', '140102');
INSERT INTO `fancing_classifier` VALUES ('27', '17', '140101');
INSERT INTO `fancing_classifier` VALUES ('28', '17', '140102');
INSERT INTO `fancing_classifier` VALUES ('29', '18', '140101');
INSERT INTO `fancing_classifier` VALUES ('30', '18', '140102');
INSERT INTO `fancing_classifier` VALUES ('31', '19', '140101');
INSERT INTO `fancing_classifier` VALUES ('32', '19', '140102');
INSERT INTO `fancing_classifier` VALUES ('33', '20', '140102');

-- ----------------------------
-- Table structure for `incudators`
-- ----------------------------
DROP TABLE IF EXISTS `incudators`;
CREATE TABLE `incudators` (
  `includator_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '孵化器id',
  `includator_title` varchar(200) DEFAULT NULL COMMENT '标题',
  `includator_img` varchar(100) DEFAULT NULL COMMENT '图片',
  `includator_img_path` varchar(400) DEFAULT NULL COMMENT '图片路径',
  `includator_link` varchar(500) DEFAULT NULL COMMENT '链接',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`includator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='孵化器';

-- ----------------------------
-- Records of incudators
-- ----------------------------

-- ----------------------------
-- Table structure for `invest_company`
-- ----------------------------
DROP TABLE IF EXISTS `invest_company`;
CREATE TABLE `invest_company` (
  `invest_company_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '投资机构ID',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司ID',
  `invest_company_name` varchar(200) DEFAULT NULL COMMENT '投资机构名称',
  `build_date` date DEFAULT NULL COMMENT '成立日期',
  `invest_case` varchar(500) DEFAULT NULL COMMENT '投资机构简介',
  `invest_status` int(11) DEFAULT NULL COMMENT '投资机构状态',
  `create_time` datetime DEFAULT NULL COMMENT '发布时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`invest_company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='投资机构';

-- ----------------------------
-- Records of invest_company
-- ----------------------------
INSERT INTO `invest_company` VALUES ('1', '1', 'person02', null, '测试大撒旦撒', '400701', '2016-11-15 21:26:24', '');
INSERT INTO `invest_company` VALUES ('2', '2', '1', null, null, '400701', '2016-11-14 21:39:22', '');
INSERT INTO `invest_company` VALUES ('3', '3', '1', null, null, '400701', '2016-11-14 21:39:22', '');
INSERT INTO `invest_company` VALUES ('4', '6', 'hhhhh', null, null, '400701', '2016-11-14 21:39:22', '');
INSERT INTO `invest_company` VALUES ('5', '7', 'hhhhh', null, null, '400701', '2016-11-14 21:57:46', '');
INSERT INTO `invest_company` VALUES ('6', '1', 'jaja', null, 'sadsadsa', '400701', '2016-11-15 21:24:16', '');

-- ----------------------------
-- Table structure for `invest_company_audit`
-- ----------------------------
DROP TABLE IF EXISTS `invest_company_audit`;
CREATE TABLE `invest_company_audit` (
  `audit_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '审核ID',
  `invest_company_id` bigint(20) DEFAULT NULL COMMENT '投资机构ID',
  `back_user_id` int(11) DEFAULT NULL COMMENT '审核的后台用户ID',
  `audit_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_content` varchar(200) DEFAULT NULL COMMENT '审核内容',
  `audit_status` int(11) DEFAULT NULL COMMENT '审核状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='投资机构审核';

-- ----------------------------
-- Records of invest_company_audit
-- ----------------------------
INSERT INTO `invest_company_audit` VALUES ('1', '1', '1', null, null, '400702', '');
INSERT INTO `invest_company_audit` VALUES ('6', '3', '1', '2016-11-11 14:36:50', null, '400702', '');
INSERT INTO `invest_company_audit` VALUES ('7', null, '4', '2016-11-23 14:16:36', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('8', null, '4', '2016-11-23 14:16:56', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('9', null, '4', '2016-11-23 14:16:56', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('10', null, '4', '2016-11-23 14:20:01', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('11', null, '4', '2016-11-23 14:20:01', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('12', null, '4', '2016-11-23 14:20:01', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('13', null, '4', '2016-11-23 15:30:38', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('14', null, '4', '2016-11-23 15:33:49', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('15', null, '4', '2016-11-23 15:43:14', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('16', null, '4', '2016-11-23 15:43:19', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('17', null, '4', '2016-11-23 15:43:54', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('18', null, '4', '2016-11-23 15:45:54', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('19', null, '4', '2016-11-23 15:47:19', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('20', null, '4', '2016-11-23 15:47:31', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('21', null, '4', '2016-11-23 15:48:26', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('22', null, '4', '2016-11-23 15:51:49', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('23', null, '4', '2016-11-23 15:55:54', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('24', null, '4', '2016-11-23 16:00:35', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('25', null, '4', '2016-11-23 16:02:42', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('26', null, '4', '2016-11-23 16:03:56', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('27', null, '4', '2016-11-23 16:04:21', null, '0', '');
INSERT INTO `invest_company_audit` VALUES ('28', null, '4', '2016-11-23 16:09:05', null, '0', '');

-- ----------------------------
-- Table structure for `invest_domain`
-- ----------------------------
DROP TABLE IF EXISTS `invest_domain`;
CREATE TABLE `invest_domain` (
  `invest_domain_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投资领域ID',
  `invest_company_id` bigint(20) DEFAULT NULL COMMENT '投资机构ID',
  `invest_domain_value` varchar(100) DEFAULT NULL COMMENT '投资领域值',
  PRIMARY KEY (`invest_domain_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='投资领域';

-- ----------------------------
-- Records of invest_domain
-- ----------------------------
INSERT INTO `invest_domain` VALUES ('4', '2', '500203');
INSERT INTO `invest_domain` VALUES ('21', '0', '12345');
INSERT INTO `invest_domain` VALUES ('22', '0', '54321');
INSERT INTO `invest_domain` VALUES ('25', '5', '12345');
INSERT INTO `invest_domain` VALUES ('26', '5', '54321');
INSERT INTO `invest_domain` VALUES ('29', '6', '500201');
INSERT INTO `invest_domain` VALUES ('33', '1', '500201');
INSERT INTO `invest_domain` VALUES ('34', '1', '500202');
INSERT INTO `invest_domain` VALUES ('35', '1', '500203');
INSERT INTO `invest_domain` VALUES ('36', '1', '500201');
INSERT INTO `invest_domain` VALUES ('37', '1', '500202');
INSERT INTO `invest_domain` VALUES ('38', '1', '500203');

-- ----------------------------
-- Table structure for `invest_preference`
-- ----------------------------
DROP TABLE IF EXISTS `invest_preference`;
CREATE TABLE `invest_preference` (
  `invest_preference_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投资偏好ID',
  `invest_company_id` bigint(20) DEFAULT NULL COMMENT '投资机构ID',
  `invest_preference_value` int(11) DEFAULT NULL COMMENT '投资偏好值',
  PRIMARY KEY (`invest_preference_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='投资偏好';

-- ----------------------------
-- Records of invest_preference
-- ----------------------------
INSERT INTO `invest_preference` VALUES ('3', '2', '500101');
INSERT INTO `invest_preference` VALUES ('20', '0', '12345');
INSERT INTO `invest_preference` VALUES ('21', '0', '54321');
INSERT INTO `invest_preference` VALUES ('24', '5', '12345');
INSERT INTO `invest_preference` VALUES ('25', '5', '54321');
INSERT INTO `invest_preference` VALUES ('29', '6', '500101');
INSERT INTO `invest_preference` VALUES ('30', '6', '500102');
INSERT INTO `invest_preference` VALUES ('33', '1', '500101');
INSERT INTO `invest_preference` VALUES ('34', '1', '500102');
INSERT INTO `invest_preference` VALUES ('35', '1', '500101');
INSERT INTO `invest_preference` VALUES ('36', '1', '500102');

-- ----------------------------
-- Table structure for `my_community`
-- ----------------------------
DROP TABLE IF EXISTS `my_community`;
CREATE TABLE `my_community` (
  `community_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '圈子ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `community_user_id` bigint(20) DEFAULT NULL COMMENT '圈子用户ID',
  `is_confirm` bit(1) DEFAULT b'1' COMMENT '是否已确认',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`community_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='我的圈子';

-- ----------------------------
-- Records of my_community
-- ----------------------------
INSERT INTO `my_community` VALUES ('1', '1', '6', '', null, '');
INSERT INTO `my_community` VALUES ('2', '1', '2', '', null, '');
INSERT INTO `my_community` VALUES ('3', '1', '3', '', null, '');
INSERT INTO `my_community` VALUES ('4', '1', '2', '', null, '');
INSERT INTO `my_community` VALUES ('5', '1', '4', '', null, '');

-- ----------------------------
-- Table structure for `professional_evaluation`
-- ----------------------------
DROP TABLE IF EXISTS `professional_evaluation`;
CREATE TABLE `professional_evaluation` (
  `assessment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评估ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `professional_id` bigint(20) DEFAULT NULL COMMENT '专家ID',
  `assessment_date` date DEFAULT NULL COMMENT '期望评估时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '申请人ID',
  `mobile` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `project_describe` varchar(200) DEFAULT NULL COMMENT '项目描述',
  `assessment_view` varchar(200) DEFAULT NULL COMMENT '专家意见',
  `assessment_status` int(11) DEFAULT NULL COMMENT '评估状态',
  `evaluation_date` date DEFAULT NULL COMMENT '实际评估时间',
  `assessment_file_see_path` varchar(200) DEFAULT NULL COMMENT '附件预览路径',
  `assessment_file_name` varchar(50) DEFAULT NULL COMMENT '附件名称',
  `assessment_file` varchar(200) DEFAULT NULL COMMENT '附件',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`assessment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='专业评估';

-- ----------------------------
-- Records of professional_evaluation
-- ----------------------------
INSERT INTO `professional_evaluation` VALUES ('1', '1', null, '2016-11-01', '1', '12222222', '这是一个修改', null, '900001', null, null, null, null, '2016-11-11 11:07:31', '');
INSERT INTO `professional_evaluation` VALUES ('2', '2', null, '2017-01-03', '1', '15777777', '好项目，为自己带盐', '专家意见', '900002', '2016-11-08', null, null, null, '2016-11-11 11:13:35', '');
INSERT INTO `professional_evaluation` VALUES ('3', '3', '6', '2017-01-03', '1', '15777777', '好项目，为自己带盐', '专家意见', '900003', '2016-11-17', null, null, null, '2016-11-11 11:15:20', '');
INSERT INTO `professional_evaluation` VALUES ('4', '4', '6', '2017-01-03', '1', '15777777', '好项目，为自己带盐', '专家意见专家意见专家意见专家意见专家意见专家意见专家意见专家意见专家意见', '900004', null, null, null, null, '2016-11-11 15:29:41', '');
INSERT INTO `professional_evaluation` VALUES ('5', '2', null, '2016-11-17', '1', '110', '宙斯盾项目', null, '900001', null, null, null, null, '2016-11-17 16:55:20', '');

-- ----------------------------
-- Table structure for `proficient_professional_field`
-- ----------------------------
DROP TABLE IF EXISTS `proficient_professional_field`;
CREATE TABLE `proficient_professional_field` (
  `professional_field_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专业领域ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '专家ID',
  `professional_field_value` int(11) DEFAULT NULL COMMENT '专业领域值',
  PRIMARY KEY (`professional_field_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='专家专业领域';

-- ----------------------------
-- Records of proficient_professional_field
-- ----------------------------
INSERT INTO `proficient_professional_field` VALUES ('19', '7', '300205');
INSERT INTO `proficient_professional_field` VALUES ('20', '7', '300202');
INSERT INTO `proficient_professional_field` VALUES ('21', '7', '300203');
INSERT INTO `proficient_professional_field` VALUES ('22', '7', '300204');
INSERT INTO `proficient_professional_field` VALUES ('37', '6', '100101');
INSERT INTO `proficient_professional_field` VALUES ('38', '6', '100102');
INSERT INTO `proficient_professional_field` VALUES ('39', '6', '100103');
INSERT INTO `proficient_professional_field` VALUES ('40', '8', '100103');
INSERT INTO `proficient_professional_field` VALUES ('41', '8', '100104');
INSERT INTO `proficient_professional_field` VALUES ('42', '8', '100104');
INSERT INTO `proficient_professional_field` VALUES ('46', '9', '100105');
INSERT INTO `proficient_professional_field` VALUES ('47', '9', '100104');
INSERT INTO `proficient_professional_field` VALUES ('48', '9', '100106');
INSERT INTO `proficient_professional_field` VALUES ('49', '12', '100101');
INSERT INTO `proficient_professional_field` VALUES ('50', '12', '100103');
INSERT INTO `proficient_professional_field` VALUES ('51', '12', '100105');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目ID',
  `project_requirement_id` bigint(20) DEFAULT NULL COMMENT '创意需求ID',
  `project_name` varchar(200) DEFAULT NULL COMMENT '项目名称',
  `project_manager_user_id` bigint(20) DEFAULT NULL COMMENT '项目负责人ID',
  `project_estimate` int(11) DEFAULT NULL COMMENT '项目评估周期',
  `project_real_start_date` date DEFAULT NULL COMMENT '项目实际开始时间',
  `project_hope_end_date` date DEFAULT NULL COMMENT '项目预期完成时间',
  `project_real_end_date` date DEFAULT NULL COMMENT '项目实际完成时间',
  `project_status` int(11) DEFAULT NULL COMMENT '项目状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='项目';

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '1', '项目1', '1', null, null, null, '2016-11-17', '400601', '', null);
INSERT INTO `project` VALUES ('2', '2', '项目2', '1', null, null, null, '2016-11-10', '400601', '', null);
INSERT INTO `project` VALUES ('3', '3', '项目3', '1', null, null, null, '2016-11-18', '400602', '', null);
INSERT INTO `project` VALUES ('4', '4', '项目4', '1', null, null, null, '2016-11-18', '400602', '', null);
INSERT INTO `project` VALUES ('5', '32', '项目32', '1', null, null, null, '2016-11-19', '400601', '', null);
INSERT INTO `project` VALUES ('6', '33', '项目33', '1', null, null, null, '2016-11-30', '400601', '', null);
INSERT INTO `project` VALUES ('7', '34', '项目34', '1', null, '2016-11-30', '2016-11-30', '2016-11-23', '400602', '', null);
INSERT INTO `project` VALUES ('8', '35', '项目35', '1', null, '2016-11-27', '2016-11-28', '2016-12-16', '400602', '', null);

-- ----------------------------
-- Table structure for `project_enroll`
-- ----------------------------
DROP TABLE IF EXISTS `project_enroll`;
CREATE TABLE `project_enroll` (
  `enroll_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '报名ID',
  `project_requirement_id` bigint(20) DEFAULT NULL COMMENT '创意需求ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `enroll_datetime` datetime DEFAULT NULL COMMENT '报名时间',
  `enroll_status` int(11) DEFAULT NULL COMMENT '报名状态',
  `enroll_name` varchar(20) DEFAULT NULL COMMENT '报名名称',
  `enroll_email` varchar(50) DEFAULT NULL COMMENT '报名邮箱',
  `enroll_mobile` varchar(20) DEFAULT NULL COMMENT '报名手机',
  `enroll_value` varchar(200) DEFAULT NULL COMMENT '报名信息',
  `enroll_see_file_path` varchar(200) DEFAULT NULL COMMENT '附件预览',
  `enroll_file_name` varchar(50) DEFAULT NULL COMMENT '附件名称',
  `enroll_file_path` varchar(200) DEFAULT NULL COMMENT '附件路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`enroll_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='创意需求报名';

-- ----------------------------
-- Records of project_enroll
-- ----------------------------
INSERT INTO `project_enroll` VALUES ('27', '3', '1', null, null, null, null, null, null, null, null, null, '2016-11-21 20:42:11');
INSERT INTO `project_enroll` VALUES ('28', '4', '1', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `project_enroll` VALUES ('29', '5', '1', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `project_enroll` VALUES ('32', '1', '1', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `project_evaluate`
-- ----------------------------
DROP TABLE IF EXISTS `project_evaluate`;
CREATE TABLE `project_evaluate` (
  `evaluate_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `proj_id` bigint(20) DEFAULT NULL COMMENT '创意需求ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `evaluate_value` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `evaluate_time` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`evaluate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='创意需求评论';

-- ----------------------------
-- Records of project_evaluate
-- ----------------------------
INSERT INTO `project_evaluate` VALUES ('1', '30', '1', '1', '2016-11-15 17:58:52');
INSERT INTO `project_evaluate` VALUES ('2', '33', '2', '2', '2016-11-16 17:33:57');
INSERT INTO `project_evaluate` VALUES ('3', '33', '6', 'fadsf', '2016-11-16 17:35:06');
INSERT INTO `project_evaluate` VALUES ('4', '33', '7', 'sdfg', '2016-11-16 17:36:33');
INSERT INTO `project_evaluate` VALUES ('5', '33', '8', 'fdgsd', '2016-11-16 17:36:45');
INSERT INTO `project_evaluate` VALUES ('6', '33', '9', 'fasdf', '2016-11-16 17:36:56');
INSERT INTO `project_evaluate` VALUES ('7', '33', '1', 'cai', '2016-11-16 19:30:34');
INSERT INTO `project_evaluate` VALUES ('8', null, '1', 'dfasf', '2016-11-16 19:35:50');
INSERT INTO `project_evaluate` VALUES ('9', '30', '1', '白痴项目', '2016-11-18 21:54:59');

-- ----------------------------
-- Table structure for `project_leave`
-- ----------------------------
DROP TABLE IF EXISTS `project_leave`;
CREATE TABLE `project_leave` (
  `leave_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '请假ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `start_date` date DEFAULT NULL COMMENT '开始时间',
  `end_date` date DEFAULT NULL COMMENT '结束时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`leave_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='项目请假';

-- ----------------------------
-- Records of project_leave
-- ----------------------------
INSERT INTO `project_leave` VALUES ('1', '28', '1', '2016-11-19', '2016-11-21', '2016-11-19 17:05:01', '');

-- ----------------------------
-- Table structure for `project_plan`
-- ----------------------------
DROP TABLE IF EXISTS `project_plan`;
CREATE TABLE `project_plan` (
  `proj_plan_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划ID',
  `proj_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '计划父ID',
  `proj_plan_name` varchar(200) DEFAULT NULL COMMENT '计划名称',
  `plan_executant` bigint(20) DEFAULT NULL COMMENT '计划实施者',
  `parent_plan_id` bigint(20) DEFAULT NULL COMMENT '前置计划ID',
  `plan_work_range` int(11) DEFAULT NULL COMMENT '项目工作周期',
  `plan_start_date` date DEFAULT NULL COMMENT '计划开始时间',
  `plan_finish_date` date DEFAULT NULL COMMENT '计划结束时间',
  `plan_real_start_date` date DEFAULT NULL COMMENT '计划实际开始时间',
  `plan_real_finish_date` date DEFAULT NULL COMMENT '计划实际完成时间',
  `plan_status` int(11) DEFAULT NULL COMMENT '计划状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  `plan_content` varchar(500) DEFAULT NULL COMMENT '计划内容',
  PRIMARY KEY (`proj_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='计划';

-- ----------------------------
-- Records of project_plan
-- ----------------------------
INSERT INTO `project_plan` VALUES ('1', '5', null, '计划1', '1', null, '1', '2016-11-18', null, '2016-11-22', null, '400303', '', null);
INSERT INTO `project_plan` VALUES ('2', '5', null, '计划2', '2', '1', null, '2016-11-19', null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('3', '5', null, '计划3', '3', '2', null, '2016-11-17', null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('4', '5', '1', '计划1的子计划1', '4', null, null, null, null, null, null, '400301', '', null);
INSERT INTO `project_plan` VALUES ('5', '5', '1', '计划1的子计划2', '6', '4', null, null, null, null, null, '400303', '', null);
INSERT INTO `project_plan` VALUES ('6', '5', '1', '计划1的子计划3', '5', '5', null, null, null, null, null, '400302', '', null);
INSERT INTO `project_plan` VALUES ('7', '5', null, '计划4', '7', '3', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('8', '5', null, '计划5', '8', '7', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('9', '5', null, '计划6', '9', '8', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('11', '2', null, '分包1计划1', '1', null, '1', '2016-11-18', null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('12', '2', null, '分包1计划2', '2', '1', null, '2016-11-19', null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('13', '2', null, '分包1计划3', '3', '2', null, '2016-11-17', null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('14', '2', '11', '分包1计划1的子计划1', '4', null, null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('15', '2', '11', '分包1计划1的子计划2', '6', '4', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('16', '2', '11', '分包1计划1的子计划3', '5', '5', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('17', '2', null, '分包1计划4', '7', '3', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('18', '2', null, '分包1计划5', '8', '7', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('19', '2', null, '分包1计划6', '9', '8', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('21', '3', null, '分包2计划1', '1', null, '1', '2016-11-18', null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('22', '3', null, '分包2计划2', '2', '1', null, '2016-11-19', null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('23', '3', null, '分包2计划3', '3', '2', null, '2016-11-17', null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('24', '3', '21', '分包2计划1的子计划1', '4', null, null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('25', '3', '21', '分包2计划1的子计划2', '6', '4', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('26', '3', '21', '分包2计划1的子计划3', '5', '5', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('27', '3', null, '分包2计划4', '7', '3', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('28', '3', null, '分包2计划5', '8', '7', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('29', '3', null, '分包2计划6', '9', '8', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('31', '4', null, '分包3计划1', '1', null, '1', '2016-11-18', null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('32', '4', null, '分包3计划2', '2', '1', null, '2016-11-19', null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('33', '4', null, '分包3计划3', '3', '2', null, '2016-11-17', null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('34', '4', '31', '分包3计划1的子计划1', '4', null, null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('35', '4', '31', '分包3计划1的子计划2', '6', '4', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('36', '4', '31', '分包3计划1的子计划3', '5', '5', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('37', '4', null, '分包3计划4', '7', '3', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('38', '4', null, '分包3计划5', '8', '7', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('39', '4', null, '分包3计划6', '9', '8', null, null, null, null, null, null, '', null);
INSERT INTO `project_plan` VALUES ('40', '1', null, '项目计划886', '3', null, '8', '2016-11-20', '2016-11-28', null, null, null, '', '尼玛，真不想写了，唉！！太伤了');

-- ----------------------------
-- Table structure for `project_plan_task`
-- ----------------------------
DROP TABLE IF EXISTS `project_plan_task`;
CREATE TABLE `project_plan_task` (
  `proj_task_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `proj_plan_id` bigint(20) DEFAULT NULL COMMENT '计划ID',
  `undertake_user_id` bigint(20) DEFAULT NULL COMMENT '承接人ID',
  `proj_task_work_range` int(11) DEFAULT NULL COMMENT '任务周期',
  `proj_task_name` varchar(200) DEFAULT NULL COMMENT '任务名称',
  `proj_task_start_date` date DEFAULT NULL COMMENT '任务开始时间',
  `proj_task_finish_date` date DEFAULT NULL COMMENT '任务结束时间',
  `proj_task_real_start_date` date DEFAULT NULL COMMENT '任务实际开始时间',
  `proj_task_real_finish_date` date DEFAULT NULL COMMENT '任务实际结束时间',
  `proj_task_status` int(11) DEFAULT NULL COMMENT '任务状态',
  `proj_task_content` varchar(200) DEFAULT NULL COMMENT '任务内容',
  `proj_task_type` int(11) DEFAULT NULL COMMENT '任务类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`proj_task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='任务';

-- ----------------------------
-- Records of project_plan_task
-- ----------------------------
INSERT INTO `project_plan_task` VALUES ('1', '1', '1', '23', '任务1', '2016-11-02', '2016-11-10', '2016-11-22', null, '400303', null, null, null, '');
INSERT INTO `project_plan_task` VALUES ('2', '2', '1', null, '任务2', '2016-11-10', '2016-11-10', null, null, null, null, null, null, '');
INSERT INTO `project_plan_task` VALUES ('3', '3', '1', null, '任务3', '2016-11-11', '2016-11-11', null, null, null, null, null, null, '');
INSERT INTO `project_plan_task` VALUES ('4', '4', '1', null, '任务4', '2016-11-12', '2016-11-14', null, null, null, null, null, null, '');
INSERT INTO `project_plan_task` VALUES ('5', '5', '1', null, '任务5', '2016-11-17', '2016-11-17', null, null, null, null, null, null, '');
INSERT INTO `project_plan_task` VALUES ('6', '6', '1', null, '任务6', null, null, null, null, null, null, null, null, '');
INSERT INTO `project_plan_task` VALUES ('7', '7', '1', null, '任务7', null, null, null, null, null, null, null, null, '');
INSERT INTO `project_plan_task` VALUES ('8', '8', '1', null, '任务8', null, null, null, null, null, null, null, null, '');
INSERT INTO `project_plan_task` VALUES ('9', '9', '1', null, '任务9', null, null, null, null, null, null, null, null, '');

-- ----------------------------
-- Table structure for `project_plan_update`
-- ----------------------------
DROP TABLE IF EXISTS `project_plan_update`;
CREATE TABLE `project_plan_update` (
  `proj_plan_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划ID',
  `proj_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '计划父ID',
  `proj_plan_name` varchar(200) DEFAULT NULL COMMENT '计划名称',
  `plan_executant` bigint(20) DEFAULT NULL COMMENT '计划实施者',
  `parent_plan_id` bigint(20) DEFAULT NULL COMMENT '前置计划ID',
  `plan_work_range` int(11) DEFAULT NULL COMMENT '项目工作周期',
  `plan_start_date` date DEFAULT NULL COMMENT '计划开始时间',
  `plan_finish_date` date DEFAULT NULL COMMENT '计划结束时间',
  `plan_real_start_date` date DEFAULT NULL COMMENT '计划实际开始时间',
  `plan_real_finish_date` date DEFAULT NULL COMMENT '计划实际完成时间',
  `plan_status` int(11) DEFAULT NULL COMMENT '计划状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  `plan_content` varchar(500) DEFAULT NULL COMMENT '计划内容',
  PRIMARY KEY (`proj_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='计划变更';

-- ----------------------------
-- Records of project_plan_update
-- ----------------------------
INSERT INTO `project_plan_update` VALUES ('1', null, null, null, null, null, null, null, null, null, null, null, '', null);

-- ----------------------------
-- Table structure for `project_purchase_task`
-- ----------------------------
DROP TABLE IF EXISTS `project_purchase_task`;
CREATE TABLE `project_purchase_task` (
  `project_purchase_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目采购ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `project_task_id` bigint(20) DEFAULT NULL COMMENT '任务ID',
  `purchase_date` date DEFAULT NULL COMMENT '采购时间',
  `create_resource_id` bigint(20) DEFAULT NULL COMMENT '采购资源ID',
  `purchase_count` int(11) DEFAULT NULL COMMENT '采购数量',
  `purchase_provider_info` bigint(20) DEFAULT NULL COMMENT '供方信息',
  `purchase_cost` float DEFAULT NULL COMMENT '采购成本',
  `purchase_type` int(11) DEFAULT NULL COMMENT '采购类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`project_purchase_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='项目采购';

-- ----------------------------
-- Records of project_purchase_task
-- ----------------------------
INSERT INTO `project_purchase_task` VALUES ('1', '1', '1', '2016-11-21', '1', '4', '1', '555.55', '130002', '2016-11-14 14:16:54', '');
INSERT INTO `project_purchase_task` VALUES ('6', '1', '1', null, '2', '5', '1', '555.55', '130001', '2016-11-14 14:36:58', '');
INSERT INTO `project_purchase_task` VALUES ('7', '10', '1', null, '3', '6', '1', '999.99', '130003', '2016-11-17 11:08:36', '');
INSERT INTO `project_purchase_task` VALUES ('8', '11', '1', null, '4', '7', '1', '999.99', '130002', '2016-11-17 11:11:51', '');
INSERT INTO `project_purchase_task` VALUES ('9', '11', '1', null, '5', '7', '1', '999.99', '130002', '2016-11-17 15:29:29', '');
INSERT INTO `project_purchase_task` VALUES ('10', '12', '1', null, '6', '3', '2', '333', '130002', '2016-11-17 15:41:23', '');
INSERT INTO `project_purchase_task` VALUES ('11', '19', '1', null, '7', '6', '1', '999.99', '130002', '2016-11-18 13:35:43', '');
INSERT INTO `project_purchase_task` VALUES ('12', '19', '1', null, '8', '9', '1', '999.99', '130002', '2016-11-18 13:39:15', '');
INSERT INTO `project_purchase_task` VALUES ('13', '1', '1', null, '9', '3', '1', '999.99', '130002', '2016-11-18 13:43:49', '');
INSERT INTO `project_purchase_task` VALUES ('14', '2', null, null, '10', '1', '1', '9911240', '130002', '2016-11-18 15:08:25', '');
INSERT INTO `project_purchase_task` VALUES ('15', '1', null, null, '11', '2', '1', '9911240', '130002', '2016-11-18 15:09:14', '');
INSERT INTO `project_purchase_task` VALUES ('16', '1', '1', null, '12', '10', '1', '9911240', '130002', '2016-11-18 16:46:07', '');
INSERT INTO `project_purchase_task` VALUES ('17', '1', '1', null, '13', '11', '1', '9911240', '130002', '2016-11-18 17:39:08', '');
INSERT INTO `project_purchase_task` VALUES ('18', '1', '1', null, '14', '12', '1', '999.99', '130002', '2016-11-21 09:38:24', '');
INSERT INTO `project_purchase_task` VALUES ('19', '12', '12', null, '1', '15', '2', '333', '130002', '2016-11-23 13:59:50', '');

-- ----------------------------
-- Table structure for `project_requirement`
-- ----------------------------
DROP TABLE IF EXISTS `project_requirement`;
CREATE TABLE `project_requirement` (
  `proj_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意需求ID',
  `parent_proj_id` bigint(20) DEFAULT NULL COMMENT '父创意需求ID',
  `publish_user_id` bigint(20) DEFAULT NULL COMMENT '发布方ID',
  `proj_name` varchar(200) DEFAULT NULL COMMENT '创意需求名称',
  `proj_close_date` date DEFAULT NULL COMMENT '创意需求报名截止日期',
  `proj_devlier_date` date DEFAULT NULL COMMENT '创意需求交付日期',
  `proj_estimate` int(11) DEFAULT NULL COMMENT '创意需求选择承接人时间',
  `proj_file_name` varchar(50) DEFAULT NULL COMMENT '创意需求附件名称',
  `proj_attach_file` varchar(200) DEFAULT NULL COMMENT '创意需求附件',
  `proj_service_fee` decimal(10,2) DEFAULT NULL COMMENT '创意需求酬金',
  `proj_see_file_path` varchar(200) DEFAULT NULL COMMENT '创意需求附件预览',
  `manager_user_id` bigint(20) DEFAULT NULL COMMENT '负责人ID',
  `proj_fee_currency` varchar(10) DEFAULT NULL COMMENT '币种',
  `proj_flow_status` int(11) DEFAULT NULL COMMENT '创意需求状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除状态',
  `is_project` bit(1) DEFAULT b'0' COMMENT '是否为项目',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `proj_start_date` date DEFAULT NULL COMMENT '报名开始时间',
  `proj_enroll_status` int(11) DEFAULT NULL COMMENT '报名状态',
  `provider_type` varchar(50) DEFAULT NULL COMMENT '供方类型',
  `authentication_requirement` varchar(50) DEFAULT NULL COMMENT '认证要求',
  `publish_way` varchar(50) DEFAULT NULL COMMENT '发布方式',
  `is_fee_trusteeship` bit(1) DEFAULT b'1' COMMENT '酬金是否托管',
  `is_open` bit(1) DEFAULT b'1' COMMENT '是否公开',
  PRIMARY KEY (`proj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8 COMMENT='创意需求';

-- ----------------------------
-- Records of project_requirement
-- ----------------------------
INSERT INTO `project_requirement` VALUES ('1', '1', '1', 'abc123', '2016-11-01', '2016-11-12', '30', null, null, '123123.55', null, null, '', '400102', '', '', '2016-11-15 10:59:14', null, '401102', '1,2', '1,2,3', '1,2,3', '', '');
INSERT INTO `project_requirement` VALUES ('2', '2', '1', 'bbb111', '2016-11-14', '2016-11-23', '333', null, null, '334.00', null, null, null, '400102', '', '', '2016-11-15 11:06:51', null, '401101', '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('3', '3', '11', 'aaaaa333444555', '2016-11-06', '2016-11-22', '456', null, null, '345.00', null, '2', null, '400103', '', '', '2016-11-15 11:07:12', null, '401104', '1,2', '1,2,3', '1,2,3', '', '');
INSERT INTO `project_requirement` VALUES ('4', '4', '1', '12345aaaaa', '2016-11-14', '2016-11-22', '43', null, null, '2342.00', null, '2', null, '400103', '', '', '2016-11-15 11:07:31', null, '401105', '2', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('32', null, '1', 'aaaaaaaaaaaaaaaaab1', '2016-11-20', '2016-11-16', '333', null, null, '33.00', null, '1', null, '400103', '', '', '2016-11-15 11:36:52', null, '401105', '1,2', '1,2,3', '1,2,3', '', '');
INSERT INTO `project_requirement` VALUES ('33', null, '1', 'aaaaaa', '2016-11-13', '2016-11-28', '22', null, null, '111.00', null, '1', null, '400103', '', '', '2016-11-15 11:38:53', null, '401105', '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('34', null, '1', '测试01', '2016-11-21', '2016-11-29', '111', null, null, '111.00', null, '1', null, '400101', '', '', '2016-11-15 11:46:44', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('35', null, '1', '111', '2016-11-01', '2016-11-09', '2', null, null, '11.00', null, '1', null, '400101', '', '', '2016-11-15 13:39:08', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('36', null, '1', '112', '2016-11-01', '2016-11-03', '1', null, null, '222.00', null, null, null, '400101', '', '', '2016-11-15 13:39:54', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('37', null, '1', '2132', '2016-11-09', '2016-11-16', '1', null, null, '1.00', null, null, null, '400101', '', '', '2016-11-15 13:41:23', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('38', null, '1', '3333', '2016-11-10', '2016-11-24', '2', null, null, '11.00', null, null, null, '400101', '', '', '2016-11-15 13:42:02', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('39', null, '1', '11321321', '2016-11-01', '2016-11-09', '1', null, null, '1.00', null, null, null, '400101', '', '', '2016-11-15 13:52:28', null, null, '1', '1,3', '1,2', '', '');
INSERT INTO `project_requirement` VALUES ('40', null, '1', '333', '2016-11-16', '2016-11-24', '3', null, null, '1.00', null, null, null, '400101', '', '', '2016-11-15 13:52:53', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('41', null, '1', 'aa111', '2016-11-20', '2016-11-28', '11', null, null, '11.00', null, null, null, '400101', '', '', '2016-11-15 13:58:24', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('42', null, '1', 'bbb', '2016-11-20', '2016-11-28', '11', null, null, '111.00', null, null, null, '400101', '', '', '2016-11-15 14:12:14', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('43', null, '1', 'abcde', '2016-11-21', '2016-11-29', '23', null, null, '22.00', null, null, null, '400101', '', '', '2016-11-15 14:20:53', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('44', null, '1', 'abcdefg', '2016-11-14', '2016-11-29', '111', null, null, '111.00', null, null, null, '400701', '', '', '2016-11-15 14:35:34', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('45', null, '1', 'qweerty', '2016-11-20', '2016-11-28', '11', null, null, '11.00', null, null, null, '400102', '', '', '2016-11-15 14:36:03', null, null, '2', '1,2,3', '1,2,3', '', '');
INSERT INTO `project_requirement` VALUES ('48', null, '1', 'aaa', '2016-11-13', '2016-11-29', '11', null, null, '111.00', null, null, null, '400702', '', '', '2016-11-15 15:09:21', null, null, '1,2', '1,2,3', '1,2,3', '', '');
INSERT INTO `project_requirement` VALUES ('49', null, '1', 'aaa111', '2016-11-13', '2016-11-28', '111', null, null, '111.00', null, null, null, '400105', '', '', '2016-11-15 15:10:58', null, null, '1,2', '1,2,3', '1,2,3', '', '');
INSERT INTO `project_requirement` VALUES ('50', null, '1', 'aaa222', '2016-11-01', '2016-11-30', '222', null, null, '222.00', null, null, null, '400703', '', '', '2016-11-15 15:11:17', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('51', null, '1', 'aaa333', '2016-11-14', '2016-11-30', '333', null, null, '333.00', null, null, null, '400105', '', '', '2016-11-15 15:11:33', null, null, '1', '2', '3', '', '');
INSERT INTO `project_requirement` VALUES ('52', null, '1', 'aaa444', '2016-11-15', '2016-11-16', '44', null, null, '444.00', null, null, null, '400105', '', '', '2016-11-15 15:17:06', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('53', null, '1', 'aaa555', '2016-11-21', '2016-11-29', '5', null, null, '55.00', null, null, null, '400105', '', '', '2016-11-15 15:17:20', null, null, '2', '2', '2', '', '');
INSERT INTO `project_requirement` VALUES ('54', null, '1', 'aaa666', '2016-11-16', '2016-11-24', '6', null, null, '66.00', null, null, null, '400105', '', '', '2016-11-15 15:17:34', null, null, '2', '2', '3', '', '');
INSERT INTO `project_requirement` VALUES ('55', null, '1', 'aaa777', '2016-11-22', '2016-11-22', '7', null, null, '77.00', null, null, null, '400105', '', '', '2016-11-15 15:45:37', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('56', null, '1', 'aaa888', '2016-11-16', '2016-11-24', '88', null, null, '8.00', null, null, null, '400105', '', '', '2016-11-15 15:46:06', null, null, '2', '2', '2', '', '');
INSERT INTO `project_requirement` VALUES ('57', null, '1', 'aaaa', '2016-11-07', '2016-11-29', '22', null, null, '1.00', null, null, null, '400105', '', '', '2016-11-15 17:45:06', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('58', null, '1', 'bbssdd', '2016-11-07', '2016-11-23', '234', null, null, '123.00', null, null, null, '400105', '', '', '2016-11-15 18:17:07', null, null, '1,2', '1,2,3', '1,2,3', '', '');
INSERT INTO `project_requirement` VALUES ('59', null, '1', 'ccc123', '2016-11-06', '2016-11-22', '123', null, null, '123.00', null, null, null, '400105', '', '', '2016-11-15 19:18:58', null, null, '1,2', '1,2,3', '1,2,3', '', '');
INSERT INTO `project_requirement` VALUES ('60', null, '1', 'asdfghjkl', '2016-11-14', '2016-11-29', '456', null, null, '3456.00', null, null, null, '400105', '', '', '2016-11-15 19:28:50', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('61', null, '1', 'aqzxsw', '2016-11-21', '2016-11-30', '123', null, null, '123.00', null, null, null, '400105', '', '', '2016-11-15 19:44:35', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('62', null, '1', 'qwertyuiop', '2016-11-24', '2016-12-10', '123', null, null, '1234567.00', null, null, null, '400105', '', '', '2016-11-15 19:46:07', null, null, '1', '2', '3', '', '');
INSERT INTO `project_requirement` VALUES ('63', null, '1', 'wsx', '2016-11-21', '2016-11-29', '123', null, null, '123.00', null, null, null, '400102', '', '', '2016-11-15 19:51:20', null, null, '1', '1,2', '1,3', '', '');
INSERT INTO `project_requirement` VALUES ('64', null, '1', 'plmkojn', '2016-11-29', '2016-11-29', '12', null, null, '123.00', null, null, null, '400102', '', '', '2016-11-15 19:56:42', null, '401102', '1,2', '3', '1', '', '');
INSERT INTO `project_requirement` VALUES ('65', null, '1', 'asd', '2016-11-30', '2016-11-24', '345', null, null, '3.00', null, null, null, '400102', '', '', '2016-11-15 20:01:37', null, null, '2', '2', '2', '', '');
INSERT INTO `project_requirement` VALUES ('66', null, '1', 'asdfg', '2016-11-22', '2016-11-07', '7', null, null, '677.00', null, null, null, '400102', '', '', '2016-11-15 20:02:24', null, '401102', '2', '1', '2', '', '');
INSERT INTO `project_requirement` VALUES ('67', null, '1', 'asdfg', '2016-11-22', '2016-11-07', '7', null, null, '677.00', null, null, null, '400102', '', '', '2016-11-15 20:02:47', null, null, '2', '1', '2', '', '');
INSERT INTO `project_requirement` VALUES ('68', null, '1', 'azxs', '2016-11-21', '2016-11-29', '3', null, null, '2.00', null, null, null, '400102', '', '', '2016-11-15 20:04:57', null, null, '1', '2', '3', '', '');
INSERT INTO `project_requirement` VALUES ('69', null, '1', 'azxs', '2016-11-21', '2016-11-29', '3', null, null, '2.00', null, null, null, '400102', '', '', '2016-11-15 20:05:05', null, null, '1', '2', '3', '', '');
INSERT INTO `project_requirement` VALUES ('70', null, '1', 'asdfghtr', '2016-11-13', '2016-11-22', '232', null, null, '234.00', null, null, null, '400105', '', '', '2016-11-15 20:11:33', null, null, '2', '1', '2', '', '');
INSERT INTO `project_requirement` VALUES ('71', null, '1', 'ybgtfv', '2016-11-21', '2016-11-23', '45', null, null, '4.00', null, null, null, '400102', '', '', '2016-11-15 20:14:25', null, null, '2', '2,3', '1,2', '', '');
INSERT INTO `project_requirement` VALUES ('72', null, '1', '1123', '2016-11-21', '2016-11-30', '312', null, null, '334.00', null, null, null, '400105', '', '', '2016-11-15 20:17:56', null, null, '2', '2', '2', '', '');
INSERT INTO `project_requirement` VALUES ('73', null, '1', 'aaa', '2016-11-29', '2016-11-30', '435', null, null, '23.00', null, null, null, '400105', '', '', '2016-11-15 20:20:10', null, '401102', '2', '2', '2', '', '');
INSERT INTO `project_requirement` VALUES ('74', null, '1', 'aa', '2016-11-21', '2016-11-29', '324', null, null, '232.00', null, null, null, '400105', '', '', '2016-11-15 20:27:04', null, '401102', '1', '2', '2', '', '');
INSERT INTO `project_requirement` VALUES ('75', null, '1', 'fesdf', '2016-11-28', '2016-11-30', '3212', null, null, '322.00', null, null, null, '400105', '', '', '2016-11-15 20:27:32', null, '401102', '2', '2', '2', '', '');
INSERT INTO `project_requirement` VALUES ('76', null, '1', 'sdfsd', '2016-11-14', '2016-11-23', '234321', null, null, '432.00', null, null, null, '400105', '', '', '2016-11-15 20:28:22', null, '401102', '2', '2', '2', '', '');
INSERT INTO `project_requirement` VALUES ('77', null, '2', '20', '2016-11-09', '2016-11-30', '232', null, null, '100.00', null, null, null, '400105', '', '', '2016-11-16 18:03:52', null, '401102', '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('78', null, '2', 'test', '2016-11-09', '2016-11-23', '34', null, null, '1000.00', null, null, null, '400105', '', '', '2016-11-16 18:21:10', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('79', null, '1', '1212', '2016-11-01', '2016-11-16', '1', null, null, '11.00', null, null, null, '400102', '', '', '2016-11-17 09:45:18', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('80', null, '1', '111', '2016-11-07', '2016-11-14', '11', null, null, '111.00', null, null, null, '400103', '', '', '2016-11-17 16:44:36', null, null, '2', '2,3', '1,2', '', '');
INSERT INTO `project_requirement` VALUES ('81', null, '1', '123', '2016-10-30', '2016-11-15', '12', null, null, '123.00', null, null, null, '400105', '', '', '2016-11-21 14:06:40', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('82', null, '1', '112', '2016-11-01', '2016-11-03', '1', null, null, '222.00', null, null, null, '400102', '', '', '2016-11-21 14:08:47', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('85', null, '1', '测试测试', '2016-11-01', '2016-11-03', '1', null, 'resources/images/front/upload.png', '222.00', null, null, null, '400104', '', '', '2016-11-21 14:26:19', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('86', null, '1', 'aawervghd', '2016-11-14', '2016-11-29', '34', null, null, '2312.00', null, null, null, '400102', '', '', '2016-11-21 20:22:19', null, null, '1,2', '1,2,3', '1,2,3', '', '');
INSERT INTO `project_requirement` VALUES ('87', null, '1', 'adsaf', '2016-11-22', '2016-11-22', '2', null, null, '12312.00', null, null, null, '400102', '', '', '2016-11-22 20:35:23', null, null, '1', '1,3', '1,2', '', '');
INSERT INTO `project_requirement` VALUES ('88', null, '1', 'asdfcxz', '2016-11-21', '2016-11-29', '121', null, null, '2233.00', null, null, null, '400105', '', '', '2016-11-22 20:46:52', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('89', null, '1', 'gds', '2016-12-01', '2016-12-08', '123', null, 'file/files/1479819622666.xlsx', '123.00', null, null, null, '400102', '', '', '2016-11-22 21:01:21', null, null, '1,2', '1,2,3', '1,2,3', '', '');
INSERT INTO `project_requirement` VALUES ('90', null, '1', '12312', '2016-12-28', '2016-12-14', '123123', null, 'file/files/1479819622666.xlsx', '213.00', null, null, null, '400102', '', '', '2016-11-22 21:03:26', null, null, '1,2', '1,2,3', '1,2,3', '', '');
INSERT INTO `project_requirement` VALUES ('91', null, '1', '213123', '2016-11-22', '2016-11-22', '123', null, 'file/files/1479820952611.xlsx', '123.00', null, null, null, '400102', '', '', '2016-11-22 21:22:51', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('92', null, '1', '213', '2016-11-22', '2016-11-22', '123', null, 'file/files/1479820952611.xlsx', '213.00', null, null, null, '400102', '', '', '2016-11-22 21:24:05', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('93', null, '1', '123123', '2016-11-22', '2016-11-22', '123', null, 'file/files/1479821935428.xlsx', '123.00', null, null, null, '400102', '', '', '2016-11-22 21:39:04', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('94', null, '1', '213123', '2016-11-22', '2016-11-22', '213', null, 'file/files/1479822044711.xlsx', '123.00', null, null, null, '400102', '', '', '2016-11-22 21:40:55', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('95', null, '1', '12312', '2016-11-22', '2016-11-22', '213', null, 'file/files/1479822044711.xlsx', '21312.00', null, null, null, '400102', '', '', '2016-11-22 21:44:21', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('96', null, '1', '213123', '2016-11-22', '2016-11-22', '123', null, 'file/files/1479822535364.xlsx', '123.00', null, null, null, '400102', '', '', '2016-11-22 21:49:34', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('97', null, '1', '123123', '2016-11-22', '2016-11-22', '123', null, 'file/files/1479823372219.xlsx', '123.00', null, null, null, '400102', '', '', '2016-11-22 22:02:56', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('98', null, '1', '213123', '2016-11-22', '2016-11-22', '123', null, 'file/files/1479823372219.xlsx', '21312.00', null, null, null, '400102', '', '', '2016-11-22 22:03:38', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('99', null, '1', '12312', '2016-11-22', '2016-11-22', '213', null, 'file/files/1479823372219.xlsx', '21312.00', null, null, null, '400102', '', '', '2016-11-22 22:05:36', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('100', null, '1', 'asdewq', '2016-11-21', '2016-11-29', '342', null, 'file/files/1479864394056.jpg', '232.00', null, null, null, '400105', '', '', '2016-11-23 09:26:42', null, null, '1', '1', '2', '', '');
INSERT INTO `project_requirement` VALUES ('101', null, '1', 'ergdffgs', '2016-11-14', '2016-11-30', '342', null, 'file/files/1479864394056.jpg', '32.00', null, null, null, '400105', '', '', '2016-11-23 09:27:09', null, null, '1,2', '1,2,3', '2,3', '', '');
INSERT INTO `project_requirement` VALUES ('102', null, '1', 'asdfbvc', '2016-11-22', '2016-11-23', '32', null, 'file/files/1479864510213.jpg', '3.00', null, null, null, '400105', '', '', '2016-11-23 09:28:37', null, null, '2', '3', '3', '', '');
INSERT INTO `project_requirement` VALUES ('103', null, '1', 'hgnfdc2332', '2016-11-02', '2016-11-24', '22', null, 'file/files/1479864510213.jpg', '332.00', null, null, null, '400105', '', '', '2016-11-23 09:29:10', null, null, '2', '3', '3', '', '');
INSERT INTO `project_requirement` VALUES ('104', null, '1', 'a123456', '2016-11-14', '2016-11-29', '223', null, 'file/files/1479865031174.jpg', '345.00', null, null, null, '400105', '', '', '2016-11-23 09:37:18', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('105', null, '1', '1231', '2016-11-23', '2016-11-23', '123', null, 'file/files/1479865195885.xlsx', '123.00', null, null, null, '400102', '', '', '2016-11-23 09:40:35', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('106', null, '1', 'qazxsw', '2016-11-21', '2016-11-30', '23', null, 'file/files/1479865245687.jpg', '22.00', null, null, null, '400105', '', '', '2016-11-23 09:40:53', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('107', null, '1', '1231', '2016-11-23', '2016-11-23', '123', null, 'file/files/1479865195885.xlsx', '213.00', null, null, null, '400102', '', '', '2016-11-23 09:41:17', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('108', null, '1', '1234gdxc', '2016-11-14', '2016-11-30', '432', null, 'file/files/1479865372003.jpg', '32.00', null, null, null, '400105', '', '', '2016-11-23 09:42:58', null, null, '1', '1', '1', '', '');
INSERT INTO `project_requirement` VALUES ('109', null, '1', 'aqsd343', '2016-11-07', '2016-11-29', '342', null, 'file/files/1479865554869.jpg', '423.00', null, null, null, '400105', '', '', '2016-11-23 09:46:01', null, null, '2', '3', '3', '', '');
INSERT INTO `project_requirement` VALUES ('110', null, '1', 'asasaa', '2016-11-21', '2016-11-22', '22', null, 'file/files/1479865676608.jpg', '22.00', null, null, null, '400105', '', '', '2016-11-23 09:48:03', null, null, '2', '1', '2', '', '');
INSERT INTO `project_requirement` VALUES ('111', null, '1', '123321aaa', '2016-11-07', '2016-11-23', '332', null, 'file/files/1479867092509.jpg', '323.00', null, null, null, '400105', '', '', '2016-11-23 10:11:39', null, null, '2', '2', '2', '', '');
INSERT INTO `project_requirement` VALUES ('112', null, '1', '355ggfgg', '2016-11-21', '2016-11-29', '4343', null, 'file/files/1479867119576.jpg', '4343.00', null, null, null, '400105', '', '', '2016-11-23 10:12:06', null, null, '2', '1', '3', '', '');

-- ----------------------------
-- Table structure for `project_requirement_change`
-- ----------------------------
DROP TABLE IF EXISTS `project_requirement_change`;
CREATE TABLE `project_requirement_change` (
  `proj_requirement_change_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意需求变更ID',
  `proj_requirement_id` bigint(20) DEFAULT NULL COMMENT '创意需求ID',
  `publish_user_id` bigint(20) DEFAULT NULL COMMENT '发起人ID',
  `target_user_id` bigint(20) DEFAULT NULL COMMENT '对象ID',
  `proj_budget` float DEFAULT NULL COMMENT '预算',
  `change_content` varchar(1000) DEFAULT NULL COMMENT '变更内容',
  `start_datetime` datetime DEFAULT NULL COMMENT '预计开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '预计结束世间',
  `change_status` int(11) DEFAULT NULL COMMENT '变更状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`proj_requirement_change_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='创意需求变更';

-- ----------------------------
-- Records of project_requirement_change
-- ----------------------------
INSERT INTO `project_requirement_change` VALUES ('1', '1', '1', '2', '10000200', '2', '2016-11-11 00:00:00', '2016-11-11 00:00:00', '400902', '2016-11-09 13:21:42', '');
INSERT INTO `project_requirement_change` VALUES ('2', '1', '1', '1', '10086.1', '变更个毛线啊，混蛋！', '2016-11-09 08:00:00', '2017-01-02 08:00:00', '400901', '2016-11-09 14:35:32', '');
INSERT INTO `project_requirement_change` VALUES ('3', '1', null, null, null, '变更个毛线', '2016-11-20 08:00:00', '2016-11-22 08:00:00', '400901', '2016-11-20 20:03:24', '');
INSERT INTO `project_requirement_change` VALUES ('4', '1', null, '2', null, '变更个毛线', '2016-11-20 08:00:00', '2016-11-22 08:00:00', '400901', '2016-11-20 20:04:55', '');
INSERT INTO `project_requirement_change` VALUES ('5', '1', null, '3', null, '变更个毛线', '2016-11-20 08:00:00', '2016-11-22 08:00:00', '400901', '2016-11-20 20:04:55', '');
INSERT INTO `project_requirement_change` VALUES ('6', '1', null, '4', null, '变更个毛线', '2016-11-20 08:00:00', '2016-11-22 08:00:00', '400901', '2016-11-20 20:04:55', '');
INSERT INTO `project_requirement_change` VALUES ('7', '1', '1', '3', null, '变更个毛线', '2016-11-20 08:00:00', '2016-11-22 08:00:00', '400901', '2016-11-20 20:24:33', '');
INSERT INTO `project_requirement_change` VALUES ('8', '1', '1', '4', null, '变更个毛线', '2016-11-20 08:00:00', '2016-11-22 08:00:00', '400901', '2016-11-20 20:24:33', '');
INSERT INTO `project_requirement_change` VALUES ('9', '1', '1', '5', null, '变更个毛线', '2016-11-20 08:00:00', '2016-11-22 08:00:00', '400901', '2016-11-20 20:24:33', '');

-- ----------------------------
-- Table structure for `project_requirement_class`
-- ----------------------------
DROP TABLE IF EXISTS `project_requirement_class`;
CREATE TABLE `project_requirement_class` (
  `proj_requirement_class_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意需求分类ID',
  `proj_require_id` bigint(20) DEFAULT NULL COMMENT '创意需求ID',
  `proj_require_class_value` int(11) DEFAULT NULL COMMENT '创意需求分类值',
  PRIMARY KEY (`proj_requirement_class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8 COMMENT='创意需求分类';

-- ----------------------------
-- Records of project_requirement_class
-- ----------------------------
INSERT INTO `project_requirement_class` VALUES ('1', '1', '100101');
INSERT INTO `project_requirement_class` VALUES ('2', '1', '100102');
INSERT INTO `project_requirement_class` VALUES ('3', '1', '100103');
INSERT INTO `project_requirement_class` VALUES ('4', '4', '2');
INSERT INTO `project_requirement_class` VALUES ('5', '5', '2');
INSERT INTO `project_requirement_class` VALUES ('12', '7', '2');
INSERT INTO `project_requirement_class` VALUES ('13', '6', '6');
INSERT INTO `project_requirement_class` VALUES ('14', '8', '2');
INSERT INTO `project_requirement_class` VALUES ('15', '9', '6');
INSERT INTO `project_requirement_class` VALUES ('16', '10', '7');
INSERT INTO `project_requirement_class` VALUES ('17', '11', '8');
INSERT INTO `project_requirement_class` VALUES ('18', '12', '100102');
INSERT INTO `project_requirement_class` VALUES ('19', '13', '100103');
INSERT INTO `project_requirement_class` VALUES ('20', '14', '100101');
INSERT INTO `project_requirement_class` VALUES ('21', '15', '100101');
INSERT INTO `project_requirement_class` VALUES ('24', '18', '100104');
INSERT INTO `project_requirement_class` VALUES ('25', '19', '100101');
INSERT INTO `project_requirement_class` VALUES ('26', '20', '100103');
INSERT INTO `project_requirement_class` VALUES ('27', '21', '100104');
INSERT INTO `project_requirement_class` VALUES ('28', '22', '100106');
INSERT INTO `project_requirement_class` VALUES ('29', '23', '100103');
INSERT INTO `project_requirement_class` VALUES ('30', '24', '100101');
INSERT INTO `project_requirement_class` VALUES ('31', '25', '100102');
INSERT INTO `project_requirement_class` VALUES ('32', '26', '100105');
INSERT INTO `project_requirement_class` VALUES ('33', '27', '100102');
INSERT INTO `project_requirement_class` VALUES ('34', '28', '100101');
INSERT INTO `project_requirement_class` VALUES ('35', '29', '100102');
INSERT INTO `project_requirement_class` VALUES ('36', '30', '100103');
INSERT INTO `project_requirement_class` VALUES ('37', '31', '100104');
INSERT INTO `project_requirement_class` VALUES ('38', '32', '100102');
INSERT INTO `project_requirement_class` VALUES ('39', '33', '100102');
INSERT INTO `project_requirement_class` VALUES ('40', '34', '100101');
INSERT INTO `project_requirement_class` VALUES ('41', '35', '100101');
INSERT INTO `project_requirement_class` VALUES ('42', '36', '100101');
INSERT INTO `project_requirement_class` VALUES ('43', '37', '100101');
INSERT INTO `project_requirement_class` VALUES ('44', '38', '100101');
INSERT INTO `project_requirement_class` VALUES ('46', '40', '100101');
INSERT INTO `project_requirement_class` VALUES ('47', '41', '100102');
INSERT INTO `project_requirement_class` VALUES ('48', '42', '100102');
INSERT INTO `project_requirement_class` VALUES ('49', '43', '100101');
INSERT INTO `project_requirement_class` VALUES ('50', '44', '100101');
INSERT INTO `project_requirement_class` VALUES ('52', '46', '100102');
INSERT INTO `project_requirement_class` VALUES ('53', '47', '100102');
INSERT INTO `project_requirement_class` VALUES ('56', '45', '100102');
INSERT INTO `project_requirement_class` VALUES ('59', '39', '100102');
INSERT INTO `project_requirement_class` VALUES ('61', '48', '100102');
INSERT INTO `project_requirement_class` VALUES ('63', '50', '100106');
INSERT INTO `project_requirement_class` VALUES ('64', '51', '100103');
INSERT INTO `project_requirement_class` VALUES ('66', '49', '100101');
INSERT INTO `project_requirement_class` VALUES ('67', '52', '100101');
INSERT INTO `project_requirement_class` VALUES ('68', '53', '100102');
INSERT INTO `project_requirement_class` VALUES ('69', '54', '100102');
INSERT INTO `project_requirement_class` VALUES ('70', '55', '100103');
INSERT INTO `project_requirement_class` VALUES ('71', '56', '100102');
INSERT INTO `project_requirement_class` VALUES ('72', '57', '100101');
INSERT INTO `project_requirement_class` VALUES ('73', '58', '100101');
INSERT INTO `project_requirement_class` VALUES ('79', '59', '100101');
INSERT INTO `project_requirement_class` VALUES ('80', '59', '100102');
INSERT INTO `project_requirement_class` VALUES ('81', '60', '100101');
INSERT INTO `project_requirement_class` VALUES ('82', '60', '100102');
INSERT INTO `project_requirement_class` VALUES ('83', '61', '100101');
INSERT INTO `project_requirement_class` VALUES ('84', '61', '100102');
INSERT INTO `project_requirement_class` VALUES ('85', '61', '100103');
INSERT INTO `project_requirement_class` VALUES ('86', '62', '100101');
INSERT INTO `project_requirement_class` VALUES ('87', '62', '100102');
INSERT INTO `project_requirement_class` VALUES ('88', '62', '100103');
INSERT INTO `project_requirement_class` VALUES ('89', '62', '100104');
INSERT INTO `project_requirement_class` VALUES ('90', '62', '100105');
INSERT INTO `project_requirement_class` VALUES ('91', '62', '100106');
INSERT INTO `project_requirement_class` VALUES ('93', '64', '100101');
INSERT INTO `project_requirement_class` VALUES ('94', '64', '100102');
INSERT INTO `project_requirement_class` VALUES ('95', '65', '100101');
INSERT INTO `project_requirement_class` VALUES ('96', '65', '100102');
INSERT INTO `project_requirement_class` VALUES ('97', '66', '100101');
INSERT INTO `project_requirement_class` VALUES ('98', '66', '100103');
INSERT INTO `project_requirement_class` VALUES ('99', '66', '100104');
INSERT INTO `project_requirement_class` VALUES ('100', '67', '100101');
INSERT INTO `project_requirement_class` VALUES ('101', '67', '100103');
INSERT INTO `project_requirement_class` VALUES ('102', '67', '100104');
INSERT INTO `project_requirement_class` VALUES ('103', '68', '100101');
INSERT INTO `project_requirement_class` VALUES ('105', '69', '100101');
INSERT INTO `project_requirement_class` VALUES ('106', '63', '100101');
INSERT INTO `project_requirement_class` VALUES ('107', '70', '100102');
INSERT INTO `project_requirement_class` VALUES ('108', '70', '100105');
INSERT INTO `project_requirement_class` VALUES ('112', '73', '100102');
INSERT INTO `project_requirement_class` VALUES ('113', '73', '100103');
INSERT INTO `project_requirement_class` VALUES ('114', '74', '100102');
INSERT INTO `project_requirement_class` VALUES ('115', '75', '100102');
INSERT INTO `project_requirement_class` VALUES ('116', '76', '100102');
INSERT INTO `project_requirement_class` VALUES ('117', '76', '100104');
INSERT INTO `project_requirement_class` VALUES ('118', '77', '100101');
INSERT INTO `project_requirement_class` VALUES ('119', '78', '100101');
INSERT INTO `project_requirement_class` VALUES ('120', '79', '100101');
INSERT INTO `project_requirement_class` VALUES ('121', '72', '100101');
INSERT INTO `project_requirement_class` VALUES ('122', '72', '100103');
INSERT INTO `project_requirement_class` VALUES ('123', '71', '100101');
INSERT INTO `project_requirement_class` VALUES ('124', '71', '100102');
INSERT INTO `project_requirement_class` VALUES ('125', '71', '100103');
INSERT INTO `project_requirement_class` VALUES ('126', '80', '100101');
INSERT INTO `project_requirement_class` VALUES ('127', '80', '100102');
INSERT INTO `project_requirement_class` VALUES ('128', '80', '100103');
INSERT INTO `project_requirement_class` VALUES ('129', '81', '100101');
INSERT INTO `project_requirement_class` VALUES ('131', '83', '100101');
INSERT INTO `project_requirement_class` VALUES ('132', '84', '100101');
INSERT INTO `project_requirement_class` VALUES ('133', '85', '100101');
INSERT INTO `project_requirement_class` VALUES ('134', '85', '100102');
INSERT INTO `project_requirement_class` VALUES ('135', '85', '100103');
INSERT INTO `project_requirement_class` VALUES ('136', '85', '100104');
INSERT INTO `project_requirement_class` VALUES ('146', '86', '100101');
INSERT INTO `project_requirement_class` VALUES ('147', '86', '100102');
INSERT INTO `project_requirement_class` VALUES ('148', '86', '100103');
INSERT INTO `project_requirement_class` VALUES ('149', '82', '100101');
INSERT INTO `project_requirement_class` VALUES ('150', '87', '100101');
INSERT INTO `project_requirement_class` VALUES ('151', '87', '100102');
INSERT INTO `project_requirement_class` VALUES ('152', '88', '100101');
INSERT INTO `project_requirement_class` VALUES ('153', '89', '100101');
INSERT INTO `project_requirement_class` VALUES ('154', '89', '100102');
INSERT INTO `project_requirement_class` VALUES ('155', '89', '100103');
INSERT INTO `project_requirement_class` VALUES ('156', '90', '100101');
INSERT INTO `project_requirement_class` VALUES ('157', '90', '100102');
INSERT INTO `project_requirement_class` VALUES ('158', '90', '100103');
INSERT INTO `project_requirement_class` VALUES ('159', '91', '100101');
INSERT INTO `project_requirement_class` VALUES ('160', '91', '100102');
INSERT INTO `project_requirement_class` VALUES ('161', '92', '100101');
INSERT INTO `project_requirement_class` VALUES ('162', '92', '100102');
INSERT INTO `project_requirement_class` VALUES ('163', '93', '100101');
INSERT INTO `project_requirement_class` VALUES ('164', '94', '100101');
INSERT INTO `project_requirement_class` VALUES ('165', '95', '100101');
INSERT INTO `project_requirement_class` VALUES ('166', '96', '100101');
INSERT INTO `project_requirement_class` VALUES ('167', '97', '100101');
INSERT INTO `project_requirement_class` VALUES ('168', '98', '100101');
INSERT INTO `project_requirement_class` VALUES ('169', '99', '100101');
INSERT INTO `project_requirement_class` VALUES ('170', '100', '100101');
INSERT INTO `project_requirement_class` VALUES ('171', '100', '100102');
INSERT INTO `project_requirement_class` VALUES ('172', '101', '100101');
INSERT INTO `project_requirement_class` VALUES ('173', '101', '100102');
INSERT INTO `project_requirement_class` VALUES ('174', '101', '100103');
INSERT INTO `project_requirement_class` VALUES ('175', '102', '100103');
INSERT INTO `project_requirement_class` VALUES ('176', '103', '100103');
INSERT INTO `project_requirement_class` VALUES ('177', '103', '100104');
INSERT INTO `project_requirement_class` VALUES ('178', '104', '100102');
INSERT INTO `project_requirement_class` VALUES ('179', '105', '100101');
INSERT INTO `project_requirement_class` VALUES ('180', '106', '100102');
INSERT INTO `project_requirement_class` VALUES ('181', '107', '100101');
INSERT INTO `project_requirement_class` VALUES ('182', '108', '100102');
INSERT INTO `project_requirement_class` VALUES ('183', '109', '100102');
INSERT INTO `project_requirement_class` VALUES ('184', '110', '100102');
INSERT INTO `project_requirement_class` VALUES ('185', '111', '100101');
INSERT INTO `project_requirement_class` VALUES ('186', '111', '100102');
INSERT INTO `project_requirement_class` VALUES ('187', '112', '100102');

-- ----------------------------
-- Table structure for `project_requirement_description`
-- ----------------------------
DROP TABLE IF EXISTS `project_requirement_description`;
CREATE TABLE `project_requirement_description` (
  `proj_require_description_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意需求描述ID',
  `proj_require_id` bigint(20) DEFAULT NULL COMMENT '创意需求ID',
  `proj_require_description_content` varchar(800) DEFAULT NULL COMMENT '创意需求描述值',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`proj_require_description_id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8 COMMENT='创意需求描述';

-- ----------------------------
-- Records of project_requirement_description
-- ----------------------------
INSERT INTO `project_requirement_description` VALUES ('1', '4', '2', '2016-11-12 16:23:23');
INSERT INTO `project_requirement_description` VALUES ('2', '5', '2', '2016-11-12 16:25:36');
INSERT INTO `project_requirement_description` VALUES ('9', '7', '2', '2016-11-12 16:53:24');
INSERT INTO `project_requirement_description` VALUES ('10', '6', '6', '2016-11-12 17:06:22');
INSERT INTO `project_requirement_description` VALUES ('11', '8', '2', '2016-11-14 09:58:56');
INSERT INTO `project_requirement_description` VALUES ('12', '9', '6', '2016-11-14 10:10:20');
INSERT INTO `project_requirement_description` VALUES ('13', '10', '7', '2016-11-14 10:11:48');
INSERT INTO `project_requirement_description` VALUES ('14', '11', 'sdfdsz', '2016-11-14 10:19:46');
INSERT INTO `project_requirement_description` VALUES ('15', '12', 'fsdz', '2016-11-14 10:23:50');
INSERT INTO `project_requirement_description` VALUES ('16', '13', 'rewsrfas', '2016-11-14 10:45:52');
INSERT INTO `project_requirement_description` VALUES ('17', '14', 'fedsf', '2016-11-14 13:10:15');
INSERT INTO `project_requirement_description` VALUES ('18', '15', 'edfds', '2016-11-14 14:07:13');
INSERT INTO `project_requirement_description` VALUES ('21', '18', 'dfgsd', '2016-11-14 14:34:09');
INSERT INTO `project_requirement_description` VALUES ('22', '19', 'dfvas', '2016-11-14 16:55:56');
INSERT INTO `project_requirement_description` VALUES ('23', '20', 'fedsdfsaaaaaaaaaaaaa', '2016-11-14 16:59:00');
INSERT INTO `project_requirement_description` VALUES ('24', '21', 'luyiaaaaa', '2016-11-14 17:28:18');
INSERT INTO `project_requirement_description` VALUES ('25', '22', 'dsfdsa', '2016-11-14 21:21:34');
INSERT INTO `project_requirement_description` VALUES ('26', '23', 'awsfsdzzzzzzzzzzzzzzzzz', '2016-11-14 21:28:14');
INSERT INTO `project_requirement_description` VALUES ('27', '24', 'sdfdszgdfzs', '2016-11-15 10:49:03');
INSERT INTO `project_requirement_description` VALUES ('28', '25', 'fasdfszdfzxdfxzxzxzxzxzxz', '2016-11-15 10:50:41');
INSERT INTO `project_requirement_description` VALUES ('29', '26', 'dsggggggggggg', '2016-11-15 10:51:56');
INSERT INTO `project_requirement_description` VALUES ('30', '27', 'dfzx', '2016-11-15 10:55:36');
INSERT INTO `project_requirement_description` VALUES ('31', '28', 'aaaa', '2016-11-15 10:59:14');
INSERT INTO `project_requirement_description` VALUES ('32', '29', 'dfgvszddf', '2016-11-15 11:06:51');
INSERT INTO `project_requirement_description` VALUES ('33', '30', 'vsdxfzx', '2016-11-15 11:07:12');
INSERT INTO `project_requirement_description` VALUES ('34', '31', 'erdts', '2016-11-15 11:07:31');
INSERT INTO `project_requirement_description` VALUES ('35', '32', 'sadccccccccccz', '2016-11-15 11:36:52');
INSERT INTO `project_requirement_description` VALUES ('36', '33', 'sdfzs', '2016-11-15 11:38:53');
INSERT INTO `project_requirement_description` VALUES ('37', '34', '1111', '2016-11-15 11:46:44');
INSERT INTO `project_requirement_description` VALUES ('38', '35', '222', '2016-11-15 13:39:08');
INSERT INTO `project_requirement_description` VALUES ('39', '36', '11', '2016-11-15 13:39:54');
INSERT INTO `project_requirement_description` VALUES ('40', '37', '1', '2016-11-15 13:41:23');
INSERT INTO `project_requirement_description` VALUES ('41', '38', '2', '2016-11-15 13:42:02');
INSERT INTO `project_requirement_description` VALUES ('43', '40', '3', '2016-11-15 13:52:53');
INSERT INTO `project_requirement_description` VALUES ('44', '41', 'eqweas', '2016-11-15 13:58:24');
INSERT INTO `project_requirement_description` VALUES ('45', '42', 'aaaaaaaaaa', '2016-11-15 14:12:14');
INSERT INTO `project_requirement_description` VALUES ('46', '43', 'qqqqqq', '2016-11-15 14:20:53');
INSERT INTO `project_requirement_description` VALUES ('47', '44', 'aaaa', '2016-11-15 14:35:34');
INSERT INTO `project_requirement_description` VALUES ('49', '46', 'dszsdfs', '2016-11-15 14:42:27');
INSERT INTO `project_requirement_description` VALUES ('50', '47', 'dszsdfs', '2016-11-15 14:43:25');
INSERT INTO `project_requirement_description` VALUES ('53', '45', 'dszsdfs', '2016-11-15 15:03:36');
INSERT INTO `project_requirement_description` VALUES ('56', '39', '1', '2016-11-15 15:08:57');
INSERT INTO `project_requirement_description` VALUES ('58', '48', 'aaaaaaaa', '2016-11-15 15:09:34');
INSERT INTO `project_requirement_description` VALUES ('60', '50', 'aaaqqqq', '2016-11-15 15:11:17');
INSERT INTO `project_requirement_description` VALUES ('61', '51', 'asdffg', '2016-11-15 15:11:33');
INSERT INTO `project_requirement_description` VALUES ('63', '49', '123456789', '2016-11-15 15:11:54');
INSERT INTO `project_requirement_description` VALUES ('64', '52', 'aaaaaaaaaaaaaabbbbbbbbbbbbb', '2016-11-15 15:17:06');
INSERT INTO `project_requirement_description` VALUES ('65', '53', 'dasdasa', '2016-11-15 15:17:20');
INSERT INTO `project_requirement_description` VALUES ('66', '54', 'rtfdfsdas', '2016-11-15 15:17:34');
INSERT INTO `project_requirement_description` VALUES ('67', '55', 'fvsza', '2016-11-15 15:45:37');
INSERT INTO `project_requirement_description` VALUES ('68', '56', 'aaaaaaaaaaaaaaaa', '2016-11-15 15:46:06');
INSERT INTO `project_requirement_description` VALUES ('69', '57', 'sass', '2016-11-15 17:45:06');
INSERT INTO `project_requirement_description` VALUES ('70', '58', 'asdfghjkl', '2016-11-15 18:17:07');
INSERT INTO `project_requirement_description` VALUES ('73', '59', '2131231', '2016-11-15 19:20:42');
INSERT INTO `project_requirement_description` VALUES ('74', '60', 'dsa', '2016-11-15 19:28:50');
INSERT INTO `project_requirement_description` VALUES ('75', '61', 'asderty', '2016-11-15 19:44:35');
INSERT INTO `project_requirement_description` VALUES ('76', '62', 'azxsdcfvgg', '2016-11-15 19:46:07');
INSERT INTO `project_requirement_description` VALUES ('78', '64', 'asd', '2016-11-15 19:56:42');
INSERT INTO `project_requirement_description` VALUES ('79', '65', 'ssddc', '2016-11-15 20:01:37');
INSERT INTO `project_requirement_description` VALUES ('80', '66', 'jghf', '2016-11-15 20:02:24');
INSERT INTO `project_requirement_description` VALUES ('81', '67', 'jghf', '2016-11-15 20:02:47');
INSERT INTO `project_requirement_description` VALUES ('82', '68', 'sada', '2016-11-15 20:04:57');
INSERT INTO `project_requirement_description` VALUES ('84', '69', 'sada', '2016-11-15 20:05:16');
INSERT INTO `project_requirement_description` VALUES ('85', '63', 'aaa', '2016-11-15 20:05:20');
INSERT INTO `project_requirement_description` VALUES ('86', '70', 'sdsz', '2016-11-15 20:11:33');
INSERT INTO `project_requirement_description` VALUES ('89', '73', 'gdfgsd', '2016-11-15 20:20:10');
INSERT INTO `project_requirement_description` VALUES ('90', '74', 'fszfas', '2016-11-15 20:27:04');
INSERT INTO `project_requirement_description` VALUES ('91', '75', 'fasd', '2016-11-15 20:27:32');
INSERT INTO `project_requirement_description` VALUES ('92', '76', 'dsfzx', '2016-11-15 20:28:22');
INSERT INTO `project_requirement_description` VALUES ('93', '77', '23231', '2016-11-16 18:03:52');
INSERT INTO `project_requirement_description` VALUES ('94', '78', 'werewre', '2016-11-16 18:21:10');
INSERT INTO `project_requirement_description` VALUES ('95', '79', '1', '2016-11-17 09:45:18');
INSERT INTO `project_requirement_description` VALUES ('96', '72', 'sdfsa', '2016-11-17 16:43:53');
INSERT INTO `project_requirement_description` VALUES ('97', '71', 'fsdzsa', '2016-11-17 16:44:06');
INSERT INTO `project_requirement_description` VALUES ('98', '80', '111', '2016-11-17 16:44:36');
INSERT INTO `project_requirement_description` VALUES ('99', '81', '123', '2016-11-21 14:06:40');
INSERT INTO `project_requirement_description` VALUES ('101', '83', '11', '2016-11-21 14:10:06');
INSERT INTO `project_requirement_description` VALUES ('102', '84', '11', '2016-11-21 14:10:26');
INSERT INTO `project_requirement_description` VALUES ('103', '85', '11', '2016-11-21 14:26:19');
INSERT INTO `project_requirement_description` VALUES ('107', '86', 'aaaaaaaaaaaaa', '2016-11-21 20:22:38');
INSERT INTO `project_requirement_description` VALUES ('108', '82', '11', '2016-11-22 15:00:53');
INSERT INTO `project_requirement_description` VALUES ('109', '87', 'adsfadasdf', '2016-11-22 20:35:23');
INSERT INTO `project_requirement_description` VALUES ('110', '88', 'sdfzxfsz', '2016-11-22 20:46:52');
INSERT INTO `project_requirement_description` VALUES ('111', '89', '123123', '2016-11-22 21:01:21');
INSERT INTO `project_requirement_description` VALUES ('112', '90', '2131231', '2016-11-22 21:03:26');
INSERT INTO `project_requirement_description` VALUES ('113', '91', '123', '2016-11-22 21:22:51');
INSERT INTO `project_requirement_description` VALUES ('114', '92', '213', '2016-11-22 21:24:05');
INSERT INTO `project_requirement_description` VALUES ('115', '93', '23123', '2016-11-22 21:39:04');
INSERT INTO `project_requirement_description` VALUES ('116', '94', '123', '2016-11-22 21:40:55');
INSERT INTO `project_requirement_description` VALUES ('117', '95', '213', '2016-11-22 21:44:21');
INSERT INTO `project_requirement_description` VALUES ('118', '96', '123', '2016-11-22 21:49:34');
INSERT INTO `project_requirement_description` VALUES ('119', '97', '123', '2016-11-22 22:02:56');
INSERT INTO `project_requirement_description` VALUES ('120', '98', '12312312', '2016-11-22 22:03:38');
INSERT INTO `project_requirement_description` VALUES ('121', '99', '123123', '2016-11-22 22:05:36');
INSERT INTO `project_requirement_description` VALUES ('122', '100', 'dsfads', '2016-11-23 09:26:42');
INSERT INTO `project_requirement_description` VALUES ('123', '101', 'dxfdx', '2016-11-23 09:27:09');
INSERT INTO `project_requirement_description` VALUES ('124', '102', 'fsdfsd', '2016-11-23 09:28:37');
INSERT INTO `project_requirement_description` VALUES ('125', '103', 'fdfx', '2016-11-23 09:29:10');
INSERT INTO `project_requirement_description` VALUES ('126', '104', 'fsdfds', '2016-11-23 09:37:18');
INSERT INTO `project_requirement_description` VALUES ('127', '105', '123', '2016-11-23 09:40:35');
INSERT INTO `project_requirement_description` VALUES ('128', '106', 'dfs', '2016-11-23 09:40:53');
INSERT INTO `project_requirement_description` VALUES ('129', '107', '123', '2016-11-23 09:41:17');
INSERT INTO `project_requirement_description` VALUES ('130', '108', 'dfcxfxc', '2016-11-23 09:42:58');
INSERT INTO `project_requirement_description` VALUES ('131', '109', 'dfc', '2016-11-23 09:46:01');
INSERT INTO `project_requirement_description` VALUES ('132', '110', 'wad', '2016-11-23 09:48:03');
INSERT INTO `project_requirement_description` VALUES ('133', '111', 'fdfsda', '2016-11-23 10:11:39');
INSERT INTO `project_requirement_description` VALUES ('134', '112', 'gfdfs', '2016-11-23 10:12:06');

-- ----------------------------
-- Table structure for `project_requirement_recommend`
-- ----------------------------
DROP TABLE IF EXISTS `project_requirement_recommend`;
CREATE TABLE `project_requirement_recommend` (
  `recommend_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '推荐ID',
  `proj_id` bigint(20) DEFAULT NULL COMMENT '创意需求ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`recommend_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='创意需求推荐';

-- ----------------------------
-- Records of project_requirement_recommend
-- ----------------------------
INSERT INTO `project_requirement_recommend` VALUES ('3', '38', '1', '2016-11-16 18:09:06');
INSERT INTO `project_requirement_recommend` VALUES ('4', '38', '2', '2016-11-16 19:05:08');

-- ----------------------------
-- Table structure for `project_requirement_undertake`
-- ----------------------------
DROP TABLE IF EXISTS `project_requirement_undertake`;
CREATE TABLE `project_requirement_undertake` (
  `undertake_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '承接ID',
  `project_requirement_id` bigint(20) DEFAULT NULL COMMENT '创意需求ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '承接用户ID',
  `undertake_datetime` datetime DEFAULT NULL COMMENT '承接时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  `undertake_status` int(11) DEFAULT NULL COMMENT '承接状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `pass_day` int(11) DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`undertake_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='创意需求承接';

-- ----------------------------
-- Records of project_requirement_undertake
-- ----------------------------
INSERT INTO `project_requirement_undertake` VALUES ('1', '28', '2', '2016-11-25 08:00:00', '', '400902', null, null);
INSERT INTO `project_requirement_undertake` VALUES ('2', '1', '9', null, '', '401301', '2016-11-17 21:54:19', '2');
INSERT INTO `project_requirement_undertake` VALUES ('3', '1', '1', null, '', '401301', '2016-11-02 21:57:39', '2');
INSERT INTO `project_requirement_undertake` VALUES ('20', '38', '1', null, '', '401301', '2016-11-22 14:33:44', '123');

-- ----------------------------
-- Table structure for `project_task_change`
-- ----------------------------
DROP TABLE IF EXISTS `project_task_change`;
CREATE TABLE `project_task_change` (
  `project_task_change_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务变更ID',
  `proj_task_id` bigint(20) DEFAULT NULL COMMENT '任务ID',
  `publish_user_id` bigint(20) DEFAULT NULL COMMENT '发起人ID',
  `target_user_id` bigint(20) DEFAULT NULL COMMENT '发送对象ID',
  `proj_task_budget` float DEFAULT NULL COMMENT '预算',
  `proj_change_content` varchar(30) DEFAULT NULL COMMENT '任务变更内容',
  `proj_task_expect_start` datetime DEFAULT NULL COMMENT '任务预期开始时间',
  `proj_task_expect_finish` datetime DEFAULT NULL COMMENT '任务预期结束时间',
  `change_status` int(11) DEFAULT NULL COMMENT '变更状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`project_task_change_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='任务变更';

-- ----------------------------
-- Records of project_task_change
-- ----------------------------
INSERT INTO `project_task_change` VALUES ('1', '1', '1', null, null, 'dasdasd', '2016-11-13 00:00:00', '2016-11-13 00:00:00', '400902', '2016-11-10 17:11:49', '');
INSERT INTO `project_task_change` VALUES ('6', '2', '1', null, null, 'ceshi', '2016-11-10 08:00:00', null, null, '2016-11-10 18:00:46', '');
INSERT INTO `project_task_change` VALUES ('7', '2', null, null, null, 'ceshi', '2016-11-17 08:00:00', '2016-11-18 08:00:00', null, '2016-11-10 18:02:20', '');
INSERT INTO `project_task_change` VALUES ('8', '1', null, null, null, 'ceshi', '2016-11-24 08:00:00', '2016-11-30 08:00:00', null, '2016-11-10 18:04:33', '');
INSERT INTO `project_task_change` VALUES ('9', null, null, null, '0', '任务的变更1', null, null, '400902', '2016-11-16 15:12:15', '');
INSERT INTO `project_task_change` VALUES ('10', '1', '1', null, '0', 'dddasdee', null, null, '400902', '2016-11-16 16:09:26', '');
INSERT INTO `project_task_change` VALUES ('11', null, '1', null, '0', 'ddgggfd', null, null, '400901', '2016-11-16 21:41:36', '');
INSERT INTO `project_task_change` VALUES ('12', '1', '1', null, '0', 'hhhhfrr', null, null, '400902', '2016-11-16 21:48:19', '');
INSERT INTO `project_task_change` VALUES ('13', '1', '1', null, '0', 'erqwer', '2016-11-19 08:00:00', '2016-11-20 08:00:00', '400902', '2016-11-19 16:07:40', '');
INSERT INTO `project_task_change` VALUES ('14', '1', '1', null, '0', 'ceshiccc', '2016-11-19 08:00:00', '2016-11-20 08:00:00', '400902', '2016-11-19 16:08:46', '');
INSERT INTO `project_task_change` VALUES ('15', '1', '1', null, '0', '1', '2016-11-21 08:00:00', '2016-11-22 08:00:00', '400902', '2016-11-19 17:42:57', '');
INSERT INTO `project_task_change` VALUES ('16', '1', '1', null, '0', '2', '2016-11-21 08:00:00', '2016-11-22 08:00:00', '400901', '2016-11-19 19:32:14', '');
INSERT INTO `project_task_change` VALUES ('17', '1', '1', null, '0', '2', '2016-11-21 08:00:00', '2016-11-22 08:00:00', '400901', '2016-11-19 19:32:19', '');
INSERT INTO `project_task_change` VALUES ('18', '1', '1', null, '0', '4', '2016-11-21 08:00:00', '2016-11-22 08:00:00', '400902', '2016-11-19 19:32:52', '');
INSERT INTO `project_task_change` VALUES ('19', '1', '1', null, '0', '5', '2016-11-21 08:00:00', '2016-11-22 08:00:00', '400901', '2016-11-19 19:32:58', '');
INSERT INTO `project_task_change` VALUES ('20', '1', '1', null, '0', 're', '2016-11-29 08:00:00', '2016-11-30 08:00:00', '400901', '2016-11-19 19:37:18', '');

-- ----------------------------
-- Table structure for `project_task_detailplan`
-- ----------------------------
DROP TABLE IF EXISTS `project_task_detailplan`;
CREATE TABLE `project_task_detailplan` (
  `sub_task_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务计划ID',
  `project_task_id` bigint(20) DEFAULT NULL COMMENT '任务ID',
  `sub_plan_name` varchar(500) DEFAULT NULL COMMENT '任务计划名称',
  `parent_task_id` bigint(20) DEFAULT NULL COMMENT '前置计划ID',
  `plan_executant` bigint(20) DEFAULT NULL COMMENT '计划实施者',
  `start_date` date DEFAULT NULL COMMENT '开始时间',
  `finish_date` date DEFAULT NULL COMMENT '结束时间',
  `task_description` varchar(200) DEFAULT NULL COMMENT '任务描述',
  `real_start_date` date DEFAULT NULL COMMENT '实际开始时间',
  `real_finish_date` date DEFAULT NULL COMMENT '实际结束时间',
  `complete_status` int(11) DEFAULT NULL COMMENT '完成状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`sub_task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='任务计划';

-- ----------------------------
-- Records of project_task_detailplan
-- ----------------------------
INSERT INTO `project_task_detailplan` VALUES ('1', '1', 'caicc', '1', '1', '2016-11-01', '2016-11-08', null, '2016-11-22', null, '400303', '2016-11-08 18:46:57', '');
INSERT INTO `project_task_detailplan` VALUES ('2', '1', 'ceshi', '1', '1', '2016-11-03', '2016-11-06', 'aa', null, null, '400302', '2016-11-08 21:19:39', '');
INSERT INTO `project_task_detailplan` VALUES ('3', '1', '修改啊', '1', '1', '2016-11-21', '2016-11-23', '达到', null, null, '400302', '2016-11-08 21:29:41', '');
INSERT INTO `project_task_detailplan` VALUES ('4', '1', 'dsda', '1', '1', '2016-11-05', '2016-11-11', '内容描述1', '2016-11-05', '2016-11-15', '400302', '2016-11-09 11:09:53', '');
INSERT INTO `project_task_detailplan` VALUES ('5', '1', '集成测试', '4', '1', '2016-11-06', '2016-11-09', null, '2016-11-21', '2016-11-21', '400302', '2016-11-09 11:09:56', '');
INSERT INTO `project_task_detailplan` VALUES ('6', '1', '部署上线', '5', '1', '2016-11-07', '2016-11-12', null, '2016-11-08', '2016-11-21', '400302', '2016-11-09 11:10:00', '');

-- ----------------------------
-- Table structure for `project_user_releation`
-- ----------------------------
DROP TABLE IF EXISTS `project_user_releation`;
CREATE TABLE `project_user_releation` (
  `releation_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关系ID',
  `project_requirement_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `project_duty` varchar(100) DEFAULT NULL COMMENT '担任职务',
  `join_date` date DEFAULT NULL COMMENT '加入时间',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `leave_datetime` date DEFAULT NULL COMMENT '离开时间',
  `releation_status` int(11) DEFAULT NULL COMMENT '用户所处状态',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`releation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='项目用户关系';

-- ----------------------------
-- Records of project_user_releation
-- ----------------------------
INSERT INTO `project_user_releation` VALUES ('1', '1', '1', '项目经理', '2016-11-19', null, '2016-11-19', '400803', null, '', '2016-11-19 15:17:02');
INSERT INTO `project_user_releation` VALUES ('2', '2', '3', '架构师', '2016-11-19', null, '2016-11-19', '400802', null, '', '2016-11-19 15:16:59');
INSERT INTO `project_user_releation` VALUES ('3', '3', '4', '开发工程师', '2016-11-19', null, null, '400801', null, '', '2016-11-19 15:16:55');
INSERT INTO `project_user_releation` VALUES ('4', '4', '3', 'java', '2016-11-19', null, null, null, null, '', '2016-11-19 15:16:52');
INSERT INTO `project_user_releation` VALUES ('6', '5', '2', 'aa', null, null, '2016-11-30', '400801', null, '', '2016-11-09 21:20:21');

-- ----------------------------
-- Table structure for `publish_technology`
-- ----------------------------
DROP TABLE IF EXISTS `publish_technology`;
CREATE TABLE `publish_technology` (
  `publish_technology_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '人才需求发布专业技能ID',
  `publish_id` bigint(20) DEFAULT NULL COMMENT '人才需求发布ID',
  `technology_type` int(11) DEFAULT NULL COMMENT '人才需求发布专业技能值',
  PRIMARY KEY (`publish_technology_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='人才需求发布专业技能';

-- ----------------------------
-- Records of publish_technology
-- ----------------------------
INSERT INTO `publish_technology` VALUES ('1', '4', '100101');
INSERT INTO `publish_technology` VALUES ('2', '4', '100102');
INSERT INTO `publish_technology` VALUES ('3', '4', '100104');

-- ----------------------------
-- Table structure for `requirement_audit`
-- ----------------------------
DROP TABLE IF EXISTS `requirement_audit`;
CREATE TABLE `requirement_audit` (
  `audit_it` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '审核ID',
  `proj_requirement_id` bigint(20) DEFAULT NULL COMMENT '需求ID',
  `requirement_type` int(11) DEFAULT NULL COMMENT '需求类型',
  `back_user_id` bigint(20) DEFAULT NULL COMMENT '审核的后台用户ID',
  `audit_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_content` varchar(2000) DEFAULT NULL COMMENT '审核内容',
  `audit_status` int(11) DEFAULT NULL COMMENT '审核状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`audit_it`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COMMENT='创意需求审核';

-- ----------------------------
-- Records of requirement_audit
-- ----------------------------
INSERT INTO `requirement_audit` VALUES ('76', '4', '700002', '4', '2016-11-23 17:03:06', null, '400703', '');
INSERT INTO `requirement_audit` VALUES ('77', '8', '700002', '4', '2016-11-23 18:08:15', null, '400703', '');
INSERT INTO `requirement_audit` VALUES ('78', '7', '700002', '4', '2016-11-23 18:08:20', null, '400702', '');

-- ----------------------------
-- Table structure for `shopping_cart`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `shopping_cart_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `goods_type` int(11) DEFAULT NULL COMMENT '物品类型',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '物品ID',
  `goods_number` int(11) DEFAULT NULL COMMENT '物品数量',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`shopping_cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户购物车';

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES ('1', '1', '700004', '1', '7', '');
INSERT INTO `shopping_cart` VALUES ('2', '1', '700004', '2', '2', '');
INSERT INTO `shopping_cart` VALUES ('3', '1', '700004', '3', '20', '');
INSERT INTO `shopping_cart` VALUES ('4', '1', '700004', '4', '20', '');
INSERT INTO `shopping_cart` VALUES ('5', '1', '700004', '5', '10', '');

-- ----------------------------
-- Table structure for `system_logs`
-- ----------------------------
DROP TABLE IF EXISTS `system_logs`;
CREATE TABLE `system_logs` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `log_datetime` datetime DEFAULT NULL COMMENT '日志时间',
  `log_content` varchar(1000) DEFAULT NULL COMMENT '日志内容',
  `log_type` varchar(30) DEFAULT NULL COMMENT '日志类型',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of system_logs
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_message`
-- ----------------------------
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message` (
  `sys_message_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息ID',
  `message_subject` varchar(200) DEFAULT NULL COMMENT '消息主题',
  `message_title` varchar(500) DEFAULT NULL COMMENT '消息标题',
  `message_content` varchar(2000) DEFAULT NULL COMMENT '消息内容',
  `generate_datetime` datetime DEFAULT NULL COMMENT '产生消息时间',
  `message_sender` bigint(20) DEFAULT NULL COMMENT '发送人ID',
  `receive_message_type` int(11) DEFAULT NULL COMMENT '消息类型',
  `message_receiver` bigint(20) DEFAULT NULL COMMENT '接收人ID',
  `get_message_time` datetime DEFAULT NULL COMMENT '消息接收时间',
  `is_get` bit(1) DEFAULT b'1' COMMENT '是否接收',
  PRIMARY KEY (`sys_message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='消息';

-- ----------------------------
-- Records of sys_message
-- ----------------------------
INSERT INTO `sys_message` VALUES ('1', '1', '报名消息1', '测试内容', '2016-11-01 19:12:43', '1', '600001', '2', null, '');
INSERT INTO `sys_message` VALUES ('2', '2', '报名消息2', '测试ewrewrw', '2016-11-09 19:13:09', '2', '600001', '3', null, '');
INSERT INTO `sys_message` VALUES ('3', '1', '收藏消息1', '收藏消息内容', '2016-11-02 11:08:37', '3', '600001', '1', null, '');
INSERT INTO `sys_message` VALUES ('4', '4', '报名消息3', '测试内容', '2016-11-09 14:38:08', '4', '600001', null, null, '');
INSERT INTO `sys_message` VALUES ('5', '5', 'fsd', 'fsda', '2016-11-09 15:04:20', '5', '600001', null, null, '');
INSERT INTO `sys_message` VALUES ('6', '6', 'fdsg', 'sdfaf', '2016-11-09 15:04:46', '6', '600001', null, null, '');
INSERT INTO `sys_message` VALUES ('7', '7', 'nnn', 'dfgh', '2016-11-09 15:05:12', '7', '600001', null, null, '');
INSERT INTO `sys_message` VALUES ('8', '8', 'asf', 'fasf', '2016-11-09 15:05:47', '8', '600001', null, null, '');
INSERT INTO `sys_message` VALUES ('9', 'subject', 'titel', 'mcontent', '2016-11-11 09:41:04', '9', '600001', null, null, '');
INSERT INTO `sys_message` VALUES ('10', '消息主题1', '消息标题', '消息内容', '2016-11-14 19:10:55', '10', '600001', null, null, '');
INSERT INTO `sys_message` VALUES ('16', null, null, 'ceshiccc', '2016-11-19 16:24:36', '1', null, null, null, '');
INSERT INTO `sys_message` VALUES ('17', null, null, 'erqwer', '2016-11-19 16:25:33', '1', null, null, null, '');
INSERT INTO `sys_message` VALUES ('18', null, null, 'dddasdee', '2016-11-19 16:26:01', '1', null, null, null, '');
INSERT INTO `sys_message` VALUES ('19', null, null, '1', '2016-11-19 17:52:38', '1', null, null, null, '');
INSERT INTO `sys_message` VALUES ('20', null, null, '4', '2016-11-19 19:59:15', '1', null, null, null, '');
INSERT INTO `sys_message` VALUES ('21', null, null, null, '2016-11-21 20:09:14', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('22', null, null, null, '2016-11-21 20:09:15', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('23', null, null, null, '2016-11-21 20:09:15', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('24', null, null, null, '2016-11-21 20:09:16', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('25', null, null, null, '2016-11-21 20:09:16', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('26', null, null, null, '2016-11-21 20:09:18', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('27', null, null, null, '2016-11-21 20:09:18', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('28', null, null, null, '2016-11-21 20:09:23', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('29', null, null, null, '2016-11-21 20:09:23', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('30', null, null, null, '2016-11-21 20:09:44', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('31', null, null, null, '2016-11-21 20:13:54', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('32', null, null, null, '2016-11-21 20:15:38', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('33', null, null, null, '2016-11-22 17:32:51', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('34', null, null, null, '2016-11-22 17:33:02', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('35', null, null, null, '2016-11-22 17:33:03', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('36', null, null, null, '2016-11-22 17:33:03', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('37', null, null, null, '2016-11-22 17:33:03', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('38', null, null, null, '2016-11-22 17:33:03', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('39', null, null, null, '2016-11-22 17:33:29', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('40', null, null, null, '2016-11-22 17:48:49', null, null, null, null, '');
INSERT INTO `sys_message` VALUES ('41', '1', '1', '1', '2016-11-23 20:32:30', '1', '1', '1', null, '');

-- ----------------------------
-- Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `resource_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '系统资源ID',
  `parent_resource_id` bigint(20) DEFAULT NULL COMMENT '系统资源父ID',
  `sorted_field` int(255) DEFAULT NULL COMMENT '系统资源排序',
  `resource_name` varchar(100) DEFAULT NULL COMMENT '系统资源名称',
  `resource_chese` varchar(300) DEFAULT NULL COMMENT '系统资源中文名',
  `resource_icon_name` varchar(50) DEFAULT NULL COMMENT '系统资源图标名称',
  `resource_icon` varchar(200) DEFAULT NULL COMMENT '系统资源图标路径',
  `resource_type` varchar(20) DEFAULT NULL COMMENT '系统资源类型',
  `resource_link` varchar(255) DEFAULT NULL COMMENT '系统资源链接',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='系统资源';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', null, '1', '需求管理', null, null, null, 'peception', '', '');
INSERT INTO `sys_resource` VALUES ('2', '1', '11', '需求提交', null, null, null, 'peception', 'demandSubmit.html', '');
INSERT INTO `sys_resource` VALUES ('3', '1', '12', '最新反馈', null, null, null, 'peception', 'newMessage.html', '');
INSERT INTO `sys_resource` VALUES ('4', '1', '13', '需求状态', null, null, null, 'peception', 'demandStatus.html', '');
INSERT INTO `sys_resource` VALUES ('5', null, '5', '项目管理', null, null, null, 'peception', 'projectManagement.html', '');
INSERT INTO `sys_resource` VALUES ('6', null, '6', '任务管理', null, null, null, 'peception', 'taskManagement.html', '');
INSERT INTO `sys_resource` VALUES ('7', null, '7', '投融资管理', null, null, null, 'peception', null, '');
INSERT INTO `sys_resource` VALUES ('8', '7', '71', '融资发布', null, null, null, 'peception', 'financingRelease.html', '');
INSERT INTO `sys_resource` VALUES ('9', '7', '72', '投资机构', null, null, null, 'peception', 'investmentInstitutions.html', '');
INSERT INTO `sys_resource` VALUES ('10', '7', '73', '孵化器', null, null, null, 'peception', null, '');
INSERT INTO `sys_resource` VALUES ('11', null, '11', '资源管理', null, null, null, 'peception', null, '');
INSERT INTO `sys_resource` VALUES ('12', '11', '111', '资源发布', null, null, null, 'peception', 'resourceRelease.html', '');
INSERT INTO `sys_resource` VALUES ('13', '11', '112', '资源仓库', null, null, null, 'peception', 'resourceWarehouse.html', '');
INSERT INTO `sys_resource` VALUES ('14', '11', '113', '购买的资源', null, null, null, 'peception', 'myBuyResources.html', '');
INSERT INTO `sys_resource` VALUES ('15', '11', '114', '出售的资源', null, null, null, 'peception', 'sellResources.html', '');
INSERT INTO `sys_resource` VALUES ('16', null, '16', '第三方服务', null, null, null, 'peception', 'thirdPartyService.html', '');
INSERT INTO `sys_resource` VALUES ('17', null, '17', '基于Saas的系统管理', null, null, null, 'peception', null, '');
INSERT INTO `sys_resource` VALUES ('20', null, '20', '发布消息审核', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('21', '20', '201', '需求审核', null, null, null, 'back', 'needReview.html', '');
INSERT INTO `sys_resource` VALUES ('22', '20', '202', '资源审核', null, null, null, 'back', 'resourceReview.html', '');
INSERT INTO `sys_resource` VALUES ('23', '20', '203', '人才审核', null, null, null, 'back', 'talentsReview.html', '');
INSERT INTO `sys_resource` VALUES ('24', '20', '204', '身份审核', null, null, null, 'back', 'identityReview.html', '');
INSERT INTO `sys_resource` VALUES ('25', null, '25', '展示大厅', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('26', '25', '251', '供需信息', null, null, null, 'back', 'supplyDemandInfo.html', '');
INSERT INTO `sys_resource` VALUES ('27', '25', '252', '虚拟实验室', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('28', null, '28', '融资管理', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('29', '28', '281', '投资机构', null, null, null, 'back', 'investmentOrganization.html', '');
INSERT INTO `sys_resource` VALUES ('30', '28', '282', '融资信息', null, null, null, 'back', 'financingInfo.html', '');
INSERT INTO `sys_resource` VALUES ('31', null, '31', '软件创意评估', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('32', '31', '311', '专家库管理', null, null, null, 'back', 'professorManage.html', '');
INSERT INTO `sys_resource` VALUES ('33', '31', '312', '软件评估列表', null, null, null, 'back', 'softwareEvaluation.html', '');
INSERT INTO `sys_resource` VALUES ('34', null, '34', '第三方服务', null, null, null, 'back', '', '');
INSERT INTO `sys_resource` VALUES ('35', '34', '341', '软件项目监理', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('36', '34', '342', '软件著作权代理', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('37', null, '37', '统计分析', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('38', '37', '371', '需求发布量统计', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('39', '37', '372', '资源发布量统计', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('40', '37', '373', '成交量分析', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('41', '37', '374', '人缘关系图谱', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('42', null, '42', '系统管理', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('43', '42', '421', '用户管理', null, null, null, 'back', 'userManage.html', '');
INSERT INTO `sys_resource` VALUES ('44', '42', '422', '角色管理', null, null, null, 'back', 'characterManage.html', '');
INSERT INTO `sys_resource` VALUES ('45', '42', '423', '资源目录管理', null, null, null, 'back', 'setResourceDirectory.html', '');
INSERT INTO `sys_resource` VALUES ('46', '42', '424', '投诉举报处理', null, null, null, 'back', null, '');
INSERT INTO `sys_resource` VALUES ('47', '46', '0', '测试das', null, null, null, 'back', null, '');

-- ----------------------------
-- Table structure for `talent_edu_experience`
-- ----------------------------
DROP TABLE IF EXISTS `talent_edu_experience`;
CREATE TABLE `talent_edu_experience` (
  `experience_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户教育经历ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `talent_degree` varchar(50) DEFAULT NULL COMMENT '用户学历',
  `talent_school` varchar(200) DEFAULT NULL COMMENT '用户学校',
  `talent_profession` varchar(200) DEFAULT NULL COMMENT '用户专业',
  `finish_date` date DEFAULT NULL COMMENT '用户毕业时间',
  `memo` varchar(2000) DEFAULT NULL COMMENT '备注',
  `is_open` bit(1) DEFAULT b'1' COMMENT '是否公开',
  PRIMARY KEY (`experience_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='用户教育经历';

-- ----------------------------
-- Records of talent_edu_experience
-- ----------------------------
INSERT INTO `talent_edu_experience` VALUES ('11', null, '本科', '新华电脑学校新东方蓝翔', '用计算机控制挖掘机炒菜', '2016-11-09', '屌不屌', '');
INSERT INTO `talent_edu_experience` VALUES ('12', null, '本科', '新华电脑学校新东方蓝翔', '用计算机控制挖掘机炒菜', '2016-11-09', '屌不屌', '');
INSERT INTO `talent_edu_experience` VALUES ('13', null, '本科', '新华电脑学校新东方蓝翔', '用计算机控制挖掘机炒菜', '2016-11-09', '屌不屌', '');
INSERT INTO `talent_edu_experience` VALUES ('14', null, '本科', '新华电脑学校新东方蓝翔', '用计算机控制挖掘机炒菜', '2016-11-09', '屌不屌', '');
INSERT INTO `talent_edu_experience` VALUES ('37', '2', '高中', '213', '123', '2016-11-14', '123123123123123123123', '');
INSERT INTO `talent_edu_experience` VALUES ('41', '1', '本科', '新华电脑学校新东方蓝翔', '用计算机控制挖掘机炒菜', '2016-11-09', '屌不屌', '');

-- ----------------------------
-- Table structure for `talent_enroll`
-- ----------------------------
DROP TABLE IF EXISTS `talent_enroll`;
CREATE TABLE `talent_enroll` (
  `enroll_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '报名ID',
  `talent_requirement_id` bigint(20) DEFAULT NULL COMMENT '创意人才需求ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `enroll_datetime` datetime DEFAULT NULL COMMENT '报名时间',
  `enroll_status` int(11) DEFAULT NULL COMMENT '报名状态',
  `enroll_name` varchar(20) DEFAULT NULL COMMENT '报名名称',
  `enroll_email` varchar(50) DEFAULT NULL COMMENT '报名邮件',
  `enroll_mobile` varchar(20) DEFAULT NULL COMMENT '报名手机',
  `enroll_value` varchar(200) DEFAULT NULL COMMENT '报名信息',
  `enroll_see_file_path` varchar(200) DEFAULT NULL COMMENT '附件预览',
  `enroll_file_name` varchar(50) DEFAULT NULL COMMENT '附件名称',
  `enroll_file_path` varchar(200) DEFAULT NULL COMMENT '附件路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`enroll_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='创意人才报名';

-- ----------------------------
-- Records of talent_enroll
-- ----------------------------
INSERT INTO `talent_enroll` VALUES ('1', '1', '2', '2016-11-15 16:48:41', '1', null, null, null, 'wakakaka', null, null, null, null);
INSERT INTO `talent_enroll` VALUES ('3', '1', '1', '2016-11-18 11:25:03', '1', null, null, null, 'sasasa', null, null, null, null);

-- ----------------------------
-- Table structure for `talent_requirement`
-- ----------------------------
DROP TABLE IF EXISTS `talent_requirement`;
CREATE TABLE `talent_requirement` (
  `talent_requirement_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意人才需求ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `talent_requirement_name` varchar(50) DEFAULT NULL COMMENT '人才需求名称',
  `work_mode` int(11) DEFAULT NULL COMMENT '工作形式',
  `professional_skills` varchar(200) DEFAULT NULL COMMENT '专业技能',
  `talent_buget` float DEFAULT NULL COMMENT '薪酬',
  `requirement_description` varchar(1000) DEFAULT NULL COMMENT '需求概述',
  `work_space` varchar(200) DEFAULT NULL COMMENT '工作地点',
  `effective_datetime` datetime DEFAULT NULL COMMENT '生效时间',
  `requirement_classifier` varchar(50) DEFAULT NULL COMMENT '需求分类',
  `cooperate_type` varchar(50) DEFAULT NULL COMMENT '合作类型',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  `requirement_status` int(11) DEFAULT NULL COMMENT '需求状态',
  `talent_attachment_see_path` varchar(200) DEFAULT NULL COMMENT '人才需求附件预览路径',
  `talent_attachment_name` varchar(50) DEFAULT NULL COMMENT '人才需求附件名称',
  `talent_attachment` varchar(200) DEFAULT NULL COMMENT '人才附件路径',
  `work_duty` varchar(500) DEFAULT NULL COMMENT '工作职责',
  `talent_require` varchar(500) DEFAULT NULL COMMENT '人员要求',
  `publish_way` varchar(50) DEFAULT NULL COMMENT '发布方式',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_open` bit(1) DEFAULT b'1' COMMENT '是否公开',
  PRIMARY KEY (`talent_requirement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='创意人才需求';

-- ----------------------------
-- Records of talent_requirement
-- ----------------------------
INSERT INTO `talent_requirement` VALUES ('1', '1', '人才测试', '5', null, null, 'dsads', null, '2016-11-24 18:20:42', null, null, '', '400101', null, null, null, null, null, null, '2016-11-15 18:45:47', '');
INSERT INTO `talent_requirement` VALUES ('2', '1', '人才测试1', null, null, null, 'dsadas', null, '2016-11-25 16:28:01', null, null, '', '400104', null, null, null, null, null, null, '2016-11-22 19:59:05', '');
INSERT INTO `talent_requirement` VALUES ('3', '1', 'sdjsk', '6', 'fas', '0', 'saddsa', '上海', '2016-11-25 16:28:04', null, null, '', '400101', null, null, null, null, null, null, '2016-11-14 10:29:22', '');
INSERT INTO `talent_requirement` VALUES ('4', '1', 'dsa', '33', 'fas', '0', 'saddsa', '河南', '2016-11-16 16:28:06', null, null, '', '400104', null, null, null, null, null, null, '2016-11-14 10:32:23', '');
INSERT INTO `talent_requirement` VALUES ('6', '1', 'sdjsk', '6', 'fas', '0', null, '上海', null, null, null, '', '400101', null, null, null, null, null, null, '2016-11-22 16:06:46', '');
INSERT INTO `talent_requirement` VALUES ('7', '1', 'sdjsk', '6', 'fas', '0', null, '上海', null, null, null, '', '400102', null, null, null, null, null, null, '2016-11-22 16:07:30', '');
INSERT INTO `talent_requirement` VALUES ('8', '1', 'sdjsk', '6', 'fas', '0', null, '上海', null, null, null, '', '400104', null, null, null, null, null, null, '2016-11-22 16:08:34', '');
INSERT INTO `talent_requirement` VALUES ('9', '1', 'sdjsk', '6', 'fas', '0', null, '上海', null, null, null, '', '400102', null, null, null, null, null, null, '2016-11-22 16:12:06', '');

-- ----------------------------
-- Table structure for `talent_requirement_class`
-- ----------------------------
DROP TABLE IF EXISTS `talent_requirement_class`;
CREATE TABLE `talent_requirement_class` (
  `talent_requirement_class_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '人才需求分类ID',
  `talent_requirement_id` bigint(20) DEFAULT NULL COMMENT '人才需求ID',
  `talent_requirement_class_value` int(11) DEFAULT NULL COMMENT '人才需求分类值',
  PRIMARY KEY (`talent_requirement_class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='人才需求分类';

-- ----------------------------
-- Records of talent_requirement_class
-- ----------------------------
INSERT INTO `talent_requirement_class` VALUES ('1', '1', '100101');
INSERT INTO `talent_requirement_class` VALUES ('2', '9', '100102');

-- ----------------------------
-- Table structure for `talent_requirement_recommend`
-- ----------------------------
DROP TABLE IF EXISTS `talent_requirement_recommend`;
CREATE TABLE `talent_requirement_recommend` (
  `recommend_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '推荐ID',
  `talent_id` bigint(20) DEFAULT NULL COMMENT '创意人才ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`recommend_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='创意人才推荐';

-- ----------------------------
-- Records of talent_requirement_recommend
-- ----------------------------
INSERT INTO `talent_requirement_recommend` VALUES ('1', '4', '1', '2016-11-16 22:01:38');
INSERT INTO `talent_requirement_recommend` VALUES ('2', '4', '2', '2016-11-16 22:01:47');
INSERT INTO `talent_requirement_recommend` VALUES ('3', '4', '6', '2016-11-16 22:01:52');

-- ----------------------------
-- Table structure for `talent_technology`
-- ----------------------------
DROP TABLE IF EXISTS `talent_technology`;
CREATE TABLE `talent_technology` (
  `talent_technology_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意人才技能ID',
  `creative_talent_id` bigint(20) DEFAULT NULL COMMENT '创意人才ID',
  `technology_id` int(11) DEFAULT NULL COMMENT '技能ID',
  PRIMARY KEY (`talent_technology_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='创意人才技能';

-- ----------------------------
-- Records of talent_technology
-- ----------------------------
INSERT INTO `talent_technology` VALUES ('1', '3', '99');
INSERT INTO `talent_technology` VALUES ('3', '4', '300204');
INSERT INTO `talent_technology` VALUES ('4', '4', '300201');
INSERT INTO `talent_technology` VALUES ('5', '4', '300202');
INSERT INTO `talent_technology` VALUES ('6', '4', '300203');
INSERT INTO `talent_technology` VALUES ('7', '4', '300201');
INSERT INTO `talent_technology` VALUES ('8', '2', '300202');
INSERT INTO `talent_technology` VALUES ('9', '4', '300203');
INSERT INTO `talent_technology` VALUES ('10', '2', '300201');
INSERT INTO `talent_technology` VALUES ('11', '2', '300202');
INSERT INTO `talent_technology` VALUES ('12', '2', '300203');
INSERT INTO `talent_technology` VALUES ('13', '6', '99');
INSERT INTO `talent_technology` VALUES ('14', '7', '99');
INSERT INTO `talent_technology` VALUES ('15', '8', '99');
INSERT INTO `talent_technology` VALUES ('16', '9', '99');

-- ----------------------------
-- Table structure for `talent_transaction`
-- ----------------------------
DROP TABLE IF EXISTS `talent_transaction`;
CREATE TABLE `talent_transaction` (
  `transaction_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '交易ID',
  `talent_requirement_id` bigint(20) DEFAULT NULL COMMENT '创意人才需求ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '创意人才ID',
  `transaction_datetime` datetime DEFAULT NULL COMMENT '成交日期',
  `transaction_status` int(11) DEFAULT NULL COMMENT '交易状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除状态',
  `pass_day` int(11) DEFAULT NULL COMMENT '过期时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='创意人才交易';

-- ----------------------------
-- Records of talent_transaction
-- ----------------------------
INSERT INTO `talent_transaction` VALUES ('1', '1', '2', '2016-11-10 13:08:06', '401301', '', '2', '2016-11-10 11:19:10');
INSERT INTO `talent_transaction` VALUES ('2', '1', '3', null, '401302', '', '2', '2016-11-18 21:58:44');
INSERT INTO `talent_transaction` VALUES ('3', null, '1', null, '401301', '', null, '2016-11-21 18:24:38');
INSERT INTO `talent_transaction` VALUES ('4', null, '1', null, '401301', '', '1', '2016-11-21 19:18:41');
INSERT INTO `talent_transaction` VALUES ('5', null, '1', null, '401301', '', '12312', '2016-11-21 19:21:41');

-- ----------------------------
-- Table structure for `talent_work_experience`
-- ----------------------------
DROP TABLE IF EXISTS `talent_work_experience`;
CREATE TABLE `talent_work_experience` (
  `experience_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '工作经历ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `start_date` date DEFAULT NULL COMMENT '开始时间',
  `end_date` date DEFAULT NULL COMMENT '结束日期',
  `work_company` varchar(100) DEFAULT NULL COMMENT '工作单位',
  `work_job` varchar(50) DEFAULT NULL COMMENT '工作职位',
  `work_description` varchar(2000) DEFAULT NULL COMMENT '工作描述',
  `is_open` bit(1) DEFAULT b'1' COMMENT '是否公开',
  PRIMARY KEY (`experience_id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COMMENT='用户工作经历';

-- ----------------------------
-- Records of talent_work_experience
-- ----------------------------
INSERT INTO `talent_work_experience` VALUES ('109', '2', '2016-11-14', '2016-11-14', '123', '123', '123123123', '');
INSERT INTO `talent_work_experience` VALUES ('119', '1', '2016-11-01', '2016-11-18', '斯塔克企业', '机械制造', '制造钢铁侠', '');
INSERT INTO `talent_work_experience` VALUES ('120', '1', '2016-09-27', '2016-11-10', '洛克希德.马丁公司', '机械制造', '航空器制造', '');
INSERT INTO `talent_work_experience` VALUES ('121', '1', '2016-11-07', '2016-11-24', 'Blizzard Entertainment', '电子游戏开发', '建模', '');

-- ----------------------------
-- Table structure for `task_product`
-- ----------------------------
DROP TABLE IF EXISTS `task_product`;
CREATE TABLE `task_product` (
  `task_product_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务产物ID',
  `proj_task_id` bigint(20) DEFAULT NULL COMMENT '任务ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `product_value` varchar(500) DEFAULT NULL COMMENT '产物描述',
  `file_name` varchar(50) DEFAULT NULL COMMENT '产物名称',
  `file_path` varchar(200) DEFAULT NULL COMMENT '产物路径',
  `file_see_path` varchar(200) DEFAULT NULL COMMENT '预览路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`task_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='任务产物';

-- ----------------------------
-- Records of task_product
-- ----------------------------
INSERT INTO `task_product` VALUES ('1', '4', '1', '产物描述', '产物名称', 'lujing', null, '2016-11-18 10:22:41', '');
INSERT INTO `task_product` VALUES ('2', '4', '1', 'dsaas', 'dasdas', 'www', null, '2016-11-18 11:37:41', '');
INSERT INTO `task_product` VALUES ('3', '4', '1', 'dsaas', 'dasdas', 'www', null, '2016-11-18 11:39:59', '');
INSERT INTO `task_product` VALUES ('4', '5', '1', null, null, null, null, '2016-11-21 16:30:23', '');
INSERT INTO `task_product` VALUES ('5', '6', '1', null, null, null, null, '2016-11-21 16:39:20', '');
INSERT INTO `task_product` VALUES ('6', '6', '1', null, null, null, null, '2016-11-21 16:39:47', '');
INSERT INTO `task_product` VALUES ('7', '6', '1', 'fdsaf', '新建文本文档 (2).txt', 'file/files/1479718373104.txt', null, '2016-11-21 17:01:25', '');
INSERT INTO `task_product` VALUES ('8', '1', '1', 'fdsa', '已完成对接.txt', 'file/files/1479726844583.txt', null, '2016-11-21 19:14:11', '');
INSERT INTO `task_product` VALUES ('9', '1', '1', 'caic', '新建文本文档 (2).txt', 'file/files/1479726920374.txt', null, '2016-11-21 19:15:29', '');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司ID',
  `user_alias` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型',
  `user_header_name` varchar(50) DEFAULT NULL COMMENT '用户头像名称',
  `user_header_img` varchar(200) DEFAULT NULL COMMENT '用户头像路径',
  `user_pwd` varchar(50) DEFAULT NULL COMMENT '用户密码（存储密码的MD5值）',
  `user_mobile` varchar(20) DEFAULT NULL COMMENT '用户手机号',
  `user_email` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  `is_audit` bit(1) DEFAULT b'1' COMMENT '是否在审核中',
  `is_authentication` bit(1) DEFAULT b'1' COMMENT '是否认证',
  `is_activation` bit(1) DEFAULT b'1' COMMENT '是否激活',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, '麻麻米亚', 'person01', '100501', null, null, 'abac9d76e98e20b695f807593d834dfa', '16666666666', '446565656@qq.com', '2016-11-08 19:19:02', '', '', '', '');
INSERT INTO `user` VALUES ('2', '2', '12345', '测试', '100502', null, null, '827ccb0eea8a706c4c34a16891f84e7b', '1231231321', '12345@qq.com', '2016-11-09 14:47:16', '', '', '', '');
INSERT INTO `user` VALUES ('3', '3', '123', '123', '100501', null, null, '202cb962ac59075b964b07152d234b70', '1777777777', '@qqqqqq', '2016-11-09 17:08:26', '', '', '', '');
INSERT INTO `user` VALUES ('4', '4', '教授', 'jiaoshou', '100502', null, null, '202cb962ac59075b964b07152d234b70', '1231231321', '@gmail.com', '2016-11-09 18:38:59', '', '', '', '');
INSERT INTO `user` VALUES ('5', '5', '123', '1234', '100502', null, null, '202cb962ac59075b964b07152d234b70', '1777777777', '@qqqqqq', '2016-11-09 19:02:32', '', '', '', '');
INSERT INTO `user` VALUES ('6', '6', '123', '1232', '100502', null, null, '202cb962ac59075b964b07152d234b70', '1777777777', '@qqqqqq', '2016-11-09 19:47:04', '', '', '', '');
INSERT INTO `user` VALUES ('7', '7', '123', '1231', '100502', null, null, 'c4ca4238a0b923820dcc509a6f75849b', '1777777777', '@qqqqqq', '2016-11-11 15:12:17', '', '', '', '');
INSERT INTO `user` VALUES ('8', '8', '地方', '65656', '100502', null, null, null, null, null, null, '', '', '', '');
INSERT INTO `user` VALUES ('9', '9', 'asd【pijo', 'cai123', null, null, null, '4df278e15186b4deeb73e9235c9b146c', null, '643987053@qq.com', '2016-11-15 16:59:20', '', '', '', '');
INSERT INTO `user` VALUES ('10', '10', '新产品靠', 'gaodisheng1', null, null, null, 'e3ef1817d065163c74238aeb6a41dcb7', null, '545898817@qq.com', '2016-11-21 19:57:53', '', '', '', '');
INSERT INTO `user` VALUES ('11', '11', '阿道夫', 'cai1234', null, null, null, '4df278e15186b4deeb73e9235c9b146c', null, '643987053@qq.com', '2016-11-22 13:30:36', '', '', '', '');

-- ----------------------------
-- Table structure for `usertable`
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `tableid` int(11) NOT NULL AUTO_INCREMENT,
  `usertablename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tableid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertable
-- ----------------------------

-- ----------------------------
-- Table structure for `user_audit`
-- ----------------------------
DROP TABLE IF EXISTS `user_audit`;
CREATE TABLE `user_audit` (
  `audit_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '审核ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型',
  `back_user_id` bigint(20) DEFAULT NULL COMMENT '审核的后台用户ID',
  `audit_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_content` varchar(2000) DEFAULT NULL COMMENT '审核内容',
  `audit_status` int(11) DEFAULT NULL COMMENT '审核状态',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='身份审核';

-- ----------------------------
-- Records of user_audit
-- ----------------------------
INSERT INTO `user_audit` VALUES ('1', '6', '0', null, '2016-11-15 17:59:24', null, '400702', '');
INSERT INTO `user_audit` VALUES ('2', '2', '0', '1', '2016-11-15 18:43:24', null, '400703', '');

-- ----------------------------
-- Table structure for `user_behavior`
-- ----------------------------
DROP TABLE IF EXISTS `user_behavior`;
CREATE TABLE `user_behavior` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `log_datetime` datetime DEFAULT NULL COMMENT '记录时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `log_type` varchar(30) DEFAULT NULL COMMENT '用户类型',
  `log_status` varchar(30) DEFAULT NULL COMMENT '日志状态',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1738 DEFAULT CHARSET=utf8 COMMENT='用户登录日志';

-- ----------------------------
-- Records of user_behavior
-- ----------------------------
INSERT INTO `user_behavior` VALUES ('64', '2016-11-09 10:42:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('65', '2016-11-09 10:42:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('66', '2016-11-09 10:58:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('67', '2016-11-09 11:02:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('68', '2016-11-09 11:03:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('69', '2016-11-09 11:03:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('70', '2016-11-09 11:04:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('71', '2016-11-09 11:04:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('72', '2016-11-09 11:07:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('73', '2016-11-09 11:06:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('74', '2016-11-09 11:18:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('75', '2016-11-09 11:19:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('76', '2016-11-09 11:28:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('77', '2016-11-09 11:30:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('78', '2016-11-09 12:59:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('79', '2016-11-09 13:02:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('82', '2016-11-09 13:06:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('84', '2016-11-09 13:09:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('85', '2016-11-09 13:12:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('86', '2016-11-09 13:16:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('87', '2016-11-09 13:35:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('88', '2016-11-09 13:35:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('89', '2016-11-09 13:35:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('90', '2016-11-09 13:45:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('91', '2016-11-09 13:47:43', '1', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('92', '2016-11-09 13:51:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('93', '2016-11-09 13:51:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('94', '2016-11-09 13:52:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('95', '2016-11-09 13:49:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('96', '2016-11-09 13:58:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('97', '2016-11-09 13:58:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('98', '2016-11-09 13:56:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('99', '2016-11-09 14:02:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('100', '2016-11-09 14:01:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('101', '2016-11-09 14:03:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('102', '2016-11-09 14:08:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('103', '2016-11-09 14:09:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('104', '2016-11-09 14:09:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('105', '2016-11-09 14:09:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('106', '2016-11-09 14:09:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('107', '2016-11-09 14:11:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('108', '2016-11-09 14:10:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('109', '2016-11-09 14:13:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('110', '2016-11-09 14:15:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('111', '2016-11-09 14:17:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('112', '2016-11-09 14:20:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('113', '2016-11-09 14:23:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('114', '2016-11-09 14:28:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('115', '2016-11-09 14:38:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('116', '2016-11-09 14:39:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('117', '2016-11-09 14:40:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('118', '2016-11-09 14:41:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('119', '2016-11-09 14:45:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('120', '2016-11-09 14:50:28', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('121', '2016-11-09 14:52:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('122', '2016-11-09 15:10:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('123', '2016-11-09 15:10:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('124', '2016-11-09 15:11:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('125', '2016-11-09 15:12:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('126', '2016-11-09 15:13:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('127', '2016-11-09 15:14:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('128', '2016-11-09 15:37:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('129', '2016-11-09 15:41:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('130', '2016-11-09 15:57:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('131', '2016-11-09 15:58:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('132', '2016-11-09 16:00:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('133', '2016-11-09 16:11:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('134', '2016-11-09 16:15:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('135', '2016-11-09 16:29:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('136', '2016-11-09 16:36:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('137', '2016-11-09 16:38:49', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('138', '2016-11-09 16:44:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('139', '2016-11-09 16:48:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('140', '2016-11-09 17:07:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('141', '2016-11-09 17:13:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('142', '2016-11-09 17:22:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('143', '2016-11-09 17:23:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('144', '2016-11-09 18:15:13', '1', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('145', '2016-11-09 18:15:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('146', '2016-11-09 18:23:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('147', '2016-11-09 18:34:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('148', '2016-11-09 18:40:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('149', '2016-11-09 18:43:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('150', '2016-11-09 18:46:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('151', '2016-11-09 18:57:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('152', '2016-11-09 18:58:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('153', '2016-11-09 19:07:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('154', '2016-11-09 19:33:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('155', '2016-11-09 19:35:42', '6', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('156', '2016-11-09 19:35:43', '6', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('157', '2016-11-09 19:36:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('158', '2016-11-09 19:40:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('159', '2016-11-09 19:41:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('160', '2016-11-09 19:45:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('161', '2016-11-09 19:51:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('162', '2016-11-09 19:48:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('163', '2016-11-09 19:52:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('164', '2016-11-09 19:53:21', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('165', '2016-11-09 20:03:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('166', '2016-11-09 20:19:26', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('167', '2016-11-09 20:25:02', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('168', '2016-11-09 20:29:15', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('169', '2016-11-09 20:38:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('170', '2016-11-09 20:44:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('171', '2016-11-09 20:48:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('172', '2016-11-09 20:57:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('173', '2016-11-09 21:00:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('174', '2016-11-09 21:03:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('175', '2016-11-09 21:01:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('176', '2016-11-10 09:06:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('177', '2016-11-10 09:10:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('178', '2016-11-10 09:16:23', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('179', '2016-11-10 09:20:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('180', '2016-11-10 09:21:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('181', '2016-11-10 09:24:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('182', '2016-11-10 09:33:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('183', '2016-11-10 09:36:18', '10', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('184', '2016-11-10 09:36:50', '10', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('185', '2016-11-10 09:36:55', '10', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('186', '2016-11-10 09:38:00', '11', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('187', '2016-11-10 09:38:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('188', '2016-11-10 09:38:08', '11', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('189', '2016-11-10 09:38:09', '11', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('190', '2016-11-10 09:41:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('191', '2016-11-10 09:47:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('192', '2016-11-10 09:47:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('193', '2016-11-10 09:55:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('194', '2016-11-10 09:55:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('195', '2016-11-10 09:56:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('196', '2016-11-10 09:59:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('197', '2016-11-10 10:00:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('198', '2016-11-10 10:02:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('199', '2016-11-10 10:13:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('200', '2016-11-10 10:17:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('201', '2016-11-10 10:21:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('202', '2016-11-10 10:24:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('203', '2016-11-10 10:27:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('204', '2016-11-10 10:28:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('205', '2016-11-10 10:48:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('206', '2016-11-10 10:52:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('207', '2016-11-10 10:52:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('208', '2016-11-10 10:55:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('209', '2016-11-10 11:06:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('210', '2016-11-10 11:11:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('211', '2016-11-10 11:14:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('212', '2016-11-10 11:19:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('213', '2016-11-10 11:26:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('214', '2016-11-10 11:40:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('215', '2016-11-10 11:42:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('216', '2016-11-10 12:21:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('217', '2016-11-10 13:02:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('218', '2016-11-10 13:07:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('219', '2016-11-10 13:10:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('220', '2016-11-10 13:14:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('221', '2016-11-10 13:24:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('222', '2016-11-10 13:26:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('223', '2016-11-10 13:27:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('224', '2016-11-10 13:29:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('225', '2016-11-10 13:31:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('226', '2016-11-10 13:35:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('227', '2016-11-10 13:33:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('228', '2016-11-10 13:36:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('229', '2016-11-10 13:39:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('230', '2016-11-10 13:41:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('231', '2016-11-10 13:39:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('232', '2016-11-10 13:44:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('233', '2016-11-10 13:45:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('234', '2016-11-10 13:44:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('235', '2016-11-10 13:44:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('236', '2016-11-10 13:49:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('237', '2016-11-10 13:56:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('238', '2016-11-10 13:55:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('239', '2016-11-10 13:58:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('240', '2016-11-10 14:18:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('241', '2016-11-10 14:19:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('242', '2016-11-10 14:25:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('243', '2016-11-10 14:26:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('244', '2016-11-10 14:29:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('245', '2016-11-10 14:38:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('246', '2016-11-10 14:50:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('247', '2016-11-10 14:50:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('248', '2016-11-10 14:50:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('249', '2016-11-10 14:51:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('250', '2016-11-10 15:03:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('251', '2016-11-10 15:04:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('252', '2016-11-10 15:24:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('253', '2016-11-10 15:24:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('254', '2016-11-10 15:27:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('255', '2016-11-10 15:29:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('256', '2016-11-10 15:30:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('257', '2016-11-10 15:35:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('258', '2016-11-10 15:35:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('259', '2016-11-10 15:42:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('260', '2016-11-10 15:50:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('261', '2016-11-10 15:51:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('262', '2016-11-10 15:53:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('263', '2016-11-10 16:02:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('264', '2016-11-10 16:03:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('265', '2016-11-10 16:05:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('266', '2016-11-10 16:21:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('267', '2016-11-10 16:23:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('268', '2016-11-10 16:30:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('269', '2016-11-10 16:38:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('270', '2016-11-10 16:40:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('271', '2016-11-10 16:45:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('272', '2016-11-10 16:46:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('273', '2016-11-10 16:49:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('274', '2016-11-10 16:52:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('275', '2016-11-10 16:56:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('276', '2016-11-10 16:57:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('277', '2016-11-10 17:03:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('278', '2016-11-10 17:11:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('279', '2016-11-10 17:20:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('280', '2016-11-10 17:22:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('281', '2016-11-10 17:25:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('282', '2016-11-10 17:25:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('283', '2016-11-10 17:32:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('284', '2016-11-10 17:31:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('285', '2016-11-10 17:34:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('286', '2016-11-10 17:33:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('287', '2016-11-10 17:47:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('288', '2016-11-10 17:48:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('289', '2016-11-10 17:50:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('290', '2016-11-10 17:51:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('291', '2016-11-10 17:52:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('292', '2016-11-10 18:00:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('293', '2016-11-10 18:06:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('294', '2016-11-10 18:18:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('295', '2016-11-10 18:26:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('296', '2016-11-10 18:28:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('297', '2016-11-10 19:17:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('298', '2016-11-10 19:38:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('299', '2016-11-10 19:57:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('300', '2016-11-10 19:58:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('301', '2016-11-10 19:58:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('302', '2016-11-10 20:12:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('303', '2016-11-10 20:15:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('304', '2016-11-10 20:27:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('305', '2016-11-10 20:48:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('306', '2016-11-10 21:08:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('307', '2016-11-10 21:06:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('308', '2016-11-10 21:25:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('309', '2016-11-10 21:26:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('310', '2016-11-10 21:44:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('311', '2016-11-11 09:11:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('312', '2016-11-11 09:15:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('313', '2016-11-11 09:25:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('314', '2016-11-11 09:24:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('315', '2016-11-11 09:27:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('316', '2016-11-11 09:28:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('317', '2016-11-11 09:28:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('318', '2016-11-11 09:30:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('319', '2016-11-11 09:31:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('320', '2016-11-11 09:35:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('321', '2016-11-11 09:34:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('322', '2016-11-11 09:40:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('323', '2016-11-11 09:46:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('324', '2016-11-11 09:51:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('325', '2016-11-11 10:10:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('326', '2016-11-11 10:07:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('327', '2016-11-11 10:30:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('328', '2016-11-11 10:47:27', '6', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('329', '2016-11-11 10:47:33', '6', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('330', '2016-11-11 10:48:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('331', '2016-11-11 10:49:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('332', '2016-11-11 10:53:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('333', '2016-11-11 11:02:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('334', '2016-11-11 11:07:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('335', '2016-11-11 11:11:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('336', '2016-11-11 11:12:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('337', '2016-11-11 11:39:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('338', '2016-11-11 13:18:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('339', '2016-11-11 13:32:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('340', '2016-11-11 13:31:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('341', '2016-11-11 13:37:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('342', '2016-11-11 13:43:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('343', '2016-11-11 13:54:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('344', '2016-11-11 14:06:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('345', '2016-11-11 14:08:34', '6', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('346', '2016-11-11 14:16:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('347', '2016-11-11 14:25:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('348', '2016-11-11 14:27:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('349', '2016-11-11 14:30:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('350', '2016-11-11 14:34:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('351', '2016-11-11 14:37:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('352', '2016-11-11 14:36:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('353', '2016-11-11 14:37:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('354', '2016-11-11 14:39:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('355', '2016-11-11 14:41:35', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('356', '2016-11-11 14:42:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('357', '2016-11-11 14:50:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('358', '2016-11-11 14:55:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('359', '2016-11-11 14:54:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('360', '2016-11-11 14:55:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('361', '2016-11-11 15:01:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('362', '2016-11-11 14:59:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('363', '2016-11-11 14:58:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('364', '2016-11-11 15:14:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('365', '2016-11-11 15:21:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('366', '2016-11-11 15:28:02', '12', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('367', '2016-11-11 15:28:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('368', '2016-11-11 15:32:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('369', '2016-11-11 15:31:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('370', '2016-11-11 15:45:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('371', '2016-11-11 15:54:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('372', '2016-11-11 16:04:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('373', '2016-11-11 16:17:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('374', '2016-11-11 16:23:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('375', '2016-11-11 16:37:28', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('376', '2016-11-11 16:36:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('377', '2016-11-11 16:44:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('378', '2016-11-11 16:46:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('379', '2016-11-11 16:47:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('380', '2016-11-11 16:47:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('381', '2016-11-11 16:54:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('382', '2016-11-11 16:59:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('383', '2016-11-11 17:08:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('384', '2016-11-11 17:08:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('385', '2016-11-11 17:10:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('386', '2016-11-11 17:18:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('387', '2016-11-11 17:23:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('388', '2016-11-11 17:28:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('389', '2016-11-11 17:32:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('390', '2016-11-11 17:33:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('391', '2016-11-11 17:52:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('392', '2016-11-11 17:55:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('393', '2016-11-11 17:59:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('394', '2016-11-11 18:16:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('395', '2016-11-12 11:56:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('396', '2016-11-12 11:58:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('397', '2016-11-12 11:58:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('398', '2016-11-12 12:52:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('399', '2016-11-12 13:09:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('400', '2016-11-12 13:14:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('401', '2016-11-12 13:46:49', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('402', '2016-11-12 15:16:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('403', '2016-11-12 15:40:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('404', '2016-11-12 16:21:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('405', '2016-11-12 16:24:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('406', '2016-11-12 16:52:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('407', '2016-11-12 16:58:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('408', '2016-11-12 17:01:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('409', '2016-11-12 17:05:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('410', '2016-11-12 19:10:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('411', '2016-11-12 19:12:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('412', '2016-11-12 19:25:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('413', '2016-11-12 19:34:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('414', '2016-11-14 09:03:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('415', '2016-11-14 09:09:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('416', '2016-11-14 09:33:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('417', '2016-11-14 09:50:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('418', '2016-11-14 09:53:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('419', '2016-11-14 09:58:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('420', '2016-11-14 09:56:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('421', '2016-11-14 10:07:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('422', '2016-11-14 10:07:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('423', '2016-11-14 10:10:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('424', '2016-11-14 10:11:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('425', '2016-11-14 10:16:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('426', '2016-11-14 10:18:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('427', '2016-11-14 10:21:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('428', '2016-11-14 10:23:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('429', '2016-11-14 10:28:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('430', '2016-11-14 10:31:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('431', '2016-11-14 10:29:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('432', '2016-11-14 10:32:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('433', '2016-11-14 10:40:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('434', '2016-11-14 10:45:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('435', '2016-11-14 10:46:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('436', '2016-11-14 10:48:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('437', '2016-11-14 10:45:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('438', '2016-11-14 10:48:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('439', '2016-11-14 10:52:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('440', '2016-11-14 10:53:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('441', '2016-11-14 10:56:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('442', '2016-11-14 10:57:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('443', '2016-11-14 10:59:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('444', '2016-11-14 11:00:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('445', '2016-11-14 11:08:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('446', '2016-11-14 11:11:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('447', '2016-11-14 11:09:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('448', '2016-11-14 11:13:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('449', '2016-11-14 11:15:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('450', '2016-11-14 11:19:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('451', '2016-11-14 11:21:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('452', '2016-11-14 11:23:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('453', '2016-11-14 11:23:49', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('454', '2016-11-14 11:24:49', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('455', '2016-11-14 11:32:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('456', '2016-11-14 11:33:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('457', '2016-11-14 11:37:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('458', '2016-11-14 11:37:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('459', '2016-11-14 11:35:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('460', '2016-11-14 11:37:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('461', '2016-11-14 12:19:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('462', '2016-11-14 13:03:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('463', '2016-11-14 13:07:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('464', '2016-11-14 13:08:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('465', '2016-11-14 13:10:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('466', '2016-11-14 13:10:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('467', '2016-11-14 13:12:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('468', '2016-11-14 13:20:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('469', '2016-11-14 13:32:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('470', '2016-11-14 13:35:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('471', '2016-11-14 13:48:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('472', '2016-11-14 13:58:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('473', '2016-11-14 13:59:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('474', '2016-11-14 14:00:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('475', '2016-11-14 14:01:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('476', '2016-11-14 14:03:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('477', '2016-11-14 14:02:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('478', '2016-11-14 14:04:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('479', '2016-11-14 14:02:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('480', '2016-11-14 14:05:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('481', '2016-11-14 14:09:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('482', '2016-11-14 14:19:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('483', '2016-11-14 14:30:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('484', '2016-11-14 14:34:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('485', '2016-11-14 14:33:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('486', '2016-11-14 14:36:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('487', '2016-11-14 14:37:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('488', '2016-11-14 14:41:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('489', '2016-11-14 14:44:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('490', '2016-11-14 14:47:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('491', '2016-11-14 14:46:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('492', '2016-11-14 14:50:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('493', '2016-11-14 14:55:49', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('494', '2016-11-14 14:56:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('495', '2016-11-14 15:01:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('496', '2016-11-14 15:02:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('497', '2016-11-14 15:00:06', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('498', '2016-11-14 15:03:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('499', '2016-11-14 15:09:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('500', '2016-11-14 15:09:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('501', '2016-11-14 15:13:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('502', '2016-11-14 15:20:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('503', '2016-11-14 15:22:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('504', '2016-11-14 15:22:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('505', '2016-11-14 15:31:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('506', '2016-11-14 15:32:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('507', '2016-11-14 15:36:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('508', '2016-11-14 15:47:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('509', '2016-11-14 15:49:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('510', '2016-11-14 15:55:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('511', '2016-11-14 15:57:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('512', '2016-11-14 16:05:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('513', '2016-11-14 16:07:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('514', '2016-11-14 16:09:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('515', '2016-11-14 16:09:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('516', '2016-11-14 16:09:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('517', '2016-11-14 16:09:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('518', '2016-11-14 16:19:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('519', '2016-11-14 16:32:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('520', '2016-11-14 16:32:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('521', '2016-11-14 16:40:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('522', '2016-11-14 16:51:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('523', '2016-11-14 16:52:16', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('524', '2016-11-14 16:54:14', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('525', '2016-11-14 16:54:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('526', '2016-11-14 16:55:26', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('527', '2016-11-14 16:58:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('528', '2016-11-14 17:00:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('529', '2016-11-14 17:03:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('530', '2016-11-14 17:05:26', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('531', '2016-11-14 17:05:24', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('532', '2016-11-14 17:09:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('533', '2016-11-14 17:18:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('534', '2016-11-14 17:21:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('535', '2016-11-14 17:20:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('536', '2016-11-14 17:24:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('537', '2016-11-14 17:22:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('538', '2016-11-14 17:25:49', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('539', '2016-11-14 17:27:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('540', '2016-11-14 17:31:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('541', '2016-11-14 17:34:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('542', '2016-11-14 17:42:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('543', '2016-11-14 17:42:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('544', '2016-11-14 17:41:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('545', '2016-11-14 17:45:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('546', '2016-11-14 17:46:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('547', '2016-11-14 17:53:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('548', '2016-11-14 18:00:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('549', '2016-11-14 18:04:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('550', '2016-11-14 18:05:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('551', '2016-11-14 18:07:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('552', '2016-11-14 18:17:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('553', '2016-11-14 18:20:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('554', '2016-11-14 18:24:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('555', '2016-11-14 18:26:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('556', '2016-11-14 18:37:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('557', '2016-11-14 18:38:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('558', '2016-11-14 18:40:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('559', '2016-11-14 18:44:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('560', '2016-11-14 18:46:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('561', '2016-11-14 19:09:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('562', '2016-11-14 19:11:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('563', '2016-11-14 19:07:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('564', '2016-11-14 19:16:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('565', '2016-11-14 19:16:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('566', '2016-11-14 19:20:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('567', '2016-11-14 19:26:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('568', '2016-11-14 19:30:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('569', '2016-11-14 19:36:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('570', '2016-11-14 19:41:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('571', '2016-11-14 19:46:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('572', '2016-11-14 19:49:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('573', '2016-11-14 19:49:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('574', '2016-11-14 19:49:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('575', '2016-11-14 19:56:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('576', '2016-11-14 19:56:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('577', '2016-11-14 19:58:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('578', '2016-11-14 20:05:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('579', '2016-11-14 20:12:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('580', '2016-11-14 20:14:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('581', '2016-11-14 20:13:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('582', '2016-11-14 20:13:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('583', '2016-11-14 20:22:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('584', '2016-11-14 20:27:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('585', '2016-11-14 20:55:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('586', '2016-11-14 20:56:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('587', '2016-11-14 20:56:25', '2', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('588', '2016-11-14 20:56:30', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('589', '2016-11-14 20:58:19', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('590', '2016-11-14 20:59:00', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('591', '2016-11-14 21:06:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('592', '2016-11-14 21:06:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('593', '2016-11-14 21:17:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('594', '2016-11-14 21:27:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('595', '2016-11-14 21:32:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('596', '2016-11-14 21:35:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('597', '2016-11-14 21:39:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('598', '2016-11-14 21:45:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('599', '2016-11-14 21:50:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('600', '2016-11-14 21:51:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('601', '2016-11-14 22:17:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('602', '2016-11-15 09:05:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('603', '2016-11-15 09:08:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('604', '2016-11-15 09:09:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('605', '2016-11-15 09:08:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('606', '2016-11-15 09:12:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('607', '2016-11-15 09:19:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('608', '2016-11-15 09:20:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('609', '2016-11-15 09:25:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('610', '2016-11-15 09:26:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('611', '2016-11-15 09:27:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('612', '2016-11-15 09:30:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('613', '2016-11-15 09:32:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('614', '2016-11-15 09:39:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('615', '2016-11-15 09:38:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('616', '2016-11-15 09:43:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('617', '2016-11-15 09:46:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('618', '2016-11-15 09:52:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('619', '2016-11-15 09:51:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('620', '2016-11-15 09:55:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('621', '2016-11-15 09:58:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('622', '2016-11-15 09:58:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('623', '2016-11-15 10:03:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('624', '2016-11-15 10:06:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('625', '2016-11-15 10:09:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('626', '2016-11-15 10:10:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('627', '2016-11-15 10:10:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('628', '2016-11-15 10:13:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('629', '2016-11-15 10:15:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('630', '2016-11-15 10:15:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('631', '2016-11-15 10:16:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('632', '2016-11-15 10:19:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('633', '2016-11-15 10:21:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('634', '2016-11-15 10:24:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('635', '2016-11-15 10:28:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('636', '2016-11-15 10:35:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('637', '2016-11-15 10:39:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('638', '2016-11-15 10:38:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('639', '2016-11-15 10:40:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('640', '2016-11-15 10:43:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('641', '2016-11-15 10:46:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('642', '2016-11-15 10:48:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('643', '2016-11-15 10:50:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('644', '2016-11-15 10:53:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('645', '2016-11-15 10:52:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('646', '2016-11-15 10:54:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('647', '2016-11-15 10:59:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('648', '2016-11-15 11:00:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('649', '2016-11-15 11:05:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('650', '2016-11-15 11:06:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('651', '2016-11-15 11:13:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('652', '2016-11-15 11:13:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('653', '2016-11-15 11:14:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('654', '2016-11-15 11:17:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('655', '2016-11-15 11:21:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('656', '2016-11-15 11:20:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('657', '2016-11-15 11:24:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('658', '2016-11-15 11:24:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('659', '2016-11-15 11:27:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('660', '2016-11-15 11:29:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('661', '2016-11-15 11:31:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('662', '2016-11-15 11:36:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('663', '2016-11-15 11:36:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('664', '2016-11-15 11:39:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('665', '2016-11-15 11:41:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('666', '2016-11-15 11:42:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('667', '2016-11-15 11:42:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('668', '2016-11-15 11:45:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('669', '2016-11-15 13:10:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('670', '2016-11-15 13:22:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('671', '2016-11-15 13:27:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('672', '2016-11-15 13:27:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('673', '2016-11-15 13:37:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('674', '2016-11-15 13:39:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('675', '2016-11-15 13:42:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('676', '2016-11-15 13:48:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('677', '2016-11-15 13:52:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('678', '2016-11-15 13:51:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('679', '2016-11-15 13:53:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('680', '2016-11-15 13:52:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('681', '2016-11-15 13:58:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('682', '2016-11-15 13:59:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('683', '2016-11-15 14:02:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('684', '2016-11-15 14:05:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('685', '2016-11-15 14:11:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('686', '2016-11-15 14:11:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('687', '2016-11-15 14:11:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('688', '2016-11-15 14:16:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('689', '2016-11-15 14:16:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('690', '2016-11-15 14:18:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('691', '2016-11-15 14:19:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('692', '2016-11-15 14:25:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('693', '2016-11-15 14:31:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('694', '2016-11-15 14:35:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('695', '2016-11-15 14:35:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('696', '2016-11-15 14:39:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('697', '2016-11-15 14:52:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('698', '2016-11-15 15:00:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('699', '2016-11-15 15:02:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('700', '2016-11-15 15:13:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('701', '2016-11-15 15:18:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('702', '2016-11-15 15:26:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('703', '2016-11-15 15:42:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('704', '2016-11-15 15:50:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('705', '2016-11-15 16:02:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('706', '2016-11-15 16:05:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('707', '2016-11-15 16:07:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('708', '2016-11-15 16:13:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('709', '2016-11-15 16:18:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('710', '2016-11-15 16:23:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('711', '2016-11-15 16:25:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('712', '2016-11-15 16:27:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('713', '2016-11-15 16:27:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('714', '2016-11-15 16:38:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('715', '2016-11-15 16:39:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('716', '2016-11-15 16:45:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('717', '2016-11-15 16:50:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('718', '2016-11-15 17:00:38', '1', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('719', '2016-11-15 17:00:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('720', '2016-11-15 17:04:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('721', '2016-11-15 17:01:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('722', '2016-11-15 17:17:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('723', '2016-11-15 17:22:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('724', '2016-11-15 17:25:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('725', '2016-11-15 17:26:35', '14', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('726', '2016-11-15 17:27:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('727', '2016-11-15 17:36:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('728', '2016-11-15 17:45:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('729', '2016-11-15 17:46:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('730', '2016-11-15 17:56:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('731', '2016-11-15 18:04:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('732', '2016-11-15 18:05:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('733', '2016-11-15 18:10:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('734', '2016-11-15 18:18:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('735', '2016-11-15 18:32:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('736', '2016-11-15 18:38:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('737', '2016-11-15 18:44:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('738', '2016-11-15 18:48:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('739', '2016-11-15 18:46:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('740', '2016-11-15 18:46:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('741', '2016-11-15 18:51:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('742', '2016-11-15 19:03:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('743', '2016-11-15 19:09:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('744', '2016-11-15 19:13:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('745', '2016-11-15 19:18:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('746', '2016-11-15 19:16:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('747', '2016-11-15 19:22:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('748', '2016-11-15 19:30:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('749', '2016-11-15 19:35:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('750', '2016-11-15 19:33:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('751', '2016-11-15 19:34:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('752', '2016-11-15 19:44:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('753', '2016-11-15 20:02:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('754', '2016-11-15 20:00:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('755', '2016-11-15 20:08:49', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('756', '2016-11-15 20:12:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('757', '2016-11-15 20:14:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('758', '2016-11-15 20:15:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('759', '2016-11-15 20:18:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('760', '2016-11-15 20:22:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('761', '2016-11-15 20:23:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('762', '2016-11-15 20:26:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('763', '2016-11-15 20:32:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('764', '2016-11-15 20:41:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('765', '2016-11-15 20:44:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('766', '2016-11-15 20:45:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('767', '2016-11-15 20:54:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('768', '2016-11-15 21:00:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('769', '2016-11-15 21:01:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('770', '2016-11-15 21:04:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('771', '2016-11-15 21:09:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('772', '2016-11-15 21:11:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('773', '2016-11-15 21:10:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('774', '2016-11-15 21:18:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('775', '2016-11-15 21:18:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('776', '2016-11-15 21:21:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('777', '2016-11-15 21:25:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('778', '2016-11-15 21:27:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('779', '2016-11-15 21:32:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('780', '2016-11-15 21:39:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('781', '2016-11-15 21:42:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('782', '2016-11-15 21:48:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('783', '2016-11-15 21:49:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('784', '2016-11-16 09:05:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('785', '2016-11-16 09:06:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('786', '2016-11-16 09:12:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('787', '2016-11-16 09:12:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('788', '2016-11-16 09:10:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('789', '2016-11-16 09:14:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('790', '2016-11-16 09:18:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('791', '2016-11-16 09:17:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('792', '2016-11-16 09:20:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('793', '2016-11-16 09:21:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('794', '2016-11-16 09:24:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('795', '2016-11-16 09:29:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('796', '2016-11-16 09:28:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('797', '2016-11-16 09:32:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('798', '2016-11-16 09:39:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('799', '2016-11-16 09:41:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('800', '2016-11-16 09:41:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('801', '2016-11-16 09:42:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('802', '2016-11-16 09:44:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('803', '2016-11-16 09:45:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('804', '2016-11-16 09:49:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('805', '2016-11-16 09:51:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('806', '2016-11-16 09:51:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('807', '2016-11-16 09:56:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('808', '2016-11-16 09:55:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('809', '2016-11-16 09:59:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('810', '2016-11-16 10:00:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('811', '2016-11-16 10:29:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('812', '2016-11-16 10:30:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('813', '2016-11-16 10:31:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('814', '2016-11-16 10:54:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('815', '2016-11-16 10:59:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('816', '2016-11-16 11:03:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('817', '2016-11-16 11:03:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('818', '2016-11-16 11:43:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('819', '2016-11-16 13:09:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('820', '2016-11-16 13:11:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('821', '2016-11-16 13:13:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('822', '2016-11-16 13:16:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('823', '2016-11-16 13:17:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('824', '2016-11-16 13:20:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('825', '2016-11-16 13:22:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('826', '2016-11-16 13:34:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('827', '2016-11-16 13:38:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('828', '2016-11-16 13:44:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('829', '2016-11-16 13:48:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('830', '2016-11-16 13:50:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('831', '2016-11-16 13:53:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('832', '2016-11-16 13:57:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('833', '2016-11-16 14:04:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('834', '2016-11-16 14:18:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('835', '2016-11-16 14:18:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('836', '2016-11-16 14:22:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('837', '2016-11-16 14:23:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('838', '2016-11-16 14:24:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('839', '2016-11-16 14:31:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('840', '2016-11-16 14:37:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('841', '2016-11-16 14:37:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('842', '2016-11-16 14:38:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('843', '2016-11-16 14:48:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('844', '2016-11-16 14:53:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('845', '2016-11-16 14:57:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('846', '2016-11-16 15:00:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('847', '2016-11-16 15:00:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('848', '2016-11-16 15:01:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('849', '2016-11-16 15:01:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('850', '2016-11-16 15:10:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('851', '2016-11-16 15:12:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('852', '2016-11-16 15:29:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('853', '2016-11-16 15:33:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('854', '2016-11-16 15:37:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('855', '2016-11-16 15:37:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('856', '2016-11-16 15:46:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('857', '2016-11-16 15:47:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('858', '2016-11-16 15:50:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('859', '2016-11-16 15:51:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('860', '2016-11-16 15:58:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('861', '2016-11-16 16:07:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('862', '2016-11-16 16:06:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('863', '2016-11-16 16:17:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('864', '2016-11-16 16:26:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('865', '2016-11-16 16:26:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('866', '2016-11-16 16:27:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('867', '2016-11-16 16:34:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('868', '2016-11-16 16:49:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('869', '2016-11-16 16:51:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('870', '2016-11-16 16:51:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('871', '2016-11-16 16:53:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('872', '2016-11-16 16:54:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('873', '2016-11-16 16:55:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('874', '2016-11-16 16:55:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('875', '2016-11-16 17:00:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('876', '2016-11-16 17:00:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('877', '2016-11-16 17:04:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('878', '2016-11-16 17:12:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('879', '2016-11-16 17:17:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('880', '2016-11-16 17:24:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('881', '2016-11-16 17:30:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('882', '2016-11-16 17:32:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('883', '2016-11-16 17:35:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('884', '2016-11-16 17:36:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('885', '2016-11-16 17:36:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('886', '2016-11-16 17:40:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('887', '2016-11-16 18:01:56', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('888', '2016-11-16 18:19:00', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('889', '2016-11-16 18:25:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('890', '2016-11-16 18:25:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('891', '2016-11-16 18:32:49', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('892', '2016-11-16 18:32:56', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('893', '2016-11-16 18:36:37', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('894', '2016-11-16 18:36:57', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('895', '2016-11-16 18:45:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('896', '2016-11-16 18:46:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('897', '2016-11-16 19:02:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('898', '2016-11-16 19:12:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('899', '2016-11-16 19:23:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('900', '2016-11-16 19:28:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('901', '2016-11-16 19:32:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('902', '2016-11-16 19:35:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('903', '2016-11-16 19:40:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('904', '2016-11-16 19:41:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('905', '2016-11-16 19:41:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('906', '2016-11-16 19:44:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('907', '2016-11-16 19:44:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('908', '2016-11-16 19:53:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('909', '2016-11-16 19:53:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('910', '2016-11-16 20:00:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('911', '2016-11-16 20:00:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('912', '2016-11-16 20:16:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('913', '2016-11-16 20:16:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('914', '2016-11-16 20:17:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('915', '2016-11-16 20:25:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('916', '2016-11-16 20:35:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('917', '2016-11-16 20:36:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('918', '2016-11-16 20:38:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('919', '2016-11-16 20:41:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('920', '2016-11-16 20:38:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('921', '2016-11-16 20:44:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('922', '2016-11-16 20:47:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('923', '2016-11-16 20:47:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('924', '2016-11-16 20:45:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('925', '2016-11-16 20:53:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('926', '2016-11-16 21:00:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('927', '2016-11-16 21:03:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('928', '2016-11-16 21:05:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('929', '2016-11-16 21:07:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('930', '2016-11-16 21:05:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('931', '2016-11-16 21:06:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('932', '2016-11-16 21:10:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('933', '2016-11-16 21:18:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('934', '2016-11-16 21:23:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('935', '2016-11-16 21:24:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('936', '2016-11-16 21:26:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('937', '2016-11-16 21:26:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('938', '2016-11-16 21:28:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('939', '2016-11-16 21:33:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('940', '2016-11-16 21:39:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('941', '2016-11-16 21:39:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('942', '2016-11-16 21:46:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('943', '2016-11-16 21:53:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('944', '2016-11-16 22:01:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('945', '2016-11-16 22:08:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('946', '2016-11-17 09:05:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('947', '2016-11-17 09:12:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('948', '2016-11-17 09:14:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('949', '2016-11-17 09:16:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('950', '2016-11-17 09:16:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('951', '2016-11-17 09:20:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('952', '2016-11-17 09:22:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('953', '2016-11-17 09:24:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('954', '2016-11-17 09:29:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('955', '2016-11-17 09:29:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('956', '2016-11-17 09:43:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('957', '2016-11-17 09:46:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('958', '2016-11-17 09:51:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('959', '2016-11-17 10:09:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('960', '2016-11-17 10:13:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('961', '2016-11-17 10:31:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('962', '2016-11-17 10:39:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('963', '2016-11-17 10:45:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('964', '2016-11-17 10:53:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('965', '2016-11-17 11:03:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('966', '2016-11-17 11:05:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('967', '2016-11-17 11:05:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('968', '2016-11-17 11:08:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('969', '2016-11-17 11:10:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('970', '2016-11-17 11:35:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('971', '2016-11-17 11:36:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('972', '2016-11-17 11:36:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('973', '2016-11-17 13:03:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('974', '2016-11-17 13:11:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('975', '2016-11-17 13:15:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('976', '2016-11-17 13:15:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('977', '2016-11-17 13:28:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('978', '2016-11-17 13:31:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('979', '2016-11-17 13:34:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('980', '2016-11-17 13:35:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('981', '2016-11-17 13:36:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('982', '2016-11-17 13:39:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('983', '2016-11-17 13:50:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('984', '2016-11-17 13:50:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('985', '2016-11-17 13:54:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('986', '2016-11-17 13:53:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('987', '2016-11-17 13:54:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('988', '2016-11-17 13:59:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('989', '2016-11-17 14:02:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('990', '2016-11-17 14:02:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('991', '2016-11-17 14:04:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('992', '2016-11-17 14:06:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('993', '2016-11-17 14:06:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('994', '2016-11-17 14:05:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('995', '2016-11-17 14:07:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('996', '2016-11-17 14:07:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('997', '2016-11-17 14:11:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('998', '2016-11-17 14:17:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('999', '2016-11-17 14:20:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1000', '2016-11-17 14:27:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1001', '2016-11-17 14:31:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1002', '2016-11-17 14:34:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1003', '2016-11-17 14:43:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1004', '2016-11-17 14:43:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1005', '2016-11-17 14:51:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1006', '2016-11-17 14:52:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1007', '2016-11-17 15:03:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1008', '2016-11-17 15:05:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1009', '2016-11-17 15:07:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1010', '2016-11-17 15:09:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1011', '2016-11-17 15:10:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1012', '2016-11-17 15:11:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1013', '2016-11-17 15:16:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1014', '2016-11-17 15:26:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1015', '2016-11-17 15:26:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1016', '2016-11-17 15:29:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1017', '2016-11-17 15:34:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1018', '2016-11-17 15:38:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1019', '2016-11-17 15:50:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1020', '2016-11-17 15:48:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1021', '2016-11-17 15:49:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1022', '2016-11-17 15:55:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1023', '2016-11-17 15:59:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1024', '2016-11-17 16:17:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1025', '2016-11-17 16:22:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1026', '2016-11-17 16:24:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1027', '2016-11-17 16:24:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1028', '2016-11-17 16:26:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1029', '2016-11-17 16:27:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1030', '2016-11-17 16:35:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1031', '2016-11-17 16:41:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1032', '2016-11-17 16:43:34', '2', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('1033', '2016-11-17 16:43:42', '2', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('1034', '2016-11-17 16:44:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1035', '2016-11-17 16:45:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1036', '2016-11-17 16:47:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1037', '2016-11-17 16:59:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1038', '2016-11-17 17:05:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1039', '2016-11-17 17:12:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1040', '2016-11-17 17:12:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1041', '2016-11-17 17:16:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1042', '2016-11-17 17:17:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1043', '2016-11-17 17:21:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1044', '2016-11-17 17:21:49', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1045', '2016-11-17 17:30:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1046', '2016-11-17 17:34:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1047', '2016-11-17 17:34:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1048', '2016-11-17 17:35:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1049', '2016-11-17 17:40:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1050', '2016-11-17 17:39:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1051', '2016-11-17 17:40:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1052', '2016-11-17 17:45:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1053', '2016-11-17 17:44:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1054', '2016-11-17 17:49:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1055', '2016-11-17 17:54:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1056', '2016-11-17 17:56:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1057', '2016-11-17 17:57:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1058', '2016-11-17 18:10:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1059', '2016-11-17 18:12:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1060', '2016-11-17 18:15:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1061', '2016-11-17 18:17:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1062', '2016-11-17 18:20:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1063', '2016-11-17 18:22:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1064', '2016-11-17 18:21:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1065', '2016-11-17 18:22:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1066', '2016-11-17 18:26:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1067', '2016-11-17 18:28:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1068', '2016-11-17 18:29:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1069', '2016-11-17 18:31:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1070', '2016-11-17 18:33:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1071', '2016-11-17 18:34:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1072', '2016-11-17 18:36:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1073', '2016-11-17 18:39:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1074', '2016-11-17 18:41:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1075', '2016-11-17 18:47:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1076', '2016-11-17 18:50:49', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1077', '2016-11-17 18:54:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1078', '2016-11-17 18:56:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1079', '2016-11-17 18:57:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1080', '2016-11-17 19:00:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1081', '2016-11-17 19:01:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1082', '2016-11-17 19:04:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1083', '2016-11-17 19:08:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1084', '2016-11-17 19:09:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1085', '2016-11-17 19:13:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1086', '2016-11-17 19:15:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1087', '2016-11-17 19:25:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1088', '2016-11-17 19:57:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1089', '2016-11-17 20:06:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1090', '2016-11-17 20:06:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1091', '2016-11-17 20:08:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1092', '2016-11-17 20:14:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1093', '2016-11-17 20:19:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1094', '2016-11-17 20:18:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1095', '2016-11-17 20:24:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1096', '2016-11-17 20:26:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1097', '2016-11-17 20:28:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1098', '2016-11-17 20:41:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1099', '2016-11-17 20:44:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1100', '2016-11-17 20:48:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1101', '2016-11-17 20:52:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1102', '2016-11-17 20:55:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1103', '2016-11-17 20:59:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1104', '2016-11-17 20:59:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1105', '2016-11-17 21:01:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1106', '2016-11-17 21:03:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1107', '2016-11-17 21:03:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1108', '2016-11-17 21:02:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1109', '2016-11-17 21:04:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1110', '2016-11-17 21:07:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1111', '2016-11-17 21:07:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1112', '2016-11-17 21:16:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1113', '2016-11-17 21:18:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1114', '2016-11-17 21:25:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1115', '2016-11-17 21:32:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1116', '2016-11-17 21:34:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1117', '2016-11-17 21:39:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1118', '2016-11-17 21:40:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1119', '2016-11-17 21:40:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1120', '2016-11-17 21:42:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1121', '2016-11-17 21:45:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1122', '2016-11-17 21:49:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1123', '2016-11-17 21:53:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1124', '2016-11-17 21:55:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1125', '2016-11-17 21:57:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1126', '2016-11-17 22:00:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1127', '2016-11-17 22:09:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1128', '2016-11-17 22:25:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1129', '2016-11-17 22:28:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1130', '2016-11-18 09:09:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1131', '2016-11-18 09:10:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1132', '2016-11-18 09:17:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1133', '2016-11-18 09:23:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1134', '2016-11-18 09:24:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1135', '2016-11-18 09:34:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1136', '2016-11-18 09:35:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1137', '2016-11-18 09:41:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1138', '2016-11-18 09:41:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1139', '2016-11-18 09:44:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1140', '2016-11-18 09:55:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1141', '2016-11-18 10:00:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1142', '2016-11-18 10:03:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1143', '2016-11-18 10:03:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1144', '2016-11-18 10:10:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1145', '2016-11-18 10:32:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1146', '2016-11-18 10:44:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1147', '2016-11-18 10:48:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1148', '2016-11-18 10:56:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1149', '2016-11-18 10:59:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1150', '2016-11-18 11:32:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1151', '2016-11-18 11:34:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1152', '2016-11-18 11:37:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1153', '2016-11-18 11:38:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1154', '2016-11-18 11:38:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1155', '2016-11-18 11:43:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1156', '2016-11-18 12:57:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1157', '2016-11-18 13:01:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1158', '2016-11-18 13:03:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1159', '2016-11-18 13:15:38', '16', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1160', '2016-11-18 13:28:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1161', '2016-11-18 13:41:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1162', '2016-11-18 13:43:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1163', '2016-11-18 13:50:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1164', '2016-11-18 14:03:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1165', '2016-11-18 14:05:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1166', '2016-11-18 14:09:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1167', '2016-11-18 14:09:46', '16', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1168', '2016-11-18 14:18:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1169', '2016-11-18 14:23:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1170', '2016-11-18 14:28:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1171', '2016-11-18 14:37:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1172', '2016-11-18 14:38:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1173', '2016-11-18 14:47:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1174', '2016-11-18 14:50:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1175', '2016-11-18 15:01:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1176', '2016-11-18 15:08:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1177', '2016-11-18 15:14:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1178', '2016-11-18 15:16:30', '16', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1179', '2016-11-18 15:18:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1180', '2016-11-18 15:17:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1181', '2016-11-18 15:19:08', '16', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('1182', '2016-11-18 15:19:14', '16', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1183', '2016-11-18 15:18:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1184', '2016-11-18 15:21:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1185', '2016-11-18 15:27:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1186', '2016-11-18 15:29:46', '16', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1187', '2016-11-18 15:30:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1188', '2016-11-18 15:34:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1189', '2016-11-18 15:39:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1190', '2016-11-18 15:48:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1191', '2016-11-18 15:53:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1192', '2016-11-18 16:02:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1193', '2016-11-18 16:12:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1194', '2016-11-18 16:14:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1195', '2016-11-18 16:39:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1196', '2016-11-18 16:40:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1197', '2016-11-18 16:45:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1198', '2016-11-18 16:45:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1199', '2016-11-18 16:47:29', '16', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1200', '2016-11-18 16:50:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1201', '2016-11-18 17:07:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1202', '2016-11-18 17:13:30', '16', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1203', '2016-11-18 17:15:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1204', '2016-11-18 17:15:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1205', '2016-11-18 17:16:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1206', '2016-11-18 17:18:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1207', '2016-11-18 17:21:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1208', '2016-11-18 17:26:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1209', '2016-11-18 17:40:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1210', '2016-11-18 17:56:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1211', '2016-11-18 17:58:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1212', '2016-11-18 18:03:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1213', '2016-11-18 18:05:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1214', '2016-11-18 18:04:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1215', '2016-11-18 18:10:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1216', '2016-11-18 18:21:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1217', '2016-11-18 19:37:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1218', '2016-11-18 19:37:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1219', '2016-11-18 20:14:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1220', '2016-11-18 20:21:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1221', '2016-11-18 20:38:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1222', '2016-11-18 20:42:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1223', '2016-11-18 20:50:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1224', '2016-11-18 21:40:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1225', '2016-11-19 12:45:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1226', '2016-11-19 13:19:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1227', '2016-11-19 14:25:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1228', '2016-11-19 14:56:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1229', '2016-11-19 15:09:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1230', '2016-11-19 15:17:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1231', '2016-11-19 15:21:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1232', '2016-11-19 15:36:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1233', '2016-11-19 15:48:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1234', '2016-11-19 15:57:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1235', '2016-11-19 15:59:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1236', '2016-11-19 16:03:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1237', '2016-11-19 16:03:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1238', '2016-11-19 16:23:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1239', '2016-11-19 16:38:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1240', '2016-11-19 17:03:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1241', '2016-11-19 17:08:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1242', '2016-11-19 17:15:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1243', '2016-11-19 17:42:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1244', '2016-11-19 17:51:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1245', '2016-11-19 17:55:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1246', '2016-11-19 18:07:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1247', '2016-11-19 19:25:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1248', '2016-11-19 19:36:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1249', '2016-11-19 19:52:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1250', '2016-11-19 19:56:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1251', '2016-11-19 20:04:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1252', '2016-11-19 20:05:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1253', '2016-11-19 20:06:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1254', '2016-11-19 20:29:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1255', '2016-11-19 21:20:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1256', '2016-11-19 22:09:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1257', '2016-11-19 22:19:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1258', '2016-11-19 22:21:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1259', '2016-11-19 22:27:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1260', '2016-11-19 22:29:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1261', '2016-11-20 13:10:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1262', '2016-11-20 13:22:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1263', '2016-11-20 13:30:20', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1264', '2016-11-20 13:36:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1265', '2016-11-20 13:39:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1266', '2016-11-20 14:01:11', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1267', '2016-11-20 14:11:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1268', '2016-11-20 14:19:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1269', '2016-11-20 14:21:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1270', '2016-11-20 14:28:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1271', '2016-11-20 14:29:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1272', '2016-11-20 15:04:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1273', '2016-11-20 15:06:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1274', '2016-11-20 15:18:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1275', '2016-11-20 15:35:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1276', '2016-11-20 16:00:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1277', '2016-11-20 16:13:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1278', '2016-11-20 16:21:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1279', '2016-11-20 16:33:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1280', '2016-11-20 16:59:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1281', '2016-11-20 17:00:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1282', '2016-11-20 17:01:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1283', '2016-11-20 17:02:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1284', '2016-11-20 18:44:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1285', '2016-11-20 18:47:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1286', '2016-11-20 18:54:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1287', '2016-11-20 19:00:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1288', '2016-11-20 19:14:49', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1289', '2016-11-20 19:43:20', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1290', '2016-11-20 19:45:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1291', '2016-11-20 19:50:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1292', '2016-11-20 19:49:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1293', '2016-11-20 19:53:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1294', '2016-11-20 19:59:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1295', '2016-11-20 20:11:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1296', '2016-11-20 20:12:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1297', '2016-11-20 20:15:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1298', '2016-11-20 20:17:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1299', '2016-11-20 20:19:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1300', '2016-11-20 20:21:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1301', '2016-11-20 20:41:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1302', '2016-11-20 21:35:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1303', '2016-11-20 21:38:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1304', '2016-11-21 09:02:56', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1305', '2016-11-21 09:06:46', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1306', '2016-11-21 09:08:34', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1307', '2016-11-21 09:12:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1308', '2016-11-21 09:14:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1309', '2016-11-21 09:17:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1310', '2016-11-21 09:19:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1311', '2016-11-21 09:20:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1312', '2016-11-21 09:28:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1313', '2016-11-21 09:30:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1314', '2016-11-21 09:36:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1315', '2016-11-21 09:37:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1316', '2016-11-21 09:39:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1317', '2016-11-21 09:44:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1318', '2016-11-21 09:45:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1319', '2016-11-21 09:48:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1320', '2016-11-21 10:07:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1321', '2016-11-21 10:08:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1322', '2016-11-21 10:11:02', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1323', '2016-11-21 10:11:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1324', '2016-11-21 10:13:05', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1325', '2016-11-21 10:13:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1326', '2016-11-21 10:15:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1327', '2016-11-21 10:16:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1328', '2016-11-21 10:17:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1329', '2016-11-21 10:31:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1330', '2016-11-21 10:32:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1331', '2016-11-21 10:34:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1332', '2016-11-21 10:35:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1333', '2016-11-21 10:37:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1334', '2016-11-21 10:42:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1335', '2016-11-21 10:47:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1336', '2016-11-21 10:51:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1337', '2016-11-21 10:55:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1338', '2016-11-21 11:00:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1339', '2016-11-21 11:10:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1340', '2016-11-21 11:22:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1341', '2016-11-21 11:27:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1342', '2016-11-21 11:26:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1343', '2016-11-21 11:29:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1344', '2016-11-21 11:30:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1345', '2016-11-21 11:32:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1346', '2016-11-21 11:40:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1347', '2016-11-21 12:57:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1348', '2016-11-21 12:58:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1349', '2016-11-21 13:06:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1350', '2016-11-21 13:13:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1351', '2016-11-21 13:18:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1352', '2016-11-21 13:18:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1353', '2016-11-21 13:20:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1354', '2016-11-21 13:19:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1355', '2016-11-21 13:23:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1356', '2016-11-21 13:24:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1357', '2016-11-21 13:25:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1358', '2016-11-21 13:29:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1359', '2016-11-21 13:38:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1360', '2016-11-21 13:59:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1361', '2016-11-21 14:03:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1362', '2016-11-21 14:03:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1363', '2016-11-21 14:06:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1364', '2016-11-21 14:09:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1365', '2016-11-21 14:22:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1366', '2016-11-21 14:23:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1367', '2016-11-21 14:26:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1368', '2016-11-21 14:29:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1369', '2016-11-21 14:38:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1370', '2016-11-21 14:39:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1371', '2016-11-21 14:41:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1372', '2016-11-21 14:43:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1373', '2016-11-21 14:50:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1374', '2016-11-21 14:49:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1375', '2016-11-21 14:53:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1376', '2016-11-21 14:53:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1377', '2016-11-21 15:06:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1378', '2016-11-21 15:17:10', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1379', '2016-11-21 15:17:24', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1380', '2016-11-21 15:20:20', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1381', '2016-11-21 15:19:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1382', '2016-11-21 15:23:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1383', '2016-11-21 15:24:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1384', '2016-11-21 15:28:03', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1385', '2016-11-21 15:35:20', '4', 'back', '40000');
INSERT INTO `user_behavior` VALUES ('1386', '2016-11-21 15:35:24', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1387', '2016-11-21 15:34:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1388', '2016-11-21 15:37:12', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1389', '2016-11-21 15:40:52', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1390', '2016-11-21 15:40:25', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1391', '2016-11-21 15:41:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1392', '2016-11-21 15:46:29', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1393', '2016-11-21 15:50:49', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1394', '2016-11-21 15:54:03', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1395', '2016-11-21 15:54:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1396', '2016-11-21 15:56:03', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1397', '2016-11-21 15:57:26', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1398', '2016-11-21 15:58:10', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1399', '2016-11-21 15:58:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1400', '2016-11-21 16:02:11', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1401', '2016-11-21 16:04:58', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1402', '2016-11-21 16:06:13', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1403', '2016-11-21 16:08:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1404', '2016-11-21 16:16:49', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1405', '2016-11-21 16:17:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1406', '2016-11-21 16:18:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1407', '2016-11-21 16:19:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1408', '2016-11-21 16:21:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1409', '2016-11-21 16:24:01', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1410', '2016-11-21 16:28:08', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1411', '2016-11-21 16:30:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1412', '2016-11-21 16:32:41', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1413', '2016-11-21 16:31:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1414', '2016-11-21 16:52:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1415', '2016-11-21 16:56:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1416', '2016-11-21 17:15:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1417', '2016-11-21 17:15:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1418', '2016-11-21 17:28:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1419', '2016-11-21 17:31:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1420', '2016-11-21 17:31:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1421', '2016-11-21 17:36:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1422', '2016-11-21 17:38:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1423', '2016-11-21 17:57:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1424', '2016-11-21 18:02:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1425', '2016-11-21 18:03:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1426', '2016-11-21 18:05:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1427', '2016-11-21 18:07:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1428', '2016-11-21 18:13:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1429', '2016-11-21 18:14:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1430', '2016-11-21 18:21:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1431', '2016-11-21 18:24:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1432', '2016-11-21 18:29:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1433', '2016-11-21 18:38:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1434', '2016-11-21 18:49:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1435', '2016-11-21 18:50:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1436', '2016-11-21 18:56:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1437', '2016-11-21 18:59:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1438', '2016-11-21 19:00:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1439', '2016-11-21 19:04:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1440', '2016-11-21 19:03:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1441', '2016-11-21 19:05:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1442', '2016-11-21 19:10:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1443', '2016-11-21 19:13:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1444', '2016-11-21 19:18:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1445', '2016-11-21 19:35:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1446', '2016-11-21 19:36:42', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1447', '2016-11-21 19:38:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1448', '2016-11-21 19:38:28', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1449', '2016-11-21 19:40:42', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1450', '2016-11-21 19:45:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1451', '2016-11-21 19:46:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1452', '2016-11-21 19:46:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1453', '2016-11-21 19:56:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1454', '2016-11-21 19:57:52', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1455', '2016-11-21 20:07:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1456', '2016-11-21 20:09:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1457', '2016-11-21 20:12:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1458', '2016-11-21 20:18:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1459', '2016-11-21 20:21:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1460', '2016-11-21 20:21:28', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1461', '2016-11-21 20:21:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1462', '2016-11-21 20:23:49', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1463', '2016-11-21 20:28:21', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1464', '2016-11-21 20:38:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1465', '2016-11-21 20:46:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1466', '2016-11-21 20:47:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1467', '2016-11-21 20:48:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1468', '2016-11-21 20:57:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1469', '2016-11-21 21:10:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1470', '2016-11-22 09:09:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1471', '2016-11-22 09:26:19', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1472', '2016-11-22 09:29:19', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1473', '2016-11-22 09:29:26', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1474', '2016-11-22 09:39:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1475', '2016-11-22 09:39:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1476', '2016-11-22 09:55:27', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1477', '2016-11-22 09:57:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1478', '2016-11-22 09:59:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1479', '2016-11-22 10:01:05', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1480', '2016-11-22 10:01:23', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1481', '2016-11-22 10:04:12', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1482', '2016-11-22 10:05:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1483', '2016-11-22 10:05:22', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1484', '2016-11-22 10:05:44', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1485', '2016-11-22 10:05:45', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1486', '2016-11-22 10:06:05', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1487', '2016-11-22 10:09:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1488', '2016-11-22 10:16:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1489', '2016-11-22 10:16:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1490', '2016-11-22 10:18:33', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1491', '2016-11-22 10:24:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1492', '2016-11-22 10:25:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1493', '2016-11-22 10:27:52', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1494', '2016-11-22 10:28:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1495', '2016-11-22 10:41:39', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1496', '2016-11-22 10:52:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1497', '2016-11-22 11:43:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1498', '2016-11-22 11:53:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1499', '2016-11-22 11:56:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1500', '2016-11-22 12:27:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1501', '2016-11-22 12:30:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1502', '2016-11-22 12:32:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1503', '2016-11-22 12:41:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1504', '2016-11-22 13:11:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1505', '2016-11-22 13:25:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1506', '2016-11-22 13:31:20', '18', 'peception', '40000');
INSERT INTO `user_behavior` VALUES ('1507', '2016-11-22 13:31:24', '18', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1508', '2016-11-22 13:37:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1509', '2016-11-22 13:46:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1510', '2016-11-22 13:47:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1511', '2016-11-22 13:51:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1512', '2016-11-22 14:06:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1513', '2016-11-22 14:29:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1514', '2016-11-22 14:29:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1515', '2016-11-22 14:31:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1516', '2016-11-22 14:47:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1517', '2016-11-22 14:49:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1518', '2016-11-22 14:59:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1519', '2016-11-22 15:01:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1520', '2016-11-22 15:04:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1521', '2016-11-22 15:06:51', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1522', '2016-11-22 15:10:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1523', '2016-11-22 15:18:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1524', '2016-11-22 15:18:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1525', '2016-11-22 15:19:48', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1526', '2016-11-22 15:20:27', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1527', '2016-11-22 15:20:47', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1528', '2016-11-22 15:21:16', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1529', '2016-11-22 15:21:17', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1530', '2016-11-22 15:21:17', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1531', '2016-11-22 15:21:17', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1532', '2016-11-22 15:21:17', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1533', '2016-11-22 15:21:18', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1534', '2016-11-22 15:21:18', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1535', '2016-11-22 15:21:18', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1536', '2016-11-22 15:21:18', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1537', '2016-11-22 15:21:19', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1538', '2016-11-22 15:21:19', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1539', '2016-11-22 15:27:33', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1540', '2016-11-22 15:27:44', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1541', '2016-11-22 15:29:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1542', '2016-11-22 15:35:14', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1543', '2016-11-22 15:35:21', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1544', '2016-11-22 15:36:21', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1545', '2016-11-22 15:37:30', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1546', '2016-11-22 15:37:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1547', '2016-11-22 15:44:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1548', '2016-11-22 15:50:56', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1549', '2016-11-22 15:51:16', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1550', '2016-11-22 15:51:44', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1555', '2016-11-22 16:03:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1556', '2016-11-22 16:03:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1557', '2016-11-22 16:05:33', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1558', '2016-11-22 16:05:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1559', '2016-11-22 16:23:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1560', '2016-11-22 16:23:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1561', '2016-11-22 16:25:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1562', '2016-11-22 16:30:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1563', '2016-11-22 16:30:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1564', '2016-11-22 16:32:14', '3', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1565', '2016-11-22 16:47:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1566', '2016-11-22 16:48:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1567', '2016-11-22 16:49:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1568', '2016-11-22 16:52:17', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1569', '2016-11-22 16:52:26', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1570', '2016-11-22 16:58:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1571', '2016-11-22 17:07:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1572', '2016-11-22 17:20:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1573', '2016-11-22 17:24:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1574', '2016-11-22 17:30:45', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1575', '2016-11-22 17:30:56', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1576', '2016-11-22 17:36:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1577', '2016-11-22 17:39:10', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1578', '2016-11-22 17:42:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1579', '2016-11-22 17:42:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1580', '2016-11-22 17:44:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1581', '2016-11-22 17:48:04', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1582', '2016-11-22 17:53:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1583', '2016-11-22 18:01:20', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1584', '2016-11-22 18:01:31', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1585', '2016-11-22 18:12:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1586', '2016-11-22 18:13:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1587', '2016-11-22 18:39:25', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1588', '2016-11-22 18:42:35', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1589', '2016-11-22 19:02:44', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1590', '2016-11-22 19:03:18', '2', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1591', '2016-11-22 19:06:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1592', '2016-11-22 19:08:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1593', '2016-11-22 20:03:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1594', '2016-11-22 20:26:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1595', '2016-11-22 20:30:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1596', '2016-11-22 20:46:19', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1597', '2016-11-22 20:57:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1598', '2016-11-22 20:58:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1599', '2016-11-22 21:00:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1600', '2016-11-22 21:00:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1601', '2016-11-22 21:06:25', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1602', '2016-11-22 21:19:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1603', '2016-11-22 21:22:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1604', '2016-11-22 21:36:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1605', '2016-11-22 21:38:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1606', '2016-11-22 21:40:32', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1607', '2016-11-22 21:48:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1608', '2016-11-22 22:02:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1609', '2016-11-23 09:00:33', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1610', '2016-11-23 09:09:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1611', '2016-11-23 09:16:28', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1612', '2016-11-23 09:17:44', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1613', '2016-11-23 09:26:55', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1614', '2016-11-23 09:24:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1615', '2016-11-23 09:26:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1616', '2016-11-23 09:27:41', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1617', '2016-11-23 09:28:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1618', '2016-11-23 09:30:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1619', '2016-11-23 09:31:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1620', '2016-11-23 09:36:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1621', '2016-11-23 09:38:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1622', '2016-11-23 09:39:45', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1623', '2016-11-23 09:40:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1624', '2016-11-23 09:40:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1625', '2016-11-23 09:42:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1626', '2016-11-23 09:45:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1627', '2016-11-23 09:47:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1628', '2016-11-23 09:47:26', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1629', '2016-11-23 10:09:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1630', '2016-11-23 10:20:00', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1631', '2016-11-23 10:21:22', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1632', '2016-11-23 10:24:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1633', '2016-11-23 10:25:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1634', '2016-11-23 10:35:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1635', '2016-11-23 10:38:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1636', '2016-11-23 10:41:55', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1637', '2016-11-23 10:47:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1638', '2016-11-23 10:59:40', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1639', '2016-11-23 10:59:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1640', '2016-11-23 11:02:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1641', '2016-11-23 11:09:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1642', '2016-11-23 11:12:06', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1643', '2016-11-23 11:18:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1644', '2016-11-23 11:18:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1645', '2016-11-23 11:38:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1646', '2016-11-23 11:42:42', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1647', '2016-11-23 11:44:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1648', '2016-11-23 11:46:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1649', '2016-11-23 12:34:11', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1650', '2016-11-23 12:36:13', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1651', '2016-11-23 12:36:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1652', '2016-11-23 12:41:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1653', '2016-11-23 13:10:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1654', '2016-11-23 13:12:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1655', '2016-11-23 13:22:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1656', '2016-11-23 13:28:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1657', '2016-11-23 13:30:23', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1658', '2016-11-23 13:33:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1659', '2016-11-23 13:42:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1660', '2016-11-23 13:44:36', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1661', '2016-11-23 13:51:30', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1662', '2016-11-23 13:55:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1663', '2016-11-23 13:56:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1664', '2016-11-23 13:59:08', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1665', '2016-11-23 14:16:07', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1666', '2016-11-23 14:16:13', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1667', '2016-11-23 14:16:29', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1668', '2016-11-23 14:19:52', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1669', '2016-11-23 14:25:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1670', '2016-11-23 14:28:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1671', '2016-11-23 14:44:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1672', '2016-11-23 14:56:53', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1673', '2016-11-23 15:07:05', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1674', '2016-11-23 15:26:00', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1675', '2016-11-23 15:35:00', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1676', '2016-11-23 15:33:57', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1677', '2016-11-23 15:35:20', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1678', '2016-11-23 15:36:12', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1679', '2016-11-23 15:47:11', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1680', '2016-11-23 15:46:07', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1681', '2016-11-23 15:49:43', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1682', '2016-11-23 16:10:17', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1683', '2016-11-23 16:22:16', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1684', '2016-11-23 16:38:54', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1685', '2016-11-23 16:48:47', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1686', '2016-11-23 16:48:49', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1687', '2016-11-23 16:54:39', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1688', '2016-11-23 16:58:40', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1689', '2016-11-23 17:01:41', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1690', '2016-11-23 17:01:38', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1691', '2016-11-23 17:02:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1692', '2016-11-23 17:02:31', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1693', '2016-11-23 17:03:03', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1694', '2016-11-23 17:11:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1695', '2016-11-23 17:15:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1696', '2016-11-23 17:16:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1697', '2016-11-23 17:19:18', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1698', '2016-11-23 17:21:56', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1699', '2016-11-23 17:22:02', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1700', '2016-11-23 17:23:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1701', '2016-11-23 17:35:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1702', '2016-11-23 17:49:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1703', '2016-11-23 17:53:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1704', '2016-11-23 18:10:07', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1705', '2016-11-23 18:16:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1706', '2016-11-23 18:16:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1707', '2016-11-23 18:25:59', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1708', '2016-11-23 19:01:16', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1709', '2016-11-23 19:02:37', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1710', '2016-11-23 19:14:27', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1711', '2016-11-23 19:28:10', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1712', '2016-11-23 19:56:01', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1713', '2016-11-23 19:58:35', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1714', '2016-11-23 20:05:09', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1715', '2016-11-23 20:08:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1716', '2016-11-23 20:09:15', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1717', '2016-11-23 20:16:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1718', '2016-11-23 20:20:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1719', '2016-11-23 20:25:58', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1720', '2016-11-23 20:29:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1721', '2016-11-23 20:36:14', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1722', '2016-11-23 20:37:41', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1723', '2016-11-23 20:36:48', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1724', '2016-11-23 20:38:34', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1725', '2016-11-23 20:37:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1726', '2016-11-23 20:45:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1727', '2016-11-23 20:51:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1728', '2016-11-23 20:56:24', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1729', '2016-11-23 20:56:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1730', '2016-11-23 21:04:21', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1731', '2016-11-23 21:21:12', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1732', '2016-11-23 21:23:46', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1733', '2016-11-23 21:28:50', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1734', '2016-11-24 09:15:17', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1735', '2016-11-24 09:18:52', '4', 'back', '10000');
INSERT INTO `user_behavior` VALUES ('1736', '2016-11-24 09:25:43', '1', 'peception', '10000');
INSERT INTO `user_behavior` VALUES ('1737', '2016-11-24 09:40:40', '1', 'peception', '10000');

-- ----------------------------
-- Table structure for `user_complain`
-- ----------------------------
DROP TABLE IF EXISTS `user_complain`;
CREATE TABLE `user_complain` (
  `complain_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '举报ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `complain_object` varchar(200) DEFAULT NULL COMMENT '举报对象',
  `complain_content` varchar(500) DEFAULT NULL COMMENT '举报内容',
  `complain_update_time` datetime DEFAULT NULL COMMENT '处理时间',
  `complain_advice` varchar(500) DEFAULT NULL COMMENT '处理意见',
  `complain_status` int(11) DEFAULT NULL COMMENT '投诉举报状态',
  `complain_datetime` datetime DEFAULT NULL COMMENT '举报时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`complain_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='投诉举报';

-- ----------------------------
-- Records of user_complain
-- ----------------------------
INSERT INTO `user_complain` VALUES ('1', '1', ' 江南皮革一厂', '钱包质量不好', '2016-11-15 16:47:43', '情况属实已做封号处理', '110002', '2016-11-12 15:35:29', '');
INSERT INTO `user_complain` VALUES ('2', '2', '江南皮革二厂', '老板黄鹤跑路了', '2016-11-15 16:47:47', '无违规情况，无需处理', '110003', '2016-11-12 15:40:49', '');
INSERT INTO `user_complain` VALUES ('3', '1', 'NumberONE', 'You are NumberONE !', '2016-11-16 10:26:13', '情况不实，已忽略', '110003', '2016-11-16 09:56:42', '');
INSERT INTO `user_complain` VALUES ('4', '1', 'NumberONE1', 'You are NumberONE1 !', null, null, '110001', '2016-11-16 09:57:27', '');
INSERT INTO `user_complain` VALUES ('5', '1', 'NumberONE2', 'You are NumberONE2 !', null, null, '110001', '2016-11-16 09:57:33', '');
INSERT INTO `user_complain` VALUES ('6', '1', 'NumberONE3', 'You are NumberONE3 !', null, null, '110001', '2016-11-16 09:57:38', '');

-- ----------------------------
-- Table structure for `user_creative_talent`
-- ----------------------------
DROP TABLE IF EXISTS `user_creative_talent`;
CREATE TABLE `user_creative_talent` (
  `creative_talent_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '创意人才ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `talent_name` varchar(50) DEFAULT NULL COMMENT '人才名称',
  `work_mode` varchar(200) DEFAULT NULL COMMENT '工作方式',
  `work_time` varchar(200) DEFAULT NULL COMMENT '工作时间',
  `now_address` varchar(200) DEFAULT NULL COMMENT '所在地',
  `hope_salary` decimal(10,2) DEFAULT NULL COMMENT '期望薪资',
  `talent_description` varchar(2000) DEFAULT NULL COMMENT '技能特长',
  `talent_work_experience` varchar(2000) DEFAULT NULL COMMENT '项目经验',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `is_open` bit(1) DEFAULT b'1' COMMENT '是否公开',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`creative_talent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='创意人才';

-- ----------------------------
-- Records of user_creative_talent
-- ----------------------------
INSERT INTO `user_creative_talent` VALUES ('1', '2', '123', '123', '123', '123', '1312.00', '1231231', '123123123', '2016-11-14 20:59:36', '', '');
INSERT INTO `user_creative_talent` VALUES ('2', '1', 'javascript11111', '白天', '2016-10-12', '纽约', '100.00', '前端架构', '100年', null, '', '');

-- ----------------------------
-- Table structure for `user_extension_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_extension_info`;
CREATE TABLE `user_extension_info` (
  `extension_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '扩展信息ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_real_name` varchar(50) DEFAULT NULL COMMENT '用户实名',
  `credit_type` varchar(20) DEFAULT NULL COMMENT '证件类型',
  `credit_number` varchar(100) DEFAULT NULL COMMENT '证件号码',
  `credit_file_name` varchar(100) DEFAULT NULL COMMENT '证件文件名称',
  `credit_front_path` varchar(200) DEFAULT NULL COMMENT '证件文件正面路径',
  `credit_back_path` varchar(200) DEFAULT NULL COMMENT '证件文件反面路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`extension_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户扩展信息';

-- ----------------------------
-- Records of user_extension_info
-- ----------------------------
INSERT INTO `user_extension_info` VALUES ('1', '7', '高狄升', '', '121245898542155415', 'hgjhjh', 'hjjhhjffffff', 'jhfffff', '2016-11-14 10:32:57');
INSERT INTO `user_extension_info` VALUES ('2', '7', 'gds', '身份证', '123456789', '6407720161111055556', 'fffffffffffffffffffffff', 'fffffffffffff', '2016-11-18 16:51:16');
INSERT INTO `user_extension_info` VALUES ('3', '8', null, '身份证', '114114411414114', '4222220161111055714', null, null, null);
INSERT INTO `user_extension_info` VALUES ('4', '9', '12', '身份证', '320481199112190212', '3489020161114050545', 'sdafsafdsad', 'cai', null);
INSERT INTO `user_extension_info` VALUES ('5', '10', '123', '身份证', '320481199112190212', '3090020161114085714', 'sdafsafdsad', 'cai', null);

-- ----------------------------
-- Table structure for `user_house`
-- ----------------------------
DROP TABLE IF EXISTS `user_house`;
CREATE TABLE `user_house` (
  `house_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收藏ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `house_type` int(11) DEFAULT NULL COMMENT '收藏类型',
  `house_resource_id` bigint(20) DEFAULT NULL COMMENT '收藏资源ID',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`house_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 COMMENT='用户收藏';

-- ----------------------------
-- Records of user_house
-- ----------------------------
INSERT INTO `user_house` VALUES ('1', '1', '700005', '1', '');
INSERT INTO `user_house` VALUES ('2', '1', '700005', '2', '');
INSERT INTO `user_house` VALUES ('3', '1', '700005', '3', '');
INSERT INTO `user_house` VALUES ('4', '1', '700005', '4', '');
INSERT INTO `user_house` VALUES ('5', '1', '700005', '5', '');
INSERT INTO `user_house` VALUES ('6', '1', '700004', '6', '');
INSERT INTO `user_house` VALUES ('7', '1', '700004', '7', '');

-- ----------------------------
-- Table structure for `user_receive_message`
-- ----------------------------
DROP TABLE IF EXISTS `user_receive_message`;
CREATE TABLE `user_receive_message` (
  `receive_id` bigint(20) DEFAULT NULL,
  `message_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `receive_datetime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_receive_message
-- ----------------------------

-- ----------------------------
-- Table structure for `virtual_aboratory`
-- ----------------------------
DROP TABLE IF EXISTS `virtual_aboratory`;
CREATE TABLE `virtual_aboratory` (
  `virtual_aboratory_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '虚拟实验室ID',
  `equipment_number` bigint(20) DEFAULT NULL COMMENT '设备编号',
  `virtual_version` varchar(50) DEFAULT NULL COMMENT '当前版本',
  `virtual_type` int(11) DEFAULT NULL COMMENT '类型',
  `virtual_owner_name` varchar(50) DEFAULT NULL COMMENT '所有者名称',
  `virtual_count` int(11) DEFAULT NULL COMMENT '数量',
  `parent_virtual_aboratory` bigint(20) DEFAULT NULL COMMENT '父虚拟实验室ID',
  `virtual_aboratory_name` varchar(50) DEFAULT NULL COMMENT '虚拟实验室名称',
  `virtual_aboratory_introduce` varchar(200) DEFAULT NULL COMMENT '虚拟实验室介绍',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`virtual_aboratory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='虚拟实验室';

-- ----------------------------
-- Records of virtual_aboratory
-- ----------------------------
INSERT INTO `virtual_aboratory` VALUES ('1', null, null, null, null, null, null, '软件测试', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('2', null, null, null, null, null, null, '计算机司法鉴定', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('3', null, null, null, null, '20', '1', 'TestShell', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('4', null, null, null, null, '50', '1', 'QAload', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('5', null, null, null, null, '60', '1', 'QADirector', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('6', null, null, null, null, '70', '1', '绿盟远程安全评估系统', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('7', null, null, null, null, '80', '1', 'WEB应用弱点扫描器', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('8', null, null, null, null, null, '1', 'QARun', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('9', null, null, null, null, null, '1', 'QACenter', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('10', null, null, null, null, null, '1', 'Beyond', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('11', null, null, null, null, null, '1', 'WebsiteEdition', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('12', null, null, null, null, null, '1', 'Compare', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('13', null, null, null, null, null, '1', 'HP QC', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('14', null, null, null, null, null, '1', 'HP QTP', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('15', null, null, null, null, null, '1', 'HP PC', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('16', null, null, null, null, null, '1', 'HP NNMI', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('17', null, null, null, null, null, '1', 'HP QAInspect', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('18', null, null, null, null, null, '1', 'HP WebInspect', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('19', null, null, null, null, null, '1', 'LDRA Testbed', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('20', null, null, null, null, null, '1', 'QACenter WebsiteEdition', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('21', null, null, null, null, null, '2', 'QADirector', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('22', null, null, null, null, null, '2', 'SO在线邮箱取证系统', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('23', null, null, null, null, null, '2', 'ilook-forensics法证版', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('24', null, null, null, null, null, '2', 'F-response法正版', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('25', null, null, null, null, null, '2', 'SANS课件', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('26', null, null, null, null, null, '2', 'Aircp NX', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('27', null, null, null, null, null, '2', 'SP-FCD取证分析软件', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('28', null, null, null, null, null, '2', '浦软翔鹰企业安全服务平台', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('29', null, null, null, null, null, '2', 'ISOBUSTER2.8.5', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('30', null, null, null, null, null, '2', 'Vmware7.0', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('31', null, null, null, null, null, '2', 'PS-VM1.0', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('32', null, null, null, null, null, '2', 'SO-SYS-CRACK1.0', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('33', null, null, null, null, null, '2', 'GT-ALLinone密码库', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('34', null, null, null, null, null, '2', 'Eiconmsoft法证版', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('35', null, null, null, null, null, '2', 'R-STUDIO Network Edition', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('36', null, null, null, null, null, '2', 'IDA-Pro(带Hexray)', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('37', null, null, null, null, null, '2', 'SAMINSIDE2.6取证分析软件', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('38', null, null, null, null, null, '2', 'Belkasoft Evidence Center 标准版', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('39', null, null, null, null, null, '2', 'EasyRecvevery', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('40', null, null, null, null, null, '2', 'FINLFORENSICS3.1', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('41', null, null, null, null, null, '2', 'PS-SIV2.0', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('42', null, null, null, null, null, '2', 'PS-IDVP-PRO', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('43', null, null, null, null, null, '2', 'FTK3.0', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('44', null, null, null, null, null, '2', 'Encase7.0', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('45', null, null, null, null, null, '2', 'Maclockpick II', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('46', null, null, null, null, null, '2', 'MACForensicLab', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('47', null, null, null, null, null, '2', 'Solid Optimus', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('48', null, null, null, null, null, '2', '常规密码库-T-MD5\\TW14', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('49', null, null, null, null, null, '2', 'imageSAN', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('50', null, null, null, null, null, '2', 'PC3000FLlash', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('51', null, null, null, null, null, '2', 'Winhex X-Ways Forensics', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('52', null, null, null, null, null, '2', 'mountimage Pro V4', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('53', null, null, null, null, null, '2', 'Belkasoft Evidence Center 标准版', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('54', null, null, null, null, null, '2', 'R-STUDIO Network Edition', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('55', null, null, null, null, null, '2', '美亚案件管理系统', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('56', null, null, null, null, null, '2', '屏幕录像管理专家', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('57', null, null, null, null, null, '2', 'Solid Optimus', '', null, '');
INSERT INTO `virtual_aboratory` VALUES ('58', null, null, null, null, null, '2', '常规密码库T-WV8', '', null, '');

-- ----------------------------
-- Table structure for `virtual_application`
-- ----------------------------
DROP TABLE IF EXISTS `virtual_application`;
CREATE TABLE `virtual_application` (
  `virtual_application_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '虚拟实验室申请ID',
  `virtual_id` bigint(20) DEFAULT NULL COMMENT '虚拟实验室ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '申请人',
  `application_count` int(11) DEFAULT NULL COMMENT '申请数量',
  `application_start_date` date DEFAULT NULL COMMENT '开始使用时间',
  `application_end_date` date DEFAULT NULL COMMENT '归还日期',
  `application_discription` varchar(200) DEFAULT NULL COMMENT '申请描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `active` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`virtual_application_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='虚拟实验室申请';

-- ----------------------------
-- Records of virtual_application
-- ----------------------------
INSERT INTO `virtual_application` VALUES ('1', '3', null, '1', '2016-11-17', '2016-11-19', null, null, '');
INSERT INTO `virtual_application` VALUES ('4', '3', null, '1', '2016-11-18', '2016-11-21', null, null, '');
INSERT INTO `virtual_application` VALUES ('5', '3', null, '3', '2016-11-22', '2016-11-25', null, null, '');
INSERT INTO `virtual_application` VALUES ('6', '3', null, '1', '2016-11-16', '2016-11-26', null, null, '');
INSERT INTO `virtual_application` VALUES ('7', '3', null, '1', '2016-11-15', '2016-11-19', null, null, '');

-- ----------------------------
-- View structure for `v_back_user`
-- ----------------------------
DROP VIEW IF EXISTS `v_back_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `v_back_user` AS select `tu`.`user_id` AS `user_id`,`tu`.`user_name` AS `user_name`,`tu`.`user_alias` AS `user_alias`,`tu`.`user_pwd` AS `user_pwd`,`tu`.`user_department` AS `user_department`,`tu`.`user_mobile` AS `user_mobile`,`tu`.`user_email` AS `user_email`,`tu`.`create_datetime` AS `create_datetime`,`tu`.`active` AS `active`,`tur`.`role_id` AS `role_id` from (`back_user` `tu` left join `back_user_role` `tur` on((`tu`.`user_id` = `tur`.`user_id`))) ;
