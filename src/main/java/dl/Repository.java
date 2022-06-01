package dl;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

     T findById(Integer id);

    Integer save(T entity);
    void saveWithId(T entity);
    int update(T entity);
    void delete(Integer id);
    List<T> selectAll();
}
