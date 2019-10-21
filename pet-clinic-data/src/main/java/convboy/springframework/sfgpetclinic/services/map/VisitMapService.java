package convboy.springframework.sfgpetclinic.services.map;

import convboy.springframework.sfgpetclinic.model.Visit;
import convboy.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit obj) {
        super.delete(obj);
    }

    @Override
    public Visit save(Visit obj) {
        if(obj.getPet() == null || obj.getPet().getOwner() == null || obj.getPet().getId()== null){
            throw new RuntimeException("invalid visit");
        }
        return super.save(obj);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
