/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : book_store_v2

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 09/06/2023 21:02:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_remove` bit(1) NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `quantity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKrq60d7uurp8l09p6dvxua9mhq`(`type_id` ASC) USING BTREE,
  CONSTRAINT `FKrq60d7uurp8l09p6dvxua9mhq` FOREIGN KEY (`type_id`) REFERENCES `book_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'Description 1', 'https://picsum.photos/500/500?random', b'0', 10.99, '5', 'Title 1', 1);
INSERT INTO `book` VALUES (2, 'Description 2', 'https://picsum.photos/500/500?random', b'1', 12.99, '3', 'Title 200', 3);
INSERT INTO `book` VALUES (3, 'Description 3', 'https://picsum.photos/500/500?random', b'0', 100, '8', 'Title 3', 3);
INSERT INTO `book` VALUES (4, 'Description 4', 'https://picsum.photos/500/500?random', b'0', 15.99, '6', 'Title 4', 4);
INSERT INTO `book` VALUES (5, 'Description 5', 'https://picsum.photos/500/500?random', b'0', 11.99, '4', 'Title 5', 1);
INSERT INTO `book` VALUES (6, 'Description 6', 'https://picsum.photos/500/500?random', b'0', 13.99, '2', 'Title 6', 2);
INSERT INTO `book` VALUES (7, 'Description 7', 'https://picsum.photos/500/500?random', b'0', 10.49, '7', 'Title 7', 3);
INSERT INTO `book` VALUES (8, 'Description 8', 'https://picsum.photos/500/500?random', b'0', 14.49, '5', 'Title 8', 4);
INSERT INTO `book` VALUES (9, 'Description 9', 'https://picsum.photos/500/500?random', b'1', 9.99, '3', 'Title 9', 1);
INSERT INTO `book` VALUES (10, 'Description new update', 'https://picsum.photos/500/500?random', b'0', 10.49, '3', 'Title new update', 3);
INSERT INTO `book` VALUES (11, 'Description 11', 'https://picsum.photos/500/500?random', b'0', 10.99, '4', 'Title 11', 3);
INSERT INTO `book` VALUES (12, 'Description 12', 'https://picsum.photos/500/500?random', b'0', 15.99, '2', 'Title 12', 4);
INSERT INTO `book` VALUES (13, 'Description 13', 'https://picsum.photos/500/500?random', b'0', 11.99, '7', 'Title 13', 1);
INSERT INTO `book` VALUES (14, 'Description 14', 'https://picsum.photos/500/500?random', b'0', 13.99, '5', 'Title 14', 2);
INSERT INTO `book` VALUES (15, 'Description 15', 'https://picsum.photos/500/500?random', b'0', 10.49, '3', 'Title 15', 3);
INSERT INTO `book` VALUES (16, 'Description 16', 'https://picsum.photos/500/500?random', b'0', 14.49, '6', 'Title 16', 4);
INSERT INTO `book` VALUES (17, 'Description 17', 'https://picsum.photos/500/500?random', b'0', 9.99, '4', 'Title 17', 1);
INSERT INTO `book` VALUES (18, 'Description 18', 'https://picsum.photos/500/500?random', b'1', 12.99, '2', 'Title 18', 2);
INSERT INTO `book` VALUES (19, 'Description new', 'https://picsum.photos/500/500?random', b'1', 10.49, '3', 'Title new', 3);
INSERT INTO `book` VALUES (20, 'Description new', 'https://picsum.photos/500/500?random', b'1', 10.49, '3', 'Title newsssss', 3);
INSERT INTO `book` VALUES (21, 'mo ta', 'https://picsum.photos/500/500?random', b'1', 1, '10', 'aaa', 3);
INSERT INTO `book` VALUES (22, 'JAVASCRIPT BASIC Mô tả', 'https://picsum.photos/500/500?random', b'0', 222, '12', 'JAVASCRIPT BASIC', 1);

