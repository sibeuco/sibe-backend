package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import lombok.Getter;
import java.util.UUID;

@Getter
public class UsuarioOrganizacion {
    private UUID identificador;
    private Usuario usuario;
    private Direccion direccion;
    private Area area;
    private Subarea subarea;

    private UsuarioOrganizacion(UUID identificador, Usuario usuario, Direccion direccion, Area area, Subarea subarea) {
        this.identificador = identificador;
        this.usuario = usuario;
        this.direccion = direccion;
        this.area = area;
        this.subarea = subarea;
    }

    public static UsuarioOrganizacion construir(UUID identificador, Usuario usuario, Direccion direccion, Area area, Subarea subarea) {
        return new UsuarioOrganizacion(identificador, ValidadorObjeto.obtenerValorPorDefecto(usuario, Usuario.construir()), ValidadorObjeto.obtenerValorPorDefecto(direccion, Direccion.construir()), ValidadorObjeto.obtenerValorPorDefecto(area, Area.construir()), ValidadorObjeto.obtenerValorPorDefecto(subarea, Subarea.construir()));
    }

    public static UsuarioOrganizacion construir() {
        return new UsuarioOrganizacion(UtilUUID.obtenerValorDefecto(), Usuario.construir(), Direccion.construir(), Area.construir(), Subarea.construir());
    }
}