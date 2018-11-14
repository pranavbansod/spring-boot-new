package app.model;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;
    private String name;
}