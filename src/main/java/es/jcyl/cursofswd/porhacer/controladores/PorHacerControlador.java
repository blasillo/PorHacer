package es.jcyl.cursofswd.porhacer.controladores;

import es.jcyl.cursofswd.porhacer.excepciones.PorHacerExcepcion;
import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import es.jcyl.cursofswd.porhacer.modelos.Respuesta;
import es.jcyl.cursofswd.porhacer.servicios.PorHacerServicio;
import es.jcyl.cursofswd.porhacer.util.Validador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "PorHacer API", tags = { "PorHacer API" })
public class PorHacerControlador {
    @Autowired
    private PorHacerServicio servicio;


    //@RequestMapping(value="/porhacer", method= RequestMethod.GET)
    @GetMapping("/porhacer")
    @ApiOperation(
            value = "Obtener todos los elementos PorHacer",
            notes = "Obtiene una lista de todos los elementos PorHacer disponibles en el sistema."
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "La solicitud se ha procesado con éxito."),
            @ApiResponse(code = 500, message = "Se ha producido un error interno en el servidor.")
    })
    public ResponseEntity<List<PorHacer>> obtenerTodo(){
        return new ResponseEntity<List<PorHacer>>( servicio.obtenerTodo() , HttpStatus.OK);
    }

    //@RequestMapping(value = "/porhacer/{id}", method = RequestMethod.GET)
    @GetMapping("/porhacer/{id}")
    @ApiOperation(
            value = "Obtener un elemento PorHacer por su ID",
            notes = "Obtiene un elemento PorHacer en base a su ID."
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Se ha encontrado el elemento PorHacer con éxito."),
            @ApiResponse(code = 404, message = "No se ha encontrado el elemento PorHacer."),
            @ApiResponse(code = 500, message = "Se ha producido un error interno en el servidor.")
    })
    public ResponseEntity<PorHacer> getToDoById(@PathVariable("id") long id) throws PorHacerExcepcion {
        //logger.info("ToDo id to return " + id);
        PorHacer toDo = servicio.obtenerPorId(id);
        if (toDo == null || toDo.getId() <= 0){
            throw new PorHacerExcepcion("No exite");
        }
        return new ResponseEntity<PorHacer>(servicio.obtenerPorId(id), HttpStatus.OK);
    }

    //@RequestMapping(value = "/porhacer", method = RequestMethod.POST)
    @PostMapping("/porhacer")
    @ApiOperation(
            value = "Crear un nuevo elemento PorHacer",
            notes = "Crea un nuevo elemento PorHacer con la información proporcionada en el payload."
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "El elemento PorHacer se ha creado correctamente."),
            @ApiResponse(code = 400, message = "El payload proporcionado es incorrecto."),
            @ApiResponse(code = 500, message = "Se ha producido un error interno en el servidor.")
    })
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
