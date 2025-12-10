package talentoTech.Project.Entidades;

import java.util.List;

public record PedidoRequest(
    List<Long> productosIds,
    List<Integer> cants,
    Long userId,
    String fechaEntrega
) {}
