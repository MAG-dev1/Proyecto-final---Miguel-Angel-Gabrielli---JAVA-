package talentoTech.Project.Entidades.users;

import lombok.Builder;

@Builder
public record ClienteDTO (
    String username,
    String password,
    Type tipo
) implements UsuarioDTO  {

}
