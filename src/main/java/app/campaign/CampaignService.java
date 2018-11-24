package app.campaign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    @Autowired
    CampaignRepository campaignRepository;

    public void create(Campaign campaign) {
        campaignRepository.save(campaign);
    }

    public Campaign getById(String id) {
        return campaignRepository.findOneById(id);
    }

    public List<Campaign> getAll() {
        return campaignRepository.findAll();
    }
}
