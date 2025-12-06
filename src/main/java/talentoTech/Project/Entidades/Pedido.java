package talentoTech.Project.Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import talentoTech.Project.Entidades.productos.Producto;
import talentoTech.Project.Entidades.productos.ProductoDTO;
import talentoTech.Project.Entidades.users.Cliente;
import talentoTech.Project.Entidades.users.ClienteDTO;
import talentoTech.Project.Entidades.users.Usuario;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

  @ManyToMany
    @JoinTable(
        name = "pedido_productos",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id"),
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"pedido_id", "producto_id"})
        }
    )
  private List<Producto> productos;


    @ManyToOne
    private Cliente user;

    public List<Producto> getProductos() {
        return productos;
    }

    public PedidoDTO toDTO(){

        List<ProductoDTO> list = new ArrayList<>();
        list.addAll(productos.stream().map((e) -> e.toDTO()).toList()); 

        return PedidoDTO
        .builder()
        .cliente((ClienteDTO) user.toDTO())
        .productos(
            list
        )
        .build();
    }
}
