package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import lombok.Getter;
import java.util.UUID;

@Getter
public class RegistroAsistencia {
    private UUID identificador;
    private EjecucionActividad ejecucionActividad;
    private Participante participante;

    private RegistroAsistencia(UUID identificador, EjecucionActividad ejecucionActividad, Participante participante) {
        this.identificador = identificador;
        this.ejecucionActividad = ejecucionActividad;
        this.participante = participante;
    }

    public static RegistroAsistencia construir(UUID identificador, EjecucionActividad ejecucionActividad, Participante participante) {
        return new RegistroAsistencia(
                identificador,
                ValidadorObjeto.obtenerValorPorDefecto(ejecucionActividad, EjecucionActividad.construir()),
                ValidadorObjeto.obtenerValorPorDefecto(participante, Participante.construir())
        );
    }

    public static RegistroAsistencia construir() {
        return new RegistroAsistencia(
                UtilUUID.obtenerValorDefecto(),
                EjecucionActividad.construir(),
                Participante.construir()
        );
    }
}