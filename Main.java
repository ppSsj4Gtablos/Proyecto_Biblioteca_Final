import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Inicio de la aplicación
        Biblioteca biblioteca = new Biblioteca();
        BDUsuarios baseDatos = new BDUsuarios();

        // Cargar datos desde los archivos de texto
        cargarDatosDesdeArchivo("biblioteca3.txt", biblioteca);
        cargarDatosDesdeArchivo("BD_POO.txt", baseDatos);

        // Mostrar la ventana de inicio de sesión del administrador
        mostrarVentanaInicioSesion(biblioteca, baseDatos);
    }

    // Método para cargar datos desde un archivo de texto
    public static void cargarDatosDesdeArchivo(String filename, Object obj) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.nextLine(); // Saltar la primera línea (encabezados)
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                // Procesar la línea según el tipo de objeto (Biblioteca o BDUsuarios)
                if (obj instanceof Biblioteca) {
                    procesarLineaParaBiblioteca(data, (Biblioteca) obj);
                } else if (obj instanceof BDUsuarios) {
                    procesarLineaParaBDUsuarios(data, (BDUsuarios) obj);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado - " + filename);
        }
    }

    // Método para procesar una línea de datos y agregar un libro a la biblioteca
    private static void procesarLineaParaBiblioteca(String[] data, Biblioteca biblioteca) {
        if (data.length == 7) {
            String titulo = data[0];
            String autor = data[1];
            String genero = data[2];
            int numPaginas = Integer.parseInt(data[3]);
            int anoPublicacion = Integer.parseInt(data[4]);
            double precio = Double.parseDouble(data[5]);
            int ejemplares = Integer.parseInt(data[6]);
            Libro libro = new Libro(ejemplares, anoPublicacion, numPaginas, ejemplares, titulo, autor, genero, precio);
            biblioteca.agregarLibro(libro);
        } else {
            System.err.println("Error: Longitud incorrecta en la línea");
        }
    }

    // Método para procesar una línea de datos y agregar un usuario a la base de
    // datos de usuarios
    private static void procesarLineaParaBDUsuarios(String[] data, BDUsuarios baseDatos) {
        if (data.length == 3) {
            String nombre = data[0];
            String direccion = data[1];
            int edad = Integer.parseInt(data[2]);
            Usuario usuario = new Usuario(nombre, direccion, edad);
            baseDatos.agregarUsuario(usuario);
        } else {
            System.err.println("Error: Longitud incorrecta en la línea");
        }
    }

    // Método para mostrar la ventana de inicio de sesión del administrador
    private static void mostrarVentanaInicioSesion(Biblioteca biblioteca, BDUsuarios baseDatos) {
        JFrame ventanaInicioSesion = new JFrame("Inicio de Sesión");
        ventanaInicioSesion.setSize(300, 200);
        ventanaInicioSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        ventanaInicioSesion.add(panel);

        JLabel usernameLabel = new JLabel("Nombre de Usuario:");
        usernameLabel.setBounds(50, 30, 150, 30);
        panel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(170, 30, 100, 30);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(50, 80, 150, 30);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(170, 80, 100, 30);
        panel.add(passwordField);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(100, 130, 120, 30);
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Verificar las credenciales del administrador
            if (username.equals("admin") && password.equals("contraseñaSegura123")) {
                // Si las credenciales son correctas, mostrar la interfaz de biblioteca
                InterfazBiblioteca interfazBiblioteca = new InterfazBiblioteca(biblioteca);
                ventanaInicioSesion.dispose(); // Cerrar la ventana de inicio de sesión
            } else {
                // Si las credenciales son incorrectas, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Inténtelo de nuevo.",
                        "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        });

        ventanaInicioSesion.setVisible(true);
    }
}
