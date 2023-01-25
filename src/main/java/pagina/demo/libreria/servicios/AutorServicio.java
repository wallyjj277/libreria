package pagina.demo.libreria.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pagina.demo.libreria.entidades.Autor;
import pagina.demo.libreria.errores.ErrorServicio;
import pagina.demo.libreria.repositorio.AutorRepositorio;

import java.util.Optional;

@Service
public class AutorServicio {
    @Autowired
    private AutorRepositorio autorRepositorio;

    public void registrar(String nombre, Boolean alta) throws ErrorServicio {
        validar(nombre, alta);

        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(alta);

        autorRepositorio.save(autor);
    }

    public void modificar(String nombre, Boolean alta, String id) throws ErrorServicio{
        validar(nombre, alta);

        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent()){
            Autor autor = respuesta.get();
            autor.setNombre(nombre);

            autorRepositorio.save(autor);
        }

    }

    public void baja(String id, Boolean alta) throws ErrorServicio{
        Optional<Autor> respuesta = autorRepositorio.findById(id);

        if (respuesta.isPresent()){
            Autor autor = respuesta.get();
            autor.setAlta(alta == false);
            autorRepositorio.save(autor);

        } else {
            throw new ErrorServicio("no se encuentra el autor que busca");
        }
    }

    public void validar(String nombre, Boolean alta) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("el nombre no puede estar vacio");
        }

        if (alta == null || alta == false) {
            throw new ErrorServicio("el autor no fue dado de alta correctamente");
        }
    }

}
