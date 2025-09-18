package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class TipoUsuario {
    private UUID identificador;
    private String nombre;
    private boolean crear;
    private boolean modificar;
    private boolean eliminar;
    private boolean consultar;

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
        ValidadorTexto.validarObligatorio(nombre, Mensajes.NOMBRE_TIPO_USUARIO_VACIO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 1, 30, Mensajes.LONGITUD_NOMBRE_TIPO_USUARIO);

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