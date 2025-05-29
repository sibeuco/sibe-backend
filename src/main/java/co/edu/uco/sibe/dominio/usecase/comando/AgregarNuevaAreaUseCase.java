package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.dominio.puerto.comando.AreaRepositorioComando;

import java.util.UUID;

public class AgregarNuevaAreaUseCase {

    private final AreaRepositorioComando areaRepositorioComando;


    public AgregarNuevaAreaUseCase(AreaRepositorioComando areaRepositorioComando) {
        this.areaRepositorioComando = areaRepositorioComando;
    }

    public UUID ejecutar(Area area){
        return this.areaRepositorioComando.agregarNuevaArea(area);
    }

}
