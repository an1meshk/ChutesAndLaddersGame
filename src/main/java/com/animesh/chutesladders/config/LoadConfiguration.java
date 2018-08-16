package com.animesh.chutesladders.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Animesh Kumar on 12-08-2018.
 *
 * Spring Java configuration class which bootstraps the application beans
 * It scans the application base package and create all application
 * beans.
 */
@Configuration
@ComponentScan(basePackages = "com.animesh.chutesladders")
public class LoadConfiguration {
}
