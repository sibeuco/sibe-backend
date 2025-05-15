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
@Table(name = "proyecto")
public class ProyectoEntidad {
    @Id
    private UUID identificador;

    @Column(name = "numero_proyecto", length = 20, nullable = false, unique = true)
    private String numeroProyecto;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 750, nullable = false)
    private String objetivo;
}
