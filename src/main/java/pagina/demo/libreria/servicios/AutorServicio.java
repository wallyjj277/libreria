package pagina.demo.libreria.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pagina.demo.libreria.dto.AutorDto;
import pagina.demo.libreria.entidades.Autor;
import pagina.demo.libreria.errores.ErrorServicio;
import pagina.demo.libreria.mapper.AutorMapper;
import pagina.demo.libreria.repositorio.AutorRepositorio;

import java.util.Optional;

@Service
public class AutorServicio {

    /**
     * REPASAR
     * - Hacer CRUDS de: Autor, Cliente, Editorial
     * - Completar Dtos faltantes
     * - Completar Mappers
     * - Crear Interfaces para los Servicios
     * - Usar nombres en Inglés
     * - Crear Controllers
     * - Docker
     *
     *
     * - Métodos Jpa ya definidos
     *
     * - Instalar DBeaver
     * - Optional
     * - Streams
     */




    // Pasar a Inyección por Contructor

    @Autowired
    private AutorRepositorio autorRepositorio;

    public List<AutorDto> findAll(){

        return AutorMapper.fromEntities(autorRepositorio.findAll());

    }

    public AutorDto findById(String id){
        return autorRepositorio.findById(id)
            .map(AutorMapper::fromEntity)
            .orElseThrow();
    }

    public void findByIdAndAlta(String id, Boolean alta){
        Autor autor = autorRepositorio.findByIdAndAlta("asd", true);
    }
    public void create(String nombre, Boolean alta) throws ErrorServicio {
        validar(nombre, alta);

        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(alta);

        autorRepositorio.save(autor);
    }

    public void update(String nombre, Boolean alta, String id) throws ErrorServicio{
        validar(nombre, alta);

        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent()){
            Autor autor = respuesta.get();
            autor.setNombre(nombre);

            autorRepositorio.save(autor);
        }

    }

    public void delete(String id, Boolean alta) throws ErrorServicio{
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
