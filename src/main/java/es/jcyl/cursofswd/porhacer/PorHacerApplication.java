package es.jcyl.cursofswd.porhacer;

import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import es.jcyl.cursofswd.porhacer.repositorios.PorHacerRepositorio;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PorHacerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PorHacerApplication.class, args);
    }


    @Bean
    public CommandLineRunner setup(PorHacerRepositorio repo) {
        return (args) -> {
            repo.save(new PorHacer("Eliminar imports no usados", true));
            repo.save(new PorHacer("Limpiar el código", true));
            repo.save(new PorHacer("Construir artefactos", false));
            repo.save(new PorHacer("Desplegar aplicación", true));
            //logger.info("The sample data has been generated");
        };
    }

}
