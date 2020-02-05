package com.herculesapi.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class ServiceStatus implements ReactiveHealthIndicator {

	@Override
	public Mono<Health> health() {
		return checkServiceStatus().onErrorResume(ex -> Mono.just(new Health.Builder().down(ex).build()));
	}

	private Mono<Health> checkServiceStatus() {
		return Mono.just(new Health.Builder().up().build());
	}

}
