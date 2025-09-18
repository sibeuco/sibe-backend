package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class CiudadResidencia {
    private UUID identificador;
    private String descripcion;

    private CiudadResidencia(UUID identificador, String descripcion) {
        setIdentificador(identificador);
        setDescripcion(descripcion);
    }

    public static CiudadResidencia construir(UUID identificador, String descripcion) {
        return new CiudadResidencia(identificador, descripcion);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setDescripcion(String descripcion) {
        ValidadorTexto.validarObligatorio(descripcion, "");
        ValidadorTexto.validarTextoValido(descripcion, "");
        ValidadorNumero.validarNumeroEntre(descripcion.length(), 1, 50, "");

        this.descripcion = descripcion;
    }
}