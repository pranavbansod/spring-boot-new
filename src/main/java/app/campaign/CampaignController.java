package app.campaign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    CampaignService campaignService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Campaign campaign) {
        campaignService.create(campaign);
//        return campaign.toString();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Campaign read(@PathVariable String id) {
        return campaignService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Campaign> all() {
        return campaignService.getAll();
    }

    @RequestMapping(value = "/greet")
    public String greet() {
        return "Hey, there !!";
    }
}