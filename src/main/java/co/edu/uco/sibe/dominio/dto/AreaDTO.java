package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class AreaDTO {
    private UUID identificador;
    private String nombreArea;
    private TipoAreaDTO tipoArea;
    private AreaDTO areaPadre;

    public AreaDTO(){
    }

    public AreaDTO(UUID identificador, String nombreArea, TipoAreaDTO tipoArea, AreaDTO areaPadre){
        setIdentificador(identificador);
        setNombreArea(nombreArea);
        setTipoArea(tipoArea);
        setAreaPadre(areaPadre);
    }

    public static AreaDTO obtenerValorDefecto(){
        return new AreaDTO();
    }

    public static AreaDTO obtenerValorDefecto(final AreaDTO area){
        return UtilObjeto.getInstance().obtenerValorDefecto(area, obtenerValorDefecto());

    }

    public static AreaDTO construir(UUID identificador, String nombreArea, TipoAreaDTO tipoArea, AreaDTO areaPadre){
        return new AreaDTO(identificador, nombreArea, tipoArea, areaPadre);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombreArea);
    }

    public void setTipoArea(TipoAreaDTO tipoArea) {
        this.tipoArea = TipoAreaDTO.obtenerValorDefecto(tipoArea);
    }

    public void setAreaPadre(AreaDTO areaPadre) {
        this.areaPadre = areaPadre;
    }
}
