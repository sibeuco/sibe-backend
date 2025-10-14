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
@Table(name = "usuario_organizacion")
public class UsuarioOrganizacionEntidad {
    @Id
    private UUID identificador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario", nullable = false)
    private UsuarioEntidad usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "direccion", nullable = false)
    private DireccionEntidad direccion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "area", nullable = false)
    private AreaEntidad area;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subarea", nullable = false)
    private SubareaEntidad subarea;
}
