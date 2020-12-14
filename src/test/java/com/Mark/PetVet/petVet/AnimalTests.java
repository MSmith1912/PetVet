package com.Mark.PetVet.petVet;

import com.Mark.PetVet.petVet.models.Animal;
import com.Mark.PetVet.petVet.services.GeneralService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AnimalTests {

    @Autowired
    GeneralService generalService;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    ObjectMapper objectMapper;

    MockMvc mockMvc;

    MockHttpSession session;

    @BeforeEach
    public void setUp() {
        this.session = new MockHttpSession();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(SharedHttpSessionConfigurer.sharedHttpSession())
                .build();
    }

    @AfterEach
    public void test() {
        this.session = null;
        this.mockMvc = null;
    }

    // vertebrate or invertebrate

    // VERTEBRATE
    // reptiles
    // fish
    // amphibians
    // birds
    // mammals

    // INVERTEBRATES
    // insects
    // arachnids
    // crustaceans


    @Test
    public void testThat_AnAnimal_CanBeCreated() {
        Animal animal = new Animal();
        animal.setGroup("vertebrate");
        animal.setClassification("mammal");
        animal.setSpecies("Canine");
        animal.setBreed("Staffy");

        animal.setName("Sky");
        animal.setDOB("01-04-2018");
        animal.setWeight(24.53);
        animal.setDescription("A beautiful black and white staff with brown paws and a white chest");

        generalService.save(animal);
        Assertions.assertNotNull(animal.getAnimalId());
        Assertions.assertNotNull(animal.getGroup());
        Assertions.assertNotNull(animal.getClassification());
        Assertions.assertNotNull(animal.getSpecies());
        Assertions.assertNotNull(animal.getBreed());
        Assertions.assertNotNull(animal.getName());
        Assertions.assertNotNull(animal.getDOB());
        Assertions.assertNotNull(animal.getWeight());
        Assertions.assertNotNull(animal.getDescription());
    }

    @Test
    public void testThat_Animal_CanBeRetreived_ViaAnimalID() {
        Animal animalFromDB = generalService.findByAnimalId(1).get();
        Assertions.assertNotNull(animalFromDB);
        Assertions.assertEquals(animalFromDB.getName(), "Sky");
        System.err.println(animalFromDB);
    }

}
