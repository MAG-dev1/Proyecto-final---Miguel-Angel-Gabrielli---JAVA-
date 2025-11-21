package talentoTech.Project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import talentoTech.Project.Entidades.Pedido;
import talentoTech.Project.Entidades.productos.Producto;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    
} 
