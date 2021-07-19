/*
 Navicat Premium Data Transfer

 Source Server         : ali_yun_my_mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 47.106.67.138:3333
 Source Schema         : dlhjw_website

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 18/07/2021 09:31:10
*/

-- 判断数据库存在，存在再删除
DROP DATABASE IF EXISTS dlhjw_website;
	
-- 创建数据库，判断不存在，再创建
CREATE DATABASE IF NOT EXISTS dlhjw_website;

-- 使用数据库
USE dlhjw_website;

CREATE TABLE `user` (
	`uid` BIGINT ( 20 ) PRIMARY KEY auto_increment,-- 用户ID(PK AI)
	`name` VARCHAR ( 16 ) NOT NULL,-- 姓名(NN)
	`birth` VARCHAR ( 64 ),-- 出生日期
	`political` VARCHAR ( 16 ),-- 政治面貌
	`city` VARCHAR ( 32 ),-- 地区城市
	`address` VARCHAR ( 256 ),-- 详细地址
	`sex` INT,-- 性别
        `is_message` INT,-- 是否开启留言
	`info`  VARCHAR ( 1024 ),-- 个人简介
	`add_time` datetime DEFAULT CURRENT_TIMESTAMP,-- 添加日期
	`last_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 修改日期
);

-- 联系方式表
CREATE TABLE `contact` (
	`cid` BIGINT ( 20 ) PRIMARY KEY auto_increment,-- 联系方式ID(PK AI)
	`uid` BIGINT ( 20 ),-- 用户ID(FK)
	FOREIGN KEY ( uid ) REFERENCES `user` ( uid ),
        `email` VARCHAR ( 64 ),-- 邮箱
	`phone` VARCHAR ( 32 ),-- 电话
	`wechat` VARCHAR ( 64 ),-- 微信
	`wechat_official` VARCHAR ( 64 ),-- 微信公众号
	`qq` VARCHAR ( 32 ),-- QQ
	`weibo` VARCHAR ( 256 ),-- 微博地址
	`github` VARCHAR ( 256 ),-- github地址
	`blog` VARCHAR ( 256 ),-- 博客地址
        `mask` VARCHAR ( 1024 ),-- 头像地址
	`add_time` datetime DEFAULT CURRENT_TIMESTAMP,-- 添加日期
	`last_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 修改日期
);

-- 教育经历表
CREATE TABLE `education` (
	`eid` BIGINT ( 20 ) PRIMARY KEY auto_increment,-- 教育ID(PK AI)
	`uid` BIGINT ( 20 ),-- 用户ID(FK)
	FOREIGN KEY ( uid ) REFERENCES `user` ( uid ),
	`school` VARCHAR ( 64 ),-- 学校
	`study` VARCHAR ( 64 ),-- 专业名称
	`start` VARCHAR ( 64 ),-- 开始时间
	`end` VARCHAR ( 64 ),-- 结束时间
	`description` VARCHAR ( 1024 ),-- 说明
	`add_time` datetime DEFAULT CURRENT_TIMESTAMP,-- 添加日期
	`last_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 修改日期
);

-- 工作经历表
CREATE TABLE `work` (
	`wid` BIGINT ( 20 ) PRIMARY KEY auto_increment,-- 工作ID(PK AI)
	`uid` BIGINT ( 20 ),-- 用户ID(FK)
	FOREIGN KEY ( uid ) REFERENCES `user` ( uid ),
	`is_school`  INT,-- 是否在校
	`company` VARCHAR ( 64 ),-- 公司名称
	`job` VARCHAR ( 64 ),-- 职位
	`start` VARCHAR ( 64 ),-- 开始时间
	`end` VARCHAR ( 64 ),-- 结束时间
	`description` VARCHAR ( 1024 ),-- 说明
	`add_time` datetime DEFAULT CURRENT_TIMESTAMP,-- 添加日期
	`last_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 修改日期
);

-- 关键词表
CREATE TABLE `keywords` (
	`kid` BIGINT ( 20 ) PRIMARY KEY auto_increment,-- 性格ID(PK AI)
	`uid` BIGINT ( 20 ),-- 用户ID(FK)
	FOREIGN KEY ( uid ) REFERENCES `user` ( uid ),
	`disposition` VARCHAR ( 1024 ),-- 性格关键词
        `ability` VARCHAR ( 1024 ),-- 能力关键词
	`add_time` datetime DEFAULT CURRENT_TIMESTAMP,-- 添加日期
	`last_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 修改日期
);

-- 特长表
CREATE TABLE `specialty` (
	`sid` BIGINT ( 20 ) PRIMARY KEY auto_increment,-- 特长ID(PK AI)
	`uid` BIGINT ( 20 ),-- 用户ID(FK)
	FOREIGN KEY ( uid ) REFERENCES `user` ( uid ),
	`name` VARCHAR ( 64 ),-- 特长名称
	`description` VARCHAR ( 1024 ),-- 特长描述
	`add_time` datetime DEFAULT CURRENT_TIMESTAMP,-- 添加日期
	`last_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 修改日	
);

-- 荣誉证书表
CREATE TABLE `honour` (
	`hid` BIGINT ( 20 ) PRIMARY KEY auto_increment,-- 荣誉ID(PK AI)
	`uid` BIGINT ( 20 ),-- 用户ID(FK)
	FOREIGN KEY ( uid ) REFERENCES `user` ( uid ),
	`category`  INT,-- 荣誉类别
	`name` VARCHAR ( 64 ),-- 荣誉名称
	`description` VARCHAR ( 1024 ),-- 荣誉描述
    `file` VARCHAR ( 1024 ),-- 荣誉证书文件
	`add_time` datetime DEFAULT CURRENT_TIMESTAMP,-- 添加日期
	`last_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 修改日	
);

-- 留言表
CREATE TABLE `message` (
	`mid` BIGINT ( 20 ) PRIMARY KEY auto_increment,-- 留言ID(PK AI)
	`uid` BIGINT ( 20 ),-- 用户ID(FK)
	FOREIGN KEY ( uid ) REFERENCES `user` ( uid ),
	`name` VARCHAR ( 16 ),-- 留言者
	`message` VARCHAR ( 1024 ),-- 留言
	`add_time` datetime DEFAULT CURRENT_TIMESTAMP,-- 添加日期
	`last_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 修改日
);
