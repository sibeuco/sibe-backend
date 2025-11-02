package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.MiembroDTO;
import co.edu.uco.sibe.dominio.enums.TipoParticipante;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.EmpleadoEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.EstudianteEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ExternoEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.MiembroEntidad;
import org.springframework.stereotype.Component;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.NO_APLICA;

@Component
public class MiembroMapeador {

    public MiembroDTO construirDTO(MiembroEntidad miembro) {
        if (miembro instanceof EstudianteEntidad e) {
            return new MiembroDTO(
                    e.getIdentificador().toString(),
                    e.getNombreCompleto(),
                    e.getNumeroIdentificacion(),
                    e.getProgramaAcademico(),
                    e.getCorreoInstitucional(),
                    TipoParticipante.INTERNO.name()
            );
        }

        if (miembro instanceof EmpleadoEntidad e) {
            return new MiembroDTO(
                    e.getIdentificador().toString(),
                    e.getNombreCompleto(),
                    e.getNumeroIdentificacion(),
                    NO_APLICA,
                    NO_APLICA,
                    TipoParticipante.INTERNO.name()
            );
        }

        if (miembro instanceof ExternoEntidad e) {
            return new MiembroDTO(
                    e.getIdentificador().toString(),
                    e.getNombreCompleto(),
                    e.getNumeroIdentificacion(),
                    NO_APLICA,
                    NO_APLICA,
                    TipoParticipante.EXTERNO.name()
            );
        }

        return null;
    }
}