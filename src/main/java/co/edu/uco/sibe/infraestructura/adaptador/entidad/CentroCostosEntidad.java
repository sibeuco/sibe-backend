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
@Table(name = "centro_costos")
public class CentroCostosEntidad {
    @Id
    private UUID identificador;

    @Column(length = 100, nullable = false)
    private String codigo;

    @Column(length = 100, nullable = false)
    private String descripcion;
}
