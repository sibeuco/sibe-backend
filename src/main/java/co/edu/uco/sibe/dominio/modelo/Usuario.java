package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class Usuario {
    private UUID identificador;
    private String correo;
    private String contrasena;
    private TipoUsuario tipoUsuario;
    private boolean estaActivo;
    private Area area;
    private Persona persona;

    public Usuario(){
        this.identificador = UtilUUID.obtenerValorDefecto();
        setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
        setContrasena(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoUsuario(TipoUsuario.obtenerValorDefecto());
        setEstaActivo(false);
        setArea(Area.obtenerValorDefecto());
        setPersona(Persona.obtenerValorDefecto());
    }

    private Usuario(String correo, String contrasena, TipoUsuario tipoUsuario, boolean estaActivo, Area area, Persona persona){
        setIdentificador();
        setCorreo(correo);
        setContrasena(contrasena);
        setTipoUsuario(tipoUsuario);
        setEstaActivo(estaActivo);
        setArea(area);
        setPersona(persona);
    }

    public static Usuario obtenerValorDefecto(){
        return new Usuario();
    }

    public static Usuario obtenerValorDefecto(final Usuario usuario){
        return UtilObjeto.getInstance().obtenerValorDefecto(usuario, obtenerValorDefecto());
    }

    public static Usuario construir(String correo, String contrasena, TipoUsuario tipoUsuario, Area area, Persona persona){
        return new Usuario(correo, contrasena, tipoUsuario, false, area, persona);
    }

    public void setIdentificador() {
        this.identificador = UtilUUID.generarNuevoUUID();
    }

    public void setCorreo(String correo) {
        this.correo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(correo);
    }

    public void setContrasena(String contrasena) {
        this.contrasena = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(contrasena);
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = TipoUsuario.obtenerValorDefecto(tipoUsuario);
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public void setArea(Area area) {
        this.area = Area.obtenerValorDefecto(area);
    }

    public void setPersona(Persona persona) {
        this.persona = Persona.obtenerValorDefecto(persona);
    }
}
