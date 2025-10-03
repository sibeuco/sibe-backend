package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class EstadoActividad {
    private UUID identificador;
    private String nombre;

    private EstadoActividad(UUID identificador, String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static EstadoActividad construir(UUID identificador, String nombre) {
        return new EstadoActividad(identificador, nombre);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, Mensajes.NOMBRE_ESTADO_ACTIVIDAD_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, Mensajes.NOMBRE_ESTADO_ACTIVIDAD_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 5, 15, Mensajes.LONGITUD_NOMBRE_ESTADO_ACTIVIDAD_INVALIDA);

        this.nombre = nombre;
    }
}