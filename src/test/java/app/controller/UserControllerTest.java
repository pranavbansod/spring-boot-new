package app.controller;

import app.model.User;
import app.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    @MockBean
    UserRepository userRepository;

    @Test
    public void getGreet() throws Exception {
        RequestBuilder getGreetRequest = MockMvcRequestBuilders.get("/user/greet");

        mvc.perform(getGreetRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hey, there !!")));
    }


//    @Test
//    public void getUser() throws Exception {
//        RequestBuilder getUserRequest = MockMvcRequestBuilders.get("/user/01").accept(MediaType.APPLICATION_JSON);
//
//
//        User mockedUser = new User();
//
//        when(userRepository.findOneById("01")).thenReturn(mockedUser);
//
//        mvc.perform(getUserRequest).andReturn();
//
//        verify(userRepository).findOneById("01");
//    }
}
