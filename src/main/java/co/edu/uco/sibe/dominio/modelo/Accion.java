package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Accion {
    private UUID identificador;
    private String detalle;
    private String objetivo;

    private Accion(UUID identificador, String detalle, String objetivo) {
        this.identificador = identificador;
        this.detalle = detalle;
        this.objetivo = objetivo;
    }

    public static Accion construir(UUID identificador, String detalle, String objetivo) {
        return new Accion(identificador, ValidadorTexto.obtenerValorPorDefecto(detalle), objetivo);
    }
}