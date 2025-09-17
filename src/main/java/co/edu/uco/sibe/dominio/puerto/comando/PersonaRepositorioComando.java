package co.edu.uco.sibe.dominio.puerto.comando;

import java.util.UUID;

public interface PersonaRepositorioComando {

    UUID agregarNuevoUsuario(Usuario usuario, Persona persona, String contrasenaEncriptada);

    UUID modificarPersona(Persona persona, UUID identificador);

    UUID modificarUsuario(Usuario usuario, UUID identificador);

    UUID modificarContrasena(String nuevaContrasena, UUID identificador);

    void eliminarUsuario(UUID identificador);

}
