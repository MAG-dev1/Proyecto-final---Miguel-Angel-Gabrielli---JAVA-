package talentoTech.Project.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jspecify.annotations.Nullable;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import talentoTech.Project.Entidades.Pedido;
import talentoTech.Project.Entidades.productos.Producto;
import talentoTech.Project.Repository.PedidoRepository;

@Service
public class PedidoService {
    
    private PedidoRepository servicio;

    public List<Pedido> getAll(){
        return servicio.findAll();
    }

    public List<Producto> getAllProducts(long id){
        Optional<Pedido> p = servicio.findById(id);
        return p.get().getProductos();
    }

    public Pedido get(long id) {
        Optional<Pedido> p = servicio.findById(id);
        return p.orElseThrow(
            () -> new IllegalArgumentException("No existe ese pedido"));
    }

    public Producto getOneProduct(Long id, Long idProduct){
        Optional<Pedido> p = servicio.findById(id);
        Pedido pedido = p.orElseThrow( () -> new IllegalArgumentException("No existe ese pedido"));
        return findProduct(pedido, idProduct);
    }

    private Producto findProduct(Pedido pedido, long id){
        for (Producto product : pedido.getProductos()) 
            if (product.getId() == id) 
                return product;
        throw new IllegalArgumentException("product not found");
    }
}
