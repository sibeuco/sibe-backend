package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class CentroCostos {
    private UUID identificador;
    private String codigo;
    private String descripcion;

    private CentroCostos(UUID identificador, String codigo, String descripcion) {
        setIdentificador(identificador);
        setCodigo(codigo);
        setDescripcion(descripcion);
    }

    public static CentroCostos construir(UUID identificador, String codigo, String descripcion) {
        return new CentroCostos(identificador, codigo, descripcion);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setCodigo(String codigo) {
        ValidadorTexto.validarObligatorio(codigo, Mensajes.CODIGO_CENTRO_COSTOS_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(codigo, Mensajes.CODIGO_CENTRO_COSTOS_INVALIDO);
        ValidadorNumero.validarNumeroEntre(codigo.length(), 4, 6, Mensajes.LONGITUD_CODIGO_CENTRO_COSTOS_INVALIDA);

        this.codigo = codigo;
    }

    private void setDescripcion(String descripcion) {
        ValidadorTexto.validarObligatorio(descripcion, Mensajes.DESCRIPCION_CENTRO_COSTOS_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(descripcion, Mensajes.DESCRIPCION_CENTRO_COSTOS_INVALIDA);
        ValidadorNumero.validarNumeroEntre(descripcion.length(), 10, 100, Mensajes.LONGITUD_DESCRIPCION_CENTRO_COSTOS_INVALIDA);

        this.descripcion = descripcion;
    }
}