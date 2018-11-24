package app.campaign;

import org.springframework.data.annotation.Id;

public class Campaign {
    @Id
    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public Campaign setName(String name) {
        this.name = name;
        return this;
    }

    public String getId() {
        return id;
    }

    public Campaign setId(String id) {
        this.id = id;
        return this;
    }
}