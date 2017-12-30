/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : tmms

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-08-02 16:04:15
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `book_info`
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO book_info VALUES ('1', '大型网站技术架构', '1', '李智慧3', '7-111-19947-2', '电子工业出版社', '0121-01-08 00:00:00', '59.00', '大型网站技术架构核心原理与案例分析', null, null, null, null, null);
INSERT INTO book_info VALUES ('2', '深入理解Java虚拟机', '2', '周志明', '9787121222222啊啊啊啊啊', '顶顶顶顶', '2014', '66.66', '测试用的', '2017-05-30 17:05:12', '2017-05-30 17:05:12', null, null, null);
INSERT INTO book_info VALUES ('15', 'java从入门到精通', '3', '国家863中部软件孵化器', '9787115223678', '人民邮电出版社', '2010-04-01 00:00:00', '59.00', '以零基础讲解为宗旨，深入浅出地讲解Java的各项技术及实战技能。', '2017-06-30 09:24:59', '2017-06-30 09:24:59', null, null, null);
INSERT INTO book_info VALUES ('16', '编译原理', '4', '陈火旺', '978-7-118-02207-0', '国防工业出版社', '2010-02-04 00:00:00', '31.00', '本书比较全面、系统地介绍了编译程序构造的一般原理和基本实现方法，内容包括词法分析、语法分析、属性文法与语法制导翻译、语义分析与中间代码产生、符号表与运行时存储空间组织、优化与目标代码生成、并行编译技术。', '2017-06-30 09:24:59', '2017-06-30 09:24:59', null, null, null);
INSERT INTO book_info VALUES ('17', '大数据思维与决策', '1', '伊恩·艾瑞斯 (Ian Ayres)', '7115370656', '人民邮电出版社', '2014-04-17 00:00:00', '87.00', '大数据时代奠基之作，Surper Crunchers的中文升级版', '2017-06-30 09:24:59', '2017-06-30 09:24:59', null, null, null);
INSERT INTO book_info VALUES ('18', '深入解析Spring MVC与Web Flow', '2', '拉德', '9787115169730', '人民邮电出版社', '2014-09-08 00:00:00', '56.00', '本书是Spring MVC和Web Flow两个框架的权威指南，书中包括的技巧和提示可以让你从这个灵活的框架中汲取尽可能多的信息。', '2017-06-30 09:24:59', '2017-06-30 09:24:59', null, null, null);
INSERT INTO book_info VALUES ('20', '打到', '3', '阿萨德', '23423', '2342', '2015-08-09 00:00:00', '4.00', '', null, null, null, null, null);
INSERT INTO book_info VALUES ('21', '和第三方', '1', '地方', '4234', '机械工业出版社', '2017-07-23 00:00:00', '3453.00', '', null, null, null, null, null);
INSERT INTO book_info VALUES ('22', '的放到个大范甘迪', '1', '热天', '45645645645', '机械工业出版社', '2017-07-23 00:00:00', '4535.00', '3453', null, null, null, null, null);
INSERT INTO book_info VALUES ('25', '21天学通java', '2', '国家863中部软件孵化器', '9787115289678', '人民邮电出版社', '2010-04-01 00:00:00', '59.00', '以零基础讲解为宗旨，深入浅出地讲解Java的各项技术及实战技能。', '2017-08-02 09:49:35', '2017-08-02 09:49:35', null, null, null);
INSERT INTO book_info VALUES ('26', 'java程序员修炼之道', '2', '吴海星', '9787115321954', '人民邮电出版社', '2013-05-06 00:00:00', '89.00', '本书分为四部分，第一部分全面介绍Java 7 的新特性，第二部分探讨Java 关键编程知识和技术，第三部分讨论JVM 上的新语言和多语言编程，第四部分将平台和多语言编程知识付诸实践。从介绍Java 7 的新特性入手，本书涵盖了Java 开发中最重要的技术，比如依赖注入、测试驱动的开发和持续集成，探索了JVM 上的非Java 语言，并详细讲解了多语言项目， 特别是涉及Groovy、Scala 和Clojure 语言的项目。此外，书中含有大量代码示例，帮助读者从实践中理解Java 语言和平台。', '2017-08-02 09:49:35', '2017-08-02 09:49:35', null, null, null);

