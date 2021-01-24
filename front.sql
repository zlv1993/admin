/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : front

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 24/01/2021 23:17:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sp_permission
-- ----------------------------
DROP TABLE IF EXISTS `sp_permission`;
CREATE TABLE `sp_permission` (
  `id` int NOT NULL COMMENT ' 权限id',
  `pid` int DEFAULT NULL COMMENT '父级id',
  `url` varchar(255) DEFAULT NULL COMMENT '路径',
  `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '前端页面重定向地址',
  `component` varchar(255) DEFAULT NULL COMMENT '前端页面组建地址',
  `name` varchar(255) DEFAULT NULL COMMENT ' 页面名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '前端页面展示图标',
  `type` tinyint DEFAULT NULL COMMENT '路径类别：1、目录，2、目录隐藏，3、',
  `isShow` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sp_permission
-- ----------------------------
BEGIN;
INSERT INTO `sp_permission` VALUES (1, 0, '/permiss', '/permiss/user', 'Layout', '权限模块', NULL, 1, '1', NULL, NULL);
INSERT INTO `sp_permission` VALUES (2, 1, '/permiss/user', '', '@/pages/permission/User', '用户管理', NULL, 1, '1', NULL, NULL);
INSERT INTO `sp_permission` VALUES (3, 1, '/permiss/role', '', '@/pages/permission/Role', '角色管理', NULL, 1, '1', NULL, NULL);
INSERT INTO `sp_permission` VALUES (4, 1, '/permiss/url', '', '@/pages/permission/Url', '权限管理', NULL, 1, '1', NULL, NULL);
INSERT INTO `sp_permission` VALUES (5, 0, '/', '/dashboard', 'Layout', '首页', NULL, 1, '1', NULL, NULL);
INSERT INTO `sp_permission` VALUES (6, 5, '/dashboard', '', '@/pages/Home', '首页 管理', NULL, 1, '0', NULL, NULL);
INSERT INTO `sp_permission` VALUES (7, 3, '/add', '/add', 'add', '新增', NULL, 3, '0', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sp_role
-- ----------------------------
DROP TABLE IF EXISTS `sp_role`;
CREATE TABLE `sp_role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色英文名称',
  `name` varchar(255) DEFAULT NULL COMMENT '角色中文名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime DEFAULT NULL COMMENT ' 角色创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '角色更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sp_role
-- ----------------------------
BEGIN;
INSERT INTO `sp_role` VALUES (1, 'ROLE_ROOT', '超级管理员', NULL, NULL, NULL);
INSERT INTO `sp_role` VALUES (2, 'ROLE_ADMIN', '后台管理员', NULL, NULL, NULL);
INSERT INTO `sp_role` VALUES (3, 'ROLE_USER', ' 普通用户', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sp_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sp_role_permission`;
CREATE TABLE `sp_role_permission` (
  `role_id` int NOT NULL COMMENT '角色id\n',
  `permission_id` int NOT NULL COMMENT ' 权限id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sp_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `sp_role_permission` VALUES (1, 1);
INSERT INTO `sp_role_permission` VALUES (1, 2);
INSERT INTO `sp_role_permission` VALUES (1, 3);
INSERT INTO `sp_role_permission` VALUES (1, 4);
INSERT INTO `sp_role_permission` VALUES (1, 5);
INSERT INTO `sp_role_permission` VALUES (1, 6);
INSERT INTO `sp_role_permission` VALUES (1, 7);
COMMIT;

-- ----------------------------
-- Table structure for sp_user
-- ----------------------------
DROP TABLE IF EXISTS `sp_user`;
CREATE TABLE `sp_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `email` varchar(50) DEFAULT NULL COMMENT '用户联系email\n',
  `phone` char(11) DEFAULT NULL COMMENT '用户联系电话',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `avator` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `address` varchar(255) DEFAULT NULL COMMENT '用户联系地址',
  `create_time` datetime DEFAULT NULL COMMENT '用户创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '用户更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sp_user
-- ----------------------------
BEGIN;
INSERT INTO `sp_user` VALUES (1, '张三', '$2a$10$muFmhACTmE1aRXDVDS18ruzVR9qzL9oS4jTjsD7A6u4figntFFI0K', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sp_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sp_user_role`;
CREATE TABLE `sp_user_role` (
  `user_id` int NOT NULL COMMENT '用户ID',
  `role_id` int NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sp_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sp_user_role` VALUES (1, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
