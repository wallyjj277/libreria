package pagina.demo.libreria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pagina.demo.libreria.entidades.Editorial;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial,String> {
    //buscar libros que pertenecen a la editorial por id, nombre
}
