package talentoTech.Project.Entidades;

import java.util.UUID;
import lombok.Data;

@Data
public class Producto{

    private Long id;
    private String _nombre;
    private String _descripcion;
    private String _categoria;
    private String _url;
    private int _stock;

   
}