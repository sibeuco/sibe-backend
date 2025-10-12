package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.ParticipanteInterno;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;

public final class ParticipanteInternoRegla implements Regla<ParticipanteInterno> {
    private static final ParticipanteInternoRegla INSTANCIA = new ParticipanteInternoRegla();

    private ParticipanteInternoRegla() {
        super();
    }

    public static ParticipanteInternoRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, Mensajes.IDENTIFICADOR_PARTICIPANTE_INTERNO_NULO);
    }

    @Override
    public void validarCampos(ParticipanteInterno modelo) {
        validarIdCarnet(modelo.getIdCarnet());
        validarSexo(modelo.getSexo());
    }

    private void validarIdCarnet(String idCarnet) {
        ValidadorTexto.validarObligatorio(idCarnet, Mensajes.ID_CARNET_INTERNO_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(idCarnet, Mensajes.ID_CARNET_INTERNO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(idCarnet.length(), 1, 20, Mensajes.LONGITUD_ID_CARNET_INTERNO_INVALIDA);
    }

    private void validarSexo(String sexo) {
        ValidadorTexto.validarObligatorio(sexo, Mensajes.SEXO_PARTICIPANTE_INTERNO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(sexo, Mensajes.SEXO_PARTICIPANTE_INTERNO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(sexo.length(), 1, 1, Mensajes.LONGITUD_SEXO_PARTICIPANTE_INTERNO_INVALIDA);
    }
}