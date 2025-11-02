package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.AccionDTO;
import co.edu.uco.sibe.dominio.modelo.Accion;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.AccionEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ProyectoAccionEntidad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccionMapeador {
    public AccionEntidad construirEntidad(Accion accion) {
        return new AccionEntidad(accion.getIdentificador(), accion.getDetalle(), accion.getObjetivo());
    }

    public Accion construriModelo(AccionEntidad accion) {
        return Accion.construir(accion.getIdentificador(), accion.getDetalle(), accion.getObjetivo());
    }

    public List<Accion> construirModelos(List<AccionEntidad> acciones){
        return acciones.stream().map(this::construriModelo).toList();
    }

    public AccionDTO construirDTO(AccionEntidad accion){
        return new AccionDTO(accion.getIdentificador().toString(), accion.getDetalle(), accion.getObjetivo());
    }

    public List<AccionDTO> construirDTOs(List<AccionEntidad> acciones){
        return acciones.stream().map(this::construirDTO).toList();
    }

    public void actualizarEntidad(AccionEntidad entidad, Accion accion) {
        entidad.setDetalle(accion.getDetalle());
        entidad.setObjetivo(accion.getObjetivo());
    }
}