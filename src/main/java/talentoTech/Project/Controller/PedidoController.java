package talentoTech.Project.Controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import talentoTech.Project.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    private PedidoService servicio;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(servicio.getAll());
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<?> getAllProducts(@PathVariable Long id){
        return ResponseEntity.ok(servicio.getAllProducts(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable long id){
        return ResponseEntity.ok(servicio.get(id));
    }
}
