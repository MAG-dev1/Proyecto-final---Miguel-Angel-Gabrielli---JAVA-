package talentoTech.Project.services.interfaces;

import talentoTech.Project.Entidades.users.Usuario;
import talentoTech.Project.Entidades.users.UsuarioDTO;

public interface IUsuarioService extends OperationalCRUD<Usuario, UsuarioDTO> {
    String revocar(long idUsuario);
}
