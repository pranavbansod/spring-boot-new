package app.controller;

import app.model.User;
import app.repository.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody User user) {
        userRepository.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User read(@PathVariable String id) {
        return userRepository.findOneById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List <User> all(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/greet")
    public String greet() {
        return "Hey, there !!";
    }
}