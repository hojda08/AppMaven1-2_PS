package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Users {
    private String username;
    private String password;

    public Users(@JsonProperty("username") String username,
                 @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
