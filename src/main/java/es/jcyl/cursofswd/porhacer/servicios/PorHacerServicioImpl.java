package es.jcyl.cursofswd.porhacer.servicios;

import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import es.jcyl.cursofswd.porhacer.repositorios.PorHacerRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PorHacerServicioImpl implements PorHacerServicio {

    @Autowired
    private PorHacerRepositorio repo;

    @Override
    public List<PorHacer> obtenerTodo() {
        return repo.findAll();
    }

    @Override
    public PorHacer obtenerPorId(Long id) {
        return repo.findById( id ).get();
    }

    @Override
    @Transactional
    public PorHacer guardarporHacer(PorHacer ph) {
        return repo.save(ph);
    }

    @Override
    @Transactional
    public void eliminarPorHacer(PorHacer ph) {
        repo.delete(ph);
    }
}
