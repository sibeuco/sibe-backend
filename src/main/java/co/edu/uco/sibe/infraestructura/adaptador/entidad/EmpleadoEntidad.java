package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TABLA_EMPLEADO)
@PrimaryKeyJoinColumn(name = CAMPO_IDENTIFICADOR)
public class EmpleadoEntidad extends InternoEntidad {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = CAMPO_RELACION_LABORAL, nullable = false)
    private EmpleadoRelacionLaboralEntidad relacionLaboral;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = CAMPO_CENTRO_COSTOS, nullable = false)
    private EmpleadoCentroCostosEntidad centroCostos;
}