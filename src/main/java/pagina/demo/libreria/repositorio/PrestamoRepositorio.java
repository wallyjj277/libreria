package pagina.demo.libreria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pagina.demo.libreria.entidades.Prestamo;
@Repository
public interface PrestamoRepositorio extends JpaRepository<Prestamo,String> {
}
