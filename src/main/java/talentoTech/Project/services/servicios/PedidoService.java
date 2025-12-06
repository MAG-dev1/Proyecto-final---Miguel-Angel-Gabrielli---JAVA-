package talentoTech.Project.services.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import org.jspecify.annotations.Nullable;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import lombok.Data;
import talentoTech.Project.Entidades.Pedido;
import talentoTech.Project.Entidades.PedidoDTO;
import talentoTech.Project.Entidades.productos.Producto;
import talentoTech.Project.Entidades.users.Cliente;
import talentoTech.Project.Repository.PedidoRepository;
import talentoTech.Project.services.interfaces.IPedidoService;

@Service
@Data
public class PedidoService implements IPedidoService {
    
    private final PedidoRepository repository;
    private final ProductoService servicioProducto;
    private final UsuarioService servicioUsuario;

    @Override
    public List<PedidoDTO> getAll(){
        return repository
        .findAll()
        .stream()
        .map(Pedido::toDTO)
        .toList();
    }

    @Override
    public List<Producto> getAllProducts(long id){
        Optional<Pedido> p = repository.findById(id);
        return p.get().getProductos();
    }

    @Override
    public Producto getOneProduct(Long id, Long idProduct){
        Optional<Pedido> p = repository.findById(id);
        Pedido pedido = p.orElseThrow( () -> new IllegalArgumentException("No existe ese pedido"));
        return findProduct(pedido, idProduct);
    }

    private Producto findProduct(Pedido pedido, long id){
        for (Producto product : pedido.getProductos()) 
            if (product.getId() == id) 
                return product;
        throw new IllegalArgumentException("product not found");
    }

    @Override
    public PedidoDTO create(Pedido object) {
        return repository.save(object).toDTO();
    }

    @Override
    public PedidoDTO edit(Long id, Pedido object) {
       return repository.save(object).toDTO();
    }

    @Override
    public PedidoDTO delete(Long idObject) throws Exception {
        Pedido p = repository.findById(idObject)
        .orElseThrow(errorNotIDFoundException());
        repository.deleteById(idObject);
        return p.toDTO();
    }

    @Override
    public PedidoDTO getByID(Long idObject) throws Exception {
        return repository.findById(idObject)
        .orElseThrow(errorNotIDFoundException())
        .toDTO();
    }

    private Supplier<Exception> errorNotIDFoundException(){
        return () -> new IllegalArgumentException("Not found exception");
    }

    @Override
    public List<Producto> localizarProductos(List<Long> productosIds) throws Exception{
        return productosIds
        .stream()
        .map( (id) -> {

            Producto p = servicioProducto.getProducts(id);
            if (p == null) {
                throw new RuntimeException("no existe un producto con id" + id);
            }

            return p;
        
        })
        .toList();
        
    }

    @Override
    public Cliente localizarCliente(Long userId) {
        return servicioUsuario.obtenerCliente(userId);
    }
}
