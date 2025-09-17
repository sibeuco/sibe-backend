package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class ParticipanteEstudiante extends ParticipanteInterno {
    private String estadoCivil;
    private String direccion;
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

    private ParticipanteEstudiante(
            UUID identificador,
            Miembro miembro,
            CiudadResidencia ciudadResidencia,
            String idCarnet,
            String sexo,
            String estadoCivil,
            String direccion,
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
        super(identificador, miembro, ciudadResidencia, idCarnet, sexo);
        setEstadoCivil(estadoCivil);
        setDireccion(direccion);
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

    public static ParticipanteEstudiante construir(
            UUID identificador,
            Miembro miembro,
            CiudadResidencia ciudadResidencia,
            String idCarnet,
            String sexo,
            String estadoCivil,
            String direccion,
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
        return new ParticipanteEstudiante(
                identificador,
                miembro,
                ciudadResidencia,
                idCarnet,
                sexo,
                estadoCivil,
                direccion,
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getDireccion() {
        return direccion;
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

    private void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    private void setDireccion(String direccion) {
        this.direccion = direccion;
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