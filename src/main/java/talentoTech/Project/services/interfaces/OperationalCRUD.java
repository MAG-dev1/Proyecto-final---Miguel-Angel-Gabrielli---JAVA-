package talentoTech.Project.services.interfaces;

import java.util.List;

// La interfaz base de la que derivan las demas interfaces
public interface OperationalCRUD<T, K> {

    K create(T object);
    K edit(Long id, T object) throws Exception;
    K delete(Long idObject) throws Exception;
    List<K> getAll();
    K getByID(Long idObject) throws Exception;
}