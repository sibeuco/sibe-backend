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
@Table(name = "indicador")
public class IndicadorEntidad {
    @Id
    @Column(name = "identificador", nullable = false, updatable = false)
    private UUID identificador;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_indicador", referencedColumnName = "identificador")
    private IndicadorTipoIndicadorEntidad tipoIndicador;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "temporalidad", referencedColumnName = "identificador")
    private IndicadorTemporalidadEntidad temporalidad;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "proyecto", referencedColumnName = "identificador")
    private IndicadorProyectoEntidad proyecto;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "publico_interes", referencedColumnName = "identificador")
    private IndicadorPublicoInteresEntidad publicoInteres;
}
