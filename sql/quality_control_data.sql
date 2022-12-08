/*
 Navicat Premium Data Transfer

 Source Server         : new_server
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : 47.99.65.198:3306
 Source Schema         : quality_control_data

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 07/12/2022 21:46:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for analysiscount
-- ----------------------------
DROP TABLE IF EXISTS `analysiscount`;
CREATE TABLE `analysiscount`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `count` int(11) NULL DEFAULT NULL COMMENT '总数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of analysiscount
-- ----------------------------

-- ----------------------------
-- Table structure for change_data
-- ----------------------------
DROP TABLE IF EXISTS `change_data`;
CREATE TABLE `change_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of change_data
-- ----------------------------
INSERT INTO `change_data` VALUES (1, '设计阶段', 0);
INSERT INTO `change_data` VALUES (2, '生产阶段', 0);
INSERT INTO `change_data` VALUES (3, '维修阶段', 0);
INSERT INTO `change_data` VALUES (4, '使用阶段', 0);
INSERT INTO `change_data` VALUES (5, '装备型号升级', 1);
INSERT INTO `change_data` VALUES (6, '产品改型', 1);
INSERT INTO `change_data` VALUES (7, '装备能力提升', 1);
INSERT INTO `change_data` VALUES (8, '生产班组发生变化', 2);
INSERT INTO `change_data` VALUES (9, '生产人员发生变化', 2);
INSERT INTO `change_data` VALUES (10, '生产设备发生变化', 2);
INSERT INTO `change_data` VALUES (11, '测量设备发生变化', 2);
INSERT INTO `change_data` VALUES (12, '供应链发生变化', 2);
INSERT INTO `change_data` VALUES (13, '生产工艺发生变化', 2);
INSERT INTO `change_data` VALUES (14, '维修班组发生变化', 3);
INSERT INTO `change_data` VALUES (15, '维修人员发生变化', 3);
INSERT INTO `change_data` VALUES (16, '维修设备发生变化', 3);
INSERT INTO `change_data` VALUES (17, '维修工艺发生变化', 3);
INSERT INTO `change_data` VALUES (18, '使用强度发生变化', 4);
INSERT INTO `change_data` VALUES (19, '装备状态发生变化', 4);
INSERT INTO `change_data` VALUES (20, '使用环境发生变化', 4);

-- ----------------------------
-- Table structure for equipment_deployment_data_11
-- ----------------------------
DROP TABLE IF EXISTS `equipment_deployment_data_11`;
CREATE TABLE `equipment_deployment_data_11`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plane_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机型',
  `troops` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部队',
  `deployment_time` date NULL DEFAULT NULL COMMENT '部署时间',
  `deployment_quantity` int(11) NULL DEFAULT NULL COMMENT '部署数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment_deployment_data_11
-- ----------------------------
INSERT INTO `equipment_deployment_data_11` VALUES (32, '1', '2', '2020-07-09', 2);
INSERT INTO `equipment_deployment_data_11` VALUES (33, '1', '2', '2022-12-07', 22);
INSERT INTO `equipment_deployment_data_11` VALUES (34, '22A', '33', '2022-12-14', 323232);

-- ----------------------------
-- Table structure for equipment_design_data
-- ----------------------------
DROP TABLE IF EXISTS `equipment_design_data`;
CREATE TABLE `equipment_design_data`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `plane_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remodel_date` date NULL DEFAULT NULL,
  `remodel_measure` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `make_unit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `model_series` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment_design_data
-- ----------------------------
INSERT INTO `equipment_design_data` VALUES (1, '机型1A', '2016-03-01', '对液压系统布局进行更新', '洛克希德马丁', '机型1');
INSERT INTO `equipment_design_data` VALUES (2, '机型3B', '2015-02-01', NULL, '波音', '机型3');
INSERT INTO `equipment_design_data` VALUES (3, '机型2B', '2014-04-01', NULL, '雷神', '机型2');
INSERT INTO `equipment_design_data` VALUES (4, '机型1B', '2022-09-01', NULL, '洛克希德马丁', '机型1');
INSERT INTO `equipment_design_data` VALUES (5, '机型1C', '2017-02-01', NULL, '洛克希德马丁', '机型1');
INSERT INTO `equipment_design_data` VALUES (6, '机型1E', '2019-10-01', NULL, '洛克希德马丁', '机型1');
INSERT INTO `equipment_design_data` VALUES (7, '机型2C', '2017-05-01', NULL, '雷神', '机型2');
INSERT INTO `equipment_design_data` VALUES (8, '机型2D', '2018-02-01', NULL, '雷神', '机型2');
INSERT INTO `equipment_design_data` VALUES (9, '机型3C', '2017-08-01', NULL, '波音', '机型3');
INSERT INTO `equipment_design_data` VALUES (10, '机型3D', '2018-11-01', NULL, '波音', '机型3');
INSERT INTO `equipment_design_data` VALUES (11, '机型3E', '2020-06-01', NULL, '波音', '机型3');

-- ----------------------------
-- Table structure for equipment_manufacturing_data5
-- ----------------------------
DROP TABLE IF EXISTS `equipment_manufacturing_data5`;
CREATE TABLE `equipment_manufacturing_data5`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plane_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dev_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `production_upgrade_time` date NULL DEFAULT NULL,
  `dev_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dev_manufacture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `capability_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment_manufacturing_data5
-- ----------------------------
INSERT INTO `equipment_manufacturing_data5` VALUES (1, '机型1A', '201111701', '能力提升', '2021-12-07', '制造单位2', '01', '2.0');
INSERT INTO `equipment_manufacturing_data5` VALUES (2, '机型1B', '201111701', '能力提升', '2022-02-10', '制造单位3', '03', '2.0');
INSERT INTO `equipment_manufacturing_data5` VALUES (3, '机型2B', '201111702', '生产', '2021-11-02', '制造单位2', '02', '1.0');

-- ----------------------------
-- Table structure for equipment_use_data_12
-- ----------------------------
DROP TABLE IF EXISTS `equipment_use_data_12`;
CREATE TABLE `equipment_use_data_12`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NULL DEFAULT NULL COMMENT '年月',
  `plane_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机型',
  `troops` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部队',
  `flight_hours` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '飞行小时',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment_use_data_12
-- ----------------------------
INSERT INTO `equipment_use_data_12` VALUES (1, '2022-11-01', '机型1A', '部队1', '555');
INSERT INTO `equipment_use_data_12` VALUES (2, '2022-05-01', '机型2A', '部队2', '333');
INSERT INTO `equipment_use_data_12` VALUES (3, '2022-09-01', '机型3B', '部队3', '222');
INSERT INTO `equipment_use_data_12` VALUES (4, '2022-01-01', '机型1B', '部队1', '111');
INSERT INTO `equipment_use_data_12` VALUES (5, '2022-10-01', '机型1C', '部队2', '333');
INSERT INTO `equipment_use_data_12` VALUES (6, '2020-11-01', '机型2C', '部队3', '555');
INSERT INTO `equipment_use_data_12` VALUES (7, '2022-10-01', '机型1A', '部队1', '111');
INSERT INTO `equipment_use_data_12` VALUES (8, '2022-12-01', '机型1A', '部队1', '222');
INSERT INTO `equipment_use_data_12` VALUES (9, '2022-01-01', '机型1A', '部队1', '333');
INSERT INTO `equipment_use_data_12` VALUES (10, '2022-03-01', '机型1A', '部队1', '444');
INSERT INTO `equipment_use_data_12` VALUES (11, '2022-08-01', '机型1A', '部队1', '555');
INSERT INTO `equipment_use_data_12` VALUES (12, '2019-02-01', '机型2C', '部队3', '999');
INSERT INTO `equipment_use_data_12` VALUES (13, '2017-06-01', '机型2C', '部队3', '444');

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES (1, 'parts_repair_num_13', '', NULL, NULL, 'PartsRepairNum13', 'crud', 'com.ruoyi.project.system', 'system', '13', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 16:42:12', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (2, 'equipment_deployment_data_11', '', NULL, NULL, 'EquipmentDeploymentData11', 'crud', 'com.ruoyi.project.system', 'system', '11', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:02', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (3, 'equipment_design_data', '', NULL, NULL, 'EquipmentDesignData', 'crud', 'com.ruoyi.project.system', 'system', 'data', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:02', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (4, 'equipment_manufacturing_data5', '', NULL, NULL, 'EquipmentManufacturingData5', 'crud', 'com.ruoyi.project.system', 'system', 'data5', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:03', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (5, 'parts_make_num_9', '', NULL, NULL, 'PartsMakeNum9', 'crud', 'com.ruoyi.project.system', 'system', '9', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:04', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (6, 'product_design_3', '', NULL, NULL, 'ProductDesign3', 'crud', 'com.ruoyi.project.system', 'system', '3', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:06', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (7, 'product_modify_4', '', NULL, NULL, 'ProductModify4', 'crud', 'com.ruoyi.project.system', 'system', '4', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:07', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (8, 'product_modify_data_6', '对应文档中的表7 产品制造变更数据', NULL, NULL, 'ProductModifyData6', 'crud', 'com.ruoyi.project.system', 'system', '6', '对应文档中的7 产品制造变更数据', 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:08', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (9, 'quality_problem_1', '', NULL, NULL, 'QualityProblem1', 'crud', 'com.ruoyi.project.system', 'system', '1', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:09', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (10, 'repair_modify_data_10', '', NULL, NULL, 'RepairModifyData10', 'crud', 'com.ruoyi.project.system', 'system', '10', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:11', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (11, 'equipment_deployment_data_11', '', NULL, NULL, 'EquipmentDeploymentData11', 'crud', 'com.ruoyi.project.system', 'system', '11', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:16', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (12, 'equipment_design_data', '', NULL, NULL, 'EquipmentDesignData', 'crud', 'com.ruoyi.project.system', 'system', 'data', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:16', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (13, 'equipment_manufacturing_data5', '', NULL, NULL, 'EquipmentManufacturingData5', 'crud', 'com.ruoyi.project.system', 'system', 'data5', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:17', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (14, 'parts_make_num_9', '', NULL, NULL, 'PartsMakeNum9', 'crud', 'com.ruoyi.project.system', 'system', '9', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:18', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (15, 'product_design_3', '', NULL, NULL, 'ProductDesign3', 'crud', 'com.ruoyi.project.system', 'system', '3', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:20', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (16, 'product_modify_4', '', NULL, NULL, 'ProductModify4', 'crud', 'com.ruoyi.project.system', 'system', '4', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:21', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (17, 'product_modify_data_6', '对应文档中的表7 产品制造变更数据', NULL, NULL, 'ProductModifyData6', 'crud', 'com.ruoyi.project.system', 'system', '6', '对应文档中的7 产品制造变更数据', 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:22', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (18, 'quality_problem_1', '', NULL, NULL, 'QualityProblem1', 'crud', 'com.ruoyi.project.system', 'system', '1', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:23', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (19, 'repair_modify_data_10', '', NULL, NULL, 'RepairModifyData10', 'crud', 'com.ruoyi.project.system', 'system', '10', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-02 18:11:26', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (20, 'equipment_use_data_12', '', NULL, NULL, 'EquipmentUseData12', 'crud', 'com.ruoyi.project.system', 'system', '12', NULL, 'ruoyi', '0', '/', NULL, 'admin', '2022-12-04 14:25:13', '', NULL, NULL);

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`  (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 196 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES (1, '1', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 16:42:13', '', NULL);
INSERT INTO `gen_table_column` VALUES (2, '1', 'plane_type', NULL, 'varchar(255)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 16:42:13', '', NULL);
INSERT INTO `gen_table_column` VALUES (3, '1', 'parts_name', NULL, 'varchar(255)', 'String', 'partsName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2022-12-02 16:42:13', '', NULL);
INSERT INTO `gen_table_column` VALUES (4, '1', 'parts_model', NULL, 'varchar(255)', 'String', 'partsModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-12-02 16:42:13', '', NULL);
INSERT INTO `gen_table_column` VALUES (5, '1', 'parts_code', NULL, 'varchar(255)', 'String', 'partsCode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 16:42:13', '', NULL);
INSERT INTO `gen_table_column` VALUES (6, '1', 'parts_factory_time', NULL, 'date', 'Date', 'partsFactoryTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 6, 'admin', '2022-12-02 16:42:13', '', NULL);
INSERT INTO `gen_table_column` VALUES (7, '1', 'parts_manufacture', NULL, 'varchar(255)', 'String', 'partsManufacture', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-12-02 16:42:13', '', NULL);
INSERT INTO `gen_table_column` VALUES (8, '1', 'parts_repair_group', NULL, 'varchar(255)', 'String', 'partsRepairGroup', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-12-02 16:42:13', '', NULL);
INSERT INTO `gen_table_column` VALUES (9, '1', 'parts_repair_people', '产品维修班组', 'varchar(255)', 'String', 'partsRepairPeople', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-12-02 16:42:14', '', NULL);
INSERT INTO `gen_table_column` VALUES (10, '1', 'parts_repair_quipment', '产品维修人员', 'varchar(255)', 'String', 'partsRepairQuipment', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2022-12-02 16:42:14', '', NULL);
INSERT INTO `gen_table_column` VALUES (11, '1', 'parts_measuring_quipment', '产品加工设备', 'varchar(255)', 'String', 'partsMeasuringQuipment', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-12-02 16:42:14', '', NULL);
INSERT INTO `gen_table_column` VALUES (12, '1', 'raw_material_place', NULL, 'varchar(255)', 'String', 'rawMaterialPlace', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2022-12-02 16:42:14', '', NULL);
INSERT INTO `gen_table_column` VALUES (13, '1', 'spare_parts_place', NULL, 'varchar(255)', 'String', 'sparePartsPlace', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 13, 'admin', '2022-12-02 16:42:14', '', NULL);
INSERT INTO `gen_table_column` VALUES (14, '1', 'parts_make_workmanship', NULL, 'varchar(255)', 'String', 'partsMakeWorkmanship', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 14, 'admin', '2022-12-02 16:42:14', '', NULL);
INSERT INTO `gen_table_column` VALUES (15, '2', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:02', '', NULL);
INSERT INTO `gen_table_column` VALUES (16, '2', 'plane_type', '机型', 'varchar(255)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 18:11:02', '', NULL);
INSERT INTO `gen_table_column` VALUES (17, '2', 'troops', '部队', 'varchar(255)', 'String', 'troops', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-12-02 18:11:02', '', NULL);
INSERT INTO `gen_table_column` VALUES (18, '2', 'deployment_time', '部署时间', 'date', 'Date', 'deploymentTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 4, 'admin', '2022-12-02 18:11:02', '', NULL);
INSERT INTO `gen_table_column` VALUES (19, '2', 'deployment_quantity', '部署数量', 'int(11)', 'Long', 'deploymentQuantity', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 18:11:02', '', NULL);
INSERT INTO `gen_table_column` VALUES (20, '3', 'id', NULL, 'int(10)', 'Integer', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:02', '', NULL);
INSERT INTO `gen_table_column` VALUES (21, '3', 'plane_type', NULL, 'varchar(50)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 18:11:03', '', NULL);
INSERT INTO `gen_table_column` VALUES (22, '3', 'remodel_date', NULL, 'date', 'Date', 'remodelDate', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 3, 'admin', '2022-12-02 18:11:03', '', NULL);
INSERT INTO `gen_table_column` VALUES (23, '3', 'remodel_measure', NULL, 'varchar(255)', 'String', 'remodelMeasure', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-12-02 18:11:03', '', NULL);
INSERT INTO `gen_table_column` VALUES (24, '3', 'make_unit', NULL, 'varchar(100)', 'String', 'makeUnit', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 18:11:03', '', NULL);
INSERT INTO `gen_table_column` VALUES (25, '3', 'model_series', NULL, 'varchar(200)', 'String', 'modelSeries', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-12-02 18:11:03', '', NULL);
INSERT INTO `gen_table_column` VALUES (26, '4', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:03', '', NULL);
INSERT INTO `gen_table_column` VALUES (27, '4', 'plane_type', NULL, 'varchar(255)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 18:11:03', '', NULL);
INSERT INTO `gen_table_column` VALUES (28, '4', 'dev_code', NULL, 'varchar(255)', 'String', 'devCode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-12-02 18:11:03', '', NULL);
INSERT INTO `gen_table_column` VALUES (29, '4', 'type', NULL, 'varchar(255)', 'String', 'type', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 4, 'admin', '2022-12-02 18:11:04', '', NULL);
INSERT INTO `gen_table_column` VALUES (30, '4', 'production_upgrade_time', NULL, 'date', 'Date', 'productionUpgradeTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 5, 'admin', '2022-12-02 18:11:04', '', NULL);
INSERT INTO `gen_table_column` VALUES (31, '4', 'dev_unit', NULL, 'varchar(255)', 'String', 'devUnit', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-12-02 18:11:04', '', NULL);
INSERT INTO `gen_table_column` VALUES (32, '4', 'dev_manufacture', NULL, 'varchar(255)', 'String', 'devManufacture', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-12-02 18:11:04', '', NULL);
INSERT INTO `gen_table_column` VALUES (33, '4', 'capability_status', NULL, 'varchar(255)', 'String', 'capabilityStatus', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'radio', '', 8, 'admin', '2022-12-02 18:11:04', '', NULL);
INSERT INTO `gen_table_column` VALUES (34, '5', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:04', '', NULL);
INSERT INTO `gen_table_column` VALUES (35, '5', 'plane_type', NULL, 'varchar(255)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 18:11:04', '', NULL);
INSERT INTO `gen_table_column` VALUES (36, '5', 'parts_name', NULL, 'varchar(255)', 'String', 'partsName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2022-12-02 18:11:04', '', NULL);
INSERT INTO `gen_table_column` VALUES (37, '5', 'parts_model', NULL, 'varchar(255)', 'String', 'partsModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-12-02 18:11:05', '', NULL);
INSERT INTO `gen_table_column` VALUES (38, '5', 'parts_code', NULL, 'varchar(255)', 'String', 'partsCode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 18:11:05', '', NULL);
INSERT INTO `gen_table_column` VALUES (39, '5', 'parts_factory_time', NULL, 'date', 'Date', 'partsFactoryTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 6, 'admin', '2022-12-02 18:11:05', '', NULL);
INSERT INTO `gen_table_column` VALUES (40, '5', 'parts_manufacture', NULL, 'varchar(255)', 'String', 'partsManufacture', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-12-02 18:11:05', '', NULL);
INSERT INTO `gen_table_column` VALUES (41, '5', 'parts_make_group', NULL, 'varchar(255)', 'String', 'partsMakeGroup', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-12-02 18:11:05', '', NULL);
INSERT INTO `gen_table_column` VALUES (42, '5', 'parts_make_people', NULL, 'varchar(255)', 'String', 'partsMakePeople', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-12-02 18:11:05', '', NULL);
INSERT INTO `gen_table_column` VALUES (43, '5', 'parts_make_quipment', NULL, 'varchar(255)', 'String', 'partsMakeQuipment', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2022-12-02 18:11:05', '', NULL);
INSERT INTO `gen_table_column` VALUES (44, '5', 'parts_measuring_quipment', '测量设备', 'varchar(255)', 'String', 'partsMeasuringQuipment', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-12-02 18:11:05', '', NULL);
INSERT INTO `gen_table_column` VALUES (45, '5', 'raw_material_place', '原材料来源地', 'varchar(255)', 'String', 'rawMaterialPlace', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2022-12-02 18:11:05', '', NULL);
INSERT INTO `gen_table_column` VALUES (46, '5', 'spare_parts_place', '零部件来源地', 'varchar(255)', 'String', 'sparePartsPlace', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 13, 'admin', '2022-12-02 18:11:05', '', NULL);
INSERT INTO `gen_table_column` VALUES (47, '5', 'parts_make_workmanship', '生产工艺', 'varchar(255)', 'String', 'partsMakeWorkmanship', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 14, 'admin', '2022-12-02 18:11:06', '', NULL);
INSERT INTO `gen_table_column` VALUES (48, '6', 'id', NULL, 'int(10)', 'Integer', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:06', '', NULL);
INSERT INTO `gen_table_column` VALUES (49, '6', 'plane_type', NULL, 'varchar(50)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 18:11:06', '', NULL);
INSERT INTO `gen_table_column` VALUES (50, '6', 'finished_type', NULL, 'varchar(50)', 'String', 'finishedType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 3, 'admin', '2022-12-02 18:11:06', '', NULL);
INSERT INTO `gen_table_column` VALUES (51, '6', 'finished_name', NULL, 'varchar(80)', 'String', 'finishedName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 4, 'admin', '2022-12-02 18:11:06', '', NULL);
INSERT INTO `gen_table_column` VALUES (52, '6', 'finished_model', NULL, 'varchar(50)', 'String', 'finishedModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 18:11:06', '', NULL);
INSERT INTO `gen_table_column` VALUES (53, '6', 'finished_manufacturer', NULL, 'varchar(255)', 'String', 'finishedManufacturer', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-12-02 18:11:06', '', NULL);
INSERT INTO `gen_table_column` VALUES (54, '6', 'frame', NULL, 'int(10)', 'Integer', 'frame', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-12-02 18:11:06', '', NULL);
INSERT INTO `gen_table_column` VALUES (55, '6', 'upper_middle_lower', NULL, 'int(10)', 'Integer', 'upperMiddleLower', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-12-02 18:11:07', '', NULL);
INSERT INTO `gen_table_column` VALUES (56, '6', 'left_middle_right', NULL, 'int(10)', 'Integer', 'leftMiddleRight', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-12-02 18:11:07', '', NULL);
INSERT INTO `gen_table_column` VALUES (57, '6', 'install_method', NULL, 'varchar(255)', 'String', 'installMethod', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2022-12-02 18:11:07', '', NULL);
INSERT INTO `gen_table_column` VALUES (58, '6', 'raw_material', NULL, 'varchar(255)', 'String', 'rawMaterial', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-12-02 18:11:07', '', NULL);
INSERT INTO `gen_table_column` VALUES (59, '6', 'spare_parts', NULL, 'varchar(255)', 'String', 'spareParts', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2022-12-02 18:11:07', '', NULL);
INSERT INTO `gen_table_column` VALUES (60, '7', 'id', NULL, 'int(10)', 'Integer', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:07', '', NULL);
INSERT INTO `gen_table_column` VALUES (61, '7', 'plane_type', NULL, 'varchar(50)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 18:11:07', '', NULL);
INSERT INTO `gen_table_column` VALUES (62, '7', 'product_type', NULL, 'varchar(50)', 'String', 'productType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 3, 'admin', '2022-12-02 18:11:07', '', NULL);
INSERT INTO `gen_table_column` VALUES (63, '7', 'product_name', NULL, 'varchar(50)', 'String', 'productName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 4, 'admin', '2022-12-02 18:11:08', '', NULL);
INSERT INTO `gen_table_column` VALUES (64, '7', 'product_model', NULL, 'varchar(50)', 'String', 'productModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 18:11:08', '', NULL);
INSERT INTO `gen_table_column` VALUES (65, '7', 'modify_time', NULL, 'date', 'Date', 'modifyTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 6, 'admin', '2022-12-02 18:11:08', '', NULL);
INSERT INTO `gen_table_column` VALUES (66, '7', 'modify_measures', NULL, 'varchar(200)', 'String', 'modifyMeasures', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-12-02 18:11:08', '', NULL);
INSERT INTO `gen_table_column` VALUES (67, '8', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:08', '', NULL);
INSERT INTO `gen_table_column` VALUES (68, '8', 'product_name', '产品名称', 'varchar(255)', 'String', 'productName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2022-12-02 18:11:08', '', NULL);
INSERT INTO `gen_table_column` VALUES (69, '8', 'product_model', '产品型号', 'varchar(255)', 'String', 'productModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-12-02 18:11:08', '', NULL);
INSERT INTO `gen_table_column` VALUES (70, '8', 'modify_time', '变更时间', 'date', 'Date', 'modifyTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 4, 'admin', '2022-12-02 18:11:08', '', NULL);
INSERT INTO `gen_table_column` VALUES (71, '8', 'modify_type', '变更类型', 'varchar(255)', 'String', 'modifyType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 5, 'admin', '2022-12-02 18:11:08', '', NULL);
INSERT INTO `gen_table_column` VALUES (72, '8', 'modify_method', '变更方式', 'varchar(255)', 'String', 'modifyMethod', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-12-02 18:11:09', '', NULL);
INSERT INTO `gen_table_column` VALUES (73, '9', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:09', '', NULL);
INSERT INTO `gen_table_column` VALUES (74, '9', 'title', NULL, 'varchar(255)', 'String', 'title', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2022-12-02 18:11:09', '', NULL);
INSERT INTO `gen_table_column` VALUES (75, '9', 'plane_type', NULL, 'varchar(255)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 3, 'admin', '2022-12-02 18:11:09', '', NULL);
INSERT INTO `gen_table_column` VALUES (76, '9', 'dev_code', NULL, 'varchar(255)', 'String', 'devCode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-12-02 18:11:09', '', NULL);
INSERT INTO `gen_table_column` VALUES (77, '9', 'dev_unit', NULL, 'varchar(255)', 'String', 'devUnit', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 18:11:09', '', NULL);
INSERT INTO `gen_table_column` VALUES (78, '9', 'dev_manufacture', NULL, 'varchar(255)', 'String', 'devManufacture', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-12-02 18:11:09', '', NULL);
INSERT INTO `gen_table_column` VALUES (79, '9', 'dev_factory_time', '装备出厂时间', 'date', 'Date', 'devFactoryTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 7, 'admin', '2022-12-02 18:11:09', '', NULL);
INSERT INTO `gen_table_column` VALUES (80, '9', 'dev_happen_time', '发生时间', 'date', 'Date', 'devHappenTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 8, 'admin', '2022-12-02 18:11:10', '', NULL);
INSERT INTO `gen_table_column` VALUES (81, '9', 'dev_use_time', '使用时长', 'varchar(255)', 'String', 'devUseTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-12-02 18:11:10', '', NULL);
INSERT INTO `gen_table_column` VALUES (82, '9', 'parts_factory_time', '故障件出厂时间', 'date', 'Date', 'partsFactoryTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 10, 'admin', '2022-12-02 18:11:10', '', NULL);
INSERT INTO `gen_table_column` VALUES (83, '9', 'parts_use_time', '故障件使用时长', 'varchar(255)', 'String', 'partsUseTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-12-02 18:11:10', '', NULL);
INSERT INTO `gen_table_column` VALUES (84, '9', 'parts_type', NULL, 'varchar(255)', 'String', 'partsType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 12, 'admin', '2022-12-02 18:11:10', '', NULL);
INSERT INTO `gen_table_column` VALUES (85, '9', 'parts_name', NULL, 'varchar(255)', 'String', 'partsName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 13, 'admin', '2022-12-02 18:11:10', '', NULL);
INSERT INTO `gen_table_column` VALUES (86, '9', 'parts_model', NULL, 'varchar(255)', 'String', 'partsModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 14, 'admin', '2022-12-02 18:11:10', '', NULL);
INSERT INTO `gen_table_column` VALUES (87, '9', 'parts_code', NULL, 'varchar(255)', 'String', 'partsCode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 15, 'admin', '2022-12-02 18:11:10', '', NULL);
INSERT INTO `gen_table_column` VALUES (88, '9', 'parts_unit', NULL, 'varchar(255)', 'String', 'partsUnit', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 16, 'admin', '2022-12-02 18:11:10', '', NULL);
INSERT INTO `gen_table_column` VALUES (89, '9', 'parts_manufacture', NULL, 'varchar(255)', 'String', 'partsManufacture', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 17, 'admin', '2022-12-02 18:11:10', '', NULL);
INSERT INTO `gen_table_column` VALUES (90, '9', 'fault_phenomenon', NULL, 'varchar(255)', 'String', 'faultPhenomenon', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 18, 'admin', '2022-12-02 18:11:11', '', NULL);
INSERT INTO `gen_table_column` VALUES (91, '9', 'fault_model', NULL, 'varchar(255)', 'String', 'faultModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 19, 'admin', '2022-12-02 18:11:11', '', NULL);
INSERT INTO `gen_table_column` VALUES (92, '9', 'environment', NULL, 'varchar(255)', 'String', 'environment', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 20, 'admin', '2022-12-02 18:11:11', '', NULL);
INSERT INTO `gen_table_column` VALUES (93, '9', 'dev_repaired', NULL, 'varchar(255)', 'String', 'devRepaired', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 21, 'admin', '2022-12-02 18:11:11', '', NULL);
INSERT INTO `gen_table_column` VALUES (94, '9', 'repaired_time', NULL, 'date', 'Date', 'repairedTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 22, 'admin', '2022-12-02 18:11:11', '', NULL);
INSERT INTO `gen_table_column` VALUES (95, '9', 'repaired_factory', NULL, 'varchar(255)', 'String', 'repairedFactory', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 23, 'admin', '2022-12-02 18:11:11', '', NULL);
INSERT INTO `gen_table_column` VALUES (96, '9', 'repaired_staff', NULL, 'varchar(255)', 'String', 'repairedStaff', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 24, 'admin', '2022-12-02 18:11:11', '', NULL);
INSERT INTO `gen_table_column` VALUES (97, '10', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:11', '', NULL);
INSERT INTO `gen_table_column` VALUES (98, '10', 'parts_name', '产品名称', 'varchar(255)', 'String', 'partsName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2022-12-02 18:11:12', '', NULL);
INSERT INTO `gen_table_column` VALUES (99, '10', 'parts_model', '产品型号', 'varchar(255)', 'String', 'partsModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-12-02 18:11:12', '', NULL);
INSERT INTO `gen_table_column` VALUES (100, '10', 'modify_time', '变更时间', 'date', 'Date', 'modifyTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 4, 'admin', '2022-12-02 18:11:12', '', NULL);
INSERT INTO `gen_table_column` VALUES (101, '10', 'modify_type', '变更类型', 'varchar(255)', 'String', 'modifyType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 5, 'admin', '2022-12-02 18:11:12', '', NULL);
INSERT INTO `gen_table_column` VALUES (102, '10', 'modify_method', '变更方式', 'varchar(255)', 'String', 'modifyMethod', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-12-02 18:11:12', '', NULL);
INSERT INTO `gen_table_column` VALUES (103, '11', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:16', '', NULL);
INSERT INTO `gen_table_column` VALUES (104, '11', 'plane_type', '机型', 'varchar(255)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 18:11:16', '', NULL);
INSERT INTO `gen_table_column` VALUES (105, '11', 'troops', '部队', 'varchar(255)', 'String', 'troops', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-12-02 18:11:16', '', NULL);
INSERT INTO `gen_table_column` VALUES (106, '11', 'deployment_time', '部署时间', 'date', 'Date', 'deploymentTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 4, 'admin', '2022-12-02 18:11:16', '', NULL);
INSERT INTO `gen_table_column` VALUES (107, '11', 'deployment_quantity', '部署数量', 'int(11)', 'Long', 'deploymentQuantity', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 18:11:16', '', NULL);
INSERT INTO `gen_table_column` VALUES (108, '12', 'id', NULL, 'int(10)', 'Integer', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (109, '12', 'plane_type', NULL, 'varchar(50)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 18:11:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (110, '12', 'remodel_date', NULL, 'date', 'Date', 'remodelDate', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 3, 'admin', '2022-12-02 18:11:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (111, '12', 'remodel_measure', NULL, 'varchar(255)', 'String', 'remodelMeasure', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-12-02 18:11:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (112, '12', 'make_unit', NULL, 'varchar(100)', 'String', 'makeUnit', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 18:11:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (113, '12', 'model_series', NULL, 'varchar(200)', 'String', 'modelSeries', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-12-02 18:11:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (114, '13', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (115, '13', 'plane_type', NULL, 'varchar(255)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 18:11:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (116, '13', 'dev_code', NULL, 'varchar(255)', 'String', 'devCode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-12-02 18:11:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (117, '13', 'type', NULL, 'varchar(255)', 'String', 'type', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 4, 'admin', '2022-12-02 18:11:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (118, '13', 'production_upgrade_time', NULL, 'date', 'Date', 'productionUpgradeTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 5, 'admin', '2022-12-02 18:11:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (119, '13', 'dev_unit', NULL, 'varchar(255)', 'String', 'devUnit', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-12-02 18:11:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (120, '13', 'dev_manufacture', NULL, 'varchar(255)', 'String', 'devManufacture', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-12-02 18:11:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (121, '13', 'capability_status', NULL, 'varchar(255)', 'String', 'capabilityStatus', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'radio', '', 8, 'admin', '2022-12-02 18:11:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (122, '14', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (123, '14', 'plane_type', NULL, 'varchar(255)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 18:11:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (124, '14', 'parts_name', NULL, 'varchar(255)', 'String', 'partsName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2022-12-02 18:11:19', '', NULL);
INSERT INTO `gen_table_column` VALUES (125, '14', 'parts_model', NULL, 'varchar(255)', 'String', 'partsModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-12-02 18:11:19', '', NULL);
INSERT INTO `gen_table_column` VALUES (126, '14', 'parts_code', NULL, 'varchar(255)', 'String', 'partsCode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 18:11:19', '', NULL);
INSERT INTO `gen_table_column` VALUES (127, '14', 'parts_factory_time', NULL, 'date', 'Date', 'partsFactoryTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 6, 'admin', '2022-12-02 18:11:19', '', NULL);
INSERT INTO `gen_table_column` VALUES (128, '14', 'parts_manufacture', NULL, 'varchar(255)', 'String', 'partsManufacture', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-12-02 18:11:19', '', NULL);
INSERT INTO `gen_table_column` VALUES (129, '14', 'parts_make_group', NULL, 'varchar(255)', 'String', 'partsMakeGroup', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-12-02 18:11:19', '', NULL);
INSERT INTO `gen_table_column` VALUES (130, '14', 'parts_make_people', NULL, 'varchar(255)', 'String', 'partsMakePeople', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-12-02 18:11:19', '', NULL);
INSERT INTO `gen_table_column` VALUES (131, '14', 'parts_make_quipment', NULL, 'varchar(255)', 'String', 'partsMakeQuipment', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2022-12-02 18:11:19', '', NULL);
INSERT INTO `gen_table_column` VALUES (132, '14', 'parts_measuring_quipment', '测量设备', 'varchar(255)', 'String', 'partsMeasuringQuipment', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-12-02 18:11:19', '', NULL);
INSERT INTO `gen_table_column` VALUES (133, '14', 'raw_material_place', '原材料来源地', 'varchar(255)', 'String', 'rawMaterialPlace', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2022-12-02 18:11:20', '', NULL);
INSERT INTO `gen_table_column` VALUES (134, '14', 'spare_parts_place', '零部件来源地', 'varchar(255)', 'String', 'sparePartsPlace', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 13, 'admin', '2022-12-02 18:11:20', '', NULL);
INSERT INTO `gen_table_column` VALUES (135, '14', 'parts_make_workmanship', '生产工艺', 'varchar(255)', 'String', 'partsMakeWorkmanship', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 14, 'admin', '2022-12-02 18:11:20', '', NULL);
INSERT INTO `gen_table_column` VALUES (136, '15', 'id', NULL, 'int(10)', 'Integer', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:20', '', NULL);
INSERT INTO `gen_table_column` VALUES (137, '15', 'plane_type', NULL, 'varchar(50)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 18:11:20', '', NULL);
INSERT INTO `gen_table_column` VALUES (138, '15', 'finished_type', NULL, 'varchar(50)', 'String', 'finishedType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 3, 'admin', '2022-12-02 18:11:20', '', NULL);
INSERT INTO `gen_table_column` VALUES (139, '15', 'finished_name', NULL, 'varchar(80)', 'String', 'finishedName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 4, 'admin', '2022-12-02 18:11:20', '', NULL);
INSERT INTO `gen_table_column` VALUES (140, '15', 'finished_model', NULL, 'varchar(50)', 'String', 'finishedModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 18:11:20', '', NULL);
INSERT INTO `gen_table_column` VALUES (141, '15', 'finished_manufacturer', NULL, 'varchar(255)', 'String', 'finishedManufacturer', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-12-02 18:11:21', '', NULL);
INSERT INTO `gen_table_column` VALUES (142, '15', 'frame', NULL, 'int(10)', 'Integer', 'frame', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-12-02 18:11:21', '', NULL);
INSERT INTO `gen_table_column` VALUES (143, '15', 'upper_middle_lower', NULL, 'int(10)', 'Integer', 'upperMiddleLower', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-12-02 18:11:21', '', NULL);
INSERT INTO `gen_table_column` VALUES (144, '15', 'left_middle_right', NULL, 'int(10)', 'Integer', 'leftMiddleRight', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-12-02 18:11:21', '', NULL);
INSERT INTO `gen_table_column` VALUES (145, '15', 'install_method', NULL, 'varchar(255)', 'String', 'installMethod', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2022-12-02 18:11:21', '', NULL);
INSERT INTO `gen_table_column` VALUES (146, '15', 'raw_material', NULL, 'varchar(255)', 'String', 'rawMaterial', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-12-02 18:11:21', '', NULL);
INSERT INTO `gen_table_column` VALUES (147, '15', 'spare_parts', NULL, 'varchar(255)', 'String', 'spareParts', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2022-12-02 18:11:21', '', NULL);
INSERT INTO `gen_table_column` VALUES (148, '16', 'id', NULL, 'int(10)', 'Integer', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:21', '', NULL);
INSERT INTO `gen_table_column` VALUES (149, '16', 'plane_type', NULL, 'varchar(50)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 2, 'admin', '2022-12-02 18:11:22', '', NULL);
INSERT INTO `gen_table_column` VALUES (150, '16', 'product_type', NULL, 'varchar(50)', 'String', 'productType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 3, 'admin', '2022-12-02 18:11:22', '', NULL);
INSERT INTO `gen_table_column` VALUES (151, '16', 'product_name', NULL, 'varchar(50)', 'String', 'productName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 4, 'admin', '2022-12-02 18:11:22', '', NULL);
INSERT INTO `gen_table_column` VALUES (152, '16', 'product_model', NULL, 'varchar(50)', 'String', 'productModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 18:11:22', '', NULL);
INSERT INTO `gen_table_column` VALUES (153, '16', 'modify_time', NULL, 'date', 'Date', 'modifyTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 6, 'admin', '2022-12-02 18:11:22', '', NULL);
INSERT INTO `gen_table_column` VALUES (154, '16', 'modify_measures', NULL, 'varchar(200)', 'String', 'modifyMeasures', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-12-02 18:11:22', '', NULL);
INSERT INTO `gen_table_column` VALUES (155, '17', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:22', '', NULL);
INSERT INTO `gen_table_column` VALUES (156, '17', 'product_name', '产品名称', 'varchar(255)', 'String', 'productName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2022-12-02 18:11:22', '', NULL);
INSERT INTO `gen_table_column` VALUES (157, '17', 'product_model', '产品型号', 'varchar(255)', 'String', 'productModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-12-02 18:11:23', '', NULL);
INSERT INTO `gen_table_column` VALUES (158, '17', 'modify_time', '变更时间', 'date', 'Date', 'modifyTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 4, 'admin', '2022-12-02 18:11:23', '', NULL);
INSERT INTO `gen_table_column` VALUES (159, '17', 'modify_type', '变更类型', 'varchar(255)', 'String', 'modifyType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 5, 'admin', '2022-12-02 18:11:23', '', NULL);
INSERT INTO `gen_table_column` VALUES (160, '17', 'modify_method', '变更方式', 'varchar(255)', 'String', 'modifyMethod', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-12-02 18:11:23', '', NULL);
INSERT INTO `gen_table_column` VALUES (161, '18', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:23', '', NULL);
INSERT INTO `gen_table_column` VALUES (162, '18', 'title', NULL, 'varchar(255)', 'String', 'title', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2022-12-02 18:11:23', '', NULL);
INSERT INTO `gen_table_column` VALUES (163, '18', 'plane_type', NULL, 'varchar(255)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 3, 'admin', '2022-12-02 18:11:23', '', NULL);
INSERT INTO `gen_table_column` VALUES (164, '18', 'dev_code', NULL, 'varchar(255)', 'String', 'devCode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-12-02 18:11:24', '', NULL);
INSERT INTO `gen_table_column` VALUES (165, '18', 'dev_unit', NULL, 'varchar(255)', 'String', 'devUnit', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-02 18:11:24', '', NULL);
INSERT INTO `gen_table_column` VALUES (166, '18', 'dev_manufacture', NULL, 'varchar(255)', 'String', 'devManufacture', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-12-02 18:11:24', '', NULL);
INSERT INTO `gen_table_column` VALUES (167, '18', 'dev_factory_time', '装备出厂时间', 'date', 'Date', 'devFactoryTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 7, 'admin', '2022-12-02 18:11:24', '', NULL);
INSERT INTO `gen_table_column` VALUES (168, '18', 'dev_happen_time', '发生时间', 'date', 'Date', 'devHappenTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 8, 'admin', '2022-12-02 18:11:24', '', NULL);
INSERT INTO `gen_table_column` VALUES (169, '18', 'dev_use_time', '使用时长', 'varchar(255)', 'String', 'devUseTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-12-02 18:11:24', '', NULL);
INSERT INTO `gen_table_column` VALUES (170, '18', 'parts_factory_time', '故障件出厂时间', 'date', 'Date', 'partsFactoryTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 10, 'admin', '2022-12-02 18:11:24', '', NULL);
INSERT INTO `gen_table_column` VALUES (171, '18', 'parts_use_time', '故障件使用时长', 'varchar(255)', 'String', 'partsUseTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-12-02 18:11:24', '', NULL);
INSERT INTO `gen_table_column` VALUES (172, '18', 'parts_type', NULL, 'varchar(255)', 'String', 'partsType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 12, 'admin', '2022-12-02 18:11:24', '', NULL);
INSERT INTO `gen_table_column` VALUES (173, '18', 'parts_name', NULL, 'varchar(255)', 'String', 'partsName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 13, 'admin', '2022-12-02 18:11:24', '', NULL);
INSERT INTO `gen_table_column` VALUES (174, '18', 'parts_model', NULL, 'varchar(255)', 'String', 'partsModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 14, 'admin', '2022-12-02 18:11:25', '', NULL);
INSERT INTO `gen_table_column` VALUES (175, '18', 'parts_code', NULL, 'varchar(255)', 'String', 'partsCode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 15, 'admin', '2022-12-02 18:11:25', '', NULL);
INSERT INTO `gen_table_column` VALUES (176, '18', 'parts_unit', NULL, 'varchar(255)', 'String', 'partsUnit', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 16, 'admin', '2022-12-02 18:11:25', '', NULL);
INSERT INTO `gen_table_column` VALUES (177, '18', 'parts_manufacture', NULL, 'varchar(255)', 'String', 'partsManufacture', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 17, 'admin', '2022-12-02 18:11:25', '', NULL);
INSERT INTO `gen_table_column` VALUES (178, '18', 'fault_phenomenon', NULL, 'varchar(255)', 'String', 'faultPhenomenon', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 18, 'admin', '2022-12-02 18:11:25', '', NULL);
INSERT INTO `gen_table_column` VALUES (179, '18', 'fault_model', NULL, 'varchar(255)', 'String', 'faultModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 19, 'admin', '2022-12-02 18:11:25', '', NULL);
INSERT INTO `gen_table_column` VALUES (180, '18', 'environment', NULL, 'varchar(255)', 'String', 'environment', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 20, 'admin', '2022-12-02 18:11:25', '', NULL);
INSERT INTO `gen_table_column` VALUES (181, '18', 'dev_repaired', NULL, 'varchar(255)', 'String', 'devRepaired', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 21, 'admin', '2022-12-02 18:11:25', '', NULL);
INSERT INTO `gen_table_column` VALUES (182, '18', 'repaired_time', NULL, 'date', 'Date', 'repairedTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 22, 'admin', '2022-12-02 18:11:25', '', NULL);
INSERT INTO `gen_table_column` VALUES (183, '18', 'repaired_factory', NULL, 'varchar(255)', 'String', 'repairedFactory', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 23, 'admin', '2022-12-02 18:11:26', '', NULL);
INSERT INTO `gen_table_column` VALUES (184, '18', 'repaired_staff', NULL, 'varchar(255)', 'String', 'repairedStaff', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 24, 'admin', '2022-12-02 18:11:26', '', NULL);
INSERT INTO `gen_table_column` VALUES (185, '19', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-02 18:11:26', '', NULL);
INSERT INTO `gen_table_column` VALUES (186, '19', 'parts_name', '产品名称', 'varchar(255)', 'String', 'partsName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2022-12-02 18:11:26', '', NULL);
INSERT INTO `gen_table_column` VALUES (187, '19', 'parts_model', '产品型号', 'varchar(255)', 'String', 'partsModel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-12-02 18:11:26', '', NULL);
INSERT INTO `gen_table_column` VALUES (188, '19', 'modify_time', '变更时间', 'date', 'Date', 'modifyTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 4, 'admin', '2022-12-02 18:11:26', '', NULL);
INSERT INTO `gen_table_column` VALUES (189, '19', 'modify_type', '变更类型', 'varchar(255)', 'String', 'modifyType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 5, 'admin', '2022-12-02 18:11:26', '', NULL);
INSERT INTO `gen_table_column` VALUES (190, '19', 'modify_method', '变更方式', 'varchar(255)', 'String', 'modifyMethod', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-12-02 18:11:26', '', NULL);
INSERT INTO `gen_table_column` VALUES (191, '20', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-12-04 14:25:13', '', NULL);
INSERT INTO `gen_table_column` VALUES (192, '20', 'date', '年月', 'date', 'Date', 'date', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 2, 'admin', '2022-12-04 14:25:13', '', NULL);
INSERT INTO `gen_table_column` VALUES (193, '20', 'plane_type', '机型', 'varchar(255)', 'String', 'planeType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 3, 'admin', '2022-12-04 14:25:13', '', NULL);
INSERT INTO `gen_table_column` VALUES (194, '20', 'troops', '部队', 'varchar(255)', 'String', 'troops', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-12-04 14:25:13', '', NULL);
INSERT INTO `gen_table_column` VALUES (195, '20', 'flight_hours', '飞行小时', 'varchar(255)', 'String', 'flightHours', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-12-04 14:25:13', '', NULL);

-- ----------------------------
-- Table structure for parts_make_num_9
-- ----------------------------
DROP TABLE IF EXISTS `parts_make_num_9`;
CREATE TABLE `parts_make_num_9`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plane_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_factory_time` date NULL DEFAULT NULL,
  `parts_manufacture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_make_group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_make_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_make_quipment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_measuring_quipment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '测量设备',
  `raw_material_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原材料来源地',
  `spare_parts_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零部件来源地',
  `parts_make_workmanship` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产工艺',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of parts_make_num_9
-- ----------------------------
INSERT INTO `parts_make_num_9` VALUES (1, '机型1A', '液压泵', 'TC-1', '20221130', '2022-11-17', '202211', '班组1', '[人员4,人员5,人员6]', '[300#五轴机床,20#夹具]', '[300#五轴机床2,20#夹具2]', NULL, '2', '焊接');
INSERT INTO `parts_make_num_9` VALUES (2, '机型1B', '功率阀', 'GL-1', '20221131', '2022-01-30', '202212', '班组2', '[人员1,人员2,人员3]', '[310#五轴机床,20#夹具]', '[310#五轴机床1,20#夹具2]', NULL, '2', '热处理');
INSERT INTO `parts_make_num_9` VALUES (3, '机型1A', '功率阀', 'GL-1', '20221132', '2022-06-16', '202213', '班组2', '[人员1,人员2,人员3]', '[310#五轴机床,20#夹具]', '[310#五轴机床1,20#夹具2]', NULL, '3', '塑形');
INSERT INTO `parts_make_num_9` VALUES (4, '机型3B', '功率阀', 'GL-1', '20221133', '2022-01-07', '202214', '320厂第4组', '[人员10,人员11,人员12]', '[323#五轴机床,13#夹具]', '[323#五轴机床,13#夹具]', NULL, '5', '塑形');
INSERT INTO `parts_make_num_9` VALUES (5, '机型2C', '液压泵', 'TC-2', '20221134', '2022-06-09', '202215', '320厂第3组', '[人员7,人员8,人员9]', '[323#五轴机床,13#夹具]', '[323#五轴机床,13#夹具]', NULL, '6', '焊接');
INSERT INTO `parts_make_num_9` VALUES (6, '机型3C', '液压泵', 'TC-2', '20221135', '2022-11-10', '202216', '320厂第3组', '[人员7,人员8,人员9]', '[323#五轴机床,13#夹具]', '[323#五轴机床,13#夹具]', NULL, '6', '焊接');

-- ----------------------------
-- Table structure for parts_repair_num_13
-- ----------------------------
DROP TABLE IF EXISTS `parts_repair_num_13`;
CREATE TABLE `parts_repair_num_13`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plane_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_factory_time` date NULL DEFAULT NULL,
  `parts_manufacture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_repair_group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品维修班组',
  `parts_repair_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品维修人员',
  `parts_repair_quipment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品维修设备',
  `parts_measuring_quipment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '\r\n',
  `raw_material_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `spare_parts_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_make_workmanship` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of parts_repair_num_13
-- ----------------------------
INSERT INTO `parts_repair_num_13` VALUES (1, '机型1B', '液压泵', 'TC-1', '20221135', '2022-12-26', '202212', '维修班组1', '[王老三,张老四]', '[300#五轴机床,20#夹具]', NULL, NULL, NULL, NULL);
INSERT INTO `parts_repair_num_13` VALUES (2, '机型3B', '功率阀', 'GL-1', '20221133', '2022-12-04', '202214', '维修班组2', '[李伟,赵四]', '[320#五轴机床2,21#夹具]', NULL, NULL, NULL, NULL);
INSERT INTO `parts_repair_num_13` VALUES (3, '机型1A', '功率阀', 'GL-2', '20221132', '2022-12-01', '202213', '维修班组3', '[张三,李伟]', '[200#五轴机床,20#夹具]', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for product_design_3
-- ----------------------------
DROP TABLE IF EXISTS `product_design_3`;
CREATE TABLE `product_design_3`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `plane_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `finished_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `finished_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `finished_model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `finished_manufacturer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `frame` int(10) NULL DEFAULT NULL,
  `upper_middle_lower` int(10) NULL DEFAULT NULL,
  `left_middle_right` int(10) NULL DEFAULT NULL,
  `install_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `raw_material` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `spare_parts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_design_3
-- ----------------------------
INSERT INTO `product_design_3` VALUES (1, '机型1A', '泵', '液压泵', 'TC-1', '123厂', 3, 1, 2, '直接安装', '45#铸铁', '25');
INSERT INTO `product_design_3` VALUES (2, '机型2B', '阀', '功率阀', 'Gl-1', '123厂', 15, 2, 3, '由连接件固定在框上', '不锈钢', '19');
INSERT INTO `product_design_3` VALUES (3, '机型1B', '阀', '功率阀', 'Gl-2', '123厂', 12, 1, 1, '直接安装', '不锈钢', '15');
INSERT INTO `product_design_3` VALUES (4, '机型1E', '阀', '功率阀', 'Gl-3', '123厂', 12, 1, 1, '由连接件固定在框上', '不锈钢', '15');
INSERT INTO `product_design_3` VALUES (5, '机型1F', '阀', '功率阀', 'Gl-3', '123厂', 12, 1, 1, '由连接件固定在框上', '不锈钢', '15');
INSERT INTO `product_design_3` VALUES (6, '机型2G', '阀', '功率阀', 'Gl-2', '123厂', 12, 1, 1, '直接安装', '不锈钢', '15');
INSERT INTO `product_design_3` VALUES (8, '机型3A', '泵', '液压泵', 'TC-2', '123厂', 3, 1, 2, '由连接件固定在框上', '45#铸铁', '25');

-- ----------------------------
-- Table structure for product_modify_4
-- ----------------------------
DROP TABLE IF EXISTS `product_modify_4`;
CREATE TABLE `product_modify_4`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `plane_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modify_time` date NULL DEFAULT NULL,
  `modify_measures` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_modify_4
-- ----------------------------
INSERT INTO `product_modify_4` VALUES (1, '机型1A', '泵', '液压泵', 'TC-1', '2022-09-28', '更换密封圈制造商');
INSERT INTO `product_modify_4` VALUES (2, '机型2B', '阀', '功率阀', 'GL-1', '2022-06-16', '更换阀门');
INSERT INTO `product_modify_4` VALUES (3, '机型1B', '阀', '功率阀', 'GL-2', '2022-12-08', '更换阀门');
INSERT INTO `product_modify_4` VALUES (4, '机型1B', '阀', '功率阀', 'GL-2', '2021-07-23', '更换阀门');
INSERT INTO `product_modify_4` VALUES (5, '机型1B', '阀', '功率阀', 'GL-2', '2021-12-25', '更换阀门');
INSERT INTO `product_modify_4` VALUES (6, '机型1A', '泵', '液压泵', 'TC-1', '2021-08-28', '更换密封圈制造商');
INSERT INTO `product_modify_4` VALUES (7, '机型2B', '阀', '功率阀', 'GL-1', '2022-08-14', '更换阀门');
INSERT INTO `product_modify_4` VALUES (8, '机型2B', '阀', '功率阀', 'GL-1', '2021-03-13', '更换阀门');

-- ----------------------------
-- Table structure for product_modify_data_6
-- ----------------------------
DROP TABLE IF EXISTS `product_modify_data_6`;
CREATE TABLE `product_modify_data_6`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `product_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品型号',
  `modify_time` date NULL DEFAULT NULL COMMENT '变更时间',
  `modify_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '变更类型',
  `modify_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '变更方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '对应文档中的表7 产品制造变更数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_modify_data_6
-- ----------------------------
INSERT INTO `product_modify_data_6` VALUES (1, '液压泵', 'TC-1', '2021-06-01', '生产班组变更', '有大量新员工入职');
INSERT INTO `product_modify_data_6` VALUES (2, '液压泵', 'TC-2', '2022-02-01', '生产班组变更', '有大量新员工入职');
INSERT INTO `product_modify_data_6` VALUES (3, '功率阀', 'GL-1', '2022-10-01', '生产人员变更', '有大量新员工入职');
INSERT INTO `product_modify_data_6` VALUES (4, '功率阀', 'Gl-2', '2021-12-01', '生产班组变更', '有大量新员工入职');
INSERT INTO `product_modify_data_6` VALUES (5, '液压泵', 'TC-1', '2022-11-01', '原材料来源变更', '将铜原材料变TCA厂');
INSERT INTO `product_modify_data_6` VALUES (6, '功率阀', 'Gl-2', '2021-09-01', '生产设备变更', '');
INSERT INTO `product_modify_data_6` VALUES (7, '功率阀', 'Gl-1', '2021-09-01', '零部件来源变更', '将19变L厂');
INSERT INTO `product_modify_data_6` VALUES (8, '功率阀', 'Gl-1', '2021-11-01', '零部件来源变更', '将19变L厂');
INSERT INTO `product_modify_data_6` VALUES (9, '液压泵', 'TC-1', '2019-06-01', '原材料来源变更', '将铁原材料变TCB厂');
INSERT INTO `product_modify_data_6` VALUES (10, '液压泵', 'TC-2', '2018-03-01', '原材料来源变更', '将铜原材料变TCA厂');
INSERT INTO `product_modify_data_6` VALUES (11, '液压泵', 'TC-2', '2020-06-01', '原材料来源变更', '将铁原材料变TCB厂');
INSERT INTO `product_modify_data_6` VALUES (12, '液压泵', 'TC-2', '2022-02-01', '原材料来源变更', '将铝原材料变TCC厂');
INSERT INTO `product_modify_data_6` VALUES (13, '功率阀', 'GL-2', '2018-06-01', '原材料来源变更', '将铜原材料变GLA厂');
INSERT INTO `product_modify_data_6` VALUES (14, '功率阀', 'GL-2', '2022-06-01', '原材料来源变更', '将铁原材料变GLB厂');
INSERT INTO `product_modify_data_6` VALUES (15, '功率阀', 'GL-2', '2021-09-01', '原材料来源变更', '将铝原材料变GLC厂');
INSERT INTO `product_modify_data_6` VALUES (16, '功率阀', 'GL-2', '2022-09-01', '原材料来源变更', '将锰原材料变GLD厂');
INSERT INTO `product_modify_data_6` VALUES (17, '功率阀', 'GL-1', '2022-06-01', '生产工艺变更', '检测方法变更');
INSERT INTO `product_modify_data_6` VALUES (18, '功率阀', 'GL-2', '2021-11-18', '零部件来源变更', '');
INSERT INTO `product_modify_data_6` VALUES (19, '功率阀', 'GL-1', '2021-07-13', '零部件来源变更', '');
INSERT INTO `product_modify_data_6` VALUES (20, '液压泵', 'TC-2', '2022-02-07', '零部件来源变更', NULL);
INSERT INTO `product_modify_data_6` VALUES (21, '液压泵', 'TC-2', '2021-10-28', '零部件来源变更', NULL);
INSERT INTO `product_modify_data_6` VALUES (22, '液压泵', 'TC-2', '2021-10-28', '零部件来源变更', NULL);
INSERT INTO `product_modify_data_6` VALUES (23, '液压泵', 'TC-1', '2022-02-07', '零部件来源变更', '将25变L厂');
INSERT INTO `product_modify_data_6` VALUES (24, '液压泵', 'TC-1', '2021-12-30', '测量设备变更', NULL);
INSERT INTO `product_modify_data_6` VALUES (25, '功率阀', 'GL-2', '2022-06-01', '测量设备变更', '');
INSERT INTO `product_modify_data_6` VALUES (26, '液压泵', 'TC-1', '2020-07-01', '生产设备变更', '');
INSERT INTO `product_modify_data_6` VALUES (27, '液压泵', 'TC-2', '2021-03-19', '生产设备变更', '');
INSERT INTO `product_modify_data_6` VALUES (28, '液压泵', 'TC-2', '2022-01-01', '生产设备变更', '');
INSERT INTO `product_modify_data_6` VALUES (29, '功率阀', 'GL-2', '2019-06-18', '测量设备变更', '');
INSERT INTO `product_modify_data_6` VALUES (30, '液压泵', 'TC-1', '2021-09-01', '生产设备变更', '');

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `blob_data` blob NULL COMMENT '存放持久化Trigger对象',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Blob类型的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `calendar_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日历名称',
  `calendar` blob NOT NULL COMMENT '存放持久化calendar对象',
  PRIMARY KEY (`sched_name`, `calendar_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日历信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `cron_expression` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'cron表达式',
  `time_zone_id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时区',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Cron类型的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `entry_id` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度器实例id',
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `instance_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度器实例名',
  `fired_time` bigint(13) NOT NULL COMMENT '触发的时间',
  `sched_time` bigint(13) NOT NULL COMMENT '定时器制定的时间',
  `priority` int(11) NOT NULL COMMENT '优先级',
  `state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态',
  `job_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务组名',
  `is_nonconcurrent` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否并发',
  `requests_recovery` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否接受恢复执行',
  PRIMARY KEY (`sched_name`, `entry_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '已触发的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `job_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务组名',
  `description` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '相关介绍',
  `job_class_name` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '执行任务类名称',
  `is_durable` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否持久化',
  `is_nonconcurrent` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否并发',
  `is_update_data` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否更新数据',
  `requests_recovery` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否接受恢复执行',
  `job_data` blob NULL COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务详细信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `lock_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '悲观锁名称',
  PRIMARY KEY (`sched_name`, `lock_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '存储的悲观锁信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  PRIMARY KEY (`sched_name`, `trigger_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '暂停的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `instance_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实例名称',
  `last_checkin_time` bigint(13) NOT NULL COMMENT '上次检查时间',
  `checkin_interval` bigint(13) NOT NULL COMMENT '检查间隔时间',
  PRIMARY KEY (`sched_name`, `instance_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '调度器状态表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `repeat_count` bigint(7) NOT NULL COMMENT '重复的次数统计',
  `repeat_interval` bigint(12) NOT NULL COMMENT '重复的间隔时间',
  `times_triggered` bigint(10) NOT NULL COMMENT '已经触发的次数',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '简单触发器的信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `str_prop_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第一个参数',
  `str_prop_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第二个参数',
  `str_prop_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第三个参数',
  `int_prop_1` int(11) NULL DEFAULT NULL COMMENT 'int类型的trigger的第一个参数',
  `int_prop_2` int(11) NULL DEFAULT NULL COMMENT 'int类型的trigger的第二个参数',
  `long_prop_1` bigint(20) NULL DEFAULT NULL COMMENT 'long类型的trigger的第一个参数',
  `long_prop_2` bigint(20) NULL DEFAULT NULL COMMENT 'long类型的trigger的第二个参数',
  `dec_prop_1` decimal(13, 4) NULL DEFAULT NULL COMMENT 'decimal类型的trigger的第一个参数',
  `dec_prop_2` decimal(13, 4) NULL DEFAULT NULL COMMENT 'decimal类型的trigger的第二个参数',
  `bool_prop_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Boolean类型的trigger的第一个参数',
  `bool_prop_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Boolean类型的trigger的第二个参数',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '同步机制的行锁表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '触发器的名字',
  `trigger_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '触发器所属组的名字',
  `job_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_job_details表job_name的外键',
  `job_group` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'qrtz_job_details表job_group的外键',
  `description` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '相关介绍',
  `next_fire_time` bigint(13) NULL DEFAULT NULL COMMENT '上一次触发时间（毫秒）',
  `prev_fire_time` bigint(13) NULL DEFAULT NULL COMMENT '下一次触发时间（默认为-1表示不触发）',
  `priority` int(11) NULL DEFAULT NULL COMMENT '优先级',
  `trigger_state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '触发器状态',
  `trigger_type` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '触发器的类型',
  `start_time` bigint(13) NOT NULL COMMENT '开始时间',
  `end_time` bigint(13) NULL DEFAULT NULL COMMENT '结束时间',
  `calendar_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日程表名称',
  `misfire_instr` smallint(2) NULL DEFAULT NULL COMMENT '补偿执行的策略',
  `job_data` blob NULL COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  INDEX `sched_name`(`sched_name` ASC, `job_name` ASC, `job_group` ASC) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '触发器详细信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for quality_problem_1
-- ----------------------------
DROP TABLE IF EXISTS `quality_problem_1`;
CREATE TABLE `quality_problem_1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plane_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dev_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dev_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dev_manufacture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dev_factory_time` date NULL DEFAULT NULL COMMENT '装备出厂时间',
  `dev_happen_time` date NULL DEFAULT NULL COMMENT '发生时间',
  `dev_use_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用时长',
  `parts_factory_time` date NULL DEFAULT NULL COMMENT '故障件出厂时间',
  `parts_use_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障件使用时长',
  `parts_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parts_manufacture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fault_phenomenon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fault_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `environment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dev_repaired` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repaired_time` date NULL DEFAULT NULL,
  `repaired_factory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repaired_staff` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of quality_problem_1
-- ----------------------------
INSERT INTO `quality_problem_1` VALUES (1, '质量问题1', '机型1B', '201111701', '制造单位1', '01', '2020-07-09', '2021-10-15', '200', '2022-11-17', '123.1', '泵', '液压泵', 'TC-1', '20221130', '123厂', '202211', '飞行过程中液压泵漏油', '漏油、漏水', '沿海地区', '是', '2021-06-10', '6666厂', '[王老三;张老四]');
INSERT INTO `quality_problem_1` VALUES (2, '质量问题2', '机型1B', '201111702', '制造单位2', '02', '2022-09-14', '2022-11-18', '400', '2022-01-30', '123.2', '阀', '功率阀', 'GL-1', '20221131', '123厂', '202212', '飞行过程中功率阀漏水', '漏油、漏水', '沿海地区', '是', '2022-05-11', '6666厂', '[王老三;张老四]');
INSERT INTO `quality_problem_1` VALUES (3, '质量问题3', '机型1A', '201111701', '制造单位3', '03', '2020-06-30', '2022-02-23', '500', '2022-06-16', '123.3', '阀', '功率阀', 'GL-1', '20221132', '123厂', '202213', '飞行过程中液压泵漏油漏水', '漏油、漏水', '大陆', '是', '2022-11-30', '123厂', '[李伟;赵四]');
INSERT INTO `quality_problem_1` VALUES (4, '质量问题4', '机型3B', '201111017', '制造单位2', '04', '2021-06-16', '2022-11-14', '300', '2022-01-07', '230', '阀', '功率阀', 'GL-1', '20221133', '123厂', '202214', '飞行过程中停机', '漏油、漏水', '高原地区', '否', '2022-12-04', '123厂', '[王三将;许啸天]');
INSERT INTO `quality_problem_1` VALUES (5, '质量问题5', '机型2C', '201111004', '制造单位4', '05', '2021-02-11', '2021-10-22', '666', '2022-06-29', '240', '泵', '液压泵', 'TC-2', '20221134', '321厂', '202215', '飞行过程中液压泵漏油', '漏油、漏水', '大陆', '是', '2022-12-30', '123厂', '[王三将;许啸天]');
INSERT INTO `quality_problem_1` VALUES (6, '质量问题6', '机型1B', '201111702', '制造单位2', '02', '2022-09-14', '2022-10-19', '500', '2022-11-30', '250', '泵', '液压泵', 'TC-1', '20221135', '123厂', '202212', '飞行过程中液压泵磨损', '过度磨损', '沿海地区', '否', '2022-12-26', '123厂', '[张三;李四]');
INSERT INTO `quality_problem_1` VALUES (7, '质量问题7', '机型1A', '201111701', '制造单位3', '03', '2020-06-30', '2021-02-23', '500', '2022-06-16', '123.3', '泵', '液压泵', 'TC-1', '20221136', '123厂', '202213', '飞行过程中液压泵磨损', '过度磨损', '大陆', '是', '2022-11-30', '123厂', '[李伟;赵四]');
INSERT INTO `quality_problem_1` VALUES (11, '质量问题8', '机型1E', '201111708', '制造单位8', '2', '2020-03-30', '2021-01-15', '500', '2021-08-17', '666', '阀', '功率阀', 'GL-3', '20221108', '123厂', '202208', '飞行过程中功率阀磨损', '过度磨损', '大陆', '否', NULL, '', '[王三将;许啸天]');
INSERT INTO `quality_problem_1` VALUES (12, '质量问题9', '机型1A', '201111709', '制造单位3', '2', '2019-04-16', '2020-07-05', '600', '2021-02-06', '888', '泵', '液压泵', 'TC-1', '20221109', '123厂', '202209', '飞行过程中液压泵漏油漏水', '漏油、漏水', '沿海地区', '否', NULL, '', '[李伟;赵四]');

-- ----------------------------
-- Table structure for repair_modify_data_10
-- ----------------------------
DROP TABLE IF EXISTS `repair_modify_data_10`;
CREATE TABLE `repair_modify_data_10`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parts_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `parts_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品型号',
  `modify_time` date NULL DEFAULT NULL COMMENT '变更时间',
  `modify_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '变更类型',
  `modify_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '变更方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair_modify_data_10
-- ----------------------------
INSERT INTO `repair_modify_data_10` VALUES (1, '液压泵', 'TC-1', '2022-11-09', '维修班组变更', '有大量新员工入职');
INSERT INTO `repair_modify_data_10` VALUES (2, '功率阀', 'GL-1', '2022-12-02', '维修班组变更', '有大量新员工入职');
INSERT INTO `repair_modify_data_10` VALUES (3, '功率阀', 'GL-2', '2022-12-04', '维修班组变更', '有大量新员工入职');
INSERT INTO `repair_modify_data_10` VALUES (4, '液压泵', 'TC-1', '2022-09-07', '维修人员变更', '有大量新员工入职');
INSERT INTO `repair_modify_data_10` VALUES (5, '功率阀', 'GL-2', '2022-08-04', '维修人员变更', '有大量新员工入职');
INSERT INTO `repair_modify_data_10` VALUES (6, '功率阀', 'GL-1', '2022-06-10', '维修人员变更', '有大量新员工入职');
INSERT INTO `repair_modify_data_10` VALUES (7, '液压泵', 'TC-1', '2022-02-02', '维修人员变更', '有大量新员工入职');
INSERT INTO `repair_modify_data_10` VALUES (8, '液压泵', 'TC-1', '2022-04-09', '维修人员变更', '有大量新员工入职');
INSERT INTO `repair_modify_data_10` VALUES (9, '功率阀', 'GL-1', '2022-02-10', '维修人员变更', '有大量新员工入职');
INSERT INTO `repair_modify_data_10` VALUES (10, '功率阀', 'GL-2', '2022-01-06', '维修人员变更', '有大量新员工入职');
INSERT INTO `repair_modify_data_10` VALUES (11, '功率阀', 'GL-2', '2022-08-04', '维修工艺变更', '焊接');
INSERT INTO `repair_modify_data_10` VALUES (12, '功率阀', 'GL-1', '2022-06-10', '维修工艺变更', '热处理');
INSERT INTO `repair_modify_data_10` VALUES (13, '液压泵', 'TC-1', '2022-02-02', '维修工艺变更', '焊接');
INSERT INTO `repair_modify_data_10` VALUES (14, '液压泵', 'TC-1', '2022-04-09', '维修工艺变更', '塑形');
INSERT INTO `repair_modify_data_10` VALUES (15, '功率阀', 'GL-1', '2022-02-10', '维修工艺变更', '塑形');
INSERT INTO `repair_modify_data_10` VALUES (16, '功率阀', 'GL-2', '2022-01-06', '维修工艺变更', '热处理');
INSERT INTO `repair_modify_data_10` VALUES (17, '功率阀', 'GL-2', '2022-01-06', '维修设备变更', '');
INSERT INTO `repair_modify_data_10` VALUES (18, '功率阀', 'GL-2', '2022-05-01', '维修设备变更', '');
INSERT INTO `repair_modify_data_10` VALUES (19, '功率阀', 'GL-1', '2022-10-01', '维修设备变更', '');

-- ----------------------------
-- Table structure for rule_construction
-- ----------------------------
DROP TABLE IF EXISTS `rule_construction`;
CREATE TABLE `rule_construction`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `change_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '变更项名称',
  `rule` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '判明准则',
  `rule_data` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规则数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rule_construction
-- ----------------------------
INSERT INTO `rule_construction` VALUES (1, '装备型号升级', '不同问题装备型号中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (2, '装备型号升级', '问题装备型号技术状态进行升级时间与质量问题变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (3, '装备能力提升', '同一型号的不同能力状态中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (4, '装备能力提升', '问题装备型号能力提升时间与质量问题变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (5, '产品改型', '不同故障件型号中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (6, '产品改型', '相同故障件型号的不同安装方式中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (7, '产品改型', '相同故障件型号的不同安装位置中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (8, '产品改型', '故障件型号技术状态升级时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (9, '生产班组发生变化', '不同生产班组生产的相同故障件型号中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (10, '生产班组发生变化', '某故障件型号生产班组发生调整时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (11, '生产人员发生变化', '不同生产人员生产的相同故障件中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (12, '生产人员发生变化', '大量生产新员工入职或老员工离职/换岗与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (13, '生产设备发生变化', '不同生产设备生产的相同故障件中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (14, '生产设备发生变化', '生产线大量新设备开始使用时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (15, '生产设备发生变化', '生产线进行升级或更换时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (16, '测量设备发生变化', '不同测量设备测量的相同故障件中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (17, '测量设备发生变化', '故障件生产中测量设备批量更换时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (18, '测量设备发生变化', '故障件出厂检测的测量设备批量更换时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (19, '供应链发生变化', '不同故障件所用原材料来源中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (20, '供应链发生变化', '不同故障件所用零部件来源中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (21, '供应链发生变化', '故障件相关原材料或原材料供应商更换时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (22, '供应链发生变化', '故障件所需零部件供应商发生变更时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (23, '生产工艺发生变化', '不同生产工艺生产的故障件中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (24, '生产工艺发生变化', '故障件生产工艺变更时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (25, '生产工艺发生变化', '故障件检测方法变更时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (26, '维修班组发生变化', '不同维修班组生产的相同故障件型号中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (27, '维修班组发生变化', '某故障件型号维修班组发生调整时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (28, '维修人员发生变化', '不同维修人员生产的相同故障件中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (29, '维修人员发生变化', '大量维修新员工入职或老员工离职/换岗与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (30, '维修设备发生变化', '维修线大量新设备开始使用时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (31, '维修设备发生变化', '维修线进行升级或更换时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (32, '维修工艺发生变化', '不同维修工艺维修的故障件中，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (33, '维修工艺发生变化', '故障件维修工艺变更时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (34, '使用强度发生变化', '年度/季度平均飞行小时变更时间与质量问题数量变化时间一致或不超过一定范围', '一致');
INSERT INTO `rule_construction` VALUES (35, '装备状态发生变化', '不同状态（新出厂、稳定期、装备到寿或大修过）的装备，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (36, '装备状态发生变化', '不同状态（是否大修过）的故障件，某种故障模式质量问题数量存在较大差异', '1.5');
INSERT INTO `rule_construction` VALUES (37, '使用环境发生变化', '不同使用环境下（沿海、高原、平原、沙漠、湿地）的装备，某种故障模式质量问题数量存在较大差异', '1.5');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2022-11-29 20:36:33', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2022-11-29 20:36:33', '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2022-11-29 20:36:33', '', NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` VALUES (4, '账号自助-验证码开关', 'sys.account.captchaEnabled', 'false', 'Y', 'admin', '2022-11-29 20:36:33', 'admin', '2022-11-30 14:49:12', '是否开启验证码功能（true开启，false关闭）');
INSERT INTO `sys_config` VALUES (5, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2022-11-29 20:36:33', '', NULL, '是否开启注册用户功能（true开启，false关闭）');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 200 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, 0, '0', '若依科技', 0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-29 20:36:32', '', NULL);
INSERT INTO `sys_dept` VALUES (101, 100, '0,100', '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-29 20:36:32', '', NULL);
INSERT INTO `sys_dept` VALUES (102, 100, '0,100', '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-29 20:36:32', '', NULL);
INSERT INTO `sys_dept` VALUES (103, 101, '0,100,101', '研发部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-29 20:36:32', '', NULL);
INSERT INTO `sys_dept` VALUES (104, 101, '0,100,101', '市场部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-29 20:36:32', '', NULL);
INSERT INTO `sys_dept` VALUES (105, 101, '0,100,101', '测试部门', 3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-29 20:36:32', '', NULL);
INSERT INTO `sys_dept` VALUES (106, 101, '0,100,101', '财务部门', 4, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-29 20:36:32', '', NULL);
INSERT INTO `sys_dept` VALUES (107, 101, '0,100,101', '运维部门', 5, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-29 20:36:32', '', NULL);
INSERT INTO `sys_dept` VALUES (108, 102, '0,100,102', '市场部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-29 20:36:32', '', NULL);
INSERT INTO `sys_dept` VALUES (109, 102, '0,100,102', '财务部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-29 20:36:32', '', NULL);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '默认分组');
INSERT INTO `sys_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '系统分组');
INSERT INTO `sys_dict_data` VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '系统默认是');
INSERT INTO `sys_dict_data` VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '系统默认否');
INSERT INTO `sys_dict_data` VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '通知');
INSERT INTO `sys_dict_data` VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '公告');
INSERT INTO `sys_dict_data` VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '关闭状态');
INSERT INTO `sys_dict_data` VALUES (18, 99, '其他', '0', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '其他操作');
INSERT INTO `sys_dict_data` VALUES (19, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '新增操作');
INSERT INTO `sys_dict_data` VALUES (20, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '修改操作');
INSERT INTO `sys_dict_data` VALUES (21, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '删除操作');
INSERT INTO `sys_dict_data` VALUES (22, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '授权操作');
INSERT INTO `sys_dict_data` VALUES (23, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '导出操作');
INSERT INTO `sys_dict_data` VALUES (24, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '导入操作');
INSERT INTO `sys_dict_data` VALUES (25, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '强退操作');
INSERT INTO `sys_dict_data` VALUES (26, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '生成操作');
INSERT INTO `sys_dict_data` VALUES (27, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '清空操作');
INSERT INTO `sys_dict_data` VALUES (28, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (29, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '停用状态');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2022-11-29 20:36:33', '', NULL, '登录状态列表');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2022-11-29 20:36:33', '', NULL, '');
INSERT INTO `sys_job` VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2022-11-29 20:36:33', '', NULL, '');
INSERT INTO `sys_job` VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2022-11-29 20:36:33', '', NULL, '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '提示消息',
  `login_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 608 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES (100, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-29 21:22:00');
INSERT INTO `sys_logininfor` VALUES (101, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '1', '验证码已失效', '2022-11-29 21:22:19');
INSERT INTO `sys_logininfor` VALUES (102, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-11-29 21:22:44');
INSERT INTO `sys_logininfor` VALUES (103, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 11:53:35');
INSERT INTO `sys_logininfor` VALUES (104, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 12:40:10');
INSERT INTO `sys_logininfor` VALUES (105, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '1', '验证码已失效', '2022-11-30 12:42:04');
INSERT INTO `sys_logininfor` VALUES (106, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 12:42:13');
INSERT INTO `sys_logininfor` VALUES (107, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 12:57:44');
INSERT INTO `sys_logininfor` VALUES (108, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '1', '验证码已失效', '2022-11-30 13:01:43');
INSERT INTO `sys_logininfor` VALUES (109, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 13:02:05');
INSERT INTO `sys_logininfor` VALUES (110, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 13:13:29');
INSERT INTO `sys_logininfor` VALUES (111, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 13:16:11');
INSERT INTO `sys_logininfor` VALUES (112, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '1', '验证码错误', '2022-11-30 13:26:12');
INSERT INTO `sys_logininfor` VALUES (113, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 13:26:27');
INSERT INTO `sys_logininfor` VALUES (114, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-11-30 13:26:27');
INSERT INTO `sys_logininfor` VALUES (115, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-11-30 13:31:53');
INSERT INTO `sys_logininfor` VALUES (116, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 13:31:59');
INSERT INTO `sys_logininfor` VALUES (117, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 13:32:00');
INSERT INTO `sys_logininfor` VALUES (118, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 13:48:22');
INSERT INTO `sys_logininfor` VALUES (119, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 13:59:23');
INSERT INTO `sys_logininfor` VALUES (120, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-11-30 14:08:01');
INSERT INTO `sys_logininfor` VALUES (121, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 14:08:05');
INSERT INTO `sys_logininfor` VALUES (122, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 14:08:10');
INSERT INTO `sys_logininfor` VALUES (123, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '验证码已失效', '2022-11-30 14:08:22');
INSERT INTO `sys_logininfor` VALUES (124, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-11-30 14:08:32');
INSERT INTO `sys_logininfor` VALUES (125, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 14:23:49');
INSERT INTO `sys_logininfor` VALUES (126, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-11-30 14:23:59');
INSERT INTO `sys_logininfor` VALUES (127, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-11-30 14:24:04');
INSERT INTO `sys_logininfor` VALUES (128, 'admin', '192.168.1.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 14:24:11');
INSERT INTO `sys_logininfor` VALUES (129, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-11-30 14:48:03');
INSERT INTO `sys_logininfor` VALUES (130, 'admin', '192.168.3.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 14:49:28');
INSERT INTO `sys_logininfor` VALUES (131, 'admin', '192.168.3.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 14:50:23');
INSERT INTO `sys_logininfor` VALUES (132, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 14:53:01');
INSERT INTO `sys_logininfor` VALUES (133, 'admin', '192.168.3.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-11-30 15:15:25');
INSERT INTO `sys_logininfor` VALUES (134, 'admin', '192.168.3.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 15:17:00');
INSERT INTO `sys_logininfor` VALUES (135, 'admin', '192.168.3.9', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 16:11:50');
INSERT INTO `sys_logininfor` VALUES (136, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-30 21:10:50');
INSERT INTO `sys_logininfor` VALUES (137, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 14:10:15');
INSERT INTO `sys_logininfor` VALUES (138, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 14:28:16');
INSERT INTO `sys_logininfor` VALUES (139, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 14:28:18');
INSERT INTO `sys_logininfor` VALUES (140, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 14:42:23');
INSERT INTO `sys_logininfor` VALUES (141, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-01 14:49:26');
INSERT INTO `sys_logininfor` VALUES (142, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 17:17:48');
INSERT INTO `sys_logininfor` VALUES (143, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 17:27:32');
INSERT INTO `sys_logininfor` VALUES (144, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-01 17:33:11');
INSERT INTO `sys_logininfor` VALUES (145, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 17:34:38');
INSERT INTO `sys_logininfor` VALUES (146, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-01 17:43:59');
INSERT INTO `sys_logininfor` VALUES (147, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 17:44:01');
INSERT INTO `sys_logininfor` VALUES (148, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 17:44:15');
INSERT INTO `sys_logininfor` VALUES (149, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 17:49:51');
INSERT INTO `sys_logininfor` VALUES (150, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-01 17:49:54');
INSERT INTO `sys_logininfor` VALUES (151, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 17:49:58');
INSERT INTO `sys_logininfor` VALUES (152, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-01 17:50:04');
INSERT INTO `sys_logininfor` VALUES (153, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-01 18:02:51');
INSERT INTO `sys_logininfor` VALUES (154, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-01 18:02:51');
INSERT INTO `sys_logininfor` VALUES (155, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 18:04:10');
INSERT INTO `sys_logininfor` VALUES (156, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-01 20:29:19');
INSERT INTO `sys_logininfor` VALUES (157, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-01 20:58:40');
INSERT INTO `sys_logininfor` VALUES (158, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-01 20:58:42');
INSERT INTO `sys_logininfor` VALUES (159, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 21:10:58');
INSERT INTO `sys_logininfor` VALUES (160, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 21:10:59');
INSERT INTO `sys_logininfor` VALUES (161, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 21:55:39');
INSERT INTO `sys_logininfor` VALUES (162, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-01 22:07:21');
INSERT INTO `sys_logininfor` VALUES (163, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 22:14:21');
INSERT INTO `sys_logininfor` VALUES (164, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 22:14:36');
INSERT INTO `sys_logininfor` VALUES (165, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 22:14:38');
INSERT INTO `sys_logininfor` VALUES (166, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-01 23:33:27');
INSERT INTO `sys_logininfor` VALUES (167, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 00:12:59');
INSERT INTO `sys_logininfor` VALUES (168, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 00:13:10');
INSERT INTO `sys_logininfor` VALUES (169, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 00:42:21');
INSERT INTO `sys_logininfor` VALUES (170, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 00:42:22');
INSERT INTO `sys_logininfor` VALUES (171, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 00:56:12');
INSERT INTO `sys_logininfor` VALUES (172, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 00:56:14');
INSERT INTO `sys_logininfor` VALUES (173, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 01:19:14');
INSERT INTO `sys_logininfor` VALUES (174, 'admin', '192.168.1.11', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 01:19:16');
INSERT INTO `sys_logininfor` VALUES (175, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-02 09:40:52');
INSERT INTO `sys_logininfor` VALUES (176, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 10:22:36');
INSERT INTO `sys_logininfor` VALUES (177, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 11:54:55');
INSERT INTO `sys_logininfor` VALUES (178, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 13:05:15');
INSERT INTO `sys_logininfor` VALUES (179, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 13:05:27');
INSERT INTO `sys_logininfor` VALUES (180, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 13:14:51');
INSERT INTO `sys_logininfor` VALUES (181, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 13:21:08');
INSERT INTO `sys_logininfor` VALUES (182, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 13:32:50');
INSERT INTO `sys_logininfor` VALUES (183, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 13:33:14');
INSERT INTO `sys_logininfor` VALUES (184, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 13:33:43');
INSERT INTO `sys_logininfor` VALUES (185, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 13:35:52');
INSERT INTO `sys_logininfor` VALUES (186, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 13:41:42');
INSERT INTO `sys_logininfor` VALUES (187, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 13:56:36');
INSERT INTO `sys_logininfor` VALUES (188, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 13:56:52');
INSERT INTO `sys_logininfor` VALUES (189, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:05:35');
INSERT INTO `sys_logininfor` VALUES (190, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 14:05:53');
INSERT INTO `sys_logininfor` VALUES (191, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:06:58');
INSERT INTO `sys_logininfor` VALUES (192, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:07:02');
INSERT INTO `sys_logininfor` VALUES (193, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:19:49');
INSERT INTO `sys_logininfor` VALUES (194, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:32:19');
INSERT INTO `sys_logininfor` VALUES (195, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 14:35:31');
INSERT INTO `sys_logininfor` VALUES (196, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:38:06');
INSERT INTO `sys_logininfor` VALUES (197, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:43:00');
INSERT INTO `sys_logininfor` VALUES (198, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 14:43:15');
INSERT INTO `sys_logininfor` VALUES (199, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:43:19');
INSERT INTO `sys_logininfor` VALUES (200, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:43:48');
INSERT INTO `sys_logininfor` VALUES (201, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:49:15');
INSERT INTO `sys_logininfor` VALUES (202, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:49:19');
INSERT INTO `sys_logininfor` VALUES (203, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 14:49:31');
INSERT INTO `sys_logininfor` VALUES (204, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:49:42');
INSERT INTO `sys_logininfor` VALUES (205, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:52:18');
INSERT INTO `sys_logininfor` VALUES (206, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 14:53:35');
INSERT INTO `sys_logininfor` VALUES (207, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-02 14:58:36');
INSERT INTO `sys_logininfor` VALUES (208, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 15:00:02');
INSERT INTO `sys_logininfor` VALUES (209, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 15:04:25');
INSERT INTO `sys_logininfor` VALUES (210, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 15:06:22');
INSERT INTO `sys_logininfor` VALUES (211, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 15:06:22');
INSERT INTO `sys_logininfor` VALUES (212, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 15:06:30');
INSERT INTO `sys_logininfor` VALUES (213, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-02 15:07:31');
INSERT INTO `sys_logininfor` VALUES (214, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-02 15:07:33');
INSERT INTO `sys_logininfor` VALUES (215, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 15:12:43');
INSERT INTO `sys_logininfor` VALUES (216, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 15:12:44');
INSERT INTO `sys_logininfor` VALUES (217, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 15:12:46');
INSERT INTO `sys_logininfor` VALUES (218, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-02 15:13:47');
INSERT INTO `sys_logininfor` VALUES (219, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-02 15:13:52');
INSERT INTO `sys_logininfor` VALUES (220, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-02 15:13:59');
INSERT INTO `sys_logininfor` VALUES (221, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-02 15:14:04');
INSERT INTO `sys_logininfor` VALUES (222, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 15:19:56');
INSERT INTO `sys_logininfor` VALUES (223, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 15:20:07');
INSERT INTO `sys_logininfor` VALUES (224, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 15:20:56');
INSERT INTO `sys_logininfor` VALUES (225, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 15:21:00');
INSERT INTO `sys_logininfor` VALUES (226, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 15:27:03');
INSERT INTO `sys_logininfor` VALUES (227, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 15:27:19');
INSERT INTO `sys_logininfor` VALUES (228, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 15:27:19');
INSERT INTO `sys_logininfor` VALUES (229, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-02 15:28:04');
INSERT INTO `sys_logininfor` VALUES (230, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-02 15:28:51');
INSERT INTO `sys_logininfor` VALUES (231, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-02 15:40:18');
INSERT INTO `sys_logininfor` VALUES (232, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-02 15:40:33');
INSERT INTO `sys_logininfor` VALUES (233, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 15:52:29');
INSERT INTO `sys_logininfor` VALUES (234, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 16:02:15');
INSERT INTO `sys_logininfor` VALUES (235, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 16:02:15');
INSERT INTO `sys_logininfor` VALUES (236, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 16:02:17');
INSERT INTO `sys_logininfor` VALUES (237, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 16:02:22');
INSERT INTO `sys_logininfor` VALUES (238, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 16:16:17');
INSERT INTO `sys_logininfor` VALUES (239, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-02 16:41:24');
INSERT INTO `sys_logininfor` VALUES (240, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 17:01:20');
INSERT INTO `sys_logininfor` VALUES (241, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-02 17:01:59');
INSERT INTO `sys_logininfor` VALUES (242, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-02 17:02:03');
INSERT INTO `sys_logininfor` VALUES (243, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 17:32:10');
INSERT INTO `sys_logininfor` VALUES (244, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 17:38:31');
INSERT INTO `sys_logininfor` VALUES (245, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 17:56:49');
INSERT INTO `sys_logininfor` VALUES (246, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 18:09:12');
INSERT INTO `sys_logininfor` VALUES (247, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 18:09:21');
INSERT INTO `sys_logininfor` VALUES (248, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 18:09:37');
INSERT INTO `sys_logininfor` VALUES (249, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 18:09:49');
INSERT INTO `sys_logininfor` VALUES (250, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 18:13:23');
INSERT INTO `sys_logininfor` VALUES (251, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 18:13:32');
INSERT INTO `sys_logininfor` VALUES (252, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 18:17:42');
INSERT INTO `sys_logininfor` VALUES (253, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 18:28:04');
INSERT INTO `sys_logininfor` VALUES (254, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 18:28:06');
INSERT INTO `sys_logininfor` VALUES (255, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-02 18:30:33');
INSERT INTO `sys_logininfor` VALUES (256, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 18:51:22');
INSERT INTO `sys_logininfor` VALUES (257, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 18:51:22');
INSERT INTO `sys_logininfor` VALUES (258, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 18:51:25');
INSERT INTO `sys_logininfor` VALUES (259, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 18:51:30');
INSERT INTO `sys_logininfor` VALUES (260, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 20:11:10');
INSERT INTO `sys_logininfor` VALUES (261, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 20:19:45');
INSERT INTO `sys_logininfor` VALUES (262, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 21:00:11');
INSERT INTO `sys_logininfor` VALUES (263, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-02 21:29:22');
INSERT INTO `sys_logininfor` VALUES (264, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-03 00:11:50');
INSERT INTO `sys_logininfor` VALUES (265, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-03 00:17:34');
INSERT INTO `sys_logininfor` VALUES (266, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-03 00:56:49');
INSERT INTO `sys_logininfor` VALUES (267, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-03 01:13:41');
INSERT INTO `sys_logininfor` VALUES (268, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-03 01:13:46');
INSERT INTO `sys_logininfor` VALUES (269, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-03 02:40:19');
INSERT INTO `sys_logininfor` VALUES (270, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 02:52:00');
INSERT INTO `sys_logininfor` VALUES (271, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 04:25:01');
INSERT INTO `sys_logininfor` VALUES (272, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 04:40:34');
INSERT INTO `sys_logininfor` VALUES (273, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 04:40:58');
INSERT INTO `sys_logininfor` VALUES (274, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 05:41:30');
INSERT INTO `sys_logininfor` VALUES (275, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 05:49:29');
INSERT INTO `sys_logininfor` VALUES (276, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 05:49:40');
INSERT INTO `sys_logininfor` VALUES (277, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 05:49:45');
INSERT INTO `sys_logininfor` VALUES (278, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 05:49:48');
INSERT INTO `sys_logininfor` VALUES (279, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 05:50:16');
INSERT INTO `sys_logininfor` VALUES (280, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 05:50:18');
INSERT INTO `sys_logininfor` VALUES (281, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 10:07:33');
INSERT INTO `sys_logininfor` VALUES (282, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 12:58:00');
INSERT INTO `sys_logininfor` VALUES (283, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 13:23:37');
INSERT INTO `sys_logininfor` VALUES (284, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 13:23:38');
INSERT INTO `sys_logininfor` VALUES (285, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 13:30:35');
INSERT INTO `sys_logininfor` VALUES (286, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 13:30:41');
INSERT INTO `sys_logininfor` VALUES (287, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 14:04:47');
INSERT INTO `sys_logininfor` VALUES (288, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-03 14:17:10');
INSERT INTO `sys_logininfor` VALUES (289, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 14:22:30');
INSERT INTO `sys_logininfor` VALUES (290, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 14:32:59');
INSERT INTO `sys_logininfor` VALUES (291, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-03 14:37:18');
INSERT INTO `sys_logininfor` VALUES (292, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-03 14:37:19');
INSERT INTO `sys_logininfor` VALUES (293, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 14:41:13');
INSERT INTO `sys_logininfor` VALUES (294, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 14:44:55');
INSERT INTO `sys_logininfor` VALUES (295, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 14:44:55');
INSERT INTO `sys_logininfor` VALUES (296, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 14:59:58');
INSERT INTO `sys_logininfor` VALUES (297, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:00:04');
INSERT INTO `sys_logininfor` VALUES (298, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:00:05');
INSERT INTO `sys_logininfor` VALUES (299, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:09:48');
INSERT INTO `sys_logininfor` VALUES (300, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-03 15:09:57');
INSERT INTO `sys_logininfor` VALUES (301, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:11:00');
INSERT INTO `sys_logininfor` VALUES (302, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:16:57');
INSERT INTO `sys_logininfor` VALUES (303, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:32:50');
INSERT INTO `sys_logininfor` VALUES (304, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:34:02');
INSERT INTO `sys_logininfor` VALUES (305, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:35:51');
INSERT INTO `sys_logininfor` VALUES (306, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:46:56');
INSERT INTO `sys_logininfor` VALUES (307, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 15:47:03');
INSERT INTO `sys_logininfor` VALUES (308, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:47:09');
INSERT INTO `sys_logininfor` VALUES (309, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:47:15');
INSERT INTO `sys_logininfor` VALUES (310, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:59:06');
INSERT INTO `sys_logininfor` VALUES (311, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 15:59:08');
INSERT INTO `sys_logininfor` VALUES (312, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 16:28:14');
INSERT INTO `sys_logininfor` VALUES (313, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 16:28:17');
INSERT INTO `sys_logininfor` VALUES (314, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 17:30:44');
INSERT INTO `sys_logininfor` VALUES (315, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 17:35:16');
INSERT INTO `sys_logininfor` VALUES (316, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 18:00:53');
INSERT INTO `sys_logininfor` VALUES (317, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 18:00:54');
INSERT INTO `sys_logininfor` VALUES (318, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 18:01:09');
INSERT INTO `sys_logininfor` VALUES (319, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 18:09:40');
INSERT INTO `sys_logininfor` VALUES (320, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 18:09:40');
INSERT INTO `sys_logininfor` VALUES (321, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 18:09:52');
INSERT INTO `sys_logininfor` VALUES (322, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 18:09:56');
INSERT INTO `sys_logininfor` VALUES (323, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 18:16:37');
INSERT INTO `sys_logininfor` VALUES (324, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 18:16:45');
INSERT INTO `sys_logininfor` VALUES (325, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 18:19:15');
INSERT INTO `sys_logininfor` VALUES (326, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 18:33:08');
INSERT INTO `sys_logininfor` VALUES (327, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-03 19:15:53');
INSERT INTO `sys_logininfor` VALUES (328, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 19:47:22');
INSERT INTO `sys_logininfor` VALUES (329, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 19:47:39');
INSERT INTO `sys_logininfor` VALUES (330, 'admin', '172.31.51.97', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 19:55:26');
INSERT INTO `sys_logininfor` VALUES (331, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-03 20:45:54');
INSERT INTO `sys_logininfor` VALUES (332, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 20:48:43');
INSERT INTO `sys_logininfor` VALUES (333, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 20:52:42');
INSERT INTO `sys_logininfor` VALUES (334, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 23:36:07');
INSERT INTO `sys_logininfor` VALUES (335, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 23:47:04');
INSERT INTO `sys_logininfor` VALUES (336, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 23:47:07');
INSERT INTO `sys_logininfor` VALUES (337, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 23:47:44');
INSERT INTO `sys_logininfor` VALUES (338, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 00:02:19');
INSERT INTO `sys_logininfor` VALUES (339, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 00:03:13');
INSERT INTO `sys_logininfor` VALUES (340, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 00:12:39');
INSERT INTO `sys_logininfor` VALUES (341, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 00:12:43');
INSERT INTO `sys_logininfor` VALUES (342, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 00:13:01');
INSERT INTO `sys_logininfor` VALUES (343, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 00:18:55');
INSERT INTO `sys_logininfor` VALUES (344, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 00:19:06');
INSERT INTO `sys_logininfor` VALUES (345, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 00:40:42');
INSERT INTO `sys_logininfor` VALUES (346, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 00:40:50');
INSERT INTO `sys_logininfor` VALUES (347, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 00:40:56');
INSERT INTO `sys_logininfor` VALUES (348, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 00:49:12');
INSERT INTO `sys_logininfor` VALUES (349, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 00:49:17');
INSERT INTO `sys_logininfor` VALUES (350, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 00:49:28');
INSERT INTO `sys_logininfor` VALUES (351, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 01:13:43');
INSERT INTO `sys_logininfor` VALUES (352, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 01:13:46');
INSERT INTO `sys_logininfor` VALUES (353, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 01:14:02');
INSERT INTO `sys_logininfor` VALUES (354, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 01:18:58');
INSERT INTO `sys_logininfor` VALUES (355, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 01:38:22');
INSERT INTO `sys_logininfor` VALUES (356, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 01:38:23');
INSERT INTO `sys_logininfor` VALUES (357, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 01:40:28');
INSERT INTO `sys_logininfor` VALUES (358, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 01:43:41');
INSERT INTO `sys_logininfor` VALUES (359, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 01:48:50');
INSERT INTO `sys_logininfor` VALUES (360, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 01:48:50');
INSERT INTO `sys_logininfor` VALUES (361, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 01:48:53');
INSERT INTO `sys_logininfor` VALUES (362, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 03:48:59');
INSERT INTO `sys_logininfor` VALUES (363, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 04:11:41');
INSERT INTO `sys_logininfor` VALUES (364, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-04 04:11:46');
INSERT INTO `sys_logininfor` VALUES (365, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 04:11:48');
INSERT INTO `sys_logininfor` VALUES (366, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 04:23:10');
INSERT INTO `sys_logininfor` VALUES (367, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 04:23:14');
INSERT INTO `sys_logininfor` VALUES (368, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 04:23:22');
INSERT INTO `sys_logininfor` VALUES (369, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-04 04:23:25');
INSERT INTO `sys_logininfor` VALUES (370, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 04:40:02');
INSERT INTO `sys_logininfor` VALUES (371, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-04 04:40:16');
INSERT INTO `sys_logininfor` VALUES (372, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 05:11:23');
INSERT INTO `sys_logininfor` VALUES (373, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 09:48:15');
INSERT INTO `sys_logininfor` VALUES (374, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 11:04:36');
INSERT INTO `sys_logininfor` VALUES (375, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 11:22:02');
INSERT INTO `sys_logininfor` VALUES (376, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 12:01:20');
INSERT INTO `sys_logininfor` VALUES (377, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 12:22:56');
INSERT INTO `sys_logininfor` VALUES (378, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 13:08:55');
INSERT INTO `sys_logininfor` VALUES (379, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 13:29:10');
INSERT INTO `sys_logininfor` VALUES (380, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 13:40:16');
INSERT INTO `sys_logininfor` VALUES (381, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 13:44:48');
INSERT INTO `sys_logininfor` VALUES (382, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 13:47:55');
INSERT INTO `sys_logininfor` VALUES (383, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 13:47:59');
INSERT INTO `sys_logininfor` VALUES (384, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 13:48:06');
INSERT INTO `sys_logininfor` VALUES (385, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 13:59:53');
INSERT INTO `sys_logininfor` VALUES (386, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:04:13');
INSERT INTO `sys_logininfor` VALUES (387, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 14:04:23');
INSERT INTO `sys_logininfor` VALUES (388, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:04:24');
INSERT INTO `sys_logininfor` VALUES (389, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:05:07');
INSERT INTO `sys_logininfor` VALUES (390, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:08:01');
INSERT INTO `sys_logininfor` VALUES (391, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 14:08:13');
INSERT INTO `sys_logininfor` VALUES (392, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:08:15');
INSERT INTO `sys_logininfor` VALUES (393, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 14:21:18');
INSERT INTO `sys_logininfor` VALUES (394, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:32:42');
INSERT INTO `sys_logininfor` VALUES (395, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:32:53');
INSERT INTO `sys_logininfor` VALUES (396, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:32:53');
INSERT INTO `sys_logininfor` VALUES (397, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 14:32:57');
INSERT INTO `sys_logininfor` VALUES (398, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 14:33:16');
INSERT INTO `sys_logininfor` VALUES (399, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:33:31');
INSERT INTO `sys_logininfor` VALUES (400, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:33:33');
INSERT INTO `sys_logininfor` VALUES (401, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:39:49');
INSERT INTO `sys_logininfor` VALUES (402, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:39:55');
INSERT INTO `sys_logininfor` VALUES (403, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:40:03');
INSERT INTO `sys_logininfor` VALUES (404, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 14:40:04');
INSERT INTO `sys_logininfor` VALUES (405, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 14:49:08');
INSERT INTO `sys_logininfor` VALUES (406, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:52:28');
INSERT INTO `sys_logininfor` VALUES (407, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 14:52:42');
INSERT INTO `sys_logininfor` VALUES (408, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 15:20:41');
INSERT INTO `sys_logininfor` VALUES (409, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 15:22:41');
INSERT INTO `sys_logininfor` VALUES (410, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 15:29:19');
INSERT INTO `sys_logininfor` VALUES (411, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 15:29:25');
INSERT INTO `sys_logininfor` VALUES (412, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 15:32:11');
INSERT INTO `sys_logininfor` VALUES (413, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 15:47:11');
INSERT INTO `sys_logininfor` VALUES (414, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 15:47:19');
INSERT INTO `sys_logininfor` VALUES (415, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 15:47:23');
INSERT INTO `sys_logininfor` VALUES (416, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 15:47:26');
INSERT INTO `sys_logininfor` VALUES (417, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 15:56:08');
INSERT INTO `sys_logininfor` VALUES (418, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 15:56:12');
INSERT INTO `sys_logininfor` VALUES (419, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 15:56:20');
INSERT INTO `sys_logininfor` VALUES (420, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 15:56:21');
INSERT INTO `sys_logininfor` VALUES (421, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 15:57:51');
INSERT INTO `sys_logininfor` VALUES (422, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 15:57:53');
INSERT INTO `sys_logininfor` VALUES (423, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 16:10:59');
INSERT INTO `sys_logininfor` VALUES (424, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 16:11:07');
INSERT INTO `sys_logininfor` VALUES (425, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 16:11:09');
INSERT INTO `sys_logininfor` VALUES (426, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 16:21:00');
INSERT INTO `sys_logininfor` VALUES (427, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 16:39:22');
INSERT INTO `sys_logininfor` VALUES (428, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 17:20:52');
INSERT INTO `sys_logininfor` VALUES (429, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-04 17:25:49');
INSERT INTO `sys_logininfor` VALUES (430, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 17:25:52');
INSERT INTO `sys_logininfor` VALUES (431, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 17:26:02');
INSERT INTO `sys_logininfor` VALUES (432, 'admin', '192.168.31.156', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-04 17:44:52');
INSERT INTO `sys_logininfor` VALUES (433, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 18:19:45');
INSERT INTO `sys_logininfor` VALUES (434, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 18:29:38');
INSERT INTO `sys_logininfor` VALUES (435, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 18:44:36');
INSERT INTO `sys_logininfor` VALUES (436, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 18:58:51');
INSERT INTO `sys_logininfor` VALUES (437, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 19:17:33');
INSERT INTO `sys_logininfor` VALUES (438, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 19:18:00');
INSERT INTO `sys_logininfor` VALUES (439, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 19:31:36');
INSERT INTO `sys_logininfor` VALUES (440, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 19:50:32');
INSERT INTO `sys_logininfor` VALUES (441, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 19:51:23');
INSERT INTO `sys_logininfor` VALUES (442, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 19:55:51');
INSERT INTO `sys_logininfor` VALUES (443, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 19:58:19');
INSERT INTO `sys_logininfor` VALUES (444, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 19:58:19');
INSERT INTO `sys_logininfor` VALUES (445, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 19:58:25');
INSERT INTO `sys_logininfor` VALUES (446, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 19:59:20');
INSERT INTO `sys_logininfor` VALUES (447, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 19:59:23');
INSERT INTO `sys_logininfor` VALUES (448, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 19:59:39');
INSERT INTO `sys_logininfor` VALUES (449, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 20:02:12');
INSERT INTO `sys_logininfor` VALUES (450, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:06:06');
INSERT INTO `sys_logininfor` VALUES (451, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:06:16');
INSERT INTO `sys_logininfor` VALUES (452, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:06:23');
INSERT INTO `sys_logininfor` VALUES (453, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:07:54');
INSERT INTO `sys_logininfor` VALUES (454, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:08:02');
INSERT INTO `sys_logininfor` VALUES (455, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 20:08:12');
INSERT INTO `sys_logininfor` VALUES (456, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:08:53');
INSERT INTO `sys_logininfor` VALUES (457, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:09:00');
INSERT INTO `sys_logininfor` VALUES (458, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 20:22:47');
INSERT INTO `sys_logininfor` VALUES (459, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:22:48');
INSERT INTO `sys_logininfor` VALUES (460, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:22:49');
INSERT INTO `sys_logininfor` VALUES (461, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:27:43');
INSERT INTO `sys_logininfor` VALUES (462, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 20:27:47');
INSERT INTO `sys_logininfor` VALUES (463, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:27:55');
INSERT INTO `sys_logininfor` VALUES (464, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-04 20:30:51');
INSERT INTO `sys_logininfor` VALUES (465, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 20:30:56');
INSERT INTO `sys_logininfor` VALUES (466, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:40:50');
INSERT INTO `sys_logininfor` VALUES (467, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:40:50');
INSERT INTO `sys_logininfor` VALUES (468, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:40:50');
INSERT INTO `sys_logininfor` VALUES (469, 'admin', '192.168.1.106', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:42:36');
INSERT INTO `sys_logininfor` VALUES (470, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:42:57');
INSERT INTO `sys_logininfor` VALUES (471, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:43:44');
INSERT INTO `sys_logininfor` VALUES (472, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 20:47:10');
INSERT INTO `sys_logininfor` VALUES (473, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 21:09:20');
INSERT INTO `sys_logininfor` VALUES (474, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-04 21:10:30');
INSERT INTO `sys_logininfor` VALUES (475, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 22:18:32');
INSERT INTO `sys_logininfor` VALUES (476, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 22:34:03');
INSERT INTO `sys_logininfor` VALUES (477, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 22:34:05');
INSERT INTO `sys_logininfor` VALUES (478, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 22:34:07');
INSERT INTO `sys_logininfor` VALUES (479, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 22:34:09');
INSERT INTO `sys_logininfor` VALUES (480, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 23:10:36');
INSERT INTO `sys_logininfor` VALUES (481, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 23:30:32');
INSERT INTO `sys_logininfor` VALUES (482, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 23:31:03');
INSERT INTO `sys_logininfor` VALUES (483, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 23:41:25');
INSERT INTO `sys_logininfor` VALUES (484, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 23:41:39');
INSERT INTO `sys_logininfor` VALUES (485, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-04 23:59:30');
INSERT INTO `sys_logininfor` VALUES (486, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-04 23:59:33');
INSERT INTO `sys_logininfor` VALUES (487, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-05 00:27:07');
INSERT INTO `sys_logininfor` VALUES (488, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 00:28:19');
INSERT INTO `sys_logininfor` VALUES (489, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-05 00:32:20');
INSERT INTO `sys_logininfor` VALUES (490, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 00:32:22');
INSERT INTO `sys_logininfor` VALUES (491, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 00:34:07');
INSERT INTO `sys_logininfor` VALUES (492, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-05 00:56:16');
INSERT INTO `sys_logininfor` VALUES (493, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 01:46:04');
INSERT INTO `sys_logininfor` VALUES (494, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 01:54:48');
INSERT INTO `sys_logininfor` VALUES (495, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 01:54:52');
INSERT INTO `sys_logininfor` VALUES (496, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-05 01:54:53');
INSERT INTO `sys_logininfor` VALUES (497, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 01:54:59');
INSERT INTO `sys_logininfor` VALUES (498, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 02:08:35');
INSERT INTO `sys_logininfor` VALUES (499, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 02:14:52');
INSERT INTO `sys_logininfor` VALUES (500, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-05 02:15:04');
INSERT INTO `sys_logininfor` VALUES (501, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 02:15:07');
INSERT INTO `sys_logininfor` VALUES (502, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 09:49:30');
INSERT INTO `sys_logininfor` VALUES (503, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 10:27:11');
INSERT INTO `sys_logininfor` VALUES (504, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 10:41:05');
INSERT INTO `sys_logininfor` VALUES (505, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 11:24:30');
INSERT INTO `sys_logininfor` VALUES (506, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 12:35:29');
INSERT INTO `sys_logininfor` VALUES (507, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 13:12:03');
INSERT INTO `sys_logininfor` VALUES (508, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-05 13:24:33');
INSERT INTO `sys_logininfor` VALUES (509, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 13:24:36');
INSERT INTO `sys_logininfor` VALUES (510, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-05 13:31:12');
INSERT INTO `sys_logininfor` VALUES (511, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 13:31:13');
INSERT INTO `sys_logininfor` VALUES (512, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-05 13:45:23');
INSERT INTO `sys_logininfor` VALUES (513, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 13:45:26');
INSERT INTO `sys_logininfor` VALUES (514, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 13:45:38');
INSERT INTO `sys_logininfor` VALUES (515, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 13:45:50');
INSERT INTO `sys_logininfor` VALUES (516, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 14:06:55');
INSERT INTO `sys_logininfor` VALUES (517, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-05 14:18:34');
INSERT INTO `sys_logininfor` VALUES (518, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-05 14:22:21');
INSERT INTO `sys_logininfor` VALUES (519, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 14:22:25');
INSERT INTO `sys_logininfor` VALUES (520, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 14:30:49');
INSERT INTO `sys_logininfor` VALUES (521, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 15:00:53');
INSERT INTO `sys_logininfor` VALUES (522, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 15:49:00');
INSERT INTO `sys_logininfor` VALUES (523, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 17:24:50');
INSERT INTO `sys_logininfor` VALUES (524, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 17:24:50');
INSERT INTO `sys_logininfor` VALUES (525, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 17:38:39');
INSERT INTO `sys_logininfor` VALUES (526, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 18:41:13');
INSERT INTO `sys_logininfor` VALUES (527, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-05 18:47:11');
INSERT INTO `sys_logininfor` VALUES (528, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 20:08:17');
INSERT INTO `sys_logininfor` VALUES (529, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-05 20:11:56');
INSERT INTO `sys_logininfor` VALUES (530, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-05 20:20:59');
INSERT INTO `sys_logininfor` VALUES (531, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 20:21:11');
INSERT INTO `sys_logininfor` VALUES (532, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 20:21:45');
INSERT INTO `sys_logininfor` VALUES (533, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-05 20:51:39');
INSERT INTO `sys_logininfor` VALUES (534, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-05 20:52:04');
INSERT INTO `sys_logininfor` VALUES (535, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 21:02:08');
INSERT INTO `sys_logininfor` VALUES (536, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 21:04:42');
INSERT INTO `sys_logininfor` VALUES (537, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 21:23:24');
INSERT INTO `sys_logininfor` VALUES (538, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-06 09:04:46');
INSERT INTO `sys_logininfor` VALUES (539, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 10:30:17');
INSERT INTO `sys_logininfor` VALUES (540, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 10:35:05');
INSERT INTO `sys_logininfor` VALUES (541, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-06 10:40:38');
INSERT INTO `sys_logininfor` VALUES (542, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 11:23:58');
INSERT INTO `sys_logininfor` VALUES (543, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 12:44:17');
INSERT INTO `sys_logininfor` VALUES (544, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 14:45:41');
INSERT INTO `sys_logininfor` VALUES (545, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 14:47:21');
INSERT INTO `sys_logininfor` VALUES (546, 'admin', '172.16.58.100', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 14:50:45');
INSERT INTO `sys_logininfor` VALUES (547, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-06 14:54:18');
INSERT INTO `sys_logininfor` VALUES (548, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 14:54:25');
INSERT INTO `sys_logininfor` VALUES (549, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 14:54:34');
INSERT INTO `sys_logininfor` VALUES (550, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 14:56:24');
INSERT INTO `sys_logininfor` VALUES (551, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-06 15:10:36');
INSERT INTO `sys_logininfor` VALUES (552, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-06 15:16:34');
INSERT INTO `sys_logininfor` VALUES (553, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 15:26:13');
INSERT INTO `sys_logininfor` VALUES (554, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 15:26:25');
INSERT INTO `sys_logininfor` VALUES (555, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 15:26:28');
INSERT INTO `sys_logininfor` VALUES (556, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 15:31:05');
INSERT INTO `sys_logininfor` VALUES (557, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-06 15:39:22');
INSERT INTO `sys_logininfor` VALUES (558, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 15:39:24');
INSERT INTO `sys_logininfor` VALUES (559, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 15:39:28');
INSERT INTO `sys_logininfor` VALUES (560, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 15:39:36');
INSERT INTO `sys_logininfor` VALUES (561, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 15:43:41');
INSERT INTO `sys_logininfor` VALUES (562, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 15:44:36');
INSERT INTO `sys_logininfor` VALUES (563, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-06 15:57:43');
INSERT INTO `sys_logininfor` VALUES (564, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 15:58:46');
INSERT INTO `sys_logininfor` VALUES (565, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 15:58:50');
INSERT INTO `sys_logininfor` VALUES (566, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-06 15:58:59');
INSERT INTO `sys_logininfor` VALUES (567, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-06 16:13:20');
INSERT INTO `sys_logininfor` VALUES (568, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 16:13:24');
INSERT INTO `sys_logininfor` VALUES (569, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 16:13:31');
INSERT INTO `sys_logininfor` VALUES (570, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 16:13:38');
INSERT INTO `sys_logininfor` VALUES (571, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 16:14:56');
INSERT INTO `sys_logininfor` VALUES (572, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 16:36:06');
INSERT INTO `sys_logininfor` VALUES (573, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-06 16:50:00');
INSERT INTO `sys_logininfor` VALUES (574, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 16:50:05');
INSERT INTO `sys_logininfor` VALUES (575, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-06 17:04:47');
INSERT INTO `sys_logininfor` VALUES (576, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 17:04:50');
INSERT INTO `sys_logininfor` VALUES (577, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-06 17:06:14');
INSERT INTO `sys_logininfor` VALUES (578, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 17:06:17');
INSERT INTO `sys_logininfor` VALUES (579, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 17:09:28');
INSERT INTO `sys_logininfor` VALUES (580, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 17:14:35');
INSERT INTO `sys_logininfor` VALUES (581, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 17:15:37');
INSERT INTO `sys_logininfor` VALUES (582, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 17:16:02');
INSERT INTO `sys_logininfor` VALUES (583, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 18:17:29');
INSERT INTO `sys_logininfor` VALUES (584, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-06 19:00:01');
INSERT INTO `sys_logininfor` VALUES (585, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 19:14:59');
INSERT INTO `sys_logininfor` VALUES (586, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 20:27:17');
INSERT INTO `sys_logininfor` VALUES (587, 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2022-12-06 23:05:16');
INSERT INTO `sys_logininfor` VALUES (588, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-07 08:59:14');
INSERT INTO `sys_logininfor` VALUES (589, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-07 09:51:10');
INSERT INTO `sys_logininfor` VALUES (590, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-07 10:21:37');
INSERT INTO `sys_logininfor` VALUES (591, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-07 10:41:34');
INSERT INTO `sys_logininfor` VALUES (592, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-07 11:15:15');
INSERT INTO `sys_logininfor` VALUES (593, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-07 12:33:19');
INSERT INTO `sys_logininfor` VALUES (594, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-07 13:01:46');
INSERT INTO `sys_logininfor` VALUES (595, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-07 13:04:55');
INSERT INTO `sys_logininfor` VALUES (596, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-07 13:52:16');
INSERT INTO `sys_logininfor` VALUES (597, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-07 14:00:12');
INSERT INTO `sys_logininfor` VALUES (598, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2022-12-07 14:21:33');
INSERT INTO `sys_logininfor` VALUES (599, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-07 14:21:36');
INSERT INTO `sys_logininfor` VALUES (600, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-07 15:09:36');
INSERT INTO `sys_logininfor` VALUES (601, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-07 15:26:17');
INSERT INTO `sys_logininfor` VALUES (602, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-07 18:45:31');
INSERT INTO `sys_logininfor` VALUES (603, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-07 19:56:26');
INSERT INTO `sys_logininfor` VALUES (604, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-07 20:26:54');
INSERT INTO `sys_logininfor` VALUES (605, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-07 21:06:26');
INSERT INTO `sys_logininfor` VALUES (606, 'admin', '172.16.44.148', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-07 21:19:58');
INSERT INTO `sys_logininfor` VALUES (607, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-12-07 21:21:51');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由参数',
  `is_frame` int(1) NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int(1) NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2018 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, 'system', NULL, '', 1, 0, 'M', '0', '0', '', 'system', 'admin', '2022-11-29 20:36:32', '', NULL, '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 2, 'monitor', NULL, '', 1, 0, 'M', '1', '0', '', 'monitor', 'admin', '2022-11-29 20:36:32', 'admin', '2022-11-29 21:39:31', '系统监控目录');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 3, 'tool', NULL, '', 1, 0, 'M', '0', '0', '', 'tool', 'admin', '2022-11-29 20:36:32', '', NULL, '系统工具目录');
INSERT INTO `sys_menu` VALUES (4, '若依官网', 0, 4, 'http://ruoyi.vip', NULL, '', 0, 0, 'M', '1', '0', '', 'guide', 'admin', '2022-11-29 20:36:32', 'admin', '2022-11-29 21:39:13', '若依官网地址');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', '', 1, 0, 'C', '0', '0', 'system:user:list', 'user', 'admin', '2022-11-29 20:36:32', '', NULL, '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', '', 1, 0, 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2022-11-29 20:36:32', '', NULL, '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', '', 1, 0, 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2022-11-29 20:36:32', '', NULL, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', '', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2022-11-29 20:36:32', '', NULL, '部门管理菜单');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', '', 1, 0, 'C', '0', '0', 'system:post:list', 'post', 'admin', '2022-11-29 20:36:32', '', NULL, '岗位管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2022-11-29 20:36:32', '', NULL, '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2022-11-29 20:36:32', '', NULL, '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2022-11-29 20:36:32', '', NULL, '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', '2022-11-29 20:36:32', '', NULL, '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2022-11-29 20:36:32', '', NULL, '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 2, 'job', 'monitor/job/index', '', 1, 0, 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2022-11-29 20:36:32', '', NULL, '定时任务菜单');
INSERT INTO `sys_menu` VALUES (111, '数据监控', 2, 3, 'druid', 'monitor/druid/index', '', 1, 0, 'C', '0', '0', 'monitor:druid:list', 'druid', 'admin', '2022-11-29 20:36:32', '', NULL, '数据监控菜单');
INSERT INTO `sys_menu` VALUES (112, '服务监控', 2, 4, 'server', 'monitor/server/index', '', 1, 0, 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2022-11-29 20:36:32', '', NULL, '服务监控菜单');
INSERT INTO `sys_menu` VALUES (113, '缓存监控', 2, 5, 'cache', 'monitor/cache/index', '', 1, 0, 'C', '0', '0', 'monitor:cache:list', 'redis', 'admin', '2022-11-29 20:36:32', '', NULL, '缓存监控菜单');
INSERT INTO `sys_menu` VALUES (114, '缓存列表', 2, 6, 'cacheList', 'monitor/cache/list', '', 1, 0, 'C', '0', '0', 'monitor:cache:list', 'redis-list', 'admin', '2022-11-29 20:36:32', '', NULL, '缓存列表菜单');
INSERT INTO `sys_menu` VALUES (115, '表单构建', 3, 1, 'build', 'tool/build/index', '', 1, 0, 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2022-11-29 20:36:32', '', NULL, '表单构建菜单');
INSERT INTO `sys_menu` VALUES (116, '代码生成', 3, 2, 'gen', 'tool/gen/index', '', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2022-11-29 20:36:32', '', NULL, '代码生成菜单');
INSERT INTO `sys_menu` VALUES (117, '系统接口', 3, 3, 'swagger', 'tool/swagger/index', '', 1, 0, 'C', '0', '0', 'tool:swagger:list', 'swagger', 'admin', '2022-11-29 20:36:32', '', NULL, '系统接口菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, 'operlog', 'monitor/operlog/index', '', 1, 0, 'C', '0', '0', 'monitor:operlog:list', 'form', 'admin', '2022-11-29 20:36:32', '', NULL, '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, 'logininfor', 'monitor/logininfor/index', '', 1, 0, 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', 'admin', '2022-11-29 20:36:32', '', NULL, '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1000, '用户查询', 100, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1001, '用户新增', 100, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1002, '用户修改', 100, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1003, '用户删除', 100, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1004, '用户导出', 100, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1005, '用户导入', 100, 6, '', '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1006, '重置密码', 100, 7, '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1007, '角色查询', 101, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1008, '角色新增', 101, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1009, '角色修改', 101, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1010, '角色删除', 101, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1011, '角色导出', 101, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1012, '菜单查询', 102, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1013, '菜单新增', 102, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1014, '菜单修改', 102, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1015, '菜单删除', 102, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1016, '部门查询', 103, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1017, '部门新增', 103, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1018, '部门修改', 103, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1019, '部门删除', 103, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1020, '岗位查询', 104, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1021, '岗位新增', 104, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1022, '岗位修改', 104, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1023, '岗位删除', 104, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1024, '岗位导出', 104, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1025, '字典查询', 105, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1026, '字典新增', 105, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1027, '字典修改', 105, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1028, '字典删除', 105, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1029, '字典导出', 105, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1030, '参数查询', 106, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1031, '参数新增', 106, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1032, '参数修改', 106, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1033, '参数删除', 106, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1034, '参数导出', 106, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1035, '公告查询', 107, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1036, '公告新增', 107, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1037, '公告修改', 107, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1038, '公告删除', 107, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1039, '操作查询', 500, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1040, '操作删除', 500, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1041, '日志导出', 500, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:export', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1042, '登录查询', 501, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1043, '登录删除', 501, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1044, '日志导出', 501, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1045, '账户解锁', 501, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:unlock', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, 5, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1054, '任务导出', 110, 6, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1055, '生成查询', 116, 1, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1056, '生成修改', 116, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1057, '生成删除', 116, 3, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1058, '导入代码', 116, 4, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1059, '预览代码', 116, 5, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1060, '生成代码', 116, 6, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2000, '问题规律分析', 0, 3, 'problemAnalysis', 'problemAnalysis', NULL, 1, 0, 'C', '0', '0', '', '#', 'admin', '2022-11-29 21:27:50', 'admin', '2022-11-29 21:29:11', '');
INSERT INTO `sys_menu` VALUES (2001, '质量问题相关变更展示', 0, 4, 'problemChange', 'problemChange', NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-11-29 21:31:14', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2002, '数据录入', 0, 5, 'inputExcel', NULL, NULL, 1, 0, 'M', '0', '0', NULL, '#', 'admin', '2022-11-29 21:32:38', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2003, '数据录入管理', 2002, 1, 'inputExcel', 'inputExcel/index', NULL, 1, 0, 'C', '0', '0', '', '#', 'admin', '2022-11-29 21:34:51', 'admin', '2022-12-02 15:07:36', '');
INSERT INTO `sys_menu` VALUES (2004, '原因推测分析', 0, 6, 'reasoninference', 'reasoninference/reasoninference', NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-11-29 21:37:37', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2005, '变更项管理', 0, 7, 'change', 'change/change', NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-11-29 21:38:31', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2006, '产品设计数据导入', 2002, 4, 'input3', 'inputExcel/input/input3', NULL, 1, 0, 'C', '1', '0', '', '#', 'admin', '2022-11-30 13:37:19', 'admin', '2022-11-30 14:31:28', '');
INSERT INTO `sys_menu` VALUES (2007, '装备设计/改型数据', 2002, 3, 'input2', 'inputExcel/input/input2', NULL, 1, 0, 'C', '1', '0', NULL, '#', 'admin', '2022-11-30 14:33:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2008, '质量问题数据', 2002, 2, 'inputQuality', 'inputExcel/inputQuality', NULL, 1, 0, 'C', '1', '0', NULL, '#', 'admin', '2022-11-30 14:34:56', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2009, '产品改型数据', 2002, 5, 'input4', 'inputExcel/input/input4', NULL, 1, 0, 'C', '1', '0', '', '#', 'admin', '2022-11-30 14:36:04', 'admin', '2022-11-30 14:43:53', '');
INSERT INTO `sys_menu` VALUES (2010, '装备制造数据', 2002, 6, 'input5', 'inputExcel/input/input5', NULL, 1, 0, 'C', '1', '0', NULL, '#', 'admin', '2022-11-30 14:36:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2011, '产品制造变更数据', 2002, 7, 'input6', 'inputExcel/input/input6', NULL, 1, 0, 'C', '1', '0', NULL, '#', 'admin', '2022-11-30 14:37:48', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2012, '产品生产数量', 2002, 8, 'input9', 'inputExcel/input/input9', NULL, 1, 0, 'C', '1', '0', '', '#', 'admin', '2022-11-30 14:38:56', 'admin', '2022-11-30 14:44:01', '');
INSERT INTO `sys_menu` VALUES (2013, '维修变更数据', 2002, 9, 'input10', 'inputExcel/input/input10', NULL, 1, 0, 'C', '1', '0', '', '#', 'admin', '2022-11-30 14:40:16', 'admin', '2022-11-30 14:44:09', '');
INSERT INTO `sys_menu` VALUES (2014, '装备部署数据', 2002, 10, 'input11', 'inputExcel/input/input11', NULL, 1, 0, 'C', '1', '0', NULL, '#', 'admin', '2022-11-30 14:41:39', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2015, '装备使用数据', 2002, 11, 'input12', 'inputExcel/input/input12', NULL, 1, 0, 'C', '1', '0', NULL, '#', 'admin', '2022-11-30 14:42:22', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2016, '数据分析-1', 0, 10, 'firstCountAnalysis', 'firstCountAnalysis/index.vue', NULL, 1, 0, 'C', '0', '0', '', '#', 'admin', '2022-12-03 20:47:39', 'admin', '2022-12-04 19:37:02', '');
INSERT INTO `sys_menu` VALUES (2017, '原因分析汇总', 0, 11, 'changeAnalysis', 'change/analysis', NULL, 1, 0, 'C', '0', '0', '', '#', 'admin', '2022-12-07 14:00:51', 'admin', '2022-12-07 14:01:56', '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, '温馨提醒：2018-07-01 若依新版本发布啦', '2', 0xE696B0E78988E69CACE58685E5AEB9, '0', 'admin', '2022-11-29 20:36:33', '', NULL, '管理员');
INSERT INTO `sys_notice` VALUES (2, '维护通知：2018-07-01 若依系统凌晨维护', '1', 0xE7BBB4E68AA4E58685E5AEB9, '0', 'admin', '2022-11-29 20:36:33', '', NULL, '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int(1) NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 255 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES (100, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"问题规律分析\",\"menuType\":\"M\",\"orderNum\":3,\"params\":{},\"parentId\":0,\"path\":\"problemAnalysis\",\"status\":\"0\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-29 21:27:50');
INSERT INTO `sys_oper_log` VALUES (101, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"problemAnalysis\",\"createTime\":\"2022-11-29 21:27:50\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2000,\"menuName\":\"问题规律分析\",\"menuType\":\"C\",\"orderNum\":3,\"params\":{},\"parentId\":0,\"path\":\"problemAnalysis\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-29 21:29:11');
INSERT INTO `sys_oper_log` VALUES (102, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"problemChange\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"质量问题相关变更展示\",\"menuType\":\"C\",\"orderNum\":4,\"params\":{},\"parentId\":0,\"path\":\"problemChange\",\"status\":\"0\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-29 21:31:14');
INSERT INTO `sys_oper_log` VALUES (103, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"数据录入\",\"menuType\":\"M\",\"orderNum\":5,\"params\":{},\"parentId\":0,\"path\":\"inputExcel\",\"status\":\"0\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-29 21:32:38');
INSERT INTO `sys_oper_log` VALUES (104, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"inputExcel/index\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"数据1\",\"menuType\":\"C\",\"orderNum\":1,\"params\":{},\"parentId\":2002,\"path\":\"inputExcel/index\",\"status\":\"0\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-29 21:34:51');
INSERT INTO `sys_oper_log` VALUES (105, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"inputExcel/index\",\"createTime\":\"2022-11-29 21:34:51\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2003,\"menuName\":\"数据1\",\"menuType\":\"C\",\"orderNum\":1,\"params\":{},\"parentId\":2002,\"path\":\"inputExce\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-29 21:35:48');
INSERT INTO `sys_oper_log` VALUES (106, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"inputExcel/index\",\"createTime\":\"2022-11-29 21:34:51\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2003,\"menuName\":\"首页\",\"menuType\":\"C\",\"orderNum\":1,\"params\":{},\"parentId\":2002,\"path\":\"inputExce\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-29 21:36:13');
INSERT INTO `sys_oper_log` VALUES (107, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"reasoninference/reasoninference\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"原因推测分析\",\"menuType\":\"C\",\"orderNum\":6,\"params\":{},\"parentId\":0,\"path\":\"reasoninference\",\"status\":\"0\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-29 21:37:37');
INSERT INTO `sys_oper_log` VALUES (108, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"faultchange/index\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"变更项管理\",\"menuType\":\"C\",\"orderNum\":7,\"params\":{},\"parentId\":0,\"path\":\"faultchange\",\"status\":\"0\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-29 21:38:31');
INSERT INTO `sys_oper_log` VALUES (109, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"createTime\":\"2022-11-29 20:36:32\",\"icon\":\"guide\",\"isCache\":\"0\",\"isFrame\":\"0\",\"menuId\":4,\"menuName\":\"若依官网\",\"menuType\":\"M\",\"orderNum\":4,\"params\":{},\"parentId\":0,\"path\":\"http://ruoyi.vip\",\"perms\":\"\",\"query\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-29 21:39:13');
INSERT INTO `sys_oper_log` VALUES (110, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"createTime\":\"2022-11-29 20:36:32\",\"icon\":\"monitor\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2,\"menuName\":\"系统监控\",\"menuType\":\"M\",\"orderNum\":2,\"params\":{},\"parentId\":0,\"path\":\"monitor\",\"perms\":\"\",\"query\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-29 21:39:31');
INSERT INTO `sys_oper_log` VALUES (111, '【请填写功能名称】', 2, 'com.ruoyi.project.system.controller.RuleConstructionController.edit()', 'PUT', 1, 'admin', NULL, '/system/construction', '127.0.0.1', '内网IP', '{\"changeName\":\"装备型号升级\",\"id\":1,\"params\":{},\"rule\":\"不同问题装备型号中，某种故障模式质量问题数量存在较大差异\",\"ruleData\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 12:44:20');
INSERT INTO `sys_oper_log` VALUES (112, '【请填写功能名称】', 2, 'com.ruoyi.project.system.controller.RuleConstructionController.edit()', 'PUT', 1, 'admin', NULL, '/system/construction', '127.0.0.1', '内网IP', '{\"changeName\":\"装备型号升级\",\"id\":1,\"params\":{},\"rule\":\"不同问题装备型号中，某种故障模式质量问题数量存在较大差异\",\"ruleData\":\"1.5\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 12:44:43');
INSERT INTO `sys_oper_log` VALUES (113, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input3\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"产品设计数据导入\",\"menuType\":\"C\",\"orderNum\":4,\"params\":{},\"parentId\":2002,\"path\":\"inputExcel/input/input3\",\"status\":\"0\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 13:37:19');
INSERT INTO `sys_oper_log` VALUES (114, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/inputExcel/input/input3\",\"createTime\":\"2022-11-30 13:37:19\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2006,\"menuName\":\"产品设计数据导入\",\"menuType\":\"C\",\"orderNum\":4,\"params\":{},\"parentId\":2002,\"path\":\"inputExcel/inputExcel/input/input3\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 13:38:15');
INSERT INTO `sys_oper_log` VALUES (115, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/index\",\"createTime\":\"2022-11-29 21:34:51\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2003,\"menuName\":\"首页\",\"menuType\":\"C\",\"orderNum\":1,\"params\":{},\"parentId\":2002,\"path\":\"inputExcel\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 13:39:04');
INSERT INTO `sys_oper_log` VALUES (116, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input3\",\"createTime\":\"2022-11-30 13:37:19\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2006,\"menuName\":\"产品设计数据导入\",\"menuType\":\"C\",\"orderNum\":4,\"params\":{},\"parentId\":2002,\"path\":\"inputExcel/input/input3\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 13:40:40');
INSERT INTO `sys_oper_log` VALUES (117, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input3\",\"createTime\":\"2022-11-30 13:37:19\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2006,\"menuName\":\"产品设计数据导入\",\"menuType\":\"C\",\"orderNum\":4,\"params\":{},\"parentId\":2002,\"path\":\"inputExcel/inputExcel/input/input3\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 13:42:42');
INSERT INTO `sys_oper_log` VALUES (118, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/inputExcel/input/input3\",\"createTime\":\"2022-11-30 13:37:19\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2006,\"menuName\":\"产品设计数据导入\",\"menuType\":\"C\",\"orderNum\":4,\"params\":{},\"parentId\":2002,\"path\":\"inputExcel/inputExcel/input/input3\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 13:43:11');
INSERT INTO `sys_oper_log` VALUES (119, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/inputQuality\",\"createTime\":\"2022-11-30 13:37:19\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2006,\"menuName\":\"产品设计数据导入\",\"menuType\":\"C\",\"orderNum\":4,\"params\":{},\"parentId\":2002,\"path\":\"inputExcel\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 13:46:38');
INSERT INTO `sys_oper_log` VALUES (120, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input3\",\"createTime\":\"2022-11-30 13:37:19\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2006,\"menuName\":\"产品设计数据导入\",\"menuType\":\"C\",\"orderNum\":4,\"params\":{},\"parentId\":2002,\"path\":\"inputExcel\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:26:04');
INSERT INTO `sys_oper_log` VALUES (121, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input3\",\"createTime\":\"2022-11-30 13:37:19\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2006,\"menuName\":\"产品设计数据导入\",\"menuType\":\"C\",\"orderNum\":4,\"params\":{},\"parentId\":2002,\"path\":\"inputExcel\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:30:08');
INSERT INTO `sys_oper_log` VALUES (122, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input3\",\"createTime\":\"2022-11-30 13:37:19\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2006,\"menuName\":\"产品设计数据导入\",\"menuType\":\"C\",\"orderNum\":4,\"params\":{},\"parentId\":2002,\"path\":\"input3\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:31:09');
INSERT INTO `sys_oper_log` VALUES (123, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input3\",\"createTime\":\"2022-11-30 13:37:19\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2006,\"menuName\":\"产品设计数据导入\",\"menuType\":\"C\",\"orderNum\":4,\"params\":{},\"parentId\":2002,\"path\":\"input3\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:31:28');
INSERT INTO `sys_oper_log` VALUES (124, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input2\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"装备设计/改型数据\",\"menuType\":\"C\",\"orderNum\":3,\"params\":{},\"parentId\":2002,\"path\":\"input2\",\"status\":\"0\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:33:47');
INSERT INTO `sys_oper_log` VALUES (125, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/inputQuality\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"质量问题数据\",\"menuType\":\"C\",\"orderNum\":2,\"params\":{},\"parentId\":2002,\"path\":\"inputQuality\",\"status\":\"0\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:34:56');
INSERT INTO `sys_oper_log` VALUES (126, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input4\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"产品改型数据\",\"menuType\":\"C\",\"orderNum\":5,\"params\":{},\"parentId\":2002,\"path\":\"input4\",\"status\":\"0\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:36:04');
INSERT INTO `sys_oper_log` VALUES (127, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input5\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"装备制造数据\",\"menuType\":\"C\",\"orderNum\":6,\"params\":{},\"parentId\":2002,\"path\":\"input5\",\"status\":\"0\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:36:45');
INSERT INTO `sys_oper_log` VALUES (128, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input6\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"产品制造变更数据\",\"menuType\":\"C\",\"orderNum\":7,\"params\":{},\"parentId\":2002,\"path\":\"input6\",\"status\":\"0\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:37:48');
INSERT INTO `sys_oper_log` VALUES (129, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input9\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"产品生产数量\",\"menuType\":\"C\",\"orderNum\":8,\"params\":{},\"parentId\":2002,\"path\":\"input9\",\"status\":\"0\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:38:56');
INSERT INTO `sys_oper_log` VALUES (130, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input10\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"维修变更数据\",\"menuType\":\"C\",\"orderNum\":8,\"params\":{},\"parentId\":2002,\"path\":\"input10\",\"status\":\"0\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:40:17');
INSERT INTO `sys_oper_log` VALUES (131, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input10\",\"createTime\":\"2022-11-30 14:40:16\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2013,\"menuName\":\"维修变更数据\",\"menuType\":\"C\",\"orderNum\":9,\"params\":{},\"parentId\":2002,\"path\":\"input10\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:41:02');
INSERT INTO `sys_oper_log` VALUES (132, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input11\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"装备部署数据\",\"menuType\":\"C\",\"orderNum\":10,\"params\":{},\"parentId\":2002,\"path\":\"input11\",\"status\":\"0\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:41:39');
INSERT INTO `sys_oper_log` VALUES (133, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input12\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"装备使用数据\",\"menuType\":\"C\",\"orderNum\":11,\"params\":{},\"parentId\":2002,\"path\":\"input12\",\"status\":\"0\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:42:22');
INSERT INTO `sys_oper_log` VALUES (134, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input4\",\"createTime\":\"2022-11-30 14:36:04\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2009,\"menuName\":\"产品改型数据\",\"menuType\":\"C\",\"orderNum\":5,\"params\":{},\"parentId\":2002,\"path\":\"input4\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:43:54');
INSERT INTO `sys_oper_log` VALUES (135, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input9\",\"createTime\":\"2022-11-30 14:38:56\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2012,\"menuName\":\"产品生产数量\",\"menuType\":\"C\",\"orderNum\":8,\"params\":{},\"parentId\":2002,\"path\":\"input9\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:44:01');
INSERT INTO `sys_oper_log` VALUES (136, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '192.168.1.9', '内网IP', '{\"children\":[],\"component\":\"inputExcel/input/input10\",\"createTime\":\"2022-11-30 14:40:16\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2013,\"menuName\":\"维修变更数据\",\"menuType\":\"C\",\"orderNum\":9,\"params\":{},\"parentId\":2002,\"path\":\"input10\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:44:09');
INSERT INTO `sys_oper_log` VALUES (137, '参数管理', 2, 'com.ruoyi.project.system.controller.SysConfigController.edit()', 'PUT', 1, 'admin', NULL, '/system/config', '127.0.0.1', '内网IP', '{\"configId\":4,\"configKey\":\"sys.account.captchaEnabled\",\"configName\":\"账号自助-验证码开关\",\"configType\":\"Y\",\"configValue\":\"false\",\"createBy\":\"admin\",\"createTime\":\"2022-11-29 20:36:33\",\"params\":{},\"remark\":\"是否开启验证码功能（true开启，false关闭）\",\"updateBy\":\"admin\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-11-30 14:49:12');
INSERT INTO `sys_oper_log` VALUES (138, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', NULL, 1, '很抱歉，导入失败！共 2 条数据格式不正确，错误如下：<br/>1、账号 1 导入失败：\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'id\' doesn\'t have a default value\r\n### The error may exist in file [E:\\DalianUniversity\\qualityControl\\quality_control_back\\target\\classes\\mybatis\\system\\EquipmentDeploymentData11Mapper.xml]\r\n### The error may involve com.ruoyi.project.system.mapper.EquipmentDeploymentData11Mapper.insertEquipmentDeploymentData11-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into equipment_deployment_data_11          ( plane_type,             troops,             deployment_time,             deployment_quantity )           values ( ?,             ?,             ?,             ? )\r\n### Cause: java.sql.SQLException: Field \'id\' doesn\'t have a default value\n; Field \'id\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'id\' doesn\'t have a default value<br/>2、账号 2 导入失败：\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'id\' doesn\'t have a default value\r\n### The error may exist in file [E:\\DalianUniversity\\qualityControl\\quality_control_back\\target\\classes\\mybatis\\system\\EquipmentDeploymentData11Mapper.xml]\r\n### The error may involve com.ruoyi.project.system.mapper.EquipmentDeploymentData11Mapper.insertEquipmentDeploymentData11-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into equipment_deployment_data_11          ( plane_type,             troops,             deployment_time )           values ( ?,             ?,             ? )\r\n### Cause: java.sql.SQLException: Field \'id\' doesn\'t have a default value\n; Field \'id\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'id\' doesn\'t have a default value', '2022-12-01 22:00:47');
INSERT INTO `sys_oper_log` VALUES (139, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功\",\"code\":200}', 0, NULL, '2022-12-01 22:15:06');
INSERT INTO `sys_oper_log` VALUES (140, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/1', '192.168.1.11', '内网IP', '{ids=1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-01 22:18:08');
INSERT INTO `sys_oper_log` VALUES (141, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/2', '192.168.1.11', '内网IP', '{ids=2}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-01 22:18:10');
INSERT INTO `sys_oper_log` VALUES (142, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功\",\"code\":200}', 0, NULL, '2022-12-01 22:18:39');
INSERT INTO `sys_oper_log` VALUES (143, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/4', '192.168.1.11', '内网IP', '{ids=4}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-01 22:19:01');
INSERT INTO `sys_oper_log` VALUES (144, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/3', '192.168.1.11', '内网IP', '{ids=3}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-01 22:19:05');
INSERT INTO `sys_oper_log` VALUES (145, '数据管理', 6, 'com.ruoyi.project.system.controller.QualityProblemController.importData()', 'POST', 1, 'admin', NULL, '/system/dev/importData', '192.168.1.11', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 1 条，数据如下：<br/>1、数据 123 导入成功\",\"code\":200}', 0, NULL, '2022-12-01 22:20:16');
INSERT INTO `sys_oper_log` VALUES (146, 'quality_problem', 3, 'com.ruoyi.project.system.controller.QualityProblemController.remove()', 'DELETE', 1, 'admin', NULL, '/system/dev/8', '192.168.1.11', '内网IP', '{ids=8}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-01 22:20:26');
INSERT INTO `sys_oper_log` VALUES (147, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', NULL, 1, '', '2022-12-01 23:33:46');
INSERT INTO `sys_oper_log` VALUES (148, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', NULL, 1, '', '2022-12-01 23:35:42');
INSERT INTO `sys_oper_log` VALUES (149, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', NULL, 1, '', '2022-12-01 23:36:17');
INSERT INTO `sys_oper_log` VALUES (150, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', '{\"msg\":\"1\",\"code\":200}', 0, NULL, '2022-12-01 23:40:20');
INSERT INTO `sys_oper_log` VALUES (151, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', NULL, 1, '', '2022-12-01 23:41:18');
INSERT INTO `sys_oper_log` VALUES (152, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', '{\"msg\":\"1\",\"code\":200}', 0, NULL, '2022-12-01 23:57:14');
INSERT INTO `sys_oper_log` VALUES (153, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', '{\"msg\":\"1\",\"code\":200}', 0, NULL, '2022-12-01 23:59:09');
INSERT INTO `sys_oper_log` VALUES (154, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', '{\"msg\":\"1\",\"code\":200}', 0, NULL, '2022-12-02 00:06:13');
INSERT INTO `sys_oper_log` VALUES (155, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', NULL, 1, '', '2022-12-02 00:13:51');
INSERT INTO `sys_oper_log` VALUES (156, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', NULL, 1, '', '2022-12-02 00:55:43');
INSERT INTO `sys_oper_log` VALUES (157, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', NULL, 1, '', '2022-12-02 00:57:42');
INSERT INTO `sys_oper_log` VALUES (158, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', NULL, 1, '', '2022-12-02 00:58:36');
INSERT INTO `sys_oper_log` VALUES (159, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', NULL, 1, '', '2022-12-02 01:20:56');
INSERT INTO `sys_oper_log` VALUES (160, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '192.168.1.11', '内网IP', 'false', NULL, 1, '', '2022-12-02 01:22:19');
INSERT INTO `sys_oper_log` VALUES (161, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功\",\"code\":200}', 0, NULL, '2022-12-02 14:53:57');
INSERT INTO `sys_oper_log` VALUES (162, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/5', '127.0.0.1', '内网IP', '{ids=5}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 14:54:34');
INSERT INTO `sys_oper_log` VALUES (163, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/6', '127.0.0.1', '内网IP', '{ids=6}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 14:54:36');
INSERT INTO `sys_oper_log` VALUES (164, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功\",\"code\":200}', 0, NULL, '2022-12-02 14:58:43');
INSERT INTO `sys_oper_log` VALUES (165, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"inputExcel/index\",\"createTime\":\"2022-11-29 21:34:51\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2003,\"menuName\":\"数据录入管理\",\"menuType\":\"C\",\"orderNum\":1,\"params\":{},\"parentId\":2002,\"path\":\"inputExcel\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 15:07:36');
INSERT INTO `sys_oper_log` VALUES (166, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功\",\"code\":200}', 0, NULL, '2022-12-02 15:27:30');
INSERT INTO `sys_oper_log` VALUES (167, '代码生成', 6, 'com.ruoyi.project.tool.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/tool/gen/importTable', '127.0.0.1', '内网IP', '\"parts_repair_num_13\"', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 16:42:14');
INSERT INTO `sys_oper_log` VALUES (168, '代码生成', 8, 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{}', NULL, 0, NULL, '2022-12-02 16:42:17');
INSERT INTO `sys_oper_log` VALUES (169, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/7', '127.0.0.1', '内网IP', '{ids=7}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:09:50');
INSERT INTO `sys_oper_log` VALUES (170, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/8', '127.0.0.1', '内网IP', '{ids=8}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:09:52');
INSERT INTO `sys_oper_log` VALUES (171, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/9', '127.0.0.1', '内网IP', '{ids=9}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:09:54');
INSERT INTO `sys_oper_log` VALUES (172, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/10', '127.0.0.1', '内网IP', '{ids=10}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:09:56');
INSERT INTO `sys_oper_log` VALUES (173, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功\",\"code\":200}', 0, NULL, '2022-12-02 18:10:04');
INSERT INTO `sys_oper_log` VALUES (174, '代码生成', 6, 'com.ruoyi.project.tool.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/tool/gen/importTable', '192.168.1.106', '内网IP', '\"equipment_deployment_data_11,repair_modify_data_10,product_modify_data_6,parts_make_num_9,equipment_manufacturing_data5,equipment_design_data,product_design_3,quality_problem_1,product_modify_4\"', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:11:12');
INSERT INTO `sys_oper_log` VALUES (175, '代码生成', 6, 'com.ruoyi.project.tool.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/tool/gen/importTable', '192.168.1.106', '内网IP', '\"equipment_deployment_data_11,repair_modify_data_10,product_modify_data_6,parts_make_num_9,equipment_manufacturing_data5,equipment_design_data,product_design_3,quality_problem_1,product_modify_4\"', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:11:27');
INSERT INTO `sys_oper_log` VALUES (176, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功\",\"code\":200}', 0, NULL, '2022-12-02 18:28:22');
INSERT INTO `sys_oper_log` VALUES (177, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/11', '127.0.0.1', '内网IP', '{ids=11}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:28:38');
INSERT INTO `sys_oper_log` VALUES (178, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/12', '127.0.0.1', '内网IP', '{ids=12}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:28:40');
INSERT INTO `sys_oper_log` VALUES (179, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/13', '127.0.0.1', '内网IP', '{ids=13}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:28:43');
INSERT INTO `sys_oper_log` VALUES (180, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/14', '127.0.0.1', '内网IP', '{ids=14}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:28:47');
INSERT INTO `sys_oper_log` VALUES (181, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功\",\"code\":200}', 0, NULL, '2022-12-02 18:48:31');
INSERT INTO `sys_oper_log` VALUES (182, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/15', '127.0.0.1', '内网IP', '{ids=15}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:48:49');
INSERT INTO `sys_oper_log` VALUES (183, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/16', '127.0.0.1', '内网IP', '{ids=16}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:48:53');
INSERT INTO `sys_oper_log` VALUES (184, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功\",\"code\":200}', 0, NULL, '2022-12-02 18:54:08');
INSERT INTO `sys_oper_log` VALUES (185, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/17', '127.0.0.1', '内网IP', '{ids=17}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:54:14');
INSERT INTO `sys_oper_log` VALUES (186, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/18', '127.0.0.1', '内网IP', '{ids=18}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 18:54:16');
INSERT INTO `sys_oper_log` VALUES (187, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功\",\"code\":200}', 0, NULL, '2022-12-02 19:03:24');
INSERT INTO `sys_oper_log` VALUES (188, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/19', '127.0.0.1', '内网IP', '{ids=19}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 19:03:27');
INSERT INTO `sys_oper_log` VALUES (189, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/20', '127.0.0.1', '内网IP', '{ids=20}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 19:03:30');
INSERT INTO `sys_oper_log` VALUES (190, '用户管理', 6, 'com.ruoyi.project.system.controller.SysUserController.importData()', 'POST', 1, 'admin', NULL, '/system/user/importData', '127.0.0.1', '内网IP', 'false', NULL, 1, '很抱歉，导入失败！共 1 条数据格式不正确，错误如下：<br/>1、账号  导入失败：userName: 用户账号不能为空', '2022-12-02 20:20:32');
INSERT INTO `sys_oper_log` VALUES (191, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功\",\"code\":200}', 0, NULL, '2022-12-02 20:28:02');
INSERT INTO `sys_oper_log` VALUES (192, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/21', '127.0.0.1', '内网IP', '{ids=21}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 20:28:06');
INSERT INTO `sys_oper_log` VALUES (193, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/22', '127.0.0.1', '内网IP', '{ids=22}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 20:28:09');
INSERT INTO `sys_oper_log` VALUES (194, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 3 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功<br/>3、数据 33 导入成功\",\"code\":200}', 0, NULL, '2022-12-02 20:31:59');
INSERT INTO `sys_oper_log` VALUES (195, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/23', '127.0.0.1', '内网IP', '{ids=23}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 20:32:05');
INSERT INTO `sys_oper_log` VALUES (196, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/24', '127.0.0.1', '内网IP', '{ids=24}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 20:32:08');
INSERT INTO `sys_oper_log` VALUES (197, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/25', '127.0.0.1', '内网IP', '{ids=25}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 20:32:10');
INSERT INTO `sys_oper_log` VALUES (198, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 3 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功<br/>3、数据 33 导入成功\",\"code\":200}', 0, NULL, '2022-12-02 21:29:36');
INSERT INTO `sys_oper_log` VALUES (199, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/26', '127.0.0.1', '内网IP', '{ids=26}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 21:29:41');
INSERT INTO `sys_oper_log` VALUES (200, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/27', '127.0.0.1', '内网IP', '{ids=27}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 21:29:43');
INSERT INTO `sys_oper_log` VALUES (201, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/28', '127.0.0.1', '内网IP', '{ids=28}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-02 21:29:45');
INSERT INTO `sys_oper_log` VALUES (202, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', NULL, 1, '', '2022-12-02 21:40:33');
INSERT INTO `sys_oper_log` VALUES (203, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', NULL, 1, '', '2022-12-02 21:41:17');
INSERT INTO `sys_oper_log` VALUES (204, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', NULL, 1, '', '2022-12-02 22:00:18');
INSERT INTO `sys_oper_log` VALUES (205, '产品设计', 6, 'com.ruoyi.project.system.controller.ProductDesignController.importData()', 'POST', 1, 'admin', NULL, '/system/design/importData', '192.168.31.156', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 1 条，数据如下：<br/>1、数据 机型1E 导入成功\",\"code\":200}', 0, NULL, '2022-12-03 14:41:50');
INSERT INTO `sys_oper_log` VALUES (206, '产品设计', 6, 'com.ruoyi.project.system.controller.ProductDesignController.importData()', 'POST', 1, 'admin', NULL, '/system/design/importData', '192.168.31.156', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 机型1F 导入成功<br/>2、数据 机型2G 导入成功\",\"code\":200}', 0, NULL, '2022-12-03 14:42:50');
INSERT INTO `sys_oper_log` VALUES (207, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', NULL, 1, '', '2022-12-03 14:53:53');
INSERT INTO `sys_oper_log` VALUES (208, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 3 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功<br/>3、数据  导入成功\",\"code\":200}', 0, NULL, '2022-12-03 14:58:50');
INSERT INTO `sys_oper_log` VALUES (209, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/29', '127.0.0.1', '内网IP', '{ids=29}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 14:59:10');
INSERT INTO `sys_oper_log` VALUES (210, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/30', '127.0.0.1', '内网IP', '{ids=30}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 14:59:17');
INSERT INTO `sys_oper_log` VALUES (211, '8:装备部署数据', 3, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.remove()', 'DELETE', 1, 'admin', NULL, '/system/11/31', '127.0.0.1', '内网IP', '{ids=31}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 14:59:19');
INSERT INTO `sys_oper_log` VALUES (212, 'quality_problem', 2, 'com.ruoyi.project.system.controller.QualityProblemController.edit()', 'PUT', 1, 'admin', NULL, '/system/dev', '192.168.1.106', '内网IP', '{\"devCode\":\"201111701\",\"devFactoryTime\":\"2022-09-14 00:00:00\",\"devHappenTime\":\"2022-10-19 00:00:00\",\"devManufacture\":\"02\",\"devRepaired\":\"否\",\"devUnit\":\"制造单位2\",\"devUseTime\":\"500\",\"environment\":\"沿海地区\",\"faultModel\":\"过度磨损\",\"faultPhenomenon\":\"飞行过程中液压泵磨损\",\"id\":6,\"params\":{},\"partsCode\":\"20221135\",\"partsFactoryTime\":\"2022-11-30 00:00:00\",\"partsManufacture\":\"202212\",\"partsModel\":\"TC-1\",\"partsName\":\"液压泵\",\"partsType\":\"泵\",\"partsUnit\":\"123厂\",\"partsUseTime\":\"250\",\"planeType\":\"机型2B\",\"repairedFactory\":\"123厂\",\"title\":\"质量问题6\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 15:21:08');
INSERT INTO `sys_oper_log` VALUES (213, 'quality_problem', 2, 'com.ruoyi.project.system.controller.QualityProblemController.edit()', 'PUT', 1, 'admin', NULL, '/system/dev', '192.168.1.106', '内网IP', '{\"devCode\":\"201111702\",\"devFactoryTime\":\"2022-09-14 00:00:00\",\"devHappenTime\":\"2022-10-19 00:00:00\",\"devManufacture\":\"02\",\"devRepaired\":\"否\",\"devUnit\":\"制造单位2\",\"devUseTime\":\"500\",\"environment\":\"沿海地区\",\"faultModel\":\"过度磨损\",\"faultPhenomenon\":\"飞行过程中液压泵磨损\",\"id\":6,\"params\":{},\"partsCode\":\"20221135\",\"partsFactoryTime\":\"2022-11-30 00:00:00\",\"partsManufacture\":\"202212\",\"partsModel\":\"TC-1\",\"partsName\":\"液压泵\",\"partsType\":\"泵\",\"partsUnit\":\"123厂\",\"partsUseTime\":\"250\",\"planeType\":\"机型2B\",\"repairedFactory\":\"123厂\",\"title\":\"质量问题6\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 15:21:22');
INSERT INTO `sys_oper_log` VALUES (214, 'quality_problem', 1, 'com.ruoyi.project.system.controller.QualityProblemController.add()', 'POST', 1, 'admin', NULL, '/system/dev', '192.168.1.106', '内网IP', '{\"params\":{}}', NULL, 1, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\r\n### The error may exist in file [C:\\Users\\木草人\\Desktop\\项目\\quality_control_back\\target\\classes\\mybatis\\system\\QualityProblemMapper.xml]\r\n### The error may involve com.ruoyi.project.system.mapper.QualityProblemMapper.insertQualityProblem-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into quality_problem_1\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1', '2022-12-03 15:53:04');
INSERT INTO `sys_oper_log` VALUES (215, 'quality_problem', 2, 'com.ruoyi.project.system.controller.QualityProblemController.edit()', 'PUT', 1, 'admin', NULL, '/system/dev', '192.168.1.106', '内网IP', '{\"devCode\":\"201111702\",\"devFactoryTime\":\"2022-09-14 00:00:00\",\"devHappenTime\":\"2022-10-19 00:00:00\",\"devManufacture\":\"02\",\"devRepaired\":\"否\",\"devUnit\":\"制造单位2\",\"devUseTime\":\"500\",\"environment\":\"沿海地区\",\"faultModel\":\"过度磨损\",\"faultPhenomenon\":\"飞行过程中液压泵磨损\",\"id\":6,\"params\":{},\"partsCode\":\"20221135\",\"partsFactoryTime\":\"2022-11-30 00:00:00\",\"partsManufacture\":\"202212\",\"partsModel\":\"TC-1\",\"partsName\":\"液压泵\",\"partsType\":\"泵\",\"partsUnit\":\"123厂\",\"partsUseTime\":\"250\",\"planeType\":\"机型2B\",\"repairedFactory\":\"123厂\",\"title\":\"质量问题6\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 15:53:12');
INSERT INTO `sys_oper_log` VALUES (216, 'quality_problem', 2, 'com.ruoyi.project.system.controller.QualityProblemController.edit()', 'PUT', 1, 'admin', NULL, '/system/dev', '192.168.1.106', '内网IP', '{\"devCode\":\"201111702\",\"devFactoryTime\":\"2022-09-14 00:00:00\",\"devHappenTime\":\"2022-10-19 00:00:00\",\"devManufacture\":\"02\",\"devRepaired\":\"否\",\"devUnit\":\"制造单位2\",\"devUseTime\":\"500\",\"environment\":\"沿海地区\",\"faultModel\":\"过度磨损\",\"faultPhenomenon\":\"飞行过程中液压泵磨损\",\"id\":6,\"params\":{},\"partsCode\":\"20221135\",\"partsFactoryTime\":\"2022-11-30 00:00:00\",\"partsManufacture\":\"202212\",\"partsModel\":\"TC-1\",\"partsName\":\"液压泵\",\"partsType\":\"泵\",\"partsUnit\":\"123厂\",\"partsUseTime\":\"250\",\"planeType\":\"机型2B\",\"repairedFactory\":\"123厂\",\"title\":\"质量问题6\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 15:59:19');
INSERT INTO `sys_oper_log` VALUES (217, 'quality_problem', 2, 'com.ruoyi.project.system.controller.QualityProblemController.edit()', 'PUT', 1, 'admin', NULL, '/system/dev', '192.168.1.106', '内网IP', '{\"devCode\":\"201111702\",\"devFactoryTime\":\"2022-09-14 00:00:00\",\"devHappenTime\":\"2022-10-19 00:00:00\",\"devManufacture\":\"02\",\"devRepaired\":\"否\",\"devUnit\":\"制造单位2\",\"devUseTime\":\"500\",\"environment\":\"沿海地区\",\"faultModel\":\"过度磨损\",\"faultPhenomenon\":\"飞行过程中液压泵磨损\",\"id\":6,\"params\":{},\"partsCode\":\"20221135\",\"partsFactoryTime\":\"2022-11-30 00:00:00\",\"partsManufacture\":\"202212\",\"partsModel\":\"TC-1\",\"partsName\":\"液压泵\",\"partsType\":\"泵\",\"partsUnit\":\"123厂\",\"partsUseTime\":\"250\",\"planeType\":\"机型2B\",\"repairedFactory\":\"123厂\",\"title\":\"质量问题6\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 15:59:29');
INSERT INTO `sys_oper_log` VALUES (218, '数据管理', 6, 'com.ruoyi.project.system.controller.QualityProblemController.importData()', 'POST', 1, 'admin', NULL, '/system/dev/importData', '192.168.1.106', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 1 条，数据如下：<br/>1、数据 2 导入成功\",\"code\":200}', 0, NULL, '2022-12-03 16:03:29');
INSERT INTO `sys_oper_log` VALUES (219, 'quality_problem', 2, 'com.ruoyi.project.system.controller.QualityProblemController.edit()', 'PUT', 1, 'admin', NULL, '/system/dev', '127.0.0.1', '内网IP', '{\"devCode\":\"201111702\",\"devFactoryTime\":\"2022-09-14 00:00:00\",\"devHappenTime\":\"2022-10-19 00:00:00\",\"devManufacture\":\"02\",\"devRepaired\":\"否\",\"devUnit\":\"制造单位2\",\"devUseTime\":\"500\",\"environment\":\"沿海地区\",\"faultModel\":\"过度磨损\",\"faultPhenomenon\":\"飞行过程中液压泵磨损\",\"id\":6,\"params\":{},\"partsCode\":\"20221135\",\"partsFactoryTime\":\"2022-11-30 00:00:00\",\"partsManufacture\":\"202212\",\"partsModel\":\"TC-1\",\"partsName\":\"液压泵\",\"partsType\":\"泵\",\"partsUnit\":\"123厂\",\"partsUseTime\":\"250\",\"planeType\":\"机型2B\",\"repairedFactory\":\"123厂\",\"title\":\"质量问题6\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 17:35:40');
INSERT INTO `sys_oper_log` VALUES (220, 'quality_problem', 2, 'com.ruoyi.project.system.controller.QualityProblemController.edit()', 'PUT', 1, 'admin', NULL, '/system/dev', '127.0.0.1', '内网IP', '{\"devCode\":\"201111701\",\"devFactoryTime\":\"2022-09-14 00:00:00\",\"devHappenTime\":\"2022-10-19 00:00:00\",\"devManufacture\":\"02\",\"devRepaired\":\"否\",\"devUnit\":\"制造单位2\",\"devUseTime\":\"500\",\"environment\":\"沿海地区\",\"faultModel\":\"过度磨损\",\"faultPhenomenon\":\"飞行过程中液压泵磨损\",\"id\":6,\"params\":{},\"partsCode\":\"20221135\",\"partsFactoryTime\":\"2022-11-30 00:00:00\",\"partsManufacture\":\"202212\",\"partsModel\":\"TC-1\",\"partsName\":\"液压泵\",\"partsType\":\"泵\",\"partsUnit\":\"123厂\",\"partsUseTime\":\"250\",\"planeType\":\"机型2B\",\"repairedFactory\":\"123厂\",\"title\":\"质量问题6\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 17:35:58');
INSERT INTO `sys_oper_log` VALUES (221, 'quality_problem', 2, 'com.ruoyi.project.system.controller.QualityProblemController.edit()', 'PUT', 1, 'admin', NULL, '/system/dev', '127.0.0.1', '内网IP', '{\"devCode\":\"201111702\",\"devFactoryTime\":\"2022-09-14 00:00:00\",\"devHappenTime\":\"2022-10-19 00:00:00\",\"devManufacture\":\"02\",\"devRepaired\":\"否\",\"devUnit\":\"制造单位2\",\"devUseTime\":\"500\",\"environment\":\"沿海地区\",\"faultModel\":\"过度磨损\",\"faultPhenomenon\":\"飞行过程中液压泵磨损\",\"id\":6,\"params\":{},\"partsCode\":\"20221135\",\"partsFactoryTime\":\"2022-11-30 00:00:00\",\"partsManufacture\":\"202212\",\"partsModel\":\"TC-1\",\"partsName\":\"液压泵\",\"partsType\":\"泵\",\"partsUnit\":\"123厂\",\"partsUseTime\":\"250\",\"planeType\":\"机型2B\",\"repairedFactory\":\"123厂\",\"title\":\"质量问题6\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 17:36:08');
INSERT INTO `sys_oper_log` VALUES (222, 'quality_problem', 2, 'com.ruoyi.project.system.controller.QualityProblemController.edit()', 'PUT', 1, 'admin', NULL, '/system/dev', '127.0.0.1', '内网IP', '{\"devCode\":\"201111702\",\"devFactoryTime\":\"2022-09-14 00:00:00\",\"devHappenTime\":\"2022-10-19 00:00:00\",\"devManufacture\":\"02\",\"devRepaired\":\"否\",\"devUnit\":\"制造单位2\",\"devUseTime\":\"500\",\"environment\":\"沿海地区\",\"faultModel\":\"过度磨损\",\"faultPhenomenon\":\"飞行过程中液压泵磨损\",\"id\":6,\"params\":{},\"partsCode\":\"20221135\",\"partsFactoryTime\":\"2022-11-30 00:00:00\",\"partsManufacture\":\"202212\",\"partsModel\":\"TC-1\",\"partsName\":\"液压泵\",\"partsType\":\"泵\",\"partsUnit\":\"123厂\",\"partsUseTime\":\"250\",\"planeType\":\"机型2B\",\"repairedFactory\":\"123厂\",\"title\":\"质量问题6\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 17:38:59');
INSERT INTO `sys_oper_log` VALUES (223, 'quality_problem', 2, 'com.ruoyi.project.system.controller.QualityProblemController.edit()', 'PUT', 1, 'admin', NULL, '/system/dev', '127.0.0.1', '内网IP', '{\"devCode\":\"201111702\",\"devFactoryTime\":\"2022-09-14 00:00:00\",\"devHappenTime\":\"2022-10-19 00:00:00\",\"devManufacture\":\"02\",\"devRepaired\":\"否\",\"devUnit\":\"制造单位2\",\"devUseTime\":\"500\",\"environment\":\"沿海地区\",\"faultModel\":\"过度磨损\",\"faultPhenomenon\":\"飞行过程中液压泵磨损\",\"id\":6,\"params\":{},\"partsCode\":\"20221135\",\"partsFactoryTime\":\"2022-11-30 00:00:00\",\"partsManufacture\":\"202212\",\"partsModel\":\"TC-1\",\"partsName\":\"液压泵\",\"partsType\":\"泵\",\"partsUnit\":\"123厂\",\"partsUseTime\":\"250\",\"planeType\":\"机型2B\",\"repairedFactory\":\"123厂\",\"title\":\"质量问题6\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 17:39:11');
INSERT INTO `sys_oper_log` VALUES (224, 'quality_problem', 2, 'com.ruoyi.project.system.controller.QualityProblemController.edit()', 'PUT', 1, 'admin', NULL, '/system/dev', '127.0.0.1', '内网IP', '{\"devCode\":\"201111702\",\"devFactoryTime\":\"2022-09-14 00:00:00\",\"devHappenTime\":\"2022-10-19 00:00:00\",\"devManufacture\":\"02\",\"devRepaired\":\"否\",\"devUnit\":\"制造单位2\",\"devUseTime\":\"500\",\"environment\":\"沿海地区\",\"faultModel\":\"过度磨损\",\"faultPhenomenon\":\"飞行过程中液压泵磨损\",\"id\":6,\"params\":{},\"partsCode\":\"20221135\",\"partsFactoryTime\":\"2022-11-30 00:00:00\",\"partsManufacture\":\"202212\",\"partsModel\":\"TC-1\",\"partsName\":\"液压泵\",\"partsType\":\"泵\",\"partsUnit\":\"123厂\",\"partsUseTime\":\"250\",\"planeType\":\"机型2B\",\"repairedFactory\":\"123厂\",\"repairedTime\":\"2022-12-26 00:00:00\",\"title\":\"质量问题6\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 17:42:57');
INSERT INTO `sys_oper_log` VALUES (225, '装备设计/改型数据', 2, 'com.ruoyi.project.system.controller.EquipmentDesignDataController.edit()', 'PUT', 1, 'admin', NULL, '/system/data', '127.0.0.1', '内网IP', '{\"id\":1,\"makeUnit\":\"洛克希德马丁\",\"modelSeries\":\"机型2\",\"params\":{},\"planeType\":\"机型1A\",\"remodelDate\":\"2016-03-01 00:00:00\",\"remodelMeasure\":\"对液压系统布局进行更新\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 18:22:36');
INSERT INTO `sys_oper_log` VALUES (226, '装备设计/改型数据', 2, 'com.ruoyi.project.system.controller.EquipmentDesignDataController.edit()', 'PUT', 1, 'admin', NULL, '/system/data', '127.0.0.1', '内网IP', '{\"id\":1,\"makeUnit\":\"洛克希德马丁\",\"modelSeries\":\"机型1\",\"params\":{},\"planeType\":\"机型1A\",\"remodelDate\":\"2016-03-01 00:00:00\",\"remodelMeasure\":\"对液压系统布局进行更新\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 18:22:43');
INSERT INTO `sys_oper_log` VALUES (227, '装备设计/改型数据', 2, 'com.ruoyi.project.system.controller.EquipmentDesignDataController.edit()', 'PUT', 1, 'admin', NULL, '/system/data', '127.0.0.1', '内网IP', '{\"id\":1,\"makeUnit\":\"洛克希德马丁\",\"modelSeries\":\"机型2\",\"params\":{},\"planeType\":\"机型1A\",\"remodelDate\":\"2016-03-01 00:00:00\",\"remodelMeasure\":\"对液压系统布局进行更新\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 18:22:52');
INSERT INTO `sys_oper_log` VALUES (228, '装备设计/改型数据', 2, 'com.ruoyi.project.system.controller.EquipmentDesignDataController.edit()', 'PUT', 1, 'admin', NULL, '/system/data', '127.0.0.1', '内网IP', '{\"id\":1,\"makeUnit\":\"洛克希德马丁\",\"modelSeries\":\"机型1\",\"params\":{},\"planeType\":\"机型1A\",\"remodelDate\":\"2016-03-01 00:00:00\",\"remodelMeasure\":\"对液压系统布局进行更新\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 18:23:02');
INSERT INTO `sys_oper_log` VALUES (229, '装备设计/改型数据', 2, 'com.ruoyi.project.system.controller.EquipmentDesignDataController.edit()', 'PUT', 1, 'admin', NULL, '/system/data', '127.0.0.1', '内网IP', '{\"id\":1,\"makeUnit\":\"洛克希德马丁\",\"modelSeries\":\"机型2\",\"params\":{},\"planeType\":\"机型1A\",\"remodelDate\":\"2016-03-01 00:00:00\",\"remodelMeasure\":\"对液压系统布局进行更新\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 18:23:52');
INSERT INTO `sys_oper_log` VALUES (230, '装备设计/改型数据', 2, 'com.ruoyi.project.system.controller.EquipmentDesignDataController.edit()', 'PUT', 1, 'admin', NULL, '/system/data', '127.0.0.1', '内网IP', '{\"id\":1,\"makeUnit\":\"洛克希德马丁\",\"modelSeries\":\"机型1\",\"params\":{},\"planeType\":\"机型1A\",\"remodelDate\":\"2016-03-01 00:00:00\",\"remodelMeasure\":\"对液压系统布局进行更新\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 18:23:57');
INSERT INTO `sys_oper_log` VALUES (231, '装备设计/改型', 6, 'com.ruoyi.project.system.controller.EquipmentDesignDataController.importData()', 'POST', 1, 'admin', NULL, '/system/data/importData', '192.168.1.106', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 1 条，数据如下：<br/>1、数据 机型1 导入成功\",\"code\":200}', 0, NULL, '2022-12-03 19:02:21');
INSERT INTO `sys_oper_log` VALUES (232, '装备设计/改型数据', 3, 'com.ruoyi.project.system.controller.EquipmentDesignDataController.remove()', 'DELETE', 1, 'admin', NULL, '/system/data/13', '192.168.1.106', '内网IP', '{ids=13}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 19:02:53');
INSERT INTO `sys_oper_log` VALUES (233, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"firstCountAnalysis/index.vue\",\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"数据分析-1\",\"menuType\":\"C\",\"orderNum\":10,\"params\":{},\"parentId\":0,\"path\":\"firstCountAnalysis\",\"status\":\"0\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 20:47:39');
INSERT INTO `sys_oper_log` VALUES (234, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"firstCountAnalysis/index.vue\",\"createTime\":\"2022-12-03 20:47:39\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2016,\"menuName\":\"数据分析-1\",\"menuType\":\"C\",\"orderNum\":10,\"params\":{},\"parentId\":0,\"path\":\"firstCountAnalysis\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 20:48:04');
INSERT INTO `sys_oper_log` VALUES (235, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', NULL, 1, '', '2022-12-03 21:08:00');
INSERT INTO `sys_oper_log` VALUES (236, '装备部署', 6, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.importData()', 'POST', 1, 'admin', NULL, '/system/11/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 3 条，数据如下：<br/>1、数据 1 导入成功<br/>2、数据 2 导入成功<br/>3、数据  导入成功\",\"code\":200}', 0, NULL, '2022-12-03 21:09:42');
INSERT INTO `sys_oper_log` VALUES (237, '产品改型数据', 2, 'com.ruoyi.project.system.controller.ProductModifyController.edit()', 'PUT', 1, 'admin', NULL, '/system/modify', '192.168.1.106', '内网IP', '{\"id\":1,\"modifyMeasures\":\"更换密封圈制造商\",\"modifyTime\":\"2022-09-28 00:00:00\",\"params\":{},\"planeType\":\"机型1A\",\"productModel\":\"TC-2\",\"productName\":\"液压泵\",\"productType\":\"泵\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 00:13:14');
INSERT INTO `sys_oper_log` VALUES (238, '产品改型数据', 2, 'com.ruoyi.project.system.controller.ProductModifyController.edit()', 'PUT', 1, 'admin', NULL, '/system/modify', '192.168.1.106', '内网IP', '{\"id\":1,\"modifyMeasures\":\"更换密封圈制造商\",\"modifyTime\":\"2022-09-28 00:00:00\",\"params\":{},\"planeType\":\"机型1A\",\"productModel\":\"TC-1\",\"productName\":\"液压泵\",\"productType\":\"泵\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 00:20:30');
INSERT INTO `sys_oper_log` VALUES (239, '产品改型数据', 2, 'com.ruoyi.project.system.controller.ProductModifyController.edit()', 'PUT', 1, 'admin', NULL, '/system/modify', '192.168.1.106', '内网IP', '{\"id\":1,\"modifyMeasures\":\"更换密封圈制造商\",\"modifyTime\":\"2022-09-28 00:00:00\",\"params\":{},\"planeType\":\"机型1A\",\"productModel\":\"TC-1\",\"productName\":\"液压泵\",\"productType\":\"泵\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 00:21:20');
INSERT INTO `sys_oper_log` VALUES (240, '【请填写功能名称】', 2, 'com.ruoyi.project.system.controller.EquipmentManufacturingData5Controller.edit()', 'PUT', 1, 'admin', NULL, '/system/data5', '192.168.1.106', '内网IP', '{\"capabilityStatus\":\"1.0\",\"devCode\":\"201111701\",\"devManufacture\":\"01\",\"devUnit\":\"制造单位2\",\"id\":1,\"params\":{},\"planeType\":\"机型1A\",\"productionUpgradeTime\":\"2021-10-07 00:00:00\",\"type\":\"生产\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 00:52:24');
INSERT INTO `sys_oper_log` VALUES (241, '产品制造变更数据', 2, 'com.ruoyi.project.system.controller.ProductModifyDataController.edit()', 'PUT', 1, 'admin', NULL, '/system/modifyData', '192.168.1.106', '内网IP', '{\"id\":1,\"modifyMethod\":\"有大量新员工入职\",\"modifyTime\":\"2021-06-22 00:00:00\",\"modifyType\":\"生产班组变更\",\"params\":{},\"productModel\":\"TC-1\",\"productName\":\"液压泵\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 01:16:36');
INSERT INTO `sys_oper_log` VALUES (242, '9：装备使用数据', 2, 'com.ruoyi.project.system.controller.PartsMakeNum9Controller.edit()', 'PUT', 1, 'admin', NULL, '/system/9', '192.168.1.106', '内网IP', '{\"id\":1,\"params\":{},\"partsCode\":\"20221130\",\"partsFactoryTime\":\"2022-11-17 00:00:00\",\"partsMakeGroup\":\"班组1\",\"partsMakePeople\":\"[人员4,人员5,人员6]\",\"partsMakeQuipment\":\"[300#五轴机床,20#夹具]\",\"partsMakeWorkmanship\":\"焊接\",\"partsManufacture\":\"202211\",\"partsMeasuringQuipment\":\"[300#五轴机床2,20#夹具2]\",\"partsModel\":\"TC-1\",\"partsName\":\"液压泵\",\"planeType\":\"机型1A\",\"sparePartsPlace\":\"2\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 01:40:20');
INSERT INTO `sys_oper_log` VALUES (243, '8:装备部署数据', 2, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.edit()', 'PUT', 1, 'admin', NULL, '/system/11', '127.0.0.1', '内网IP', '{\"deploymentQuantity\":2,\"deploymentTime\":\"2020-07-09 00:00:00\",\"id\":32,\"params\":{},\"planeType\":\"1\",\"troops\":\"2\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 13:55:01');
INSERT INTO `sys_oper_log` VALUES (244, '8:装备部署数据', 2, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.edit()', 'PUT', 1, 'admin', NULL, '/system/11', '127.0.0.1', '内网IP', '{\"id\":33,\"params\":{},\"planeType\":\"1\",\"troops\":\"2\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 13:55:11');
INSERT INTO `sys_oper_log` VALUES (245, '8:装备部署数据', 2, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.edit()', 'PUT', 1, 'admin', NULL, '/system/11', '127.0.0.1', '内网IP', '{\"deploymentQuantity\":22,\"deploymentTime\":\"2022-12-07 00:00:00\",\"id\":33,\"params\":{},\"planeType\":\"1\",\"troops\":\"2\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 13:55:23');
INSERT INTO `sys_oper_log` VALUES (246, '8:装备部署数据', 2, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.edit()', 'PUT', 1, 'admin', NULL, '/system/11', '127.0.0.1', '内网IP', '{\"deploymentQuantity\":323232,\"deploymentTime\":\"2022-12-14 00:00:00\",\"id\":34,\"params\":{},\"planeType\":\"\",\"troops\":\"33\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 13:55:37');
INSERT INTO `sys_oper_log` VALUES (247, '8:装备部署数据', 2, 'com.ruoyi.project.system.controller.EquipmentDeploymentData11Controller.edit()', 'PUT', 1, 'admin', NULL, '/system/11', '127.0.0.1', '内网IP', '{\"deploymentQuantity\":323232,\"deploymentTime\":\"2022-12-14 00:00:00\",\"id\":34,\"params\":{},\"planeType\":\"22A\",\"troops\":\"33\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 14:04:45');
INSERT INTO `sys_oper_log` VALUES (248, '代码生成', 6, 'com.ruoyi.project.tool.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/tool/gen/importTable', '127.0.0.1', '内网IP', '\"equipment_use_data_12\"', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 14:25:13');
INSERT INTO `sys_oper_log` VALUES (249, '12：装备使用数据', 2, 'com.ruoyi.project.system.controller.EquipmentUseData12Controller.edit()', 'PUT', 1, 'admin', NULL, '/system/12', '127.0.0.1', '内网IP', '{\"date\":\"2022-11-09 00:00:00\",\"flightHours\":555,\"id\":1,\"params\":{},\"planeType\":\"机型1A\",\"troops\":\"部队1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 14:33:58');
INSERT INTO `sys_oper_log` VALUES (250, '数据管理', 6, 'com.ruoyi.project.system.controller.QualityProblemController.importData()', 'POST', 1, 'admin', NULL, '/system/dev/importData', '127.0.0.1', '内网IP', 'false', '{\"msg\":\"恭喜您，数据已全部导入成功！共 2 条，数据如下：<br/>1、数据 质量问题8 导入成功<br/>2、数据 质量问题9 导入成功\",\"code\":200}', 0, NULL, '2022-12-04 19:20:11');
INSERT INTO `sys_oper_log` VALUES (251, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"firstCountAnalysis/index.vue\",\"createTime\":\"2022-12-03 20:47:39\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2016,\"menuName\":\"数据分析-1\",\"menuType\":\"C\",\"orderNum\":10,\"params\":{},\"parentId\":0,\"path\":\"firstCountAnalysis\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-04 19:37:02');
INSERT INTO `sys_oper_log` VALUES (252, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"createBy\":\"admin\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"原因分析汇总\",\"menuType\":\"C\",\"orderNum\":10,\"params\":{},\"parentId\":0,\"path\":\"change/\",\"status\":\"0\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-07 14:00:51');
INSERT INTO `sys_oper_log` VALUES (253, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"change/analysis\",\"createTime\":\"2022-12-07 14:00:51\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2017,\"menuName\":\"原因分析汇总\",\"menuType\":\"C\",\"orderNum\":10,\"params\":{},\"parentId\":0,\"path\":\"changeAnalysis\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-07 14:01:34');
INSERT INTO `sys_oper_log` VALUES (254, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"children\":[],\"component\":\"change/analysis\",\"createTime\":\"2022-12-07 14:00:51\",\"icon\":\"#\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2017,\"menuName\":\"原因分析汇总\",\"menuType\":\"C\",\"orderNum\":11,\"params\":{},\"parentId\":0,\"path\":\"changeAnalysis\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-07 14:01:57');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES (1, 'ceo', '董事长', 1, '0', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_post` VALUES (2, 'se', '项目经理', 2, '0', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_post` VALUES (3, 'hr', '人力资源', 3, '0', 'admin', '2022-11-29 20:36:32', '', NULL, '');
INSERT INTO `sys_post` VALUES (4, 'user', '普通员工', 4, '0', 'admin', '2022-11-29 20:36:32', '', NULL, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2022-11-29 20:36:32', '', NULL, '超级管理员');
INSERT INTO `sys_role` VALUES (2, '普通角色', 'common', 2, '2', 1, 1, '0', '0', 'admin', '2022-11-29 20:36:32', '', NULL, '普通角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES (2, 100);
INSERT INTO `sys_role_dept` VALUES (2, 101);
INSERT INTO `sys_role_dept` VALUES (2, 105);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 4);
INSERT INTO `sys_role_menu` VALUES (2, 100);
INSERT INTO `sys_role_menu` VALUES (2, 101);
INSERT INTO `sys_role_menu` VALUES (2, 102);
INSERT INTO `sys_role_menu` VALUES (2, 103);
INSERT INTO `sys_role_menu` VALUES (2, 104);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 106);
INSERT INTO `sys_role_menu` VALUES (2, 107);
INSERT INTO `sys_role_menu` VALUES (2, 108);
INSERT INTO `sys_role_menu` VALUES (2, 109);
INSERT INTO `sys_role_menu` VALUES (2, 110);
INSERT INTO `sys_role_menu` VALUES (2, 111);
INSERT INTO `sys_role_menu` VALUES (2, 112);
INSERT INTO `sys_role_menu` VALUES (2, 113);
INSERT INTO `sys_role_menu` VALUES (2, 114);
INSERT INTO `sys_role_menu` VALUES (2, 115);
INSERT INTO `sys_role_menu` VALUES (2, 116);
INSERT INTO `sys_role_menu` VALUES (2, 117);
INSERT INTO `sys_role_menu` VALUES (2, 500);
INSERT INTO `sys_role_menu` VALUES (2, 501);
INSERT INTO `sys_role_menu` VALUES (2, 1000);
INSERT INTO `sys_role_menu` VALUES (2, 1001);
INSERT INTO `sys_role_menu` VALUES (2, 1002);
INSERT INTO `sys_role_menu` VALUES (2, 1003);
INSERT INTO `sys_role_menu` VALUES (2, 1004);
INSERT INTO `sys_role_menu` VALUES (2, 1005);
INSERT INTO `sys_role_menu` VALUES (2, 1006);
INSERT INTO `sys_role_menu` VALUES (2, 1007);
INSERT INTO `sys_role_menu` VALUES (2, 1008);
INSERT INTO `sys_role_menu` VALUES (2, 1009);
INSERT INTO `sys_role_menu` VALUES (2, 1010);
INSERT INTO `sys_role_menu` VALUES (2, 1011);
INSERT INTO `sys_role_menu` VALUES (2, 1012);
INSERT INTO `sys_role_menu` VALUES (2, 1013);
INSERT INTO `sys_role_menu` VALUES (2, 1014);
INSERT INTO `sys_role_menu` VALUES (2, 1015);
INSERT INTO `sys_role_menu` VALUES (2, 1016);
INSERT INTO `sys_role_menu` VALUES (2, 1017);
INSERT INTO `sys_role_menu` VALUES (2, 1018);
INSERT INTO `sys_role_menu` VALUES (2, 1019);
INSERT INTO `sys_role_menu` VALUES (2, 1020);
INSERT INTO `sys_role_menu` VALUES (2, 1021);
INSERT INTO `sys_role_menu` VALUES (2, 1022);
INSERT INTO `sys_role_menu` VALUES (2, 1023);
INSERT INTO `sys_role_menu` VALUES (2, 1024);
INSERT INTO `sys_role_menu` VALUES (2, 1025);
INSERT INTO `sys_role_menu` VALUES (2, 1026);
INSERT INTO `sys_role_menu` VALUES (2, 1027);
INSERT INTO `sys_role_menu` VALUES (2, 1028);
INSERT INTO `sys_role_menu` VALUES (2, 1029);
INSERT INTO `sys_role_menu` VALUES (2, 1030);
INSERT INTO `sys_role_menu` VALUES (2, 1031);
INSERT INTO `sys_role_menu` VALUES (2, 1032);
INSERT INTO `sys_role_menu` VALUES (2, 1033);
INSERT INTO `sys_role_menu` VALUES (2, 1034);
INSERT INTO `sys_role_menu` VALUES (2, 1035);
INSERT INTO `sys_role_menu` VALUES (2, 1036);
INSERT INTO `sys_role_menu` VALUES (2, 1037);
INSERT INTO `sys_role_menu` VALUES (2, 1038);
INSERT INTO `sys_role_menu` VALUES (2, 1039);
INSERT INTO `sys_role_menu` VALUES (2, 1040);
INSERT INTO `sys_role_menu` VALUES (2, 1041);
INSERT INTO `sys_role_menu` VALUES (2, 1042);
INSERT INTO `sys_role_menu` VALUES (2, 1043);
INSERT INTO `sys_role_menu` VALUES (2, 1044);
INSERT INTO `sys_role_menu` VALUES (2, 1045);
INSERT INTO `sys_role_menu` VALUES (2, 1046);
INSERT INTO `sys_role_menu` VALUES (2, 1047);
INSERT INTO `sys_role_menu` VALUES (2, 1048);
INSERT INTO `sys_role_menu` VALUES (2, 1049);
INSERT INTO `sys_role_menu` VALUES (2, 1050);
INSERT INTO `sys_role_menu` VALUES (2, 1051);
INSERT INTO `sys_role_menu` VALUES (2, 1052);
INSERT INTO `sys_role_menu` VALUES (2, 1053);
INSERT INTO `sys_role_menu` VALUES (2, 1054);
INSERT INTO `sys_role_menu` VALUES (2, 1055);
INSERT INTO `sys_role_menu` VALUES (2, 1056);
INSERT INTO `sys_role_menu` VALUES (2, 1057);
INSERT INTO `sys_role_menu` VALUES (2, 1058);
INSERT INTO `sys_role_menu` VALUES (2, 1059);
INSERT INTO `sys_role_menu` VALUES (2, 1060);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 103, 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-12-07 21:21:50', 'admin', '2022-11-29 20:36:32', '', '2022-12-07 21:21:51', '管理员');
INSERT INTO `sys_user` VALUES (2, 105, 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-11-29 20:36:32', 'admin', '2022-11-29 20:36:32', '', NULL, '测试员');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES (1, 1);
INSERT INTO `sys_user_post` VALUES (2, 2);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
