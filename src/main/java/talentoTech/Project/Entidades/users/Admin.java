package talentoTech.Project.Entidades.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.With;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "admin")
public class Admin extends Usuario{@Override
    public UsuarioDTO toDTO() {
        
        return AdminDTO
        .builder()
        .username(getUsername())
        .password(getPassword())
        .build();
    }
    
    
}
