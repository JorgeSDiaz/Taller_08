package org.myorg.service;

import org.myorg.model.User;
import org.myorg.persistence.UserServiceException;
import org.myorg.response.UserResponse;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserService {
    private final Set<User> users;

    public UserService() {
        users = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
        users.add(new User("jorge", "12345"));
        users.add(new User("juca", "54321"));
    }

    public Set<UserResponse> list() {
        return users.stream().map(UserResponse::new).collect(Collectors.toSet());
    }

    public Set<UserResponse> add(User newUser) {
        users.add(newUser);
        return list();
    }

    public UserResponse check(User user) throws UserServiceException {
        User userRegistered = null;
        for (User us: users) {
            if (us.getUsername().equals(user.getUsername()) && us.getPassword().equals(user.getPassword())) {
                userRegistered = us;
                break;
            }
        }

        if (userRegistered == null) {
            throw new UserServiceException(UserServiceException.WRONG_CREDENTIALS);
        }

        return new UserResponse(userRegistered);
    }

}
