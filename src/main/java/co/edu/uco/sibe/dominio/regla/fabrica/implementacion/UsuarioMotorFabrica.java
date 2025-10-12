package co.edu.uco.sibe.dominio.regla.fabrica.implementacion;

import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotorFabrica;
import co.edu.uco.sibe.dominio.regla.implementacion.UsuarioRegla;
import co.edu.uco.sibe.dominio.regla.motor.MotorRegla;

public final class UsuarioMotorFabrica implements MotorFabrica<Usuario> {
    private static final UsuarioMotorFabrica INSTANCIA = new UsuarioMotorFabrica();

    private UsuarioMotorFabrica() {
        super();
    }

    public static UsuarioMotorFabrica obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public MotorRegla<Usuario> obtenerMotorReglas() {
        var motorUsuario = new MotorRegla<Usuario>();
        var reglaUsuario = UsuarioRegla.obtenerInstancia();

        motorUsuario.agregarRegla(TipoOperacion.CREAR, usuario -> reglaUsuario.validarIdentificador(usuario.getIdentificador()));
        motorUsuario.agregarRegla(TipoOperacion.CREAR, reglaUsuario::validarCampos);
        motorUsuario.agregarRegla(TipoOperacion.ACTUALIZAR, usuario -> reglaUsuario.validarIdentificador(usuario.getIdentificador()));
        motorUsuario.agregarRegla(TipoOperacion.ACTUALIZAR, reglaUsuario::validarCampos);
        motorUsuario.agregarRegla(TipoOperacion.ELIMINAR, usuario -> reglaUsuario.validarIdentificador(usuario.getIdentificador()));
        motorUsuario.agregarRegla(TipoOperacion.CONSULTAR, usuario -> reglaUsuario.validarIdentificador(usuario.getIdentificador()));

        return motorUsuario;
    }
}