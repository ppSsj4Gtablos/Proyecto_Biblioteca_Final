import java.util.ArrayList;

public class BDUsuarios {
    private ArrayList<Usuario> baseDatos;

    public BDUsuarios() {
        this.baseDatos = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        baseDatos.add(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        baseDatos.remove(usuario);
    }

    public void mostrarUsuarios() {
        for (Usuario usuario : baseDatos) {
            System.out.println(usuario);
        }
    }

    public Usuario encontrarUsuarioPorId(int id) {
        for (Usuario usuario : baseDatos) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public ArrayList<Usuario> encontrarUsuariosPorNombre(String nombre) {
        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();
        for (Usuario usuario : baseDatos) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                usuariosEncontrados.add(usuario);
            }
        }
        return usuariosEncontrados;
    }

    public ArrayList<Usuario> encontrarUsuariosConDeuda() {
        ArrayList<Usuario> usuariosConDeuda = new ArrayList<>();
        for (Usuario usuario : baseDatos) {
            if (usuario.getDeuda() > 0) {
                usuariosConDeuda.add(usuario);
            }
        }
        return usuariosConDeuda;
    }

    @Override
    public String toString() {
        StringBuilder contenido = new StringBuilder();
        for (Usuario usuario : baseDatos) {
            contenido.append(usuario).append("\n");
        }
        return contenido.toString().trim();
    }
}
