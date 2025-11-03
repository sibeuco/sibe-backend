package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.ParticipanteEmpleado;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public class ParticipanteEmpleadoRegla implements Regla<ParticipanteEmpleado> {
    private static final ParticipanteEmpleadoRegla INSTANCIA = new ParticipanteEmpleadoRegla();

    private ParticipanteEmpleadoRegla() {
        super();
    }

    public static ParticipanteEmpleadoRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_PARTICIPANTE_EMPLEADO_NULO);
    }

    @Override
    public void validarCampos(ParticipanteEmpleado modelo) {
        validarIdCarnet(modelo.getIdCarnet());
        validarSexo(modelo.getSexo());
    }

    private void validarIdCarnet(String idCarnet) {
        ValidadorTexto.validarObligatorio(idCarnet, ID_CARNET_INTERNO_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(idCarnet, ID_CARNET_INTERNO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(idCarnet.length(), 1, 20, LONGITUD_ID_CARNET_INTERNO_INVALIDA);
    }

    private void validarSexo(String sexo) {
        ValidadorTexto.validarObligatorio(sexo, SEXO_PARTICIPANTE_INTERNO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(sexo, SEXO_PARTICIPANTE_INTERNO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(sexo.length(), 1, 1, LONGITUD_SEXO_PARTICIPANTE_INTERNO_INVALIDA);
    }
}