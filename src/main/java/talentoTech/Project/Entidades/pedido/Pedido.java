package talentoTech.Project.Entidades.pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
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
import talentoTech.Project.Entidades.IGenericDTO;
import talentoTech.Project.Entidades.productos.Producto;
import talentoTech.Project.Entidades.productos.ProductoDTO;
import talentoTech.Project.Entidades.users.Cliente;
import talentoTech.Project.Entidades.users.ClienteDTO;
import talentoTech.Project.Entidades.users.Usuario;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido implements IGenericDTO<PedidoDTO>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ItemPedido> productos = new ArrayList<>();


    @ManyToOne
    private Cliente user;

    private LocalDate fechaCreacion;
    private LocalDate fechaEntrega;
    private String estado;

  
    @Override
    public PedidoDTO toDTO(){

        List<ProductoDTO> list = new ArrayList<>();
        list.addAll(productos.stream().map((e) -> e.getProducto().toDTO()).toList()); 

        return PedidoDTO
        .builder()
        .cliente((ClienteDTO) user.toDTO())
        .productos(
            list
        )
        .fechaCreacion(fechaCreacion)
        .fechaEntrega(fechaEntrega)
        .estado(estado)
        .build();
    }


    public void crearItems(List<Producto> procs, List<Integer> cants) {
        
        int index = 0;
        for (Producto producto : procs) {
            productos.add(new ItemPedido(this, producto, cants.get(index)));
            index++;
        }
    }


    public Producto[] getProductos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductos'");
    }

    public List<Producto> getListProductos(){
        return null;
    }
}
