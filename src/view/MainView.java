package view;

import java.util.Scanner;

import model.User;

public class MainView {

    private Scanner scanner = new Scanner(System.in);


    public User login(){
        System.out.println("SISTEMA DE GESTIÓN DE USUARIOS");
        System.out.println("-Inicio de sesión-");
        System.out.println("Usuario: ");
        String username = scanner.nextLine();
        System.out.println("Contraseña: ");
        String password = scanner.nextLine();

        return new User(username, password);
    }

    public void blockedUserAccount(){
        System.out.println("USUARIO BLOQUEADO, CONSULTE CON EL ADMINISTRADOR!");
        scanner.nextLine();
    }

    public void nonRegistered(){
        System.out.println("No eres usuario registrado");
        scanner.nextLine();
    }

    public void errorScreenView(String error){
        System.out.println("Error: " + error);
        scanner.nextLine();
    }

}
