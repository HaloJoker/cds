# cds
项目架构
springboot、mybatis、swagger 干净的项目架构

sql脚本

/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : 39.106.27.238:3306
 Source Schema         : ycs

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : 65001

 Date: 15/07/2019 12:17:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for TEST_USER
-- ----------------------------
DROP TABLE IF EXISTS `TEST_USER`;
CREATE TABLE `TEST_USER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `is_del` int(1) unsigned zerofill DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
