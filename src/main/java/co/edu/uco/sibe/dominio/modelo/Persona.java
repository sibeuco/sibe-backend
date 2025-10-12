package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Persona {
    private UUID identificador;
    private String nombres;
    private String apellidos;
    private String correo;
    private Identificacion identificacion;

    private Persona(UUID identificador, String nombres, String correo, String apellidos, Identificacion identificacion) {
        this.identificador = identificador;
        this.nombres = nombres;
        this.correo = correo;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }

    public static Persona construir(UUID identificador, String nombres, String apellidos, String correo, Identificacion identificacion) {
        return new Persona(identificador, ValidadorTexto.obtenerValorPorDefecto(nombres), ValidadorTexto.obtenerValorPorDefecto(apellidos), ValidadorTexto.obtenerValorPorDefecto(correo), ValidadorObjeto.obtenerValorPorDefecto(identificacion, Identificacion.construir()));
    }

    public static Persona construir() {
        return new Persona(UtilUUID.obtenerValorDefecto(), TextoConstante.VACIO, TextoConstante.VACIO, TextoConstante.VACIO, Identificacion.construir());
    }
}