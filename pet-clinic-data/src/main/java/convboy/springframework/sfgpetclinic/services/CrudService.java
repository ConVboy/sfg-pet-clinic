package convboy.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID extends Long> {

    Set<T> findAll();

    T findById(ID id);

    T save(T obj);

    void delete(T obj);

    void deleteById(ID id);
}
