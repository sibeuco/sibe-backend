package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.TipoUsuario;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public final class TipoUsuarioRegla implements Regla<TipoUsuario> {
    private static final TipoUsuarioRegla INSTANCIA = new TipoUsuarioRegla();

    private TipoUsuarioRegla() {
        super();
    }

    public static TipoUsuarioRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, "");
    }

    @Override
    public void validarCampos(TipoUsuario modelo) {
        validarNombre(modelo.getNombre());
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, Mensajes.NOMBRE_TIPO_USUARIO_VACIO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 30, Mensajes.LONGITUD_NOMBRE_TIPO_USUARIO);
    }
}