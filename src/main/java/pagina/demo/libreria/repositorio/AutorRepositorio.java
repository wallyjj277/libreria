package pagina.demo.libreria.repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pagina.demo.libreria.entidades.Autor;

import java.util.List;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor,String> {
    // comandos para buscar autor por id
@Query("SELECT c FROM Libro WHERE c.autor.id = :id ORDER BY c.fechaalta DESC  ")
     List<Autor> buscarAutor(@Param("id") String id);

    Autor findByIdAndAlta(String id, Boolean alta);


}
