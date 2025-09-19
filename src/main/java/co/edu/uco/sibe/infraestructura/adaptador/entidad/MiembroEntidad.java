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
@Table(name = "miembro")
public class MiembroEntidad {
    @Id
    private UUID identificador;

    @Column(name = "nombre_completo", length = 30, nullable = false)
    private String nombreCompleto;

    @Column(name = "numero_identificacion", length = 30, nullable = false)
    private String numeroIdentificacion;

    @Column(name = "es_interno", nullable = false)
    private boolean esInterno;

    @Column(name = "es_externo", nullable = false)
    private boolean esExterno;
}