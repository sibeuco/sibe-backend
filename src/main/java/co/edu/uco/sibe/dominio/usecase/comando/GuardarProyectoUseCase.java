package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Proyecto;
import co.edu.uco.sibe.dominio.puerto.comando.ProyectoRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.ProyectoRepositorioConsulta;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorDuplicadoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.NUMERO_PROYECTO_EXISTENTE;

public class GuardarProyectoUseCase {
    private final ProyectoRepositorioComando proyectoRepositorioComando;
    private final ProyectoRepositorioConsulta proyectoRepositorioConsulta;

    public GuardarProyectoUseCase(ProyectoRepositorioComando proyectoRepositorioComando, ProyectoRepositorioConsulta proyectoRepositorioConsulta) {
        this.proyectoRepositorioComando = proyectoRepositorioComando;
        this.proyectoRepositorioConsulta = proyectoRepositorioConsulta;
    }

    public UUID ejecutar(Proyecto proyecto){
        MotoresFabrica.MOTOR_PROYECTO.ejecutar(proyecto, TipoOperacion.CREAR);

        validarNoExisteProyectoCoNumero(proyecto.getNumeroProyecto());

        return this.proyectoRepositorioComando.guardar(proyecto);
    }

    private void validarNoExisteProyectoCoNumero(String numeroProyecto) {
        if (!ValidadorObjeto.esNulo(this.proyectoRepositorioConsulta.consultarPorNumeroProyecto(numeroProyecto))){
            throw new ValorDuplicadoExcepcion(NUMERO_PROYECTO_EXISTENTE);
        }
    }
}