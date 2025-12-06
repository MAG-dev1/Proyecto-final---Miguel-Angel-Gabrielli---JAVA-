package talentoTech.Project.Entidades;

import java.util.List;

public record PedidoRequest(
    List<Long> productosIds,
    Long userId
) {}
