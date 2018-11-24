package app.campaign;

import app.campaign.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CampaignRepository extends MongoRepository<Campaign,String> {
    Campaign findOneById(String id);
}
