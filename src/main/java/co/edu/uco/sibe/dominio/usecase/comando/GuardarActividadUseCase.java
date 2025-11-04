package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.enums.TipoArea;
import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.modelo.EjecucionActividad;
import co.edu.uco.sibe.dominio.puerto.comando.ActividadRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import co.edu.uco.sibe.dominio.service.VincularActividadConAreaService;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorDuplicadoExcepcion;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajeConstante.ACTIVIDAD_EXISTENTE_DURANTE_SEMESTRE_ACTUAL;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class GuardarActividadUseCase {
    private final ActividadRepositorioComando actividadRepositorioComando;
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;
    private final VincularActividadConAreaService vincularActividadConAreaService;

    public GuardarActividadUseCase(ActividadRepositorioComando actividadRepositorioComando, ActividadRepositorioConsulta actividadRepositorioConsulta, VincularActividadConAreaService vincularActividadConAreaService) {
        this.actividadRepositorioComando = actividadRepositorioComando;
        this.actividadRepositorioConsulta = actividadRepositorioConsulta;
        this.vincularActividadConAreaService = vincularActividadConAreaService;
    }

    public UUID ejecutar(Actividad actividad, List<EjecucionActividad> ejecucionesActividad, UUID area, TipoArea tipoArea) {
        MotoresFabrica.MOTOR_ACTIVIDAD.ejecutar(actividad, TipoOperacion.CREAR);

        validarSiExisteActividadConNombreEnElSemestre(actividad.getNombre(), actividad.getSemestre());

        var identificador = this.actividadRepositorioComando.guardar(actividad);

        this.vincularActividadConAreaService.ejecutar(actividad, area, tipoArea);

        ejecucionesActividad.forEach(ejecucionActividad -> {
            MotoresFabrica.MOTOR_ESTADO_ACTIVIDAD.ejecutar(ejecucionActividad.getEstadoActividad(), TipoOperacion.CREAR);
            MotoresFabrica.MOTOR_EJECUCION_ACTIVIDAD.ejecutar(ejecucionActividad, TipoOperacion.CREAR);

            actividadRepositorioComando.guardarEjecucion(ejecucionActividad);
        });

        return identificador;
    }

    private void validarSiExisteActividadConNombreEnElSemestre(String nombre, String semestre) {
        if (!esNulo(this.actividadRepositorioConsulta.consultarPorNombreYSemestre(nombre, semestre))){
            throw new ValorDuplicadoExcepcion(ACTIVIDAD_EXISTENTE_DURANTE_SEMESTRE_ACTUAL);
        }
    }
}