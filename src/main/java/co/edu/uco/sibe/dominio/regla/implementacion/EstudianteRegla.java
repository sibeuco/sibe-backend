package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Estudiante;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

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
        ValidadorObjeto.validarObligatorio(identificador, UtilMensaje.IDENTIFICADOR_ESTUDIANTE_NULO);
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
        ValidadorTexto.validarObligatorio(nombreCompleto, UtilMensaje.NOMBRE_COMPLETO_MIEMBRO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombreCompleto, UtilMensaje.NOMBRE_COMPLETO_MIEMBRO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombreCompleto.length(), 5, 100, UtilMensaje.LONGITUD_NOMBRE_COMPLETO_MIEMBRO_INVALIDA);
    }

    private void validarNumeroIdentificacion(String numeroIdentificacion) {
        ValidadorTexto.validarObligatorio(numeroIdentificacion, UtilMensaje.NUMERO_IDENTIFICACION_MIEMBRO_OBLIGATORIO);
        ValidadorTexto.validarNumeroIdentificacionValido(numeroIdentificacion, UtilMensaje.NUMERO_IDENTIFICACION_MIEMBRO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(numeroIdentificacion.length(), 6, 12, UtilMensaje.LONGITUD_NUMERO_IDENTIFICACION_MIEMBRO_INVALIDA);
    }

    private void validarIdCarnet(String idCarnet) {
        ValidadorTexto.validarObligatorio(idCarnet, UtilMensaje.ID_CARNET_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(idCarnet, UtilMensaje.ID_CARNET_INVALIDO);
        ValidadorNumero.validarNumeroEntre(idCarnet.length(), 1, 20, UtilMensaje.LONGITUD_ID_CARNET_INVALIDA);
    }

    private void validarSexo(String sexo) {
        ValidadorTexto.validarObligatorio(sexo, UtilMensaje.SEXO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(sexo, UtilMensaje.SEXO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(sexo.length(), 1, 1, UtilMensaje.LONGITUD_SEXO_INVALIDA);
    }

    private void validarNacionalidad(String nacionalidad) {
        ValidadorTexto.validarObligatorio(nacionalidad, UtilMensaje.NACIONALIDAD_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(nacionalidad, UtilMensaje.NACIONALIDAD_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(nacionalidad.length(), 4, 50, UtilMensaje.LONGITUD_NACIONALIDAD_ESTUDIANTE_INVALIDA);
    }

    private void validarEstadoCivil(String estadoCivil) {
        ValidadorTexto.validarObligatorio(estadoCivil, UtilMensaje.ESTADO_CIVIL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoCivil, UtilMensaje.ESTADO_CIVIL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoCivil.length(), 5, 15, UtilMensaje.LONGITUD_ESTADO_CIVIL_ESTUDIANTE_INVALIDA);
    }

    private void validarCorreoPersonal(String correoPersonal) {
        ValidadorTexto.validarObligatorio(correoPersonal, UtilMensaje.CORREO_PERSONAL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarCorreoValido(correoPersonal, UtilMensaje.CORREO_PERSONAL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(correoPersonal.length(), 10, 100, UtilMensaje.LONGITUD_CORREO_PERSONAL_ESTUDIANTE_INVALIDA);
    }

    private void validarCorreoInstitucional(String correoInstitucional) {
        ValidadorTexto.validarObligatorio(correoInstitucional, UtilMensaje.CORREO_INSTITUCIONAL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarCorreoValido(correoInstitucional, UtilMensaje.CORREO_INSTITUCIONAL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(correoInstitucional.length(), 10, 100, UtilMensaje.LONGITUD_CORREO_INSTITUCIONAL_ESTUDIANTE_INVALIDA);
    }

    private void validarProgramaAcademico(String programaAcademico) {
        ValidadorTexto.validarObligatorio(programaAcademico, UtilMensaje.PROGRAMA_ACADEMICO_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(programaAcademico, UtilMensaje.PROGRAMA_ACADEMICO_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(programaAcademico.length(), 5, 100, UtilMensaje.LONGITUD_PROGRAMA_ACADEMICO_ESTUDIANTE_INVALIDA);
    }

    private void validarFacultad(String facultad) {
        ValidadorTexto.validarObligatorio(facultad, UtilMensaje.FACULTAD_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(facultad, UtilMensaje.FACULTAD_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(facultad.length(), 5, 50, UtilMensaje.LONGITUD_FACULTAD_ESTUDIANTE_INVALIDA);
    }

    private void validarAnnoIngreso(int annoIngreso) {
        ValidadorNumero.validarNumeroMayorOIgual(annoIngreso, 2000, "");
    }

    private void validarSemestreActual(String semestreActual) {
        ValidadorTexto.validarObligatorio(semestreActual, "");
        ValidadorTexto.validarTextoValido(semestreActual, "");
        ValidadorNumero.validarNumeroEntre(semestreActual.length(), 5, 5, UtilMensaje.ANNO_INGRESO_ESTUDIANTE_INVALIDO);
    }

    private void validarCreditosAprobados(int creditosAprobados) {
        ValidadorNumero.validarNumeroMayorOIgual(creditosAprobados, 0, UtilMensaje.CREDITOS_APROBADOS_ESTUDIANTE_INVALIDOS);
    }

    private void validarPromedioGeneral(float promedioGeneral) {
        ValidadorNumero.validarNumeroMayorOIgual(promedioGeneral, 0.0, UtilMensaje.PROMEDIO_GENERAL_ESTUDIANTE_INVALIDO);
    }

    private void validarEstadoAcademico(String estadoAcademico) {
        ValidadorTexto.validarObligatorio(estadoAcademico, UtilMensaje.ESTADO_ACADEMICO_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoAcademico, UtilMensaje.ESTADO_ACADEMICO_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoAcademico.length(), 6, 10, UtilMensaje.LONGITUD_ESTADO_ACADEMICO_ESTUDIANTE_INVALIDA);
    }

    private void validarModalidadEstudio(String modalidadEstudio) {
        ValidadorTexto.validarObligatorio(modalidadEstudio, UtilMensaje.MODALIDAD_ESTUDIO_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(modalidadEstudio, UtilMensaje.MODALIDAD_ESTUDIO_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(modalidadEstudio.length(), 5, 50, UtilMensaje.LONGITUD_MODALIDAD_ESTUDIO_ESTUDIANTE_INVALIDA);
    }

    private void validarTiempoLlegadaUniversidad(int tiempoLlegadaUniversidad) {
        ValidadorNumero.validarNumeroMayorOIgual(tiempoLlegadaUniversidad, 1, UtilMensaje.TIEMPO_LLEGADA_ESTUDIANTE_INVALIDO);
    }

    private void validarMedioTransporte(String medioTransporte) {
        ValidadorTexto.validarTextoValido(medioTransporte, UtilMensaje.MEDIO_TRANSPORTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(medioTransporte.length(), 5, 30, UtilMensaje.LONGITUD_MEDIO_TRANSPORTE_ESTUDIANTE_INVALIDA);
    }
}