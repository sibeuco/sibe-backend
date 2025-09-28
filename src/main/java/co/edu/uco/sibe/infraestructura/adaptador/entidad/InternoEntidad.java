package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "interno")
@PrimaryKeyJoinColumn(name = "identificador")
public class InternoEntidad extends MiembroEntidad {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ciudad_residencia", nullable = false)
    private InternoCiudadResidenciaEntidad ciudadResidencia;

    @Column(name = "id_carnet", nullable = false, length = 20)
    private String idCarnet;

    @Column(name = "sexo", nullable = false, length = 1)
    private String sexo;
}
