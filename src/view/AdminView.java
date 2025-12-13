package view;

import java.util.Scanner;

import model.User;
import util.UserType;

public class AdminView {

    Scanner scanner = new Scanner(System.in);

    public int adminMenu() {
        System.out.println("-MENÚ ADMINISTRADOR-");
        System.out.println("1. Crear usuario.");
        System.out.println("2. Editar usuario.");
        System.out.println("3. Eliminar usuario.");
        System.out.println("4. Cambiar tipo de usuario.");
        System.out.println("5. Mostrar lista de usuarios.");
        System.out.println("6. Mostrar logs de usuarios.");
        System.out.println("7. Salir.");

        System.out.println("Elija una opción: ");
        return scanner.nextInt();
    }

    public void error(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'error'");
    }

    public void usersList(User[] users) {

        for (User user : users) {
            if (user != null) {
                System.out.println("+-----------------------------+");
                System.out.println("ID: " + user.getId());
                System.out.println("Username: " + user.getUserName());
                System.out.println("Nombre: " + user.getName());
                System.out.println("Tipo de usuario: " + user.getUserType());
                System.out.println("+-----------------------------+");
            }
        }
        scanner.nextLine();
        scanner.nextLine();
    }

    public void changeUserType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeUserType'");
    }

    public void deleteUser() {
        System.out.println("Eliminar usuario");
    }

    public int requestUserId() {
        System.out.println("Ingrese el id del usuario: ");
        return scanner.nextInt();
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

    public User createUser() {
        System.out.println("-CREAR USUARIO-");
        scanner.nextLine();
        System.out.println("Ingrese el nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.println("Ingrese el nombre completo del usuario: ");
        String fullName = scanner.nextLine();
        System.out.println("Ingrese la contraseña: ");
        String password = scanner.nextLine();

        return new User(username, fullName, password, UserType.STANDARD);
    }

    public void showMessage(String message) {
        System.out.println(message);
        scanner.nextLine();
        scanner.nextLine();
    }

}
