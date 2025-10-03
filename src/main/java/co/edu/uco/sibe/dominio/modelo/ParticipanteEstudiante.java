package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class ParticipanteEstudiante extends ParticipanteInterno {
    private String estadoCivil;
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

    private ParticipanteEstudiante(
            UUID identificador,
            Miembro miembro,
            CiudadResidencia ciudadResidencia,
            String idCarnet,
            String sexo,
            String estadoCivil,
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
        super(identificador, miembro, ciudadResidencia, idCarnet, sexo);
        setEstadoCivil(estadoCivil);
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
        return new ParticipanteEstudiante(
                identificador,
                miembro,
                ciudadResidencia,
                idCarnet,
                sexo,
                estadoCivil,
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

    public int getTiempoLlegadaUniversidad() {
        return tiempoLlegadaUniversidad;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    private void setEstadoCivil(String estadoCivil) {
        ValidadorTexto.validarObligatorio(estadoCivil, Mensajes.ESTADO_CIVIL_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoCivil, Mensajes.ESTADO_CIVIL_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoCivil.length(), 5, 15, Mensajes.LONGITUD_ESTADO_CIVIL_PARTICIPANTE_ESTUDIANTE_INVALIDA);

        this.estadoCivil = estadoCivil;
    }

    private void setProgramaAcademico(String programaAcademico) {
        ValidadorTexto.validarObligatorio(programaAcademico, Mensajes.PROGRAMA_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(programaAcademico, Mensajes.PROGRAMA_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(programaAcademico.length(), 5, 100, Mensajes.LONGITUD_PROGRAMA_PARTICIPANTE_ESTUDIANTE_INVALIDA);

        this.programaAcademico = programaAcademico;
    }

    private void setFacultad(String facultad) {
        ValidadorTexto.validarObligatorio(facultad, Mensajes.FACULTAD_PARTICPANTE_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(facultad, Mensajes.FACULTAD_PARTICIPANTE_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(facultad.length(), 5, 50, Mensajes.LONGITUD_FACULTAD_PARTICIPANTE_ESTUDIANTE_INVALIDA);

        this.facultad = facultad;
    }

    private void setAnnoIngreso(int annoIngreso) {
        ValidadorNumero.validarNumeroMayorOIgual(annoIngreso, 2000, Mensajes.ANNO_INGRESO_PARTICIPANTE_ESTUDIANTE_INVALIDO);

        this.annoIngreso = annoIngreso;
    }

    private void setSemestreActual(String semestreActual) {
        ValidadorTexto.validarObligatorio(semestreActual, Mensajes.SEMESTRE_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(semestreActual, Mensajes.SEMESTRE_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(semestreActual.length(), 5, 5, Mensajes.LONGITUD_SEMESTRE_PARTICIPANTE_ESTUDIANTE_INVALIDA);

        this.semestreActual = semestreActual;
    }

    private void setCreditosAprobados(int creditosAprobados) {
        ValidadorNumero.validarNumeroMayorOIgual(creditosAprobados, 0, Mensajes.CREDITOS_APROBADOS_PARTICIPANTE_ESTUDIANTE_INVALIDOS);

        this.creditosAprobados = creditosAprobados;
    }

    private void setPromedioGeneral(float promedioGeneral) {
        ValidadorNumero.validarNumeroMayorOIgual(promedioGeneral, 0.0, Mensajes.PROMEDIO_GENERAL_PARTICIPANTE_ESTUDIANTE_INVALIDO);

        this.promedioGeneral = promedioGeneral;
    }

    private void setEstadoAcademico(String estadoAcademico) {
        ValidadorTexto.validarObligatorio(estadoAcademico, Mensajes.ESTADO_ACADEMICO_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoAcademico, Mensajes.ESTADO_ACADEMICO_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoAcademico.length(), 6, 10, Mensajes.LONGITUD_ESTADO_ACADEMICO_PARTICIPANTE_ESTUDIANTE_INVALIDA);

        this.estadoAcademico = estadoAcademico;
    }

    private void setModalidadEstudio(String modalidadEstudio) {
        ValidadorTexto.validarObligatorio(modalidadEstudio, Mensajes.MODALIDAD_ESTUDIO_PARTICIPANTE_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(modalidadEstudio, Mensajes.MODALIDAD_ESTUDIO_PARTICIPANTE_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(modalidadEstudio.length(), 5, 50, Mensajes.LONGITUD_MODALIDAD_ESTUDIO_PARTICIPANTE_ESTUDIANTE_INVALIDA);

        this.modalidadEstudio = modalidadEstudio;
    }

    private void setTiempoLlegadaUniversidad(int tiempoLlegadaUniversidad) {
        ValidadorNumero.validarNumeroMayorOIgual(tiempoLlegadaUniversidad, 1, Mensajes.TIEMPO_LLEGADA_PARTICIPANTE_ESTUDIANTE_INVALIDO);

        this.tiempoLlegadaUniversidad = tiempoLlegadaUniversidad;
    }

    private void setMedioTransporte(String medioTransporte) {
        //ValidadorTexto.validarObligatorio(medioTransporte, "");
        ValidadorTexto.validarTextoValido(medioTransporte, Mensajes.MEDIO_TRANSPORTE_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(medioTransporte.length(), 5, 30, Mensajes.LONGITUD_MEDIO_TRANSPORTE_PARTICIPANTE_ESTUDIANTE_INVALIDA);

        this.medioTransporte = medioTransporte;
    }
}