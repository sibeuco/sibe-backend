package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class TipoUsuario {
    UUID identificador;
    String nombre;
    boolean crear;
    boolean modificar;
    boolean eliminar;
    boolean consultar;

    private TipoUsuario(UUID identificador, String nombre, boolean crear, boolean modificar, boolean eliminar, boolean consultar) {
        setIdentificador(identificador);
        setNombre(nombre);
        setCrear(crear);
        setModificar(modificar);
        setEliminar(eliminar);
        setConsultar(consultar);
    }

    public static TipoUsuario construir(UUID identificador, String nombre, boolean crear, boolean modificar, boolean eliminar, boolean consultar) {
        return new TipoUsuario(identificador, nombre, crear, modificar, eliminar, consultar);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isCrear() {
        return crear;
    }

    private void setCrear(boolean crear) {
        this.crear = crear;
    }

    public boolean isModificar() {
        return modificar;
    }

    private void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public boolean isEliminar() {
        return eliminar;
    }

    private void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public boolean isConsultar() {
        return consultar;
    }

    private void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }
}