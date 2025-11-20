package talentoTech.Project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;

import lombok.Data;
import talentoTech.Project.Entidades.Producto;
import talentoTech.Project.Repository.ProductoRepository;

@Data
public class ProductoService {

    private ProductoRepository productos;

    public List<Producto> getAll(){
        return productos.findAll();
     }

    public Producto getByID(long id) {
        Optional<Producto> p = productos.findById(id);
        return p.get();
    }
}
