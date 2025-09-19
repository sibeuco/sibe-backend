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

    @Column(length = 100, nullable = false)
    private String correo;

    @Column(length = 255, nullable = false)
    private String clave;

    @Column(name = "esta_activo", nullable = false)
    private boolean estaActivo;
}
