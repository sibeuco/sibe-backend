package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;
import java.util.UUID;

@Getter
public final class PersonaRegla implements Regla<Persona> {
    private static final PersonaRegla INSTANCIA = new PersonaRegla();

    private PersonaRegla() {
        super();
    }

    public static PersonaRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, "");
    }

    @Override
    public void validarCampos(Persona modelo) {
        validarNombres(modelo.getNombres());
        validarApellidos(modelo.getApellidos());
        validarCorreo(modelo.getCorreo());
    }

    private void validarNombres(String nombres) {
        ValidadorTexto.validarObligatorio(nombres, Mensajes.PRIMER_NOMBRE_PERSONA_VACIO);
        ValidadorTexto.validarTextoValido(nombres, Mensajes.PATRON_NOMBRE_PERSONA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombres.length(), 1, 50, Mensajes.LONGITUD_NOMBRE_PERSONA_INVALIDA);
    }

    private void validarApellidos(String apellidos) {
        ValidadorTexto.validarObligatorio(apellidos, Mensajes.PRIMER_APELLIDO_PERSONA_VACIO);
        ValidadorTexto.validarTextoValido(apellidos, Mensajes.PATRON_APELLIDO_PERSONA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(apellidos.length(), 1, 50, Mensajes.LONGITUD_APELLIDO_PERSONA_INVALIDA);
    }

    private void validarCorreo(String correo) {
        ValidadorTexto.validarObligatorio(correo, Mensajes.CORREO_USUARIO_VACIO);
        ValidadorTexto.validarCorreoValido(correo, Mensajes.PATRON_CORREO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(correo.length(), 10, 100, Mensajes.LONGITUD_CORREO_PERSONA_INVALIDA);
    }
}