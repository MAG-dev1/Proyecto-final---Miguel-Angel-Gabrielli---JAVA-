package talentoTech.Project.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import talentoTech.Project.Entidades.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
