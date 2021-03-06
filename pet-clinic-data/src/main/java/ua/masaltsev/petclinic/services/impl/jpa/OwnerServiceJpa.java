package ua.masaltsev.petclinic.services.impl.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ua.masaltsev.petclinic.model.Owner;
import ua.masaltsev.petclinic.repositories.OwnerRepository;
import ua.masaltsev.petclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class OwnerServiceJpa implements OwnerService {

    private final OwnerRepository ownerRepository;

    OwnerServiceJpa(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
