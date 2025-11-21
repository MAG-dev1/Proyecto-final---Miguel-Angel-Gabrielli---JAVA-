package talentoTech.Project.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import talentoTech.Project.Entidades.productos.Producto;
import talentoTech.Project.services.OperationalCRUD;
import talentoTech.Project.services.ProductoService;

@RestController
@RequestMapping("/products")
class ProductoController{

    private OperationalCRUD<Producto> service;
    
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(service.getByID(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createProduct(@RequestBody Producto product){
         return ResponseEntity.ok(service.create(product));
    }
    @PutMapping("")
    public  ResponseEntity<?> edit(@RequestBody Producto product){
        return ResponseEntity.ok(service.edit(product));
    }
}