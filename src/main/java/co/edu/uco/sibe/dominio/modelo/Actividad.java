package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

@Getter
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
            UUID creador) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.semestre = semestre;
        this.rutaInsumos = rutaInsumos;
        this.indicador = indicador;
        this.colaborador = colaborador;
        this.creador = creador;
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

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }
}