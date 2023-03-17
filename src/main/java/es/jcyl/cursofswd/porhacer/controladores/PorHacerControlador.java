package es.jcyl.cursofswd.porhacer.controladores;

import es.jcyl.cursofswd.porhacer.excepciones.PorHacerExcepcion;
import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import es.jcyl.cursofswd.porhacer.modelos.Respuesta;
import es.jcyl.cursofswd.porhacer.servicios.PorHacerServicio;
import es.jcyl.cursofswd.porhacer.util.Validador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PorHacerControlador {
    @Autowired
    private PorHacerServicio servicio;

    @RequestMapping(value="/porhacer", method= RequestMethod.GET)
    public ResponseEntity<List<PorHacer>> obtenerTodo(){
        return new ResponseEntity<List<PorHacer>>( servicio.obtenerTodo() , HttpStatus.OK);
    }

    @RequestMapping(value = "/porhacer/{id}", method = RequestMethod.GET)
    public ResponseEntity<PorHacer> getToDoById(@PathVariable("id") long id) throws PorHacerExcepcion {
        //logger.info("ToDo id to return " + id);
        PorHacer toDo = servicio.obtenerPorId(id);
        if (toDo == null || toDo.getId() <= 0){
            throw new PorHacerExcepcion("No exite");
        }
        return new ResponseEntity<PorHacer>(servicio.obtenerPorId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/porhacer", method = RequestMethod.POST)
    public ResponseEntity<PorHacer> nuevo (@RequestBody PorHacer payload) throws PorHacerExcepcion{
        //logger.info("Payload to save " + payload);
        if (!Validador.validar(payload)){
            throw new PorHacerExcepcion("Elemento mal formado");
        }
        return new ResponseEntity<PorHacer>(servicio.guardarporHacer(payload), HttpStatus.OK);
    }

    @RequestMapping(value = "/porhacer", method = RequestMethod.PATCH)
    public ResponseEntity<PorHacer>  actualizar (@RequestBody PorHacer payload) throws PorHacerExcepcion{
        //logger.info("Payload to update " + payload);
        PorHacer ph = servicio.obtenerPorId(payload.getId());
        if (ph == null || ph.getId() <= 0){
            throw new PorHacerExcepcion("No existe el elemento");
        }
        return new ResponseEntity<PorHacer>(servicio.guardarporHacer(payload), HttpStatus.OK);
    }

    @RequestMapping(value = "/porhacer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Respuesta> eliminarPorId (@PathVariable("id") long id) throws PorHacerExcepcion{
        //logger.info("ToDo id to remove " + id);
        PorHacer ph = servicio.obtenerPorId(id);
        if (ph == null || ph.getId() <= 0){
            throw new PorHacerExcepcion("El elemento no existe");
        }
        servicio.eliminarPorHacer(ph);
        return new ResponseEntity<Respuesta>(new Respuesta(HttpStatus.OK.value(), "Elemento eliminado"), HttpStatus.OK);
    }
}
