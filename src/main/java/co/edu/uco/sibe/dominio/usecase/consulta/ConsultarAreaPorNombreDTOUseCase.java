package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.AreaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesErrorConstante.AREA_NO_ENCONTRADA_CON_NOMBRE;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesSistemaConstante.obtenerMensajeConParametro;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarAreaPorNombreDTOUseCase {
    private final AreaRepositorioConsulta areaRepositorioConsulta;

    public ConsultarAreaPorNombreDTOUseCase(AreaRepositorioConsulta areaRepositorioConsulta) {
        this.areaRepositorioConsulta = areaRepositorioConsulta;
    }

    public AreaDTO ejecutar(String nombre) {
        return validarSiExisteArea(nombre);
    }

    private AreaDTO validarSiExisteArea(String nombre) {
        var area = areaRepositorioConsulta.consultarPorNombreDTO(nombre);
        if (esNulo(area)) {
            throw new ValorInvalidoExcepcion(obtenerMensajeConParametro(AREA_NO_ENCONTRADA_CON_NOMBRE, nombre));
        }
        return area;
    }
}