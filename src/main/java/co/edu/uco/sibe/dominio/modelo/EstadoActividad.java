package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

@Getter
public class EstadoActividad {
    private UUID identificador;
    private String nombre;

    private EstadoActividad(UUID identificador, String nombre){
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static EstadoActividad construir(UUID identificador, String nombre){
        return new EstadoActividad(identificador, nombre);
    }

    public void setIdentificador(UUID identifiacador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }
}
