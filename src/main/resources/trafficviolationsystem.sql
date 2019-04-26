/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : trafficviolationsystem

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 27/04/2019 05:38:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dirve_no` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '驾驶执照号',
  `model` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '型号',
  `number_plate` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '车牌号',
  `manufacturer` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '制造厂',
  `production` datetime(0) NOT NULL COMMENT '生产日期',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) DEFAULT NULL,
  `flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES (1, '123456789012345678', '新型飞船32', '木A-66685', '木星人类科技', '2023-06-08 00:00:00', '2019-04-27 05:20:27', NULL, '0');
INSERT INTO `car` VALUES (2, '123456789012345678', '跃迁飞船08', '木C-00011', '木星人类科技', '2030-01-01 00:00:00', '2019-04-27 05:24:58', NULL, '0');
INSERT INTO `car` VALUES (3, '123456789112345679', '传送车', '歌B-08530', '歌者文明科技', '2033-06-17 00:00:00', '2019-04-27 05:27:24', NULL, '0');
INSERT INTO `car` VALUES (4, '123456789112345678', '标准越野车', '地A-12345', '后人类文明科技', '2036-06-04 00:00:00', '2019-04-27 05:30:19', NULL, '0');
INSERT INTO `car` VALUES (5, '123456789112345678', '智子飞行器', '地C-88888', '三体科技', '2021-01-04 00:00:00', '2019-04-27 05:32:48', NULL, '0');

-- ----------------------------
-- Table structure for dirver
-- ----------------------------
DROP TABLE IF EXISTS `dirver`;
CREATE TABLE `dirver`  (
  `num` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '驾驶执照号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '姓名',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '地址',
  `zip` char(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '邮编',
  `phone` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '电话',
  `create_time` datetime(0) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '标记',
  PRIMARY KEY (`num`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dirver
-- ----------------------------
INSERT INTO `dirver` VALUES ('123456789012345678', '刘培强', '木星木卫三星际社区一期', '750002', '+8818522168136', '2019-04-27 05:15:47', NULL, '0');
INSERT INTO `dirver` VALUES ('123456789112345678', '罗辑', '地球底下城新区', '850002', '+661326547898', '2019-04-27 05:16:52', NULL, '0');
INSERT INTO `dirver` VALUES ('123456789112345679', '程心', '歌者社区1-3-5-4444-23', '895202', '32154+5118444', '2019-04-27 05:18:54', NULL, '0');

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket`  (
  `id` char(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '违章编号',
  `car_id` int(11) NOT NULL COMMENT '违章车辆id',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '违章地点',
  `record` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '无' COMMENT '违章记载',
  `violation_date` datetime(0) NOT NULL COMMENT '违章日期',
  `notice_time` datetime(0) NOT NULL COMMENT '通知时间',
  `punishment_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '处罚方式',
  `police_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '警察签字',
  `police_no` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '警察编号',
  `party_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '处罚人签字',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES ('CP8E365', 4, '北京遗址', '独自外出', '2032-02-28 00:00:00', '2019-04-27 05:31:45', '{\"1\":1,\"2\":0,\"3\":0}', 'SANS', '100026', '罗辑', '2019-04-27 05:31:45', NULL, '0');
INSERT INTO `ticket` VALUES ('FY254Q7', 5, '大底谷纪念碑', '危险驾驶', '2032-02-28 00:00:00', '2019-04-27 05:34:28', '{\"1\":0,\"2\":1,\"3\":1}', 'SANS', '800026', '罗辑', '2019-04-27 05:34:28', NULL, '0');
INSERT INTO `ticket` VALUES ('JB87632', 2, '木卫三', '超速', '2032-02-29 00:00:00', '2019-04-27 05:26:04', '{\"1\":1,\"2\":1,\"3\":1}', 'SANS', '100026', '刘培茄', '2019-04-27 05:26:04', NULL, '0');
INSERT INTO `ticket` VALUES ('Jc87632', 1, '木卫二', '违反星际交通法则', '2024-06-07 00:00:00', '2019-04-27 05:23:19', '{\"1\":1,\"2\":1,\"3\":0}', 'SANS', '100026', '刘培茄', '2019-04-27 05:23:19', NULL, '0');
INSERT INTO `ticket` VALUES ('KK8G421', 3, '歌者星球', '独自外出', '2032-02-29 00:00:00', '2019-04-27 05:29:02', '{\"1\":1,\"2\":0,\"3\":0}', 'SANS', '100026', '刘培茄', '2019-04-27 05:29:02', NULL, '0');

SET FOREIGN_KEY_CHECKS = 1;
