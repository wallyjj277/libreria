package pagina.demo.libreria.servicios;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pagina.demo.libreria.entidades.Autor;
import pagina.demo.libreria.entidades.Editorial;
import pagina.demo.libreria.entidades.Libro;
import pagina.demo.libreria.repositorio.LibroRepositorio;

import java.util.Date;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio libroRepositorio;
    public void registrar (Long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial){

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

    public void modificar(String id, Long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial){
        Libro libro = libroRepositorio.findById(id).get();
        libro.setTitulo(titulo);
        libro.setIsbn(isbn);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);

    }
}
