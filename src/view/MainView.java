package view;

import java.util.List;
import java.util.Scanner;

import model.User;

public class MainView {

    private Scanner scanner;

    public MainView (){
        this.scanner = new Scanner(System.in);
    }

    public void login(){
        System.out.println("== SISTEMA DE REGISTRO DE USUARIOS ==");
        System.out.println("1. Ingresar");
        System.out.println("2. Registrar nuevo usuario");
    }
    public void adminMainMenu(){
        System.out.println("<=== Bienvenido al sistema de registro de usuarios ===>");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Registrar nuevo usuario.");
        System.out.println("2. Mostrar lista de usuarios registrados.");
        System.out.println("3. Buscar un usuario específico.");
        System.out.println("4. Actualizar la información de un usuario.");
        System.out.println("5. Eliminar un usuario.");
        System.out.println("6. Salir.");

    }

    public String[] getNewUserData(){
        System.out.println("<=== Registrar nuevo usuario ===>");

        System.out.println("Ingrese el nombre completo del usuario: ");
        String fullName = scanner.nextLine();

        System.out.println("Ingrese el nombre de usuario: ");
        String userName = scanner.nextLine();

        System.out.println("Ingrese la contraseña del usuario: ");
        String password = scanner.nextLine();

        System.out.println("Ingrese el rol del usuario (ADMIN o STANDARD): ");
        String role = scanner.nextLine();

        return new String[] {fullName, userName, password, role};

    }

    public String[] getLoginUserData(){
        System.out.println("Ingrese el nombre de usuario: ");
        String userName = scanner.nextLine();

        System.out.println("Ingrese la contraseña:");
        String password = scanner.nextLine();

        return new String[] {userName, password};

    }

    public void showUsers(List<User> users){
        System.out.println("Lista de usuarios");

        for(User user : users){
            System.out.println(user.toString());
        }

    }

    public String getUserInput(){
        return scanner.nextLine();
    }

    public void errorLogin(){
        System.out.println("Error de login");
    }
}
