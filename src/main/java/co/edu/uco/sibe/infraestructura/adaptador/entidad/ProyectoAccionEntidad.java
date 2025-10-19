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
@Table(name = "proyecto_accion")
public class ProyectoAccionEntidad {
    @Id
    @Column(name = "identificador", updatable = false)
    private UUID identificador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accion", nullable = false)
    private AccionEntidad accion;
}

