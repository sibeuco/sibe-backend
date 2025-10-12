package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Interno;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public final class InternoRegla implements Regla<Interno> {
    private static final InternoRegla INSTANCIA = new InternoRegla();

    private InternoRegla() {
        super();
    }

    public static InternoRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, Mensajes.IDENTIFICADOR_INTERNO_NULO);
    }

    @Override
    public void validarCampos(Interno modelo) {
        validarIdCarnet(modelo.getIdCarnet());
        validarSexo(modelo.getSexo());
    }

    private void validarIdCarnet(String idCarnet) {
        ValidadorTexto.validarObligatorio(idCarnet, Mensajes.ID_CARNET_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(idCarnet, Mensajes.ID_CARNET_INVALIDO);
        ValidadorNumero.validarNumeroEntre(idCarnet.length(), 1, 20, Mensajes.LONGITUD_ID_CARNET_INVALIDA);
    }

    private void validarSexo(String sexo) {
        ValidadorTexto.validarObligatorio(sexo, Mensajes.SEXO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(sexo, Mensajes.SEXO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(sexo.length(), 1, 1, Mensajes.LONGITUD_SEXO_INVALIDA);
    }
}