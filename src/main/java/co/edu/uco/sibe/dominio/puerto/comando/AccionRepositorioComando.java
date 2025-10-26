package co.edu.uco.sibe.dominio.puerto.comando;

import co.edu.uco.sibe.dominio.modelo.Accion;

import java.util.UUID;

public interface AccionRepositorioComando {
    UUID guardar(Accion accion);
}
