package talentoTech.Project.Entidades.pedido;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import talentoTech.Project.Entidades.IGenericDTO;
import talentoTech.Project.Entidades.productos.Producto;
import talentoTech.Project.services.servicios.PedidoService;

@Entity
@Data
public class ItemPedido implements IGenericDTO<ItemPedidoDTO> {
    
       public ItemPedido() {} 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id    
    private Long id;

    @ManyToOne
@JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
@JoinColumn(name = "producto_id")
    private Producto producto;

    private int cantidad;
    private int precioUnidad;
    @Override
    public ItemPedidoDTO toDTO() {
        return ItemPedidoDTO.builder()
        .producto(producto)
        .cantidad(cantidad)
        .precioUnidad(precioUnidad)
        .pedido(pedido)
        .build();
        
        
    }

    public ItemPedido(Pedido pedido2, Producto producto2, int cantidad) {
        pedido = pedido2;
        producto = producto2;
        this.cantidad = cantidad;
        this.precioUnidad = producto2.getPrecio().intValue();
        
    }
    
}
