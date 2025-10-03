package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.List;
import java.util.UUID;

public class Proyecto {
    private UUID identificador;
    private String numeroProyecto;
    private String nombre;
    private String objetivo;
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

    public String getObjetivo() {
        return objetivo;
    }

    public List<Accion> getAcciones() {
        return acciones;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNumeroProyecto(String numeroProyecto) {
        ValidadorTexto.validarObligatorio(numeroProyecto, Mensajes.NUMERO_PROYECTO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(numeroProyecto, Mensajes.NUMERO_PROYECTO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(numeroProyecto.length(), 1, 12, Mensajes.LONGITUD_NUMERO_PROYECTO_INVALIDA);

        this.numeroProyecto = numeroProyecto;
    }

    private void setNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, Mensajes.NOMBRE_PROYECTO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, Mensajes.NOMBRE_PROYECTO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 100, Mensajes.LONGITUD_NOMBRE_PROYECTO_INVALIDA);

        this.nombre = nombre;
    }

    private void setObjetivo(String objetivo) {
        ValidadorTexto.validarObligatorio(objetivo, Mensajes.OBJETIVO_PROYECTO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(objetivo, Mensajes.OBJETIVO_PROYECTO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(objetivo.length(), 10, 500, Mensajes.LONGITUD_OBJETIVO_PROYECTO_INVALIDA);

        this.objetivo = objetivo;
    }

    private void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }
}