package talentoTech.Project.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import talentoTech.Project.services.interfaces.IPedidoService;

@RestController
@RequestMapping("/pedidos")
@Data
public class PedidoController {
    
    private final IPedidoService servicio;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(servicio.getAll());
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<?> getAllProductsFromThisPedido(@PathVariable Long id){
        return ResponseEntity.ok(servicio.getAllProducts(id));
    }

    @GetMapping("/{id}/products/{idProduct}")
    public ResponseEntity<?> getOneProduct(@PathVariable Long id, @PathVariable Long idProduct){
         return ResponseEntity.ok(servicio.getOneProduct(id, idProduct));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable long id) throws Exception{
        return ResponseEntity.ok(servicio.getByID(id));
    }


}
