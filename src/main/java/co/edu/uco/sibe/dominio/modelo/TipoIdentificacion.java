package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

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

    public static TipoIdentificacion construir(UUID identificador, String sigla, String descripcion){
        return new TipoIdentificacion(identificador, sigla, descripcion);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setSigla(String sigla) {
        this.sigla = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(sigla);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(descripcion);
    }
}
