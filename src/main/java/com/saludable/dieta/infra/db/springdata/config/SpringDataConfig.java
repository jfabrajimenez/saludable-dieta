package com.saludable.dieta.infra.db.springdata.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.saludable.dieta.infra.db.springdata.repository")
@ConfigurationProperties("spring.datasource")
@NoArgsConstructor
@Getter
@Setter
@EnableJpaAuditing
@EntityScan(basePackages = "com.saludable.dieta.infra.db.springdata.entity")
public class SpringDataConfig {}
