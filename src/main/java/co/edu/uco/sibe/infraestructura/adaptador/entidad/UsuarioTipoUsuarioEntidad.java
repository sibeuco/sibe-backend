package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import java.util.UUID;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario_tipo_usuario")
public class UsuarioTipoUsuarioEntidad {
    @Id
    private UUID identificador;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario")
    private TipoUsuarioEntidad tipoUsuario;
}