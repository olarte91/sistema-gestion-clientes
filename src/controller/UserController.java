package controller;

import model.User;
import model.UserLog;
import service.UserService;
import view.AdminView;
import view.MainView;
import view.StandardView;

public class UserController {

    private UserService userService;
    private AdminView adminView;
    private StandardView standardView;
    private MainView mainView;
    

    public UserController(UserService userService, AdminView adminView,
        StandardView standardView, MainView mainView
    ){
        this.userService = userService;
        this.adminView = adminView;
        this.standardView = standardView;
        this.mainView = mainView;
    }

    public void loginUser() {
        User loginUser = mainView.login();
        User user = userService.loginUser(loginUser);
        if(user != null && user.canCreateUser()){
            adminView.adminMenu();
        }else if(user != null && !user.canCreateUser()){
            standardView.standardMenu();
        }else{
            mainView.nonRegistered();
        }

    }

    public User createUser(User user){
        userService.create(user);

        return user;
    }

    public User[] usersList(){
        return userService.getUsers();
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

    public UserLog[] getUserLogs(){
        return userService.getUserLogs();
    }

    public String currentUserData(){
        return userService.currentUserData();
    }

}
