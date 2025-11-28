package view;

import java.util.List;
import java.util.Scanner;

import controller.UserController;
import model.User;

public class MainView {

    private UserController userController;
    private Scanner scanner = new Scanner(System.in);

    public MainView(UserController userController){
        this.userController = userController;
    }

    public void usersListView(){
        User[] listaUsuarios = userController.usersList();

        for(User usuario: listaUsuarios){
            System.out.println("Id: " + usuario.getId());
            System.out.println("Username: " + usuario.getName());
            System.out.println("Nombre: " + usuario.getName());
        }
    }

    public void login(){
        User user = new User();
        System.out.println("SISTEMA DE GESTIÓN DE USUARIOS");
        System.out.println("-Inicio de sesión-");
        System.out.println("Usuario: ");
        String username = scanner.nextLine();
        user.setUserName(username);
        System.out.println("Contraseña: ");
        String password = scanner.nextLine();
        user.setPassword(password);

        User usuarioLogin = userController.loginUser(user);

        if(usuarioLogin != null){
            if (!usuarioLogin.canCreateUser() && userController.getErrorCodeAndAttemps()[1] == 0
        && !usuarioLogin.isAccountBlocked()) {
                userController.addUserLog("Usuario: " + userController.currentUserName() + "Ha iniciado sesión");
                standardMenu();
            }else if(usuarioLogin.canCreateUser() && userController.getErrorCodeAndAttemps()[1] == 0
        && !usuarioLogin.isAccountBlocked()){
                userController.addUserLog("Usuario: " + userController.currentUserName() + "Ha iniciado sesión");
                adminMenu();
            } else if (userController.getErrorCodeAndAttemps()[1] == 1
                    && userController.getErrorCodeAndAttemps()[0] <= 3
                && !usuarioLogin.isAccountBlocked()) {

                errorScreenView("Contraseña incorrecta, vuelva a intentarlo");
                System.out.println("Intentos restantes: " + (3 - userController.getErrorCodeAndAttemps()[0]));
                login();
        } else {
            blockedUserAccountView();
            login();
        }
        nonRegistered();
        login();
    }

    }

    public void adminMenu(){

        int option = 0;
        System.out.println("-MENÚ ADMINISTRADOR-");
        System.out.println("1. Crear usuario.");
        System.out.println("2. Editar usuario.");
        System.out.println("3. Eliminar usuario.");
        System.out.println("4. Mostrar lista de usuarios.");
        System.out.println("5. Mostrar logs de usuarios.");
        System.out.println("6. Salir.");

        System.out.println("Elija una opción: ");
        option = scanner.nextInt();

        switch (option) {
            case 1:
                createUserView();
                break;
            case 2:
                editUserView();
                break;
            case 3: 
                deleteUserView();
                break;
            case 4:
                usersListView();
                break;
            case 5:
                usersLogsView();
                break;
            case 6:
                break;
            default:
                errorScreenView("Opción inválida!");
                adminMenu();
                break;
        }
    }

    private void usersLogsView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usersLogsView'");
    }

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

    public void standardMenu(){

        int option = 0;

        System.out.println("-MENÚ USUARIO STANDAR-");
        System.out.println("1. Ver datos de usuario.");
        System.out.println("2. Editar usuario.");
        System.out.println("3. Salir.");

        System.out.println("Seleccione una opción: ");
        option = scanner.nextInt();

        switch (option) {
            case 1:
                viewUserData();
                break;
            case 2:
                editUserView();
                break;
            case 3:
                userController.addUserLog("El usuario" + userController.currentUserName() + "Ha cerrado sesión");
                userController.logoutUser();
                login();
            default:
                errorScreenView("Opción inválida!");
                standardMenu();
                break;
        }
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

    public void viewUserData(){
        System.out.println("-DATOS DE USUARIO-");
        System.out.println(userController.currentUserData());
        
        System.out.println("Presione un botón para continuar...");
        scanner.nextLine();
        scanner.nextLine();
        standardMenu();
    }

}
