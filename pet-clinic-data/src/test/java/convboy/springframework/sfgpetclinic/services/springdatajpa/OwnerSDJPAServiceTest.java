package convboy.springframework.sfgpetclinic.services.springdatajpa;

import convboy.springframework.sfgpetclinic.model.Owner;
import convboy.springframework.sfgpetclinic.repositories.OwnerRepository;
import convboy.springframework.sfgpetclinic.repositories.PetRepository;
import convboy.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJPAServiceTest {

    public static final String LAST_NAME = "Redinger";
    Owner returnOwner;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJPAService ownerService;


    @BeforeEach
    void setUp() {
        returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName(LAST_NAME);


    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(returnOwner);

        assertEquals(returnOwner, ownerService.findByLastName(LAST_NAME));
    }

    @Test
    void findAll() {


        Set<Owner> returnOwnerSet = new HashSet<>();
        Owner returnOwner2 = new Owner();
        returnOwner2.setId(2L);
        returnOwner2.setLastName("Kev");
        returnOwnerSet.add(returnOwner);
        returnOwnerSet.add(returnOwner2);

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> findAllSet = ownerService.findAll();

        assertNotNull(findAllSet);
        assertEquals(2, findAllSet.size());

    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(java.util.Optional.of(returnOwner));

        Owner findByIdOwner = ownerService.findById(1l);

        assertEquals(findByIdOwner, returnOwner);

    }

    @Test
    void findByIdNotFound(){
        when(ownerRepository.findById(anyLong())).thenReturn(java.util.Optional.empty());

        Owner noOwner = ownerService.findById(1L);

        assertNull(noOwner);
    }

    @Test
    void save() {

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerService.save(returnOwner);

        assertEquals(savedOwner, returnOwner);
        verify(ownerRepository, times(1)).save(any());

    }

    @Test
    void delete() {
        ownerService.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(any());

    }

    @Test
    void deleteById() {
        ownerService.deleteById(returnOwner.getId());

        verify(ownerRepository, times(1)).deleteById(any());
    }
}