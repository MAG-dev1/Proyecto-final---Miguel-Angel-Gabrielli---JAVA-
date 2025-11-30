package talentoTech.Project.services.interfaces;

import java.util.List;

// La interfaz base de la que derivan las demas interfaces
public interface OperationalCRUD<T> {

    T create(T object);
    T edit(Long id, T object);
    T delete(Long idObject) throws Exception;
    List<T> getAll();
    T getByID(Long idObject) throws Exception;
}