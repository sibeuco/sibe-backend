package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.List;
import java.util.UUID;

public class Area {
    private UUID identificador;
    private String nombre;
    private List<Subarea> subareas;
    private List<Actividad> actividades;

    private Area(UUID identificador, String nombre, List<Subarea> subareas, List<Actividad> actividades) {
        setIdentificador(identificador);
        setNombre(nombre);
        setSubareas(subareas);
        setActividades(actividades);
    }

    public static Area construir(UUID identificador, String nombre, List<Subarea> subareas, List<Actividad> actividades) {
        return new Area(identificador, nombre, subareas, actividades);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Subarea> getSubareas() {
        return subareas;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, Mensajes.NOMBRE_AREA_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, Mensajes.NOMBRE_AREA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 70, Mensajes.LONGITUD_NOMBRE_AREA_INVALIDA);

        this.nombre = nombre;
    }

    private void setSubareas(List<Subarea> subareas) {
        this.subareas = subareas;
    }

    private void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
}