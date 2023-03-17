package es.jcyl.cursofswd.porhacer.modelos;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="TD_PORHACER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PorHacer {

    @Id
    @GeneratedValue
    @Column(name="id", updatable = false)
    private long id;
    @Column(name="texto", length=1024, nullable = false)
    private String texto;
    @Column(name="completado", nullable = false)
    private boolean completado = false;

    public PorHacer(String texto, boolean completedo) {
        this.texto = texto;
        this.completado = completedo;
    }


}

