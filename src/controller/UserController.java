package controller;

import service.UserService;
import view.MainView;

public class UserController {

    public MainView mainView;
    public UserService userService;

    public UserController(MainView mainView, UserService userService){

        this.mainView = mainView;
        this.userService = userService;
    }

    public void start() {
        boolean exit = false;

        while(!exit){

            this.mainView.login();

            String option = this.mainView.getUserInput();

            if(option.equals(option)){

                String[] loginData = this.mainView.getLoginUserData();
                boolean loginUser = this.userService.loginUser(loginData);

                if(!loginUser){
                    this.mainView.errorLogin();
                }else{

                    switch (option) {
                        case "1":
                            String[] userData = this.mainView.getNewUserData();
                            this.userService.createNewUser(userData);
                            this.mainView.showUsers(userService.showUsers());
                            break;

                        default:
                            break;
                    }
                }

                
            }else{
                String[] userData = this.mainView.getNewUserData();
                this.userService.createNewUser(userData);
            }

            

            
        }
    }

}
