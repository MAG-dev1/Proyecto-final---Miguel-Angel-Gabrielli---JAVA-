package talentoTech.Project.Controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import talentoTech.Project.Entidades.Pedido;
import talentoTech.Project.services.IPedido;
import talentoTech.Project.services.OperationalCRUD;
import talentoTech.Project.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    private IPedido servicio;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(servicio.getAll());
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<?> getAllProducts(@PathVariable Long id){
        return ResponseEntity.ok(servicio.getAllProducts(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable long id) throws Exception{
        return ResponseEntity.ok(servicio.getByID(id));
    }
}
