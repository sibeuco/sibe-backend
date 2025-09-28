package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "participante_estudiante")
@PrimaryKeyJoinColumn(name = "identificador")
public class ParticipanteEstudianteEntidad extends ParticipanteInternoEntidad {
    @Column(name = "estado_civil", nullable = false, length = 15)
    private String estadoCivil;

    @Column(name = "programa_academico", nullable = false, length = 100)
    private String programaAcademico;

    @Column(name = "facultad", nullable = false, length = 50)
    private String facultad;

    @Column(name = "anno_ingreso", nullable = false)
    private int annoIngreso;

    @Column(name = "semestre_actual", nullable = false, length = 5)
    private String semestreActual;

    @Column(name = "creditos_aprobados", nullable = false)
    private int creditosAprobados;

    @Column(name = "promedio_general", nullable = false)
    private float promedioGeneral;

    @Column(name = "estado_academico", nullable = false, length = 10)
    private String estadoAcademico;

    @Column(name = "modalidad_estudio", nullable = false, length = 50)
    private String modalidadEstudio;

    @Column(name = "tiempo_llegada_universidad", nullable = false)
    private int tiempoLlegadaUniversidad;

    @Column(name = "medio_transporte", nullable = false, length = 30)
    private String medioTransporte;
}