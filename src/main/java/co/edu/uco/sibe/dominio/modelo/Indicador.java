package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class Indicador {
    private UUID identificador;
    private String nombre;
    private TipoIndicador tipoIndicador;
    private Temporalidad temporalidad;
    private Proyecto proyecto;
    private PublicoInteres publicoInteres;

    private Indicador(UUID identificador, String nombre, TipoIndicador tipoIndicador, Temporalidad temporalidad, Proyecto proyecto, PublicoInteres publicoInteres) {
        setIdentificador(identificador);
        setNombre(nombre);
        setTipoIndicador(tipoIndicador);
        setTemporalidad(temporalidad);
        setProyecto(proyecto);
        setPublicoInteres(publicoInteres);
    }

    public static Indicador construir(UUID identificador, String nombre, TipoIndicador tipoIndicador, Temporalidad temporalidad, Proyecto proyecto, PublicoInteres publicoInteres) {
        return new Indicador(identificador, nombre, tipoIndicador, temporalidad, proyecto, publicoInteres);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoIndicador getTipoIndicador() {
        return tipoIndicador;
    }

    public Temporalidad getTemporalidad() {
        return temporalidad;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public PublicoInteres getPublicoInteres() {
        return publicoInteres;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, "");
        ValidadorTexto.validarTextoAlfanumericoValido(nombre, "");
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 100, "");

        this.nombre = nombre;
    }

    private void setTipoIndicador(TipoIndicador tipoIndicador) {
        this.tipoIndicador = tipoIndicador;
    }

    private void setTemporalidad(Temporalidad temporalidad) {
        this.temporalidad = temporalidad;
    }

    private void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    private void setPublicoInteres(PublicoInteres publicoInteres) {
        this.publicoInteres = publicoInteres;
    }
}