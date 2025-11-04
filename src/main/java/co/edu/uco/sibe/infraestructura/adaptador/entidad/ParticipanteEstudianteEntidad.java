package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static co.edu.uco.sibe.dominio.transversal.constante.PersistenciaConstante.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = PARTICIPANTE_ESTUDIANTE)
@PrimaryKeyJoinColumn(name = CAMPO_IDENTIFICADOR)
public class ParticipanteEstudianteEntidad extends ParticipanteInternoEntidad {
    @Column(name = ESTADO_CIVIL, nullable = false, length = 15)
    private String estadoCivil;

    @Column(name = PROGRAMA_ACADEMICO, nullable = false, length = 100)
    private String programaAcademico;

    @Column(name = FACULTAD, nullable = false, length = 50)
    private String facultad;

    @Column(name = ANNO_INGRESO, nullable = false)
    private int annoIngreso;

    @Column(name = SEMESTRE_ACTUAL, nullable = false, length = 5)
    private String semestreActual;

    @Column(name = CREDITOS_APROBADOS, nullable = false)
    private int creditosAprobados;

    @Column(name = PROMEDIO_GENERAL, nullable = false)
    private float promedioGeneral;

    @Column(name = ESTADO_ACADEMICO, nullable = false, length = 10)
    private String estadoAcademico;

    @Column(name = MODALIDAD_ESTUDIO, nullable = false, length = 50)
    private String modalidadEstudio;

    @Column(name = TIEMPO_LLEGADA_UNIVERSIDAD, nullable = false)
    private int tiempoLlegadaUniversidad;

    @Column(name = MEDIO_TRANSPORTE, nullable = false, length = 30)
    private String medioTransporte;
}