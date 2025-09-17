package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class RegistroAsistencia {
    private UUID identificador;
    private EjecucionActividad ejecucionActividad;
    private Participante participante;

    private RegistroAsistencia(UUID identificador, EjecucionActividad ejecucionActividad, Participante participante) {
        setIdentificador(identificador);
        setEjecucionActividad(ejecucionActividad);
        setParticipante(participante);
    }

    public static RegistroAsistencia construir(UUID identificador, EjecucionActividad ejecucionActividad, Participante participante) {
        return new RegistroAsistencia(identificador, ejecucionActividad, participante);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public EjecucionActividad getEjecucionActividad() {
        return ejecucionActividad;
    }

    public Participante getParticipante() {
        return participante;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setEjecucionActividad(EjecucionActividad ejecucionActividad) {
        this.ejecucionActividad = ejecucionActividad;
    }

    private void setParticipante(Participante participante) {
        this.participante = participante;
    }
}