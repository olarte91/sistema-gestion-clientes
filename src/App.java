import controller.UserController;
import service.UserService;
import view.MainView;

public class App {
    public static void main(String[] args) throws Exception {

        MainView mainView = new MainView();
        UserService userService = new UserService();
        UserController userController = new UserController(mainView, userService);

        userController.start();
    }
}
