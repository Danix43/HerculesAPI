package com.herculesapi.actuator;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {

	@Override
	public Health health() {
		int errorCode = check();
		if (errorCode != 0) {
			return Health.down().withDetail("Error Code: ", errorCode).build();
		}
		return Health.up().withDetails(constructDetails()).build();
//		return Health.up().withDetail("Release: ", LocalDateTime.now().toString()).build();
	}

	private Map<String, String> constructDetails() {
		Map<String, String> details = new HashMap<>();

		details.put("System status", "All Operating");
		details.put("Release", LocalDateTime.now().toString());
		details.put("Test for", "Owl Project");

		return details;
	}

	private int check() {
		return 0;
	}

}
