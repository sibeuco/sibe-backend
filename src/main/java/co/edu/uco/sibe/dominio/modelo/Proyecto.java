package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.List;
import java.util.UUID;

public class Proyecto {
    private UUID identificador;
    private String numeroProyecto;
    private String nombre;
    private List<Accion> acciones;

    private Proyecto(UUID identificador, String numeroProyecto, String nombre, List<Accion> acciones) {
        setIdentificador(identificador);
        setNumeroProyecto(numeroProyecto);
        setNombre(nombre);
        setAcciones(acciones);
    }

    public static Proyecto construir(UUID identificador, String numeroProyecto, String nombre, List<Accion> acciones) {
        return new Proyecto(identificador, numeroProyecto, nombre, acciones);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNumeroProyecto() {
        return numeroProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Accion> getAcciones() {
        return acciones;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNumeroProyecto(String numeroProyecto) {
        ValidadorTexto.validarObligatorio(numeroProyecto, "");
        ValidadorTexto.validarTextoValido(numeroProyecto, "");
        ValidadorNumero.validarNumeroEntre(numeroProyecto.length(), 1, 5, "");

        this.numeroProyecto = numeroProyecto;
    }

    private void setNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, "");
        ValidadorTexto.validarTextoValido(nombre, "");
        ValidadorNumero.validarNumeroEntre(nombre.length(), 1, 50, "");

        this.nombre = nombre;
    }

    private void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }
}