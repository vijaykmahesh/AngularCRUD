package com.bezkoder.spring.jpa.postgresql;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.bezkoder.spring.jpa.postgresql.repository")
public class JpaConfig {

}
