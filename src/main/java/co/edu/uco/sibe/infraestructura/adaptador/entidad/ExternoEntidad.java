package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "externo")
@PrimaryKeyJoinColumn(name = "identificador")
public class ExternoEntidad extends MiembroEntidad { }