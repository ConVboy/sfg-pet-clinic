package convboy.springframework.sfgpetclinic.services;

import convboy.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {


    Pet findByID(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}


