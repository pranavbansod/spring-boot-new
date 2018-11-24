package app.campaign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    CampaignRepository campaignRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Campaign campaign) {
        campaignRepository.save(campaign);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Campaign read(@PathVariable String id) {
        return campaignRepository.findOneById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List <Campaign> all(){
        return campaignRepository.findAll();
    }

    @RequestMapping(value = "/greet")
    public String greet() {
        return "Hey, there !!";
    }
}