package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.dominio.modelo.CentroCostos;
import co.edu.uco.sibe.dominio.modelo.CiudadResidencia;

import java.util.UUID;

public class CentroCostosFabrica {
    public CentroCostos construir(String codigo, String descripcion) {
        return CentroCostos.construir(UUID.randomUUID(), codigo, descripcion);
    }
}