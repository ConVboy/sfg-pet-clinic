package convboy.springframework.sfgpetclinic.services.springdatajpa;

import convboy.springframework.sfgpetclinic.model.Pet;
import convboy.springframework.sfgpetclinic.repositories.PetRepository;
import convboy.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJPAService implements PetService {

    private final PetRepository petRepo;

    public PetSDJPAService(PetRepository petRepo) {
        this.petRepo = petRepo;
    }


    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepo.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepo.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet obj) {
        return petRepo.save(obj);
    }

    @Override
    public void delete(Pet obj) {
        petRepo.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepo.deleteById(aLong);
    }
}
