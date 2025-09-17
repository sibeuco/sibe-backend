package co.edu.uco.sibe.dominio.modelo;

import java.time.LocalDate;
import java.util.UUID;

public class Estudiante extends Interno {
    private LocalDate fechaNacimiento;
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
            String direccion,
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
            String tiempoLlegadaUniversidad,
            String medioTransporte
    ) {
        super(identificador, nombreCompleto, numeroIdentificacion, ciudadResidencia, idCarnet, sexo);
        setFechaNacimiento(fechaNacimiento);
        setNacionalidad(nacionalidad);
        setEstadoCivil(estadoCivil);
        setDireccion(direccion);
        setCorreoPersonal(correoPersonal);
        setCorreoInstitucional(correoInstitucional);
        setProgramaAcademico(programaAcademico);
        setFacultad(facultad);
        setAnnoIngreso(annoIngreso);
        setSemestreActual(semestreActual);
        setCreditosAprobados(creditosAprobados);
        setPromedioGeneral(promedioGeneral);
        setEstadoAcademico(estadoAcademico);
        setModalidadEstudio(modalidadEstudio);
        setTiempoLlegadaUniversidad(tiempoLlegadaUniversidad);
        setMedioTransporte(medioTransporte);
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
            String direccion,
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
            String tiempoLlegadaUniversidad,
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
                direccion,
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public String getFacultad() {
        return facultad;
    }

    public int getAnnoIngreso() {
        return annoIngreso;
    }

    public String getSemestreActual() {
        return semestreActual;
    }

    public int getCreditosAprobados() {
        return creditosAprobados;
    }

    public float getPromedioGeneral() {
        return promedioGeneral;
    }

    public String getEstadoAcademico() {
        return estadoAcademico;
    }

    public String getModalidadEstudio() {
        return modalidadEstudio;
    }

    public String getTiempoLlegadaUniversidad() {
        return tiempoLlegadaUniversidad;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    private void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    private void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    private void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    private void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    private void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    private void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    private void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    private void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    private void setAnnoIngreso(int annoIngreso) {
        this.annoIngreso = annoIngreso;
    }

    private void setSemestreActual(String semestreActual) {
        this.semestreActual = semestreActual;
    }

    private void setCreditosAprobados(int creditosAprobados) {
        this.creditosAprobados = creditosAprobados;
    }

    private void setPromedioGeneral(float promedioGeneral) {
        this.promedioGeneral = promedioGeneral;
    }

    private void setEstadoAcademico(String estadoAcademico) {
        this.estadoAcademico = estadoAcademico;
    }

    private void setModalidadEstudio(String modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio;
    }

    private void setTiempoLlegadaUniversidad(String tiempoLlegadaUniversidad) {
        this.tiempoLlegadaUniversidad = tiempoLlegadaUniversidad;
    }

    private void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }
}