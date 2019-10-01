package convboy.springframework.sfgpetclinic.bootstrap;

import convboy.springframework.sfgpetclinic.model.Owner;
import convboy.springframework.sfgpetclinic.model.Vet;
import convboy.springframework.sfgpetclinic.services.OwnerService;
import convboy.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Kenny");
        owner1.setLastName("McCormac");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Steve");
        owner2.setLastName("Ackermann");

        ownerService.save(owner2);

        System.out.println("Owners loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Kellogs");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Kellogsome");

        vetService.save(vet2);

        System.out.println("Vets loaded...");


    }
}
