CREATE TABLE `dbfpyme`.`producto` (`id_prod` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT , `nombre_prod` VARCHAR(25) NOT NULL ,
                                   `precio` INT UNSIGNED NOT NULL , `estado` VARCHAR(10) NOT NULL ,
                                   `imagen` VARCHAR(255) NOT NULL , `descripcion` VARCHAR(255) NOT NULL ,
                                   PRIMARY KEY (`id_prod`)) ENGINE = InnoDB;

INSERT INTO `producto` (`id_prod`, `nombre_prod`, `precio`, `estado`, `imagen`, `descripcion`) VALUES ('1', 'pepinos',
                            '2500', 'sos', 'https://www.gastronomiavasca.net/uploads/image/file/3406/w700_pepino.jpg',
                                                                                                       'ricos pepinos');

CREATE TABLE `dbfpyme`.`sucursal` (`id_suc` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT , `nombre_suc` VARCHAR(25) NOT NULL ,
                            `direccion` VARCHAR(50) NOT NULL , `imagen` VARCHAR(255) NULL , `email` VARCHAR(50) NOT NULL ,
                            `telefono` VARCHAR(15) NOT NULL , PRIMARY KEY (`id_suc`)) ENGINE = InnoDB;

CREATE TABLE `dbfpyme`.`usuario` (`id_usuario` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
                            `nombre_usuario` VARCHAR(25) NOT NULL , `correo` VARCHAR(50) NOT NULL ,
                            `telefono` VARCHAR(15) NOT NULL , `contraseña` VARCHAR(20) NOT NULL ,
                            `rol` VARCHAR(6) NOT NULL , PRIMARY KEY (`id_usuario`)) ENGINE = InnoDB;