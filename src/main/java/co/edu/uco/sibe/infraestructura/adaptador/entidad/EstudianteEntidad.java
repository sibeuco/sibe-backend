package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "estudiante")
public class EstudianteEntidad {
    @Id
    private UUID identificador;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(length = 30, nullable = false)
    private String nacionalidad;

    @Column(name = "estado_civil", length = 30, nullable = false)
    private String estadoCivil;

    @Column(length = 30, nullable = false)
    private String direccion;

    @Column(name = "correo_personal", length = 30, nullable = false)
    private String correoPersonal;

    @Column(name = "correo_institucional", length = 30, nullable = false)
    private String correoInstitucional;

    @Column(name = "programa_academico", length = 30, nullable = false)
    private String programaAcademico;

    @Column(length = 30, nullable = false)
    private String facultad;

    @Column(name = "anno_ingreso", length = 30, nullable = false)
    private String annoIngreso;

    @Column(name = "semestre_actual", length = 30, nullable = false)
    private String semestreActual;

    @Column(name = "creditos_aprobados", nullable = false)
    private int creditosAprobados;

    @Column(name = "promedio_general", precision = 10, scale = 2, nullable = false)
    private BigDecimal promedioGeneral;

    @Column(name = "estado_academico", length = 30, nullable = false)
    private String estadoAcademico;

    @Column(name = "modalidad_estudio", length = 30, nullable = false)
    private String modalidadEstudio;

    @Column(name = "tiempo_llegada_universidad", length = 30, nullable = false)
    private String tiempoLlegadaUniversidad;

    @Column(name = "medio_transporte", length = 30, nullable = false)
    private String medioTransporte;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "interno", nullable = false)
    private InternoEntidad interno;
}