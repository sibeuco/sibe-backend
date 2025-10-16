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
@Table(name = "identificacion")
public class IdentificacionEntidad {
    @Id
    private UUID identificador;

    @Column(name = "numero_identificacion", length = 12, nullable = false)
    private String numeroIdentificacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_identificacion")
    private IdentificacionTipoIdentificacionEntidad tipoIdentificacion;
}
