package app.model;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }
}