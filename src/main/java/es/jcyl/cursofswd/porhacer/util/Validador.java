package es.jcyl.cursofswd.porhacer.util;

import es.jcyl.cursofswd.porhacer.modelos.PorHacer;

public class Validador {

    public static boolean validar(PorHacer ph){
        if (ph.getId() > 0){
            return false;
        }
        return true;
    }

}
