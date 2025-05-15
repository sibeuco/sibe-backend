package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "indicador")
public class IndicadorEntidad {
        @Id
        private UUID identificador;

        @Column(length = 40, nullable = false)
        private String nombre;

        @ManyToOne(optional = false)
        @JoinColumn(name = "tipo_indicador", nullable = false)
        private TipoIndicadorEntidad tipoIndicador;

        @ManyToOne(optional = false)
        @JoinColumn(name = "temporalidad", nullable = false)
        private TemporalidadEntidad temporalidad;

        @ManyToOne(optional = false)
        @JoinColumn(name = "proyecto", nullable = false)
        private ProyectoEntidad proyecto;

        @ManyToOne(optional = false)
        @JoinColumn(name = "publico_interes", nullable = false)
        private PublicoInteresEntidad publicoInteres;
}
