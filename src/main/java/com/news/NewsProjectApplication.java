package com.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.news"})
@ComponentScan({"com.news"})
@EntityScan("com.news.model")
@EnableJpaRepositories("com.news.repository")
public class NewsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsProjectApplication.class, args);
	}
	
}