-- ----------------------------
-- Table structure for book_type
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_remove` bit(1) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_type
-- ----------------------------
INSERT INTO `book_type` VALUES (1, b'0', 'Kim Đông');
INSERT INTO `book_type` VALUES (2, b'0', 'Trẻ');
INSERT INTO `book_type` VALUES (3, b'0', 'Hồng Đức');
INSERT INTO `book_type` VALUES (4, b'0', 'Nhà Nước');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_remove` bit(1) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, 'Địa chỉ 1', 'email1@example.com', b'0', 'Khách hàng 1', '1234567890');
INSERT INTO `customer` VALUES (2, 'Địa chỉ 2', 'email2@example.com', b'0', 'Khách hàng 2', '0987654321');
INSERT INTO `customer` VALUES (3, 'Địa chỉ 3', 'email3@example.com', b'0', 'Khách hàng 3', '1112223333');
INSERT INTO `customer` VALUES (4, 'Địa chỉ 4', 'email4@example.com', b'0', 'Khách hàng 4', '4445556666');
INSERT INTO `customer` VALUES (5, 'Địa chỉ 5', 'email5@example.com', b'0', 'Khách hàng 5', '7778889999');
INSERT INTO `customer` VALUES (6, 'Địa chỉ 6', 'email6@example.com', b'0', 'Khách hàng 6', '0123456789');
INSERT INTO `customer` VALUES (7, 'Địa chỉ 7', 'email7@example.com', b'0', 'Khách hàng 7', '9876543210');
INSERT INTO `customer` VALUES (8, 'Địa chỉ 8', 'email8@example.com', b'0', 'Khách hàng 8', '5554443333');
INSERT INTO `customer` VALUES (9, 'Địa chỉ 9', 'email9@example.com', b'0', 'Khách hàng 9', '2221110000');
INSERT INTO `customer` VALUES (10, 'Địa chỉ 10', 'email10@example.com', b'0', 'Khách hàng 10', '6667778888');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_remove` bit(1) NULL DEFAULT NULL,
  `orders_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK624gtjin3po807j3vix093tlf`(`customer_id` ASC) USING BTREE,
  CONSTRAINT `FK624gtjin3po807j3vix093tlf` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, b'0', '2023-06-09', 2);
INSERT INTO `orders` VALUES (2, b'0', '2023-06-09', 10);
INSERT INTO `orders` VALUES (3, b'0', '2023-06-09', 7);
INSERT INTO `orders` VALUES (4, b'0', '2023-06-09', 4);
INSERT INTO `orders` VALUES (5, b'0', '2023-06-09', 10);
INSERT INTO `orders` VALUES (6, b'0', '2023-06-09', 6);
INSERT INTO `orders` VALUES (7, b'0', '2023-06-09', 2);
INSERT INTO `orders` VALUES (8, b'0', '2023-06-09', 8);
INSERT INTO `orders` VALUES (9, b'0', '2023-06-09', 5);
INSERT INTO `orders` VALUES (10, b'0', '2023-06-09', 10);

-- ----------------------------
-- Table structure for orders_detail
-- ----------------------------
DROP TABLE IF EXISTS `orders_detail`;
CREATE TABLE `orders_detail`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_remove` bit(1) NULL DEFAULT NULL,
  `book_id` bigint NULL DEFAULT NULL,
  `orders_id` bigint NULL DEFAULT NULL,
  `quantity` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKh53m9am86l9ohytl283d464vo`(`book_id` ASC) USING BTREE,
  INDEX `FKlt3mrhyikkt94xukyqrv652jd`(`orders_id` ASC) USING BTREE,
  CONSTRAINT `FKh53m9am86l9ohytl283d464vo` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKlt3mrhyikkt94xukyqrv652jd` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders_detail
