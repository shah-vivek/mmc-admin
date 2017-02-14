package com.mmc.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by SGaurav on 05/12/2016.
 */
@EnableJpaRepositories(basePackages = { "com.mmc.repository" })
@EntityScan("com.mmc.entity")
@Configuration
public class DatabaseConfiguration {

}