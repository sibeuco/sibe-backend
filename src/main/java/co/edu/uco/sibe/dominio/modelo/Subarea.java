package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.List;
import java.util.UUID;

public class Subarea {
    private UUID identificador;
    private String nombre;
    private List<Actividad> actividades;

    private Subarea(UUID identificador, String nombre, List<Actividad> actividades) {
        setIdentificador(identificador);
        setNombre(nombre);
        setActividades(actividades);
    }

    public static Subarea construir(UUID identificador, String nombre, List<Actividad> actividades) {
        return new Subarea(identificador, nombre, actividades);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, "");
        ValidadorTexto.validarTextoValido(nombre, "");
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 70, "");

        this.nombre = nombre;
    }

    private void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
}