package convboy.springframework.sfgpetclinic.services.map;

import net.bytebuddy.implementation.HashCodeMethod;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save (ID objId, T obj){
        map.put(objId, obj);
        return obj;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T obj){
        map.entrySet().removeIf(entry -> entry.getValue().equals(obj));
    }
}
