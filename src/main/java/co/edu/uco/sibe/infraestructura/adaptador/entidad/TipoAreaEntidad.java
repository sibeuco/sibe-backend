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
@Table(name = "tipo_area")
public class TipoAreaEntidad {
    @Id
    private UUID identificador;

    @Column(length = 25, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private boolean gestionable;

    @Column(nullable = false)
    private int nivel;
}
