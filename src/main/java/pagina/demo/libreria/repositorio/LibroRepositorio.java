package pagina.demo.libreria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pagina.demo.libreria.entidades.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro,String> {
    // comandos para buscar libro por id, autor,editorial
}