-- ----------------------------
INSERT INTO `orders_detail` VALUES (1, b'1', 14, 1, 8);
INSERT INTO `orders_detail` VALUES (2, b'0', 12, 4, 18);
INSERT INTO `orders_detail` VALUES (3, b'0', 4, 8, 24);
INSERT INTO `orders_detail` VALUES (4, b'0', 3, 4, 4);
INSERT INTO `orders_detail` VALUES (5, b'0', 12, 7, 9);
INSERT INTO `orders_detail` VALUES (6, b'0', 10, 5, 2);
INSERT INTO `orders_detail` VALUES (7, b'0', 17, 5, 13);
INSERT INTO `orders_detail` VALUES (8, b'0', 4, 5, 27);
INSERT INTO `orders_detail` VALUES (9, b'0', 12, 5, 7);
INSERT INTO `orders_detail` VALUES (10, b'0', 15, 10, 12);
INSERT INTO `orders_detail` VALUES (11, b'0', 15, 6, 7);
INSERT INTO `orders_detail` VALUES (12, b'0', 20, 7, 30);
INSERT INTO `orders_detail` VALUES (13, b'0', 12, 9, 10);
INSERT INTO `orders_detail` VALUES (14, b'0', 9, 6, 17);
INSERT INTO `orders_detail` VALUES (15, b'0', 17, 10, 24);
INSERT INTO `orders_detail` VALUES (16, b'0', 14, 5, 11);
INSERT INTO `orders_detail` VALUES (17, b'0', 14, 7, 11);
INSERT INTO `orders_detail` VALUES (18, b'0', 11, 4, 22);
INSERT INTO `orders_detail` VALUES (19, b'1', 5, 1, 14);
INSERT INTO `orders_detail` VALUES (20, b'0', 18, 8, 7);
INSERT INTO `orders_detail` VALUES (21, b'0', 12, 2, 22);
INSERT INTO `orders_detail` VALUES (22, b'0', 8, 3, 30);
INSERT INTO `orders_detail` VALUES (23, b'1', 4, 1, 20);
INSERT INTO `orders_detail` VALUES (24, b'0', 20, 2, 12);
INSERT INTO `orders_detail` VALUES (25, b'0', 1, 7, 30);
INSERT INTO `orders_detail` VALUES (26, b'0', 7, 5, 21);
INSERT INTO `orders_detail` VALUES (27, b'0', 7, 3, 14);
INSERT INTO `orders_detail` VALUES (28, b'1', 8, 1, 9);
INSERT INTO `orders_detail` VALUES (29, b'0', 2, 3, 27);
INSERT INTO `orders_detail` VALUES (30, b'0', 6, 3, 20);
INSERT INTO `orders_detail` VALUES (31, b'0', 17, 9, 19);
INSERT INTO `orders_detail` VALUES (32, b'0', 21, 2, 6);
INSERT INTO `orders_detail` VALUES (33, b'0', 2, 9, 2);
INSERT INTO `orders_detail` VALUES (34, b'0', 21, 10, 20);
INSERT INTO `orders_detail` VALUES (35, b'0', 18, 2, 6);
INSERT INTO `orders_detail` VALUES (36, b'0', 14, 4, 29);
INSERT INTO `orders_detail` VALUES (37, b'0', 5, 8, 5);
INSERT INTO `orders_detail` VALUES (38, b'0', 4, 6, 28);
INSERT INTO `orders_detail` VALUES (39, b'0', 9, 3, 5);
INSERT INTO `orders_detail` VALUES (40, b'0', 22, 2, 2);
INSERT INTO `orders_detail` VALUES (41, b'0', 1, 6, 23);
INSERT INTO `orders_detail` VALUES (42, b'0', 14, 6, 20);
INSERT INTO `orders_detail` VALUES (43, b'1', 17, 1, 30);
INSERT INTO `orders_detail` VALUES (44, b'0', 4, 7, 29);
INSERT INTO `orders_detail` VALUES (45, b'0', 16, 7, 26);
INSERT INTO `orders_detail` VALUES (46, b'1', 22, 1, 10);
INSERT INTO `orders_detail` VALUES (47, b'0', 10, 10, 1);
INSERT INTO `orders_detail` VALUES (48, b'0', 9, 2, 5);
INSERT INTO `orders_detail` VALUES (49, b'0', 13, 5, 23);
INSERT INTO `orders_detail` VALUES (50, b'0', 7, 6, 10);
INSERT INTO `orders_detail` VALUES (51, b'0', 22, 3, 11);
INSERT INTO `orders_detail` VALUES (52, b'0', 5, 3, 24);
INSERT INTO `orders_detail` VALUES (53, b'0', 19, 5, 24);
INSERT INTO `orders_detail` VALUES (54, b'0', 11, 3, 19);
INSERT INTO `orders_detail` VALUES (55, b'0', 2, 8, 23);
INSERT INTO `orders_detail` VALUES (56, b'0', 14, 9, 28);
INSERT INTO `orders_detail` VALUES (57, b'1', 12, 1, 10);
INSERT INTO `orders_detail` VALUES (58, b'1', 15, 1, 28);
INSERT INTO `orders_detail` VALUES (59, b'0', 9, 7, 14);
INSERT INTO `orders_detail` VALUES (60, b'0', 3, 7, 16);
INSERT INTO `orders_detail` VALUES (61, b'0', 18, 1, 9);
INSERT INTO `orders_detail` VALUES (62, b'0', 16, 6, 22);
INSERT INTO `orders_detail` VALUES (63, b'0', 13, 2, 26);
INSERT INTO `orders_detail` VALUES (64, b'0', 6, 8, 3);
INSERT INTO `orders_detail` VALUES (65, b'0', 18, 10, 27);
INSERT INTO `orders_detail` VALUES (66, b'0', 9, 8, 5);
INSERT INTO `orders_detail` VALUES (67, b'0', 17, 4, 4);
INSERT INTO `orders_detail` VALUES (68, b'0', 8, 8, 4);
INSERT INTO `orders_detail` VALUES (69, b'0', 21, 3, 10);
INSERT INTO `orders_detail` VALUES (70, b'0', 14, 2, 5);
INSERT INTO `orders_detail` VALUES (71, b'0', 22, 5, 25);
INSERT INTO `orders_detail` VALUES (72, b'0', 6, 9, 19);
INSERT INTO `orders_detail` VALUES (73, b'0', 15, 8, 22);
INSERT INTO `orders_detail` VALUES (74, b'0', 6, 1, 21);
INSERT INTO `orders_detail` VALUES (75, b'0', 12, 6, 3);
INSERT INTO `orders_detail` VALUES (76, b'0', 19, 10, 16);
INSERT INTO `orders_detail` VALUES (77, b'0', 19, 1, 12);
INSERT INTO `orders_detail` VALUES (78, b'0', 2, 2, 9);
INSERT INTO `orders_detail` VALUES (79, b'0', 9, 5, 11);
INSERT INTO `orders_detail` VALUES (80, b'0', 1, 8, 25);
INSERT INTO `orders_detail` VALUES (81, b'0', 4, 4, 4);
INSERT INTO `orders_detail` VALUES (82, b'0', 3, 6, 4);
INSERT INTO `orders_detail` VALUES (83, b'0', 10, 6, 7);
INSERT INTO `orders_detail` VALUES (84, b'0', 6, 6, 21);
INSERT INTO `orders_detail` VALUES (85, b'0', 17, 2, 23);
INSERT INTO `orders_detail` VALUES (86, b'0', 10, 8, 23);
INSERT INTO `orders_detail` VALUES (87, b'0', 20, 5, 15);
INSERT INTO `orders_detail` VALUES (88, b'0', 11, 2, 7);
INSERT INTO `orders_detail` VALUES (89, b'0', 20, 3, 17);
INSERT INTO `orders_detail` VALUES (90, b'0', 4, 3, 4);
INSERT INTO `orders_detail` VALUES (91, b'0', 16, 2, 29);
INSERT INTO `orders_detail` VALUES (92, b'0', 19, 6, 14);
INSERT INTO `orders_detail` VALUES (93, b'0', 11, 6, 11);
INSERT INTO `orders_detail` VALUES (94, b'0', 8, 9, 12);
INSERT INTO `orders_detail` VALUES (95, b'0', 5, 5, 27);
INSERT INTO `orders_detail` VALUES (96, b'0', 13, 6, 8);
INSERT INTO `orders_detail` VALUES (97, b'0', 19, 4, 20);
INSERT INTO `orders_detail` VALUES (98, b'0', 13, 1, 13);
INSERT INTO `orders_detail` VALUES (99, b'0', 10, 2, 5);
INSERT INTO `orders_detail` VALUES (100, b'0', 11, 10, 16);

