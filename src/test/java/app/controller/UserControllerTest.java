package app.controller;

import app.model.User;
import app.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    private MockMvc mvc;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void getGreet() throws Exception {
        RequestBuilder getGreetRequest = MockMvcRequestBuilders.get("/user/greet");

        mvc.perform(getGreetRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hey, there !!")));
    }

    @Test
    public void postUser() throws Exception {
        String userData = "{\"id\":\"01\",\"name\":\"Pranav\"}";

        RequestBuilder postUserRequest = MockMvcRequestBuilders.post("/user").content(userData);
        mvc.perform(postUserRequest).andReturn();


//        verify(userRepository,times(1)).save(Mockito.any(User.class));
    }

    @Test
    public void getUser() throws Exception {
        RequestBuilder getUser = MockMvcRequestBuilders.get("/user/01").accept(MediaType.APPLICATION_JSON);
        mvc.perform(getUser);

        verify(userRepository,times(1)).findOneById("01");
    }

    @Test
    public void getAll() throws Exception {
        RequestBuilder getUser = MockMvcRequestBuilders.get("/user/all").accept(MediaType.APPLICATION_JSON);
        mvc.perform(getUser);

        verify(userRepository,times(1)).findAll();
    }
}
