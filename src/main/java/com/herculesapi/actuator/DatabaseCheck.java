package com.herculesapi.actuator;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseCheck implements HealthIndicator {

    private static final Logger log = LoggerFactory.getLogger(DatabaseCheck.class);

    @Autowired
    private DataSource dataSource;

    @Override
    public Health health() {

	// checking database avalability
	try (Connection connection = dataSource.getConnection()) {
	} catch (SQLException e) {
	    log.error(e.getMessage());
	    return Health.down().build();
	}
	return Health.up().build();
    }

}
