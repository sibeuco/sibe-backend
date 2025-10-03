package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class PublicoInteres {
    private UUID identificador;
    private String nombre;

    private PublicoInteres(UUID identificador, String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static PublicoInteres construir(UUID identificador, String nombre) {
        return new PublicoInteres(identificador, nombre);
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
        ValidadorTexto.validarObligatorio(nombre, Mensajes.NOMBRE_PUBLICO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, Mensajes.NOMBRE_PUBLICO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 5, 50, Mensajes.LONGITUD_NOMBRE_PUBLICO_INVALIDA);

        this.nombre = nombre;
    }
}