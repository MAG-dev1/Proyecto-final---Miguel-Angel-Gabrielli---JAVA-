package talentoTech.Project.services.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.Data;
import talentoTech.Project.Entidades.users.Cliente;
import talentoTech.Project.Entidades.users.Usuario;
import talentoTech.Project.Entidades.users.UsuarioDTO;
import talentoTech.Project.Repository.UsuarioRepository;
import talentoTech.Project.services.interfaces.IUsuarioService;

@Service
@Data
public class UsuarioService implements IUsuarioService{

    private final UsuarioRepository repository;
    @Override
    public UsuarioDTO create(Usuario object) {
        return repository.save(object).toDTO();
    }

    @Override
    public UsuarioDTO edit(Long id, Usuario object) {
        Cliente cliente = (Cliente) repository.findById(id)
        .orElseThrow(()-> new IllegalArgumentException("invalid id for edit user"));
        
        cliente.setPassword(object.getPassword());
        cliente.setUsername(object.getUsername());
        cliente.setType(((Cliente)object).getType());

        return repository.save(cliente).toDTO();
    }

    @Override
    public UsuarioDTO delete(Long idObject) throws Exception {
        Usuario user = repository
        .findById(idObject)
        .orElseThrow(()-> new IllegalArgumentException("invalid id for delete user"));
        
        repository.delete(user);
        return user.toDTO();

    }

    @Override
    public List<UsuarioDTO> getAll() {
        return repository
        .findAll()
        .stream()
        .map((e)-> e.toDTO())
        .toList();
    }

    @Override
    public UsuarioDTO getByID(Long idObject) throws Exception {
        return repository
        .findById(idObject)
        .orElseThrow(()-> new IllegalArgumentException("invalid id for delete user"))
        .toDTO();
    }

    @Override
    public String revocar(long idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'revocar'");
    }

    public Cliente obtenerCliente(Long userId) {
        return (Cliente) repository
        .findById(userId)
        .orElseThrow(() -> new RuntimeException("No existe ese cliente"));
    }
    
}
