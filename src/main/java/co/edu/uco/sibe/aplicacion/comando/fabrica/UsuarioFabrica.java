package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoUsuarioRepositorioConsulta;

public class UsuarioFabrica {

    private final TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta;
    private final AreaRepositorioConsulta areaRepositorioConsulta;

    public UsuarioFabrica(TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta, AreaRepositorioConsulta areaRepositorioConsulta) {
        this.tipoUsuarioRepositorioConsulta = tipoUsuarioRepositorioConsulta;
        this.areaRepositorioConsulta = areaRepositorioConsulta;
    }

    public Usuario construir(UsuarioComando usuario){

        return Usuario.construir();

    }
}
