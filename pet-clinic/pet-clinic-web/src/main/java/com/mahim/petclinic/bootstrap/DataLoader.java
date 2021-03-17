package com.mahim.petclinic.bootstrap;

import com.mahim.petclinic.model.Owner;
import com.mahim.petclinic.model.Vet;
import com.mahim.petclinic.service.OwnerService;
import com.mahim.petclinic.service.VetService;
import com.mahim.petclinic.service.map.OwnerServiceMap;
import com.mahim.petclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Ashraful");
        owner1.setLastName("Mahim");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("nitol");
        owner2.setLastName("amin");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Monjurul");
        vet1.setLastName("Ornob");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Ashim");
        vet2.setLastName("Ayed");

        vetService.save(vet2);
    }
}
