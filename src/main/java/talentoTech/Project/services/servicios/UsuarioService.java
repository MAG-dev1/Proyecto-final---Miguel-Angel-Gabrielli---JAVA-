package talentoTech.Project.services.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.Data;
import talentoTech.Project.Entidades.users.Cliente;
import talentoTech.Project.Entidades.users.Usuario;
import talentoTech.Project.Repository.UsuarioRepository;
import talentoTech.Project.services.interfaces.IUsuarioService;

@Service
@Data
public class UsuarioService implements IUsuarioService{

    private final UsuarioRepository repository;
    @Override
    public Usuario create(Usuario object) {
        return repository.save(object);
    }

    @Override
    public Usuario edit(Long id, Usuario object) {
        Cliente cliente = (Cliente) repository.findById(id)
        .orElseThrow(()-> new IllegalArgumentException("invalid id for edit user"));
        
        cliente.setPassword(object.getPassword());
        cliente.setUsername(object.getUsername());
        cliente.setType(((Cliente)object).getType());

        return repository.save(cliente);
    }

    @Override
    public Usuario delete(Long idObject) throws Exception {
        Usuario user = repository
        .findById(idObject)
        .orElseThrow(()-> new IllegalArgumentException("invalid id for delete user"));
        
        repository.delete(user);
        return user;

    }

    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @Override
    public Usuario getByID(Long idObject) throws Exception {
        return repository
        .findById(idObject)
        .orElseThrow(()-> new IllegalArgumentException("invalid id for delete user"));
    }

    @Override
    public String revocar(long idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'revocar'");
    }
    
}
