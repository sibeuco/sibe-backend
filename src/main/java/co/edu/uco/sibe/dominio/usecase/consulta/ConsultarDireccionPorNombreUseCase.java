package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.modelo.Direccion;
import co.edu.uco.sibe.dominio.puerto.consulta.DireccionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.consultarPorNombre;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarDireccionPorNombreUseCase {
    private final DireccionRepositorioConsulta direccionRepositorioConsulta;

    public ConsultarDireccionPorNombreUseCase(DireccionRepositorioConsulta direccionRepositorioConsulta) {
        this.direccionRepositorioConsulta = direccionRepositorioConsulta;
    }

    public Direccion ejecutar(String nombre) {
        validarSiNoExisteDireccionConNombre(nombre);

        return this.direccionRepositorioConsulta.consultarPorNombre(nombre);
    }

    private void validarSiNoExisteDireccionConNombre(String nombre) {
        if (esNulo(this.direccionRepositorioConsulta.consultarPorNombre(nombre))) {
            throw new ValorInvalidoExcepcion(consultarPorNombre(nombre));
        }
    }
}