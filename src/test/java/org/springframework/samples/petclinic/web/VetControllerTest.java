package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    private Map<String, Object> model;

    @Mock
    private ClinicService clinicService;

    @InjectMocks
    VetController vetController;

    @BeforeEach
    void setUp() {
        model = new HashMap<>();
    }

    @Test
    void vetListUrlCorrect() {
        //when
        String actualUrl = vetController.showVetList(model);

        //then
        assertThat(actualUrl).isEqualTo("vets/vetList");
    }

    @Test
    void vetListFilled() {
        //given
        List<Vet> vets = clinicServiceHasOneVet();

        //when
        vetController.showVetList(model);

        //then
        List<Vet> actualVets = ((Vets) model.get("vets")).getVetList();
        assertThat(actualVets).isEqualTo(vets);
    }

    @Test
    void vetsObjectForJSonFilled() {
        //given
        List<Vet> vets = clinicServiceHasOneVet();
        //when
        Vets actualVets = vetController.showResourcesVetList();
        //then
        assertThat(actualVets.getVetList()).isEqualTo(vets);
    }

    private List<Vet> clinicServiceHasOneVet() {
        List<Vet> vets = singletonList(new Vet());
        when(clinicService.findVets()).thenReturn(vets);
        return vets;
    }
}