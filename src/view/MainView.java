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
        System.out.println("SISTEMA DE GESTIÓN DE USUARIOS");
        System.out.println("-Inicio de sesión-");
        System.out.println("Usuario: ");
        String username = scanner.nextLine();
        System.out.println("Contraseña: ");
        String password = scanner.nextLine();

        return new User(username, password);
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

    public void blockedUserAccount(){
        System.out.println("USUARIO BLOQUEADO, CONSULTE CON EL ADMINISTRADOR!");
        scanner.nextLine();
    }

    public void nonRegistered(){
        System.out.println("No eres usuario registrado");
        scanner.nextLine();
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
