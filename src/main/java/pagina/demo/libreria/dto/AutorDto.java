package pagina.demo.libreria.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author José Luis Jofre
 * @Date 3/2/23
 */
@Setter
@Getter
@Builder
public class AutorDto {

  private String id;
  private String nombre;
  private Boolean alta;

}
