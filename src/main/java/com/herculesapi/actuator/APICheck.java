package com.herculesapi.actuator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class APICheck implements HealthIndicator {

	private static final Logger log = LoggerFactory.getLogger(APICheck.class);

	@Override
	public Health health() {

		// checking to see if got a response from the api
		try {
			URL url = new URL("http://localhost:8080/termometre/all");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));) {
				int responseCode = connection.getResponseCode();

				if (responseCode != 200) {
					return Health.down().build();
				}

				if (!reader.ready()) {
					return Health.down().build();
				}
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Health.up().build();
	}

}
