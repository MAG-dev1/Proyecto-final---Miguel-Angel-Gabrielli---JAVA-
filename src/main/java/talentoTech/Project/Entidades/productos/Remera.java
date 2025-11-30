package talentoTech.Project.Entidades.productos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "remera")
@Data
@EqualsAndHashCode(callSuper = true)      
public class Remera extends Producto{
    

    private String fabricType; //cotton, polyester, blends
}
