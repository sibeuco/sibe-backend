package co.edu.uco.sibe.aplicacion.comando;

import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaComando {
    private UUID tipoIdentificacion;
    private String documento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

}
