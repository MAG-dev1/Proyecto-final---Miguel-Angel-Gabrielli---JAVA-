package talentoTech.Project.services.interfaces;

import java.util.List;

import talentoTech.Project.Entidades.Pedido;
import talentoTech.Project.Entidades.PedidoDTO;
import talentoTech.Project.Entidades.productos.Producto;
import talentoTech.Project.Entidades.users.Cliente;

public interface IPedidoService extends OperationalCRUD<Pedido, PedidoDTO> {

    public Producto getOneProduct(Long id, Long idProduct);
    public List<Producto> getAllProducts(long id);
    public List<Producto> localizarProductos(List<Long> productosIds)  throws Exception;
    public Cliente localizarCliente(Long userId);
}
