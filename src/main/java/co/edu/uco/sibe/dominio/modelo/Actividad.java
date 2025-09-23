package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;

public class Actividad {
    private UUID identificador;
    private String nombre;
    private String objetivo;
    private String semestre;
    private String rutaInsumos;
    private Indicador indicador;
    private UUID colaborador;
    private UUID creador;

    private Actividad(
            UUID identificador,
            String nombre,
            String objetivo,
            String semestre,
            String rutaInsumos,
            Indicador indicador,
            UUID colaborador,
            UUID creador
    ) {
        setIdentificador(identificador);
        setNombre(nombre);
        setObjetivo(objetivo);
        setSemestre(semestre);
        setRutaInsumos(rutaInsumos);
        setIndicador(indicador);
        setColaborador(colaborador);
        setCreador(creador);
    }

    public static Actividad construir(
            UUID identificador,
            String nombre,
            String objetivo,
            String semestre,
            String rutaInsumos,
            Indicador indicador,
            UUID colaborador,
            UUID creador
    ) {
        return new Actividad(identificador, nombre, objetivo, semestre, rutaInsumos, indicador, colaborador, creador);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getRutaInsumos() {
        return rutaInsumos;
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public UUID getColaborador() {
        return colaborador;
    }

    public UUID getCreador() {
        return creador;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, "");
        ValidadorTexto.validarTextoValido(nombre, "");
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 200, "");

        this.nombre = nombre;
    }

    private void setObjetivo(String objetivo) {
        ValidadorTexto.validarObligatorio(objetivo, "");
        ValidadorTexto.validarTextoValido(objetivo, "");
        ValidadorNumero.validarNumeroEntre(objetivo.length(), 10, 500, "");

        this.objetivo = objetivo;
    }

    private void setSemestre(String semestre) {
        ValidadorTexto.validarObligatorio(semestre, "");
        ValidadorTexto.validarTextoValido(semestre, "");
        ValidadorNumero.validarNumeroEntre(semestre.length(), 6, 6, "");

        this.semestre = semestre;
    }

    private void setRutaInsumos(String rutaInsumos) {
        ValidadorTexto.validarObligatorio(rutaInsumos, "");
        ValidadorTexto.validarTextoValido(rutaInsumos, "");
        ValidadorNumero.validarNumeroEntre(rutaInsumos.length(), 10, 3000, "");

        this.rutaInsumos = rutaInsumos;
    }

    private void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    private void setColaborador(UUID colaborador) {
        this.colaborador = colaborador;
    }

    private void setCreador(UUID creador) {
        this.creador = creador;
    }
}