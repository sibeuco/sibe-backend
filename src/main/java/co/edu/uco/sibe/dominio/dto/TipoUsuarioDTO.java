package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class TipoUsuarioDTO {
    UUID identificador;
    String nombre;
    boolean crear;
    boolean modificar;
    boolean eliminar;
    boolean consultar;

    public TipoUsuarioDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCrear(crear);
        setModificar(modificar);
        setEliminar(eliminar);
        setConsultar(consultar);
    }

    public TipoUsuarioDTO(UUID identificador, String nombre, boolean crear, boolean modificar, boolean eliminar, boolean consultar){
        setIdentificador(identificador);
        setNombre(nombre);
        setCrear(crear);
        setModificar(modificar);
        setEliminar(eliminar);
        setConsultar(consultar);
    }

    public static TipoUsuarioDTO obtenerValorDefecto(){
        return new TipoUsuarioDTO();
    }

    public static TipoUsuarioDTO obtenerValorDefecto(final TipoUsuarioDTO tipoUsuario){
        return UtilObjeto.getInstance().obtenerValorDefecto(tipoUsuario, obtenerValorDefecto());
    }

    public static TipoUsuarioDTO construir(UUID identificador, String nombre, boolean crear, boolean modificar, boolean eliminar, boolean consultar){
        return new TipoUsuarioDTO(identificador, nombre, crear, modificar, eliminar, consultar);
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    private void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);

    }

    private void setCrear(boolean crear) {
        this.crear = crear;
    }

    private void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    private void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    private void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }
}
