package co.edu.uco.sibe.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClaveModificacionComando {
    private UUID usuario;
    private String claveAntigua;
    private String claveNueva;
    private String confirmacionClaveNueva;
}