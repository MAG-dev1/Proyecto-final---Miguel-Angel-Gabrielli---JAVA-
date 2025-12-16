package talentoTech.Project.Entidades.pedido;

import java.util.List;

public record PedidoRequest(
    List<Long> productosIds,
    List<Integer> cants,
    Long userId,
    String fechaEntrega
) {}
