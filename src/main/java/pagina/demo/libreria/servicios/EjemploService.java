package pagina.demo.libreria.servicios;

/**
 * @author José Luis Jofre
 * @Date 30/1/23
 */

/**
 * Una buena práctica es crear para cada servicio, una interfaz que contenga los métodos a implementar.
 * Luego tendremos una clase que implemente los métodos de esta interfaz
 */
public interface EjemploService {

  void metodo1(String param);

  String metodo2(String param1, String param2);

}
