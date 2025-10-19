package co.edu.uco.sibe.dominio.puerto.comando;

import co.edu.uco.sibe.dominio.modelo.Area;
import java.util.UUID;

public interface AreaRepositorioComando {
    UUID guardar(Area area);
}