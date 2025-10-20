package co.edu.uco.sibe.dominio.puerto.comando;

import co.edu.uco.sibe.dominio.modelo.Subarea;
import java.util.UUID;

public interface SubareaRepositorioComando {
    UUID guardar(Subarea subarea);
}