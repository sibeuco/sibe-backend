package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = CAMPO_INDICADOR)
public class IndicadorEntidad {
    @Id
    @Column(name = CAMPO_IDENTIFICADOR, nullable = false, updatable = false)
    private UUID identificador;

    @Column(name = CAMPO_NOMBRE, nullable = false, length = 100)
    private String nombre;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = TIPO_INDICADOR, referencedColumnName = CAMPO_IDENTIFICADOR)
    private IndicadorTipoIndicadorEntidad tipoIndicador;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = TEMPORALIDAD, referencedColumnName = CAMPO_IDENTIFICADOR)
    private IndicadorTemporalidadEntidad temporalidad;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = PROYECTO, referencedColumnName = CAMPO_IDENTIFICADOR)
    private IndicadorProyectoEntidad proyecto;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = PUBLICO_INTERES, referencedColumnName = CAMPO_IDENTIFICADOR)
    private IndicadorPublicoInteresEntidad publicoInteres;
}
