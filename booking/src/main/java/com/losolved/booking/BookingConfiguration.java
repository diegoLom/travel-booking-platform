package com.losolved.booking;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import com.losolved.booking.configuration.DataSourceProperties;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
public class BookingConfiguration {

}
