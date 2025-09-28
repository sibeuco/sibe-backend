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
@Table(name = "participante_interno")
@PrimaryKeyJoinColumn(name = "identificador")
public class ParticipanteInternoEntidad extends ParticipanteEntidad {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ciudad_residencia", nullable = false)
    private InternoCiudadResidenciaEntidad ciudadResidencia;

    @Column(name = "id_carnet", nullable = false, length = 20)
    private String idCarnet;

    @Column(name = "sexo", nullable = false, length = 1)
    private String sexo;
}
