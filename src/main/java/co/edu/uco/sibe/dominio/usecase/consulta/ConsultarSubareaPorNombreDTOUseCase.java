package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.SubareaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.SubareaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.SUBAREA_NO_ENCONTRADA_CON_NOMBRE;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarSubareaPorNombreDTOUseCase {
    private final SubareaRepositorioConsulta subareaRepositorioConsulta;

    public ConsultarSubareaPorNombreDTOUseCase(SubareaRepositorioConsulta subareaRepositorioConsulta) {
        this.subareaRepositorioConsulta = subareaRepositorioConsulta;
    }

    public SubareaDTO ejecutar(String nombre) {
        return validarSiExisteSubarea(nombre);
    }

    private SubareaDTO validarSiExisteSubarea(String nombre) {
        var subarea = subareaRepositorioConsulta.consultarPorNombreDTO(nombre);
        if (esNulo(subarea)) {
            throw new ValorInvalidoExcepcion(SUBAREA_NO_ENCONTRADA_CON_NOMBRE + nombre);
        }
        return subarea;
    }
}