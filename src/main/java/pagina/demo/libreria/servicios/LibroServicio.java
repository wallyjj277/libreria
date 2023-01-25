package pagina.demo.libreria.servicios;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pagina.demo.libreria.entidades.Autor;
import pagina.demo.libreria.entidades.Editorial;
import pagina.demo.libreria.entidades.Libro;
import pagina.demo.libreria.errores.ErrorServicio;
import pagina.demo.libreria.repositorio.LibroRepositorio;

import java.util.Date;
import java.util.Optional;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio libroRepositorio;

    public void registrar(Long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) throws ErrorServicio {
        validar(isbn, titulo, anio, ejemplares, autor, editorial);

        Libro libro = new Libro();

        libro.setTitulo(titulo);
        libro.setIsbn(isbn);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setFechaalta(new Date());

        libroRepositorio.save(libro);

    }

    public void modificar(String id, Long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) throws ErrorServicio {
        validar(isbn, titulo, anio, ejemplares, autor, editorial);

        Optional<Libro> respuesta = libroRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            libro.setTitulo(titulo);
            libro.setIsbn(isbn);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setAutor(autor);
            libro.setEditorial(editorial);

            libroRepositorio.save(libro);
        } else
            throw new  ErrorServicio("no se encontro el libro solicitado");

    }

    public void deshabilitar(String id) throws ErrorServicio{
        Optional<Libro> respuesta = libroRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            libro.setFechabaja(new Date());
            libroRepositorio.save(libro);
        } else {
            throw new ErrorServicio("no se encontro el libro solicitado");
        }

    }

    public void validar(Long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) throws ErrorServicio {
        if (isbn == null) {
            throw new ErrorServicio("el isbn no puede estar vacio");
        }

        if (titulo == null || titulo.isEmpty()) {
            throw new ErrorServicio("el titulo no puede estar vacio");
        }

        if (anio == null) {
            throw new ErrorServicio("el año no puede estar vacio");
        }

        if (ejemplares == null || ejemplares <= 0) {
            throw new ErrorServicio("ejemplare no puede estar vacio");
        }

        if (autor == null) {
            throw new ErrorServicio("el autor no puede estar vacio");
        }

        if (editorial == null) {
            throw new ErrorServicio("la editorial no puede estar vacia");
        }
    }
}
