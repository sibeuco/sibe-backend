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
@Table(name = "indicador_tipo_indicador")
public class IndicadorTipoIndicadorEntidad {
    @Id
    @Column(name = "identificador", nullable = false, updatable = false)
    private UUID identificador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_indicador", nullable = false)
    private TipoIndicadorEntidad tipoIndicador;
}

