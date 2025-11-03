package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.*;
import lombok.Getter;
import java.time.LocalDate;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante.CERO;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;

@Getter
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
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.estadoCivil = estadoCivil;
        this.correoPersonal = correoPersonal;
        this.correoInstitucional = correoInstitucional;
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
                ValidadorTexto.obtenerValorPorDefecto(nombreCompleto),
                ValidadorTexto.obtenerValorPorDefecto(numeroIdentificacion),
                ValidadorObjeto.obtenerValorPorDefecto(ciudadResidencia, CiudadResidencia.construir()),
                ValidadorTexto.obtenerValorPorDefecto(idCarnet),
                ValidadorTexto.obtenerValorPorDefecto(sexo),
                UtilFecha.obtenerValorFechaPorDefecto(fechaNacimiento),
                ValidadorTexto.obtenerValorPorDefecto(nacionalidad),
                ValidadorTexto.obtenerValorPorDefecto(estadoCivil),
                ValidadorTexto.obtenerValorPorDefecto(correoPersonal),
                ValidadorTexto.obtenerValorPorDefecto(correoInstitucional),
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

    public static Estudiante construir() {
        return new Estudiante(
                UtilUUID.obtenerValorDefecto(),
                VACIO,
                VACIO,
                CiudadResidencia.construir(),
                VACIO,
                VACIO,
                UtilFecha.obtenerFechaDefecto(),
                VACIO,
                VACIO,
                VACIO,
                VACIO,
                VACIO,
                VACIO,
                CERO,
                VACIO,
                CERO,
                CERO,
                VACIO,
                VACIO,
                CERO,
                VACIO
        );
    }
}