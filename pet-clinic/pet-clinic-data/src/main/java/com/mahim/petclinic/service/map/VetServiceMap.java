package com.mahim.petclinic.service.map;

import com.mahim.petclinic.model.Specialty;
import com.mahim.petclinic.model.Vet;
import com.mahim.petclinic.service.SpecialtyService;
import com.mahim.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet object) {
        if (object != null) {
            if (object.getSpecialties() != null) {
                object.getSpecialties().forEach(specialty -> {
                    if (specialty.getId() == null) {
                        Specialty savedSpecialty = specialtyService.save(specialty);
                        specialty.setId(savedSpecialty.getId());
                    }
                });
            }
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
