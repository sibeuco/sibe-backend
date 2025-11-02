package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.EjecucionActividad;
import co.edu.uco.sibe.dominio.modelo.EstadoActividad;
import co.edu.uco.sibe.dominio.puerto.comando.ActividadRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.EstadoActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import java.time.LocalTime;
import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.EN_CURSO;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.EJECUCION_ACTIVIDAD_NO_ENCONTRADA_CON_ID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.ESTADO_ACTIVIDAD_NO_ENCONTRADO_CON_NOMBRE;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class IniciarActividadUseCase {

    private final ActividadRepositorioComando actividadRepositorioComando;
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;
    private final EstadoActividadRepositorioConsulta estadoActividadRepositorioConsulta;

    public IniciarActividadUseCase(ActividadRepositorioComando actividadRepositorioComando, ActividadRepositorioConsulta actividadRepositorioConsulta, EstadoActividadRepositorioConsulta estadoActividadRepositorioConsulta) {
        this.actividadRepositorioComando = actividadRepositorioComando;
        this.actividadRepositorioConsulta = actividadRepositorioConsulta;
        this.estadoActividadRepositorioConsulta = estadoActividadRepositorioConsulta;
    }

    public UUID ejecutar(UUID identificadorEjecucion) {
        var ejecucion = validarSiExisteEjecucion(identificadorEjecucion);
        var estado = validarSiExisteEstado(EN_CURSO);

        var ejecucionActualizada = EjecucionActividad.construir(
                ejecucion.getIdentificador(),
                ejecucion.getFechaProgramada(),
                ejecucion.getFechaRealizacion(),
                LocalTime.now(),
                ejecucion.getHoraFin(),
                estado,
                ejecucion.getActividad()
        );

        actividadRepositorioComando.modificarEjecucion(ejecucionActualizada);
        return identificadorEjecucion;
    }

    private EjecucionActividad validarSiExisteEjecucion(UUID id) {
        var ejecucion = actividadRepositorioConsulta.consultarEjecucionActividadPorIdentificador(id);
        if (esNulo(ejecucion)) {
            throw new ValorInvalidoExcepcion(EJECUCION_ACTIVIDAD_NO_ENCONTRADA_CON_ID + id);
        }
        return ejecucion;
    }

    private EstadoActividad validarSiExisteEstado(String nombre) {
        var estado = estadoActividadRepositorioConsulta.consultarPorNombre(nombre);
        if (esNulo(estado)) {
            throw new ValorInvalidoExcepcion(ESTADO_ACTIVIDAD_NO_ENCONTRADO_CON_NOMBRE + nombre);
        }
        return estado;
    }
}