package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estudiante")
@PrimaryKeyJoinColumn(name = "identificador")
public class EstudianteEntidad extends InternoEntidad {
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "nacionalidad", nullable = false, length = 50)
    private String nacionalidad;

    @Column(name = "estado_civil", nullable = false, length = 15)
    private String estadoCivil;

    @Column(name = "correo_personal", nullable = false, length = 100)
    private String correoPersonal;

    @Column(name = "correo_institucional", nullable = false, length = 100)
    private String correoInstitucional;

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