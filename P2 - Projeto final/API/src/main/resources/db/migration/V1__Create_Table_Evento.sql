CREATE TABLE `evento` (
	`evento_id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`data_evento` DATETIME NULL DEFAULT NULL,
	`email` VARCHAR(80) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`local` VARCHAR(80) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`quantidade_pessoas` INT(10) NULL DEFAULT NULL,
	`telefone` VARCHAR(80) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	`tema` VARCHAR(80) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	PRIMARY KEY (`evento_id`) USING BTREE
)