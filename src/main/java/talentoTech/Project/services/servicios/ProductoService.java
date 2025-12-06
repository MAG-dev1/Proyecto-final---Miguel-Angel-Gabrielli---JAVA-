package talentoTech.Project.services.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import lombok.Data;
import talentoTech.Project.Entidades.productos.Producto;
import talentoTech.Project.Entidades.productos.ProductoDTO;
import talentoTech.Project.Entidades.productos.Remera;
import talentoTech.Project.Repository.ProductoRepository;
import talentoTech.Project.services.interfaces.IProductoService;
import talentoTech.Project.services.interfaces.OperationalCRUD;
import talentoTech.Project.Entidades.productos.Short;
@Data
@Service
public class ProductoService implements IProductoService{

    private final ProductoRepository productos;

    @Override
    public ProductoDTO getByID(Long idObject) throws Exception{
       Producto p = productos.findById(idObject)
       .orElseThrow(errorNotIDFoundException());
        return p.toDTO();
    }

    @Override
    public ProductoDTO create(Producto object) {
        return productos.save(object).toDTO();
    }

    @Override
    public ProductoDTO edit(Long id, Producto object) throws Exception {
        Producto p = productos.findById(id)
        .orElseThrow(errorNotIDFoundException());

        if (object instanceof Remera) {
            p.setNombre(object.getNombre());
            p.setDescripcion(object.getDescripcion());
            p.setCategoria(object.getCategoria());
            p.setUrl(object.getUrl());
            p.setStock(object.getStock());
            p.setPrecio(object.getPrecio());
            p.setColor(object.getColor());
            p.setQuality(object.getQuality());
            ((Remera)object).setFabricType(((Remera)object).getFabricType());
        }
        return productos.save(p).toDTO();
    }

    @Override
    public List<ProductoDTO> getAll() {
        return productos
        .findAll()
        .stream()
        .map(e -> e.toDTO())
        .toList();
    }

    @Override
    public ProductoDTO delete(Long idObject) throws Exception {
        Producto p = productos.findById(idObject)
        .orElseThrow(errorNotIDFoundException());
        productos.deleteById(idObject);
        return p.toDTO();
    }

    private Supplier<Exception> errorNotIDFoundException(){
        return () -> new IllegalArgumentException("Not found exception");
    }

    Producto getProducts(long id){
        try {
            return productos.findById(id).orElseThrow(errorNotIDFoundException());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
