package app.campaign;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
public class CampaignServiceTest {

    @Mock
    CampaignRepository campaignRepository;

    @InjectMocks
    CampaignService campaignService;

    @Test
    public void create() {
        campaignService.create(Mockito.any(Campaign.class));

        verify(campaignRepository, times(1)).save(Mockito.any(Campaign.class));
    }

    @Test
    public void getById() {
        campaignService.getById("1");

        verify(campaignRepository,times(1)).findOneById("1");
    }

    @Test
    public void getAll() {
        campaignService.getAll();

        verify(campaignRepository,times(1)).findAll();
    }
}
