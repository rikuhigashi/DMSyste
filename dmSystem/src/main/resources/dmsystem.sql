/*
 Navicat Premium Dump SQL

 Source Server         : higashi
 Source Server Type    : MySQL
 Source Server Version : 80037 (8.0.37)
 Source Host           : localhost:3306
 Source Schema         : dmsystem

 Target Server Type    : MySQL
 Target Server Version : 80037 (8.0.37)
 File Encoding         : 65001

 Date: 15/11/2024 01:02:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `useraccount` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账号',
  `userpassword` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '未命名用户' COMMENT '用户名字',
  `identity` int NOT NULL DEFAULT 1 COMMENT '0 管理员  1 普通用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '这是用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '管理员', 0);
INSERT INTO `user` VALUES (4, 'test', '123456', '\"未命名用户\"', 1);

-- ----------------------------
-- Table structure for warranty
-- ----------------------------
DROP TABLE IF EXISTS `warranty`;
CREATE TABLE `warranty`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '保修单号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '维修物品名',
  `image` blob NULL COMMENT '故障图片',
  `starttime` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `endtime` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `studentnumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学生学号',
  `studentname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `worknumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '45215' COMMENT '工作人员工号',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '保修标题',
  `workname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '工作人员名字',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warranty
-- ----------------------------
INSERT INTO `warranty` VALUES (1, '内部灯', '', '2024-11-14 14:01:40', '2024-11-29 14:05:11', '20205562', '小明', '45215', '这是一个测试', '张三', '这是一个备注');
INSERT INTO `warranty` VALUES (2, '风扇', 0x74657374, '2024-11-14 14:01:40', '2024-11-14 14:01:40', '20205561', '小明', '45215', '这是测试2', '王五', '这是一个备注');
INSERT INTO `warranty` VALUES (3, '大门', 0x74657374, '2024-11-14 14:01:40', '2024-11-14 14:01:40', '20205561', '小明', '45218', '这是测试2', '张三', '这是一个备注');
INSERT INTO `warranty` VALUES (4, '厕所门', 0x74657374, '2024-11-14 14:01:40', '2024-11-14 14:01:40', '20205563', '小红', '452153', '这是测试2', '张三', '这是一个备注');
INSERT INTO `warranty` VALUES (5, '灯', 0x74657374, '2024-11-14 14:01:40', '2024-11-14 14:01:40', '20205621', '小红', '4512168', '这是测试2', '王五', '这是一个备注');
INSERT INTO `warranty` VALUES (6, '厕所灯', 0x74657374, '2024-11-14 14:01:40', '2024-11-14 14:01:40', '20205561', '小红', '45215', '这是测试2', '张三', '这是一个备注');
INSERT INTO `warranty` VALUES (7, '内部灯3', 0x74657374, '2024-11-14 17:01:40', '2024-11-29 19:05:11', '20205587', '小亮', '451', '这是一个插入测试', '王五', '这是一个备注');
INSERT INTO `warranty` VALUES (8, '内部灯4', NULL, '2024-11-14 17:01:40', '2024-11-29 19:05:11', '20205587', '小亮', '451', '这是一个插入测试', '王五', '这是一个备注');
INSERT INTO `warranty` VALUES (9, '内部灯4', NULL, '2024-11-14 17:01:40', '2024-11-29 19:05:11', '20205587', '小亮', '451', '这是一个插入测试', '王五', '这是一个备注');

SET FOREIGN_KEY_CHECKS = 1;
