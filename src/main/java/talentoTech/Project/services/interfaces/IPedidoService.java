package talentoTech.Project.services.interfaces;

import java.util.List;

import talentoTech.Project.Entidades.Pedido;
import talentoTech.Project.Entidades.productos.Producto;

public interface IPedidoService extends OperationalCRUD<Pedido> {

    public Producto getOneProduct(Long id, Long idProduct);
    public List<Producto> getAllProducts(long id);
}
