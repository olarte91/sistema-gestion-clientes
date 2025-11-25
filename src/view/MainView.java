package view;

import java.util.Scanner;

import controller.UserController;
import model.User;
import model.UserLog;

public class MainView {

    private UserController userController;
    private Scanner scanner = new Scanner(System.in);

    public MainView(UserController userController){
        this.userController = userController;
    }

    public void login(){
        System.out.println("Ingrese el nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.println("Ingrese la constraseña: ");
        String password = scanner.nextLine();

        User user = new User(username, password);

        String userType = userController.login(user);

        if(userType == "admin"){
            System.out.println("Bienvenido, Administrador");
            adminView();
        }else if (userType == "standard"){
            System.out.println("Bienvenido Usuario");
            standardView();
        }else{
            System.out.println("Nombre de usuario o contraseña incorrectos.");
            login();
        }
    }

    private void standardView() {
        System.out.println("Bienvenido usuario");
    }

    public void showUserLogs(User user){

        System.out.println("Usuario: " + user.getUserName() + "\n");

        for(UserLog log: user.getUserLogs()){
            System.out.println("Acción: " + log.getAction() + "\n" + "Timestamp: " + log.getTimestamp());
        }
    }

    public Integer adminView(){

        System.out.println("Panel principal usuario *Administrador*");
        System.out.println("1.Crear usuario nuevo");
        System.out.println("2.Actualizar usuario existente");
        System.out.println("3.Eliminar usuario");
        System.out.println("4.Mostrar lista de usuarios");
        System.out.println("5.Cerrar sesión");

        Integer userOption = scanner.nextInt();

        return userOption;
    }
}
