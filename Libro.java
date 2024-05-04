public class Libro {
    private static int contadorId = 1;
    private int id;
    private int isbn;
    private int anioPublicacion;
    private int numPaginas;
    private int numEjemplares;
    private String nombre;
    private String autor;
    private String genero;
    private double precioRenta;

    public Libro() {
        this.id = contadorId++;
    }

    public Libro(int isbn, int anioPublicacion, int numPaginas, int numEjemplares, String nombre, String autor,
            String genero, double precioRenta) {
        this.id = contadorId++;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.numPaginas = numPaginas;
        this.numEjemplares = numEjemplares;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.precioRenta = precioRenta;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecioRenta() {
        return precioRenta;
    }

    public void setPrecioRenta(double precioRenta) {
        this.precioRenta = precioRenta;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", ISBN: " + isbn + ", Nombre: " + nombre + ", Autor: " + autor + ", Género: " + genero
                + ", Precio Renta: $" + precioRenta;
    }
}
