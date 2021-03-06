package app.campaign;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(JUnit4.class)
@AutoConfigureMockMvc
public class CampaignControllerTest {

    private MockMvc mvc;

    @Mock
    private CampaignService campaignService;

    @InjectMocks
    private CampaignController campaignController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mvc = MockMvcBuilders.standaloneSetup(campaignController).build();
    }

    @Test
    public void getGreet() throws Exception {
        RequestBuilder getGreetRequest = MockMvcRequestBuilders.get("/campaign/greet");

        mvc.perform(getGreetRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hey, there !!")));
    }

    @Test
    public void postCampaign() throws Exception {
        String campaign = "{\"id\":\"01\",\"name\":\"Pranav\"}";

        RequestBuilder postCampaignRequest = MockMvcRequestBuilders.post("/campaign").contentType(MediaType.APPLICATION_JSON).content(campaign);
        mvc.perform(postCampaignRequest)
                .andExpect(status().isOk());

        verify(campaignService,times(1)).create(Mockito.any(Campaign.class));
    }

    @Test
    public void getCampaign() throws Exception {
        RequestBuilder getCampaign = MockMvcRequestBuilders.get("/campaign/01").accept(MediaType.APPLICATION_JSON);
        mvc.perform(getCampaign);

        verify(campaignService, times(1)).getById("01");
    }

    @Test
    public void getAll() throws Exception {
        RequestBuilder getCampaign = MockMvcRequestBuilders.get("/campaign/all").accept(MediaType.APPLICATION_JSON);
        mvc.perform(getCampaign);

        verify(campaignService, times(1)).getAll();
    }
}
