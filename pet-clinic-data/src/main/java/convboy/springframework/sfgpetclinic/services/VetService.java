package convboy.springframework.sfgpetclinic.services;

import convboy.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {


    Vet findByID(Long id);

    Vet findByLastName(String lastName);

    Vet save(Vet vet);

    Set<Vet> findAll();
}


