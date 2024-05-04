import java.util.Date;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean devuelto;

    public Prestamo(Usuario usuario, Libro libro, Date fechaPrestamo) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null;
        this.devuelto = false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public boolean realizarPrestamo() {
        if (libro.getNumEjemplares() > 0) {
            // Realizar el préstamo
            Date fechaActual = new Date(); // Fecha actual
            fechaPrestamo = fechaActual;
            fechaDevolucion = null;
            devuelto = false;
            libro.decrementarEjemplaresDisponibles();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Préstamo{" +
                "usuario=" + usuario.getNombre() +
                ", libro=" + libro.getNombre() +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                ", devuelto=" + devuelto +
                '}';
    }
}
