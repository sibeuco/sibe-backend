package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.ParticipanteDTO;
import co.edu.uco.sibe.dominio.enums.TipoInterno;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto.obtenerTipoPrograma;

@Component
@AllArgsConstructor
public class ParticipanteDetalladoMapeador {
    private final RelacionLaboralMapeador relacionLaboralMapeador;
    private final CentroCostosMapeador centroCostosMapeador;

    public ParticipanteDTO construirDTO(ParticipanteEntidad entidad) {
        if (esNulo(entidad) || esNulo(entidad.getMiembro())) {
            return null;
        }

        MiembroEntidad miembro = entidad.getMiembro();
        ParticipanteDTO dto = new ParticipanteDTO();
        dto.setIdentificador(entidad.getIdentificador().toString());
        dto.setNombreCompleto(miembro.getNombreCompleto());
        dto.setNumeroIdentificacion(miembro.getNumeroIdentificacion());

        if (entidad instanceof ParticipanteEstudianteEntidad e) {
            EstudianteEntidad estudiante = (EstudianteEntidad) miembro;
            dto.setTipoInterno(TipoInterno.ESTUDIANTE.name());
            dto.setFechaNacimiento(estudiante.getFechaNacimiento().toString());
            dto.setNacionalidad(estudiante.getNacionalidad());
            dto.setEstadoCivil(e.getEstadoCivil());
            dto.setCorreoPersonal(estudiante.getCorreoPersonal());
            dto.setCorreoInstitucional(estudiante.getCorreoInstitucional());
            dto.setProgramaAcademico(e.getProgramaAcademico());
            dto.setTipoProgramaAcademico(obtenerTipoPrograma(e.getProgramaAcademico()));
            dto.setFacultad(e.getFacultad());
            dto.setAnnoIngreso(e.getAnnoIngreso());
            dto.setSemestreActual(e.getSemestreActual());
            dto.setCreditosAprobados(e.getCreditosAprobados());
            dto.setPromedioGeneral(e.getPromedioGeneral());
            dto.setEstadoAcademico(e.getEstadoAcademico());
            dto.setModalidadEstudio(e.getModalidadEstudio());
            dto.setTiempoLlegadaUniversidad(e.getTiempoLlegadaUniversidad());
            dto.setMedioTransporte(e.getMedioTransporte());
        }

        if (entidad instanceof ParticipanteEmpleadoEntidad e) {
            dto.setRelacionLaboralDTO(relacionLaboralMapeador.construirDTO(e.getRelacionLaboral().getRelacionLaboral()));
            dto.setCentroCostosDTO(centroCostosMapeador.construirDTO(e.getCentroCostos().getCentroCostos()));
            dto.setTipoInterno(TipoInterno.EMPLEADO.name());
        }

        return dto;
    }
}