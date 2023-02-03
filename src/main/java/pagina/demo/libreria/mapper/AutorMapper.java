package pagina.demo.libreria.mapper;

import java.util.List;
import java.util.Objects;
import pagina.demo.libreria.dto.AutorDto;
import pagina.demo.libreria.entidades.Autor;

/**
 * @author José Luis Jofre
 * @Date 3/2/23
 */
public class AutorMapper {


  public static AutorDto fromEntity(Autor entity){
    if (Objects.isNull(entity)) {
      return null;
    }

    return AutorDto.builder()
        .id(entity.getId())
        .nombre(entity.getNombre())
        .alta(entity.getAlta())
        .build();

  }

  public static List<AutorDto> fromEntities(List<Autor> entities){
    return entities.stream()
        .map(AutorMapper::fromEntity)
        .toList();
  }

  public static Autor toEntity(AutorDto dto){
    Autor entity = new Autor();
   entity.setId(dto.getId());
   entity.setNombre(dto.getNombre());
   entity.setAlta(dto.getAlta());

    return entity;
  }

}
