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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion")
    private DireccionEntidad direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area")
    private AreaEntidad area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subarea")
    private SubareaEntidad subarea;
}