-- ----------------------------
-- Procedure structure for generate_orders
-- ----------------------------
DROP PROCEDURE IF EXISTS `generate_orders`;
delimiter ;;
CREATE PROCEDURE `generate_orders`()
BEGIN
  DECLARE start_id INT DEFAULT 1;
  DECLARE end_id INT DEFAULT 10;

  WHILE start_id <= end_id DO
    INSERT INTO orders (orders_date, customer_id)
    VALUES
      (CURDATE(), start_id);
    SET start_id = start_id + 1;
  END WHILE;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for generate_orders_detail
-- ----------------------------
DROP PROCEDURE IF EXISTS `generate_orders_detail`;
delimiter ;;
CREATE PROCEDURE `generate_orders_detail`()
BEGIN
  DECLARE start_id INT DEFAULT 1;
  DECLARE end_id INT DEFAULT 100;
  DECLARE random_book_id INT;
  DECLARE random_orders_id INT;
  DECLARE is_duplicate INT;

  WHILE start_id <= end_id DO
    SET random_book_id = FLOOR(RAND() * 22) + 1;
    SET random_orders_id = FLOOR(RAND() * 10) + 1;

    SELECT COUNT(*) INTO is_duplicate
    FROM orders_detail
    WHERE book_id = random_book_id AND orders_id = random_orders_id;

    IF is_duplicate = 0 THEN
      INSERT INTO orders_detail (is_remove, book_id, orders_id)
      VALUES (b'0', random_book_id, random_orders_id);
      SET start_id = start_id + 1;
    END IF;
  END WHILE;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
