package com.tech.mkblogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class)
public class JpaEntityGraphUsing3rdPartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaEntityGraphUsing3rdPartyApplication.class, args);
	}

}
