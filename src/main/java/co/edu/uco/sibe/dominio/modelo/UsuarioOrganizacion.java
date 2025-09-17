package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class UsuarioOrganizacion {
    private UUID identificador;
    private Usuario usuario;
    private Direccion direccion;
    private Area area;
    private Subarea subarea;

    private UsuarioOrganizacion(UUID identificador, Usuario usuario, Direccion direccion, Area area, Subarea subarea) {
        setIdentificador(identificador);
        setUsuario(usuario);
        setDireccion(direccion);
        setArea(area);
        setSubarea(subarea);
    }

    public static UsuarioOrganizacion construir(UUID identificador, Usuario usuario, Direccion direccion, Area area, Subarea subarea) {
        return new UsuarioOrganizacion(identificador, usuario, direccion, area, subarea);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Area getArea() {
        return area;
    }

    public Subarea getSubarea() {
        return subarea;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    private void setArea(Area area) {
        this.area = area;
    }

    private void setSubarea(Subarea subarea) {
        this.subarea = subarea;
    }
}