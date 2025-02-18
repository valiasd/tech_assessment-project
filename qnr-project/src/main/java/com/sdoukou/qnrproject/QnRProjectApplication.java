package com.sdoukou.qnrproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class  QnRProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(QnRProjectApplication.class, args);
	}
}
