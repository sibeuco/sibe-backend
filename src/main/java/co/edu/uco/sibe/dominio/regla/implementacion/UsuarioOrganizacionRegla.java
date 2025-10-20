package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.UsuarioOrganizacion;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import java.util.UUID;

public class UsuarioOrganizacionRegla implements Regla<UsuarioOrganizacion> {
    private static final UsuarioOrganizacionRegla INSTANCIA = new UsuarioOrganizacionRegla();

    private UsuarioOrganizacionRegla() {
        super();
    }

    public static UsuarioOrganizacionRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, UtilMensaje.IDENTIFICADOR_USUARIO_ORGANIZACION_NULO);
    }

    @Override
    public void validarCampos(UsuarioOrganizacion modelo) {
        throw new IllegalStateException(UtilMensaje.NO_HAY_CAMPOS_POR_VALIDAR);
    }
}
