package co.edu.uco.sibe.dominio.puerto.comando;

import co.edu.uco.sibe.dominio.modelo.TipoArea;

import java.util.UUID;

public interface TipoAreaRepositorioComando {

    UUID agregarNuevoTipoArea(TipoArea tipoArea);

}
