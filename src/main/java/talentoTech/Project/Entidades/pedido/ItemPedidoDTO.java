package talentoTech.Project.Entidades.pedido;

import lombok.Builder;
import talentoTech.Project.Entidades.productos.Producto;

@Builder
public record ItemPedidoDTO(

    Pedido pedido,
    Producto producto,

   int cantidad,
   int precioUnidad
) {

}
