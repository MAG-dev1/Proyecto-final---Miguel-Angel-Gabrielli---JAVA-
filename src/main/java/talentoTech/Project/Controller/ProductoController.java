package talentoTech.Project.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import talentoTech.Project.Entidades.productos.Producto;
import talentoTech.Project.Entidades.productos.ProductoDTO;
import talentoTech.Project.Entidades.productos.Remera;
import talentoTech.Project.services.interfaces.IProductoService;
import talentoTech.Project.services.interfaces.OperationalCRUD;
import talentoTech.Project.services.servicios.ProductoService;

@RestController
@RequestMapping("/products")
@Data
class ProductoController{

    private final IProductoService service;
    
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(service.getByID(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createProduct(@RequestBody Remera product){
         return ResponseEntity.ok(service.create(product));
    }
    @PutMapping("/{id}")
    public  ResponseEntity<?> edit(@PathVariable Long id, @RequestBody Remera product) throws Exception{
        return ResponseEntity.ok(service.edit(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(service.delete(id));
    }
}