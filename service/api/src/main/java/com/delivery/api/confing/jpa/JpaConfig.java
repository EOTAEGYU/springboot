package com.delivery.api.confing.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Bean에 수동으로 주입하는 과정
@Configuration
@EntityScan(basePackages = "com.delivery.db")
@EnableJpaRepositories(basePackages = "com.delivery.db")
public class JpaConfig {
}
