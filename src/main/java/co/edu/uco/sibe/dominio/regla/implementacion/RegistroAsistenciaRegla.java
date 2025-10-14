package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.RegistroAsistencia;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

import java.util.UUID;

public class RegistroAsistenciaRegla implements Regla<RegistroAsistencia> {
    private static final RegistroAsistenciaRegla INSTANCIA = new RegistroAsistenciaRegla();

    private RegistroAsistenciaRegla() {
        super();
    }

    public static RegistroAsistenciaRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, Mensajes.IDENTIFICADOR_REGISTRO_ASISTENCIA_NULO);
    }

    @Override
    public void validarCampos(RegistroAsistencia modelo) {
        throw new IllegalStateException(Mensajes.NO_HAY_CAMPOS_POR_VALIDAR);
    }
}
