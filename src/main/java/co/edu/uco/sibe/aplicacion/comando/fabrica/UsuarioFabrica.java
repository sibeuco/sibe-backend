package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.aplicacion.comando.UsuarioModificacionComando;
import co.edu.uco.sibe.dominio.dto.AreaDTO;
import co.edu.uco.sibe.dominio.dto.PersonaDTO;
import co.edu.uco.sibe.dominio.dto.TipoAreaDTO;
import co.edu.uco.sibe.dominio.dto.TipoUsuarioDTO;
import co.edu.uco.sibe.dominio.modelo.*;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoAreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoUsuarioRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsuarioFabrica {

    private final TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta;
    private final AreaRepositorioConsulta areaRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final TipoAreaRepositorioConsulta tipoAreaRepositorioConsulta;
    private final PersonaFabrica personaFabrica;

    public UsuarioFabrica(TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta, AreaRepositorioConsulta areaRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta, TipoAreaRepositorioConsulta tipoAreaRepositorioConsulta, PersonaFabrica personaFabrica) {
        this.tipoUsuarioRepositorioConsulta = tipoUsuarioRepositorioConsulta;
        this.areaRepositorioConsulta = areaRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.tipoAreaRepositorioConsulta = tipoAreaRepositorioConsulta;
        this.personaFabrica = personaFabrica;
    }

    public Usuario construir(UsuarioComando usuario){
        var identificadorUsuario = generarNuevoUUIDUnico();

        TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioRepositorioConsulta.consultarTipoUsuarioPorIdentificador(usuario.getTipoUsuario());
        TipoUsuario tipoUsuario = TipoUsuario.construir(tipoUsuarioDTO.getIdentificador(),
                tipoUsuarioDTO.getNombre(),
                tipoUsuarioDTO.isCrear(), tipoUsuarioDTO.isModificar(),
                tipoUsuarioDTO.isEliminar(),
                tipoUsuarioDTO.isConsultar());

        AreaDTO areaDTO = areaRepositorioConsulta.consultarAreaPorIdentificador(usuario.getArea());
        Area area = construirAreaModelo(areaDTO);

        Persona persona = personaFabrica.construir(usuario.getPersona());

        return Usuario.construir(identificadorUsuario, usuario.getCorreo(), usuario.getContrasena(), tipoUsuario, area, persona);

    }

    public Usuario construirActualizar(UsuarioModificacionComando usuario, UUID identificador){
        TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioRepositorioConsulta.consultarTipoUsuarioPorIdentificador(usuario.getTipoUsuario());
        TipoUsuario tipoUsuario = TipoUsuario.construir(tipoUsuarioDTO.getIdentificador(),
                tipoUsuarioDTO.getNombre(),
                tipoUsuarioDTO.isCrear(), tipoUsuarioDTO.isModificar(),
                tipoUsuarioDTO.isEliminar(),
                tipoUsuarioDTO.isConsultar());

        AreaDTO areaDTO = areaRepositorioConsulta.consultarAreaPorIdentificador(usuario.getArea());
        Area area = construirAreaModelo(areaDTO);

        PersonaDTO personaDTO = personaRepositorioConsulta.consultarPersonaPorIdentificador(usuario.getPersona());
        TipoIdentificacion tipoIdentificacion = TipoIdentificacion.construir(personaDTO.getTipoIdentificacion().getIdentificador(), personaDTO.getTipoIdentificacion().getSigla(), personaDTO.getTipoIdentificacion().getDescripcion());
        Persona persona = Persona.construir(personaDTO.getIdentificador(), tipoIdentificacion, personaDTO.getDocumento(), personaDTO.getPrimerNombre(), personaDTO.getSegundoNombre(), personaDTO.getPrimerApellido(), personaDTO.getSegundoApellido());

        return Usuario.construir(identificador, usuario.getCorreo(), "", tipoUsuario, area, persona);

    }

    private Area construirAreaModelo(AreaDTO areaDTO) {
        TipoAreaDTO tipoAreaDTO = tipoAreaRepositorioConsulta.consultarTipoAreaPorIdentificador(areaDTO.getTipoArea().getIdentificador());

        TipoArea tipoArea = TipoArea.construir(
                tipoAreaDTO.getIdentificador(),
                tipoAreaDTO.getNombre(),
                tipoAreaDTO.isGestionable(),
                tipoAreaDTO.getNivel()
        );

        Area areaPadre = null;
        if (areaDTO.getAreaPadre() != null) {
            AreaDTO areaPadreDTO = areaRepositorioConsulta.consultarAreaPorIdentificador(areaDTO.getAreaPadre().getIdentificador());
            areaPadre = construirAreaModelo(areaPadreDTO);
        }

        return Area.construir(areaDTO.getIdentificador(), areaDTO.getNombreArea(), tipoArea, areaPadre);
    }

    public UUID generarNuevoUUIDUnico() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (personaRepositorioConsulta.consultarUsuarioPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }

}
