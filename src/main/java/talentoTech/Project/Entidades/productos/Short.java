package talentoTech.Project.Entidades.productos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "short")
@Data
@EqualsAndHashCode(callSuper = true)
public class Short extends Producto {
    private String color;
    private boolean verticalLines;
}
