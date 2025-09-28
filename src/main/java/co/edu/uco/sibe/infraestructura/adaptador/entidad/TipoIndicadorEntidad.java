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
@Table(name = "tipo_indicador")
public class TipoIndicadorEntidad {
    @Id
    private UUID identificador;

    @Column(length = 100, nullable = false)
    private String naturaleza;

    @Column(name = "tipologia_indicador", length = 100, nullable = false)
    private String tipologiaIndicador;
}