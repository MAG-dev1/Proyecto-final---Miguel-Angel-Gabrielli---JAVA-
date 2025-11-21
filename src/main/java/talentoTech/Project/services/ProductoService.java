package talentoTech.Project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import lombok.Data;
import talentoTech.Project.Entidades.productos.Producto;
import talentoTech.Project.Repository.ProductoRepository;

@Data
@Service
public class ProductoService implements OperationalCRUD<Producto>{

    private ProductoRepository productos;

    @Override
    public Producto getByID(Long idObject) throws Exception{
       Producto p = productos.findById(idObject)
       .orElseThrow(errorNotIDFoundException());
        return p;
    }

    @Override
    public Producto create(Producto object) {
       return productos.save(object);
    }

    @Override
    public Producto edit(Producto object) {
        return productos.save(object);
    }

    @Override
    public List<Producto> getAll() {
        return productos.findAll();
    }

    @Override
    public Producto delete(Long idObject) throws Exception {
        Producto p = productos.findById(idObject)
        .orElseThrow(errorNotIDFoundException());
        productos.deleteById(idObject);
        return p;
    }

    private Supplier<Exception> errorNotIDFoundException(){
        return () -> new IllegalArgumentException("Not found exception");
    }


}
