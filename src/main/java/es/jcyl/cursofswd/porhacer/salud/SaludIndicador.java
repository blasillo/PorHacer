package es.jcyl.cursofswd.porhacer.salud;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class SaludIndicador implements HealthIndicator {
    @Override
    public Health health() {
        boolean invalido = Runtime.getRuntime().maxMemory() < (100*1024*1204);
        Status estado = invalido ? Status.DOWN : Status.UP;
        return Health
                .status(estado).withDetail("Código:", "Memoria")
                .build();
    }

}
