package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.ParticipanteEstudiante;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
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
        ValidadorObjeto.validarObligatorio(identificador, "");
    }

    @Override
    public void validarCampos(ParticipanteEstudiante modelo) {
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

    private void validarEstadoCivil(String estadoCivil) {
        ValidadorTexto.validarObligatorio(estadoCivil, Mensajes.ESTADO_CIVIL_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoCivil, Mensajes.ESTADO_CIVIL_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoCivil.length(), 5, 15, Mensajes.LONGITUD_ESTADO_CIVIL_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }

    private void validarProgramaAcademico(String programaAcademico) {
        ValidadorTexto.validarObligatorio(programaAcademico, Mensajes.PROGRAMA_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(programaAcademico, Mensajes.PROGRAMA_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(programaAcademico.length(), 5, 100, Mensajes.LONGITUD_PROGRAMA_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }

    private void validarFacultad(String facultad) {
        ValidadorTexto.validarObligatorio(facultad, Mensajes.FACULTAD_PARTICPANTE_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(facultad, Mensajes.FACULTAD_PARTICIPANTE_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(facultad.length(), 5, 50, Mensajes.LONGITUD_FACULTAD_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }

    private void validarAnnoIngreso(int annoIngreso) {
        ValidadorNumero.validarNumeroMayorOIgual(annoIngreso, 2000, Mensajes.ANNO_INGRESO_PARTICIPANTE_ESTUDIANTE_INVALIDO);
    }

    private void validarSemestreActual(String semestreActual) {
        ValidadorTexto.validarObligatorio(semestreActual, Mensajes.SEMESTRE_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(semestreActual, Mensajes.SEMESTRE_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(semestreActual.length(), 5, 5, Mensajes.LONGITUD_SEMESTRE_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }

    private void validarCreditosAprobados(int creditosAprobados) {
        ValidadorNumero.validarNumeroMayorOIgual(creditosAprobados, 0, Mensajes.CREDITOS_APROBADOS_PARTICIPANTE_ESTUDIANTE_INVALIDOS);
    }

    private void validarPromedioGeneral(float promedioGeneral) {
        ValidadorNumero.validarNumeroMayorOIgual(promedioGeneral, 0.0, Mensajes.PROMEDIO_GENERAL_PARTICIPANTE_ESTUDIANTE_INVALIDO);
    }

    private void validarEstadoAcademico(String estadoAcademico) {
        ValidadorTexto.validarObligatorio(estadoAcademico, Mensajes.ESTADO_ACADEMICO_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoAcademico, Mensajes.ESTADO_ACADEMICO_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoAcademico.length(), 6, 10, Mensajes.LONGITUD_ESTADO_ACADEMICO_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }

    private void validarModalidadEstudio(String modalidadEstudio) {
        ValidadorTexto.validarObligatorio(modalidadEstudio, Mensajes.MODALIDAD_ESTUDIO_PARTICIPANTE_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(modalidadEstudio, Mensajes.MODALIDAD_ESTUDIO_PARTICIPANTE_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(modalidadEstudio.length(), 5, 50, Mensajes.LONGITUD_MODALIDAD_ESTUDIO_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }

    private void validarTiempoLlegadaUniversidad(int tiempoLlegadaUniversidad) {
        ValidadorNumero.validarNumeroMayorOIgual(tiempoLlegadaUniversidad, 1, Mensajes.TIEMPO_LLEGADA_PARTICIPANTE_ESTUDIANTE_INVALIDO);
    }

    private void validarMedioTransporte(String medioTransporte) {
        //ValidadorTexto.validarObligatorio(medioTransporte, "");
        ValidadorTexto.validarTextoValido(medioTransporte, Mensajes.MEDIO_TRANSPORTE_PARTICIPANTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(medioTransporte.length(), 5, 30, Mensajes.LONGITUD_MEDIO_TRANSPORTE_PARTICIPANTE_ESTUDIANTE_INVALIDA);
    }
}