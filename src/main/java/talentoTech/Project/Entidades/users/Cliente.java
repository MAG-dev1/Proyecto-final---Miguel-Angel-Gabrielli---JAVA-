package talentoTech.Project.Entidades.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.With;

@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "cliente")
@Data
public class Cliente extends Usuario {
    private Type type;
}
