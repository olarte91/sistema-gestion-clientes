package controller;

import java.util.List;

import model.AdminUser;
import model.StandardUser;
import model.User;
import model.UserLog;
import service.UserService;

public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    public void createUser(User user){
        userService.createUser(user);
    }

    public String login(User user){
        User loggedUser = userService.login(user);

        if(loggedUser instanceof AdminUser){
            return "admin";
        }else if(loggedUser instanceof StandardUser){
            return "standard";
        }else{
            return "fail";
        }
    }

    public List<UserLog> getUserLogs(User user){
        return userService.getUserLogs(user);
    }
}
