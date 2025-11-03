package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.*;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Component
@AllArgsConstructor
public class ParticipanteMapeador {

    private final MiembroMapeador miembroMapeador;
    private final InternoCiudadResidenciaMapeador internoCiudadResidenciaMapeador;
    private final EmpleadoRelacionLaboralMapeador empleadoRelacionLaboralMapeador;
    private final EmpleadoCentroCostosMapeador empleadoCentroCostosMapeador;

    public ParticipanteEntidad construirEntidad(Participante dominio) {
        if (esNulo(dominio)) {
            return null;
        }

            var miembroEntidad = miembroMapeador.construirEntidad(dominio.getMiembro());

        if (dominio instanceof ParticipanteEstudiante e) {
            return new ParticipanteEstudianteEntidad(
                    e.getEstadoCivil(),
                    e.getProgramaAcademico(),
                    e.getFacultad(),
                    e.getAnnoIngreso(),
                    e.getSemestreActual(),
                    e.getCreditosAprobados(),
                    e.getPromedioGeneral(),
                    e.getEstadoAcademico(),
                    e.getModalidadEstudio(),
                    e.getTiempoLlegadaUniversidad(),
                    e.getMedioTransporte()
            );
        }

        if (dominio instanceof ParticipanteEmpleado e) {
            return new ParticipanteEmpleadoEntidad(
                    empleadoRelacionLaboralMapeador.construirEntidad(e.getRelacionLaboral()),
                    empleadoCentroCostosMapeador.construirEntidad(e.getCentroCostos())
            );
        }

        if (dominio instanceof ParticipanteExterno) {
            return new ParticipanteExternoEntidad();
        }

        var entidad = new ParticipanteEntidad(dominio.getIdentificador(), miembroEntidad);

        if (dominio instanceof ParticipanteInterno i) {
            var interno = new ParticipanteInternoEntidad(
                    internoCiudadResidenciaMapeador.construirEntidad(i.getCiudadResidencia()),
                    i.getIdCarnet(),
                    i.getSexo()
            );
            interno.setIdentificador(i.getIdentificador());
            interno.setMiembro(miembroEntidad);
            return interno;
        }

        return entidad;
    }

    public Participante construirModelo(ParticipanteEntidad entidad) {
        if (esNulo(entidad)) {
            return null;
        }

        var miembro = miembroMapeador.construirModelo(entidad.getMiembro());

        if (entidad instanceof ParticipanteEstudianteEntidad e) {
            var interno = (ParticipanteInternoEntidad) e;
            return ParticipanteEstudiante.construir(
                    e.getIdentificador(),
                    miembro,
                    internoCiudadResidenciaMapeador.construirModelo(interno.getCiudadResidencia()),
                    interno.getIdCarnet(),
                    interno.getSexo(),
                    e.getEstadoCivil(),
                    e.getProgramaAcademico(),
                    e.getFacultad(),
                    e.getAnnoIngreso(),
                    e.getSemestreActual(),
                    e.getCreditosAprobados(),
                    e.getPromedioGeneral(),
                    e.getEstadoAcademico(),
                    e.getModalidadEstudio(),
                    e.getTiempoLlegadaUniversidad(),
                    e.getMedioTransporte()
            );
        }

        if (entidad instanceof ParticipanteEmpleadoEntidad e) {
            var interno = (ParticipanteInternoEntidad) e;
            return ParticipanteEmpleado.construir(
                    e.getIdentificador(),
                    miembro,
                    internoCiudadResidenciaMapeador.construirModelo(interno.getCiudadResidencia()),
                    interno.getIdCarnet(),
                    interno.getSexo(),
                    empleadoRelacionLaboralMapeador.construirModelo(e.getRelacionLaboral()),
                    empleadoCentroCostosMapeador.construirModelo(e.getCentroCostos())
            );
        }

        if (entidad instanceof ParticipanteExternoEntidad e) {
            return ParticipanteExterno.construir(e.getIdentificador(), miembro);
        }

        return Participante.construir(entidad.getIdentificador(), miembro);
    }
}