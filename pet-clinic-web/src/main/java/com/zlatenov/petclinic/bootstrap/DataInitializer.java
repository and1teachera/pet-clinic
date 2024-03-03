package com.zlatenov.petclinic.bootstrap;

import com.zlatenov.petclinic.model.Owner;
import com.zlatenov.petclinic.model.Pet;
import com.zlatenov.petclinic.model.PetType;
import com.zlatenov.petclinic.model.Speciality;
import com.zlatenov.petclinic.model.Vet;
import com.zlatenov.petclinic.model.Visit;
import com.zlatenov.petclinic.service.OwnerService;
import com.zlatenov.petclinic.service.PetTypeService;
import com.zlatenov.petclinic.service.SpecialityService;
import com.zlatenov.petclinic.service.VetService;
import com.zlatenov.petclinic.service.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author Angel Zlatenov
 */
@AllArgsConstructor
@Component
@Profile("default")
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;


    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().isEmpty()) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        // Generate additional Owners, Pets, and Vets
        String[] ownerFirstNames = {"Alice", "Bob", "Charlie", "Diana", "Edward"};
        String[] ownerLastNames = {"Smith", "Johnson", "Williams", "Brown", "Davis"};
        String[] petNames = {"Buddy", "Lucy", "Max", "Daisy", "Bella"};
        String[] vetFirstNames = {"George", "Hannah", "Ian", "Julia", "Kevin"};
        String[] vetLastNames = {"Taylor", "Moore", "King", "Walker", "Lee"};

        for (int i = 0; i < 5; i++) {
            // Create new owner
            Owner newOwner = new Owner();
            newOwner.setFirstName(ownerFirstNames[i]);
            newOwner.setLastName(ownerLastNames[i]);
            newOwner.setAddress("Street " + (100 + i));
            newOwner.setCity("City" + (i + 1));
            newOwner.setTelephone("98765432" + i);

            // Create new pet
            Pet newPet = new Pet();
            newPet.setName(petNames[i]);
            newPet.setOwner(newOwner);
            newPet.setBirthDate(LocalDate.now());
            newPet.setPetType(i % 2 == 0 ? savedDogPetType : savedCatPetType);
            newOwner.getPets().add(newPet);

            // Save owner and pet
            ownerService.save(newOwner);

            // Create and save a visit for the pet
            Visit petVisit = new Visit();
            petVisit.setPet(newPet);
            petVisit.setDate(LocalDate.now());
            petVisit.setDescription("Checkup for " + petNames[i]);
            visitService.save(petVisit);

            // Create new vet
            Vet newVet = new Vet();
            newVet.setFirstName(vetFirstNames[i]);
            newVet.setLastName(vetLastNames[i]);
            // Assign a specialty to each new vet
            if (i % 3 == 0) {
                newVet.getSpecialities().add(savedRadiology);
            } else if (i % 3 == 1) {
                newVet.getSpecialities().add(savedSurgery);
            } else {
                newVet.getSpecialities().add(savedDentistry);
            }

            // Save the new vet
            vetService.save(newVet);
        }

        System.out.println("Loaded Vets....");
    }
}
