package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class Estudiante extends Interno {
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String estadoCivil;
    private String correoPersonal;
    private String correoInstitucional;
    private String programaAcademico;
    private String facultad;
    private int annoIngreso;
    private String semestreActual;
    private int creditosAprobados;
    private float promedioGeneral;
    private String estadoAcademico;
    private String modalidadEstudio;
    private int tiempoLlegadaUniversidad;
    private String medioTransporte;

    private Estudiante(
            UUID identificador,
            String nombreCompleto,
            String numeroIdentificacion,
            CiudadResidencia ciudadResidencia,
            String idCarnet,
            String sexo,
            LocalDate fechaNacimiento,
            String nacionalidad,
            String estadoCivil,
            String correoPersonal,
            String correoInstitucional,
            String programaAcademico,
            String facultad,
            int annoIngreso,
            String semestreActual,
            int creditosAprobados,
            float promedioGeneral,
            String estadoAcademico,
            String modalidadEstudio,
            int tiempoLlegadaUniversidad,
            String medioTransporte
    ) {
        super(identificador, nombreCompleto, numeroIdentificacion, ciudadResidencia, idCarnet, sexo);
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.estadoCivil = estadoCivil;
        this.correoPersonal = correoPersonal;
        this.correoInstitucional = correoInstitucional;
        this.programaAcademico = programaAcademico;
        this.facultad = facultad;
        this.annoIngreso = annoIngreso;
        this.semestreActual = semestreActual;
        this.creditosAprobados = creditosAprobados;
        this.promedioGeneral = promedioGeneral;
        this.estadoAcademico = estadoAcademico;
        this.modalidadEstudio = modalidadEstudio;
        this.tiempoLlegadaUniversidad = tiempoLlegadaUniversidad;
        this.medioTransporte = medioTransporte;
    }

    public static Estudiante construir(
            UUID identificador,
            String nombreCompleto,
            String numeroIdentificacion,
            CiudadResidencia ciudadResidencia,
            String idCarnet,
            String sexo,
            LocalDate fechaNacimiento,
            String nacionalidad,
            String estadoCivil,
            String correoPersonal,
            String correoInstitucional,
            String programaAcademico,
            String facultad,
            int annoIngreso,
            String semestreActual,
            int creditosAprobados,
            float promedioGeneral,
            String estadoAcademico,
            String modalidadEstudio,
            int tiempoLlegadaUniversidad,
            String medioTransporte
    ) {
        return new Estudiante(
                identificador,
                nombreCompleto,
                numeroIdentificacion,
                ciudadResidencia,
                idCarnet,
                sexo,
                fechaNacimiento,
                nacionalidad,
                estadoCivil,
                correoPersonal,
                correoInstitucional,
                programaAcademico,
                facultad,
                annoIngreso,
                semestreActual,
                creditosAprobados,
                promedioGeneral,
                estadoAcademico,
                modalidadEstudio,
                tiempoLlegadaUniversidad,
                medioTransporte
        );
    }
}