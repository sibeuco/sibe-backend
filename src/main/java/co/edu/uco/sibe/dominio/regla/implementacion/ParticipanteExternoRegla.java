package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.ParticipanteExterno;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.IDENTIFICADOR_PARTICIPANTE_EXTERNO_NULO;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.NO_HAY_CAMPOS_POR_VALIDAR;

public class ParticipanteExternoRegla implements Regla<ParticipanteExterno> {
    private static final ParticipanteExternoRegla INSTANCIA = new ParticipanteExternoRegla();

    private ParticipanteExternoRegla() {
        super();
    }

    public static ParticipanteExternoRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_PARTICIPANTE_EXTERNO_NULO);
    }

    @Override
    public void validarCampos(ParticipanteExterno modelo) {
        throw new IllegalStateException(NO_HAY_CAMPOS_POR_VALIDAR);
    }
}
