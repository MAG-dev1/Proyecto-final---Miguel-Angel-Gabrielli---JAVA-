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
   
    private boolean verticalLines;

    @Override
    public ProductoDTO toDTO() {
        return ShortDTO
        .builder()
        ._nombre(getNombre())
        ._descripcion(getDescripcion())
        ._categoria(getCategoria())
            ._url(getUrl())
            .stock(getStock())
            .precio(getPrecio())
            .color(getColor())
            .quality(getQuality())
            .verticalLines(isVerticalLines())
            .build();
    }
}
