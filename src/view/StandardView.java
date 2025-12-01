package view;

import java.util.Scanner;

public class StandardView {

    Scanner scanner = new Scanner(System.in);

    public void standardMenu() {
        int option = 0;

        System.out.println("-MENÚ USUARIO STANDARD-");
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
        editUser();
        break;
        case 3:
            logoutUser();
        default:
        error("Opción inválida!");
        standardMenu();
        break;
        }
    }

    private void logoutUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logoutUser'");
    }

    private void error(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'error'");
    }

    private void editUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editUser'");
    }

    private void viewUserData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewUserData'");
    }

}
