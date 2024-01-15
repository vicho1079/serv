package com.fpyme.serv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//borrar el exclude cuando se creen entidades jpa y la estructura de la base de datos
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ServApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServApplication.class, args);
	}

}
