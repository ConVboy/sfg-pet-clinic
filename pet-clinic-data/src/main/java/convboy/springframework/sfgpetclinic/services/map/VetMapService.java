package convboy.springframework.sfgpetclinic.services.map;

import convboy.springframework.sfgpetclinic.model.Specialty;
import convboy.springframework.sfgpetclinic.model.Vet;
import convboy.springframework.sfgpetclinic.services.SpecialtyService;
import convboy.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService){
        this.specialtyService = specialtyService;
    }
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet obj) {
        super.delete(obj);
    }

    @Override
    public Vet save(Vet obj) {

        if(obj.getSpecialites().size() > 0){
            obj.getSpecialites().forEach(specialty -> {if(specialty.getId()== null){
           Specialty savedSpecialty = specialtyService.save(specialty);
           specialty.setId(savedSpecialty.getId());
            }
            });
        }
        return super.save( obj);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
