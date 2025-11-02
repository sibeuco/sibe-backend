package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.ParticipanteComando;
import co.edu.uco.sibe.dominio.enums.TipoParticipante;
import co.edu.uco.sibe.dominio.modelo.*;
import co.edu.uco.sibe.dominio.puerto.consulta.MiembroRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.ParticipanteRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.NO_APLICA;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.MIEMBRO_NO_ENCONTRADO_CON_DOCUMENTO;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.generar;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Component
@AllArgsConstructor
public class ParticipanteFabrica {

    private final MiembroRepositorioConsulta miembroRepositorioConsulta;
    private final ParticipanteRepositorioConsulta participanteRepositorioConsulta;

    public List<Participante> construirParticipantes(List<ParticipanteComando> comandos) {
        return comandos.stream().map(this::construir).toList();
    }

    public Participante construir(ParticipanteComando comando) {
        var miembroDto = miembroRepositorioConsulta.consultarPorIdentificacion(comando.getDocumentoIdentificacion());
        if (esNulo(miembroDto)) {
            throw new ValorInvalidoExcepcion(MIEMBRO_NO_ENCONTRADO_CON_DOCUMENTO + comando.getDocumentoIdentificacion());
        }

        var miembro = Miembro.construir(
                UtilUUID.textoAUUID(miembroDto.getIdentificador()),
                miembroDto.getNombreCompleto(),
                miembroDto.getDocumentoIdentificacion()
        );

        var tipo = TipoParticipante.valueOf(comando.getTipo());


        var idParticipante = generar(uuid -> !esNulo(this.participanteRepositorioConsulta.consultarPorIdentificador(uuid)));

        if (tipo == TipoParticipante.EXTERNO) {
            return ParticipanteExterno.construir(idParticipante, miembro);
        }

        if (tipo == TipoParticipante.INTERNO && !comando.getProgramaAcademico().equals(NO_APLICA)) {
            return construirParticipanteEstudiante(idParticipante, miembro, comando);
        }

        if (tipo == TipoParticipante.INTERNO) {
            return construirParticipanteEmpleado(idParticipante, miembro, comando);
        }

        return Participante.construir(idParticipante, miembro);
    }

    private ParticipanteEstudiante construirParticipanteEstudiante(UUID id, Miembro m, ParticipanteComando c) {
        return ParticipanteEstudiante.construir(
                id, m, CiudadResidencia.construir(), c.getCorreoInstitucional(),
                VACIO, VACIO, c.getProgramaAcademico(), VACIO, 0, VACIO, 0, 0, VACIO, VACIO, 0, VACIO
        );
    }

    private ParticipanteEmpleado construirParticipanteEmpleado(UUID id, Miembro m, ParticipanteComando c) {
        return ParticipanteEmpleado.construir(
                id, m, CiudadResidencia.construir(), c.getCorreoInstitucional(),
                VACIO, RelacionLaboral.construir(), CentroCostos.construir()
        );
    }
}