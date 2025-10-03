package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class RelacionLaboral {
    private UUID identificador;
    private String codigo;
    private String descripcion;

    private RelacionLaboral(UUID identificador, String codigo, String descripcion) {
        setIdentificador(identificador);
        setCodigo(codigo);
        setDescripcion(descripcion);
    }

    public static RelacionLaboral construir(UUID identificador, String codigo, String descripcion) {
        return new RelacionLaboral(identificador, codigo, descripcion);
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
        ValidadorTexto.validarObligatorio(codigo, Mensajes.CODIGO_RELACION_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(codigo, Mensajes.CODIGO_RELACION_INVALIDO);
        ValidadorNumero.validarNumeroEntre(codigo.length(), 2, 4, Mensajes.LONGITUD_CODIGO_RELACION_INVALIDA);

        this.codigo = codigo;
    }

    private void setDescripcion(String descripcion) {
        ValidadorTexto.validarObligatorio(descripcion, Mensajes.DESCRIPCION_RELACION_LABORAL_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(descripcion, Mensajes.DESCRIPCION_RELACION_LABORAL_INVALIDA);
        ValidadorNumero.validarNumeroEntre(descripcion.length(), 5, 20, Mensajes.LONGITUD_DESCRIPCION_RELACION_LABORAL_INVALIDA);

        this.descripcion = descripcion;
    }
}