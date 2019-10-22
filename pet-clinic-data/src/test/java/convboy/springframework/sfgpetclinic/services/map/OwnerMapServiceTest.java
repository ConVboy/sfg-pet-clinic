package convboy.springframework.sfgpetclinic.services.map;

import convboy.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner owner = new Owner();
        owner.setId(1L);
        ownerMapService.save(owner);

    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        Owner owner = ownerMapService.findById(1L);

        assertEquals(1L, owner.getId());
    }

    @Test
    void delete() {
        Owner owner2 = new Owner();
        owner2.setId(2L);

        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(2, ownerMapService.findAll().size());

        ownerMapService.delete(savedOwner);

        assertNull(ownerMapService.findById(savedOwner.getId()));
        assertEquals(1, ownerMapService.findAll().size());

    }

    @Test
    void saveExistIntID() {
        Owner owner2 = new Owner();
        owner2.setId(2L);
        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(owner2.getId(), savedOwner.getId());

    }

    @Test
    void saveNoID(){
        Owner savedOwner = ownerMapService.save(new Owner());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner2 = new Owner();
        owner2.setId(2L);
        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(savedOwner, ownerMapService.findById(owner2.getId()));
    }

    @Test
    void findByLastName() {
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setLastName("Redinger");
        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(savedOwner, ownerMapService.findByLastName(owner2.getLastName()));
    }
}