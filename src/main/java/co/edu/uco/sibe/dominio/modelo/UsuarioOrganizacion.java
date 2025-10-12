package co.edu.uco.sibe.dominio.modelo;

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
        return new UsuarioOrganizacion(identificador, usuario, direccion, area, subarea);
    }
}