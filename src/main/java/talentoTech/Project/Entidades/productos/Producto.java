package talentoTech.Project.Entidades.productos;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import talentoTech.Project.Entidades.Pedido;
import talentoTech.Project.Entidades.users.UsuarioDTO;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Producto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String categoria;
    private String url;
    private Integer stock;
    private Double precio;
    private String color;
    private Integer quality; // 1, 2 and 3

   @ManyToMany(mappedBy = "productos")
    private List<Pedido> pedidos;

     public abstract ProductoDTO toDTO();
   
}