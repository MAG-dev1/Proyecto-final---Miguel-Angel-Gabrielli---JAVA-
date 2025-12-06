package talentoTech.Project.Entidades.users;

import lombok.Builder;

@Builder
public record AdminDTO(
    String username,
    String password
) implements UsuarioDTO {
    
}
