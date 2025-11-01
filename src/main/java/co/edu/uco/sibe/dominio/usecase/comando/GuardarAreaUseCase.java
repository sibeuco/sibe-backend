package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.dominio.puerto.comando.AreaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorDuplicadoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.NOMBRE_AREA_EXISTENTE;

public class GuardarAreaUseCase {
    private final AreaRepositorioComando areaRepositorioComando;
    private final AreaRepositorioConsulta areaRepositorioConsulta;

    public GuardarAreaUseCase(AreaRepositorioComando areaRepositorioComando, AreaRepositorioConsulta areaRepositorioConsulta) {
        this.areaRepositorioComando = areaRepositorioComando;
        this.areaRepositorioConsulta = areaRepositorioConsulta;
    }

    public UUID ejecutar(Area area) {
        MotoresFabrica.MOTOR_AREA.ejecutar(area, TipoOperacion.CREAR);

        validarNoExisteAreaConNombre(area.getNombre());

        return this.areaRepositorioComando.guardar(area);
    }

    private void validarNoExisteAreaConNombre(String nombre) {
        if (!ValidadorObjeto.esNulo(this.areaRepositorioConsulta.consultarPorNombre(nombre))){
            throw new ValorDuplicadoExcepcion(NOMBRE_AREA_EXISTENTE);
        }
    }
}
