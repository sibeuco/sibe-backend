package co.edu.uco.sibe.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CierreActividadComando {
    private List<UUID> miembros;
    private String horaFin;
    private String fechaRealizacion;
    private UUID ejecucionActividad;
}