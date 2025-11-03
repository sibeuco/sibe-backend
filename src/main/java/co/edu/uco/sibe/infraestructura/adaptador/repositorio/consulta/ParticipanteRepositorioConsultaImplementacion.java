package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.modelo.Participante;
import co.edu.uco.sibe.dominio.puerto.consulta.ParticipanteRepositorioConsulta;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ParticipanteDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.ParticipanteMapeador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
@AllArgsConstructor
public class ParticipanteRepositorioConsultaImplementacion implements ParticipanteRepositorioConsulta {

    private final ParticipanteDAO participanteDAO;
    private final ParticipanteMapeador participanteMapeador;

    @Override
    public Participante consultarPorIdentificador(UUID identificador) {
        var entidad = participanteDAO.findById(identificador).orElse(null);
        if (esNulo(entidad)) {
            return null;
        }
        return participanteMapeador.construirModelo(entidad);
    }

    @Override
    public Participante consultarPorDocumentoMiembro(String documento) {
        var entidad = participanteDAO.findByMiembroNumeroIdentificacion(documento);
        if (esNulo(entidad)) {
            return null;
        }
        return participanteMapeador.construirModelo(entidad);
    }
}