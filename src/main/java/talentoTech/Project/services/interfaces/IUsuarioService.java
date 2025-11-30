package talentoTech.Project.services.interfaces;

import talentoTech.Project.Entidades.users.Usuario;

public interface IUsuarioService extends OperationalCRUD<Usuario> {
    String revocar(long idUsuario);
}
