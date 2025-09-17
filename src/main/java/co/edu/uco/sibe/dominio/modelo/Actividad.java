package co.edu.uco.sibe.dominio.modelo;

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
        this.nombre = nombre;
    }

    private void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    private void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    private void setRutaInsumos(String rutaInsumos) {
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