package pagina.demo.libreria.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pagina.demo.libreria.dto.AutorDto;
import pagina.demo.libreria.servicios.AutorServicio;
import pagina.demo.libreria.servicios.EjemploService;

/**
 * @author José Luis Jofre
 * @Date 30/1/23
 */

@RestController
@RequestMapping("/api/ejemplo")
public class EjemploController {

  private static final Logger LOGGER = LoggerFactory.getLogger(EjemploController.class);

  private final EjemploService ejemploService;

  private final AutorServicio autorServicio;

  public EjemploController(EjemploService ejemploService, AutorServicio autorServicio) {
    this.ejemploService = ejemploService;
    this.autorServicio = autorServicio;
  }

  /**
   * Métodos HTTP:
   * @GetMapping
   * @PostMapping
   * @PutMapping
   * @DeleteMapping
   *
   *
   * Importante!! Como buena practica, no deberían tener alguna lógica dentro
   * de los métodos del controller. Solo la llamada a los serives.
   *
   *
   */
  @GetMapping
  public void callMethod(@RequestParam String param){
    ejemploService.metodo1(param);
  }


  @GetMapping
  public String callMethod2(@RequestParam String param1, @RequestParam String param2){
    return ejemploService.metodo2(param1, param2);
  }

  @GetMapping("/autor")
  public List<AutorDto> findAll(){
    return autorServicio.findAll();
  }
}
