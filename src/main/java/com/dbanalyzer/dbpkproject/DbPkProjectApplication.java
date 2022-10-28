package com.dbanalyzer.dbpkproject;

import com.dbanalyzer.dbpkproject.controllers.PerformDbActionController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DbPkProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbPkProjectApplication.class, args);
	}

}
