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

    public void login(){
        User user = new User();
        System.out.println("Usuario: ");
        String username = scanner.nextLine();
        user.setUserName(username);
        System.out.println("Contraseña: ");
        String password = scanner.nextLine();
        user.setPassword(password);

        User usuarioLogin = userController.loginUser(user);

        if(usuarioLogin != null){
            if (!usuarioLogin.canCreateUser()) {
                standardMenu();
            }else{
                adminMenu();
            }
        }else{
            nonRegistered();
        }

    }

    public void adminMenu(){
        System.out.println("-MENÚ ADMINISTRADOR-");
        System.out.println("1. Crear usuario.");
        System.out.println("2. Editar usuario.");
        System.out.println("3. Eliminar usuario.");
        System.out.println("4. Mostrar lista de usuarios.");
    }

    public void standardMenu(){
        System.out.println("-MENÚ USUARIO STANDAR-");
    }

    public void nonRegistered(){
        System.out.println("No eres usuario registrado");
    }

}
