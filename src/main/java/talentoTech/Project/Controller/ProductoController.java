package talentoTech.Project.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import talentoTech.Project.Entidades.Producto;
import talentoTech.Project.services.ProductoService;

class ProductoController{

    private ProductoService service;
    
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping
    public ResponseEntity<?> getByID(@RequestBody int id){
        return ResponseEntity.ok(service.getByID(id));
    }
}