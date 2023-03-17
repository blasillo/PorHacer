package es.jcyl.cursofswd.porhacer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import es.jcyl.cursofswd.porhacer.repositorios.PorHacerRepositorio;
import es.jcyl.cursofswd.porhacer.servicios.PorHacerServicioImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class PorHacerServicioTest {

    @Mock
    private PorHacerRepositorio repo;

    @InjectMocks
    private PorHacerServicioImpl servicio;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllToDo(){
        List<PorHacer> toDoList = new ArrayList<PorHacer>();
        toDoList.add(new PorHacer(1,"Todo Sample 1",true));
        toDoList.add(new PorHacer(2,"Todo Sample 2",true));
        toDoList.add(new PorHacer(3,"Todo Sample 3",false));
        when(repo.findAll()).thenReturn(toDoList);

        List<PorHacer> result = servicio.obtenerTodo();
        assertEquals(3, result.size());
    }
}
