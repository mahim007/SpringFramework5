package com.mahim.petclinic.service.jpa;

import com.mahim.petclinic.model.Specialty;
import com.mahim.petclinic.repositories.SpecialtyRepository;
import com.mahim.petclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtyServiceJpa implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceJpa(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }
}
