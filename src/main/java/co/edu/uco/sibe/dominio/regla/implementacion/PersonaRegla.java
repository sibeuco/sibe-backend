package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

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
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_PERSONA_NULO);
    }

    @Override
    public void validarCampos(Persona modelo) {
        validarNombres(modelo.getNombres());
        validarApellidos(modelo.getApellidos());
        validarCorreo(modelo.getCorreo());
    }

    private void validarNombres(String nombres) {
        ValidadorTexto.validarObligatorio(nombres, PRIMER_NOMBRE_PERSONA_VACIO);
        ValidadorTexto.validarTextoValido(nombres, PATRON_NOMBRE_PERSONA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombres.length(), 1, 50, LONGITUD_NOMBRE_PERSONA_INVALIDA);
    }

    private void validarApellidos(String apellidos) {
        ValidadorTexto.validarObligatorio(apellidos, PRIMER_APELLIDO_PERSONA_VACIO);
        ValidadorTexto.validarTextoValido(apellidos, PATRON_APELLIDO_PERSONA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(apellidos.length(), 1, 50, LONGITUD_APELLIDO_PERSONA_INVALIDA);
    }

    private void validarCorreo(String correo) {
        ValidadorTexto.validarObligatorio(correo, CORREO_USUARIO_VACIO);
        ValidadorTexto.validarCorreoValido(correo, PATRON_CORREO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(correo.length(), 10, 100, LONGITUD_CORREO_PERSONA_INVALIDA);
    }
}