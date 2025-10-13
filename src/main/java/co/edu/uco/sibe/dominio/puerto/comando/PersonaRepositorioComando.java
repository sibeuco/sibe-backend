package co.edu.uco.sibe.dominio.puerto.comando;

import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.Usuario;

import java.util.UUID;

public interface PersonaRepositorioComando {

    UUID agregarNuevoUsuario(Usuario usuario, Persona persona, String contrasenaEncriptada);

    UUID modificarUsuario(Usuario usuario, Persona persona, UUID identificador);

    UUID modificarContrasena(String nuevaContrasena, UUID identificador);

    void eliminarUsuario(UUID identificador);

}
