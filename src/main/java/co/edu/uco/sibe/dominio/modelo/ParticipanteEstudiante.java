package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante;
import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;
import java.util.UUID;

@Getter
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
        this.estadoCivil = estadoCivil;
        this.programaAcademico = programaAcademico;
        this.facultad = facultad;
        this.annoIngreso = annoIngreso;
        this.semestreActual = semestreActual;
        this.creditosAprobados = creditosAprobados;
        this.promedioGeneral = promedioGeneral;
        this.estadoAcademico = estadoAcademico;
        this.modalidadEstudio = modalidadEstudio;
        this.tiempoLlegadaUniversidad = tiempoLlegadaUniversidad;
        this.medioTransporte = medioTransporte;
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
                ValidadorObjeto.obtenerValorPorDefecto(miembro, Miembro.construir()),
                ValidadorObjeto.obtenerValorPorDefecto(ciudadResidencia, CiudadResidencia.construir()),
                ValidadorTexto.obtenerValorPorDefecto(idCarnet),
                ValidadorTexto.obtenerValorPorDefecto(sexo),
                ValidadorTexto.obtenerValorPorDefecto(estadoCivil),
                ValidadorTexto.obtenerValorPorDefecto(programaAcademico),
                ValidadorTexto.obtenerValorPorDefecto(facultad),
                ValidadorNumero.obtenerNumeroPorDefecto(annoIngreso),
                ValidadorTexto.obtenerValorPorDefecto(semestreActual),
                ValidadorNumero.obtenerNumeroPorDefecto(creditosAprobados),
                ValidadorNumero.obtenerNumeroPorDefecto(promedioGeneral),
                ValidadorTexto.obtenerValorPorDefecto(estadoAcademico),
                ValidadorTexto.obtenerValorPorDefecto(modalidadEstudio),
                ValidadorNumero.obtenerNumeroPorDefecto(tiempoLlegadaUniversidad),
                ValidadorTexto.obtenerValorPorDefecto(medioTransporte)
        );
    }

    public static ParticipanteEstudiante construir() {
        return new ParticipanteEstudiante(
                UtilUUID.obtenerValorDefecto(),
                Miembro.construir(),
                CiudadResidencia.construir(),
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                NumeroConstante.CERO,
                TextoConstante.VACIO,
                NumeroConstante.CERO,
                NumeroConstante.CERO,
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                NumeroConstante.CERO,
                TextoConstante.VACIO
        );
    }
}