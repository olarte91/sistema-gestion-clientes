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
            StandardView standardView, MainView mainView) {
        this.userService = userService;
        this.adminView = adminView;
        this.standardView = standardView;
        this.mainView = mainView;
    }

    public void loginUser() {
        boolean logout = false;
        while (true) {
            User user = userService.loginUser(mainView.login());

            if (userService.errorCode == 1) {
                if (userService.errorAttemp < 3) {
                    mainView.errorScreenView(
                            "Contraseña errónea, le quedan " + (3 - userService.errorAttemp) + " intentos");
                    continue;
                } else {
                    mainView.blockedUserAccount();
                    continue;
                }
            }

            if (user != null && user.isAccountBlocked()) {
                mainView.blockedUserAccount();
                continue;
            }

            if (user != null && user.canCreateUser) {
                logout = false;
                while (!logout) {
                   int option = adminView.adminMenu();

                    switch (option) {
                        case 1:
                            createUser();
                            break;
                        case 2:
                            updateUser();
                            break;
                        case 3:
                            delteUser();
                            break;
                        case 4:
                            changeUserRole();
                            break;
                        case 6:
                            usersList();
                            break;
                        case 7:
                            getUserLogs();
                            break;
                        case 8:
                            logout = true;
                            adminView.showMessage("Cerrando sesión");                
                    }
                }
            } else if (user != null && !user.canCreateUser) {
                standardView.standardMenu();
            }

            if (user == null) {
                mainView.nonRegistered();
                continue;
            }
        }
    }

    public void updateUser() {
        int userId = adminView.requestUserId();
        User user = userService.findById(userId);

        if(user == null){
            adminView.showMessage("Usuario no encontrado");
            return;
        }

        boolean option = false;

        while (!option) {
            int menuOption = adminView.updateMenu();

            switch(menuOption){
                case 1:
                    user.setName(adminView.updateUsername());
                    adminView.showMessage("Nombre actualizado con éxito!");
                    option = true;
                    break;
                case 2:
                    user.setPassword(adminView.updatePassword());
                    adminView.showMessage("Contraseña actualizada con éxito!");
                    option = true;
                    break;
                default:
                    adminView.showMessage("Opción inválida");
            }
        }

        userService.update(user);


    }

    public void changeUserRole(){
        Integer id = adminView.requestUserId();



        if(!userService.changeUserRole(id)){
            adminView.showMessage("Usuario no encontrado!");
        }else{
            adminView.showMessage("Cambio de rol exitoso");
        }


    }

    public void delteUser(){
        Integer id = adminView.requestUserId();

        if(userService.delete(id)){
            adminView.showMessage("Usuario Eliminado exitosamente");
        }else{
            adminView.showMessage("Usurio no encontrado");
        }
        
    }


    public void createUser() {
        userService.create(adminView.createUser());
    }

    public void usersList() {
        adminView.usersList(userService.getUsers());
    }

    public void logoutUser() {
        userService.logoutUser();
    }

    public void addUserLog(String message) {
        userService.addUserLog(message);
    }

    public void getUserLogs() {
        
        Integer userId = adminView.requestUserId();

        if(userService.findById(userId) != null){
            adminView.showUserLogs(userService.findById(userId));
        }else{
            adminView.showMessage("Usuario no encontrado!");
        }
    }

    public String currentUserData() {
        return userService.currentUserData();
    }

}
