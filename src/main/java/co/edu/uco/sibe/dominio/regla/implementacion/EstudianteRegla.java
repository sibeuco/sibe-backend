package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Estudiante;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
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
        ValidadorObjeto.validarObligatorio(identificador, "");
    }

    @Override
    public void validarCampos(Estudiante modelo) {
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

    private void validarNacionalidad(String nacionalidad) {
        ValidadorTexto.validarObligatorio(nacionalidad, Mensajes.NACIONALIDAD_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(nacionalidad, Mensajes.NACIONALIDAD_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(nacionalidad.length(), 4, 50, Mensajes.LONGITUD_NACIONALIDAD_ESTUDIANTE_INVALIDA);
    }

    private void validarEstadoCivil(String estadoCivil) {
        ValidadorTexto.validarObligatorio(estadoCivil, Mensajes.ESTADO_CIVIL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoCivil, Mensajes.ESTADO_CIVIL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoCivil.length(), 5, 15, Mensajes.LONGITUD_ESTADO_CIVIL_ESTUDIANTE_INVALIDA);
    }

    private void validarCorreoPersonal(String correoPersonal) {
        ValidadorTexto.validarObligatorio(correoPersonal, Mensajes.CORREO_PERSONAL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarCorreoValido(correoPersonal, Mensajes.CORREO_PERSONAL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(correoPersonal.length(), 10, 100, Mensajes.LONGITUD_CORREO_PERSONAL_ESTUDIANTE_INVALIDA);
    }

    private void validarCorreoInstitucional(String correoInstitucional) {
        ValidadorTexto.validarObligatorio(correoInstitucional, Mensajes.CORREO_INSTITUCIONAL_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarCorreoValido(correoInstitucional, Mensajes.CORREO_INSTITUCIONAL_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(correoInstitucional.length(), 10, 100, Mensajes.LONGITUD_CORREO_INSTITUCIONAL_ESTUDIANTE_INVALIDA);
    }

    private void validarProgramaAcademico(String programaAcademico) {
        ValidadorTexto.validarObligatorio(programaAcademico, Mensajes.PROGRAMA_ACADEMICO_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(programaAcademico, Mensajes.PROGRAMA_ACADEMICO_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(programaAcademico.length(), 5, 100, Mensajes.LONGITUD_PROGRAMA_ACADEMICO_ESTUDIANTE_INVALIDA);
    }

    private void validarFacultad(String facultad) {
        ValidadorTexto.validarObligatorio(facultad, Mensajes.FACULTAD_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(facultad, Mensajes.FACULTAD_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(facultad.length(), 5, 50, Mensajes.LONGITUD_FACULTAD_ESTUDIANTE_INVALIDA);
    }

    private void validarAnnoIngreso(int annoIngreso) {
        ValidadorNumero.validarNumeroMayorOIgual(annoIngreso, 2000, "");
    }

    private void validarSemestreActual(String semestreActual) {
        ValidadorTexto.validarObligatorio(semestreActual, "");
        ValidadorTexto.validarTextoValido(semestreActual, "");
        ValidadorNumero.validarNumeroEntre(semestreActual.length(), 5, 5, Mensajes.ANNO_INGRESO_ESTUDIANTE_INVALIDO);
    }

    private void validarCreditosAprobados(int creditosAprobados) {
        ValidadorNumero.validarNumeroMayorOIgual(creditosAprobados, 0, Mensajes.CREDITOS_APROBADOS_ESTUDIANTE_INVALIDOS);
    }

    private void validarPromedioGeneral(float promedioGeneral) {
        ValidadorNumero.validarNumeroMayorOIgual(promedioGeneral, 0.0, Mensajes.PROMEDIO_GENERAL_ESTUDIANTE_INVALIDO);
    }

    private void validarEstadoAcademico(String estadoAcademico) {
        ValidadorTexto.validarObligatorio(estadoAcademico, Mensajes.ESTADO_ACADEMICO_ESTUDIANTE_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(estadoAcademico, Mensajes.ESTADO_ACADEMICO_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(estadoAcademico.length(), 6, 10, Mensajes.LONGITUD_ESTADO_ACADEMICO_ESTUDIANTE_INVALIDA);
    }

    private void validarModalidadEstudio(String modalidadEstudio) {
        ValidadorTexto.validarObligatorio(modalidadEstudio, Mensajes.MODALIDAD_ESTUDIO_ESTUDIANTE_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(modalidadEstudio, Mensajes.MODALIDAD_ESTUDIO_ESTUDIANTE_INVALIDA);
        ValidadorNumero.validarNumeroEntre(modalidadEstudio.length(), 5, 50, Mensajes.LONGITUD_MODALIDAD_ESTUDIO_ESTUDIANTE_INVALIDA);
    }

    private void validarTiempoLlegadaUniversidad(int tiempoLlegadaUniversidad) {
        ValidadorNumero.validarNumeroMayorOIgual(tiempoLlegadaUniversidad, 1, Mensajes.TIEMPO_LLEGADA_ESTUDIANTE_INVALIDO);
    }

    private void validarMedioTransporte(String medioTransporte) {
        ValidadorTexto.validarTextoValido(medioTransporte, Mensajes.MEDIO_TRANSPORTE_ESTUDIANTE_INVALIDO);
        ValidadorNumero.validarNumeroEntre(medioTransporte.length(), 5, 30, Mensajes.LONGITUD_MEDIO_TRANSPORTE_ESTUDIANTE_INVALIDA);
    }
}