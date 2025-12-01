package view;

import java.util.Scanner;

import model.User;

public class MainView {

    private Scanner scanner = new Scanner(System.in);

    // public void usersListView(){
    //     User[] listaUsuarios = userController.usersList();

    //     for(User usuario: listaUsuarios){
    //         System.out.println("Id: " + usuario.getId());
    //         System.out.println("Username: " + usuario.getName());
    //         System.out.println("Nombre: " + usuario.getName());
    //     }
    // }

    public User login(){
        User user = new User();
        System.out.println("SISTEMA DE GESTIÓN DE USUARIOS");
        System.out.println("-Inicio de sesión-");
        System.out.println("Usuario: ");
        String username = scanner.nextLine();
        user.setUserName(username);
        System.out.println("Contraseña: ");
        String password = scanner.nextLine();
        user.setPassword(password);

        return new User(username, password);

    //     if(usuarioLogin != null){
    //         if (!usuarioLogin.canCreateUser() && userController.getErrorCodeAndAttemps()[1] == 0
    //     && !usuarioLogin.isAccountBlocked()) {
    //             userController.addUserLog("usuario " + userController.currentUserName() + " ha iniciado sesión");
    //             standardMenu();
    //         }else if(usuarioLogin.canCreateUser() && userController.getErrorCodeAndAttemps()[1] == 0
    //     && !usuarioLogin.isAccountBlocked()){
    //             userController.addUserLog("usuario " + userController.currentUserName() + " ha iniciado sesión");
    //             adminMenu();
    //         } else if (userController.getErrorCodeAndAttemps()[1] == 1
    //                 && userController.getErrorCodeAndAttemps()[0] <= 3
    //             && !usuarioLogin.isAccountBlocked()) {

    //             errorScreenView("Contraseña incorrecta, vuelva a intentarlo");
    //             System.out.println("Intentos restantes: " + (3 - userController.getErrorCodeAndAttemps()[0]));
    //             login();
    //     } else {
    //         blockedUserAccountView();
    //         login();
    //     }
    //     nonRegistered();
    //     login();
    // }

    }

    // private void usersLogsView() {
    //     System.out.println("-LOGS DE USUARIO-");
    //     for(UserLog log: userController.getUserLogs()){
    //         if(log != null){

    //             System.out.println(log.getTimestamp()+ " " + log.getAction());
    //         }
    //     }

    //     scanner.nextLine();

    //     System.out.println("Presione una tecla para continuar...");

    //     scanner.nextLine();

    //     adminMenu();
    // }

    private void editUserView() {
        System.out.println("-EDITAR DATOS DE USUARIO-");
        System.out.println("Seleccione el campo que desea editar.");
        System.out.println("1. ");
    }

    private void deleteUserView(){

    }

    private void blockedUserAccountView(){
        System.out.println("USUARIO BLOQUEADO, CONSULTE CON EL ADMINISTRADOR!");
    }

    public void nonRegistered(){
        System.out.println("No eres usuario registrado");
    }

    public void createUserView(){
        System.out.println("Crear nuevo usuario");
    }

    public void errorScreenView(String error){
        System.out.println("Error: " + error);
    }

    // public void viewUserData(){
    //     System.out.println("-DATOS DE USUARIO-");
    //     System.out.println(userController.currentUserData());
        
    //     System.out.println("Presione un botón para continuar...");
    //     scanner.nextLine();
    //     scanner.nextLine();
    //     standardMenu();
    // }

    public void changeUserTypeView(){
        System.out.println("-CAMBIAR DE TIPO DE USUARIO-");
    }

}
