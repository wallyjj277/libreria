package pagina.demo.libreria.servicios.impl;

import org.springframework.stereotype.Service;
import pagina.demo.libreria.repositorio.AutorRepositorio;
import pagina.demo.libreria.servicios.EjemploService;

/**
 * @author José Luis Jofre
 * @Date 30/1/23
 */

/**
 * Esta clase es la que lleva la lógica para la implementación de los métodos.
 * Una buena práctica es que lleve el mismo nombre que la interfaz, solo que se le agrega 'impl'
 */
@Service
public class EjemploServiceImpl implements EjemploService {


  // En vez de usar @Autowired para la inyección de dependencias,
  // es mejor usar Inyección por Contructor

  private final AutorRepositorio autorRepositorio;

  public EjemploServiceImpl(AutorRepositorio autorRepositorio) {
    this.autorRepositorio = autorRepositorio;
  }


  @Override
  public void metodo1(String param) {

  }

  @Override
  public String metodo2(String param1, String param2) {
    return null;
  }
}
