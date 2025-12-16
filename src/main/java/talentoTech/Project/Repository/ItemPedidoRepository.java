package talentoTech.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import talentoTech.Project.Entidades.pedido.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    
}
