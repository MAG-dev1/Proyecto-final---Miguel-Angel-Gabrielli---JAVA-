package talentoTech.Project.services;

import talentoTech.Project.Entidades.Usuario;

public interface IUsuarioService extends OperationalCRUD<Usuario> {
    String revocar(long idUsuario);
}
