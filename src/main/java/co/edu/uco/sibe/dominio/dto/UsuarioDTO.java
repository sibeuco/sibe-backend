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
public class UsuarioDTO {
    private String identificador;
    private String nombres;
    private String apellidos;
    private String correo;
    private IdentificacionDTO identificacion;
    private TipoUsuarioDTO tipoUsuario;
    private Boolean estaActivo;
}