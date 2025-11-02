package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.ActividadComando;
import co.edu.uco.sibe.aplicacion.comando.ActividadModificacionComando;
import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.modelo.EjecucionActividad;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.EstadoActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.IndicadorRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilFecha;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.PENDIENTE;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.generar;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Component
@AllArgsConstructor
public class ActividadFabrica {

    private final ActividadRepositorioConsulta actividadRepositorioConsulta;
    private final IndicadorRepositorioConsulta indicadorRepositorioConsulta;
    private final EstadoActividadRepositorioConsulta estadoActividadRepositorioConsulta;

    public Actividad construir(ActividadComando comando) {
        var indicadorUuid = UtilUUID.textoAUUID(comando.getIndicador());
        var indicador = indicadorRepositorioConsulta.consultarPorIdentificador(indicadorUuid);

        return Actividad.construir(
                generar(uuid -> !esNulo(actividadRepositorioConsulta.consultarPorIdentificador(uuid))),
                comando.getNombre(),
                comando.getObjetivo(),
                comando.getSemestre(),
                comando.getRutaInsumos(),
                indicador,
                UtilUUID.textoAUUID(comando.getColaborador()),
                UtilUUID.textoAUUID(comando.getCreador())
        );
    }

    public Actividad construirActualizar(ActividadModificacionComando comando, UUID identificador) {
        var indicadorUuid = UtilUUID.textoAUUID(comando.getIndicador());
        var indicador = indicadorRepositorioConsulta.consultarPorIdentificador(indicadorUuid);
        var actividadExistente = actividadRepositorioConsulta.consultarPorIdentificador(identificador);

        return Actividad.construir(
                identificador,
                comando.getNombre(),
                comando.getObjetivo(),
                comando.getSemestre(),
                comando.getRutaInsumos(),
                indicador,
                UtilUUID.textoAUUID(comando.getColaborador()),
                actividadExistente.getCreador()
        );
    }

    public List<EjecucionActividad> construirEjecuciones(List<String> fechas, Actividad actividadPadre) {
        var estadoProgramada = estadoActividadRepositorioConsulta.consultarPorNombre(PENDIENTE);

        return fechas.stream()
                .map(fechaStr -> {
                    var fechaProgramada = UtilFecha.formatearTextoAFecha(fechaStr);

                    var idEjecucion = generar(uuid -> !esNulo(actividadRepositorioConsulta.consultarEjecucionActividadPorIdentificador(uuid)));
                    return EjecucionActividad.construir(
                            idEjecucion,
                            fechaProgramada,
                            UtilFecha.obtenerFechaDefecto(),
                            UtilFecha.obtenerHoraDefecto(),
                            UtilFecha.obtenerHoraDefecto(),
                            estadoProgramada,
                            actividadPadre
                    );
                })
                .toList();
    }
}