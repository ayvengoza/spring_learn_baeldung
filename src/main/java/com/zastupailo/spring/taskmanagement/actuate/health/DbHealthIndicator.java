package com.zastupailo.spring.taskmanagement.actuate.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DbHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if (checkDbStatus()) {
            return Health.up().build();
        } else {
            return Health.down()
                    .withDetail("Error Code", 503)
                    .build();
        }
    }

    private boolean checkDbStatus() {
        return false;
    }
}
