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
@Table(name = PARTICIPANTE_EMPLEADO)
@PrimaryKeyJoinColumn(name = CAMPO_IDENTIFICADOR)
public class ParticipanteEmpleadoEntidad extends ParticipanteInternoEntidad {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = RELACION_LABORAL, nullable = false)
    private EmpleadoRelacionLaboralEntidad relacionLaboral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = CAMPO_CENTRO_COSTOS, nullable = false)
    private EmpleadoCentroCostosEntidad centroCostos;
}
