package talentoTech.Project.Controller;

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
import talentoTech.Project.Entidades.users.Cliente;
import talentoTech.Project.Entidades.users.Usuario;
import talentoTech.Project.services.interfaces.IUsuarioService;

@RestController
@RequestMapping("/users")
@Data
public class UsuarioController {
    
    private final IUsuarioService service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

     @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(service.getByID(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody Cliente user){
         return ResponseEntity.ok(service.create(user));
    }
    @PutMapping("/{id}")
    public  ResponseEntity<?> edit(@PathVariable Long id, @RequestBody Cliente user) throws Exception{
        return ResponseEntity.ok(service.edit(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(service.delete(id));
    }

}
