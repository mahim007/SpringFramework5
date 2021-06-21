package com.mahim.petclinic.service.jpa;

import com.mahim.petclinic.model.Owner;
import com.mahim.petclinic.repositories.OwnerRepository;
import com.mahim.petclinic.repositories.PetRepository;
import com.mahim.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {
    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private OwnerServiceJpa ownerServiceJpa;

    private final Long ownerId = 1L;
    private final String firstName = "ashraful";
    private final String city = "Dhaka";
    private final String address = "adorsho nogor";
    private final String lastName = "mahim";
    private final String telephone = "12345678";
    Owner owner;
    Set<Owner> owners = new HashSet<>();

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(ownerId).firstName(firstName).lastName(lastName)
                .city(city).address(address).telephone(telephone).build();
        owners.add(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner owner = Owner.builder().id(2L).build();
        Owner savedOwner = ownerServiceJpa.save(owner);
        assertNotEquals(owner.getId(), savedOwner.getId());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(owner));
        Owner owner = ownerServiceJpa.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> all = ownerServiceJpa.findAll();
        assertNotNull(all);
        assertEquals(1, all.size());
    }

    @Test
    void deleteById() {
        ownerServiceJpa.deleteById(ownerId);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void delete() {
        ownerServiceJpa.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(owner);
        Owner mahim = ownerServiceJpa.findByLastName(lastName);
        assertEquals(lastName, mahim.getLastName());
    }
}