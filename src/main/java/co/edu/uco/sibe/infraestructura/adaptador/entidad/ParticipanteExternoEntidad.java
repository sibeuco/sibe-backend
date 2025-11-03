package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.CAMPO_IDENTIFICADOR;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.PARTICIPANTE_EXTERNO;

@Getter
@Setter
@Entity
@Table(name = PARTICIPANTE_EXTERNO)
@PrimaryKeyJoinColumn(name = CAMPO_IDENTIFICADOR)
public class ParticipanteExternoEntidad extends ParticipanteEntidad {
}