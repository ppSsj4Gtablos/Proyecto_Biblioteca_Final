public class Usuario {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private String direccion;
    private int edad;
    private int librosPrestados;
    private double deuda;
    private boolean estado;
    private boolean tieneLibro;

    public Usuario(String nombre, String direccion, int edad) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.librosPrestados = 0;
        this.deuda = 0.0;
        this.estado = true;
        this.tieneLibro = false;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isTieneLibro() {
        return tieneLibro;
    }

    public void setTieneLibro(boolean tieneLibro) {
        this.tieneLibro = tieneLibro;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Dirección: " + direccion + ", Edad: " + edad
                + ", Libros Prestados: " + librosPrestados + ", Deuda: $" + deuda + ", Estado: " + estado
                + ", Tiene Libro: " + tieneLibro;
    }
}
