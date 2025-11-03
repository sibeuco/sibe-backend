package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.DireccionDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.DireccionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.DIRECCION_NO_ENCONTRADA_CON_NOMBRE;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarDireccionPorNombreDTOUseCase {
    private final DireccionRepositorioConsulta direccionRepositorioConsulta;

    public ConsultarDireccionPorNombreDTOUseCase(DireccionRepositorioConsulta direccionRepositorioConsulta) {
        this.direccionRepositorioConsulta = direccionRepositorioConsulta;
    }

    public DireccionDTO ejecutar(String nombre) {
        return validarSiExisteDireccion(nombre);
    }

    private DireccionDTO validarSiExisteDireccion(String nombre) {
        var direccion = direccionRepositorioConsulta.consultarPorNombreDTO(nombre);
        if (esNulo(direccion)) {
            throw new ValorInvalidoExcepcion(DIRECCION_NO_ENCONTRADA_CON_NOMBRE + nombre);
        }
        return direccion;
    }
}