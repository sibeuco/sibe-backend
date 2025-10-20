package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public final class UsuarioRegla implements Regla<Usuario> {
    private static final UsuarioRegla INSTANCIA = new UsuarioRegla();

    private UsuarioRegla() {
        super();
    }

    public static UsuarioRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, UtilMensaje.IDENTIFICADOR_USUARIO_NULO);
    }

    @Override
    public void validarCampos(Usuario modelo) {
        validarCorreo(modelo.getCorreo());
    }

    private void validarCorreo(String correo) {
        ValidadorTexto.validarObligatorio(correo, UtilMensaje.CORREO_USUARIO_VACIO);
        ValidadorTexto.validarCorreoValido(correo, UtilMensaje.PATRON_CORREO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(correo.length(), 10, 100, UtilMensaje.LONGITUD_CORREO_USUARIO_INVALIDA);
    }

    public void validarClave(String clave) {
        ValidadorTexto.validarObligatorio(clave, UtilMensaje.CONTRASENA_VACIA);
        ValidadorTexto.validarClaveValida(clave, UtilMensaje.PATRON_CONTRASENA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(clave.length(), 8, 20, UtilMensaje.LONGITUD_CLAVE_USUARIO_INVALIDA);
    }
}