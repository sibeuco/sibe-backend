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
@Table(name = "identificacion_tipo_identificacion")
public class IdentificacionTipoIdentificacionEntidad {
    @Id
    private UUID identificador;

    @ManyToOne
    @JoinColumn(name = "tipo_identificacion", nullable = false)
    private TipoIdentificacionEntidad tipoIdentificacion;
}
