package talentoTech.Project.Entidades.productos;

import lombok.Builder;

@Builder
public record ShortDTO(
    String _nombre,
    String _descripcion,
    String _categoria,
    String _url,
    Integer stock,
    Double precio,
    String color,
    Integer quality, // 1, 2 and 3
    boolean verticalLines
) implements ProductoDTO {
    
}
