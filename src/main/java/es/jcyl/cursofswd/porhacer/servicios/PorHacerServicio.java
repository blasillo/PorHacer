package es.jcyl.cursofswd.porhacer.servicios;

import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PorHacerServicio {

    public List<PorHacer> obtenerTodo();
    public PorHacer obtenerPorId (Long id);
    public PorHacer guardarporHacer (PorHacer ph);
    public void eliminarPorHacer(PorHacer ph);

}

