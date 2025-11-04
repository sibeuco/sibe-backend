package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import static co.edu.uco.sibe.dominio.transversal.constante.PersistenciaConstante.*;

@Getter
@Setter
@Entity
@Table(name = EXTERNO)
@PrimaryKeyJoinColumn(name = CAMPO_IDENTIFICADOR)
public class ExternoEntidad extends MiembroEntidad { }