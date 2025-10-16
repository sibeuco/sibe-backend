package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "peticion_recuperacion_clave")
public class PeticionRecuperacionClaveEntidad {
    @Id
    private UUID id;

    @Column(length = 50, nullable = false)
    private String codigo;

    @Column(length = 100, nullable = false)
    private String correo;

    private LocalDateTime fecha;
}
