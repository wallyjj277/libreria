package pagina.demo.libreria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pagina.demo.libreria.entidades.Cliente;
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,String> {

}
