package org.myorg.response;

import org.myorg.model.User;

public class UserResponse {
    String username;

    public UserResponse() {
    }

    public UserResponse(User user) {
        this.username = user.getUsername();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
