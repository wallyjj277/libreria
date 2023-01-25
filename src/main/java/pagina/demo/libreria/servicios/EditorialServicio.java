package pagina.demo.libreria.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pagina.demo.libreria.entidades.Editorial;
import pagina.demo.libreria.errores.ErrorServicio;
import pagina.demo.libreria.repositorio.EditorialRepositorio;

import java.util.Optional;

@Service
public class EditorialServicio {
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    public void cargar(String nombre, Boolean alta) throws ErrorServicio {

        validar(nombre, alta);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(alta);

        editorialRepositorio.save(editorial);
    }

    public void modificar(String id, String nombre, Boolean alta) throws ErrorServicio{
        validar(nombre,alta);
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        if (respuesta.isPresent()){
            Editorial editorial = respuesta.get();
            editorial.setNombre(nombre);
        } else {
            throw new ErrorServicio("la id de la editorial no se encuentra cargada");
        }
    }

    public void baja(String id, Boolean alta) throws ErrorServicio{

        Optional<Editorial> respuesta = editorialRepositorio.findById(id);

        if (respuesta.isPresent()){
            Editorial editorial = respuesta.get();
           editorial.setAlta(alta == false);
            editorialRepositorio.save(editorial);

        } else {
            throw new ErrorServicio("no se encuentra la editorial que busca");
        }
    }

    public void validar(String nombre, Boolean alta) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("el nombre no puede estar vacio");
        }

        if (alta == null || alta == false) {
            throw new ErrorServicio("la editorial no fue dada de alta correctamente");
        }
    }
}
