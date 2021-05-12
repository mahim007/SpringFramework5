package com.mahim.petclinic.bootstrap;

import com.mahim.petclinic.model.Owner;
import com.mahim.petclinic.model.Pet;
import com.mahim.petclinic.model.PetType;
import com.mahim.petclinic.model.Vet;
import com.mahim.petclinic.service.OwnerService;
import com.mahim.petclinic.service.PetTypeService;
import com.mahim.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Ashraful");
        owner1.setLastName("Mahim");
        owner1.setAddress("adorsho nogor");
        owner1.setCity("N.gonj");
        owner1.setTelephone("123456");

        Pet pet1 = new Pet();
        pet1.setName("tommy");
        pet1.setPetType(savedDogType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("nitol");
        owner2.setLastName("amin");
        owner2.setAddress("rampura");
        owner2.setCity("Dhaka");
        owner2.setTelephone("54321");

        Pet pet2 = new Pet();
        pet2.setName("boyy");
        pet2.setPetType(savedCatType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Monjurul");
        vet1.setLastName("Ornob");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ashim");
        vet2.setLastName("Ayed");
        vetService.save(vet2);
    }
}
