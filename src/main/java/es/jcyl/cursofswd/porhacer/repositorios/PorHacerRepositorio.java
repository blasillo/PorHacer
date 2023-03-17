package es.jcyl.cursofswd.porhacer.repositorios;

import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorHacerRepositorio extends JpaRepository<PorHacer,Long> {


}
