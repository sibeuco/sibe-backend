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
@Table(name = "participante")
public class ParticipanteEntidad {
    @Id
    private UUID identificador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "miembro", nullable = false)
    private MiembroEntidad miembro;

    @Column(name = "es_participante_interno", nullable = false)
    private boolean esParticipanteInterno;

    @Column(name = "es_participante_externo", nullable = false)
    private boolean esParticipanteExterno;
}
