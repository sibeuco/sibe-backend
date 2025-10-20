package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ActividadEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ActividadMapeador {
    private final IndicadorMapeador indicadorMapeador;

    public ActividadEntidad construirEntidad(Actividad actividad) {
        return new ActividadEntidad(
                actividad.getIdentificador(),
                actividad.getNombre(),
                actividad.getObjetivo(),
                actividad.getSemestre(),
                actividad.getRutaInsumos(),
                this.indicadorMapeador.construirEntidad(actividad.getIndicador()),
                actividad.getColaborador(),
                actividad.getCreador()
        );
    }

    public List<ActividadEntidad> construirEntidades(List<Actividad> actividades) {
        return actividades.stream().map(this::construirEntidad).toList();
    }

    public Actividad construriModelo(ActividadEntidad actividad) {
        return Actividad.construir(
                actividad.getIdentificador(),
                actividad.getNombre(),
                actividad.getObjetivo(),
                actividad.getSemestre(),
                actividad.getRutaInsumos(),
                this.indicadorMapeador.construriModelo(actividad.getIndicador()),
                actividad.getColaborador(),
                actividad.getCreador()
        );
    }

    public List<Actividad> construirModelos(List<ActividadEntidad> actividades) {
        return actividades.stream().map(this::construriModelo).toList();
    }
}