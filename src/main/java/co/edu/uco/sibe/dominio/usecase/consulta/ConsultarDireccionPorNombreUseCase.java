package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.modelo.Direccion;
import co.edu.uco.sibe.dominio.puerto.consulta.DireccionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

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
        if (ValidadorObjeto.esNulo(this.direccionRepositorioConsulta.consultarPorNombre(nombre))) {
            throw new ValorInvalidoExcepcion(UtilMensaje.consultarPorNombre(nombre));
        }
    }
}