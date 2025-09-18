package co.edu.uco.sibe.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioOrganizacionDTO {
    private UUID identificador;
    private UsuarioDTO usuario;
    private DireccionDTO direccion;
    private AreaDTO area;
    private SubareaDTO subarea;
}