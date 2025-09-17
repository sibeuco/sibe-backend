package co.edu.uco.sibe.dominio.modelo;

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
        this.codigo = codigo;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}