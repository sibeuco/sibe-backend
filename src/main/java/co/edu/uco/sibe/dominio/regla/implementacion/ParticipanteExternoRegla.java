package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.ParticipanteExterno;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

import java.util.UUID;

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
        ValidadorObjeto.validarObligatorio(identificador, Mensajes.IDENTIFICADOR_PARTICIPANTE_EXTERNO_NULO);
    }

    @Override
    public void validarCampos(ParticipanteExterno modelo) {
        throw new IllegalStateException(Mensajes.NO_HAY_CAMPOS_POR_VALIDAR);
    }
}
