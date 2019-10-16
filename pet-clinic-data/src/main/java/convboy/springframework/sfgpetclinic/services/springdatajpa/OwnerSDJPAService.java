package convboy.springframework.sfgpetclinic.services.springdatajpa;

import convboy.springframework.sfgpetclinic.model.Owner;
import convboy.springframework.sfgpetclinic.repositories.OwnerRepository;
import convboy.springframework.sfgpetclinic.repositories.PetRepository;
import convboy.springframework.sfgpetclinic.repositories.PetTypeRepository;
import convboy.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJPAService implements OwnerService {

    private final OwnerRepository ownerRepo;
    private final PetRepository petRepo;
    private final PetTypeRepository petTypeRepo;

    public OwnerSDJPAService(OwnerRepository ownerRepo,PetRepository petRepo,
                             PetTypeRepository petTypeRepo ){
        this.ownerRepo = ownerRepo;
        this.petRepo = petRepo;
        this.petTypeRepo = petTypeRepo;
    }
    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepo.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepo.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
       /* Optional<Owner> ownerOptional = ownerRepo.findById(id);
        if (ownerOptional.isPresent()){
         return ownerOptional.get();
        }
        else return null;*/

       return ownerRepo.findById(id).orElse(null);
        }

    @Override
    public Owner save(Owner obj) {
        return ownerRepo.save(obj);
    }

    @Override
    public void delete(Owner obj) {
        ownerRepo.delete(obj);

    }

    @Override
    public void deleteById(Long id) {
        ownerRepo.deleteById(id);
    }
}
