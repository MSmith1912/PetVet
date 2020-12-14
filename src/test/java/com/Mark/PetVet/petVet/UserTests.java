package com.Mark.PetVet.petVet;

import com.Mark.PetVet.petVet.models.User;
import com.Mark.PetVet.petVet.services.GeneralService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
public class UserTests {

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

    @Test
    public void testThat_User_CanBeCreated() {
        User user = new User();

        user.setUsername("MSmith1912");
        user.setPassword("password");
        user.setFirstName("Mark");
        user.setLastName("Smith");
        user.setDOB("Mark");
        user.setAccess("Admin");

        generalService.save(user);
        Assertions.assertNotNull(user.getUserId());
        Assertions.assertNotNull(user.getUsername());
        Assertions.assertNotNull(user.getPassword());
        Assertions.assertNotNull(user.getFirstName());
        Assertions.assertNotNull(user.getLastName());
        Assertions.assertNotNull(user.getAccess());
        System.err.println(user);
    }

}
