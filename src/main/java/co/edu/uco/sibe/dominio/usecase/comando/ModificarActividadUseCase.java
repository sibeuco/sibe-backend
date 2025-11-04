package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.enums.TipoArea;
import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.modelo.EjecucionActividad;
import co.edu.uco.sibe.dominio.puerto.comando.ActividadRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import co.edu.uco.sibe.dominio.service.ModificarVinculacionActividadConAreaService;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorDuplicadoExcepcion;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesErrorConstante.ACTIVIDAD_EXISTENTE_DURANTE_SEMESTRE_ACTUAL;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesErrorConstante.ACTIVIDAD_NO_EXISTE_CON_IDENTIFICADOR;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ModificarActividadUseCase {
    private final ActividadRepositorioComando actividadRepositorioComando;
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;
    private final ModificarVinculacionActividadConAreaService modificarVinculacionActividadConAreaService;

    public ModificarActividadUseCase(ActividadRepositorioComando actividadRepositorioComando, ActividadRepositorioConsulta actividadRepositorioConsulta, ModificarVinculacionActividadConAreaService modificarVinculacionActividadConAreaService) {
        this.actividadRepositorioComando = actividadRepositorioComando;
        this.actividadRepositorioConsulta = actividadRepositorioConsulta;
        this.modificarVinculacionActividadConAreaService = modificarVinculacionActividadConAreaService;
    }

    public UUID ejecutar(Actividad actividad, List<EjecucionActividad> ejecucionesActividad, UUID area, TipoArea tipoArea, UUID identificador) {
        validarSiNoExistePersonaConId(identificador);

        MotoresFabrica.MOTOR_ACTIVIDAD.ejecutar(actividad, TipoOperacion.CREAR);

        validarSiExisteActividadConNombreEnElSemestre(actividad.getNombre(), actividad.getSemestre(), identificador);

        this.actividadRepositorioComando.modificar(actividad);

        this.modificarVinculacionActividadConAreaService.ejecutar(actividad, area, tipoArea);

        ejecucionesActividad.forEach(ejecucionActividad -> {
            MotoresFabrica.MOTOR_ESTADO_ACTIVIDAD.ejecutar(ejecucionActividad.getEstadoActividad(), TipoOperacion.CREAR);
            MotoresFabrica.MOTOR_EJECUCION_ACTIVIDAD.ejecutar(ejecucionActividad, TipoOperacion.CREAR);
        });

        actividadRepositorioComando.modificarEjecuciones(ejecucionesActividad);

        return identificador;
    }

    private void validarSiNoExistePersonaConId(UUID identificador) {
        if (esNulo(this.actividadRepositorioConsulta.consultarPorIdentificador(identificador))){
            throw new ValorDuplicadoExcepcion(ACTIVIDAD_NO_EXISTE_CON_IDENTIFICADOR);
        }
    }

    private void validarSiExisteActividadConNombreEnElSemestre(String nombre, String semestre, UUID identificador) {
        var actividad = this.actividadRepositorioConsulta.consultarPorNombreYSemestre(nombre, semestre);
        if (!esNulo(actividad) && !actividad.getIdentificador().equals(identificador)){
            throw new ValorDuplicadoExcepcion(ACTIVIDAD_EXISTENTE_DURANTE_SEMESTRE_ACTUAL);
        }
    }
}