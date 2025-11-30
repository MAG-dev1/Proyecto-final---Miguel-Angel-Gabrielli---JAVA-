package talentoTech.Project.Entidades;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import talentoTech.Project.Entidades.productos.Producto;
import talentoTech.Project.Entidades.users.Cliente;
import talentoTech.Project.Entidades.users.Usuario;

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue
    private long id;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Producto> productos;


    @ManyToOne
    private Cliente user;

    public List<Producto> getProductos() {
        return productos;
    }
}
