package es.jcyl.cursofswd.porhacer;

import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import es.jcyl.cursofswd.porhacer.repositorios.PorHacerRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class PorHacerRepositorioTest {


    @Autowired
    PorHacerRepositorio repositorio;


    @Test
    public void deberia_inyectar_repositorio() {
        assertThat(repositorio).isNotNull();
    }

    @Test
    public void deberiaBuscarNoCompletados() {
        List<PorHacer> lista = repositorio.findByCompletadoFalse();
        assertThat( lista ).hasSize(1);
    }


    @Test
    public void deberiaBuscarCompletados() {
        List<PorHacer> lista = repositorio.buscarCompletados();
        assertThat( lista ).hasSize(3);
    }








}
