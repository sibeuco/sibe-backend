package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;

@Getter
public class Indicador {
    private UUID identificador;
    private String nombre;
    private TipoIndicador tipoIndicador;
    private Temporalidad temporalidad;
    private Proyecto proyecto;
    private PublicoInteres publicoInteres;

    private Indicador(UUID identificador, String nombre, TipoIndicador tipoIndicador, Temporalidad temporalidad, Proyecto proyecto, PublicoInteres publicoInteres) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.tipoIndicador = tipoIndicador;
        this.temporalidad = temporalidad;
        this.proyecto = proyecto;
        this.publicoInteres = publicoInteres;
    }

    public static Indicador construir(UUID identificador, String nombre, TipoIndicador tipoIndicador, Temporalidad temporalidad, Proyecto proyecto, PublicoInteres publicoInteres) {
        return new Indicador(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(nombre),
                ValidadorObjeto.obtenerValorPorDefecto(tipoIndicador, TipoIndicador.construir()),
                ValidadorObjeto.obtenerValorPorDefecto(temporalidad, Temporalidad.construir()),
                ValidadorObjeto.obtenerValorPorDefecto(proyecto, Proyecto.construir()),
                ValidadorObjeto.obtenerValorPorDefecto(publicoInteres, PublicoInteres.construir())
        );
    }

    public static Indicador construir() {
        return new Indicador(
                UtilUUID.obtenerValorDefecto(),
                VACIO,
                TipoIndicador.construir(),
                Temporalidad.construir(),
                Proyecto.construir(),
                PublicoInteres.construir()
        );
    }
}