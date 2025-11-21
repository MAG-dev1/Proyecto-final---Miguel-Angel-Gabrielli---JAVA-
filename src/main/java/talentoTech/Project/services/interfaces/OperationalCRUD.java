package talentoTech.Project.services.interfaces;

import java.util.List;

public interface OperationalCRUD<T> {

    T create(T object);
    T edit(T object);
    T delete(Long idObject) throws Exception;
    List<T> getAll();
    T getByID(Long idObject) throws Exception;
}