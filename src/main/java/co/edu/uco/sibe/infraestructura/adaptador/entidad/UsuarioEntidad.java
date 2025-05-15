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
@Table(name = "usuario")
public class UsuarioEntidad {
    @Id
    private UUID identificador;

    @Column(length = 40, nullable = false)
    private String correo;

    @Column(length = 20, nullable = false)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario", nullable = false)
    private TipoUsuarioEntidad tipoUsuario;

    @Column(name = "esta_activo", nullable = false)
    private boolean estaActivo;

    @ManyToOne
    @JoinColumn(name = "area_o_direccion", nullable = false)
    private AreaEntidad area;

    @ManyToOne
    @JoinColumn(name = "persona", nullable = false)
    private PersonaEntidad persona;

}
