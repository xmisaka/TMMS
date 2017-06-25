/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : tmms

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-06-25 15:25:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(150) DEFAULT '' COMMENT '教材书名',
  `book_kind` varchar(4) DEFAULT NULL COMMENT '教材类型',
  `book_author` varchar(150) DEFAULT '' COMMENT '作者',
  `book_ISBN` varchar(150) DEFAULT '' COMMENT '书的ISBN号',
  `book_publish` varchar(150) DEFAULT '' COMMENT '出版社',
  `book_publish_time` varchar(50) DEFAULT NULL COMMENT '出版时间',
  `book_price` decimal(20,2) DEFAULT NULL COMMENT '教材价格',
  `book_intro` varchar(600) DEFAULT NULL COMMENT '教材简介',
  `create_time` datetime DEFAULT NULL COMMENT '添加日期',
  `update_time` datetime DEFAULT NULL,
  `extend1` varchar(150) DEFAULT NULL,
  `extend2` varchar(150) DEFAULT NULL,
  `extend3` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_book_ISBN` (`book_ISBN`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES ('1', '大型网站技术架构', '计算机', '李智慧', '9787121212000', '电子工业出版社', '2013', '59.00', '大型网站技术架构核心原理与案例分析', '2017-05-30 17:05:12', '2017-05-30 17:05:12', null, null, null);
INSERT INTO `book_info` VALUES ('2', '深入理解Java虚拟机', '计算机', '周志明', '9787121222222啊啊啊啊啊', '顶顶顶顶', '2014', '66.66', '测试用的', '2017-05-30 17:05:12', '2017-05-30 17:05:12', null, null, null);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `extend1` varchar(200) DEFAULT NULL,
  `extend2` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_role_permission` (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_no` varchar(32) NOT NULL COMMENT '学生学号',
  `student_name` varchar(150) DEFAULT NULL COMMENT '学生姓名',
  `student_sex` varchar(2) DEFAULT NULL COMMENT '学生性别',
  `mobile` varchar(11) DEFAULT NULL,
  `student_pwd` varchar(150) DEFAULT NULL COMMENT '学生密码',
  `student_grade` varchar(150) DEFAULT NULL COMMENT '学生年级',
  `class_id` varchar(32) DEFAULT NULL COMMENT '所属班级号',
  `specialty_id` varchar(32) DEFAULT NULL COMMENT '所属专业号',
  `college_id` varchar(32) DEFAULT NULL COMMENT '所属院系号',
  `enter_time` datetime DEFAULT NULL COMMENT '入学时间',
  `pay_status` varchar(2) DEFAULT NULL COMMENT '缴费状态',
  `initial_amount` decimal(20,2) DEFAULT NULL COMMENT '初始缴费金额',
  `state` tinyint(4) DEFAULT '1' COMMENT '1代表正常，2代表毕业，0代表无效',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `extend1` varchar(150) DEFAULT NULL,
  `extend2` varchar(150) DEFAULT NULL,
  `extend3` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_student_no` (`student_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生基本信息表';

-- ----------------------------
-- Records of student_info
-- ----------------------------

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_no` varchar(18) NOT NULL COMMENT '职工号',
  `teacher_name` varchar(100) DEFAULT NULL COMMENT '教职工姓名',
  `teacher_sex` char(2) DEFAULT NULL,
  `moblie` varchar(11) DEFAULT NULL COMMENT '教职工手机号',
  `teacher_pwd` varchar(20) DEFAULT NULL COMMENT '教职工密码',
  `college_id` varchar(32) DEFAULT NULL COMMENT '所属院系号',
  `technical_title` varchar(50) DEFAULT NULL COMMENT '职称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `state` tinyint(4) DEFAULT '1',
  `extend1` varchar(150) DEFAULT NULL COMMENT '教职工性别',
  `extend2` varchar(150) DEFAULT NULL,
  `extend3` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_teacher_no` (`teacher_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_info
-- ----------------------------

-- ----------------------------
-- Table structure for tmms_syslog
-- ----------------------------
DROP TABLE IF EXISTS `tmms_syslog`;
CREATE TABLE `tmms_syslog` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键,32未序列',
  `user_id` int(11) NOT NULL COMMENT '操作ID',
  `user_name` varchar(100) NOT NULL COMMENT '操作人',
  `oper_ip` varchar(30) NOT NULL COMMENT '操作会员IP',
  `oper_time` datetime NOT NULL COMMENT '操作日期',
  `oper_url` text COMMENT '操作URL',
  `oper_description` text COMMENT '操作描述',
  `oper_type` varchar(255) DEFAULT NULL COMMENT '类型',
  `EXTEND0` varchar(255) DEFAULT NULL COMMENT '扩展字段0',
  `EXTEND1` varchar(255) DEFAULT NULL COMMENT '扩展字段1',
  `EXTEND2` varchar(255) DEFAULT NULL COMMENT '扩展字段2',
  `EXTEND3` varchar(255) DEFAULT NULL COMMENT '扩展字段3',
  `EXTEND4` varchar(255) DEFAULT NULL COMMENT '扩展字段4',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmms_syslog
-- ----------------------------

-- ----------------------------
-- Table structure for tmms_user
-- ----------------------------
DROP TABLE IF EXISTS `tmms_user`;
CREATE TABLE `tmms_user` (
  `id` int(11) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `state` tinyint(4) DEFAULT '1' COMMENT '表示user状态，1表示正常，0表示无效',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `inx_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmms_user
-- ----------------------------

-- ----------------------------
-- Table structure for user_permission
-- ----------------------------
DROP TABLE IF EXISTS `user_permission`;
CREATE TABLE `user_permission` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(200) DEFAULT NULL,
  `permission_description` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `extend1` varchar(200) DEFAULT NULL,
  `extend2` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `inx_permission_name` (`permission_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_permission
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `role_description` varchar(1000) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime DEFAULT NULL COMMENT '表创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '表最后一次更新时间',
  `extend1` varchar(200) DEFAULT NULL,
  `extend2` varchar(200) DEFAULT NULL,
  `state` tinyint(4) DEFAULT '1' COMMENT '表示角色当前的状态，0表示冻结，1表示正常',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_role_name` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '学生', '普通学生，可以自助选书', '2017-05-30 17:05:12', '2017-05-30 17:05:12', null, null, '1');
INSERT INTO `user_role` VALUES ('2', '中心管理员', '后台管理员', '2017-05-30 17:05:12', '2017-05-30 17:05:12', null, null, '1');
INSERT INTO `user_role` VALUES ('3', '院系管理员', '院系管理员', '2017-05-30 17:05:12', '2017-05-30 17:05:12', null, null, '1');
