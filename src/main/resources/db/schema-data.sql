CREATE DATABASE spring_demo;

USE spring_demo;

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`
(
    `account_id`   INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '主键id',
    `account_name` VARCHAR(50) NOT NULL COMMENT '用户名',
    `password`     VARCHAR(50) NOT NULL COMMENT '密码'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '用户表';

INSERT INTO `account`
VALUES (NULL, 'Tom', '123456');

INSERT INTO `account`
VALUES (NULL, 'Bob', '654321');

INSERT INTO `account`
VALUES (NULL, 'Jackson', 'abc1');

INSERT INTO `account`
VALUES (NULL, 'Pony', '666');

INSERT INTO `account`
VALUES (NULL, 'Alice', 'x1c2');

INSERT INTO `account`
VALUES (NULL, 'Belen', '369');

INSERT INTO `account`
VALUES (NULL, 'Cherry', '987');

INSERT INTO `account`
VALUES (NULL, 'Yuri', '111');

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`
(
    `id`           INT(11)      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `address_name` VARCHAR(100) NOT NULL COMMENT '地址名',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '地址表';

INSERT INTO `address`
VALUES (NULL, 'BeiJing');

INSERT INTO `address`
VALUES (NULL, 'ShangHai');

INSERT INTO `address`
VALUES (NULL, 'GuangDong');

INSERT INTO `address`
VALUES (NULL, 'ShenZhen');

ALTER TABLE `account`
    ADD COLUMN `address_id` INT(11);

UPDATE `account`
SET address_id = 1
where account_id = 1;

UPDATE `account`
SET address_id = 1
where account_id = 2;


UPDATE `account`
SET address_id = 3
where account_id = 3;

UPDATE `account`
SET address_id = 4
where account_id = 4;