package ua.masaltsev.petclinic.services.impl.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ua.masaltsev.petclinic.model.Pet;
import ua.masaltsev.petclinic.repositories.PetRepository;
import ua.masaltsev.petclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class PetServiceJpa implements PetService {

    private final PetRepository petRepository;

    PetServiceJpa (PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
