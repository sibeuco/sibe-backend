package co.edu.uco.sibe.dominio.modelo;

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
        return new RegistroAsistencia(identificador, ejecucionActividad, participante);
    }
}