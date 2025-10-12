package co.edu.uco.sibe.dominio.regla.fabrica;

import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.regla.fabrica.implementacion.UsuarioMotorFabrica;
import co.edu.uco.sibe.dominio.regla.motor.MotorRegla;

public final class MotoresFabrica {
    public static final MotorRegla<Usuario> MOTOR_USUARIO;

    static {
        MOTOR_USUARIO = UsuarioMotorFabrica.obtenerInstancia().obtenerMotorReglas();
    }

    private MotoresFabrica() {}
}