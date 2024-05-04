import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> listaLibros;

    public Biblioteca() {
        this.listaLibros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public void quitarLibro(int id) {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == id) {
                listaLibros.remove(i);
                return;
            }
        }
        System.out.println("El libro con ID " + id + " no existe en la biblioteca.");
    }

    public void mostrarLibros() {
        for (Libro libro : listaLibros) {
            System.out.println(libro);
        }
    }

    public void mostrarLibrosPorGenero(String genero) {
        for (Libro libro : listaLibros) {
            if (libro.getGenero().equalsIgnoreCase(genero)) {
                System.out.println(libro);
            }
        }
    }

    public Libro encontrarLibroId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public Libro encontrarLibroNombre(String nombre) {
        for (Libro libro : listaLibros) {
            if (libro.getNombre().equalsIgnoreCase(nombre)) {
                return libro;
            }
        }
        return null;
    }

    public void prestarLibro(int id) {
        Libro libro = encontrarLibroId(id);
        if (libro != null) {
            if (libro.getNumEjemplares() > 0) {
                libro.setNumEjemplares(libro.getNumEjemplares() - 1);
                System.out.println("Libro prestado: " + libro.getNombre());
            } else {
                System.out.println("El libro " + libro.getNombre() + " está agotado.");
            }
        } else {
            System.out.println("No se encontró ningún libro con el ID " + id);
        }
    }

    @Override
    public String toString() {
        StringBuilder contenido = new StringBuilder();
        for (Libro libro : listaLibros) {
            contenido.append(libro).append("\n");
        }
        return contenido.toString();
    }
}
