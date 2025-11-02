package co.edu.uco.sibe.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {
    private String fechaNacimiento;
    private String nacionalidad;
    private String estadoCivil;
    private String direccion;
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
    private String tiempoLlegadaUniversidad;
    private String medioTransporte;
}