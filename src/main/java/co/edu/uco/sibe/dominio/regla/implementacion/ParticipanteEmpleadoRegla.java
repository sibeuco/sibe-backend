package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.ParticipanteEmpleado;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class ParticipanteEmpleadoRegla implements Regla<ParticipanteEmpleado> {
    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, "");
    }

    @Override
    public void validarCampos(ParticipanteEmpleado modelo) {
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
