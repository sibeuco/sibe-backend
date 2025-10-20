package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorRespuesta;
import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.puerto.consulta.SubareaRepositorioConsulta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarSubareasManejador implements ManejadorRespuesta<List<Subarea>> {
    private final SubareaRepositorioConsulta subareaRepositorioConsulta;

    @Override
    public List<Subarea> ejecutar() {
        return this.subareaRepositorioConsulta.consultarTodos();
    }
}