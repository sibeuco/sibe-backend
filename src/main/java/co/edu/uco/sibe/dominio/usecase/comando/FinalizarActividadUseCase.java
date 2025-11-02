package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.EjecucionActividad;
import co.edu.uco.sibe.dominio.modelo.EstadoActividad;
import co.edu.uco.sibe.dominio.modelo.Participante;
import co.edu.uco.sibe.dominio.modelo.RegistroAsistencia;
import co.edu.uco.sibe.dominio.puerto.comando.ActividadRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.comando.RegistroAsistenciaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.EstadoActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.RegistroAsistenciaRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.RegistrarParticipanteService;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.FINALIZADA;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.EJECUCION_ACTIVIDAD_NO_ENCONTRADA_CON_ID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.ESTADO_ACTIVIDAD_NO_ENCONTRADO_CON_NOMBRE;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.generar;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class FinalizarActividadUseCase {

    private final ActividadRepositorioComando actividadRepositorioComando;
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;
    private final EstadoActividadRepositorioConsulta estadoActividadRepositorioConsulta;
    private final RegistrarParticipanteService registrarParticipanteService;
    private final RegistroAsistenciaRepositorioComando registroAsistenciaRepositorioComando;
    private final RegistroAsistenciaRepositorioConsulta registroAsistenciaRepositorioConsulta;

    public FinalizarActividadUseCase(ActividadRepositorioComando actividadRepositorioComando, ActividadRepositorioConsulta actividadRepositorioConsulta, EstadoActividadRepositorioConsulta estadoActividadRepositorioConsulta, RegistrarParticipanteService registrarParticipanteService, RegistroAsistenciaRepositorioComando registroAsistenciaRepositorioComando, RegistroAsistenciaRepositorioConsulta registroAsistenciaRepositorioConsulta) {
        this.actividadRepositorioComando = actividadRepositorioComando;
        this.actividadRepositorioConsulta = actividadRepositorioConsulta;
        this.estadoActividadRepositorioConsulta = estadoActividadRepositorioConsulta;
        this.registrarParticipanteService = registrarParticipanteService;
        this.registroAsistenciaRepositorioComando = registroAsistenciaRepositorioComando;
        this.registroAsistenciaRepositorioConsulta = registroAsistenciaRepositorioConsulta;
    }

    public UUID ejecutar(UUID ejecucionId, List<Participante> participantes) {
        var ejecucion = validarSiExisteEjecucion(ejecucionId);
        var estado = validarSiExisteEstado(FINALIZADA);

        var ejecucionFinalizada = EjecucionActividad.construir(
                ejecucion.getIdentificador(),
                ejecucion.getFechaProgramada(),
                LocalDate.now(),
                ejecucion.getHoraInicio(),
                LocalTime.now(),
                estado,
                ejecucion.getActividad()
        );

        actividadRepositorioComando.modificarEjecucion(ejecucionFinalizada);

        participantes.forEach(p -> {
            var participanteRegistrado = registrarParticipanteService.ejecutar(p);
            var registro = RegistroAsistencia.construir(
                    generar(uuid -> !esNulo(actividadRepositorioConsulta.consultarPorIdentificador(uuid))),
                    ejecucionFinalizada,
                    participanteRegistrado
            );
            registroAsistenciaRepositorioComando.guardar(registro);
        });

        return ejecucionId;
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