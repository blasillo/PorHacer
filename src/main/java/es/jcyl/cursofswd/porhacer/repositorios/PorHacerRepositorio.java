package es.jcyl.cursofswd.porhacer.repositorios;

import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PorHacerRepositorio extends JpaRepository<PorHacer,Long> {

    List<PorHacer> findByTextoContains (String text );

    List<PorHacer> findByCompletadoFalse ();

    @Query ("select p from  PorHacer p where p.completado = true")
    List<PorHacer> buscarCompletados ();

}
