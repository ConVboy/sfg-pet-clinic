package convboy.springframework.sfgpetclinic.services.map;

import convboy.springframework.sfgpetclinic.model.BaseEntity;
import net.bytebuddy.implementation.HashCodeMethod;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T obj) {
        if (obj != null) {
            if (obj.getId() == null) {
                obj.setId(getNextId());
            }
            map.put(obj.getId(), obj);
        } else {
            throw new RuntimeException("Object can not be null");
        }

        return obj;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T obj) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(obj));
    }

    private Long getNextId() {
       Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }

}
