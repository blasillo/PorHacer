package es.jcyl.cursofswd.porhacer;

import es.jcyl.cursofswd.porhacer.repositorios.PorHacerRepositorio;
import javafx.beans.binding.Bindings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestRepositorio {


    @Autowired
    PorHacerRepositorio repositorio;


    @Test
    public void deberia_inyectar_repositorio() {
        assertThat(repositorio).isNotNull();
    }

    


}
