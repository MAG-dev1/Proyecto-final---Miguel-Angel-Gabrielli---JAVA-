package talentoTech.Project.Entidades.productos;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@Entity
public abstract class Producto{

    @Id
    @GeneratedValue
    private Long id;

    private String _nombre;
    private String _descripcion;
    private String _categoria;
    private String _url;
    private Integer _stock;
    private Double precio;

    
   
}