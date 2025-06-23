package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Area {
    private UUID identificador;
    private String nombreArea;
    private TipoArea tipoArea;
    private Area areaPadre;

    private Area(UUID identificador, String nombreArea, TipoArea tipoArea, Area areaPadre){
        setIdentificador(identificador);
        setNombreArea(nombreArea);
        setTipoArea(tipoArea);
        setAreaPadre(areaPadre);
    }

    public static Area construir(UUID identificador, String nombreArea, TipoArea tipoArea, Area areaPadre){
        return new Area(identificador,nombreArea, tipoArea, areaPadre);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombreArea(String nombreArea) {
        UtilTexto.getInstance().validarObligatorio(nombreArea, Mensajes.CAMPO_OBLIGATORIO);
        UtilTexto.getInstance().validarPatronTextoEsValido(nombreArea, Mensajes.PATRON_NOMBRE_AREA_INVALIDO);
        UtilTexto.getInstance().validarLongitud(nombreArea, 1, 50, Mensajes.LONGITUD_NOMBRE_AREA_INVALIDA);
        this.nombreArea = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombreArea);
    }

    public void setTipoArea(TipoArea tipoArea) {
        this.tipoArea = tipoArea;
    }

    public void setAreaPadre(Area areaPadre) {
        this.areaPadre = areaPadre;
    }

}
