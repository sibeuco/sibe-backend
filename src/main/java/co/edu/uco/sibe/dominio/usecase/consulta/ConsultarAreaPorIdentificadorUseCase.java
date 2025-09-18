package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

import java.util.UUID;

public class ConsultarAreaPorIdentificadorUseCase {

    private final AreaRepositorioConsulta areaRepositorioConsulta;

    public ConsultarAreaPorIdentificadorUseCase(AreaRepositorioConsulta areaRepositorioConsulta) {
        this.areaRepositorioConsulta = areaRepositorioConsulta;
    }

    public AreaDTO ejecutar(UUID identificador){
        validarSiNoExisteAreaConId(identificador);

        return this.areaRepositorioConsulta.consultarAreaPorIdentificador(identificador);

    }

    private void validarSiNoExisteAreaConId(UUID identificador) {
        if (ValidadorObjeto.getInstance().esNulo(this.areaRepositorioConsulta.consultarAreaPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExisteAreaConId(identificador));
        }
    }

}
