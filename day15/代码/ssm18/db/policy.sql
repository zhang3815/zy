/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-25 07:17:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for policy
-- ----------------------------
DROP TABLE IF EXISTS `policy`;
CREATE TABLE `policy` (
  `policyId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '策略',
  `policyName` varchar(30) DEFAULT NULL COMMENT '操作人',
  `createTime` datetime DEFAULT NULL COMMENT '时间',
  `content` varchar(200) DEFAULT NULL COMMENT '详细',
  `policyType` tinyint(4) DEFAULT NULL COMMENT '策略类型',
  `policyDescription` varchar(200) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`policyId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='策略表';
