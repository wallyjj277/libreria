package pagina.demo.libreria.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class Prestamo {

    private String id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDevolucion;
    private Boolean alta;
    @OneToOne
    private Libro libro;
    @OneToOne
    private Cliente cliente;

}
