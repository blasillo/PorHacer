package es.jcyl.cursofswd.porhacer.modelos;

import lombok.*;

import javax.persistence.SecondaryTable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Respuesta {
        private int estado;
        private String mensaje;
}