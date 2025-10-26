package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.dominio.modelo.CiudadResidencia;

import java.util.UUID;

public class CiudadResidenciaFabrica {
    public CiudadResidencia construir(String municipioResidencia) {
        return CiudadResidencia.construir(UUID.randomUUID(), municipioResidencia);
    }
}
