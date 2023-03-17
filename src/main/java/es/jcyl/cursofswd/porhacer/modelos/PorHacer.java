package es.jcyl.cursofswd.porhacer.modelos;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name="TD_PORHACER")
@Data
public class PorHacer {

    @Id
    @GeneratedValue
    @Column(name="id", updatable = false)
    private long id;
    @Column(name="texto", length=1024, nullable = false)
    private String texto;
    @Column(name="completado", nullable = false)
    private boolean completedo = false;

}

