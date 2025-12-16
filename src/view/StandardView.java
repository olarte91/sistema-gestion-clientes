package view;

import java.util.Scanner;

import model.User;

public class StandardView {

    Scanner scanner = new Scanner(System.in);

    public int standardMenu() {

        System.out.println("-MENÚ USUARIO STANDARD-");
        System.out.println("1. Ver datos de usuario.");
        System.out.println("2. Editar usuario.");
        System.out.println("3. Salir.");

        System.out.println("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public void userData(User user) {
        System.out.println("+-----------------------------+");
        System.out.println("ID: " + user.getId());
        System.out.println("Username: " + user.getUserName());
        System.out.println("Nombre: " + user.getName());
        System.out.println("Tipo de usuario: " + user.getUserType());
        System.out.println("Usuario bloqueado: " + (user.isAccountBlocked() ? "si" : "no"));
        System.out.println("+-----------------------------+");
        scanner.nextLine();
        scanner.nextLine();
    }

    public int updateMenu() {
        System.out.println("-ACTUALIZAR DATOS DE USUARIO-");
        System.out.println("Seleccione el apartado a actualizar: ");
        System.out.println("1. Nombre del usuario.");
        System.out.println("2. Contraseña. ");

        return scanner.nextInt();
    }

    public String updateUsername() {
        scanner.nextLine();
        System.out.println("Ingrese el nuevo username: ");
        return scanner.nextLine();
    }

    public String updatePassword() {
        scanner.nextLine();
        System.out.println("Ingrese la nueva contraseña");
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
        scanner.nextLine();
    }

}
