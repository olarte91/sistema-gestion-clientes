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

        User loggedUser = userController.login(user);

        if(loggedUser != null){
            System.out.println("Bienvenido! " + user.getUserName());
        }else{
            System.out.println("El usuario " + user.getUserName() + " no está registrado en el sistema");
            login();
        }
    }

    public void showUserLogs(User user){

        System.out.println("Usuario: " + user.getUserName() + "\n");

        for(UserLog log: user.getUserLogs()){
            System.out.println("Acción: " + log.getAction() + "\n" + "Timestamp: " + log.getTimestamp());
        }
    }
}
