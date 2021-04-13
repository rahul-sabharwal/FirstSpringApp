package com.spring.course.FirstSpringApplication;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id = '" + id + '\'' +
                ", username = '" + username + '\'' +
                '}';
    }
}
