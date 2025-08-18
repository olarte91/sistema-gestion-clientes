package controller;

import java.util.List;

import model.User;
import model.UserLog;
import service.UserService;

public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    public User login(User user){
        return userService.login(user);
    }

    public List<UserLog> getUserLogs(User user){
        return userService.getUserLogs(user);
    }
}
