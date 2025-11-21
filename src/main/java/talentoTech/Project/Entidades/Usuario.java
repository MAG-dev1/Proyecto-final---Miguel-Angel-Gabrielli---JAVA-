package talentoTech.Project.Entidades;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private TipoUsuario tipo;
}

