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
@Table(name = "persona")
public class PersonaEntidad {
    @Id
    private UUID identificador;

    @Column(length = 50, nullable = false)
    private String nombres;

    @Column(length = 50, nullable = false)
    private String apellido;

    @Column(length = 100, nullable = false)
    private String correo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identificacion", nullable = false)
    private IdentificacionEntidad identificacion;
}
