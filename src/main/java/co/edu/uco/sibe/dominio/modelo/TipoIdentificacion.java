package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class TipoIdentificacion {
    private UUID identificador;
    private String sigla;
    private String descripcion;

    private TipoIdentificacion(UUID identificador, String sigla, String descripcion) {
        setIdentificador(identificador);
        setSigla(sigla);
        setDescripcion(descripcion);
    }

    public static TipoIdentificacion construir(UUID identificador, String sigla, String descripcion) {
        return new TipoIdentificacion(identificador, sigla, descripcion);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setSigla(String sigla) {
        ValidadorTexto.validarObligatorio(sigla, Mensajes.CAMPO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(sigla, Mensajes.PATRON_SIGLA_TIPO_IDENTIFICACION_INVALIDO);
        ValidadorNumero.validarNumeroEntre(sigla.length(), 1, 5, Mensajes.LONGITUD_SIGLA_TIPO_IDENTIFICACION_INVALIDA);

        this.sigla = sigla;
    }

    private void setDescripcion(String descripcion) {
        ValidadorTexto.validarObligatorio(descripcion, Mensajes.CAMPO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(descripcion, Mensajes.PATRON_DESCIPCION_TIPO_IDENTIFICACION_INVALIDO);
        ValidadorNumero.validarNumeroEntre(descripcion.length(), 1, 40, Mensajes.LONGITUD_DESCRIPCION_TIPO_IDENTIFICACION_INVALIDA);

        this.descripcion = descripcion;
    }
}