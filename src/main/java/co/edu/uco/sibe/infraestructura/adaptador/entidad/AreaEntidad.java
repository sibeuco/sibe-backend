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
@Table(name = "area")
public class AreaEntidad {
    @Id
    private UUID identificador;

    @Column(length = 50, nullable = false)
    private String nombreArea;

    @ManyToOne
    @JoinColumn(name = "tipo_area", nullable = false)
    private TipoAreaEntidad tipoArea;

    @ManyToOne
    @JoinColumn(name = "area_padre", nullable = false)
    private AreaEntidad areaPadre;

}
