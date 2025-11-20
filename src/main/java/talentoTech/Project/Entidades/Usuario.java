package talentoTech.Project.Entidades;

import java.util.UUID;

import lombok.Data;

@Data
public class Usuario {

    private UUID id;
    private String username;
    private String password;
    private TipoUsuario tipo;
}

