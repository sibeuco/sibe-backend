package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

import java.util.UUID;

@Getter
public class TipoIdentificacion {
    private UUID identificador;
    private String sigla;
    private String descripcion;

    private TipoIdentificacion(UUID identificador, String sigla, String descripcion){
        setIdentificador(identificador);
        setSigla(sigla);
        setDescripcion(descripcion);
    }

    public static TipoIdentificacion construir(UUID identificador,String sigla, String descripcion){
        return new TipoIdentificacion(identificador, sigla, descripcion);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setSigla(String sigla) {
        UtilTexto.getInstance().validarObligatorio(sigla, Mensajes.CAMPO_OBLIGATORIO);
        UtilTexto.getInstance().validarPatronTextoEsValido(sigla, Mensajes.PATRON_SIGLA_TIPO_IDENTIFICACION_INVALIDO);
        UtilTexto.getInstance().validarLongitud(sigla, 1, 5, Mensajes.LONGITUD_SIGLA_TIPO_IDENTIFICACION_INVALIDA);
        this.sigla = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(sigla);
    }

    public void setDescripcion(String descripcion) {
        UtilTexto.getInstance().validarObligatorio(descripcion, Mensajes.CAMPO_OBLIGATORIO);
        UtilTexto.getInstance().validarPatronTextoEsValido(descripcion, Mensajes.PATRON_DESCIPCION_TIPO_IDENTIFICACION_INVALIDO);
        UtilTexto.getInstance().validarLongitud(descripcion, 1, 40, Mensajes.LONGITUD_DESCRIPCION_TIPO_IDENTIFICACION_INVALIDA);
        this.descripcion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(descripcion);
    }
}
