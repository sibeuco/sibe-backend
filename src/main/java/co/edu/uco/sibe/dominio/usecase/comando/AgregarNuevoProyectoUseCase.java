package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Proyecto;
import co.edu.uco.sibe.dominio.puerto.comando.ProyectoRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;

import java.util.UUID;

public class AgregarNuevoProyectoUseCase {
    private final ProyectoRepositorioComando proyectoRepositorioComando;

    public AgregarNuevoProyectoUseCase(ProyectoRepositorioComando proyectoRepositorioComando) {
        this.proyectoRepositorioComando = proyectoRepositorioComando;
    }

    public UUID ejecutar(Proyecto proyecto){
        MotoresFabrica.MOTOR_PROYECTO.ejecutar(proyecto, TipoOperacion.CREAR);

        return this.proyectoRepositorioComando.guardar(proyecto);
    }
}
