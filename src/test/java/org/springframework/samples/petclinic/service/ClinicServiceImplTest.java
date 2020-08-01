package org.springframework.samples.petclinic.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;

import java.util.Collection;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ClinicServiceImplTest {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private ClinicServiceImpl clinicService;

    @Test
    void findPetTypes() {
        //given
        List<PetType> petTypes = emptyList();
        given(petRepository.findPetTypes()).willReturn(petTypes);

        //when
        Collection<PetType> actualPetTypes = clinicService.findPetTypes();

        //then
        assertThat(actualPetTypes).isEqualTo(petTypes);
    }
}