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

    public User[] usersList(){
        return userService.getUsers();
    }

    public User loginUser(User user){
        return userService.loginUser(user);
    }

    public void logoutUser(){
        userService.logoutUser();
    }

    public int[] getErrorCodeAndAttemps(){
        int[] codeAttpems = new int[2];
        codeAttpems[0] = userService.errorAttemp;
        codeAttpems[1] = userService.errorCode;
        return codeAttpems;
    }

    public void addUserLog(String message){
        userService.addUserLog(message);
    }

    public String currentUserName(){
        return userService.currentUser().getUserName();
    }

    public String currentUserData(){
        return userService.currentUserData();
    }

}
