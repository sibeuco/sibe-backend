package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.aplicacion.comando.UsuarioModificacionComando;
import co.edu.uco.sibe.dominio.modelo.Identificacion;
import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.puerto.consulta.IdentificacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoIdentificacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PersonaFabrica {
    private final TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta;
    private final IdentificacionRepositorioConsulta identificacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public Persona construir(UsuarioComando comando){
        var identificadorIdentificacion = generarNuevoUUIDIdentificacion();
        var identificadorPersona = generarNuevoUUIDPersona();

        var tipoIdentificacion = tipoIdentificacionRepositorioConsulta.consultarTipoIdentificacionPorIdentificador(UUID.fromString(comando.getTipoIdentificacion()));
        var identificacion = Identificacion.construir(identificadorIdentificacion, comando.getNumeroIdentificacion(), tipoIdentificacion);

        MotoresFabrica.MOTOR_IDENTIFICACION.ejecutar(identificacion, TipoOperacion.CREAR);

        var persona = Persona.construir(identificadorPersona, comando.getNombres(), comando.getApellidos(), comando.getCorreo(), identificacion);

        MotoresFabrica.MOTOR_PERSONA.ejecutar(persona, TipoOperacion.CREAR);

        return persona;
    }

    public Persona construirActualizar(UsuarioModificacionComando comando, UUID identificador){
        var tipoIdentificacion = tipoIdentificacionRepositorioConsulta.consultarTipoIdentificacionPorIdentificador(UtilUUID.convertirAUUID(comando.getTipoIdentificacion()));
        var identificacionIdentificador = personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador).getIdentificacion().getIdentificador();

        var identificacion = Identificacion.construir(identificacionIdentificador, comando.getNumeroIdentificacion(), tipoIdentificacion);

        MotoresFabrica.MOTOR_IDENTIFICACION.ejecutar(identificacion, TipoOperacion.ACTUALIZAR);

        var persona = Persona.construir(identificador, comando.getNombres(), comando.getApellidos(), comando.getCorreo(), identificacion);

        MotoresFabrica.MOTOR_PERSONA.ejecutar(persona, TipoOperacion.ACTUALIZAR);

        return persona;
    }

    public UUID generarNuevoUUIDIdentificacion() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (identificacionRepositorioConsulta.consultarPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }

    public UUID generarNuevoUUIDPersona() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (personaRepositorioConsulta.consultarPersonaPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }
}
