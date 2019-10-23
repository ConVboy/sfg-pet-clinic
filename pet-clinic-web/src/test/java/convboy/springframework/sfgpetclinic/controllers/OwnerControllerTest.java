package convboy.springframework.sfgpetclinic.controllers;

import convboy.springframework.sfgpetclinic.model.Owner;
import convboy.springframework.sfgpetclinic.services.OwnerService;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;

    MockMvc mockMvc;

    
    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setId(1L);
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owners.add(owner1);
        owners.add(owner2);

        mockMvc = MockMvcBuilders
                .standaloneSetup(ownerController)
                .build();
    }

    @Test
    void listOwners() {
        when(ownerService.findAll()).thenReturn(owners);

        try {
            mockMvc.perform(get("/owners/index"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("owners/index"))
                    .andExpect(model().attribute("owners", hasSize(2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void listOwnersbyIndex(){

    }

   /* @Test
    void findOwners(){
        try {
            mockMvc.perform(get("/owners/find"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("notimplemented"));
        } catch (Exception e) {

        }
    }
*/
}