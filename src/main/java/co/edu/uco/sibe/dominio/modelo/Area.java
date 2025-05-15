package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class Area {
    private UUID identificador;
    private String nombreArea;
    private TipoArea tipoArea;
    private Area areaPadre;

    public Area(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombreArea(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoArea(TipoArea.obtenerValorDefecto());
        setAreaPadre(Area.obtenerValorDefecto());
    }

    private Area(UUID identificador, String nombreArea, TipoArea tipoArea, Area areaPadre){
        setIdentificador(identificador);
        setNombreArea(nombreArea);
        setTipoArea(tipoArea);
        setAreaPadre(areaPadre);
    }

    public static Area obtenerValorDefecto(){
        return new Area();
    }

    public static Area obtenerValorDefecto(final Area area){
        return UtilObjeto.getInstance().obtenerValorDefecto(area, obtenerValorDefecto());

    }

    public static Area construir(UUID identificador, String nombreArea, TipoArea tipoArea, Area areaPadre){
        return new Area(identificador, nombreArea, tipoArea, areaPadre);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombreArea);
    }

    public void setTipoArea(TipoArea tipoArea) {
        this.tipoArea = TipoArea.obtenerValorDefecto(tipoArea);
    }

    public void setAreaPadre(Area areaPadre) {
        this.areaPadre = (areaPadre == this) ? Area.obtenerValorDefecto() : Area.obtenerValorDefecto(areaPadre);
    }

}
