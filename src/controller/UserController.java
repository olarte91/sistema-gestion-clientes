package controller;

import java.util.List;

import model.User;
import service.UserService;

public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    public User createUser(User user){
        userService.create(user);

        return user;
    }

    public List<User> usersList(){
        return userService.getUsers();
    }

}
