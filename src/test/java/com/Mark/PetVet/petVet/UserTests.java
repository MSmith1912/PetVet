package com.Mark.PetVet.petVet;

import com.Mark.PetVet.petVet.models.Animal;
import com.Mark.PetVet.petVet.models.User;
import com.Mark.PetVet.petVet.models.UserRequest;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    final static String USER_CONTROLLER_URI = "/userController";

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
        Assertions.assertNotNull(user.getUser_id());
        Assertions.assertNotNull(user.getUsername());
        Assertions.assertNotNull(user.getPassword());
        Assertions.assertNotNull(user.getFirstName());
        Assertions.assertNotNull(user.getLastName());
        Assertions.assertNotNull(user.getAccess());
        System.err.println(user);
    }

    @Test
    public void testThat_User_CanBeCreated_Viacontroller() throws Exception {

        UserRequest newUser = new UserRequest("JSmith", "password", "John", "Smith", "29-06-1967", "Admin");

        ResultActions result = this.mockMvc.perform(post(USER_CONTROLLER_URI + "/CreateUser")
                .session(session)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isOk());
        String expectedResult = "{\"user_id\":6,\"username\":\"JSmith\",\"password\":\"password\",\"firstName\":\"John\",\"lastName\":\"Smith\",\"access\":\"Admin\",\"pets\":null,\"dob\":\"29-06-1967\"}";

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedResult, result.andReturn().getResponse().getContentAsString());
    }

    @Test
    public void testThat_User_CanBeRetreived_ViaUserId() {
        User userFromDB = generalService.findUserById(2).get();
        Assertions.assertNotNull(userFromDB);
        Assertions.assertEquals(userFromDB.getUsername(), "MSmith1912");
        System.err.println(userFromDB);
    }

    @Test
    public void testThat_User_CanBeRetrieved_Viacontroller() throws Exception {

        ResultActions result = this.mockMvc.perform(get(USER_CONTROLLER_URI + "/GetUserById/" + 1)
                .session(session)
                .contentType("application/json"))
                .andExpect(status().isOk());
        String expectedResult = "{\"user_id\":1,\"username\":\"JSmith\",\"password\":\"password\",\"firstName\":\"John\",\"lastName\":\"Smith\",\"access\":\"Admin\",\"pets\":[],\"dob\":\"29-06-1967\"}";

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedResult, result.andReturn().getResponse().getContentAsString());
    }

    @Test
    public void testThat_User_CanHave_ListOfAnimals() {
        List<Animal> usersPets = generalService.findUserPets(2);
        Assertions.assertEquals(usersPets.size(), 2);
        System.err.println(usersPets);
    }

    @Test
    public void testThat_AllUsers_CanBeRetrieved() {
        List<User> allTrades = generalService.getAllUsers();
        Assertions.assertTrue(allTrades.size() > 0);
        System.err.println(allTrades);
    }

    @Test
    public void testThat_AllUsers_CanBeRetrieved_Viacontroller() throws Exception {

        ResultActions result = this.mockMvc.perform(get(USER_CONTROLLER_URI + "/GetAllUsers")
                .session(session)
                .contentType("application/json"))
                .andExpect(status().isOk());
        Assertions.assertNotNull(result);
    }

    @Test
    public void testThat_User_CanBeDeleted() {
        List<User> allUsersBeforeDeletion = generalService.getAllUsers();
        int sizeBefore = allUsersBeforeDeletion.size();
        System.err.println(sizeBefore);
        generalService.deleteUserById(1);

        List<User> allUsersAfterDeletion = generalService.getAllUsers();
        int sizeAfter = allUsersAfterDeletion.size();
        System.err.println(sizeAfter);

        Assertions.assertNotEquals(sizeBefore, sizeAfter);
    }

    @Test
    public void testThat_User_CanBerDeleted_Viacontroller() throws Exception {

        ResultActions result = this.mockMvc.perform(patch(USER_CONTROLLER_URI + "/DeleteUserById/" + 2)
                .session(session)
                .contentType("application/json"))
                .andExpect(status().isOk());
        Assertions.assertNotNull(result);
    }
}
