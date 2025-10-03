package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import javax.swing.*;
import java.beans.XMLEncoder;
import java.time.LocalDate;
import java.util.UUID;

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
        setFechaNacimiento(fechaNacimiento);
        setNacionalidad(nacionalidad);
        setEstadoCivil(estadoCivil);
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
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

    public int getTiempoLlegadaUniversidad() {
        return tiempoLlegadaUniversidad;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    private void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    private void setNacionalidad(String nacionalidad) {
        ValidadorTexto.validarObligatorio(nacionalidad, Mensajes.NACIONALIDAD_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(nacionalidad, Mensajes.NACIONALIDAD_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(nacionalidad.length(), 4, 50, Mensajes.LONGITUD_NACIONALIDAD_ESTUDIANTE_INVALIDA);

        this.nacionalidad = nacionalidad;
    }

    private void setEstadoCivil(String estadoCivil) {
        ValidadorTexto.validarObligatorio(estadoCivil, Mensajes.ESTADO_CIVIL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoCivil, Mensajes.ESTADO_CIVIL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoCivil.length(), 5, 15, Mensajes.LONGITUD_ESTADO_CIVIL_ESTUDIANTE_INVALIDA);

        this.estadoCivil = estadoCivil;
    }

    private void setCorreoPersonal(String correoPersonal) {
        ValidadorTexto.validarObligatorio(correoPersonal, Mensajes.CORREO_PERSONAL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarCorreoValido(correoPersonal, Mensajes.CORREO_PERSONAL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(correoPersonal.length(), 10, 100, Mensajes.LONGITUD_CORREO_PERSONAL_ESTUDIANTE_INVALIDA);

        this.correoPersonal = correoPersonal;
    }

    private void setCorreoInstitucional(String correoInstitucional) {
        ValidadorTexto.validarObligatorio(correoInstitucional, Mensajes.CORREO_INSTITUCIONAL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarCorreoValido(correoInstitucional, Mensajes.CORREO_INSTITUCIONAL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(correoInstitucional.length(), 10, 100, Mensajes.LONGITUD_CORREO_INSTITUCIONAL_ESTUDIANTE_INVALIDA);

        this.correoInstitucional = correoInstitucional;
    }

    private void setProgramaAcademico(String programaAcademico) {
        ValidadorTexto.validarObligatorio(programaAcademico, Mensajes.PROGRAMA_ACADEMICO_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(programaAcademico, Mensajes.PROGRAMA_ACADEMICO_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(programaAcademico.length(), 5, 100, Mensajes.LONGITUD_PROGRAMA_ACADEMICO_ESTUDIANTE_INVALIDA);

        this.programaAcademico = programaAcademico;
    }

    private void setFacultad(String facultad) {
        ValidadorTexto.validarObligatorio(facultad, Mensajes.FACULTAD_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(facultad, Mensajes.FACULTAD_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(facultad.length(), 5, 50, Mensajes.LONGITUD_FACULTAD_ESTUDIANTE_INVALIDA);

        this.facultad = facultad;
    }

    private void setAnnoIngreso(int annoIngreso) {
        ValidadorNumero.validarNumeroMayorOIgual(annoIngreso, 2000, "");

        this.annoIngreso = annoIngreso;
    }

    private void setSemestreActual(String semestreActual) {
        ValidadorTexto.validarObligatorio(semestreActual, "");
        ValidadorTexto.validarTextoValido(semestreActual, "");
        ValidadorNumero.validarNumeroEntre(semestreActual.length(), 5, 5, Mensajes.ANNO_INGRESO_ESTUDIANTE_INVALIDO);

        this.semestreActual = semestreActual;
    }

    private void setCreditosAprobados(int creditosAprobados) {
        ValidadorNumero.validarNumeroMayorOIgual(creditosAprobados, 0, Mensajes.CREDITOS_APROBADOS_ESTUDIANTE_INVALIDOS);

        this.creditosAprobados = creditosAprobados;
    }

    private void setPromedioGeneral(float promedioGeneral) {
        ValidadorNumero.validarNumeroMayorOIgual(promedioGeneral, 0.0, Mensajes.PROMEDIO_GENERAL_ESTUDIANTE_INVALIDO);

        this.promedioGeneral = promedioGeneral;
    }

    private void setEstadoAcademico(String estadoAcademico) {
        ValidadorTexto.validarObligatorio(estadoAcademico, Mensajes.ESTADO_ACADEMICO_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoAcademico, Mensajes.ESTADO_ACADEMICO_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoAcademico.length(), 6, 10, Mensajes.LONGITUD_ESTADO_ACADEMICO_ESTUDIANTE_INVALIDA);

        this.estadoAcademico = estadoAcademico;
    }

    private void setModalidadEstudio(String modalidadEstudio) {
        ValidadorTexto.validarObligatorio(modalidadEstudio, Mensajes.MODALIDAD_ESTUDIO_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(modalidadEstudio, Mensajes.MODALIDAD_ESTUDIO_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(modalidadEstudio.length(), 5, 50, Mensajes.LONGITUD_MODALIDAD_ESTUDIO_ESTUDIANTE_INVALIDA);

        this.modalidadEstudio = modalidadEstudio;
    }

    private void setTiempoLlegadaUniversidad(int tiempoLlegadaUniversidad) {
        ValidadorNumero.validarNumeroMayorOIgual(tiempoLlegadaUniversidad, 1, Mensajes.TIEMPO_LLEGADA_ESTUDIANTE_INVALIDO);

        this.tiempoLlegadaUniversidad = tiempoLlegadaUniversidad;
    }

    private void setMedioTransporte(String medioTransporte) {
        ValidadorTexto.validarTextoValido(medioTransporte, Mensajes.MEDIO_TRANSPORTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(medioTransporte.length(), 5, 30, Mensajes.LONGITUD_MEDIO_TRANSPORTE_ESTUDIANTE_INVALIDA);

        this.medioTransporte = medioTransporte;
    }
}