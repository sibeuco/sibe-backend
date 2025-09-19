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
@Table(name = "tipo_identificacion")
public class TipoIdentificacionEntidad {
    @Id
    private UUID identificador;

    @Column(length = 3, nullable = false)
    private String sigla;

    @Column(length = 30, nullable = false)
    private String descripcion;
}