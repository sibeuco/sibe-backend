package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Estudiante;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public final class EstudianteRegla implements Regla<Estudiante> {
    private static final EstudianteRegla INSTANCIA = new EstudianteRegla();

    private EstudianteRegla() {
        super();
    }

    public static EstudianteRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_ESTUDIANTE_NULO);
    }

    @Override
    public void validarCampos(Estudiante modelo) {
        validarNombreCompleto(modelo.getNombreCompleto());
        validarNumeroIdentificacion(modelo.getNumeroIdentificacion());
        validarIdCarnet(modelo.getIdCarnet());
        validarSexo(modelo.getSexo());
        validarNacionalidad(modelo.getNacionalidad());
        validarEstadoCivil(modelo.getEstadoCivil());
        validarCorreoPersonal(modelo.getCorreoPersonal());
        validarCorreoInstitucional(modelo.getCorreoInstitucional());
        validarProgramaAcademico(modelo.getProgramaAcademico());
        validarFacultad(modelo.getFacultad());
        validarAnnoIngreso(modelo.getAnnoIngreso());
        validarSemestreActual(modelo.getSemestreActual());
        validarCreditosAprobados(modelo.getCreditosAprobados());
        validarPromedioGeneral(modelo.getPromedioGeneral());
        validarEstadoAcademico(modelo.getEstadoAcademico());
        validarModalidadEstudio(modelo.getModalidadEstudio());
        validarTiempoLlegadaUniversidad(modelo.getTiempoLlegadaUniversidad());
        validarMedioTransporte(modelo.getMedioTransporte());
    }

    private void validarNombreCompleto(String nombreCompleto) {
        ValidadorTexto.validarObligatorio(nombreCompleto, NOMBRE_COMPLETO_MIEMBRO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombreCompleto, NOMBRE_COMPLETO_MIEMBRO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombreCompleto.length(), 5, 100, LONGITUD_NOMBRE_COMPLETO_MIEMBRO_INVALIDA);
    }

    private void validarNumeroIdentificacion(String numeroIdentificacion) {
        ValidadorTexto.validarObligatorio(numeroIdentificacion, NUMERO_IDENTIFICACION_MIEMBRO_OBLIGATORIO);
        ValidadorTexto.validarNumeroIdentificacionValido(numeroIdentificacion, NUMERO_IDENTIFICACION_MIEMBRO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(numeroIdentificacion.length(), 6, 12, LONGITUD_NUMERO_IDENTIFICACION_MIEMBRO_INVALIDA);
    }

    private void validarIdCarnet(String idCarnet) {
        ValidadorTexto.validarObligatorio(idCarnet, ID_CARNET_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(idCarnet, ID_CARNET_INVALIDO);
        ValidadorNumero.validarNumeroEntre(idCarnet.length(), 1, 20, LONGITUD_ID_CARNET_INVALIDA);
    }

    private void validarSexo(String sexo) {
        ValidadorTexto.validarObligatorio(sexo, SEXO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(sexo, SEXO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(sexo.length(), 1, 1, LONGITUD_SEXO_INVALIDA);
    }

    private void validarNacionalidad(String nacionalidad) {
        ValidadorTexto.validarObligatorio(nacionalidad, NACIONALIDAD_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(nacionalidad, NACIONALIDAD_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(nacionalidad.length(), 4, 50, LONGITUD_NACIONALIDAD_ESTUDIANTE_INVALIDA);
    }

    private void validarEstadoCivil(String estadoCivil) {
        ValidadorTexto.validarObligatorio(estadoCivil, ESTADO_CIVIL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoCivil, ESTADO_CIVIL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoCivil.length(), 5, 15, LONGITUD_ESTADO_CIVIL_ESTUDIANTE_INVALIDA);
    }

    private void validarCorreoPersonal(String correoPersonal) {
        ValidadorTexto.validarObligatorio(correoPersonal, CORREO_PERSONAL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarCorreoValido(correoPersonal, CORREO_PERSONAL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(correoPersonal.length(), 10, 100, LONGITUD_CORREO_PERSONAL_ESTUDIANTE_INVALIDA);
    }

    private void validarCorreoInstitucional(String correoInstitucional) {
        ValidadorTexto.validarObligatorio(correoInstitucional, CORREO_INSTITUCIONAL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarCorreoValido(correoInstitucional, CORREO_INSTITUCIONAL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(correoInstitucional.length(), 10, 100, LONGITUD_CORREO_INSTITUCIONAL_ESTUDIANTE_INVALIDA);
    }

    private void validarProgramaAcademico(String programaAcademico) {
        ValidadorTexto.validarObligatorio(programaAcademico, PROGRAMA_ACADEMICO_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(programaAcademico, PROGRAMA_ACADEMICO_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(programaAcademico.length(), 5, 100, LONGITUD_PROGRAMA_ACADEMICO_ESTUDIANTE_INVALIDA);
    }

    private void validarFacultad(String facultad) {
        ValidadorTexto.validarObligatorio(facultad, FACULTAD_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(facultad, FACULTAD_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(facultad.length(), 5, 50, LONGITUD_FACULTAD_ESTUDIANTE_INVALIDA);
    }

    private void validarAnnoIngreso(int annoIngreso) {
        ValidadorNumero.validarNumeroMayorOIgual(annoIngreso, 2000, ANNO_INGRESO_ESTUDIANTE_INVALIDO);
    }

    private void validarSemestreActual(String semestreActual) {
        ValidadorTexto.validarObligatorio(semestreActual, SEMESTRE_ACTUAL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(semestreActual, SEMESTRE_ACTUAL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(semestreActual.length(), 5, 5, LONGITUD_SEMESTRE_ACTUAL_ESTUDIANTE_INVALIDA);
    }

    private void validarCreditosAprobados(int creditosAprobados) {
        ValidadorNumero.validarNumeroMayorOIgual(creditosAprobados, 0, CREDITOS_APROBADOS_ESTUDIANTE_INVALIDOS);
    }

    private void validarPromedioGeneral(float promedioGeneral) {
        ValidadorNumero.validarNumeroMayorOIgual(promedioGeneral, 0.0, PROMEDIO_GENERAL_ESTUDIANTE_INVALIDO);
    }

    private void validarEstadoAcademico(String estadoAcademico) {
        ValidadorTexto.validarObligatorio(estadoAcademico, ESTADO_ACADEMICO_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoAcademico, ESTADO_ACADEMICO_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoAcademico.length(), 6, 10, LONGITUD_ESTADO_ACADEMICO_ESTUDIANTE_INVALIDA);
    }

    private void validarModalidadEstudio(String modalidadEstudio) {
        ValidadorTexto.validarObligatorio(modalidadEstudio, MODALIDAD_ESTUDIO_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(modalidadEstudio, MODALIDAD_ESTUDIO_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(modalidadEstudio.length(), 5, 50, LONGITUD_MODALIDAD_ESTUDIO_ESTUDIANTE_INVALIDA);
    }

    private void validarTiempoLlegadaUniversidad(int tiempoLlegadaUniversidad) {
        ValidadorNumero.validarNumeroMayorOIgual(tiempoLlegadaUniversidad, 1, TIEMPO_LLEGADA_ESTUDIANTE_INVALIDO);
    }

    private void validarMedioTransporte(String medioTransporte) {
        ValidadorTexto.validarTextoValido(medioTransporte, MEDIO_TRANSPORTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(medioTransporte.length(), 0, 30, LONGITUD_MEDIO_TRANSPORTE_ESTUDIANTE_INVALIDA);
    }
}