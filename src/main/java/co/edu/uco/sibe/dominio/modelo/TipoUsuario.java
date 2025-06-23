package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

import java.util.UUID;

@Getter
public class TipoUsuario {
    UUID identificador;
    String nombre;
    boolean crear;
    boolean modificar;
    boolean eliminar;
    boolean consultar;

    private TipoUsuario(UUID identificador, String nombre, boolean crear, boolean modificar, boolean eliminar, boolean consultar){
        setIdentificador(identificador);
        setNombre(nombre);
        setCrear(crear);
        setModificar(modificar);
        setEliminar(eliminar);
        setConsultar(consultar);
    }

    public static TipoUsuario construir(UUID identificador, String nombre, boolean crear, boolean modificar, boolean eliminar, boolean consultar){
        return new TipoUsuario(identificador, nombre, crear, modificar, eliminar, consultar);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombre(String nombre) {
        UtilTexto.getInstance().validarObligatorio(nombre, Mensajes.NOMBRE_TIPO_USUARIO_VACIO);
        UtilTexto.getInstance().validarLongitud(nombre, 1, 30, Mensajes.LONGITUD_NOMBRE_TIPO_USUARIO);
        UtilTexto.getInstance().validarPatronTextoEsValido(nombre, Mensajes.PATRON_NOMBRE_TIPO_USUARIO_INVALIDO);
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);

    }

    public void setCrear(boolean crear) {
        this.crear = crear;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }
}
