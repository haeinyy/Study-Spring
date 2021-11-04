CREATE TABLE `ssafyws`.`product` (
  `seq` INT NOT NULL,
  `item_code` VARCHAR(50) NULL,
  `item_name` VARCHAR(50) NULL,
  `item_prcie` INT NULL,
  `item_corp` INT NULL,
  `item_stat` CHAR(1) NULL,
  `dt_reg` DATETIME NULL,
  `cate_seq` INT NULL DEFAULT NULL,
  PRIMARY KEY (`seq`));