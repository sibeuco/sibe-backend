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

    @Column(length = 100, nullable = false)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario", nullable = false)
    private TipoUsuarioEntidad tipoUsuario;

    @Column(name = "esta_activo", nullable = false)
    private boolean estaActivo;

}
