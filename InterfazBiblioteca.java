import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InterfazBiblioteca extends JFrame {

    private Biblioteca biblioteca;

    public InterfazBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Biblioteca");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("Biblioteca Virtual");
        titleLabel.setBounds(180, 20, 150, 30);
        panel.add(titleLabel);

        JButton agregarLibroButton = new JButton("Agregar Libro");
        agregarLibroButton.setBounds(50, 80, 150, 30);
        panel.add(agregarLibroButton);

        JButton mostrarLibrosButton = new JButton("Mostrar Libros");
        mostrarLibrosButton.setBounds(50, 130, 150, 30);
        panel.add(mostrarLibrosButton);

        JButton buscarLibroButton = new JButton("Buscar Libro");
        buscarLibroButton.setBounds(50, 180, 150, 30);
        panel.add(buscarLibroButton);

        JButton prestamoLibroButton = new JButton("Préstamo Libro");
        prestamoLibroButton.setBounds(50, 230, 150, 30);
        panel.add(prestamoLibroButton);

        JButton devolucionLibroButton = new JButton("Devolución Libro");
        devolucionLibroButton.setBounds(50, 280, 150, 30);
        panel.add(devolucionLibroButton);

        agregarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la lógica para agregar un libro
                // Se podría abrir una nueva ventana para ingresar los detalles del libro a
                // agregar
            }
        });

        mostrarLibrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la lógica para mostrar todos los libros
                JOptionPane.showMessageDialog(null, biblioteca.toString(), "Libros en la Biblioteca",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la lógica para buscar un libro
                String nombreLibro = JOptionPane.showInputDialog(null, "Ingrese el nombre del libro a buscar:",
                        "Buscar Libro", JOptionPane.QUESTION_MESSAGE);
                Libro libro = biblioteca.buscarLibroPorNombre(nombreLibro);
                if (libro != null) {
                    JOptionPane.showMessageDialog(null, "Libro encontrado:\n" + libro.toString(),
                            "Resultado de la Búsqueda", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Libro no encontrado", "Resultado de la Búsqueda",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        prestamoLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la lógica para préstamo de libros
                // Se podría abrir una nueva ventana para realizar el préstamo
                String nombreUsuario = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario:",
                        "Préstamo de Libro", JOptionPane.QUESTION_MESSAGE);
                Usuario usuario = biblioteca.buscarUsuarioPorNombre(nombreUsuario);
                if (usuario != null) {
                    String nombreLibro = JOptionPane.showInputDialog(null, "Ingrese el nombre del libro a prestar:",
                            "Préstamo de Libro", JOptionPane.QUESTION_MESSAGE);
                    Libro libro = biblioteca.buscarLibroPorNombre(nombreLibro);
                    if (libro != null) {
                        if (libro.getNumEjemplares() > 0) {
                            // Realizar el préstamo
                            Date fechaPrestamo = new Date(); // Fecha actual
                            Prestamo prestamo = new Prestamo(usuario, libro, fechaPrestamo);
                            biblioteca.agregarPrestamo(prestamo);
                            JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito:\n" + prestamo.toString(),
                                    "Préstamo de Libro", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "El libro no está disponible para préstamo",
                                    "Préstamo de Libro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Libro no encontrado", "Préstamo de Libro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Préstamo de Libro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        devolucionLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la lógica para devolución de libros
                String nombreUsuario = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario:",
                        "Devolución de Libro", JOptionPane.QUESTION_MESSAGE);
                Usuario usuario = biblioteca.buscarUsuarioPorNombre(nombreUsuario);
                if (usuario != null) {
                    Prestamo prestamo = biblioteca.buscarPrestamoPorUsuario(usuario);
                    if (prestamo != null) {
                        // Realizar la devolución
                        prestamo.setFechaDevolucion(new Date()); // Fecha actual
                        prestamo.setDevuelto(true);
                        JOptionPane.showMessageDialog(null, "Devolución realizada con éxito:\n" + prestamo.toString(),
                                "Devolución de Libro", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario no tiene libros prestados",
                                "Devolución de Libro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Devolución de Libro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    // Método para mostrar la ventana de inicio de sesión del administrador
    private void mostrarVentanaInicioSesion() {
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

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });

        ventanaInicioSesion.setVisible(true);
    }

    public static void main(String[] args) {
        // Crear una instancia de la biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Mostrar la ventana de inicio de sesión del administrador
        InterfazBiblioteca interfazBiblioteca = new InterfazBiblioteca(biblioteca);
        interfazBiblioteca.mostrarVentanaInicioSesion();
    }
}
