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
    private String contrasena;
    private TipoUsuarioDTO tipoUsuario;
    private boolean estaActivo;
    private AreaDTO area;
    private PersonaDTO persona;

    public UsuarioDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
        setContrasena(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoUsuario(TipoUsuarioDTO.obtenerValorDefecto());
        setEstaActivo(false);
        setArea(AreaDTO.obtenerValorDefecto());
        setPersona(PersonaDTO.obtenerValorDefecto());
    }

    private UsuarioDTO(UUID identificador, String correo, String contrasena, TipoUsuarioDTO tipoUsuario, boolean estaActivo, AreaDTO area, PersonaDTO persona){
        setIdentificador(identificador);
        setCorreo(correo);
        setContrasena(contrasena);
        setTipoUsuario(tipoUsuario);
        setEstaActivo(estaActivo);
        setArea(area);
        setPersona(persona);
    }

    public static UsuarioDTO obtenerValorDefecto(){
        return new UsuarioDTO();
    }

    public static UsuarioDTO obtenerValorDefecto(final UsuarioDTO usuario){
        return UtilObjeto.getInstance().obtenerValorDefecto(usuario, obtenerValorDefecto());
    }

    public static UsuarioDTO construir(UUID identificador, String correo, String contrasena, TipoUsuarioDTO tipoUsuario, AreaDTO area, PersonaDTO persona){
        return new UsuarioDTO(identificador, correo, contrasena, tipoUsuario, false, area, persona);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setCorreo(String correo) {
        this.correo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(correo);
    }

    public void setContrasena(String contrasena) {
        this.contrasena = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(contrasena);
    }

    public void setTipoUsuario(TipoUsuarioDTO tipoUsuario) {
        this.tipoUsuario = TipoUsuarioDTO.obtenerValorDefecto(tipoUsuario);
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public void setArea(AreaDTO area) {
        this.area = AreaDTO.obtenerValorDefecto(area);
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = PersonaDTO.obtenerValorDefecto(persona);
    }
}