-- ----------------------------
-- Table structure for `class_info`
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `class_id` varchar(32) NOT NULL COMMENT '班级号',
  `class_name` varchar(150) DEFAULT NULL COMMENT '班级名',
  `class_pwd` varchar(150) DEFAULT NULL COMMENT '班级密码',
  `college_id` varchar(150) DEFAULT NULL COMMENT '所属学院号',
  `specialty_id` varchar(150) DEFAULT NULL COMMENT '所属专业号',
  `grade` varchar(150) DEFAULT NULL COMMENT '年级',
  `monitor_no` varchar(150) DEFAULT NULL COMMENT '班长学号',
  `monitor_name` varchar(150) DEFAULT NULL COMMENT '班长姓名',
  `monitor_linkinfo` varchar(150) DEFAULT NULL COMMENT '班长联系方式',
  `student_num` int(20) DEFAULT NULL COMMENT '学生总数量',
  `paid_student_num` int(20) DEFAULT NULL COMMENT '已缴费学生数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL,
  `extend1` varchar(150) DEFAULT NULL,
  `extend2` varchar(150) DEFAULT NULL,
  `extend3` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  UNIQUE KEY `idx_class_name` (`class_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO class_info VALUES ('cc1', '临床一班', null, 'c1', 's1', '4', '45', '56', '67', '65', '54', null, null, null, null, null);
INSERT INTO class_info VALUES ('cc2', '临床二班', null, 'c1', 's1', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO class_info VALUES ('cc3', '内科一班', null, 'c1', 's2', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO class_info VALUES ('cc4', '内科二班', null, 'c1', 's2', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO class_info VALUES ('cc5', '软件一班', null, 'c2', 's3', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO class_info VALUES ('cc6', '软件二班', null, 'c2', 's3', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO class_info VALUES ('cc7', '通信一班', null, 'c2', 's4', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO class_info VALUES ('cc8', '通信二班', null, 'c2', 's4', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO class_info VALUES ('f02d9cab474c4627bade9c233cbfb328', '国外旅游1班', null, '95e80bce70b1469090455bfc5b3822ec', 'ab52e752b95642599d6c72c679951804', '4', '324', '2342', '324324', '44', '23', '2017-07-26 14:22:53', '2017-07-26 14:22:53', null, null, null);

-- ----------------------------
-- Table structure for `code_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `code_catalog`;
CREATE TABLE `code_catalog` (
  `CODENO` varchar(50) NOT NULL COMMENT '类别编号',
  `CODENAME` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `CODEDESCRIBE` varchar(50) DEFAULT NULL COMMENT '类别描述',
  `ITEMNOLENGTH` int(11) DEFAULT NULL COMMENT '编码长度',
  `KIND` varchar(50) DEFAULT NULL COMMENT '种类',
  `PARENTCODENO` varchar(50) DEFAULT NULL COMMENT '上级编码',
  PRIMARY KEY (`CODENO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code_catalog
-- ----------------------------
INSERT INTO code_catalog VALUES ('BOOKTYPE', '书类型', '书的类型', null, null, null);
INSERT INTO code_catalog VALUES ('COURSEKIND', '课程类型', '课程类型', null, null, null);
INSERT INTO code_catalog VALUES ('COURSETERM', '学期', '学期', null, null, null);
INSERT INTO code_catalog VALUES ('GRADE', '年级', '年级', null, null, null);
INSERT INTO code_catalog VALUES ('SEX', '性别', '性别', null, null, null);

-- ----------------------------
-- Table structure for `code_library`
-- ----------------------------
DROP TABLE IF EXISTS `code_library`;
CREATE TABLE `code_library` (
  `id` varchar(32) NOT NULL,
  `codeno` varchar(32) DEFAULT NULL COMMENT '类别代码',
  `itemno` varchar(11) DEFAULT NULL COMMENT '序号',
  `itemname` varchar(120) DEFAULT NULL COMMENT '分类名字',
  `addtime` datetime DEFAULT NULL,
  `extend1` varchar(120) DEFAULT NULL,
  `extend2` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code_library
-- ----------------------------
INSERT INTO code_library VALUES ('0280185ebde147549f72df5747e35110', 'BOOKTYPE', '5', '历史', '2017-07-27 12:00:25', null, null);
INSERT INTO code_library VALUES ('8066c299fd6e48af96eaee2bd6d0eee8', 'COURSEKIND', '3', '未知性别', null, null, null);
INSERT INTO code_library VALUES ('b1fa5be68ee94c9288e6caaab93395f3', 'SEX', '3', '中性', '2017-07-27 11:33:47', null, null);
INSERT INTO code_library VALUES ('CL1', 'BOOKTYPE', '1', '数学', '2017-07-19 16:51:09', null, null);
INSERT INTO code_library VALUES ('CL10', 'GRADE', '4', '大四', '2017-07-21 09:29:16', null, null);
INSERT INTO code_library VALUES ('CL11', 'COURSETERM', '1', '第一学期', '2017-07-24 17:58:19', null, null);
INSERT INTO code_library VALUES ('CL12', 'COURSETERM', '2', '第二学期', '2017-07-24 17:58:52', null, null);
INSERT INTO code_library VALUES ('CL13', 'COURSEKIND', '1', '选修', '2017-07-24 17:59:27', null, null);
INSERT INTO code_library VALUES ('CL14', 'COURSEKIND', '2', '必修', '2017-07-24 17:59:44', null, null);
INSERT INTO code_library VALUES ('CL2', 'BOOKTYPE', '2', '英语', '2017-07-19 16:51:33', null, null);
INSERT INTO code_library VALUES ('CL3', 'BOOKTYPE', '3', '自然科学', '2017-07-19 16:52:39', null, null);
INSERT INTO code_library VALUES ('CL4', 'BOOKTYPE', '4', '政治', '2017-07-19 16:53:13', null, null);
INSERT INTO code_library VALUES ('CL5', 'SEX', '1', '男', '2017-07-21 09:12:46', null, null);
INSERT INTO code_library VALUES ('CL6', 'SEX', '2', '女', '2017-07-21 09:13:05', null, null);
INSERT INTO code_library VALUES ('CL7', 'GRADE', '1', '大一', '2017-07-21 09:28:03', null, null);
INSERT INTO code_library VALUES ('CL8', 'GRADE', '2', '大二', '2017-07-21 09:28:37', null, null);
INSERT INTO code_library VALUES ('CL9', 'GRADE', '3', '大三', '2017-07-21 09:29:00', null, null);

-- ----------------------------
-- Table structure for `college_info`
-- ----------------------------
DROP TABLE IF EXISTS `college_info`;
CREATE TABLE `college_info` (
  `college_id` varchar(32) NOT NULL COMMENT '院系代码',
  `college_name` varchar(150) DEFAULT NULL COMMENT '院系名字',
  `college_pwd` varchar(150) DEFAULT NULL COMMENT '院系密码',
  `college_principal` varchar(150) DEFAULT NULL COMMENT '院系负责人',
  `school` varchar(150) DEFAULT NULL COMMENT '所属学校',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `extend1` varchar(150) DEFAULT NULL,
  `extend2` varchar(150) DEFAULT NULL,
  `extend3` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`college_id`),
  UNIQUE KEY `idx_ University` (`college_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college_info
-- ----------------------------
INSERT INTO college_info VALUES ('95e80bce70b1469090455bfc5b3822ec', '旅游学院', null, '小王', '郑大', '2017-07-25 16:50:15', '2017-07-25 16:50:15', null, null, null);
INSERT INTO college_info VALUES ('c1', '基础医学院', null, '勒布朗', '郑大', null, null, null, null, null);
INSERT INTO college_info VALUES ('c2', '信息工程学院', null, '白猫', '郑大', null, null, null, null, null);
INSERT INTO college_info VALUES ('c2ce9dcee8b442f99954445d03bcc432', '物理学院', null, '吴大人', '郑大', '2017-07-25 16:47:58', '2017-07-25 16:47:58', null, null, null);

-- ----------------------------
-- Table structure for `course_info`
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_no` varchar(32) DEFAULT NULL COMMENT '课程号',
  `course_name` varchar(150) DEFAULT NULL COMMENT '课程名称',
  `course_grade` varchar(150) DEFAULT NULL COMMENT '年级',
  `course_term` varchar(150) DEFAULT NULL COMMENT '学期',
  `college_id` varchar(32) DEFAULT NULL COMMENT '授课院系',
  `specialty_id` varchar(32) DEFAULT NULL COMMENT '授课专业',
  `course_kind` varchar(150) DEFAULT NULL COMMENT '课程性质',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `extend1` varchar(150) DEFAULT NULL,
  `extend2` varchar(150) DEFAULT NULL,
  `extend3` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_course_no` (`course_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_info
-- ----------------------------
INSERT INTO course_info VALUES ('1', '546456', '高数', '4', '1', 'c1', 's1', '1', null, null, null, null, null);
INSERT INTO course_info VALUES ('2', '7678789', '编译原理', '4', '1', 'c1', 's1', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for `menuitem`
-- ----------------------------
DROP TABLE IF EXISTS `menuitem`;
CREATE TABLE `menuitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单ID',
  `menu_name` varchar(100) DEFAULT NULL COMMENT '菜单名',
  `uri` varchar(100) DEFAULT NULL COMMENT '访问地址',
  `icon` varchar(32) DEFAULT NULL COMMENT '菜单图标',
  `valid` varchar(2) DEFAULT NULL COMMENT '有效标志（0无效，1有效）',
  `create_time` datetime DEFAULT NULL,
  `updata_time` datetime DEFAULT NULL,
  `extend1` varchar(100) DEFAULT NULL,
  `extend2` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menuitem
-- ----------------------------
INSERT INTO menuitem VALUES ('0', null, '根目录', null, null, null, null, null, '1', null);
INSERT INTO menuitem VALUES ('2', '0', '书库信息', 'book/books', 'icon-book', null, null, null, '1', null);
INSERT INTO menuitem VALUES ('7', '2', '教材书目', 'book/books', 'icon-double-angle-right', null, null, null, '', null);
INSERT INTO menuitem VALUES ('13', '0', '院系信息', 'college/colleges', 'icon-lemon', null, '2017-08-01 09:14:33', '2017-08-01 09:14:33', '1', null);
INSERT INTO menuitem VALUES ('14', '13', '院系管理', 'college/colleges', 'icon-double-angle-right', null, '2017-08-01 09:15:05', '2017-08-01 09:15:05', null, null);
INSERT INTO menuitem VALUES ('15', '13', '专业管理', 'specialty/specialtys', 'icon-double-angle-right', null, '2017-08-01 09:15:44', '2017-08-01 09:15:44', null, null);
INSERT INTO menuitem VALUES ('16', '0', '班级信息', 'class/classs', 'icon-bold', null, '2017-08-01 09:16:14', '2017-08-01 09:16:14', '1', null);
INSERT INTO menuitem VALUES ('17', '16', '班级管理', 'class/classs', 'icon-double-angle-right', null, '2017-08-01 09:16:53', '2017-08-01 09:16:53', null, null);
INSERT INTO menuitem VALUES ('19', '0', '学生信息', 'stu/students', 'icon-male', null, '2017-08-01 09:17:35', '2017-08-01 09:17:35', '1', null);
INSERT INTO menuitem VALUES ('20', '19', '学生管理', 'stu/students', 'icon-double-angle-right', null, '2017-08-01 09:17:59', '2017-08-01 09:17:59', null, null);
INSERT INTO menuitem VALUES ('21', '0', '教师信息', 'teacher/teachers', 'icon-pencil', null, '2017-08-01 09:18:27', '2017-08-01 09:18:27', '1', null);
INSERT INTO menuitem VALUES ('22', '21', '教师管理', 'teacher/teachers', 'icon-double-angle-right', null, '2017-08-01 09:18:47', '2017-08-01 09:18:47', null, null);
INSERT INTO menuitem VALUES ('23', '0', '用户信息', '', 'icon-user', null, '2017-08-01 09:19:37', '2017-08-01 09:19:37', '1', null);
INSERT INTO menuitem VALUES ('24', '23', '用户管理', 'tmmsuser/tmmsusers', 'icon-double-angle-right', null, '2017-08-01 10:11:34', '2017-08-01 10:11:34', '', null);
INSERT INTO menuitem VALUES ('25', '23', '角色管理', 'userrole/userroles', 'icon-double-angle-right', null, '2017-08-01 10:14:43', '2017-08-01 10:14:43', null, null);
INSERT INTO menuitem VALUES ('26', '23', '权限管理', 'userpermission/userpermissions', 'icon-double-angle-right', null, '2017-08-01 10:15:13', '2017-08-01 10:15:13', null, null);
INSERT INTO menuitem VALUES ('27', '0', '课程信息', '', 'icon-table', null, '2017-08-01 10:15:55', '2017-08-01 10:15:55', '1', null);
INSERT INTO menuitem VALUES ('28', '27', '课程管理', 'course/courses', 'icon-double-angle-right', null, '2017-08-01 10:16:23', '2017-08-01 10:16:23', null, null);
INSERT INTO menuitem VALUES ('29', '0', '菜单信息', '', 'icon-list', null, '2017-08-01 10:16:45', '2017-08-01 10:16:45', '1', null);
INSERT INTO menuitem VALUES ('30', '29', '菜单管理', 'menuitem/menuitems', 'icon-double-angle-right', null, '2017-08-01 10:17:04', '2017-08-01 10:17:04', null, null);
INSERT INTO menuitem VALUES ('31', '0', '分类管理', '', 'icon-th', null, '2017-08-01 10:17:36', '2017-08-01 10:17:36', '1', null);
INSERT INTO menuitem VALUES ('32', '32', '出版社管理', '', 'icon-double-angle-right', null, '2017-08-01 10:18:00', '2017-08-01 10:18:00', '', null);
INSERT INTO menuitem VALUES ('33', '31', '参数管理', 'codeCatalog/codeCatalogs', 'icon-double-angle-right', null, '2017-08-01 10:18:28', '2017-08-01 10:18:28', null, null);
INSERT INTO menuitem VALUES ('34', '31', '出版社管理', '', 'icon-double-angle-right', null, '2017-08-01 10:19:23', '2017-08-01 10:19:23', null, null);

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` int(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `extend1` varchar(200) DEFAULT NULL,
  `extend2` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_role_permission` (`role_id`,`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO role_permission VALUES ('2', '2', '3', null, null, null, null);
INSERT INTO role_permission VALUES ('3', '1', '5', null, null, null, null);
INSERT INTO role_permission VALUES ('5', '1', '2', null, null, null, null);
INSERT INTO role_permission VALUES ('7', '1', '4', '2017-07-29 17:55:02', '2017-07-29 17:55:02', null, null);
INSERT INTO role_permission VALUES ('9', '1', '7', '2017-07-29 17:55:09', '2017-07-29 17:55:09', null, null);
INSERT INTO role_permission VALUES ('10', '1', '3', '2017-07-29 17:55:44', '2017-07-29 17:55:44', null, null);
INSERT INTO role_permission VALUES ('11', '0', '1', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('12', '0', '2', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('13', '0', '3', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('14', '0', '4', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('15', '0', '5', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('16', '0', '7', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('17', '0', '8', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('18', '0', '9', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('19', '0', '10', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('20', '0', '11', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('21', '0', '12', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('22', '0', '13', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('23', '0', '14', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('24', '0', '15', '2017-07-30 15:05:21', '2017-07-30 15:05:21', null, null);
INSERT INTO role_permission VALUES ('25', '0', '16', '2017-08-01 16:17:45', '2017-08-01 16:17:45', null, null);
INSERT INTO role_permission VALUES ('26', '0', '17', '2017-08-01 16:17:45', '2017-08-01 16:17:45', null, null);
INSERT INTO role_permission VALUES ('27', '0', '18', '2017-08-01 16:17:45', '2017-08-01 16:17:45', null, null);
INSERT INTO role_permission VALUES ('28', '0', '19', '2017-08-01 16:26:58', '2017-08-01 16:26:58', null, null);

-- ----------------------------
-- Table structure for `specialty_info`
-- ----------------------------
DROP TABLE IF EXISTS `specialty_info`;
CREATE TABLE `specialty_info` (
  `specialty_id` varchar(32) NOT NULL COMMENT '专业代码',
  `college_id` varchar(32) DEFAULT NULL COMMENT '所属学院号',
  `specialty_name` varchar(150) DEFAULT NULL COMMENT '专业名称',
  `schsys` varchar(600) DEFAULT NULL COMMENT '学制',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `extend1` varchar(150) DEFAULT NULL,
  `extend2` varchar(150) DEFAULT NULL,
  `extend3` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`specialty_id`),
  UNIQUE KEY `idx_specialty_name` (`specialty_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specialty_info
-- ----------------------------
INSERT INTO specialty_info VALUES ('ab52e752b95642599d6c72c679951804', '95e80bce70b1469090455bfc5b3822ec', '国外旅游', '4年', '2017-07-26 11:17:09', '2017-07-26 11:17:09', null, null, null);
INSERT INTO specialty_info VALUES ('d43bb0f5131e404f91273d14d461d718', '95e80bce70b1469090455bfc5b3822ec', '国内旅游', '4年', null, null, null, null, null);
INSERT INTO specialty_info VALUES ('s1', 'c1', '临床管理', '6年', '2017-07-21 16:39:30', '2017-07-21 16:39:33', null, null, null);
INSERT INTO specialty_info VALUES ('s2', 'c1', '内科专业', '6年', '2017-07-21 16:39:59', '2017-07-21 16:40:04', null, null, null);
INSERT INTO specialty_info VALUES ('s3', 'c2', '软件工程', '4年', '2017-07-21 16:40:37', '2017-07-21 16:40:42', null, null, null);
INSERT INTO specialty_info VALUES ('s4', 'c2', '通信工程', '4年', '2017-07-21 16:41:04', '2017-07-21 16:41:06', null, null, null);

-- ----------------------------
-- Table structure for `student_info`
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='学生基本信息表';

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO student_info VALUES ('6', '789', '454', '1', '17789565878', null, '4', 'cc1', 's1', 'c1', '2017-07-25 00:00:00', null, '12.00', null, null, null, null, null, null);
INSERT INTO student_info VALUES ('7', '4569', '7895', '1', '15689784589', null, '4', 'cc1', 's1', 'c1', '2017-07-23 00:00:00', null, '56.00', '1', '2017-07-23 14:27:27', '2017-07-23 14:27:27', null, null, null);
INSERT INTO student_info VALUES ('8', '787854', '二维吗', '2', '15896385478', null, '4', 'cc5', 's3', 'c2', '2017-07-24 00:00:00', null, '56.00', null, null, null, null, null, null);
INSERT INTO student_info VALUES ('9', '35345', '史蒂芬孙', '1', '14789525587', null, '4', 'cc1', 's1', 'c1', '2017-07-23 00:00:00', null, '345.00', '1', '2017-07-23 15:12:41', '2017-07-23 15:12:41', null, null, null);

-- ----------------------------
-- Table structure for `teacher_info`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_no` varchar(18) NOT NULL COMMENT '职工号',
  `teacher_name` varchar(100) DEFAULT NULL COMMENT '教职工姓名',
  `teacher_sex` char(2) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL COMMENT '教职工手机号',
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_info
-- ----------------------------
INSERT INTO teacher_info VALUES ('2', '45', '王老师', '1', '15878966547', null, 'c1', '324', '2017-07-23 17:29:39', '2017-07-23 17:29:39', '1', null, null, null);
INSERT INTO teacher_info VALUES ('3', '56757', '刘老师', '2', '15896547852', null, 'c2', '243', '2017-07-23 17:43:54', '2017-07-23 17:43:54', '1', null, null, null);

-- ----------------------------
-- Table structure for `tmms_syslog`
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
-- Table structure for `tmms_user`
-- ----------------------------
DROP TABLE IF EXISTS `tmms_user`;
CREATE TABLE `tmms_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `state` tinyint(4) DEFAULT '1' COMMENT '表示user状态，1表示正常，0表示无效',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `inx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmms_user
-- ----------------------------
INSERT INTO tmms_user VALUES ('1', 'jack', '123456', '1', '1', null, null);
INSERT INTO tmms_user VALUES ('2', 'mike', '123456', '1', null, null, null);
INSERT INTO tmms_user VALUES ('4', 'tier', '445', '2', '1', null, null);
INSERT INTO tmms_user VALUES ('7', '4ggh', '123456', '3', '1', '2017-07-28 15:26:03', '2017-07-28 15:26:03');
INSERT INTO tmms_user VALUES ('8', 'xiaowang', '123456', '1', '1', null, null);
INSERT INTO tmms_user VALUES ('9', 'admin', '123456', '0', '1', '2017-07-31 10:21:03', '2017-07-31 10:21:05');

-- ----------------------------
-- Table structure for `user_permission`
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_permission
-- ----------------------------
INSERT INTO user_permission VALUES ('1', 'student:add', '学生信息添加', null, null, null, null);
INSERT INTO user_permission VALUES ('2', 'student:edit', '学生信息修改', null, null, null, null);
INSERT INTO user_permission VALUES ('3', 'student:addbatch', '学生信息导入', null, null, null, null);
INSERT INTO user_permission VALUES ('4', 'student:editexport', '学生信息导出', null, null, null, null);
INSERT INTO user_permission VALUES ('5', 'student:view', '学生信息列表查看', null, null, null, null);
INSERT INTO user_permission VALUES ('7', 'student:del', '学生信息删除', null, null, null, null);
INSERT INTO user_permission VALUES ('8', 'student:dels', '学生信息批量删除', null, null, null, null);
INSERT INTO user_permission VALUES ('9', 'teacher:add', '教师信息添加', null, null, null, null);
INSERT INTO user_permission VALUES ('10', 'teacher:edit', '教师信息修改', null, null, null, null);
INSERT INTO user_permission VALUES ('11', 'teacher:addbatch', '教师信息导入', null, null, null, null);
INSERT INTO user_permission VALUES ('12', 'teacher:export', '教师信息导出', '2017-07-30 14:53:28', '2017-07-30 14:53:28', null, null);
INSERT INTO user_permission VALUES ('13', 'teacher:view', '教师信息列表查看', '2017-07-30 14:54:24', '2017-07-30 14:54:24', null, null);
INSERT INTO user_permission VALUES ('14', 'teacher:del', '教师信息删除', null, null, null, null);
INSERT INTO user_permission VALUES ('15', 'teacher:dels', '教师信息批量删除', '2017-07-30 14:55:40', '2017-07-30 14:55:40', null, null);
INSERT INTO user_permission VALUES ('16', 'book:add', '书籍信息添加', '2017-08-01 16:16:53', '2017-08-01 16:16:53', null, null);
INSERT INTO user_permission VALUES ('17', 'book:edit', '书籍修改', '2017-08-01 16:17:12', '2017-08-01 16:17:12', null, null);
INSERT INTO user_permission VALUES ('18', 'book:addbatch', '书籍信息导入', '2017-08-01 16:17:33', '2017-08-01 16:17:33', null, null);
INSERT INTO user_permission VALUES ('19', 'book:view', '书籍信息列表查看', '2017-08-01 16:26:51', '2017-08-01 16:26:51', null, null);

-- ----------------------------
-- Table structure for `user_role`
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO user_role VALUES ('0', 'admin', '超级管理员', '2017-07-30 14:38:12', '2017-07-30 14:38:12', '2,7,13,14,15,16,17,19,20,21,22,23,24,25,26,27,28,29,30,31,33,34', null, '1');
INSERT INTO user_role VALUES ('1', '学生', '普通学生，可以自助选书', null, null, '2,7,19,20,27,28', null, '1');
INSERT INTO user_role VALUES ('2', '中心管理员', '后台管理员', '2017-05-30 17:05:12', '2017-05-30 17:05:12', '2,7,13,14,15,16,17,19,20,21,22,23,24,25,26,27,28,29,30,31,33,34', null, '1');
INSERT INTO user_role VALUES ('3', '院系管理员', '院系管理员', '2017-05-30 17:05:12', '2017-05-30 17:05:12', null, null, '1');
INSERT INTO user_role VALUES ('4', '教师', '教师用户，可以添加书籍', null, null, null, null, '1');
