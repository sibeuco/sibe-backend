package co.edu.uco.sibe.dominio.service;

import co.edu.uco.sibe.dominio.modelo.Participante;
import co.edu.uco.sibe.dominio.puerto.comando.ParticipanteRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.ParticipanteRepositorioConsulta;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class RegistrarParticipanteService {
    private final ParticipanteRepositorioConsulta participanteRepositorioConsulta;
    private final ParticipanteRepositorioComando participanteRepositorioComando;

    public RegistrarParticipanteService(ParticipanteRepositorioConsulta participanteRepositorioConsulta, ParticipanteRepositorioComando participanteRepositorioComando) {
        this.participanteRepositorioConsulta = participanteRepositorioConsulta;
        this.participanteRepositorioComando = participanteRepositorioComando;
    }

    public Participante ejecutar(Participante participante) {
        var participanteExistente = participanteRepositorioConsulta.consultarPorDocumentoMiembro(participante.getMiembro().getNumeroIdentificacion());

        if (esNulo(participanteExistente)) {
            var identificador = participanteRepositorioComando.guardar(participante);

            return obtenerParticipanteConId(participante, identificador);
        }

        return participanteExistente;
    }

    private Participante obtenerParticipanteConId(Participante participante, UUID identificador) {
        return Participante.construir(
                identificador,
                participante.getMiembro()
        );
    }
}