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

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_identificacion", nullable = false)
    private TipoIdentificacionEntidad tipoIdentificacion;

    @Column(length = 12, nullable = false)
    private String documento;

    @Column(name = "primer_nombre", length = 20, nullable = false)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 20)
    private String segundoNombre;

    @Column(name = "primer_apellido", length = 20, nullable = false)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 20)
    private String segundoApellido;

    @Column(length = 40, nullable = false)
    private String correo;
}
