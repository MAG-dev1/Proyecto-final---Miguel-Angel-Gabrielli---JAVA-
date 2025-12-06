package talentoTech.Project.Entidades.productos;

import lombok.Builder;

@Builder
public record RemeraDTO(

    String nombre,
    String descripcion,
    String categoria,
    String url,
    Integer stock,
    Double precio,
    String color,
    Integer quality, // 1, 2 and 3
    String fabricType //cotton, polyester, blends

) implements ProductoDTO {
    
}
