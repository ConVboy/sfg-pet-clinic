package convboy.springframework.sfgpetclinic.bootstrap;

import convboy.springframework.sfgpetclinic.model.*;
import convboy.springframework.sfgpetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialtyService specialtyService;



    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petService.findAll().size();
        if(count == 0){
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Kenny");
        owner1.setLastName("McCormac");
        owner1.setAdress("Sesamestreet 2");
        owner1.setCity("Gotham");
        owner1.setTelephone("012471203");

        Pet kennysPet = new Pet();
        kennysPet.setName("Hunter");
        kennysPet.setPetType(dog);
        kennysPet.setBirthDate(LocalDate.now());
        kennysPet.setOwner(owner1);
        owner1.getPets().add(kennysPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Steve");
        owner2.setLastName("Ackermann");
        owner2.setAdress("Sesamestreet 3");
        owner2.setCity("Gothham");
        owner2.setTelephone("2134561345");

        Pet StevesPet = new Pet();
        StevesPet.setName("Schnurrbi");
        StevesPet.setPetType(cat);
        StevesPet.setBirthDate(LocalDate.now());
        StevesPet.setOwner(owner2);
        owner2.getPets().add(StevesPet);

        ownerService.save(owner2);

        System.out.println("Owners loaded...");


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Kellogs");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Kellogsome");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vets loaded...");
    }
}
