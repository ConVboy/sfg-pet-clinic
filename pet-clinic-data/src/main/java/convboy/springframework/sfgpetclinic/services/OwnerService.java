package convboy.springframework.sfgpetclinic.services;

import convboy.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

  Owner findByID(Long id);

  Owner findByLastName(String lastName);

  Owner save(Owner owner);

  Set<Owner> findAll();
}
