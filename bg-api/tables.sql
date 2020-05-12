/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云
Source Server Version : 50718
Source Host           : cdb-8vlvqayx.gz.tencentcdb.com:10094
Source Database       : bgconsole

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-06-01 21:39:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for banners
-- ----------------------------
DROP TABLE IF EXISTS `banners`;
CREATE TABLE `banners` (
  `id` varchar(36) DEFAULT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` int(2) DEFAULT NULL COMMENT '类型',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int(11) DEFAULT NULL COMMENT '状态:1 启用, 0 禁用',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `url` text COMMENT '链接url地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='滚动条';

-- ----------------------------
-- Table structure for developers
-- ----------------------------
DROP TABLE IF EXISTS `developers`;
CREATE TABLE `developers` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `type` int(11) DEFAULT '2' COMMENT '类型: 1. 个人, 2. 公司',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发者';

-- ----------------------------
-- Table structure for featured_content
-- ----------------------------
DROP TABLE IF EXISTS `featured_content`;
CREATE TABLE `featured_content` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` int(2) DEFAULT NULL COMMENT '1, 推荐视频, 2, 推荐音乐, 3 推荐有声内容, 4, 推荐技能',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='推荐内容, 包括视频, 音频, 音乐, 技能,';

-- ----------------------------
-- Table structure for migu_voice
-- ----------------------------
DROP TABLE IF EXISTS `migu_voice`;
CREATE TABLE `migu_voice` (
  `id` varchar(32) DEFAULT NULL COMMENT 'id',
  `category_id` varchar(32) DEFAULT NULL COMMENT '类型id',
  `category_name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `text_author` varchar(32) DEFAULT NULL COMMENT '文本作者',
  `voice_author` varchar(32) DEFAULT NULL COMMENT '声音作者',
  `cover_image_url` varchar(255) DEFAULT NULL COMMENT '封面图片url地址',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `sid` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '咪咕该条音频的id',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=5473 DEFAULT CHARSET=utf8 COMMENT='咪咕推荐有声资源';

-- ----------------------------
-- Table structure for resource_address
-- ----------------------------
DROP TABLE IF EXISTS `resource_address`;
CREATE TABLE `resource_address` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `target_id` varchar(255) DEFAULT NULL COMMENT '所属对象id',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源地址(目前仅限图片)';

-- ----------------------------
-- Table structure for skill_examples
-- ----------------------------
DROP TABLE IF EXISTS `skill_examples`;
CREATE TABLE `skill_examples` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `skill_id` varchar(36) DEFAULT NULL COMMENT '技能id',
  `example` text COMMENT '语料',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `if_multi` int(1) DEFAULT '0' COMMENT '是否为多轮语料, 1: 是, 0, 不是',
  PRIMARY KEY (`id`),
  KEY `skill_example` (`skill_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='语料';

-- ----------------------------
-- Table structure for skills
-- ----------------------------
DROP TABLE IF EXISTS `skills`;
CREATE TABLE `skills` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `developer_id` varchar(36) DEFAULT NULL COMMENT '开发者id',
  `description` text COMMENT '描述',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `rate` int(1) DEFAULT '3' COMMENT '评分',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `type` int(2) DEFAULT '0' COMMENT '1: 影音阅读\r\n2: 生活服务\r\n3: 效率工具\r\n4: 教育百科\r\n5: 商业金融\r\n6: 游戏娱乐\r\n7: 健康健身',
  `times_searched` bigint(20) DEFAULT NULL COMMENT '搜索次数',
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技能';
