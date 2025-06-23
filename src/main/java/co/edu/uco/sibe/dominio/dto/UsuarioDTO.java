package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class UsuarioDTO {
    private UUID identificador;
    private String correo;
    private TipoUsuarioDTO tipoUsuario;
    private boolean estaActivo;

    public UsuarioDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoUsuario(TipoUsuarioDTO.obtenerValorDefecto());
        setEstaActivo(false);
    }

    public UsuarioDTO(UUID identificador, String correo, TipoUsuarioDTO tipoUsuario, boolean estaActivo){
        setIdentificador(identificador);
        setCorreo(correo);
        setTipoUsuario(tipoUsuario);
        setEstaActivo(estaActivo);
    }

    public static UsuarioDTO obtenerValorDefecto(){
        return new UsuarioDTO();
    }

    public static UsuarioDTO obtenerValorDefecto(final UsuarioDTO usuario){
        return UtilObjeto.getInstance().obtenerValorDefecto(usuario, obtenerValorDefecto());
    }

    public static UsuarioDTO construir(UUID identificador, String correo, TipoUsuarioDTO tipoUsuario){
        return new UsuarioDTO(identificador, correo, tipoUsuario, false);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setCorreo(String correo) {
        this.correo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(correo);
    }

    public void setTipoUsuario(TipoUsuarioDTO tipoUsuario) {
        this.tipoUsuario = TipoUsuarioDTO.obtenerValorDefecto(tipoUsuario);
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

}
