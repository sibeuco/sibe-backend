package co.edu.uco.sibe.dominio.puerto.comando;

import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.Usuario;

import java.util.UUID;

public interface PersonaRepositorioComando {

    UUID agregarNuevoUsuario(Usuario usuario, UUID identificador);

    UUID modificarPersona(Persona persona, UUID identificador);

    UUID modificarUsuario(Usuario usuario);

    UUID modificarContrasena(String nuevaContrasena, UUID identificador);

    void eliminarUsuario(UUID identificador);

}
