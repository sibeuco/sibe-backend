package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.ParticipanteEstudiante;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;

public final class ParticipanteEstudianteRegla implements Regla<ParticipanteEstudiante> {
    private static final ParticipanteEstudianteRegla INSTANCIA = new ParticipanteEstudianteRegla();

    private ParticipanteEstudianteRegla() {
        super();
    }

    public static ParticipanteEstudianteRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, UtilMensaje.IDENTIFICADOR_PARTICIPANTE_ESTUDIANTE_NULO);
    }

    @Override
    public void validarCampos(ParticipanteEstudiante modelo) {
        validarIdCarnet(modelo.getIdCarnet());
        validarSexo(modelo.getSexo());
        validarEstadoCivil(modelo.getEstadoCivil());
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

    private void validarIdCarnet(String idCarnet) {
        ValidadorTexto.validarObligatorio(idCarnet, UtilMensaje.ID_CARNET_INTERNO_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(idCarnet, UtilMensaje.ID_CARNET_INTERNO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(idCarnet.length(), 1, 20, UtilMensaje.LONGITUD_ID_CARNET_INTERNO_INVALIDA);
    }

    private void validarSexo(String sexo) {
        ValidadorTexto.validarObligatorio(sexo, UtilMensaje.SEXO_PARTICIPANTE_INTERNO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(sexo, UtilMensaje.SEXO_PARTICIPANTE_INTERNO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(sexo.length(), 1, 1, UtilMensaje.LONGITUD_SEXO_PARTICIPANTE_INTERNO_INVALIDA);
    }

    private void validarEstadoCivil(String estadoCivil) {
        ValidadorTexto.validarObligatorio(estadoCivil, UtilMensaje.ESTADO_CIVIL_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoCivil, UtilMensaje.ESTADO_CIVIL_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoCivil.length(), 5, 15, UtilMensaje.LONGITUD_ESTADO_CIVIL_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }

    private void validarProgramaAcademico(String programaAcademico) {
        ValidadorTexto.validarObligatorio(programaAcademico, UtilMensaje.PROGRAMA_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(programaAcademico, UtilMensaje.PROGRAMA_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(programaAcademico.length(), 5, 100, UtilMensaje.LONGITUD_PROGRAMA_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }

    private void validarFacultad(String facultad) {
        ValidadorTexto.validarObligatorio(facultad, UtilMensaje.FACULTAD_PARTICPANTE_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(facultad, UtilMensaje.FACULTAD_PARTICIPANTE_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(facultad.length(), 5, 50, UtilMensaje.LONGITUD_FACULTAD_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }

    private void validarAnnoIngreso(int annoIngreso) {
        ValidadorNumero.validarNumeroMayorOIgual(annoIngreso, 2000, UtilMensaje.ANNO_INGRESO_PARTICIPANTE_ESTUDIANTE_INVALIDO);
    }

    private void validarSemestreActual(String semestreActual) {
        ValidadorTexto.validarObligatorio(semestreActual, UtilMensaje.SEMESTRE_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(semestreActual, UtilMensaje.SEMESTRE_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(semestreActual.length(), 5, 5, UtilMensaje.LONGITUD_SEMESTRE_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }

    private void validarCreditosAprobados(int creditosAprobados) {
        ValidadorNumero.validarNumeroMayorOIgual(creditosAprobados, 0, UtilMensaje.CREDITOS_APROBADOS_PARTICIPANTE_ESTUDIANTE_INVALIDOS);
    }

    private void validarPromedioGeneral(float promedioGeneral) {
        ValidadorNumero.validarNumeroMayorOIgual(promedioGeneral, 0.0, UtilMensaje.PROMEDIO_GENERAL_PARTICIPANTE_ESTUDIANTE_INVALIDO);
    }

    private void validarEstadoAcademico(String estadoAcademico) {
        ValidadorTexto.validarObligatorio(estadoAcademico, UtilMensaje.ESTADO_ACADEMICO_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoAcademico, UtilMensaje.ESTADO_ACADEMICO_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoAcademico.length(), 6, 10, UtilMensaje.LONGITUD_ESTADO_ACADEMICO_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }

    private void validarModalidadEstudio(String modalidadEstudio) {
        ValidadorTexto.validarObligatorio(modalidadEstudio, UtilMensaje.MODALIDAD_ESTUDIO_PARTICIPANTE_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(modalidadEstudio, UtilMensaje.MODALIDAD_ESTUDIO_PARTICIPANTE_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(modalidadEstudio.length(), 5, 50, UtilMensaje.LONGITUD_MODALIDAD_ESTUDIO_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }

    private void validarTiempoLlegadaUniversidad(int tiempoLlegadaUniversidad) {
        ValidadorNumero.validarNumeroMayorOIgual(tiempoLlegadaUniversidad, 1, UtilMensaje.TIEMPO_LLEGADA_PARTICIPANTE_ESTUDIANTE_INVALIDO);
    }

    private void validarMedioTransporte(String medioTransporte) {
        //ValidadorTexto.validarObligatorio(medioTransporte, "");
        ValidadorTexto.validarTextoValido(medioTransporte, UtilMensaje.MEDIO_TRANSPORTE_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(medioTransporte.length(), 5, 30, UtilMensaje.LONGITUD_MEDIO_TRANSPORTE_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }
}