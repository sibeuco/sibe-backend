package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;

@Getter
public class EstadoActividad {
    private UUID identificador;
    private String nombre;

    private EstadoActividad(UUID identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public static EstadoActividad construir(UUID identificador, String nombre) {
        return new EstadoActividad(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(nombre)
        );
    }

    public static EstadoActividad construir() {
        return new EstadoActividad(
                UtilUUID.obtenerValorDefecto(),
                VACIO
        );
    }
}