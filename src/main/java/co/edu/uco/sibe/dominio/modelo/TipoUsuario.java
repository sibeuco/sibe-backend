package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

@Getter
public class TipoUsuario {
    UUID identificador;
    String nombre;
    boolean crear;
    boolean modificar;
    boolean eliminar;
    boolean consultar;

    public TipoUsuario(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCrear(crear);
        setModificar(modificar);
        setEliminar(eliminar);
        setConsultar(consultar);
    }

    private TipoUsuario(UUID identificador, String nombre, boolean crear, boolean modificar, boolean eliminar, boolean consultar){
        setIdentificador(identificador);
        setNombre(nombre);
        setCrear(crear);
        setModificar(modificar);
        setEliminar(eliminar);
        setConsultar(consultar);
    }

    public static TipoUsuario obtenerValorDefecto(){
        return new TipoUsuario();
    }

    public static TipoUsuario obtenerValorDefecto(final TipoUsuario tipoUsuario){
        return UtilObjeto.getInstance().obtenerValorDefecto(tipoUsuario, obtenerValorDefecto());
    }

    public static TipoUsuario construir(UUID identificador, String nombre, boolean crear, boolean modificar, boolean eliminar, boolean consultar){
        return new TipoUsuario(identificador, nombre, crear, modificar, eliminar, consultar);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombre(String nombre) {
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
