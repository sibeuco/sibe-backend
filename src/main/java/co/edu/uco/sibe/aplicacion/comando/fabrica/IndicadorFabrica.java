package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.IndicadorComando;
import co.edu.uco.sibe.dominio.modelo.Indicador;
import co.edu.uco.sibe.dominio.puerto.consulta.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.generar;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.textoAUUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Component
@AllArgsConstructor
public class IndicadorFabrica {
    private final IndicadorRepositorioConsulta indicadorRepositorioConsulta;
    private final TipoIndicadorRepositorioConsulta tipoIndicadorRepositorioConsulta;
    private final TemporalidadRepositorioConsulta temporalidadRepositorioConsulta;
    private final ProyectoRepositorioConsulta proyectoRepositorioConsulta;
    private final PublicoInteresRepositorioConsulta publicoInteresRepositorioConsulta;

    public Indicador construir(IndicadorComando comando) {
        return Indicador.construir(
                generar(uuid -> !esNulo(indicadorRepositorioConsulta.consultarPorIdentificador(uuid))),
                comando.getNombre(),
                tipoIndicadorRepositorioConsulta.consultarPorIdentificador(textoAUUID(comando.getTipoIndicador())),
                temporalidadRepositorioConsulta.consultarPorIdentificador(textoAUUID(comando.getTipoIndicador())),
                proyectoRepositorioConsulta.consultarPorIdentificador(textoAUUID(comando.getTipoIndicador())),
                publicoInteresRepositorioConsulta.consultarPorIdentificador(textoAUUID(comando.getTipoIndicador()))
        );
    }
}
