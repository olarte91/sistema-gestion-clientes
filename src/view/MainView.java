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

    public void createUser(){
        User user = new User();
        System.out.println("Ingrese el nombre del username: ");
        user.setUserName(scanner.nextLine());

        System.out.println("Ingrese el nombre completo del usuario: ");
        user.setName(scanner.nextLine());

        System.out.println("Ingrese la contraseña de usuario: ");
        user.setPassword(scanner.nextLine());

        userController.createUser(user);
    }

    public void usersList(){
        List<User> listaUsuarios = userController.usersList();

        for(User usuario: listaUsuarios){
            System.out.println("Id: " + usuario.getId());
            System.out.println("Username: " + usuario.getName());
            System.out.println("Nombre: " + usuario.getName());
        }
    }

}
