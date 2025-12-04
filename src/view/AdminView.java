package view;

import java.util.Scanner;

public class AdminView {

    Scanner scanner = new Scanner(System.in);

    public void adminMenu() {
        int option = 0;
        System.out.println("-MENÚ ADMINISTRADOR-");
        System.out.println("1. Crear usuario.");
        System.out.println("2. Editar usuario.");
        System.out.println("3. Eliminar usuario.");
        System.out.println("4. Cambiar tipo de usuario.");
        System.out.println("5. Mostrar lista de usuarios.");
        System.out.println("6. Mostrar logs de usuarios.");
        System.out.println("7. Salir.");

        System.out.println("Elija una opción: ");
        option = scanner.nextInt();

        switch (option) {
            case 1:
                createUser();
                break;
            case 2:
                editUser();
                break;
            case 3:
                deleteUser();
                break;
            case 4:
                changeUserType();
                break;
            case 5:
                usersList();
                break;
            case 6:
                usersList();
                break;
            case 7:
                break;
            default:
                error("Opción inválida!");
                adminMenu();
                break;
        }
    }

    private void error(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'error'");
    }

    private void usersList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'usersList'");
    }

    private void changeUserType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeUserType'");
    }

    private void deleteUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    private void editUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editUser'");
    }

    private void createUser() {
        System.out.println("-CREAR USUARIO-");
    }

 

}
