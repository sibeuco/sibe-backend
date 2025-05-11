package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

@Getter
public class TipoArea {
    private UUID identificador;
    private String nombre;
    private boolean gestionable;
    private int nivel;

    public TipoArea(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setGestionable(gestionable);
        setNivel(UtilNumero.getInstance().obtenerValorDefecto());
    }

    private TipoArea(UUID identificador, String nombre, boolean gestionable, int nivel){
        setIdentificador(identificador);
        setNombre(nombre);
        setGestionable(gestionable);
        setNivel(nivel);
    }

    public static TipoArea obtenerValorDefecto(){
        return new TipoArea();
    }

    public static TipoArea obtenerValorDefecto(final TipoArea tipoArea){
        return UtilObjeto.getInstance().obtenerValorDefecto(tipoArea, obtenerValorDefecto());
    }

    public static TipoArea construir(UUID identificador, String nombre, boolean gestionable, int nivel){
        return new TipoArea(identificador, nombre, gestionable, nivel);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }

    public void setGestionable(boolean gestionable) {
        this.gestionable = gestionable;
    }

    public void setNivel(int nivel) {
        this.nivel = UtilNumero.getInstance().obtenerValorDefecto(nivel);
    }
}
