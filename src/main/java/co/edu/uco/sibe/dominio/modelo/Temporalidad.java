package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Temporalidad {
    private UUID identificador;
    private String nombre;

    private Temporalidad(String nombre){
        setIdentificador();
        setNombre(nombre);
    }

    public static Temporalidad construir(String nombre){
        return new Temporalidad(nombre);
    }

    public void setIdentificador() {
        this.identificador = UtilUUID.generarNuevoUUID();
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }
}
