package talentoTech.Project.Entidades.pedido;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import talentoTech.Project.Entidades.productos.ProductoDTO;
import talentoTech.Project.Entidades.users.ClienteDTO;

@Builder
public record PedidoDTO(

    ClienteDTO cliente,
    List<ProductoDTO> productos,
    LocalDate fechaCreacion,
    LocalDate fechaEntrega,
    String estado
     

) {
    
}
