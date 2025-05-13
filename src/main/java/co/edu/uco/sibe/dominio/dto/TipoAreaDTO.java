package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class TipoAreaDTO {
    private UUID identificador;
    private String nombre;
    private boolean gestionable;
    private int nivel;

    public TipoAreaDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setGestionable(gestionable);
        setNivel(UtilNumero.getInstance().obtenerValorDefecto());
    }

    private TipoAreaDTO(UUID identificador, String nombre, boolean gestionable, int nivel){
        setIdentificador(identificador);
        setNombre(nombre);
        setGestionable(gestionable);
        setNivel(nivel);
    }

    public static TipoAreaDTO obtenerValorDefecto(){
        return new TipoAreaDTO();
    }

    public static TipoAreaDTO obtenerValorDefecto(final TipoAreaDTO tipoArea){
        return UtilObjeto.getInstance().obtenerValorDefecto(tipoArea, obtenerValorDefecto());
    }

    public static TipoAreaDTO construir(UUID identificador, String nombre, boolean gestionable, int nivel){
        return new TipoAreaDTO(identificador, nombre, gestionable, nivel);
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    private void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }

    private void setGestionable(boolean gestionable) {
        this.gestionable = gestionable;
    }

    private void setNivel(int nivel) {
        this.nivel = UtilNumero.getInstance().obtenerValorDefecto(nivel);
    }
}
